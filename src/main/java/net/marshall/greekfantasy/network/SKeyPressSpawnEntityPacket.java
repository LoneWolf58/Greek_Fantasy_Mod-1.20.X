package net.marshall.greekfantasy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SKeyPressSpawnEntityPacket {

    public SKeyPressSpawnEntityPacket(){}

    public SKeyPressSpawnEntityPacket(FriendlyByteBuf buffer){}

    public void encode(FriendlyByteBuf buffer) {}

    public void handle(NetworkEvent.ServerCustomPayloadEvent.Context context){
        ServerPlayer player = context.getSender();
        ServerLevel level = ((ServerLevel) player.level());
        BlockPos position = player.blockPosition();

        EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, position,
                MobSpawnType.TRIGGERED, true, true);
    }
}