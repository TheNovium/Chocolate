package com.awriterish.chocolate.common.block;

import com.awriterish.chocolate.setup.registration.ModParticles;
import com.awriterish.chocolate.worldgen.features.ModConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Random;

public class PurpleMushroomBlock extends MushroomBlock {

    public PurpleMushroomBlock(){
        super(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(SoundType.GRASS)
                .lightLevel((p_50892_) -> 1).hasPostProcess(PurpleMushroomBlock::always), () -> ModConfiguredFeatures.HUGE_PURPLE_MUSHROOM);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        for(int i = 0; i < 3; i++){
            BlockPos plantPos = pPos.offset(pRandom.nextInt(6) -3, pRandom.nextInt(2) -1, pRandom.nextInt(6) -3);
            BlockState plantState = pLevel.getBlockState(plantPos);
            Block block = pLevel.getBlockState(plantPos).getBlock();

            if(block instanceof CropBlock cropBlock){
                if(!cropBlock.isMaxAge(plantState)){
                    IntegerProperty age = cropBlock.getAgeProperty();
                    pLevel.setBlockAndUpdate(plantPos, plantState.setValue(age, plantState.getValue(age) + 1));
                    addParticleGrowth(pLevel, pPos, 8);
                    addParticleGrowth(pLevel, plantPos, 5);
                }
            }
        }
    }

    private static boolean always(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    private static void addParticleGrowth(ServerLevel level, BlockPos pos, int particles){

        BlockState blockState = level.getBlockState(pos);

        if (!blockState.isAir()) {
            double d0 = 0.5D;
            double d1;
            if (blockState.is(Blocks.WATER)) {
                particles *= 3;
                d1 = 1.0D;
                d0 = 3.0D;
            } else if (blockState.isSolidRender(level, pos)) {
                pos = pos.above();
                particles *= 3;
                d0 = 3.0D;
                d1 = 1.0D;
            } else {
                d1 = blockState.getShape(level, pos).max(Direction.Axis.Y);
            }

            Random random = level.getRandom();

            for(int i = 0; i < particles; ++i) {
                double dx = random.nextGaussian() * 0.02D;
                double dy = random.nextGaussian() * 0.02D;
                double dz = random.nextGaussian() * 0.02D;
                double posCorrection = 0.5D - d0;
                double x = (double)pos.getX() + posCorrection + random.nextDouble() * d0 * 2.0D;
                double y = (double)pos.getY() + random.nextDouble() * d1;
                double z = (double)pos.getZ() + posCorrection + random.nextDouble() * d0 * 2.0D;
                if (!level.getBlockState((new BlockPos(x, y, z)).below()).isAir()) {
                    level.sendParticles(ModParticles.MUSHROOM_PARTICLE.get(), x, y, z, particles, dx, dy, dz, 0);
                }
            }
        }
    }

}
