package com.cursee.eat_an_omelette.core.common.registry;

import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenBlock;
import com.cursee.eat_an_omelette.core.common.block.custom.SpanishPotatoOmeletteGoldenEnchantedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksForge {

    public static void register() {}

    public static final RegistryObject<Block> SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithBlockItem("spanish_potato_omelette", SpanishPotatoOmeletteBlock::new);
    public static final RegistryObject<Block> GOLDEN_SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithRareBlockItem("golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenBlock::new);
    public static final RegistryObject<Block> ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE = RegistryForge.registerBlockWithEpicBlockItem("enchanted_golden_spanish_potato_omelette", SpanishPotatoOmeletteGoldenEnchantedBlock::new);
}
