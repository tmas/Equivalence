package com.lemon.equivalence.loot_tables;

import com.lemon.equivalence.registry.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableAdditions {
    private static final Identifier BLAZE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/blaze");
    private static final Identifier CAVE_SPIDER_LOOT_TABLE_ID = new Identifier("minecraft", "entities/cave_spider");
    private static final Identifier CREEPER_LOOT_TABLE_ID = new Identifier("minecraft", "entities/creeper");
    private static final Identifier DROWNED_LOOT_TABLE_ID = new Identifier("minecraft", "entities/drowned");
    private static final Identifier ENDERMAN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/enderman");
    private static final Identifier GHAST_LOOT_TABLE_ID = new Identifier("minecraft", "entities/ghast");
    private static final Identifier HUSK_LOOT_TABLE_ID = new Identifier("minecraft", "entities/husk");
    private static final Identifier MAGMA_CUBE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/magma_cube");
    private static final Identifier PHANTOM_LOOT_TABLE_ID = new Identifier("minecraft", "entities/phantom");
    private static final Identifier PIGLIN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/piglin");
    private static final Identifier PIGLIN_BRUTE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/piglin_brute");
    private static final Identifier SKELETON_LOOT_TABLE_ID = new Identifier("minecraft", "entities/skeleton");
    private static final Identifier SLIME_LOOT_TABLE_ID = new Identifier("minecraft", "entities/slime");
    private static final Identifier SPIDER_LOOT_TABLE_ID = new Identifier("minecraft", "entities/spider");
    private static final Identifier STRAY_LOOT_TABLE_ID = new Identifier("minecraft", "entities/stray");
    private static final Identifier WITHER_SKELETON_LOOT_TABLE_ID = new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier ZOMBIE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie");
    private static final Identifier ZOMBIE_VILLAGER_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie_villager");
    private static final Identifier ZOMBIFIED_PIGLIN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombified_piglin");

    //Common Loot Table Build Code
    public static FabricLootPoolBuilder poolBuilderGetter(){
        float lowerBound = 0.0f; //Could be done inline below but readability
        float upperBound = 1.0f; //Could be done inline below but readability

        return FabricLootPoolBuilder.builder()
                .rolls(ConstantLootNumberProvider.create(1.0f))
                .withEntry(ItemEntry.builder(ModItems.BALANCE_SHARD).build())
                .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(lowerBound, upperBound)).build());
    }

    //Adds the Balance Shard to some Loot Tables
    public static void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            FabricLootPoolBuilder poolBuilder = poolBuilderGetter();
            if(BLAZE_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(CAVE_SPIDER_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(CREEPER_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(DROWNED_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(ENDERMAN_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(GHAST_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(HUSK_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build()); }
            if(MAGMA_CUBE_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(PHANTOM_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build()); }
            if(PIGLIN_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(PIGLIN_BRUTE_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(SKELETON_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build()); }
            if(SLIME_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(SPIDER_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(STRAY_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(WITHER_SKELETON_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(ZOMBIE_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(ZOMBIE_VILLAGER_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
            if(ZOMBIFIED_PIGLIN_LOOT_TABLE_ID.equals(id)){supplier.withPool(poolBuilder.build());}
        }));
    }
}