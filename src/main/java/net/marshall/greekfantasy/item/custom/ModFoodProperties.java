package net.marshall.greekfantasy.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties Ambrosia = new FoodProperties.Builder().nutrition(4)
            .saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION,
                    150, 2), 1.0F).effect(new MobEffectInstance(MobEffects.
                    ABSORPTION, 3000, 1), 1.0F).alwaysEat().build();

    public static final FoodProperties GOLDEN_APPLE_OF_IMMORTALITY = new FoodProperties.Builder().nutrition(4)
            .saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.REGENERATION,
                    MobEffectInstance.INFINITE_DURATION, 5), 1.0F).effect(new MobEffectInstance(MobEffects.
                    ABSORPTION, MobEffectInstance.INFINITE_DURATION, 5), 1.0F).alwaysEat().build();

}
