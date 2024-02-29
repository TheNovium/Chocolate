package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.setup.registration.ModTags;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagManager;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ChocolateStructureTags extends TagsProvider<StructureSet> {
    public ChocolateStructureTags(DataGenerator generator, ExistingFileHelper helper){
        super(generator, BuiltinRegistries.STRUCTURE_SETS, Chocolate.MODID, helper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.MUSHROOM_HOUSE_STRUCTURES)
                .add(ResourceKey.create(BuiltinRegistries.STRUCTURE_SETS.key(), new ResourceLocation(Chocolate.MODID, "mushroom_house")));
    }

    @Override
    public String getName() {
        return "Chocolate Structure Sets";
    }
}
