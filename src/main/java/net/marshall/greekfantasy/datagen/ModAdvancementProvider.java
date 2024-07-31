package net.marshall.greekfantasy.datagen;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.CELESTIAL_BRONZE_INGOT.get()),
                        Component.literal("Greek Fantasy"), Component.literal("Celestial Castaways"),
                        new ResourceLocation(GreekFantasy.MOD_ID, "textures/block/celestial_bronze_ore.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_celestial_bronze", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.CELESTIAL_BRONZE_INGOT.get()))
                .save(saver, new ResourceLocation(GreekFantasy.MOD_ID, "greekfantasy"), existingFileHelper);
    }

}
