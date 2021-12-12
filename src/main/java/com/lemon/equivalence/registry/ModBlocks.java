package com.lemon.equivalence.registry;

import com.lemon.equivalence.Equivalence;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block BALANCE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 20.0f).sounds(BlockSoundGroup.STONE));
    public static final Block NITRO_COAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 20.0f).sounds(BlockSoundGroup.STONE));
    public static final Block INFERNO_COAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 20.0f).sounds(BlockSoundGroup.STONE));
    public static final Block BLAZING_COAL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0f, 20.0f).sounds(BlockSoundGroup.STONE));

public static void registerBlocks(){
    Registry.register(Registry.BLOCK, new Identifier(Equivalence.MOD_ID, "balance_block"), BALANCE_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier(Equivalence.MOD_ID, "nitro_coal_block"), NITRO_COAL_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier(Equivalence.MOD_ID, "inferno_coal_block"), INFERNO_COAL_BLOCK);
    Registry.register(Registry.BLOCK, new Identifier(Equivalence.MOD_ID, "blazing_coal_block"), BLAZING_COAL_BLOCK);
    }
}
