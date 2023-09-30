package moe.timicasto.torchoftech;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import moe.timicasto.torchoftech.block.*;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

public final class TorchOfTechBlocks {
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(TorchOfTech.MOD_ID, Registry.BLOCK_REGISTRY);

	public static final RegistrySupplier<Block> AZURITE = BLOCKS.register("azurite", AzuriteBlock::new);
	public static final RegistrySupplier<Block> MALACHITE = BLOCKS.register("malachite", MalachiteBlock::new);
	public static final RegistrySupplier<Block> CHALCOCITE = BLOCKS.register("chalcocite", ChalcociteBlock::new);
	public static final RegistrySupplier<Block> CHARCOAL_CAMPFIRE = BLOCKS.register("charcoal_campfire", CharcoalCampfireBlock::new);
	public static final RegistrySupplier<Block> SOD = BLOCKS.register("sod", SodBlock::new);
	public static void registerBlocks() {
		BLOCKS.register();
	}
}
