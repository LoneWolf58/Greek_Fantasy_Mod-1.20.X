package net.marshall.greekfantasy.fluid;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.block.ModBlocks;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, GreekFantasy.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MOLTEN_CELESTIAL_BRONZE = FLUIDS.register("molten_celestial_bronze_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_CELESTIAL_BRONZE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_CELESTIAL_BRONZE = FLUIDS.register("flowing_molten_celestial_bronze",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_CELESTIAL_BRONZE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_CELESTIAL_BRONZE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.MOLTEN_CELESTIAL_BRONZE_FLUID_TYPE, SOURCE_MOLTEN_CELESTIAL_BRONZE , FLOWING_MOLTEN_CELESTIAL_BRONZE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MOLTEN_CELESTIAL_BRONZE_BLOCK).bucket(ModItems.MOLTEN_CELESTIAL_BRONZE_BUCKET);


    public static final RegistryObject<FlowingFluid> SOURCE_ROUGH_MOLTEN_CELESTIAL_BRONZE = FLUIDS.register("rough_molten_celestial_bronze_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_CELESTIAL_BRONZE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_ROUGH_MOLTEN_CELESTIAL_BRONZE = FLUIDS.register("flowing_rough_molten_celestial_bronze",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_CELESTIAL_BRONZE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties MOLTEN_ROUGH_CELESTIAL_BRONZE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.MOLTEN_CELESTIAL_BRONZE_FLUID_TYPE, SOURCE_MOLTEN_CELESTIAL_BRONZE , FLOWING_MOLTEN_CELESTIAL_BRONZE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.MOLTEN_CELESTIAL_BRONZE_BLOCK).bucket(ModItems.MOLTEN_CELESTIAL_BRONZE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
