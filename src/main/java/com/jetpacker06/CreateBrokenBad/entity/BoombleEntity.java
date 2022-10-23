package com.jetpacker06.CreateBrokenBad.entity;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.jetpacker06.CreateBrokenBad.register.AllSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BoombleEntity extends Animal {
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(CreateBrokenBad.MOD_ID,
            "entities/boomble");
    private static final Random rnd = new Random();

    public BoombleEntity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 9.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 26.0F, 2.0D, 4.0D));
        //this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 30.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 42D)
                .add(Attributes.MOVEMENT_SPEED, 3.0D);
    }

    public static boolean canSpawn(EntityType<BoombleEntity> entity, LevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, Random random) {
        return rnd.nextInt(100) == 42;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LOOT_TABLE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return AllSoundEvents.BOOMBLELIVE.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AllSoundEvents.BOOMBLEDIE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return AllSoundEvents.BOOMBLEHIT.get();
    }
}
