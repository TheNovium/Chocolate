package com.awriterish.chocolate.common.block.entity;

import com.awriterish.chocolate.setup.registration.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneGateBlockEntity extends BlockEntity {
    private int output;

    public RedstoneGateBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntities.REDSTONE_GATE_BLOCK.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("OutputSignal", output);
    }

    public void load(CompoundTag tag){
        super.load(tag);
        output = tag.getInt("OutputSignal");
    }

    public int getOutput(){
        return output;
    }

    public void setOutput(int strength){
        output = strength;
    }
}