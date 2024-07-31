package net.marshall.greekfantasy.datagen;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, GreekFantasy.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.LAVA)
                .add(ModFluids.SOURCE_MOLTEN_CELESTIAL_BRONZE.get())
                .add(ModFluids.FLOWING_MOLTEN_CELESTIAL_BRONZE.get())

                .add(ModFluids.SOURCE_ROUGH_MOLTEN_CELESTIAL_BRONZE.get())
                .add(ModFluids.FLOWING_ROUGH_MOLTEN_CELESTIAL_BRONZE.get());
    }
}
