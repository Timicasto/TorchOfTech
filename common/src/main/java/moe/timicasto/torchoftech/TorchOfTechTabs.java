package moe.timicasto.torchoftech;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public interface TorchOfTechTabs {
	CreativeModeTab BLOCK = CreativeTabRegistry.create(new ResourceLocation(TorchOfTech.MOD_ID, "tot_blocks"), () -> new ItemStack(TorchOfTechItems.AZURITE.get()));
	CreativeModeTab MISC = CreativeTabRegistry.create(new ResourceLocation(TorchOfTech.MOD_ID, "tot_misc"), () -> new ItemStack(TorchOfTechItems.AZURITE_FRAGMENT.get()));
}
