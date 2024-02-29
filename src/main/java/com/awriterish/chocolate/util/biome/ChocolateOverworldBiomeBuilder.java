package com.awriterish.chocolate.util.biome;

import com.google.common.collect.Maps;
import com.google.common.collect.ImmutableList.Builder;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ChocolateOverworldBiomeBuilder {
    private Map<ResourceKey<Biome>, ResourceKey<Biome>> originalBiomeMap = Maps.newHashMap();
    private Map<Climate.ParameterPoint, ResourceKey<Biome>> parameterToBiome = Maps.newHashMap();
    private Map<Climate.ParameterPoint, Climate.ParameterPoint> parameterMap = Maps.newHashMap();
    private final OverworldBiomeBuilder biomeBuilder = new OverworldBiomeBuilder();

    public ChocolateOverworldBiomeBuilder(){}

    public void replaceBiome(ResourceKey<Biome> original, ResourceKey<Biome> replacement){
        originalBiomeMap.put(original, replacement);
    }

    public void replaceBiome(Climate.ParameterPoint original, ResourceKey<Biome> replacement){
        parameterToBiome.put(original, replacement);
    }

    public void replaceParameter(Climate.ParameterPoint original, Climate.ParameterPoint replacement){
        parameterMap.put(original, replacement);
    }

    public List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> build(){
        Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new Builder();
        Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper = (pair) -> {
            Climate.ParameterPoint parameter = pair.getFirst();
            ResourceKey<Biome> biome = pair.getSecond();
            if(originalBiomeMap.containsKey(biome)){
                biome = originalBiomeMap.get(biome);
            } else if(parameterToBiome.containsKey(parameter)){
                biome = parameterToBiome.get(parameter);
            }

            if (parameterMap.containsKey(parameter)) {
                parameter = parameterMap.get(parameter);
            }
            builder.add(Pair.of(parameter, biome));
        };
        biomeBuilder.addBiomes(mapper);
        return builder.build();
    }

    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper){}
}
