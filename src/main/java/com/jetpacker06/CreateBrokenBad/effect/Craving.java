package com.jetpacker06.CreateBrokenBad.effect;

import com.jetpacker06.CreateBrokenBad.register.AllEffects;
import com.jetpacker06.CreateBrokenBad.register.AllItems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Craving extends MobEffect {
    private final ArrayList<ItemStack> meths = new ArrayList<>();
    public Craving(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
        meths.add(new ItemStack(AllItems.BLUE_METH.get()));
        meths.add(new ItemStack(AllItems.WHITE_METH.get()));
    }

    private final Random rnd = new Random();

    String[] responses = {"fuckkkk, i need meth so bad..",
            "i would literally suck walter off right now",
            "anyone got some meth?",
            "will do anything for meth...",
            "if there was meth in front of me, i'd be really happy",
            "given the option of cock and meth, i'd choose meth, and that says a lot, since i am a cock demon",
            "sell my soul for meth",
            "sell my parents for meth",
            "HAVE: nothing, WANT: meth",
            "lf runescape gf (with meth)",
            "dee and reynolds did crack, why cant i do meth??",
            "my parents dont understand my craving for meth. .. so immature of them",
            "only so many ways to express i want meth: i want meth",
            ":O ¤  (¤ is meth, it's a methaphor)",
            " :O <- insert meth here (meth doesn't have to be everything, as long as it's there)"};

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.level.isClientSide) {
            return;
        }

        boolean lastTick = false;
        for (MobEffectInstance mi : pLivingEntity.getActiveEffects()) {
            if(mi.getEffect() instanceof Craving) {
                lastTick = mi.getDuration() == 1;
            }
        }

        if(lastTick) {
            MobEffectInstance withdrawal = new MobEffectInstance(AllEffects.WITHDRAWAL.get(), 5*20*60, 0);
            withdrawal.setCurativeItems(meths);
            pLivingEntity.addEffect(withdrawal);
        } else {
            pLivingEntity.sendMessage(new TextComponent(responses[rnd.nextInt(responses.length)]), pLivingEntity.getUUID());
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // last tick always needs to run, so that we can start withdrawal effect
        if(pDuration == 1) {
            return true;
        }
        // roughly every 90 seconds
        return rnd.nextInt(90*20) == 1;
    }

    @Override
    protected String getOrCreateDescriptionId() {
        /*if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("effect", Registry.MOB_EFFECT.getKey(this));
        }*/
        return "Craving...";
    }

}
