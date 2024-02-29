package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ChocolateItemTags extends ItemTagsProvider {
    public ChocolateItemTags(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper helper){
        super(gen, blockTags, Chocolate.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(Tags.Items.ORES)
                .add(ModItems.END_STONE_RUBY_ORE_ITEM.get());
        tag(Tags.Items.INGOTS)
                .add(ModItems.RUBY.get());
        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.RUBY.get());
        tag(Tags.Items.GEMS)
                .add(ModItems.RUBY.get());
        tag(ItemTags.AXOLOTL_TEMPT_ITEMS)
                .add(ModItems.RAW_CRAB_MEAT.get())
                .add(ModItems.COOKED_CRAB_MEAT.get());
        tag(Tags.Items.MUSHROOMS)
                .add(ModItems.PURPLE_MUSHROOM.get());
        tag(Tags.Items.CROPS)
                .add(ModItems.RICE.get());
        tag(Tags.Items.SEEDS)
                .add(ModItems.RICE.get());
        /*tag(Tags.Items.STORAGE_BLOCKS)
                .add(ModItems.BARREL_OF_ITEM.get());*/
    }

    @Override
    public String getName() {
        return "Chocolate Tags";
    }
}
