package net.marshall.greekfantasy.network;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.item.ModItems;
import net.marshall.greekfantasy.util.InventoryUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class SKeyPressSpawnEntityPacket {

    public SKeyPressSpawnEntityPacket() {}

    public SKeyPressSpawnEntityPacket(FriendlyByteBuf buffer) {

    }

    public void encode(FriendlyByteBuf buffer) {

    }

    public static SKeyPressSpawnEntityPacket decode(FriendlyByteBuf buffer) {
        return new SKeyPressSpawnEntityPacket(buffer);
    }


    private static final net.minecraft.network.chat.Component WRONG_PLAYER_WEAPON_DENIAL =
            Component.translatable("message." + GreekFantasy.MOD_ID + ".wrong_player_weapon_denial" );

    private static final net.minecraft.network.chat.Component WEAPON_DENIAL =
            Component.translatable("message." + GreekFantasy.MOD_ID + ".weapon_denial");

    private static final net.minecraft.network.chat.Component WEAPON_APPROVAL =
            Component.translatable("message." + GreekFantasy.MOD_ID + ".weapon_approval");


    public static void handle(SKeyPressSpawnEntityPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            Minecraft minecraft = Minecraft.getInstance();
            if (player != null) {
               // if (player.getStringUUID().equals("380df991-f603-344c-a090-369bad2a924a")) {
                    Component.literal("UUID" + player.getStringUUID());
                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.CELESTIAL_BRONZE_LIGHTNING_SWORD.get())) {
                        minecraft.player.displayClientMessage(WEAPON_DENIAL, true);
                    }else {
                        ItemStack itemStack = new ItemStack(ModItems.CELESTIAL_BRONZE_LIGHTNING_SWORD.get());
                        player.getInventory().add(itemStack);
                        minecraft.player.displayClientMessage(WEAPON_APPROVAL, true);


                    }

                //}else {minecraft.player.displayClientMessage(WRONG_PLAYER_WEAPON_DENIAL, true);
                 //   Component.literal("UUID" + player.getStringUUID());
                 //   GreekFantasy.LOGGER.info(String.valueOf(player.getUUID()));
               // }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}