package net.marshall.greekfantasy.datagen.loot;

import net.marshall.greekfantasy.block.ModBlocks;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CELESTIAL_BRONZE_BLOCK.get());

        this.add(ModBlocks.CELESTIAL_BRONZE_ORE.get(),
                block -> createOreDrop(ModBlocks.CELESTIAL_BRONZE_ORE.get(), ModItems.RAW_CELESTIAL_BRONZE.get()));

        this.dropSelf(ModBlocks.TICKET_CHECKER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
