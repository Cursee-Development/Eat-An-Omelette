package com.cursee.eat_an_omelette;

import com.cursee.eat_an_omelette.core.common.callback.FabricAnvilUpdateEvent;
import com.cursee.eat_an_omelette.core.common.registry.ModBlocksFabric;
import com.cursee.eat_an_omelette.core.common.registry.ModItemsFabric;
import com.cursee.eat_an_omelette.core.common.registry.RegistryFabric;
import com.cursee.monolib.core.MonoLibConfiguration;
import com.cursee.monolib.core.sailing.Sailing;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import oshi.util.tuples.Triplet;

public class EatAnOmeletteFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {

        EatAnOmelette.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);

        RegistryFabric.register();

        FabricAnvilUpdateEvent.EVENT.register(((anvilmenu, left, right, output, itemName, baseCost, player) -> {

            if ((right.is(Items.ENCHANTED_BOOK) || right.getDescriptionId().contains("enchanted_book")) && (right.getTag() != null && (right.getTag().toString().contains("gf_enchantment") || right.getTag().toString().contains("golden_food")))) {

                if (left.is(ModItemsFabric.GOLDEN_OMELETTE)) {
                    output = new ItemStack(ModItemsFabric.ENCHANTED_GOLDEN_OMELETTE);
                    output.setCount(left.getCount());
                    baseCost = Math.min(left.getCount(), 40);
                    return new Triplet<>(baseCost, baseCost, output);
                }

                if (left.is(ModBlocksFabric.GOLDEN_SPANISH_POTATO_OMELETTE.asItem())) {
                    output = new ItemStack(ModBlocksFabric.ENCHANTED_GOLDEN_SPANISH_POTATO_OMELETTE);
                    output.setCount(left.getCount());
                    baseCost = Math.min(left.getCount(), 40);
                    return new Triplet<>(baseCost, baseCost, output);
                }
            }

            return null;
        }));
    }
}
