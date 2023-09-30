package moe.timicasto.torchoftech;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import moe.timicasto.torchoftech.blockentity.CharcoalCampfireBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntityType;

public final class TorchOfTechBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(TorchOfTech.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
	public static final RegistrySupplier<BlockEntityType<CharcoalCampfireBlockEntity>> CHARCOAL_CAMPFIRE_TE = BLOCK_ENTITIES.register("charcoal_campfire_te", () -> BlockEntityType.Builder.of(CharcoalCampfireBlockEntity::new, TorchOfTechBlocks.CHARCOAL_CAMPFIRE.get()).build(null));

	public static void registerBlockEntities() {
		BLOCK_ENTITIES.register();
	}
}
