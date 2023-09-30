package moe.timicasto.torchoftech.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.architectury.registry.registries.RegistrySupplier;
import moe.timicasto.torchoftech.TorchOfTech;
import moe.timicasto.torchoftech.TorchOfTechItems;
import moe.timicasto.torchoftech.item.AshItem;
import moe.timicasto.torchoftech.levelgen.Generations;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;

@Mod(TorchOfTech.MOD_ID)
public class TorchOfTechForge {
    public TorchOfTechForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(TorchOfTech.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.addListener(TorchOfTechForge::biomeLoading);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(TorchOfTechForge::setup);
        TorchOfTech.init();
    }

    @SubscribeEvent
    public static void setup(FMLCommonSetupEvent evt) {
        evt.enqueueWork(Generations::registerFeatures);
        LogManager.getLogger().info("OreGenFeatures registered");
    }

    public static void biomeLoading(BiomeLoadingEvent evt) {
        evt.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Generations.AZURITE_ORE);
        evt.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Generations.CHALCOCITE_ORE);
        evt.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Generations.MALACHITE_ORE);
    }
}