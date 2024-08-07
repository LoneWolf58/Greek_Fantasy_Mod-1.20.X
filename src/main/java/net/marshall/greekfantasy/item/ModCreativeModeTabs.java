package net.marshall.greekfantasy.item;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GreekFantasy.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GREEKFANTASY_TAB = CREATIVE_MODE_TABS.register("greekfantasy_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CELESTIAL_BRONZE_INGOT.get()))
                    .title(Component.translatable("creativetab.greekfantasy_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {

                        output.accept(ModItems.CELESTIAL_BRONZE_INGOT.get());
                        output.accept(ModItems.TRAIN_OWNER_CARD.get());
                        output.accept(ModItems.TRAIN_TICKET.get());
                        output.accept(ModItems.CELESTIAL_BRONZE_SWORD.get());

                        output.accept(ModItems.COPPER_DRACHMA.get());
                        output.accept(ModItems.MIXED_GOLD_DRACHMA.get());
                        output.accept(ModItems.PURE_GOLD_DRACHMA.get());
                        output.accept(ModItems.DIAMOND_DRACHMA.get());
                        output.accept(ModItems.EMERALD_DRACHMA.get());

                        output.accept(ModItems.CELESTIAL_BRONZE_LIGHTNING_SWORD.get());

                        output.accept(ModItems.AMBROSIA.get());
                        output.accept(ModItems.GOLDEN_APPLE_OF_IMMORTALITY.get());

                        output.accept(ModBlocks.CELESTIAL_BRONZE_BLOCK.get());
                        output.accept(ModBlocks.CELESTIAL_BRONZE_ORE.get());

                        output.accept(ModBlocks.CELESTIAL_BRONZE_FORGE.get());

                        output.accept(ModItems.MOLTEN_CELESTIAL_BRONZE_BUCKET.get());
                        output.accept(ModItems.ROUGH_MOLTEN_CELESTIAL_BRONZE_BUCKET.get());


                    })).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
