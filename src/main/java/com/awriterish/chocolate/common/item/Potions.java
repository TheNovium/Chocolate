package com.awriterish.chocolate.common.item;

import com.awriterish.chocolate.setup.registration.ModItems;
import com.awriterish.chocolate.setup.registration.ModPotions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public enum Potions {

    POTION_OF_VITALITY_I("Potion of Vitality I", new MobEffectInstance(MobEffects.CONFUSION, 40, 0), new MobEffectInstance(MobEffects.REGENERATION, 3600, 0), new MobEffectInstance(MobEffects.SATURATION, 200, 0)),
    POTION_OF_VITALITY_II("Potion of Vitality II", new MobEffectInstance(MobEffects.CONFUSION, 40, 0), new MobEffectInstance(MobEffects.REGENERATION, 9600, 0), new MobEffectInstance(MobEffects.SATURATION, 400, 0));

    private final Potion potion;

    Potions(String name, MobEffectInstance... effects){
        potion = new Potion(name, effects);
    }

    public Potion getPotion(){
        return potion;
    }

    public static void registerPotions(){
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION, 1), Potion.byName("awkward potion"))), Ingredient.of(ModItems.RUBY.get()), PotionUtils.setPotion(new ItemStack(Items.POTION, 1), ModPotions.POTION_OF_VITALITY_I.get())));
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION, 1), ModPotions.POTION_OF_VITALITY_I.get())), Ingredient.of(Items.REDSTONE), PotionUtils.setPotion(new ItemStack(Items.POTION, 1), ModPotions.POTION_OF_VITALITY_II.get())));
    }
}
