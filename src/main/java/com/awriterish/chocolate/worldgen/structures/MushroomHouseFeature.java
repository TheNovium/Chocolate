package com.awriterish.chocolate.worldgen.structures;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.PostPlacementProcessor;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class MushroomHouseFeature extends StructureFeature<JigsawConfiguration> {
    public MushroomHouseFeature(){
        super(JigsawConfiguration.CODEC, MushroomHouseFeature::pieceGeneratorSupplier, PostPlacementProcessor.NONE);
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }

    private static boolean isFeatureChunk(PieceGeneratorSupplier.Context<JigsawConfiguration> context) {
        BlockPos pos = context.chunkPos().getWorldPosition();

        int landHeight = context.chunkGenerator().getFirstOccupiedHeight(pos.getX(), pos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor());

        NoiseColumn columnOfBlocks = context.chunkGenerator().getBaseColumn(pos.getX(), pos.getZ(), context.heightAccessor());

        BlockState topBlock = columnOfBlocks.getBlock(landHeight);

        return topBlock.getFluidState().isEmpty();
    }

    private static @NotNull Optional<PieceGenerator<JigsawConfiguration>> pieceGeneratorSupplier(PieceGeneratorSupplier.Context<JigsawConfiguration> context){
        BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
        var generator = JigsawPlacement.addPieces(context, PoolElementStructurePiece::new, blockpos, false, true);
        if(generator.isPresent()){
            Chocolate.LOGGER.info("Mushroom house generated at " + blockpos);
        }
        return generator;
    }
}
