package net.alminoris.whisperleaftrees.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.whisperleaftrees.world.tree.ModFoliagePlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PoplarFoliagePlacer extends FancyFoliagePlacer
{
    public static final Codec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.create(
            instance -> blobParts(instance).apply(instance, PoplarFoliagePlacer::new)
    );

    public PoplarFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset, height);
    }

    @Override
    protected FoliagePlacerType<?> type()
    {
        return ModFoliagePlacerTypes.POPLAR_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(
            LevelSimulatedReader world,
            FoliagePlacer.FoliageSetter placer,
            RandomSource random,
            TreeConfiguration config,
            int trunkHeight,
            FoliagePlacer.FoliageAttachment treeNode,
            int foliageHeight,
            int radius,
            int offset)
    {
        int c = 0;
        for (int i = offset; i >= offset - foliageHeight; i--)
        {
            int i1 = i != offset && i != offset - foliageHeight ? 1 : 0;
            if (c < 3)
            {
                int j = (radius-1) + i1;
                this.placeLeavesRow(world, placer, random, config, treeNode.pos(), j, i, treeNode.doubleTrunk());
            }
            else
            {
                int j = radius + i1;
                this.placeLeavesRow(world, placer, random, config, treeNode.pos(), j, i, treeNode.doubleTrunk());
            }
            c++;
        }
    }
}