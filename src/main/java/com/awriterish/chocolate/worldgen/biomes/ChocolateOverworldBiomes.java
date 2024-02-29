package com.awriterish.chocolate.worldgen.biomes;

import com.awriterish.chocolate.util.biome.BiomeCreator;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ChocolateOverworldBiomes {
    public static Biome denseForest(){
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.plainsSpawns(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 12, 1, 4));
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(generation);
        BiomeDefaultFeatures.addForestFlowers(generation);
        BiomeDefaultFeatures.addMossyStoneBlock(generation);
        return BiomeCreator.biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.FOREST, 0.43f, 0.74f, spawns, generation, null);
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder){
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultGrass(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
    }
}
