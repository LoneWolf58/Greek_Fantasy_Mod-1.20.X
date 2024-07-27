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


public class DepositMixedGoldDrachmaCommand {

    public DepositMixedGoldDrachmaCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money")
                .then(Commands.literal("deposit")
                .then(Commands.literal("mixed_gold_drachma")
                .then(Commands.argument("amount", IntegerArgumentType.integer(1))
                        .executes(this::execute)))));
    }

    private int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayer();
        int amount = IntegerArgumentType.getInteger(context, "amount");

        if (player.getMainHandItem().is(ModItems.PURE_GOLD_DRACHMA.get())) {
            int playerItemCount = player.getMainHandItem().getCount();

            if (playerItemCount >= amount) {

                player.getMainHandItem().shrink(amount);


                int currentMoney = player.getPersistentData().getInt("greekfantasy.money");
                player.getPersistentData().putInt("greekfantasy.money", currentMoney + amount*5);


                context.getSource().sendSuccess(() -> Component.literal(amount + " Drachmas deposited"), false);
            } else {
                context.getSource().sendSuccess(() -> Component.literal("You don't have enough Drachmas to deposit"), false);
            }
        } else {
            context.getSource().sendSuccess(() -> Component.literal("You need to be holding a drachma"), false);
        }
        return 1;
    }
}