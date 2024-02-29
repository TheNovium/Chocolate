package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.block.BarrelOfBlock;
import com.awriterish.chocolate.setup.ModSetup;
import com.awriterish.chocolate.setup.registration.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ChocolateLanguageProvider extends LanguageProvider {
    public ChocolateLanguageProvider(DataGenerator gen, String locale){
        super(gen, Chocolate.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + ModSetup.TAB, "Chocolate");

        add(ModPotions.POTION_OF_VITALITY_I.get().getName("item.minecraft.potion.effect."), "Potion of Vitality");
        add(ModPotions.POTION_OF_VITALITY_II.get().getName("item.minecraft.potion.effect."), "Potion of Vitality+");

        add(ModEntities.BABY_SKELETON.get(), "Baby Skeleton");
        add(ModItems.BABY_SKELETON_SPAWN_EGG.get(), "Baby Skeleton Spawn Egg");
        add(ModEntities.BABY_STRAY.get(), "Baby Stray");
        add(ModItems.BABY_STRAY_SPAWN_EGG.get(), "Baby Stray Spawn Egg");
        add(ModEntities.BABY_WITHER_SKELETON.get(), "Baby Wither Skeleton");
        add(ModItems.BABY_WITHER_SKELETON_SPAWN_EGG.get(), "Baby Wither Skeleton Spawn Egg");
        add(ModEntities.CRAB.get(), "Crab");
        add(ModItems.CRAB_SPAWN_EGG.get(), "Crab Spawn Egg");

        add(ModEffects.DEPTH_STRIDER.get(), "Depth Strider");

        //add(ModItems.BARREL_OF_ITEM.get(), "Barrel Of");
        add(ModItems.CARROT_CAKE_ITEM.get(), "Carrot Cake");
        add(ModItems.COOKED_CRAB_MEAT.get(), "Cooked Crab Meat");
        add(ModItems.CRAB_BOOTS.get(), "Crab Shell Boots");
        add(ModItems.CRAB_CLAW.get(), "Crab Claw");
        add(ModBlocks.END_STONE_RUBY_ORE.get(), "End Stone Ruby Ore");
        add(ModBlocks.PURPLE_MUSHROOM_BLOCK.get(), "Purple Mushroom Block");
        add(ModItems.PURPLE_MUSHROOM.get(), "Purple Mushroom");
        add(ModItems.RAW_CRAB_MEAT.get(), "Raw Crab Meat");
        add(ModBlocks.REDSTONE_GATE.get(), "Redstone Gate");
        add(ModItems.RICE.get(), "Rice");
        add(ModItems.RUBY.get(), "Ruby");
        add(ModItems.RUBY_AXE.get(), "Ruby Axe");
        add(ModBlocks.RUBY_BLOCK.get(), "Block of Ruby");
        add(ModItems.RUBY_BOOTS.get(), "Ruby Boots");
        add(ModItems.RUBY_CHESTPLATE.get(), "Ruby Chest Plate");
        add(ModItems.RUBY_HELMET.get(), "Ruby Helmet");
        add(ModItems.RUBY_HOE.get(), "Ruby Hoe");
        add(ModItems.RUBY_LEGGINGS.get(), "Ruby Leggings");
        add(ModItems.RUBY_PICKAXE.get(), "Ruby Pickaxe");
        add(ModItems.RUBY_SHOVEL.get(), "Ruby Shovel");
        add(ModItems.RUBY_SWORD.get(), "Ruby Sword");
        add(ModItems.SALMON_SUSHI_ROLL.get(), "Salmon Sushi Roll");
    }
}
