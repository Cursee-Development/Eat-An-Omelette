package com.cursee.eat_an_omelette.core.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
            new Item(new Item.Properties().rarity(Rarity.RARE).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEat().build())));

    public static final RegistryObject<Item> ENCHANTED_GOLDEN_OMELETTE = RegistryForge.registerItem("enchanted_golden_omelette", () ->
            new SimpleFoiledItem(new Item.Properties().rarity(Rarity.EPIC).food(new FoodProperties.Builder().nutrition(8).saturationMod(8f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEat().build())));

    public static final RegistryObject<Item> SPANISH_OMELETTE_MIX = RegistryForge.registerItem("spanish_omelette_mix", () ->
            new Item(new Item.Properties()));
}
