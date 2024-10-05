package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.Constants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabsFabric {

    public static void register() {}

    private static void addToTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

        output.accept(ModItemsFabric.OMELETTE);
        output.accept(ModItemsFabric.GOLDEN_OMELETTE);
        output.accept(ModItemsFabric.ENCHANTED_GOLDEN_OMELETTE);

        output.accept(ModItemsFabric.SPANISH_OMELETTE_MIX);
        output.accept(ModBlocksFabric.SPANISH_POTATO_OMELETTE);
        output.accept(ModBlocksFabric.GOLDEN_SPANISH_POTATO_OMELETTE);
        output.accept(ModBlocksFabric.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE);
    }

    public static final CreativeModeTab EAO_TAB = RegistryFabric.registerCreativeModeTab(Constants.MOD_ID, () -> FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItemsFabric.OMELETTE))
            .title(Component.translatable("itemGroup.eatAnOmelette"))
            .displayItems(ModTabsFabric::addToTab)
            .build());
}
