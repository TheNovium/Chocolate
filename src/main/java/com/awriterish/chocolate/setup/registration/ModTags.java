package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class ModTags {
    //Biome tags
    public static final TagKey<Biome> HAS_MUSHROOM_HOUSE = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Chocolate.MODID, "has_structure/mushroom_house"));

    //Structure tag locations
    public static final ResourceLocation MUSHROOM_HOUSE_SET = new ResourceLocation(Chocolate.MODID, "mushroom_house_structure_set");

    //Structure tags
    public static final TagKey<StructureSet> MUSHROOM_HOUSE_STRUCTURES = TagKey.create(Registry.STRUCTURE_SET_REGISTRY, MUSHROOM_HOUSE_SET);
}
