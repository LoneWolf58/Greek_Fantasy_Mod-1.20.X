package net.marshall.greekfantasy.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class WithdrawPureGoldDrachmaCommand {

    public WithdrawPureGoldDrachmaCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money")
                .then(Commands.literal("withdraw")
                .then(Commands.literal("pure_gold_drachma")
                .then(Commands.argument("amount", IntegerArgumentType.integer(1))
                        .executes(this::execute)))));
    }



    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        int amount = IntegerArgumentType.getInteger(context, "amount");

        context.getSource().sendSuccess(() -> Component.literal("withdrew " + amount + " Drachmas"), false);

        if (player.getPersistentData().getInt("greekfantasy.money") >= 10) {
            for (int i = 0; i < amount; i++) {
                ItemStack itemStack = new ItemStack(ModItems.PURE_GOLD_DRACHMA.get());
                player.getInventory().add(itemStack);
            }
            int currentMoney = player.getPersistentData().getInt("greekfantasy.money");
            player.getPersistentData().putInt("greekfantasy.money", currentMoney - amount*10);

        } else {context.getSource().sendSuccess(() -> Component.literal("You don't have enough Drachmas to withdraw, you need at least 10 drachmas" ), false);
        } return 1;
    }
}
