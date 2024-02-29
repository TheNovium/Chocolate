package com.awriterish.chocolate.common.block;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BarrelOfBlock extends Block implements WorldlyContainerHolder {
    private final ItemLike heldItem;
    public static final int MAX_LEVEL = 2048;
    public static final int MIN_LEVEL = 0;
    public static final IntegerProperty LEVEL = ModBlockStateProperties.LEVEL_BARREL_OF;
    public static final IntegerProperty FILL_LEVEL = ModBlockStateProperties.BARREL_OF_FILL_LEVEL;
    private static final VoxelShape OUTER_SHAPE = Shapes.block();
    private static final VoxelShape[] INNER_SHAPE = Util.make(new VoxelShape[8], (input) -> {
        for(int i = 0; i < 8; ++i){
            input[i] = Shapes.join(OUTER_SHAPE, Block.box(2.0d, Math.max(2, 1 + i * 2), 2.0d, 14.0d, 16.0d, 14.0d), BooleanOp.ONLY_FIRST);
        }
    });

    public BarrelOfBlock(ItemLike heldItem) {
        super(BlockBehaviour.Properties.of(Material.WOOD)
                .strength(0.6f)
                .sound(SoundType.WOOD));
        this.heldItem = heldItem;
        registerDefaultState(this.getStateDefinition().any().setValue(LEVEL, 9).setValue(FILL_LEVEL, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }

    public ItemLike getHeldItem() {
        return heldItem;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return INNER_SHAPE[(int)Math.floor(((double)state.getValue(LEVEL) / (double)(MAX_LEVEL + 1)) * 8)];
    }

    public void handleFill(Level level, BlockPos pos){
        BlockState state = level.getBlockState(pos);
        level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.COMPOSTER_FILL_SUCCESS, SoundSource.BLOCKS, 1.0f, 1.0f, false);
        double startY = state.getShape(level, pos).max(Direction.Axis.Y, 0.5, 0.5) + 0.03125;
        double d0 = 0.13125;
        double d1 = 0.7375;
        Random random = level.getRandom();

        for(int i = 0; i < 6; i++){
            double dx = random.nextGaussian() * 0.2;
            double dy = random.nextGaussian() * 0.2;
            double dz = random.nextGaussian() * 0.2;
            level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(heldItem.asItem())), pos.getX() + d0 + d1 * random.nextFloat(), pos.getY() + startY + random.nextFloat() * (1 - startY), pos.getZ() + d0 + d1 * random.nextFloat(), dx, dy, dz);
        }
    }

    @Override
    public VoxelShape getInteractionShape(BlockState state, BlockGetter getter, BlockPos pos) {
        return OUTER_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return INNER_SHAPE[0];
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(LEVEL);
        ItemStack items = player.getItemInHand(hand);
        if(i < MAX_LEVEL && heldItem.asItem().equals(items.getItem()) && !level.isClientSide){
            int count = items.getCount();
            if(i + count > MAX_LEVEL){
                count = MAX_LEVEL - i;
            }
            BlockState blockState = addItem(state, level, pos, count);
            level.levelEvent(1500, pos, state != blockState ? 1 : 0);
            player.awardStat(Stats.ITEM_USED.get(items.getItem()));
            if(!player.getAbilities().instabuild){
                items.shrink(count);
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    static BlockState addItem(BlockState state, LevelAccessor level, BlockPos pos, int count){
        int i = state.getValue(LEVEL);
        BlockState blockState = state.setValue(LEVEL, i + count).setValue(FILL_LEVEL, (int)Math.floor(((double)i + (double)count)/256.125));
        level.setBlock(pos, blockState, 3);
        return blockState;
    }


    static BlockState removeItem(BlockState state, LevelAccessor level, BlockPos pos, ItemStack items){
        int i = state.getValue(LEVEL);
        BlockState blockState = state.setValue(LEVEL, i - 1).setValue(FILL_LEVEL, (int)Math.floor(((double)i - 1.0)/256.125));
        level.setBlock(pos, blockState, 3);
        return blockState;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return (int)((double)state.getValue(LEVEL) * (15.0 / (double)MAX_LEVEL));
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType type) {
        return false;
    }

    public WorldlyContainer getContainer(BlockState state, LevelAccessor level, BlockPos pos) {
        return new BarrelOfBlock.BarrelContainer(state, level, pos);
    }

     class BarrelContainer extends SimpleContainer implements WorldlyContainer {
        private final BlockState state;
        private final LevelAccessor level;
        private final BlockPos pos;
        private boolean added = false;
        private boolean taken;

        public BarrelContainer(BlockState state, LevelAccessor level, BlockPos pos){
            super(new ItemStack(heldItem, state.getValue(LEVEL)));
            this.state = state;
            this.level = level;
            this.pos = pos;
        }

        @Override
        public int getMaxStackSize() {
            return MAX_LEVEL;
        }

        @Override
        public int[] getSlotsForFace(Direction dir) {
            return new int[]{0};
        }

        @Override
        public boolean canPlaceItemThroughFace(int total, ItemStack items, @Nullable Direction dir) {
            added = dir != Direction.DOWN && items.getItem().asItem().equals(heldItem.asItem()) && state.getValue(LEVEL) < MAX_LEVEL;
            return added;
        }

        @Override
        public boolean canTakeItemThroughFace(int total, ItemStack items, Direction dir) {
            taken = dir == Direction.DOWN && items.getItem().asItem().equals(heldItem.asItem()) && state.getValue(LEVEL) > MIN_LEVEL;
            return taken;
        }

        @Override
        public void setChanged() {
            ItemStack items = this.getItem(0);
            if(!items.isEmpty() && added){
                BlockState blockState = BarrelOfBlock.addItem(state, level, pos, items.getCount());
                level.levelEvent(1500, pos, blockState != state ? 1 : 0);
            }
            if(taken){
                BarrelOfBlock.removeItem(state, level, pos, items);
            }
        }
    }
}
