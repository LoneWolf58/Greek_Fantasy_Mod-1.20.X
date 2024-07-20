package net.marshall.greekfantasy.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.item.ModItems;
import net.marshall.greekfantasy.util.InventoryUtil;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;


public class DepositMoneyCommand {

    public DepositMoneyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money").then(Commands.literal("deposit")
                .executes(this::execute)));
    }


    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();

        if(player.getMainHandItem().is(ModItems.MIXED_GOLD_DRACHMA.get())) {
            context.getSource().sendSuccess(() -> Component.literal(String.valueOf(player.getMainHandItem().getCount())), false);
            context.getSource().sendSuccess(() -> Component.literal("deposited" + " ? " + "Drachmas"), false);
            player.getPersistentData().putInt("greekfantasy.money", +1);
        } else {context.getSource().sendSuccess(() -> Component.literal("need to be holding a drachma"), false);}
        return 1;
    }


}