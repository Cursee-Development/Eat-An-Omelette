package com.cursee.eat_an_omelette.core.common.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;

public class ModItemsFabric {

    public static void register() {}

    public static final Item OMELETTE = RegistryFabric.registerItem("omelette", () ->
            new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(4f).build())));

    public static final Item GOLDEN_OMELETTE = RegistryFabric.registerItem("golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).alwaysEat().build())));

    public static final Item ENCHANTED_GOLDEN_OMELETTE = RegistryFabric.registerItem("enchanted_golden_omelette", () ->
            new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).alwaysEat().build())));

    public static final Item SPANISH_OMELETTE_MIX = RegistryFabric.registerItem("spanish_omelette_mix", () ->
            new Item(new Item.Properties()));
}
