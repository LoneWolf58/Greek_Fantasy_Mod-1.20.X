package net.marshall.greekfantasy;

import com.mojang.logging.LogUtils;
import net.marshall.greekfantasy.block.ModBlocks;
import net.marshall.greekfantasy.block.entity.ModBlockEntities;
import net.marshall.greekfantasy.enchantment.ModEnchantments;
import net.marshall.greekfantasy.events.ModEvents;
import net.marshall.greekfantasy.fluid.ModFluids;
import net.marshall.greekfantasy.fluid.ModFluidsTypes;
import net.marshall.greekfantasy.item.ModCreativeModeTabs;
import net.marshall.greekfantasy.item.ModItems;
import net.marshall.greekfantasy.screen.CelestialBronzeForgeScreen;
import net.marshall.greekfantasy.screen.ModMenuTypes;
import net.minecraft.client.InputType;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.controls.KeyBindsScreen;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;




@Mod(GreekFantasy.MOD_ID)
public class GreekFantasy
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "greekfantasy";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public GreekFantasy()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        ModEnchantments.register(modEventBus);

        ModFluidsTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

           // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.CELESTIAL_BRONZE_FORGE_MENU.get(), CelestialBronzeForgeScreen::new);
        }
    }
}
