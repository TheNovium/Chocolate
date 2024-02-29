package com.awriterish.chocolate.common.block;

import com.awriterish.chocolate.common.block.entity.RedstoneGateBlockEntity;
import com.awriterish.chocolate.common.block.enums.RedstoneGateMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.ticks.TickPriority;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RedstoneGateBlock extends DiodeBlock implements EntityBlock {
    private static final EnumProperty<RedstoneGateMode> MODE = ModBlockStateProperties.MODE_REDSTONE_GATE;

    public RedstoneGateBlock(BlockBehaviour.Properties properties){
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(POWERED, Boolean.FALSE).setValue(MODE, RedstoneGateMode.AND));
    }

    @Override
    protected int getDelay(BlockState state) {
        return 2;
    }

    @Override
    protected int getOutputSignal(BlockGetter level, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        return blockEntity instanceof RedstoneGateBlockEntity ? ((RedstoneGateBlockEntity)blockEntity).getOutput() : 0;
    }

    protected boolean shouldTurnOn(Level level, BlockPos pos, BlockState blockState){
        int i = getInputSignal(level, pos, blockState);
        switch(blockState.getValue(MODE)){
            case AND -> {
                return i == 3;
            }
            case XOR -> {
                return i == 1 || i == 2;
            }
            case NOR -> {
                return i == 0;
            }
        }
        return false;
    }

    private boolean rightPowered(Level level, BlockPos pos, BlockState blockState){
        Direction direction = blockState.getValue(FACING);
        BlockPos rightPos = pos.relative(direction.getClockWise(Direction.Axis.Y));
        return getAlternateSignalAt(level, pos, direction.getClockWise()) > 0 || getAlternateSignalAt(level, rightPos.relative(direction.getClockWise()), direction.getClockWise()) > 0;
    }

    private boolean leftPowered(Level level, BlockPos pos, BlockState blockState){
        Direction direction = blockState.getValue(FACING);
        BlockPos leftPos = pos.relative(direction.getCounterClockWise());
        return getAlternateSignalAt(level, pos, direction.getCounterClockWise()) > 0 || getAlternateSignalAt(level, leftPos.relative(direction.getCounterClockWise()), direction.getCounterClockWise()) > 0;
    }

    @Override
    protected int getInputSignal(Level level, BlockPos pos, BlockState blockState) {
        return (leftPowered(level, pos, blockState) ? 1 : 0) + (rightPowered(level, pos, blockState) ? 2 : 0);
    }

    protected void checkTickOnNeighbor(Level level, BlockPos pos, BlockState blockState){
        if(!level.getBlockTicks().willTickThisTick(pos, this)){
            int i = shouldTurnOn(level, pos, blockState) ? 15 : 0;
            BlockEntity blockEntity = level.getBlockEntity(pos);
            int j = blockEntity instanceof RedstoneGateBlockEntity ? ((RedstoneGateBlockEntity)blockEntity).getOutput() : 0;
            if(i != j || blockState.getValue(POWERED) != this.shouldTurnOn(level, pos, blockState)){
                TickPriority tickPriority = shouldPrioritize(level, pos, blockState) ? TickPriority.HIGH : TickPriority.NORMAL;
                level.scheduleTick(pos, this, 2, tickPriority);
            }
        }
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit){
        if(!player.getAbilities().mayBuild){
            return InteractionResult.PASS;
        } else {
            blockState = blockState.cycle(MODE);
            float f = blockState.getValue(MODE) == RedstoneGateMode.AND ? 0.85f : blockState.getValue(MODE) == RedstoneGateMode.NOR ? 0.25f : 0.5f;
            level.playSound(player, pos, SoundEvents.COMPARATOR_CLICK, SoundSource.BLOCKS, 0.3f, f);
            level.setBlock(pos, blockState, 2);
            refreshOutputState(level, pos, blockState);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    private void refreshOutputState(Level level, BlockPos pos, BlockState blockState){
        BlockEntity entity = level.getBlockEntity(pos);
        if(entity instanceof RedstoneGateBlockEntity){
            if(shouldTurnOn(level, pos, blockState)){
                ((RedstoneGateBlockEntity) entity).setOutput(15);
                if(!blockState.getValue(POWERED)) {
                    level.setBlock(pos, blockState.setValue(POWERED, Boolean.TRUE), 2);
                }
            } else if(!shouldTurnOn(level, pos, blockState) && blockState.getValue(POWERED)){
                level.setBlock(pos, blockState.setValue(POWERED, Boolean.FALSE), 2);
                ((RedstoneGateBlockEntity) entity).setOutput(0);
            }
        }
        updateNeighborsInFront(level, pos, blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, MODE, POWERED);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel level, BlockPos pos, Random rand) {
        refreshOutputState(level, pos, blockState);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RedstoneGateBlockEntity(pos, state);
    }
}
