package moe.timicasto.torchoftech.levelgen;

import moe.timicasto.torchoftech.TorchOfTechBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class Generations {
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> AZURITE_ORE_FEATURE;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CHALCOCITE_ORE_FEATURE;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> MALACHITE_ORE_FEATURE;
	public static Holder<PlacedFeature> AZURITE_ORE;
	public static Holder<PlacedFeature> CHALCOCITE_ORE;
	public static Holder<PlacedFeature> MALACHITE_ORE;

	public static void registerFeatures() {
		AZURITE_ORE_FEATURE = FeatureUtils.register("torchoftech:azurite_vein", Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, TorchOfTechBlocks.AZURITE.get().defaultBlockState(), 5));
		CHALCOCITE_ORE_FEATURE = FeatureUtils.register("torchoftech:chalcocite_vein", Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, TorchOfTechBlocks.CHALCOCITE.get().defaultBlockState(), 4));
		MALACHITE_ORE_FEATURE = FeatureUtils.register("torchoftech:malachite_vein", Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, TorchOfTechBlocks.MALACHITE.get().defaultBlockState(), 8));

		AZURITE_ORE = PlacementUtils.register("torchoftech:azurite_vein", AZURITE_ORE_FEATURE, List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.uniform(new VerticalAnchor.AboveBottom(50), new VerticalAnchor.BelowTop(100))));
		CHALCOCITE_ORE = PlacementUtils.register("torchoftech:chalcocite_vein", CHALCOCITE_ORE_FEATURE, List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.uniform(new VerticalAnchor.AboveBottom(50), new VerticalAnchor.BelowTop(100))));
		MALACHITE_ORE = PlacementUtils.register("torchoftech:malachite_vein", MALACHITE_ORE_FEATURE, List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.uniform(new VerticalAnchor.AboveBottom(50), new VerticalAnchor.BelowTop(100))));
	}
}
