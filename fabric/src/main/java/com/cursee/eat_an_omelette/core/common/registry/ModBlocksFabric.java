package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenEnchantedBlock;
import net.minecraft.world.level.block.Block;

public class ModBlocksFabric {

    public static void register() {}

    public static final Block SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithBlockItem("spanish_potato_omelette", SpanishPotatoOmeletteBlock::new);
    public static final Block GOLDEN_SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithRareBlockItem("golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenBlock::new);
    public static final Block ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE = RegistryFabric.registerBlockWithEpicBlockItem("enchanted_golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenEnchantedBlock::new);
}
