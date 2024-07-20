package net.marshall.greekfantasy.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class WithdrawMoneyCommand {

    public WithdrawMoneyCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("money").then(Commands.literal("withdraw"))
                .executes(this::execute));
    }


    private int execute(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();
        context.getSource().sendSuccess(() -> Component.literal("withdrew" + " ? " + "Drachmas"), false);
        ItemStack itemStack = new ItemStack(ModItems.MIXED_GOLD_DRACHMA.get());
        player.getInventory().add(itemStack);
        player.getPersistentData().putInt("greekfantasy.money", -1);
        return 1;
    }
}
