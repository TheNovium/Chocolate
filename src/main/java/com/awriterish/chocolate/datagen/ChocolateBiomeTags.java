package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.setup.registration.ModTags;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ChocolateBiomeTags extends TagsProvider<Biome> {
    public ChocolateBiomeTags(DataGenerator generator, ExistingFileHelper helper){
        super(generator, BuiltinRegistries.BIOME, Chocolate.MODID, helper);
    }

    @Override
    protected void addTags() {
        ForgeRegistries.BIOMES.getValues().forEach(biome -> {
            switch(biome.getBiomeCategory()){
                case TAIGA -> tag(ModTags.HAS_MUSHROOM_HOUSE).add(biome);
            }
        });
    }

    @Override
    public String getName() {
        return "Chocolate Biome Tags";
    }
}
