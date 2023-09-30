package moe.timicasto.torchoftech.block;

import moe.timicasto.torchoftech.TorchOfTechBlockEntities;
import moe.timicasto.torchoftech.blockentity.CharcoalCampfireBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class CharcoalCampfireBlock extends BaseEntityBlock {
	public static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
	public static BooleanProperty LIT = BooleanProperty.create("lit");

	public CharcoalCampfireBlock() {
		super(Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD).lightLevel((state) -> state.getValue(LIT) ? 15 : 0).noOcclusion());
		this.registerDefaultState(this.getStateDefinition().any().setValue(LIT, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(LIT);
		super.createBlockStateDefinition(builder);
	}


	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CharcoalCampfireBlockEntity(pos, state);
	}

	@Override
	public @NotNull RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}

	@Override
	public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, TorchOfTechBlockEntities.CHARCOAL_CAMPFIRE_TE.get(), CharcoalCampfireBlockEntity::tick);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!level.isClientSide()) {
			if (hand == InteractionHand.MAIN_HAND) {
				CharcoalCampfireBlockEntity be = (CharcoalCampfireBlockEntity) level.getBlockEntity(pos);
				if (player.getItemInHand(hand).is(Items.CHARCOAL)) {
					player.getItemInHand(hand).shrink(1);
					be.insertCharcoal();
					return InteractionResult.SUCCESS;
				} /*else if (player.getItemInHand(hand).is()) {

				}*/ else if (player.getItemInHand(hand).isEmpty()) {
					be.lit();
				} else {
					be.insertOre(player.getItemInHand(hand));
					return InteractionResult.SUCCESS;
				}
			}
		}

		return InteractionResult.PASS;
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity entity, ItemStack tool) {
		super.playerDestroy(level, player, pos, state, entity, tool);
		CharcoalCampfireBlockEntity be = (CharcoalCampfireBlockEntity) entity;
		if (be.isLit()) {
			player.hurt(DamageSource.IN_FIRE, 8.0F);
		}
		ItemStack drop = be.getDrop();
		level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), drop));
	}

}
