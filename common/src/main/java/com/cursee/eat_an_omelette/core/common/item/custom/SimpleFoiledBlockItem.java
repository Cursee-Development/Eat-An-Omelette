package com.cursee.eat_an_omelette.core.common.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class SimpleFoiledBlockItem extends BlockItem {

    public SimpleFoiledBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isFoil(ItemStack $$0) {
        return true;
    }
}
