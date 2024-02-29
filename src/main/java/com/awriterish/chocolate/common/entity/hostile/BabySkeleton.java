package com.awriterish.chocolate.common.entity.hostile;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RangedBowAttackGoal;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;

public class BabySkeleton extends Skeleton {
    private int weaponSwitchCoolDown;
    private RangedBowAttackGoal<AbstractSkeleton> bowAttackGoal;
    private MeleeAttackGoal meleeGoal;

    public BabySkeleton(EntityType<? extends Skeleton> entity, Level level) {
        super(entity, level);
        this.animationSpeed *= 2.5f;
    }

    @Override
    public boolean isBaby() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
        return 0.7f;
    }

    @Override
    public double getMyRidingOffset() {
        return 0.0d;
    }

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.WOODEN_SWORD));
        this.setDropChance(EquipmentSlot.OFFHAND, 0.0f);
        if(Math.random() < 0.5){
            this.switchMainAndOffHand();
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(!this.level.isClientSide){
            if(this.weaponSwitchCoolDown > 0) {
                this.weaponSwitchCoolDown--;
            }

            if(this.weaponSwitchCoolDown == 0){
                if(this.getTarget() != null && this.distanceTo(this.getTarget()) < 5.0d){
                    if(this.getMainHandItem().getItem() instanceof BowItem){
                        this.switchMainAndOffHand();
                        this.weaponSwitchCoolDown = 40;
                    }
                } else if((this.getTarget() == null || this.distanceTo(this.getTarget()) > 7.0d) && this.getMainHandItem().getItem() instanceof SwordItem){
                    this.switchMainAndOffHand();
                }
            }
        }
    }

    private void switchMainAndOffHand(){
        ItemStack main = this.getMainHandItem();
        this.setItemInHand(InteractionHand.MAIN_HAND, this.getOffhandItem());
        this.setItemInHand(InteractionHand.OFF_HAND, main);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(!this.level.isClientSide){
            if(meleeGoal == null || bowAttackGoal == null){
                this.bowAttackGoal = new RangedBowAttackGoal<AbstractSkeleton>(this, 1.0d, 40, 15.0f);
                this.meleeGoal = new MeleeAttackGoal(this, 1.2d, false);
            }

            this.goalSelector.removeGoal(meleeGoal);
            this.goalSelector.removeGoal(bowAttackGoal);

            if(this.getMainHandItem().getItem() instanceof BowItem){
                this.goalSelector.addGoal(4, bowAttackGoal);
            } else {
                this.goalSelector.addGoal(4, meleeGoal);
            }
        }
    }

}
