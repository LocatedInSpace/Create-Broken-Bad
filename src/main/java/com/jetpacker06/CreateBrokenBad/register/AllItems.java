package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.item.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateBrokenBad.MOD_ID);
    //drop from boomble that cures addiction
    public static final FoodProperties CURE_METH = (new FoodProperties.Builder()).nutrition(0).saturationMod(0)
            .alwaysEat().build();
    public static final RegistryObject<Item> BOOMBLEBERRY = ITEMS.register("boombleberry", () -> new BoombleBerryItem(new Item.Properties().tab(ItemGroup.CREATEBB).food(CURE_METH)));
    public static final RegistryObject<ForgeSpawnEggItem> BOOMBLE_SPAWNEGG = ITEMS.register("boomble_spawn_egg", () -> new ForgeSpawnEggItem(AllEntities.BOOMBLE, 0x348ceb, 0xffffff, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    //begin items
    public static final FoodProperties GOOD_METH = (new FoodProperties.Builder()).nutrition(0).saturationMod(0)
        // good effects
        .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30*20, 4), 1.0F)
        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60*20, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60*20*60, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.REGENERATION, 5*20, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.SATURATION, 5*20, 1), 1.0F)
        // bad effects
        .effect(new MobEffectInstance(MobEffects.HUNGER, 15*20, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.BLINDNESS, 1*20, 1), 1.0F)
        // my effects >:)
        .effect(() -> {
            MobEffectInstance r = new MobEffectInstance(AllEffects.SATISFIED.get(), 60*20*60, 1);
            r.setCurativeItems(new ArrayList<>(List.of(new ItemStack(BOOMBLEBERRY.get()))));
            return r;
        }, 1.0F)
        .alwaysEat().build();

    public static final FoodProperties BAD_METH = (new FoodProperties.Builder()).nutrition(0).saturationMod(0)
        // good effects
        .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15*20, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 30*20, 1), 1.0F)
        .effect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*20*60, 1), 1.0F)
        .effect(new MobEffectInstance(MobEffects.REGENERATION, 5*20, 1), 1.0F)
        .effect(new MobEffectInstance(MobEffects.SATURATION, 5*20, 1), 1.0F)
        // bad effects
        .effect(new MobEffectInstance(MobEffects.HUNGER, 20*20, 2), 1.0F)
        .effect(new MobEffectInstance(MobEffects.BLINDNESS, 3*20, 2), 1.0F)
        // my effects >:)
        .effect(() -> {
            MobEffectInstance r = new MobEffectInstance(AllEffects.SATISFIED.get(), 15*20*60, 0);
            r.setCurativeItems(new ArrayList<>(List.of(new ItemStack(BOOMBLEBERRY.get()))));
            return r;
        }, 1.0F)
        .alwaysEat().build();

    public static final RegistryObject<Item>
    MATCH = ITEMS.register("match", () -> new MatchItem(new Item.Properties().tab(ItemGroup.CREATEBB))),
    PSEUDOPHEDRINE = ingredient("pseudophedrine"),
    SUDAFED = ITEMS.register("sudafed", () -> new SudafedItem(new Item.Properties().tab(ItemGroup.CREATEBB).food(new FoodProperties.Builder().alwaysEat().build()))),
    SUDAFED_BOX = ITEMS.register("sudafed_box", () -> new SudafedBoxItem(new Item.Properties().tab(ItemGroup.CREATEBB))),
    EPHEDRA = ITEMS.register("ephedra", () -> new EphedraItem(new Item.Properties().tab(ItemGroup.CREATEBB))),
    EPHEDRA_SEEDS = ITEMS.register("ephedra_seeds", () -> new ItemNameBlockItem(AllBlocks.EPHEDRA_CROP_BLOCK.get(), new Item.Properties().tab(ItemGroup.CREATEBB))),
    WHITE_PHOSPHORUS = ingredient("white_phosphorus"),
    RED_PHOSPHORUS = ingredient("red_phosphorus"),
    BRINE = ingredient("brine"),
    IODINE = ingredient("iodine"),
    //WHITE_METH = ITEMS.register("white_meth", () -> new MethItem.White(new Item.Properties().tab(ItemGroup.CREATEBB))),
    WHITE_METH = ITEMS.register("white_meth", () -> new MethItem.White(new Item.Properties().tab(ItemGroup.CREATEBB).food(BAD_METH))),

    CRUSHED_COPPER = ingredient("crushed_copper"),
    CRUSHED_ZINC = ingredient("crushed_zinc"),
    COPPER_ZINC_CATALYST = ITEMS.register("copper_zinc_catalyst", () -> new NonConsumedCatalystItem(new Item.Properties().stacksTo(1).tab(ItemGroup.CREATEBB))),
    CYANIDE = ingredient("cyanide"),
    ALUMINOSILICATE_CATALYST = ITEMS.register("aluminosilicate_catalyst", () -> new NonConsumedCatalystItem(new Item.Properties().stacksTo(1).tab(ItemGroup.CREATEBB))),
    ALUMINOSILICATE_BIT = ingredient("aluminosilicate_bit"),
    ALUMINOSILICATE_CHUNK = ingredient("aluminosilicate_chunk"),
    NITROGEN = ingredient("nitrogen"),
    //public static final Item APPLE = registerItem("apple", new Item((new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(Foods.APPLE)));
    //BLUE_METH = ITEMS.register("blue_meth", () -> new MethItem.Blue(new Item.Properties().tab(ItemGroup.CREATEBB))),
    BLUE_METH = ITEMS.register("blue_meth", () -> new MethItem.Blue(new Item.Properties().tab(ItemGroup.CREATEBB).food(GOOD_METH))),


    LIQUID_METHAMPHETAMINE_BUCKET = bucket("liquid_methamphetamine_bucket", AllFluids.LIQUID_METHAMPHETAMINE),
    LIQUID_BLUE_METHAMPHETAMINE_BUCKET = bucket("liquid_blue_methamphetamine_bucket", AllFluids.LIQUID_BLUE_METHAMPHETAMINE),
    METHYLAMINE_BUCKET = bucket("methylamine_bucket", AllFluids.METHYLAMINE),
    METHANOL_BUCKET = bucket("methanol_bucket", AllFluids.METHANOL),
    HYDROGEN_BUCKET = bucket("hydrogen_bucket", AllFluids.HYDROGEN),
    OXYGEN_BUCKET = bucket("oxygen_bucket", AllFluids.OXYGEN),
    AMMONIA_BUCKET = bucket("ammonia_bucket", AllFluids.AMMONIA),
    PHENYLACETIC_ACID_BUCKET = bucket("phenylacetic_acid_bucket", AllFluids.PHENYLACETIC_ACID),
    ACETIC_ANHYDRIDE_BUCKET = bucket("acetic_anhydride_bucket", AllFluids.ACETIC_ANHYDRIDE),
    PHENYLACETONE_BUCKET = bucket("phenylacetone_bucket", AllFluids.PHENYLACETONE);

    //end items
    public static RegistryObject<Item> ingredient(String name) {
        return ingredient(name, new Item.Properties().tab(ItemGroup.CREATEBB));
    }
    public static RegistryObject<Item> bucket(String name, RegistryObject<FlowingFluid> fluid) {
        return ITEMS.register(name, () -> new BucketItem(fluid, new Item.Properties().tab(ItemGroup.CREATEBB).craftRemainder(Items.BUCKET)));
    }
    public static RegistryObject<Item> ingredient(String name, Item.Properties pProperties) {
        return ITEMS.register(name, () -> new Item(pProperties));
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}