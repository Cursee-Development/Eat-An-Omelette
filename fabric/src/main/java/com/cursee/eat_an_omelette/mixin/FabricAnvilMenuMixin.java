package com.cursee.eat_an_omelette.mixin;

import com.cursee.eat_an_omelette.core.common.callback.FabricAnvilUpdateEvent;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import oshi.util.tuples.Triplet;

/** Credited to Rick South (Serilum) */

@Mixin(value = AnvilMenu.class, priority = 1001)
public abstract class FabricAnvilMenuMixin extends ItemCombinerMenu {
  
  @Shadow private String itemName;
  @Shadow private int repairItemCountCost;
  @Final @Shadow private DataSlot cost;
  
  @Inject(method = "createResult()V", at = @At(value= "TAIL"))
  public void onCreateAnvilResult(CallbackInfo cir) {
    AnvilMenu anvilMenu = (AnvilMenu) (Object) this;
    Container inputSlots = this.inputSlots;
    
    ItemStack left = inputSlots.getItem(0);
    ItemStack right = inputSlots.getItem(1);
    ItemStack output = this.resultSlots.getItem(0);
    
    int baseCost = left.getBaseRepairCost() + (right.isEmpty() ? 0 : right.getBaseRepairCost());
    
    Triplet<Integer, Integer, ItemStack> triple = FabricAnvilUpdateEvent.EVENT.invoker().onAnvilChange(anvilMenu, left, right, output, this.itemName, baseCost, this.player);
    if (triple == null) {
      return;
    }
    
    if (triple.getA() >= 0) {
      this.cost.set(triple.getA());
    }
    
    if (triple.getB() >= 0) {
      this.repairItemCountCost = triple.getB();
    }
    
    if (triple.getC() != null) {
      this.resultSlots.setItem(0, triple.getC());
    }
  }

  @Deprecated(forRemoval = false)
  public FabricAnvilMenuMixin(MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
    super(menuType, i, inventory, containerLevelAccess);
  }
}