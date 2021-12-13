package com.lemon.equivalence.registry;

import com.lemon.equivalence.Equivalence;
import com.lemon.equivalence.recipes.CustomRemainderRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(
                Registry.RECIPE_SERIALIZER,
                new Identifier(Equivalence.MOD_ID, "shapeless_custom_remainder"),
                CustomRemainderRecipeSerializer.INSTANCE
        );
    }
}
