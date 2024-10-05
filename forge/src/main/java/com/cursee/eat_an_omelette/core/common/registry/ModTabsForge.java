package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class ModTabsForge {

    public static void register() {}

    private static void addToTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

        output.accept(ModItemsForge.OMELETTE.get());
        output.accept(ModItemsForge.GOLDEN_OMELETTE.get());
        output.accept(ModItemsForge.ENCHANTED_GOLDEN_OMELETTE.get());

        output.accept(ModItemsForge.SPANISH_OMELETTE_MIX.get());
        output.accept(ModBlocksForge.SPANISH_POTATO_OMELETTE.get());
        output.accept(ModBlocksForge.GOLDEN_SPANISH_POTATO_OMELETTE.get());
        output.accept(ModBlocksForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get());
    }

    public static final RegistryObject<CreativeModeTab> EAO_TAB = RegistryForge.registerCreativeModeTab(Constants.MOD_ID, () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> new ItemStack(ModItemsForge.OMELETTE.get()))
            .title(Component.translatable("itemGroup.eatAnOmelette"))
            .displayItems(ModTabsForge::addToTab)
            .build());
}
