package net.marshall.greekfantasy.item;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.fluid.ModFluids;
import net.marshall.greekfantasy.item.custom.LightningStrikerSword;
import net.marshall.greekfantasy.item.custom.ModFoodProperties;
import net.marshall.greekfantasy.item.custom.WitheringSwordItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GreekFantasy.MOD_ID);

    public static final RegistryObject<Item> TRAIN_TICKET = ITEMS.register("train_ticket",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TRAIN_OWNER_CARD = ITEMS.register("train_owner_card",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> CELESTIAL_BRONZE_INGOT = ITEMS.register("celestial_bronze_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RAW_CELESTIAL_BRONZE = ITEMS.register("raw_celestial_bronze",
            () -> new Item(new Item.Properties().fireResistant()));


    public static final RegistryObject<Item> AMBROSIA = ITEMS.register("ambrosia",
            () -> new Item(new Item.Properties().food(ModFoodProperties.Ambrosia)));

    public static final RegistryObject<Item> GOLDEN_APPLE_OF_IMMORTALITY = ITEMS.register("golden_apple_of_immortality",
            () -> new Item(new Item.Properties().fireResistant().food(ModFoodProperties.GOLDEN_APPLE_OF_IMMORTALITY)));

    public static final RegistryObject<Item> CELESTIAL_BRONZE_SWORD = ITEMS.register("celestial_bronze_sword",
            () -> new WitheringSwordItem(ModToolTiers.CELESTIAL_BRONZE, 5, 3f,
                    new Item.Properties().durability(500)));

    public static final RegistryObject<Item> CELESTIAL_BRONZE_LIGHTNING_SWORD = ITEMS.register("celestial_bronze_lightning_sword",
            () -> new LightningStrikerSword(ModToolTiers.CELESTIAL_BRONZE, 5, 3f,
                    new Item.Properties().durability(500)));

    public static final RegistryObject<Item> COPPER_DRACHMA = ITEMS.register("copper_drachma",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> MIXED_GOLD_DRACHMA = ITEMS.register("mixed_gold_drachma",
            () -> new Item(new Item.Properties().fireResistant()));


    public static final RegistryObject<Item> PURE_GOLD_DRACHMA = ITEMS.register("pure_gold_drachma",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> DIAMOND_DRACHMA = ITEMS.register("diamond_drachma",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> EMERALD_DRACHMA = ITEMS.register("emerald_drachma",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> CELESTIAL_BRONZE_SLAG = ITEMS.register("celestial_bronze_slag",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> MOLTEN_CELESTIAL_BRONZE_BUCKET = ITEMS.register("molten_celestial_bronze_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_CELESTIAL_BRONZE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> ROUGH_MOLTEN_CELESTIAL_BRONZE_BUCKET = ITEMS.register("rough_molten_celestial_bronze_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MOLTEN_CELESTIAL_BRONZE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
