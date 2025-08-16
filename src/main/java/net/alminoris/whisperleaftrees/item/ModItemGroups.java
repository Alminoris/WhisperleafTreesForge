package net.alminoris.whisperleaftrees.item;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WhisperleafTrees.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static CreativeModeTab WHISPERLEAFTREES_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        WHISPERLEAFTREES_TAB = event.registerCreativeModeTab(ResourceLocation.fromNamespaceAndPath(WhisperleafTrees.MOD_ID, "whisperleaftreestab"),
                builder -> builder.icon(() -> new ItemStack(ModBlockSetsHelper.WOODEN_SAPLINGS.get("willow").get().asItem()))
                        .title(Component.translatable("itemgroup.whisperleaftreestab")));
    }
}