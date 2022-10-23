package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.entity.BoombleEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

// why CommonModEvents when have AllEvents?
// need bus = Mod.. for registerAttributes, silly :(
@Mod.EventBusSubscriber(modid = CreateBrokenBad.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void commonSetup(SpawnPlacementRegisterEvent event) {
        event.register(AllEntities.BOOMBLE.get(), SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE, BoombleEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.AND);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AllEntities.BOOMBLE.get(), BoombleEntity.createAttributes().build());
    }
}
