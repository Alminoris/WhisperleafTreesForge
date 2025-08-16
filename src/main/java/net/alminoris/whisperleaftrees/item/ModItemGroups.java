package net.alminoris.whisperleaftrees.item;

import net.alminoris.whisperleaftrees.WhisperleafTrees;
import net.alminoris.whisperleaftrees.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper.*;

@Mod.EventBusSubscriber(modid = WhisperleafTrees.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhisperleafTrees.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WHISPERLEAFTREES_TAB = CREATIVE_MODE_TABS.register("whisperleaftreestab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> WOODEN_SAPLINGS.get("willow").get().asItem().getDefaultInstance())
            .title(Component.translatable("itemgroup.whisperleaftreestab"))
            .displayItems((parameters, output) ->
            {
                output.accept(ModBlocks.WILLOW_VINES.get());
                for (String name : WOOD_NAMES)
                {
                    output.accept(WOODEN_SAPLINGS.get(name).get());
                    output.accept(LEAVES.get(name).get());
                    output.accept(LOGS.get(name).get());
                    output.accept(WOODS.get(name).get());
                    output.accept(STRIPPED_LOGS.get(name).get());
                    output.accept(STRIPPED_WOODS.get(name).get());
                    output.accept(WOODEN_PLANKS.get(name).get());
                    output.accept(WOODEN_SLABS.get(name).get());
                    output.accept(WOODEN_STAIRS.get(name).get());
                    output.accept(WOODEN_FENCES.get(name).get());
                    output.accept(WOODEN_FENCE_GATES.get(name).get());
                    output.accept(WOODEN_DOORS.get(name).get());
                    output.accept(WOODEN_TRAPDOORS.get(name).get());
                    output.accept(WOODEN_BUTTONS.get(name).get());
                    output.accept(WOODEN_PRESSURE_PLATES.get(name).get());
                    output.accept(WOODEN_SIGN_ITEMS.get(name).get());
                    output.accept(WOODEN_HANGING_SIGN_ITEMS.get(name).get());
                    output.accept(WOODEN_BOATS.get(name).get());
                    output.accept(WOODEN_CHEST_BOATS.get(name).get());
                }
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}