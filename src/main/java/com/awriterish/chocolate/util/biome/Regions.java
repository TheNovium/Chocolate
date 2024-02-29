package com.awriterish.chocolate.util.biome;

import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;
import java.util.Map;

public class Regions {
    private static Map<RegionType, LinkedHashMap<ResourceLocation, Region>> regions;
    private static Map<RegionType, Map<ResourceLocation, Integer>> weights;

    public Regions(){}

    public static void register(ResourceLocation name, Region region){
        RegionType type = region.getType();
        regions.get(type).put(name, region);
        int i = regions.get(type).size() - 1;
        weights.get(type).put(name, i);
    }

    public static void register(Region region){
        register(region.getName(), region);
    }

    static {
        RegionType[] regionTypes = RegionType.values();
        for (RegionType type : regionTypes) {
            regions.put(type, Maps.newLinkedHashMap());
            weights.put(type, Maps.newHashMap());
        }
    }
}
