package net.marshall.greekfantasy.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class WitheringSwordItem extends SwordItem {
    public WitheringSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

   @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
            if (entity.level().dimension() == Level.NETHER && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 10), player);
            }
            else if (entity.level().dimension() == Level.OVERWORLD && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 2), player);
            }
            else if (entity.level().dimension() == Level.END && entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 400, 2), player);
            }

            return super.onLeftClickEntity(stack, player, entity);
        }
    }

