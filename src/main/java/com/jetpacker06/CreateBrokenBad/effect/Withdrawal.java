package com.jetpacker06.CreateBrokenBad.effect;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.Random;

public class Withdrawal extends MobEffect {
    public Withdrawal(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    private final Random rnd = new Random();

    String[] responses = {"i can feel death",
            "he is here soon, he knocks on my door.. i dont want it",
            "please.. im so scared",
            "i can feel it approaching",
            "anyone, please, anyone, help me",
            "i dont want to die",
            "WHERE THE FUCK IS THE METH",
            "YOU SONS OF BITCHES, I WILL KILL ALL OF YOU",
            "IF YOU HAVE CHILDREN - YOU WILL NOT SOON",
            ";-;"};

    String[] deathResponses = {
            "mom, please dont leave me like this, please",
            "it's getting dark out, huh...",
            "what a way to go for me, methheads prosper in death...",
            "goodbye everyone, don't wait up"};

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level.isClientSide) {
            return;
        }
        boolean lastTick = false;
        for (MobEffectInstance mi : pLivingEntity.getActiveEffects()) {
            if(mi.getEffect() instanceof Withdrawal) {
                lastTick = mi.getDuration() == 1;
            }
        }

        if(lastTick) {
            pLivingEntity.sendMessage(new TextComponent(deathResponses[rnd.nextInt(responses.length)]), pLivingEntity.getUUID());
            pLivingEntity.kill();
        } else {
            pLivingEntity.sendMessage(new TextComponent(responses[rnd.nextInt(responses.length)]), pLivingEntity.getUUID());
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20*20, 1));
            }
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20*20, 2));
            }
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20*20, 2));
            }
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20*20, 2));
            }
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 20*20, 2));
            }
            if(rnd.nextBoolean()) {
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20*20, 1));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // last tick always runs, for causing instant death
        if(pDuration == 1) {
            return true;
        }

        // roughly every 60 seconds
        return rnd.nextInt(60*20) == 1;
    }

    @Override
    protected String getOrCreateDescriptionId() {
        /*if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("effect", Registry.MOB_EFFECT.getKey(this));
        }*/
        return "Withdrawal";
    }

}
