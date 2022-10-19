package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.effect.Craving;
import com.jetpacker06.CreateBrokenBad.effect.Satisfied;
import com.jetpacker06.CreateBrokenBad.effect.Withdrawal;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, CreateBrokenBad.MOD_ID);

    public static final RegistryObject<MobEffect> SATISFIED = EFFECTS.register("satisfied", () -> new Satisfied(MobEffectCategory.NEUTRAL, 0));
    public static final RegistryObject<MobEffect> CRAVING = EFFECTS.register("craving", () -> new Craving(MobEffectCategory.NEUTRAL, 0));
    public static final RegistryObject<MobEffect> WITHDRAWAL = EFFECTS.register("withdrawal", () -> new Withdrawal(MobEffectCategory.HARMFUL, 0));

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
