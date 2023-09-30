package moe.timicasto.torchoftech;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import moe.timicasto.torchoftech.entity.AshEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class TorchOfTechEntities {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(TorchOfTech.MOD_ID, Registry.ENTITY_TYPE_REGISTRY);

	public static final RegistrySupplier<EntityType<AshEntity>> ASH_ENTITY = ENTITIES.register("ash_entity", () -> EntityType.Builder.<AshEntity>of(AshEntity::new, MobCategory.MISC).build("ash_entity"));

	public static void registerEntities() {
		ENTITIES.register();
	}


}
