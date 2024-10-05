package com.cursee.eat_an_omelette.core.common.block.custom;

import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;

public class SpanishPotatoOmeletteBlock extends CakeBlock {

    public SpanishPotatoOmeletteBlock() {
        super(Properties.of().strength(0.5F).sound(SoundType.WOOL));
    }
}
