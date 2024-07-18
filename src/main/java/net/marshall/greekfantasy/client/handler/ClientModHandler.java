package net.marshall.greekfantasy.client.handler;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.client.keyBindings;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GreekFantasy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)


public class ClientModHandler {

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(keyBindings.INSTANCE.exampleKey);
        event.register(keyBindings.INSTANCE.examplePacketKey);
    }
}
