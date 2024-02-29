package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.block.CarrotCakeBlock;
import com.awriterish.chocolate.common.block.ModBlockStateProperties;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChocolateBlockStates extends BlockStateProvider {
    public ChocolateBlockStates(DataGenerator gen, ExistingFileHelper helper){
        super(gen, Chocolate.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels(){
        //Simple Blocks
        simpleBlock(ModBlocks.END_STONE_RUBY_ORE.get());
        simpleBlock(ModBlocks.RUBY_BLOCK.get());

        //Barrel of
        /*MultiPartBlockStateBuilder builder = getMultipartBuilder(ModBlocks.BARREL_OF.get());
        ModBlockStateProperties.BARREL_OF_FILL_LEVEL.getPossibleValues().forEach(level -> {
            if(level > 0){
                builder.part().modelFile(models().withExistingParent("barrel_of_level_" + level, mcLoc("block/composter_contents" + level))
                        .texture("particle", modLoc("block/apples_contents"))
                        .texture("inside", modLoc("block/apples_contents"))).addModel().condition(ModBlockStateProperties.BARREL_OF_FILL_LEVEL, level);
            }
        });
        builder.part().modelFile(models().withExistingParent("barrel_of_level_0", mcLoc("block/composter"))
                .texture("particle", mcLoc("block/barrel_side"))
                .texture("top", mcLoc("block/composter_top"))
                .texture("bottom", mcLoc("block/barrel_bottom"))
                .texture("side", mcLoc("block/barrel_side"))
                .texture("inside", mcLoc("block/composter_bottom"))).addModel().end();*/


        //I don't even know anymore :/ (carrot cake)
        getVariantBuilder(ModBlocks.CARROT_CAKE.get())
                .forAllStates(state -> {
                    String modelFile;
                    int bites = state.getValue(CarrotCakeBlock.BITES);
                    if(bites == 0){
                        modelFile = "block/cake";
                    } else {
                        modelFile = "block/cake_slice" + bites;
                    }
                    return ConfiguredModel.builder().modelFile(models().withExistingParent("carrot_cake_" + bites, mcLoc(modelFile))
                            .texture("particle", modLoc("block/carrot_cake_side"))
                            .texture("bottom", modLoc("block/carrot_cake_bottom"))
                            .texture("top", modLoc("block/carrot_cake_top"))
                            .texture("side", modLoc("block/carrot_cake_side"))).build();
                });
    }
}
