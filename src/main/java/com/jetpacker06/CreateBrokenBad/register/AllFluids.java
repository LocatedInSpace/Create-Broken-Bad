package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.fluid.BaseFluidType;
import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jetpacker06.CreateBrokenBad.CreateBrokenBad.MOD_ID;

public class AllFluids {
    public static final ResourceLocation STILL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING = new ResourceLocation("block/water_flow");
    public static final ResourceLocation OVERLAY = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MOD_ID);

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties, final int tint) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(STILL, FLOWING, OVERLAY, tint, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
    }

    //begin fluid 1
    public static final RegistryObject<FlowingFluid> LIQUID_METHAMPHETAMINE
            = FLUIDS.register("liquid_methamphetamine", () -> new ForgeFlowingFluid.Source(AllFluids.METHAMPHETAMINE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> METHAMPHETAMINE_FLOWING
            = FLUIDS.register("liquid_methamphetamine_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.METHAMPHETAMINE_PROPERTIES));

    public static final RegistryObject<LiquidBlock> METHAMPHETAMINE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("liquid_methamphetamine",
            () -> new LiquidBlock(() -> AllFluids.LIQUID_METHAMPHETAMINE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> METHAMPHETAMINE_FLUID = register("liquid_methamphetamine_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties METHAMPHETAMINE_PROPERTIES = new ForgeFlowingFluid.Properties(
            METHAMPHETAMINE_FLUID, LIQUID_METHAMPHETAMINE, METHAMPHETAMINE_FLOWING)
            .block(METHAMPHETAMINE_LIQUID_BLOCK).bucket(AllItems.LIQUID_METHAMPHETAMINE_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 2
    public static final RegistryObject<FlowingFluid> LIQUID_BLUE_METHAMPHETAMINE
            = FLUIDS.register("liquid_blue_methamphetamine", () -> new ForgeFlowingFluid.Source(AllFluids.BLUE_METHAMPHETAMINE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> BLUE_METHAMPHETAMINE_FLOWING
            = FLUIDS.register("liquid_blue_methamphetamine_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.BLUE_METHAMPHETAMINE_PROPERTIES));

    public static final RegistryObject<LiquidBlock> BLUE_METHAMPHETAMINE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("liquid_blue_methamphetamine",
            () -> new LiquidBlock(() -> AllFluids.LIQUID_BLUE_METHAMPHETAMINE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> BLUE_METHAMPHETAMINE_FLUID = register("liquid_blue_methamphetamine_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xbf03d0fc);

    public static final ForgeFlowingFluid.Properties BLUE_METHAMPHETAMINE_PROPERTIES = new ForgeFlowingFluid.Properties(
            BLUE_METHAMPHETAMINE_FLUID, LIQUID_BLUE_METHAMPHETAMINE, BLUE_METHAMPHETAMINE_FLOWING)
            .block(BLUE_METHAMPHETAMINE_LIQUID_BLOCK).bucket(AllItems.LIQUID_BLUE_METHAMPHETAMINE_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 3
    public static final RegistryObject<FlowingFluid> METHYLAMINE
            = FLUIDS.register("methylamine", () -> new ForgeFlowingFluid.Source(AllFluids.METHYLAMINE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> METHYLAMINE_FLOWING
            = FLUIDS.register("methylamine_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.METHYLAMINE_PROPERTIES));

    public static final RegistryObject<LiquidBlock> METHYLAMINE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("methylamine",
            () -> new LiquidBlock(() -> AllFluids.METHYLAMINE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> METHYLAMINE_FLUID = register("methylamine_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties METHYLAMINE_PROPERTIES = new ForgeFlowingFluid.Properties(
            METHYLAMINE_FLUID, METHYLAMINE, METHYLAMINE_FLOWING)
            .block(METHYLAMINE_LIQUID_BLOCK).bucket(AllItems.METHYLAMINE_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 4
    public static final RegistryObject<FlowingFluid> METHANOL
            = FLUIDS.register("methanol", () -> new ForgeFlowingFluid.Source(AllFluids.METHANOL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> METHANOL_FLOWING
            = FLUIDS.register("methanol_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.METHANOL_PROPERTIES));

    public static final RegistryObject<LiquidBlock> METHANOL_LIQUID_BLOCK = AllBlocks.BLOCKS.register("methanol",
            () -> new LiquidBlock(() -> AllFluids.METHANOL.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> METHANOL_FLUID = register("methanol_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties METHANOL_PROPERTIES = new ForgeFlowingFluid.Properties(
            METHANOL_FLUID, METHANOL, METHANOL_FLOWING)
            .block(METHANOL_LIQUID_BLOCK).bucket(AllItems.METHANOL_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 5
    public static final RegistryObject<FlowingFluid> HYDROGEN
            = FLUIDS.register("hydrogen", () -> new ForgeFlowingFluid.Source(AllFluids.HYDROGEN_PROPERTIES));

    public static final RegistryObject<FlowingFluid> HYDROGEN_FLOWING
            = FLUIDS.register("hydrogen_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.HYDROGEN_PROPERTIES));

    public static final RegistryObject<LiquidBlock> HYDROGEN_LIQUID_BLOCK = AllBlocks.BLOCKS.register("hydrogen",
            () -> new LiquidBlock(() -> AllFluids.HYDROGEN.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> HYDROGEN_FLUID = register("hydrogen_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties HYDROGEN_PROPERTIES = new ForgeFlowingFluid.Properties(
            HYDROGEN_FLUID, HYDROGEN, HYDROGEN_FLOWING)
            .block(HYDROGEN_LIQUID_BLOCK).bucket(AllItems.HYDROGEN_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 6
    public static final RegistryObject<FlowingFluid> OXYGEN
            = FLUIDS.register("oxygen", () -> new ForgeFlowingFluid.Source(AllFluids.OXYGEN_PROPERTIES));

    public static final RegistryObject<FlowingFluid> OXYGEN_FLOWING
            = FLUIDS.register("oxygen_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.OXYGEN_PROPERTIES));

    public static final RegistryObject<LiquidBlock> OXYGEN_LIQUID_BLOCK = AllBlocks.BLOCKS.register("oxygen",
            () -> new LiquidBlock(() -> AllFluids.OXYGEN.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> OXYGEN_FLUID = register("oxygen_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties OXYGEN_PROPERTIES = new ForgeFlowingFluid.Properties(
            OXYGEN_FLUID, OXYGEN, OXYGEN_FLOWING)
            .block(OXYGEN_LIQUID_BLOCK).bucket(AllItems.OXYGEN_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 7
    public static final RegistryObject<FlowingFluid> AMMONIA
            = FLUIDS.register("ammonia", () -> new ForgeFlowingFluid.Source(AllFluids.AMMONIA_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> AMMONIA_FLOWING
            = FLUIDS.register("ammonia_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.AMMONIA_PROPERTIES));
    
    public static final RegistryObject<LiquidBlock> AMMONIA_LIQUID_BLOCK = AllBlocks.BLOCKS.register("ammonia",
            () -> new LiquidBlock(() -> AllFluids.AMMONIA.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> AMMONIA_FLUID = register("ammonia_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties AMMONIA_PROPERTIES = new ForgeFlowingFluid.Properties(
            AMMONIA_FLUID, AMMONIA, AMMONIA_FLOWING)
            .block(AMMONIA_LIQUID_BLOCK).bucket(AllItems.AMMONIA_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 8
    public static final RegistryObject<FlowingFluid> PHENYLACETIC_ACID
            = FLUIDS.register("phenylacetic_acid", () -> new ForgeFlowingFluid.Source(AllFluids.PHENYLACETIC_ACID_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> PHENYLACETIC_ACID_FLOWING
            = FLUIDS.register("phenylacetic_acid_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.PHENYLACETIC_ACID_PROPERTIES));
    
    public static final RegistryObject<LiquidBlock> PHENYLACETIC_ACID_LIQUID_BLOCK = AllBlocks.BLOCKS.register("phenylacitic_acid",
            () -> new LiquidBlock(() -> AllFluids.PHENYLACETIC_ACID.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> PHENYLACETIC_ACID_FLUID = register("phenylacitic_acid_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties PHENYLACETIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            PHENYLACETIC_ACID_FLUID, PHENYLACETIC_ACID, PHENYLACETIC_ACID_FLOWING)
            .block(PHENYLACETIC_ACID_LIQUID_BLOCK).bucket(AllItems.PHENYLACETIC_ACID_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 9
    public static final RegistryObject<FlowingFluid> ACETIC_ANHYDRIDE
            = FLUIDS.register("acetic_anhydride", () -> new ForgeFlowingFluid.Source(AllFluids.ACETIC_ANHYDRIDE_PROPERTIES));
    
    public static final RegistryObject<FlowingFluid> ACETIC_ANHYDRIDE_FLOWING
            = FLUIDS.register("acetic_anhydride_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.ACETIC_ANHYDRIDE_PROPERTIES));
    
    public static final RegistryObject<LiquidBlock> ACETIC_ANHYDRIDE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("acetic_anhydride",
            () -> new LiquidBlock(() -> AllFluids.ACETIC_ANHYDRIDE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> ACETIC_ANHYDRIDE_FLUID = register("acetic_anhydride_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties ACETIC_ANHYDRIDE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ACETIC_ANHYDRIDE_FLUID, ACETIC_ANHYDRIDE, ACETIC_ANHYDRIDE_FLOWING)
            .block(ACETIC_ANHYDRIDE_LIQUID_BLOCK).bucket(AllItems.ACETIC_ANHYDRIDE_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //begin fluid 10
    public static final RegistryObject<FlowingFluid> PHENYLACETONE
            = FLUIDS.register("phenylacetone", () -> new ForgeFlowingFluid.Source(AllFluids.PHENYLACETONE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> PHENYLACETONE_FLOWING
            = FLUIDS.register("phenylacetone_flowing", () -> new ForgeFlowingFluid.Flowing(AllFluids.PHENYLACETONE_PROPERTIES));

    public static final RegistryObject<LiquidBlock> PHENYLACETONE_LIQUID_BLOCK = AllBlocks.BLOCKS.register("phenylacetone",
            () -> new LiquidBlock(() -> AllFluids.PHENYLACETONE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noLootTable()));

    public static final RegistryObject<FluidType> PHENYLACETONE_FLUID = register("phenylacetone_fluid",
            FluidType.Properties.create().temperature(300).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).density(2).lightLevel(2).viscosity(5),
            0xffffffff);

    public static final ForgeFlowingFluid.Properties PHENYLACETONE_PROPERTIES = new ForgeFlowingFluid.Properties(
            PHENYLACETONE_FLUID, PHENYLACETONE, PHENYLACETONE_FLOWING)
            .block(PHENYLACETONE_LIQUID_BLOCK).bucket(AllItems.PHENYLACETONE_BUCKET)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    //end fluids
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}