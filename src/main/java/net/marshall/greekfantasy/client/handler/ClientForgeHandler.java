package net.marshall.greekfantasy.client.handler;


import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.client.keyBindings;
import net.marshall.greekfantasy.network.PacketHandler;
import net.marshall.greekfantasy.network.SKeyPressSpawnEntityPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = GreekFantasy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class ClientForgeHandler {
    private static final net.minecraft.network.chat.Component EXAMPLE_KEY_PRESSED =
            Component.translatable("message." + GreekFantasy.MOD_ID + ".example_key_pressed");

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if(keyBindings.INSTANCE.exampleKey.consumeClick() && minecraft.player != null){
            minecraft.player.displayClientMessage(EXAMPLE_KEY_PRESSED, false);

        }
        if(keyBindings.INSTANCE.examplePacketKey.consumeClick() && minecraft.player != null) {
            PacketHandler.sendToServer(new SKeyPressSpawnEntityPacket());
        }
    }
}
