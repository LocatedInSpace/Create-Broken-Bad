package com.jetpacker06.CreateBrokenBad.effect;

import com.jetpacker06.CreateBrokenBad.FakeChat;
import com.jetpacker06.CreateBrokenBad.register.AllEffects;
import com.jetpacker06.CreateBrokenBad.register.AllItems;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class Satisfied extends MobEffect {
    private final ArrayList<ItemStack> meths = new ArrayList<>();
    public Satisfied(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level.isClientSide) {
            return;
        }
        if(meths.isEmpty()) {
            meths.add(new ItemStack(AllItems.BLUE_METH::get));
            meths.add(new ItemStack(AllItems.WHITE_METH::get));
            // boombleberry can cure addiction
            meths.add(new ItemStack(AllItems.BOOMBLEBERRY::get));
        }
        FakeChat.SendFakeChat((ServerPlayer) pLivingEntity, "Some more meth would be nice...");

        MobEffectInstance craving = new MobEffectInstance(AllEffects.CRAVING.get(), 15*20*60, 0);
        craving.setCurativeItems(meths);
        pLivingEntity.addEffect(craving);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return pDuration == 1;
    }
}
