package moe.timicasto.torchoftech.block;

import moe.timicasto.torchoftech.TorchOfTech;
import moe.timicasto.torchoftech.TorchOfTechItems;
import net.minecraft.nbt.DoubleTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.List;

public class MalachiteBlock extends Block {

	public MalachiteBlock() {
		super(Properties.of(Material.STONE).strength(3.5F).requiresCorrectToolForDrops());
	}

	@Override
	public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
		ItemStack malachiteFragment = new ItemStack(TorchOfTechItems.MALACHITE_FRAGMENT.get(), 1);
		double copper = TorchOfTech.RANDOM.nextDouble(22.8) + 15.2;
		malachiteFragment.addTagElement("mass", DoubleTag.valueOf(copper));
		return List.of(malachiteFragment);
	}
}
