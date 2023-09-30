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

public class ChalcociteBlock extends Block {
	public ChalcociteBlock() {
		super(Properties.of(Material.STONE).strength(2.5F));
	}

	@Override
	public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
		ItemStack chalcociteFragment = new ItemStack(TorchOfTechItems.CHALCOCITE_FRAGMENT.get(), 1);
		double copper = TorchOfTech.RANDOM.nextDouble(114) + 57;
		chalcociteFragment.addTagElement("mass", DoubleTag.valueOf(copper));
		return List.of(chalcociteFragment);
	}
}
