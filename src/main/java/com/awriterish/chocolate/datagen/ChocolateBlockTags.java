package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.block.BarrelOfBlock;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ChocolateBlockTags extends BlockTagsProvider {
    public ChocolateBlockTags(DataGenerator gen, ExistingFileHelper helper){
        super(gen, Chocolate.MODID, helper);
    }

    @Override
    protected void addTags(){
        tag(BlockTags.MINEABLE_WITH_AXE)
                //.add(ModBlocks.BARREL_OF.get())
                .add(ModBlocks.PURPLE_MUSHROOM_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.END_STONE_RUBY_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.END_STONE_RUBY_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get());
        tag(BlockTags.DRAGON_IMMUNE)
                .add(ModBlocks.END_STONE_RUBY_ORE.get());
        tag(Tags.Blocks.ORES)
                .add(ModBlocks.END_STONE_RUBY_ORE.get());
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.RUBY_BLOCK.get());
        tag(BlockTags.CROPS)
                .add(ModBlocks.RICE_CROP.get());
        tag(BlockTags.PREVENT_MOB_SPAWNING_INSIDE)
                .add(ModBlocks.REDSTONE_GATE.get())
                .add(ModBlocks.CARROT_CAKE.get());
        /*tag(Tags.Blocks.STORAGE_BLOCKS)
                .add(ModBlocks.BARREL_OF.get());*/
    }

    @Override
    public @NotNull String getName() {
        return "Chocolate Tags";
    }
}
