package com.awriterish.chocolate.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CarrotCakeBlock extends CakeBlock {

    public CarrotCakeBlock(Properties props) {
        super(props);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
        InteractionResult result = super.use(state, level, pos, player, hand, hit);
        if(level.isClientSide() && result == InteractionResult.SUCCESS){
            player.getFoodData().eat(1, 0.3f);
        }
        return result;
    }
}
