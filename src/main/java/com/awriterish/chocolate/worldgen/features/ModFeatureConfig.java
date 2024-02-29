package com.awriterish.chocolate.worldgen.features;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatureConfig<FC extends FeatureConfiguration> extends ForgeRegistryEntry<Feature<?>> {
    public static final Feature<HugeMushroomFeatureConfiguration> HUGE_PURPLE_MUSHROOM = register("huge_purple_mushroom", new HugePurpleMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));

    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String name, F codec) {
        ResourceLocation id = Chocolate.chocolateResourceLoc(name);
        if (BuiltinRegistries.CONFIGURED_FEATURE.entrySet().contains(id)) {
            throw new IllegalStateException("Feature ID: \"" + id.toString() + "\" already exists in the Features registry!");
        } else {
            return codec;
        }
    }
}
