package com.awriterish.chocolate.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class DenseTreeFeature extends TreeFeature {
    public DenseTreeFeature(Codec<TreeConfiguration> codec) {
        super(codec);
    }
}
