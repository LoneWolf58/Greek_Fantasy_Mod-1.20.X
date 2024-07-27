package net.marshall.greekfantasy.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class QueryMoneyCommand {
    public QueryMoneyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money").then(Commands.literal("query")
                .executes(this::execute)));
    }

    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        context.getSource().sendSuccess(() -> Component.literal("You have " + player.getPersistentData().getInt("greekfantasy.money") + " Drachmas"), false);
        return 1;
    }


}

