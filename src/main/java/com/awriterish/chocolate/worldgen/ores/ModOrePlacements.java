package com.awriterish.chocolate.worldgen.ores;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.ArrayList;
import java.util.List;

public class ModOrePlacements {
    public static final Holder<PlacedFeature> ORE_RUBY = PlacementUtils.register("ore_ruby", ModOreFeatures.ORE_RUBY, squarePlacement(6, 16, 80));

    private static List<PlacementModifier> squarePlacement(int total, int bottom, int top){
        List<PlacementModifier> mods = new ArrayList<>();
        mods.add(CountPlacement.of(total));
        mods.add(BiomeFilter.biome());
        mods.add(InSquarePlacement.spread());
        mods.add(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(bottom), VerticalAnchor.aboveBottom(top)));
        return mods;
    }
}
