package com.awriterish.chocolate.common.entity.hostile;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class BabyWitherSkeleton extends WitherSkeleton {

    public BabyWitherSkeleton(EntityType<? extends WitherSkeleton> entity, Level level){
        super(entity, level);
        this.animationSpeed *= 2.5;
    }

    @Override
    protected void populateDefaultEquipmentEnchantments(DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntityDimensions size) {
        return 0.95f;
    }
}
