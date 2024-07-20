package net.marshall.greekfantasy.events;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.command.DepositMoneyCommand;
import net.marshall.greekfantasy.command.QueryMoneyCommand;
import net.marshall.greekfantasy.command.WithdrawMoneyCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = GreekFantasy.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new DepositMoneyCommand(event.getDispatcher());
        new QueryMoneyCommand(event.getDispatcher());
        new WithdrawMoneyCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event){
        event.getEntity().getPersistentData().getInt("greekfantasy.money");
    }
}
