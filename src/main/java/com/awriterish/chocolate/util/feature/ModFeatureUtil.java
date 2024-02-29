package com.awriterish.chocolate.util.feature;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ModFeatureUtil {
    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<?, ?>> createConfiguredFeature(String name, F feature, FC config) {
        ResourceLocation id = Chocolate.chocolateResourceLoc(name);
        if (BuiltinRegistries.CONFIGURED_FEATURE.entrySet().contains(id)) {
            throw new IllegalStateException("Configured Feature ID: \"" + id.toString() + "\" already exists in the Configured Features registry!");
        } else {
            return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_FEATURE, Chocolate.chocolateResourceLoc(name).toString(), new ConfiguredFeature(feature, config));
        }
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> createConfiguredFeature(F feature, FC config) {
        return Holder.direct(new ConfiguredFeature(feature, config));
    }
}
