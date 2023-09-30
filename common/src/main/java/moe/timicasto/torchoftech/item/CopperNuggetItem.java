package moe.timicasto.torchoftech.item;

import moe.timicasto.torchoftech.TorchOfTechTabs;
import net.minecraft.world.item.Item;

public class CopperNuggetItem extends Item {
	public CopperNuggetItem() {
		super(new Properties().tab(TorchOfTechTabs.MISC).stacksTo(64));
	}
}
