package net.marshall.greekfantasy.item;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier CELESTIAL_BRONZE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2000, 9f, 3f, 26,
                    ModTags.Blocks.NEEDS_CELESTIAL_BRONZE_TOOL, () -> Ingredient.of(ModItems.CELESTIAL_BRONZE_INGOT.get())),
            new ResourceLocation(GreekFantasy.MOD_ID, "alexandrite"), List.of(Tiers.NETHERITE), List.of());

}
