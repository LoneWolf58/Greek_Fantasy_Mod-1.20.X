package net.marshall.greekfantasy.datagen;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.ResourceLocationException;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GreekFantasy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AMBROSIA);
        simpleItem(ModItems.CELESTIAL_BRONZE_INGOT);
        simpleItem(ModItems.GOLDEN_APPLE_OF_IMMORTALITY);

        simpleItem((ModItems.RAW_CELESTIAL_BRONZE));

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GreekFantasy.MODID, "item/" + item.getId().getPath()));
    }
}
