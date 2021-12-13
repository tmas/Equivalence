package com.lemon.equivalence;

import com.lemon.equivalence.loot_tables.LootTableAdditions;
import com.lemon.equivalence.registry.ModBlocks;
import com.lemon.equivalence.registry.ModItems;
import com.lemon.equivalence.registry.ModRecipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Equivalence implements ModInitializer {

    //MOD_ID
    public static final String MOD_ID = "equivalence";

    //Creative Tabs
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"), () -> new ItemStack(ModItems.BALANCE_SHARD));

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModRecipes.registerRecipes();

        LootTableAdditions.modifyLootTables();
    }
}
