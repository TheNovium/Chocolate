package com.awriterish.chocolate.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

import java.util.Random;

public class HugePurpleMushroomFeature extends AbstractHugeMushroomFeature {
    public HugePurpleMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeRadiusForHeight(int p_65094_, int p_65095_, int p_65096_, int height) {
        return height < 3 ? 0 : 5;
    }

    @Override
    protected void makeCap(LevelAccessor level, Random random, BlockPos pos, int treeHeight, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
        for(int i = -3; i < 4; i++){
            for(int j = -3; j < 4; j++){
                double dist = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                if(dist < 3.5){
                    mutablePos.setWithOffset(pos, i, dist > 2.5 ? treeHeight - 1 : treeHeight, j);
                    BlockState blockState = config.capProvider.getState(random, pos);
                    this.setBlock(level, mutablePos, blockState);
                }
            }
        }
    }
}
