package com.awriterish.chocolate.util.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

public class Region {
    private final ResourceLocation name;
    private RegionType type;
    private int weight;

    public Region(ResourceLocation name, RegionType type, int weight){
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public ResourceLocation getName() {
        return name;
    }

    public RegionType getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public void addBiome(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper){}
}
