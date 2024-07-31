package net.marshall.greekfantasy.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;


public class DepositDrachmaCommand {

    public DepositDrachmaCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money")
                .then(Commands.literal("deposit")
                .then(Commands.argument("amount", IntegerArgumentType.integer(1))
                        .executes(this::execute))));
    }

    private int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayer();
        int amount = IntegerArgumentType.getInteger(context, "amount");
        int playerItemCount = player.getMainHandItem().getCount();
        int currentMoney = player.getPersistentData().getInt("greekfantasy.money");

        if (player.getMainHandItem().is(ModItems.COPPER_DRACHMA.get())) {

            if (playerItemCount >= amount) {

                player.getMainHandItem().shrink(amount);

                player.getPersistentData().putInt("greekfantasy.money", currentMoney + amount);

                context.getSource().sendSuccess(() -> Component.literal(amount + " Drachmas deposited"), false);
            } else {
                context.getSource().sendSuccess(() -> Component.literal("You don't have enough Drachmas to deposit"), false);
            }

        } else if (player.getMainHandItem().is(ModItems.MIXED_GOLD_DRACHMA.get())) {

            if (playerItemCount >= amount) {

                player.getMainHandItem().shrink(amount);

                player.getPersistentData().putInt("greekfantasy.money", currentMoney + amount+5);

                context.getSource().sendSuccess(() -> Component.literal(amount + " Drachmas deposited"), false);
            } else {
                context.getSource().sendSuccess(() -> Component.literal("You don't have enough Drachmas to deposit"), false);
            }
        }
        return 1;
    }
}