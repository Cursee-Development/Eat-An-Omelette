package com.cursee.eat_an_omelette.core.common.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        ItemStack itemStack = player.getItemInHand(interactionHand);
        Item item = itemStack.getItem();

        if (itemStack.is(ItemTags.CANDLES) && (Integer)blockState.getValue(BITES) == 0) {

            Block block = Block.byItem(item);

            if (block instanceof CandleBlock) {

                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }

                level.playSound(null, blockPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(blockPos, CandleCakeBlock.byCandle(block));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                player.awardStat(Stats.ITEM_USED.get(item));

                return InteractionResult.SUCCESS;
            }
        }

        if (level.isClientSide()) {

            if (eat(level, blockPos, blockState, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, blockPos, blockState, player);
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
