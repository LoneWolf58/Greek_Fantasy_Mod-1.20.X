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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_DRACHMA.get())
                .pattern("CCC")
                .pattern("CGC")
                .pattern("CCC")
                .define('G', Items.GOLD_NUGGET)
                .define('C', Items.RAW_COPPER)
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_COPPER).build())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MIXED_GOLD_DRACHMA.get(),5)
                .pattern("GIG")
                .pattern("IGI")
                .pattern("GIG")
                .define('G', Items.GOLD_NUGGET)
                .define('I', Items.IRON_NUGGET)
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_COPPER).build())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURE_GOLD_DRACHMA.get())
                .pattern("GGG")
                .pattern("GIG")
                .pattern("GGG")
                .define('G', Items.GOLD_NUGGET)
                .define('I', Items.GOLD_INGOT)
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_COPPER).build())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_DRACHMA.get())
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', Items.GOLD_NUGGET)
                .define('E', Items.EMERALD)
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_COPPER).build())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_DRACHMA.get())
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('G', Items.GOLD_NUGGET)
                .define('D', Items.DIAMOND)
                .unlockedBy("has_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RAW_COPPER).build())).save(consumer);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CELESTIAL_BRONZE_INGOT.get(), 9)
                .requires(ModBlocks.CELESTIAL_BRONZE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CELESTIAL_BRONZE_BLOCK.get()).build()));

    }
}
