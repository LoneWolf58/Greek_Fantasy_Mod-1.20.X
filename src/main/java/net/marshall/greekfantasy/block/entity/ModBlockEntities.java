package net.marshall.greekfantasy.block.entity;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GreekFantasy.MOD_ID);

    public static final RegistryObject<BlockEntityType<CelestialBronzeForgeBlockEntity>> CELESTIAL_BRONZE_FORGE_BE =
            BLOCK_ENTITIES.register("celestial_bronze_forge_block_entity", () ->
                    BlockEntityType.Builder.of(CelestialBronzeForgeBlockEntity::new,
                            ModBlocks.CELESTIAL_BRONZE_FORGE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
