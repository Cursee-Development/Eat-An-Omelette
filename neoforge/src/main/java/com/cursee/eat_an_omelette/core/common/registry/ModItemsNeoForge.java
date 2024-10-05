package com.cursee.eat_an_omelette.core.common.registry;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItemsNeoForge {

    public static void register() {}

    public static final DeferredHolder<Item, Item> OMELETTE = RegistryNeoForge.registerItem("omelette", () ->
            new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationModifier(4f).build())));

    public static final DeferredHolder<Item, Item> GOLDEN_OMELETTE = RegistryNeoForge.registerItem("golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).food(new FoodProperties.Builder().nutrition(8).saturationModifier(8f).build())));

    public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_OMELETTE = RegistryNeoForge.registerItem("enchanted_golden_omelette", () ->
            new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true).food(new FoodProperties.Builder().nutrition(8).saturationModifier(8f).build())));

    public static final DeferredHolder<Item, Item> SPANISH_OMELETTE_MIX = RegistryNeoForge.registerItem("spanish_omelette_mix", () ->
            new Item(new Item.Properties()));
}
