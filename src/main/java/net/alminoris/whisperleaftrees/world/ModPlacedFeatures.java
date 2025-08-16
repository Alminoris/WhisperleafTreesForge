package net.alminoris.whisperleaftrees.world;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures
{
    public static final ResourceKey<PlacedFeature> POPLAR_PLACED_KEY = registerKey("poplar_placed");
    public static final ResourceKey<PlacedFeature> WILLOW_PLACED_KEY = registerKey("willow_placed");
    public static final ResourceKey<PlacedFeature> ALDER_PLACED_KEY = registerKey("alder_placed");
    public static final ResourceKey<PlacedFeature> ASPEN_PLACED_KEY = registerKey("aspen_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context)
    {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, POPLAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.POPLAR_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("poplar").get()));

        register(context, WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WILLOW_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("willow").get()));

        register(context, ALDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALDER_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("alder").get()));

        register(context, ASPEN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASPEN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.25f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("aspen").get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(WhisperleafTrees.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}