package moe.timicasto.torchoftech.block;

import moe.timicasto.torchoftech.TorchOfTech;
import moe.timicasto.torchoftech.TorchOfTechItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.nbt.ByteArrayTag;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AzuriteBlock extends Block {
	public AzuriteBlock() {
		super(Properties.of(Material.STONE).strength(3.5F));
	}

	@Override
	public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
		ItemStack azuriteFragment = new ItemStack(TorchOfTechItems.AZURITE_FRAGMENT.get(), 1);
		double copper = TorchOfTech.RANDOM.nextDouble(22.68) + 15.12;
		azuriteFragment.addTagElement("mass", DoubleTag.valueOf(copper));
		return List.of(azuriteFragment);
	}
}
