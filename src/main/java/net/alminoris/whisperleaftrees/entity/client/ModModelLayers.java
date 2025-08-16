package net.alminoris.whisperleaftrees.entity.client;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;

import static net.alminoris.whisperleaftrees.block.ModBlocks.registerPressurePlateBlock;
import static net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper.WOOD_NAMES;

public class ModModelLayers
{
    public static final Dictionary<String, ModelLayerLocation> BOAT_LAYERS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, new ModelLayerLocation(
                     ResourceLocation.fromNamespaceAndPath(WhisperleafTrees.MOD_ID, "boat/"+name), "main"));
    }};

    public static final Dictionary<String, ModelLayerLocation> CHEST_BOAT_LAYERS = new Hashtable<>()
    {{
        for(String name : WOOD_NAMES)
            put(name, new ModelLayerLocation(
                    ResourceLocation.fromNamespaceAndPath(WhisperleafTrees.MOD_ID, "chest_boat/"+name), "main"));
    }};
}