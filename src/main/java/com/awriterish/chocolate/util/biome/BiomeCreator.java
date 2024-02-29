package com.awriterish.chocolate.util.biome;

import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;

import javax.annotation.Nullable;

public class BiomeCreator {
    public static final MobSpawnSettings.Builder DEFAULT_MOB_SPAWNS;
    public static final MobSpawnSettings.Builder DEFAULT_PASSIVE_SPAWNS = new MobSpawnSettings.Builder();
    public static final MobSpawnSettings.Builder DEFAULT_HOSTILE_SPAWNS = new MobSpawnSettings.Builder();

    private static MobSpawnSettings.Builder combineMobSpawns(MobSpawnSettings.Builder one, MobSpawnSettings.Builder two){
        MobSpawnSettings.Builder temp = new MobSpawnSettings.Builder();
        MobSpawnSettings t1 = one.build();
        MobSpawnSettings t2 = two.build();
        for(MobCategory category: t1.getSpawnerTypes()){
            for(MobSpawnSettings.SpawnerData data : t1.getMobs(category).unwrap()){
                temp.addSpawn(category, data);
            }
        }
        for(MobCategory category : t2.getSpawnerTypes()){
            for(MobSpawnSettings.SpawnerData data : t2.getMobs(category).unwrap()){
                temp.addSpawn(category, data);
            }
        }
        return temp;
    }

    protected static int calculateSkyColor(float color){
        float temp = color / 3.0f;
        temp = Mth.approach(temp, -1.0f, 1.0f);
        return Mth.color(0.63f - temp * 0.05f, 0.5f + temp * 0.1f, 1.0f);
    }

    public static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temp, float downfall, MobSpawnSettings.Builder spawns, BiomeGenerationSettings.Builder generation, @Nullable Music music){
        return biome(precipitation, category, temp, downfall, 4159000, 329000, spawns, generation, music);
    }

    public static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temp, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawns, BiomeGenerationSettings.Builder generation, @Nullable Music music){
        return new Biome.BiomeBuilder()
                .precipitation(precipitation)
                .biomeCategory(category)
                .temperature(temp)
                .downfall(downfall)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .backgroundMusic(music)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(temp))
                        .build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }

    public static Biome biomeWithColorOverrides(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temp, float downfall, int grassColor, int foliageColor, MobSpawnSettings.Builder spawns, BiomeGenerationSettings.Builder generation, @Nullable Music music){
        return biomeWithColorOverrides(precipitation, category, temp, downfall, 4159000, 329000, grassColor, foliageColor, spawns, generation, music);
    }

    public static Biome biomeWithColorOverrides(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temp, float downfall, int waterColor, int waterFogColor, int grassColor, int foliageColor, MobSpawnSettings.Builder spawns, BiomeGenerationSettings.Builder generation, @Nullable Music music){
        return new Biome.BiomeBuilder()
                .precipitation(precipitation)
                .biomeCategory(category)
                .temperature(temp)
                .downfall(downfall)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .backgroundMusic(music)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(temp))
                        .grassColorOverride(grassColor)
                        .foliageColorOverride(foliageColor)
                        .build())
                .mobSpawnSettings(spawns.build())
                .generationSettings(generation.build())
                .build();
    }

    static {
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 80, 1, 4));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COD, 35, 2, 8));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COW, 14, 1, 4));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 76, 1, 4));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 17, 2, 6));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 65, 1, 4));
        DEFAULT_PASSIVE_SPAWNS.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 25, 1, 4));

        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 30, 1, 3));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 33, 1, 4));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 5, 1, 1));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PHANTOM, 23, 1, 4));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PILLAGER, 3, 1, 5));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 80, 1, 4));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 8, 1, 1));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 100, 1, 4));
        DEFAULT_HOSTILE_SPAWNS.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 2, 1, 1));

        DEFAULT_MOB_SPAWNS = combineMobSpawns(DEFAULT_HOSTILE_SPAWNS, DEFAULT_PASSIVE_SPAWNS);
    }
}
