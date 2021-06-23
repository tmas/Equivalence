package com.lemon.equivalence.custom_items;

import com.lemon.equivalence.Equivalence;
import com.lemon.equivalence.registry.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

//Custom Item
public class Philosophers_Stone_Item extends Item {

    public Philosophers_Stone_Item(Settings settings) {
        super(new FabricItemSettings()
                .group(Equivalence.ITEM_GROUP) //CreativeTab
                .maxCount(1) //Max Amount of Items in Stack
                .rarity(Rarity.RARE) //Associated Color in Text for Rarity
                .recipeRemainder(ModItems.DISCHARGED_STONE) //Remaining Item after Crafting Operation - Can't Return Self Oddly
        );
    }

    @Override
    public boolean hasRecipeRemainder() {
        return true;
    }
}

