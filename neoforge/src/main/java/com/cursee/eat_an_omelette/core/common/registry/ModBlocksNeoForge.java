package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenEnchantedBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlocksNeoForge {

    public static void register() {}

    public static final DeferredHolder<Block ,Block> SPANISH_POTATO_OMELETTE = RegistryNeoForge.registerBlockWithBlockItem("spanish_potato_omelette", SpanishPotatoOmeletteBlock::new);
    public static final DeferredHolder<Block ,Block> GOLDEN_SPANISH_POTATO_OMELETTE = RegistryNeoForge.registerBlockWithRareBlockItem("golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenBlock::new);
    public static final DeferredHolder<Block ,Block> ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE = RegistryNeoForge.registerBlockWithEpicBlockItem("enchanted_golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenEnchantedBlock::new);
}
