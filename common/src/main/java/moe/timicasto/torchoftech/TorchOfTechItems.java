package moe.timicasto.torchoftech;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import moe.timicasto.torchoftech.item.*;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public final class TorchOfTechItems {
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(TorchOfTech.MOD_ID, Registry.ITEM_REGISTRY);
	public static final RegistrySupplier<Item> AZURITE_FRAGMENT = ITEMS.register("azurite_fragment", AzuriteFragmentItem::new);
	public static final RegistrySupplier<Item> AZURITE = ITEMS.register("azurite", () -> new BlockItem(TorchOfTechBlocks.AZURITE.get(), new Item.Properties().tab(TorchOfTechTabs.BLOCK)));
	public static final RegistrySupplier<Item> MALACHITE_FRAGMENT = ITEMS.register("malachite_fragment", MalachiteFragmentItem::new);
	public static final RegistrySupplier<Item> MALACHITE = ITEMS.register("malachite", () -> new BlockItem(TorchOfTechBlocks.MALACHITE.get(), new Item.Properties().tab(TorchOfTechTabs.BLOCK)));
	public static final RegistrySupplier<Item> CHALCOCITE_FRAGMENT = ITEMS.register("chalcocite_fragment", ChalcociteFragmentItem::new);
	public static final RegistrySupplier<Item> CHALCOCITE = ITEMS.register("chalcocite", () -> new BlockItem(TorchOfTechBlocks.CHALCOCITE.get(), new Item.Properties().tab(TorchOfTechTabs.BLOCK)));
	public static final RegistrySupplier<Item> CHARCOAL_CAMPFIRE = ITEMS.register("charcoal_campfire", () -> new BlockItem(TorchOfTechBlocks.CHARCOAL_CAMPFIRE.get(), new Item.Properties().tab(TorchOfTechTabs.BLOCK)));
	public static final RegistrySupplier<Item> SOD = ITEMS.register("sod", () -> new BlockItem(TorchOfTechBlocks.SOD.get(), new Item.Properties().tab(TorchOfTechTabs.BLOCK)));
	public static final RegistrySupplier<Item> ASH = ITEMS.register("ash", AshItem::new);
	public static final RegistrySupplier<Item> COPPER_NUGGET = ITEMS.register("copper_nugger", CopperNuggetItem::new);
	public static void registerItems() {
		ITEMS.register();
	}
}
