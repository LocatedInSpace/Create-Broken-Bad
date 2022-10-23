package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.entity.BoombleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CreateBrokenBad.MOD_ID);

    public static final RegistryObject<EntityType<BoombleEntity>> BOOMBLE = ENTITIES.register("boomble",
            () -> EntityType.Builder.of(BoombleEntity::new, MobCategory.CREATURE).sized(0.7F, 1.6F).build(new ResourceLocation(CreateBrokenBad.MOD_ID, "boomble").toString())  );

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
