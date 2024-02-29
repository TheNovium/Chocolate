package com.awriterish.chocolate.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public interface IExtendedBiomeSource {
    void appendDeferredBiomesList(List<Holder<Biome>> biomes);
}
