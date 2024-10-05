package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.Constants;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegistryNeoForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Constants.MOD_ID);
    protected static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {

        ModBlocksNeoForge.register();
        ModItemsNeoForge.register();
        ModTabsNeoForge.register();

        RegistryNeoForge.BLOCKS.register(modEventBus);
        RegistryNeoForge.ITEMS.register(modEventBus);
        RegistryNeoForge.TABS.register(modEventBus);
    }

    public static <T extends Block> DeferredHolder<Block, T> registerBlock(String id, Supplier<T> supplier) {
        return RegistryNeoForge.BLOCKS.register(id, supplier);
    }

    public static <T extends Item> DeferredHolder<Item, T> registerItem(String id, Supplier<T> supplier) {
        return RegistryNeoForge.ITEMS.register(id, supplier);
    }

    public static <T extends Block> DeferredHolder<Block, T> registerBlockWithBlockItem(String id, Supplier<T> supplier) {
        DeferredHolder<Block, T> registeredBlock = registerBlock(id, supplier);
        registerItem(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }

    public static <T extends Block> DeferredHolder<Block, T> registerBlockWithRareBlockItem(String id, Supplier<T> supplier) {
        DeferredHolder<Block, T> registeredBlock = registerBlock(id, supplier);
        registerItem(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));
        return registeredBlock;
    }

    public static <T extends Block> DeferredHolder<Block, T> registerBlockWithEpicBlockItem(String id, Supplier<T> supplier) {
        DeferredHolder<Block, T> registeredBlock = registerBlock(id, supplier);
        registerItem(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
        return registeredBlock;
    }

    public static <T extends CreativeModeTab> DeferredHolder<CreativeModeTab, T> registerCreativeModeTab(String id, Supplier<T> supplier) {
        return RegistryNeoForge.TABS.register(id, supplier);
    }
}
