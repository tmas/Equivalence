package com.lemon.equivalence.registry;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;
import static net.minecraft.command.argument.EntityArgumentType.player;
import static net.minecraft.command.argument.EntityArgumentType.getPlayer;
import static net.minecraft.command.argument.ItemStackArgumentType.getItemStackArgument;
import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;

import com.lemon.equivalence.emc.EMCProvider;
import com.lemon.equivalence.emc.PlayerEMCDatabase;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            dispatcher.register(literal("equivalence")
                    .then(literal("emc")
                            .then(
                                    argument("item", itemStack())
                                            .executes(context -> {
                                                ItemStack tempStack = getItemStackArgument(context, "item").createStack(1, false);
                                                String translationKey = tempStack.getItem().getTranslationKey();

                                                System.out.println(String.format("translationKey: %s", translationKey));

                                                String[] keyNodes = translationKey.split("\\.");

                                                System.out.println(String.format("Nodes found: %d", keyNodes.length));

                                                String itemIdentifier = String.format("%s:%s", keyNodes[1], keyNodes[2]);

                                                System.out.println(String.format("Item identifier derived: %s", itemIdentifier));

                                                Integer emc = EMCProvider.INSTANCE.getEMC(itemIdentifier);

                                                String response = String.format("The EMC value for \"%s\" is %d", itemIdentifier, emc);

                                                System.out.println(response);
                                                context.getSource().sendFeedback(new LiteralText(response), false);

                                                return 1;
                                            })
                            )
                    )
                    .then(literal("save")
                            .executes(context -> {
                                PlayerEMCDatabase.INSTANCE.save();

                                return 1;
                            }))
                    .then(literal("load")
                            .executes(context -> {
                                PlayerEMCDatabase.INSTANCE.load();

                                return 1;
                            }))
                    .then(literal("player")
                            .then(
                                    argument("player", player())
                                            .then(literal("get")
                                                    .executes(context -> {
                                                        PlayerEntity player = getPlayer(context, "player");

                                                        Integer emc = PlayerEMCDatabase.INSTANCE.getEMC(player);
                                                        String response = String.format("%s has %d EMC", player.getDisplayName().asString(), emc);

                                                        context.getSource().sendFeedback(new LiteralText(response), false);

                                                        return 1;
                                                    }))
                                            .then(literal("set").then(
                                                    argument("amount", integer())
                                                            .executes(context -> {
                                                                PlayerEntity player = getPlayer(context, "player");
                                                                Integer amount = getInteger(context, "amount");

                                                                PlayerEMCDatabase.INSTANCE.setEMC(player, amount);
                                                                String response = String.format("%s's balance has been set to %d EMC", player.getDisplayName().asString(), amount);

                                                                context.getSource().sendFeedback(new LiteralText(response), false);

                                                                return 1;
                                                            })))
                            )
                    )
            );
        });
    }
}
