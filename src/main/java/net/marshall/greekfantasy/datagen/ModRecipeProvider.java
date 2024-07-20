package net.marshall.greekfantasy.datagen;

import net.marshall.greekfantasy.block.ModBlocks;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MIXED_GOLD_DRACHMA.get())
                .pattern("GIG")
                .pattern("IGI")
                .pattern("GIG")
                .define('G', Items.GOLD_NUGGET)
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_GOLD).build())).save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CELESTIAL_BRONZE_INGOT.get(), 9)
                .requires(ModBlocks.CELESTIAL_BRONZE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CELESTIAL_BRONZE_BLOCK.get()).build()));

    }
}
