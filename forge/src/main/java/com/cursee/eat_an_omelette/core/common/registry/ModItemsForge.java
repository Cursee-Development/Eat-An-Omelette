package com.cursee.eat_an_omelette.core.common.registry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsForge {

    public static void register() {}

    public static final RegistryObject<Item> OMELETTE = RegistryForge.registerItem("omelette", () ->
            new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(4f).build())));

    public static final RegistryObject<Item> GOLDEN_OMELETTE = RegistryForge.registerItem("golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).alwaysEat().build())));

    public static final RegistryObject<Item> ENCHANTED_GOLDEN_OMELETTE = RegistryForge.registerItem("enchanted_golden_omelette", () ->
            new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).alwaysEat().build())));

    public static final RegistryObject<Item> SPANISH_OMELETTE_MIX = RegistryForge.registerItem("spanish_omelette_mix", () ->
            new Item(new Item.Properties()));
}
