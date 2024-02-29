package com.awriterish.chocolate.common.tool;

import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {

    RUBY(3, 386, 12.0f, 1.0f, 25, () -> {return Ingredient.of(ModItems.RUBY.get());});

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float damage;
    private final int enchantability;
    private final Supplier<Ingredient> repair;

    ModItemTier(int harvestLevel, int durability, float efficiency, float damage, int enchantability, Supplier<Ingredient> repair) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.damage = damage;
        this.enchantability = enchantability;
        this.repair = repair;
    }

    @Override
    public int getUses() {
        return durability;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repair.get();
    }
}
