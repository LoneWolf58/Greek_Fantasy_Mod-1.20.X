package net.marshall.greekfantasy.item;

import net.marshall.greekfantasy.GreekFantasy;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GreekFantasy.MODID);

    public static final RegistryObject<Item> TRAIN_TICKET = ITEMS.register("train_ticket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRAIN_OWNER_CARD = ITEMS.register("train_owner_card",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> CELESTIAL_BRONZE_INGOT = ITEMS.register("celestial_bronze_ingot",
            () -> new Item(new Item.Properties().fireResistant()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
