package moe.timicasto.torchoftech.fabric;

import moe.timicasto.torchoftech.TorchOfTech;
import moe.timicasto.torchoftech.TorchOfTechTabs;
import moe.timicasto.torchoftech.levelgen.Generations;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;

public class TorchOfTechFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TorchOfTech.init();
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, Generations.AZURITE_ORE.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, Generations.CHALCOCITE_ORE.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, Generations.MALACHITE_ORE.unwrapKey().get());
    }
}