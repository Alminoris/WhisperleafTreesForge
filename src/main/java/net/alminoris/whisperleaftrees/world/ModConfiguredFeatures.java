package net.alminoris.whisperleaftrees.world;

import com.google.common.collect.ImmutableList;
import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.block.ModBlocks;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.alminoris.whisperleaftrees.world.gen.decorator.custom.CustomVineDecorator;
import net.alminoris.whisperleaftrees.world.tree.custom.PoplarFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_KEY = registerKey("poplar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_KEY = registerKey("willow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALDER_KEY = registerKey("alder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("aspen");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        register(context, POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockSetsHelper.LOGS.get("poplar").get()),
                new StraightTrunkPlacer(
                        11,
                        1,
                        1),
                BlockStateProvider.simple(ModBlockSetsHelper.LEAVES.get("poplar").get()),
                new PoplarFoliagePlacer(ConstantInt.of(2), ConstantInt.of(5), 15),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, WILLOW_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockSetsHelper.LOGS.get("willow").get()),
                new CherryTrunkPlacer(
                        3,
                        1,
                        1,
                        UniformInt.of(2, 3),
                        UniformInt.of(2, 3),
                        UniformInt.of(-1, 0),
                        ConstantInt.of(1)
                ),
                BlockStateProvider.simple(ModBlockSetsHelper.LEAVES.get("willow").get()),
                new CherryFoliagePlacer(
                        UniformInt.of(2, 4),
                        ConstantInt.of(0),
                        UniformInt.of(5, 8),
                        0.35f,
                        0.25f,
                        0.75f,
                        0.75f
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).decorators(ImmutableList.of(new CustomVineDecorator(0.35f, ModBlocks.WILLOW_VINES.get()))).build());

        register(context, ASPEN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockSetsHelper.LOGS.get("aspen").get()),
                new StraightTrunkPlacer(
                        9,
                        2,
                        1
                ),
                BlockStateProvider.simple(ModBlockSetsHelper.LEAVES.get("aspen").get()),
                new FancyFoliagePlacer(
                        ConstantInt.of(2),
                        UniformInt.of(0, 2),
                        6
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());

        register(context, ALDER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockSetsHelper.LOGS.get("alder").get()),
                new StraightTrunkPlacer(
                        5,
                        2,
                        0
                ),
                BlockStateProvider.simple(ModBlockSetsHelper.LEAVES.get("alder").get()),
                new BlobFoliagePlacer(
                        ConstantInt.of(3),
                        ConstantInt.of(0),
                        3
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(WhisperleafTrees.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}