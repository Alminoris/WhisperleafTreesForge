package net.alminoris.whisperleaftrees.world.gen.decorator;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.world.gen.decorator.custom.CustomVineDecorator;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTreeDecorators
{
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, WhisperleafTrees.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<CustomVineDecorator>> CUSTOM_ADVANCED_VINE_DECORATOR =
            TREE_DECORATORS.register("custom_advanced_vine_decorator",
                    () -> new TreeDecoratorType<>(CustomVineDecorator.CODEC));

    public static void register(IEventBus eventBus)
    {
        TREE_DECORATORS.register(eventBus);
    }
}