package com.awriterish.chocolate.util.biome;

import com.awriterish.chocolate.Chocolate;
import com.google.common.collect.Lists;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class ChocolateBiomes {
    private static List<ResourceKey<Biome>> overworldBiomes = Lists.newArrayList();
    private static List<ResourceKey<Biome>> allBiomes = Lists.newArrayList();
    public static final ResourceKey<Biome> DENSE_FOREST = registerOverworldBiome("dense_forest");

    private static ResourceKey<Biome> registerOverworldBiome(String name){
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, Chocolate.chocolateResourceLoc(name));
        overworldBiomes.add(key);
        allBiomes.add(key);
        return key;
    }
}
