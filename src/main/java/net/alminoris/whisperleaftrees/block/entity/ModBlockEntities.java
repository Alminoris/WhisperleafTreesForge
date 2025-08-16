package net.alminoris.whisperleaftrees.block.entity;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WhisperleafTrees.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlockSetsHelper.WOODEN_SIGNS.get("willow").get(), ModBlockSetsHelper.WOODEN_WALL_SIGNS.get("willow").get(),
                            ModBlockSetsHelper.WOODEN_SIGNS.get("poplar").get(), ModBlockSetsHelper.WOODEN_WALL_SIGNS.get("poplar").get(),
                            ModBlockSetsHelper.WOODEN_SIGNS.get("alder").get(), ModBlockSetsHelper.WOODEN_WALL_SIGNS.get("alder").get(),
                            ModBlockSetsHelper.WOODEN_SIGNS.get("aspen").get(), ModBlockSetsHelper.WOODEN_WALL_SIGNS.get("aspen").get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlockSetsHelper.WOODEN_HANGING_SIGNS.get("willow").get(), ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get("willow").get(),
                            ModBlockSetsHelper.WOODEN_HANGING_SIGNS.get("poplar").get(), ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get("poplar").get(),
                            ModBlockSetsHelper.WOODEN_HANGING_SIGNS.get("alder").get(), ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get("alder").get(),
                            ModBlockSetsHelper.WOODEN_HANGING_SIGNS.get("aspen").get(), ModBlockSetsHelper.WOODEN_WALL_HANGING_SIGNS.get("aspen").get()).build(null));


    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}