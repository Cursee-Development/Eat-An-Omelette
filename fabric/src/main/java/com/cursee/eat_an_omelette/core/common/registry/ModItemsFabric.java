package com.cursee.eat_an_omelette.core.common.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ModItemsFabric {

    public static void register() {}

    public static final Item OMELETTE = RegistryFabric.registerItem("omelette", () ->
            new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(4f).build())));

    public static final Item GOLDEN_OMELETTE = RegistryFabric.registerItem("golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(8).saturationModifier(8f).alwaysEdible().build())));

    public static final Item ENCHANTED_GOLDEN_OMELETTE = RegistryFabric.registerItem("enchanted_golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).food(new FoodProperties.Builder().nutrition(8).saturationModifier(8f).alwaysEdible().build())));

    public static final Item SPANISH_OMELETTE_MIX = RegistryFabric.registerItem("spanish_omelette_mix", () ->
            new Item(new Item.Properties()));
}
