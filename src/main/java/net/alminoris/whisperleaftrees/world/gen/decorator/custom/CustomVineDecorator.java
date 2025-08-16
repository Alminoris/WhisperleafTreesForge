package net.alminoris.whisperleaftrees.world.gen.decorator.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.alminoris.whisperleaftrees.world.gen.decorator.ModTreeDecorators;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.ForgeRegistries;


public class CustomVineDecorator extends TreeDecorator
{
    public static final Codec<CustomVineDecorator> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(decorator -> decorator.probability),
            ForgeRegistries.BLOCKS.getCodec().fieldOf("block").forGetter(decorator -> decorator.block)
    ).apply(instance, CustomVineDecorator::new));

    private final float probability;
    private static Block block;

    public CustomVineDecorator(float probability, Block block)
    {
        this.probability = probability;
        this.block = block;
    }

    @Override
    protected TreeDecoratorType<?> type()
    {
        return ModTreeDecorators.CUSTOM_ADVANCED_VINE_DECORATOR.get();
    }

    @Override
    public void place(TreeDecorator.Context generator)
    {
        RandomSource random = generator.random();
        generator.leaves().forEach(pos ->
        {
            if (random.nextFloat() < this.probability)
            {
                BlockPos blockPos = pos.west();
                if (generator.isAir(blockPos))
                {
                    placeVines(blockPos, VineBlock.EAST, generator);
                }
            }

            if (random.nextFloat() < this.probability)
            {
                BlockPos blockPos = pos.east();
                if (generator.isAir(blockPos))
                {
                    placeVines(blockPos, VineBlock.WEST, generator);
                }
            }

            if (random.nextFloat() < this.probability)
            {
                BlockPos blockPos = pos.north();
                if (generator.isAir(blockPos))
                {
                    placeVines(blockPos, VineBlock.SOUTH, generator);
                }
            }

            if (random.nextFloat() < this.probability)
            {
                BlockPos blockPos = pos.south();
                if (generator.isAir(blockPos))
                {
                    placeVines(blockPos, VineBlock.NORTH, generator);
                }
            }
        });
    }

    /**
     * Places a vine at a given position and then up to 4 more vines going downwards.
     */
    private static void placeVines(BlockPos pos, BooleanProperty faceProperty, TreeDecorator.Context generator)
    {
        generator.setBlock(pos, block.defaultBlockState().setValue(faceProperty, Boolean.valueOf(true)));
        int i = 4;

        for (BlockPos var4 = pos.below(); generator.isAir(var4) && i > 0; i--)
        {
            generator.setBlock(var4, block.defaultBlockState().setValue(faceProperty, Boolean.valueOf(true)));
            var4 = var4.below();
        }
    }
}