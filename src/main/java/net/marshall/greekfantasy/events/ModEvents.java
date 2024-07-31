package net.marshall.greekfantasy.events;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.command.*;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = GreekFantasy.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new DepositMixedGoldDrachmaCommand(event.getDispatcher());
        new WithdrawMixedGoldDrachmaCommand(event.getDispatcher());

        new WithdrawCopperDrachmaCommand(event.getDispatcher());

        new DepositPureGoldDrachmaCommand(event.getDispatcher());
        new WithdrawPureGoldDrachmaCommand(event.getDispatcher());

        new DepositDiamondDrachmaCommand(event.getDispatcher());
        new WithdrawDiamondDrachmaCommand(event.getDispatcher());

        new DepositEmeraldDrachmaCommand(event.getDispatcher());
        new WithdrawEmeraldDrachmaCommand(event.getDispatcher());

        new DepositDrachmaCommand(event.getDispatcher());
        new WithdrawDrachmaCommand(event.getDispatcher());

        new QueryMoneyCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        event.getEntity().getPersistentData().getInt("greekfantasy.money");
    }
}
