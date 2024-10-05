package com.cursee.eat_an_omelette;

import com.cursee.eat_an_omelette.core.common.registry.ModBlocksForge;
import com.cursee.eat_an_omelette.core.common.registry.ModItemsForge;
import com.cursee.eat_an_omelette.core.common.registry.RegistryForge;
import com.cursee.monolib.core.MonoLibConfiguration;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import oshi.util.tuples.Triplet;

import java.util.concurrent.atomic.AtomicBoolean;

@Mod(Constants.MOD_ID)
public class EatAnOmeletteForge {
    
    public EatAnOmeletteForge() {
    
        EatAnOmelette.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistryForge.register(modEventBus);
    }

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
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

                if (event.getLeft().is(ModItemsForge.GOLDEN_OMELETTE.get())) {
                    final ItemStack output = new ItemStack(ModItemsForge.ENCHANTED_GOLDEN_OMELETTE.get());
                    output.setCount(event.getLeft().getCount());
                    event.setCost(Math.min(event.getLeft().getCount(), 40));
                    event.setOutput(output);
                }

                if (event.getLeft().is(ModBlocksForge.GOLDEN_SPANISH_POTATO_OMELETTE.get().asItem())) {
                    final ItemStack output = new ItemStack(ModBlocksForge.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE.get());
                    output.setCount(event.getLeft().getCount());
                    event.setCost(Math.min(event.getLeft().getCount(), 40));
                    event.setOutput(output);

                }
            }
        }
    }
}