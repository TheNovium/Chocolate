package com.awriterish.chocolate.common.entity.neutral;

import com.awriterish.chocolate.setup.registration.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.Predicate;

public class Crab extends Animal implements NeutralMob {

    private static final EntityDataAccessor<String> COLOR = SynchedEntityData.defineId(Crab.class, EntityDataSerializers.STRING);

    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.KELP, Items.INK_SAC, Items.GLOW_INK_SAC);

    private static final UniformInt ANGER_TIME = TimeUtil.rangeOfSeconds(10, 20);
    private int remainingAngerTime;
    @Nullable
    private UUID angerTarget;

    public Crab(EntityType<Crab> animal, Level level) {
        super(animal, level);
        double rand = Math.random();
        if(rand<0.01){
            this.entityData.define(COLOR, "purple");
        } else if(rand<0.1){
            this.entityData.define(COLOR, "green");
        } else if(rand<0.2){
            this.entityData.define(COLOR, "blue");
        } else if(rand<0.4){
            this.entityData.define(COLOR, "red");
        } else {
            this.entityData.define(COLOR, "pink");
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Crab.CrabPinchGoal());
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(1, new Crab.CrabHurtByTargetGoal());
        this.goalSelector.addGoal(2, new TemptGoal(this, 0.7, FOOD_ITEMS, false));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.5, 20));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new MoveToBlockGoal(this, 1, 10) {
            @Override
            protected boolean isValidTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos) {
                return pLevel.getBlockState(pPos).getBlock().equals(Blocks.SAND);
            }
        });
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 5.0F));
        this.goalSelector.addGoal(5, new Crab.CrabPinchPlayerGoal());
        this.goalSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COD_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    public Crab getBreedOffspring(ServerLevel level, AgeableMob mob){
        return ModEntities.CRAB.get().create(level);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    public boolean isFood(ItemStack item){
        return FOOD_ITEMS.test(item);
    }

    @Override
    public boolean isSensitiveToWater() {
        return false;
    }

    @Override
    public boolean wantsToPickUp(ItemStack item) {
        return FOOD_ITEMS.test(item);
    }

    @Override
    public float getScale(){
        return this.isBaby() ? 0.2F : 0.6F;
    }

    public String getColor(){
        return this.entityData.get(COLOR);
    }

    public boolean doHurtTarget(Entity entity) {
        boolean flag = entity.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
        if (flag) {
            this.doEnchantDamageEffects(this, entity);
        }

        return flag;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.readPersistentAngerSaveData(this.level, pCompound);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        this.addPersistentAngerSaveData(pCompound);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        //this.entityData.define(COLOR, "pink");
    }

    public static AttributeSupplier.Builder prepareAttributes(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.MAX_HEALTH, 4.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.FOLLOW_RANGE, 20);
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        this.remainingAngerTime = pTime;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return angerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pTarget) {
        this.angerTarget = pTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(ANGER_TIME.sample(this.random));
    }

    class CrabPinchGoal extends MeleeAttackGoal {
        public CrabPinchGoal(){
            super(Crab.this, 1.4, false);
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
            double d0 = this.getAttackReachSqr(pEnemy);
            if(pDistToEnemySqr <= d0 && this.isTimeToAttack()){
                this.resetAttackCooldown();
                this.mob.doHurtTarget(pEnemy);
                setRemainingPersistentAngerTime(0);
            }
        }

        @Override
        protected double getAttackReachSqr(LivingEntity pAttackTarget) {
            return (double)(4.0f + pAttackTarget.getBbWidth());
        }
    }

    class CrabPinchPlayerGoal extends NearestAttackableTargetGoal<Player> {
        public CrabPinchPlayerGoal() {
            super(Crab.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
        }

        public boolean canUse() {
            if (!Crab.this.isBaby()) {
                if (super.canUse()) {
                    for (Crab crab : Crab.this.level.getEntitiesOfClass(Crab.class, Crab.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
                        if (crab.isBaby()) {
                            return true;
                        }
                    }
                }

            }
            return false;
        }

        protected double getFollowDistance() {
            return super.getFollowDistance() * 0.5D;
        }
    }

    class CrabHurtByTargetGoal extends HurtByTargetGoal {
        public CrabHurtByTargetGoal() {
            super(Crab.this);
        }

        public void start() {
            super.start();
            if (Crab.this.isBaby()) {
                this.alertOthers();
                this.stop();
            }

        }

        protected void alertOther(Mob pMob, LivingEntity pTarget) {
            if (pMob instanceof Crab && !pMob.isBaby()) {
                super.alertOther(pMob, pTarget);
            }

        }
    }
}
