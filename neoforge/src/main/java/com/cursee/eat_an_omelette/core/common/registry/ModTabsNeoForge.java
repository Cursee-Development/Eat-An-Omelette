package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModTabsNeoForge {

    public static void register() {}

    private static void addToTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

        output.accept(ModItemsNeoForge.OMELETTE.get());
        output.accept(ModItemsNeoForge.GOLDEN_OMELETTE.get());
        output.accept(ModItemsNeoForge.ENCHANTED_GOLDEN_OMELETTE.get());

        output.accept(ModItemsNeoForge.SPANISH_OMELETTE_MIX.get());
        output.accept(ModBlocksNeoForge.SPANISH_POTATO_OMELETTE.get());
        output.accept(ModBlocksNeoForge.GOLDEN_SPANISH_POTATO_OMELETTE.get());
        output.accept(ModBlocksNeoForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get());
    }

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EAO_TAB = RegistryNeoForge.registerCreativeModeTab(Constants.MOD_ID, () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> new ItemStack(ModItemsNeoForge.OMELETTE.get()))
            .title(Component.translatable("itemGroup.eatAnOmelette"))
            .displayItems(ModTabsNeoForge::addToTab)
            .build());
}
