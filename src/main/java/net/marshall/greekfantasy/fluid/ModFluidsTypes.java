package net.marshall.greekfantasy.fluid;

import net.marshall.greekfantasy.GreekFantasy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidsTypes {

    public static final ResourceLocation MOLTEN_CELESTIAL_BRONZE_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation MOLTEN_CELESTIAL_BRONZE_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation MOLTEN_CELESTIAL_BRONZE_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GreekFantasy.MOD_ID);

   public static final RegistryObject<FluidType> MOLTEN_CELESTIAL_BRONZE_FLUID_TYPE = registerFluidType("molten_celestial_bronze_fluid",
           new BaseFluidType(MOLTEN_CELESTIAL_BRONZE_STILL_RL, MOLTEN_CELESTIAL_BRONZE_FLOWING_RL, MOLTEN_CELESTIAL_BRONZE_OVERLAY_RL,
                   0xcd7f32, new Vector3f(205f / 255f, 127f / 255f, 50f / 255f),
                   FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).temperature(500)));

   public static final RegistryObject<FluidType> ROUGH_MOLTEN_CELESTIAL_BRONZE_FLUID_TYPE = registerFluidType("rough_molten_celestial_bronze_fluid",
           new BaseFluidType(MOLTEN_CELESTIAL_BRONZE_STILL_RL, MOLTEN_CELESTIAL_BRONZE_FLOWING_RL, MOLTEN_CELESTIAL_BRONZE_OVERLAY_RL,
                   0xcd7f32, new Vector3f(205f / 255f, 127f / 255f, 50f / 255f),
                   FluidType.Properties.create().lightLevel(2).viscosity(5).density(15).temperature(500)));

    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType){
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
