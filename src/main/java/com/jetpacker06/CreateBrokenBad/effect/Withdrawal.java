package com.jetpacker06.CreateBrokenBad.effect;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
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
            "mom, please dont leave me like this, please",
            "it's getting dark out, huh...",
            "what a way to go for me, methheads prosper in death...",
            "WHERE THE FUCK IS THE METH",
            "YOU SONS OF BITCHES, I WILL KILL ALL OF YOU",
            "IF YOU HAVE CHILDREN - YOU WILL NOT SOON",
            ";-;",
            "goodbye everyone, don't wait up"};

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level.isClientSide) {
            return;
        }
        pLivingEntity.sendMessage(new TextComponent(responses[rnd.nextInt(responses.length)]), pLivingEntity.getUUID());

        /*if (this == MobEffects.REGENERATION) {
            if (pLivingEntity.getHealth() < pLivingEntity.getMaxHealth()) {
                pLivingEntity.heal(1.0F);
            }
        } else if (this == MobEffects.POISON) {
            if (pLivingEntity.getHealth() > 1.0F) {
                pLivingEntity.hurt(DamageSource.MAGIC, 1.0F);
            }
        } else if (this == MobEffects.WITHER) {
            pLivingEntity.hurt(DamageSource.WITHER, 1.0F);
        } else if (this == MobEffects.HUNGER && pLivingEntity instanceof Player) {
            ((Player)pLivingEntity).causeFoodExhaustion(0.005F * (float)(pAmplifier + 1));
        } else if (this == MobEffects.SATURATION && pLivingEntity instanceof Player) {
            if (!pLivingEntity.level.isClientSide) {
                ((Player)pLivingEntity).getFoodData().eat(pAmplifier + 1, 1.0F);
            }
        } else if ((this != MobEffects.HEAL || pLivingEntity.isInvertedHealAndHarm()) && (this != MobEffects.HARM || !pLivingEntity.isInvertedHealAndHarm())) {
            if (this == MobEffects.HARM && !pLivingEntity.isInvertedHealAndHarm() || this == MobEffects.HEAL && pLivingEntity.isInvertedHealAndHarm()) {
                pLivingEntity.hurt(DamageSource.MAGIC, (float)(6 << pAmplifier));
            }
        } else {
            pLivingEntity.heal((float)Math.max(4 << pAmplifier, 0));
        }*/
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
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
