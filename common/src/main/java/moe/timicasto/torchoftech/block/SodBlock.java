package moe.timicasto.torchoftech.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SodBlock extends Block {
	public static final VoxelShape shape = Block.box(0, 0, 0, 16, 1, 16);

	public SodBlock() {
		super(Properties.of(Material.DIRT).strength(0.5F));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return shape;
	}
}
