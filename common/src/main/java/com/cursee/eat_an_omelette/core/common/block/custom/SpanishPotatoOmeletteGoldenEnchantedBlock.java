package com.cursee.eat_an_omelette.core.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class SpanishPotatoOmeletteGoldenEnchantedBlock extends CakeBlock {

    public SpanishPotatoOmeletteGoldenEnchantedBlock() {
        super(Properties.of().strength(0.5F).sound(SoundType.WOOL));
    }

    protected ItemInteractionResult useItemOn(ItemStack $$0, BlockState $$1, Level $$2, BlockPos $$3, Player $$4, InteractionHand $$5, BlockHitResult $$6) {
        Item $$7 = $$0.getItem();
        if ($$0.is(ItemTags.CANDLES) && (Integer)$$1.getValue(BITES) == 0) {
            Block var10 = Block.byItem($$7);
            if (var10 instanceof CandleBlock) {
                CandleBlock $$9 = (CandleBlock)var10;
                $$0.consume(1, $$4);
                $$2.playSound((Player)null, $$3, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                $$2.setBlockAndUpdate($$3, CandleCakeBlock.byCandle($$9));
                $$2.gameEvent($$4, GameEvent.BLOCK_CHANGE, $$3);
                $$4.awardStat(Stats.ITEM_USED.get($$7));
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected InteractionResult useWithoutItem(BlockState $$0, Level $$1, BlockPos $$2, Player $$3, BlockHitResult $$4) {
        if ($$1.isClientSide) {
            if (eat($$1, $$2, $$0, $$3).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if ($$3.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat($$1, $$2, $$0, $$3);
    }

    public static InteractionResult eat(LevelAccessor level, BlockPos blockPos, BlockState blockState, Player player) {

        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }
        else {

            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);

            /* Custom Logic, effects copied from net.minecraft.world.food.Foods ENCHANTED_GOLDEN_APPLE */
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));

            int bitesTaken = blockState.getValue(BITES);

            level.gameEvent(player, GameEvent.EAT, blockPos);

            if (bitesTaken < 6) {
                level.setBlock(blockPos, blockState.setValue(BITES, bitesTaken + 1), 3);
            }
            else {
                level.removeBlock(blockPos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
            }

            return InteractionResult.SUCCESS;
        }
    }
}
