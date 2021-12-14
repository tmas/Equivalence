package com.lemon.equivalence.recipes;

import net.minecraft.item.ItemStack;

public interface HasCustomRecipeRemainder {
    ItemStack getCustomRecipeRemainder(ItemStack initialStack);
}
