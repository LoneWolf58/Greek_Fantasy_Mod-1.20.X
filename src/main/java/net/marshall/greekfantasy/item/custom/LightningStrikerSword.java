package net.marshall.greekfantasy.item.custom;

import net.marshall.greekfantasy.GreekFantasy;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningStrikerSword extends SwordItem {
    public LightningStrikerSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
     //sword fires only when it has the right amount of charge
    public static int charge;
    public static int superCharge;

    //adds whither effect and builds charge


    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(!player.level().isClientSide()) {
            ServerLevel level = ((ServerLevel) player.level());
            BlockPos position = entity.blockPosition();

            charge ++;

            if(charge > 0) {
                EntityType.LIGHTNING_BOLT.spawn(level, null, (Player)null, position,
                        MobSpawnType.TRIGGERED, true, true);
            }
        }

        return super.onLeftClickEntity(stack, player, entity);


    }

    // it is supposed to summon lightning wherever the player is looking by right-clicking
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

if (Screen.hasShiftDown()){
        if (!pPlayer.level().isClientSide) {
            ServerLevel level = ((ServerLevel) pPlayer.level());
            BlockPos playerPosition = pPlayer.blockPosition();
            EntityType.LIGHTNING_BOLT.spawn(level, null, (Player) null, playerPosition,
                    MobSpawnType.TRIGGERED, true, true);
        }
    }

            //if (!pPlayer.level().isClientSide()) {
             //   ServerLevel level = ((ServerLevel) pPlayer.level());
              //  BlockPos position = blockPlayerIsLookingAt(level, pPlayer, 10);
             //   BlockPos playerPosition = pPlayer.blockPosition();

                //if (charge >= 1) {
//                        MobSpawnType.TRIGGERED, true, true);
                //      charge = charge - 1;
                //     }





        return super.use(pLevel, pPlayer, pUsedHand);

    }



    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

       pTooltipComponents.add(Component.literal("Charge: " + charge));
        pTooltipComponents.add(Component.literal("Super Charge: " + superCharge));

       super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


    public static BlockPos blockPlayerIsLookingAt(Level level, Player player, double maxDistance)
    {
        Vec3 eyePos = player.getEyePosition(1f);
        // the ray of the player's view, extended to the max distance
        Vec3 viewVector = player.getViewVector(1f).scale(maxDistance);
        // find the collision from eye pos to max position on the line
        BlockHitResult hitResult = level.clip(new ClipContext(
                eyePos, eyePos.add(viewVector), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        return hitResult.getBlockPos();
    }



}