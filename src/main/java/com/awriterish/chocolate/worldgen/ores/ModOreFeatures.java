package com.awriterish.chocolate.worldgen.ores;

import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.util.feature.ModFeatureUtil;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;

import java.util.List;

public class ModOreFeatures {
    public static final RuleTest IN_ENDSTONE = new TagMatchTest(Tags.Blocks.END_STONES);
    public static final List<OreConfiguration.TargetBlockState> ORE_RUBY_LIST = List.of(OreConfiguration.target(IN_ENDSTONE, ModBlocks.END_STONE_RUBY_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<?, ?>> ORE_RUBY = ModFeatureUtil.createConfiguredFeature("ruby_ore_end", Feature.ORE, new OreConfiguration(ORE_RUBY_LIST, 6));
}
