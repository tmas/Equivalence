package com.lemon.equivalence.registry;

import com.lemon.equivalence.Equivalence;
import com.lemon.equivalence.custom_items.Philosophers_Stone_Item;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Items
    public static final Item BALANCE_SHARD = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item DISCHARGED_STONE = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item INERT_STONE = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item PHILOSOPHERS_STONE = new Philosophers_Stone_Item(new Item.Settings());
    public static final Item ZEN_SHARD = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item ZEN_STONE = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item TINY_COAL = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item TINY_CHARCOAL = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item NITRO_COAL = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item INFERNO_COAL = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final Item BLAZING_COAL = new Item(new Item.Settings().group(Equivalence.ITEM_GROUP));

    //Blocks
    public static final BlockItem BALANCE_BLOCK = new BlockItem(ModBlocks.BALANCE_BLOCK, new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final BlockItem NITRO_COAL_BLOCK = new BlockItem(ModBlocks.NITRO_COAL_BLOCK, new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final BlockItem INFERNO_COAL_BLOCK = new BlockItem(ModBlocks.INFERNO_COAL_BLOCK, new Item.Settings().group(Equivalence.ITEM_GROUP));
    public static final BlockItem BLAZING_COAL_BLOCK = new BlockItem(ModBlocks.BLAZING_COAL_BLOCK, new Item.Settings().group(Equivalence.ITEM_GROUP));

    //Registering
    public static void registerItems(){
        //Register Items
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "balance_shard"), BALANCE_SHARD);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "discharged_stone"), DISCHARGED_STONE);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "inert_stone"), INERT_STONE);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "philosophers_stone"), PHILOSOPHERS_STONE);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "zen_shard"), ZEN_SHARD);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "zen_stone"), ZEN_STONE);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "tiny_coal"), TINY_COAL);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "tiny_charcoal"), TINY_CHARCOAL);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "nitro_coal"), NITRO_COAL);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "inferno_coal"), INFERNO_COAL);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "blazing_coal"), BLAZING_COAL);

        //Register Blocks
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "balance_block"), BALANCE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "nitro_coal_block"), NITRO_COAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "inferno_coal_block"), INFERNO_COAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Equivalence.MOD_ID, "blazing_coal_block"), BLAZING_COAL_BLOCK);

        //Register Fuels
        FuelRegistry.INSTANCE.add(TINY_COAL, 200);
        FuelRegistry.INSTANCE.add(TINY_CHARCOAL, 200);
        FuelRegistry.INSTANCE.add(NITRO_COAL, 6400);
        FuelRegistry.INSTANCE.add(INFERNO_COAL, 25600);
        FuelRegistry.INSTANCE.add(BLAZING_COAL, 102400);
        FuelRegistry.INSTANCE.add(NITRO_COAL_BLOCK, 57600);
        FuelRegistry.INSTANCE.add(INFERNO_COAL_BLOCK, 230400);
        FuelRegistry.INSTANCE.add(BLAZING_COAL_BLOCK, 921600);
    }
}
