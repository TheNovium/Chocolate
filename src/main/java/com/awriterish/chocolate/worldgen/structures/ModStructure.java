package com.awriterish.chocolate.worldgen.structures;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.NotNull;

public abstract class ModStructure<C extends FeatureConfiguration> extends ForgeRegistryEntry<StructureFeature<?>> {
    public static final StructureFeature<JigsawConfiguration> MUSHROOM_HOUSE = register("mushroom_house", new MushroomHouseFeature(), GenerationStep.Decoration.SURFACE_STRUCTURES);

    private static <F extends StructureFeature<?>> F register(String name, F feature, GenerationStep.Decoration step) {
        return Registry.register(Registry.STRUCTURE_FEATURE, name, feature);
    }

    @NotNull
    static PieceGeneratorSupplier.Context<JigsawConfiguration> createContextWithConfig(PieceGeneratorSupplier.Context<JigsawConfiguration> context, JigsawConfiguration newConfig) {
        return new PieceGeneratorSupplier.Context<>(
                context.chunkGenerator(),
                context.biomeSource(),
                context.seed(),
                context.chunkPos(),
                newConfig,
                context.heightAccessor(),
                context.validBiome(),
                context.structureManager(),
                context.registryAccess()
        );
    }
}
