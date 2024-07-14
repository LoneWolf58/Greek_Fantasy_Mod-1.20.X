package net.marshall.greekfantasy.item.custom;

import net.marshall.greekfantasy.GreekFantasy;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LightningStrikerSword extends SwordItem {
    public LightningStrikerSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    public static int charge;

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {

        if (player.level().isClientSide) {
            if (entity.level().dimension() == Level.NETHER && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 2), player);

                charge++;
            } else if (entity.level().dimension() == Level.OVERWORLD && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 10), player);

                charge++;
            } else if (entity.level().dimension() == Level.END && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 2), player);

                charge++;
            }

            return super.onLeftClickEntity(stack, player, entity);
        }

        return false;
    }




    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        Vec3 vec3 = pPlayer.getEyePosition().subtract(this.());
        if (pPlayer.level().isClientSide) {
            if (charge > 20) {
                EntityType.LIGHTNING_BOLT.spawn(pLevel, null, null, blockPlayerIsLookingAt(pLevel, pPlayer, 90), MobSpawnType.TRIGGERED, true, true);
                GreekFantasy.LOGGER.info("Sword was used");
                charge = charge - 20;
            } else {
                GreekFantasy.LOGGER.info("Not Enough Charge!");
            }


            return super.use(pLevel, pPlayer, pUsedHand);
        }
        return null;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

       pTooltipComponents.add(Component.literal("Charge: " + charge));

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