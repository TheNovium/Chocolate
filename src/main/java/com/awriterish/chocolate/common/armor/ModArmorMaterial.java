package com.awriterish.chocolate.common.armor;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    CRAB(Chocolate.MODID + ":crab", 11, new int[]{1, 0, 0, 0}, 10, 0f, () -> {return Ingredient.of(ModItems.CRAB_CLAW.get());}, SoundEvents.ARMOR_EQUIP_TURTLE),
    RUBY(Chocolate.MODID + ":ruby", 12, new int[]{3, 5, 8, 2}, 28, 2.5f, () -> { return Ingredient.of(ModItems.RUBY.get()); }, SoundEvents.ARMOR_EQUIP_GENERIC);

    private static final int[] MAX_DAMAGE = new int[] {11, 16, 15, 13};
    private final String name;
    private final int damageFactor;
    private final int[] damageReduction;
    private final int enchantability;
    private final float toughness;
    private final Supplier<Ingredient> repairIngredient;
    private final SoundEvent equipSound;
    private final float knockbackResistance;

    ModArmorMaterial(String name, int damageFactor, int[] damageReduction, int enchantability, float toughness, Supplier<Ingredient> repairIngredient, SoundEvent equipSound) {
        this.name = name;
        this.damageFactor = damageFactor;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.toughness = toughness;
        this.repairIngredient = repairIngredient;
        this.equipSound = equipSound;
        knockbackResistance = 0.0f;
    }


    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return MAX_DAMAGE[slot.getIndex()] * damageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return damageReduction[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
