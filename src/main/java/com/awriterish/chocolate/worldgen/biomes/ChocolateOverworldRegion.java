package com.awriterish.chocolate.worldgen.biomes;

import com.awriterish.chocolate.util.biome.ChocolateOverworldBiomeBuilder;
import com.awriterish.chocolate.util.biome.Region;
import com.awriterish.chocolate.util.biome.RegionType;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

public class ChocolateOverworldRegion extends Region {
    public static final ResourceLocation LOC = new ResourceLocation("minecraft:overworld");

    public ChocolateOverworldRegion(int weight){
        super(LOC, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiome(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        new ChocolateOverworldBiomeBuilder().addBiomes(registry, mapper);
    }
}
