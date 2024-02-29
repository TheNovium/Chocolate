package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.block.BarrelOfBlock;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ChocolateItemModels extends ItemModelProvider {
    public ChocolateItemModels(DataGenerator gen, ExistingFileHelper helper){
        super(gen, Chocolate.MODID, helper);
    }

    @Override
    protected void registerModels(){
        //withExistingParent(ModItems.BARREL_OF_ITEM.get().getRegistryName().getPath(), modLoc("block/barrel_of_level_0"));
        withExistingParent(ModItems.END_STONE_RUBY_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/end_stone_ruby_ore"));
        withExistingParent(ModItems.RUBY_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/ruby_block"));

        withExistingParent(ModItems.BABY_STRAY_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BABY_SKELETON_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.BABY_WITHER_SKELETON_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CRAB_SPAWN_EGG.get().getRegistryName().getPath(), mcLoc("item/template_spawn_egg"));

        singleTexture(ModItems.PURPLE_MUSHROOM.get().getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("block/purple_mushroom_crop"));

        registerSingleItemTexture(ModItems.CARROT_CAKE_ITEM, "carrot_cake");
        registerSingleItemTexture(ModItems.COOKED_CRAB_MEAT, "cooked_crab_meat");
        registerSingleItemTexture(ModItems.CRAB_BOOTS, "crab_boots");
        registerSingleItemTexture(ModItems.CRAB_CLAW, "crab_claw");
        registerSingleItemTexture(ModItems.RAW_CRAB_MEAT, "raw_crab_meat");
        registerSingleItemTexture(ModItems.REDSTONE_GATE_ITEM, "redstone_gate");
        registerSingleItemTexture(ModItems.RICE, "rice");
        registerSingleItemTexture(ModItems.RUBY, "ruby");
        registerSingleItemTexture(ModItems.RUBY_AXE, "ruby_axe");
        registerSingleItemTexture(ModItems.RUBY_BOOTS, "ruby_boots");
        registerSingleItemTexture(ModItems.RUBY_CHESTPLATE, "ruby_chestplate");
        registerSingleItemTexture(ModItems.RUBY_HELMET, "ruby_helmet");
        registerSingleItemTexture(ModItems.RUBY_HOE, "ruby_hoe");
        registerSingleItemTexture(ModItems.RUBY_LEGGINGS, "ruby_leggings");
        registerSingleItemTexture(ModItems.RUBY_PICKAXE, "ruby_pickaxe");
        registerSingleItemTexture(ModItems.RUBY_SHOVEL, "ruby_shovel");
        registerSingleItemTexture(ModItems.RUBY_SWORD, "ruby_sword");
        registerSingleItemTexture(ModItems.SALMON_SUSHI_ROLL, "salmon_sushi_roll");
    }

    private void registerSingleItemTexture(RegistryObject<? extends Item> reg, String name){
        singleTexture(reg.get().getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + name));
    }
}
