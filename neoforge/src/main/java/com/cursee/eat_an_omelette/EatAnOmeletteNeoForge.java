package com.cursee.eat_an_omelette;

import com.cursee.eat_an_omelette.core.common.registry.ModBlocksNeoForge;
import com.cursee.eat_an_omelette.core.common.registry.ModItemsNeoForge;
import com.cursee.eat_an_omelette.core.common.registry.RegistryNeoForge;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AnvilUpdateEvent;

import java.util.concurrent.atomic.AtomicBoolean;

@Mod(Constants.MOD_ID)
public class EatAnOmeletteNeoForge {
    
    public EatAnOmeletteNeoForge(IEventBus modEventBus) {
    
        EatAnOmelette.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);

        RegistryNeoForge.register(modEventBus);
    }

    @EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    public static class ForgeAnvilUpdateEvent {

        @SubscribeEvent
        public static void onAnvilChange(AnvilUpdateEvent event) {

            final AtomicBoolean foundGoldenFoodsEnchantment = new AtomicBoolean(false);
            if (event.getRight().has(DataComponents.STORED_ENCHANTMENTS)) {

                final ItemEnchantments STORED_ENCHANTMENTS = event.getRight().get(DataComponents.STORED_ENCHANTMENTS);

                assert STORED_ENCHANTMENTS != null;

                STORED_ENCHANTMENTS.keySet().forEach(enchantmentHolder -> {
                    if (enchantmentHolder.value().toString().contains("gf_enchantment")) foundGoldenFoodsEnchantment.set(true);
                    if (enchantmentHolder.value().toString().contains("golden_food")) foundGoldenFoodsEnchantment.set(true);
                });
            }

            if ((event.getRight().is(Items.ENCHANTED_BOOK) || event.getRight().getDescriptionId().contains("enchanted_book")) && foundGoldenFoodsEnchantment.get()) {

                if (event.getLeft().is(ModItemsNeoForge.GOLDEN_OMELETTE.get())) {
                    final ItemStack output = new ItemStack(ModItemsNeoForge.ENCHANTED_GOLDEN_OMELETTE.get());
                    output.setCount(event.getLeft().getCount());
                    event.setCost(Math.min(event.getLeft().getCount(), 40));
                    event.setOutput(output);
                }

                if (event.getLeft().is(ModBlocksNeoForge.GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem())) {
                    final ItemStack output = new ItemStack(ModBlocksNeoForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get());
                    output.setCount(event.getLeft().getCount());
                    event.setCost(Math.min(event.getLeft().getCount(), 40));
                    event.setOutput(output);

                }
            }
        }
    }
}