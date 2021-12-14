package com.lemon.equivalence.recipes;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

public class CustomRemainderRecipeSerializer extends ShapelessRecipe.Serializer {
    public static final CustomRemainderRecipeSerializer INSTANCE = new CustomRemainderRecipeSerializer();

    @Override
    public ShapelessRecipe read(Identifier identifier, JsonObject jsonObject) {
        return new CustomRemainderRecipe(super.read(identifier, jsonObject));
    }

    @Override
    public ShapelessRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
        return new CustomRemainderRecipe(super.read(identifier, packetByteBuf));
    }
}
