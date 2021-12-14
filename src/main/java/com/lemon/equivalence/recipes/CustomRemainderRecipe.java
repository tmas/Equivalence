package com.lemon.equivalence.recipes;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.collection.DefaultedList;

public class CustomRemainderRecipe extends ShapelessRecipe {

    public CustomRemainderRecipe(ShapelessRecipe original) {
        super(
                original.getId(),
                original.getGroup(),
                original.getOutput(),
                original.getIngredients()
        );
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CustomRemainderRecipeSerializer.INSTANCE;
    }

    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);

        for(int i = 0; i < defaultedList.size(); ++i) {
            ItemStack stack = inventory.getStack(i);
            Item item = stack.getItem();
            if (item instanceof HasCustomRecipeRemainder) {
                defaultedList.set(i, ((HasCustomRecipeRemainder) item).getCustomRecipeRemainder(stack));
            } else if (item.hasRecipeRemainder()) {
                defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
            }
        }

        return defaultedList;
    }
}
