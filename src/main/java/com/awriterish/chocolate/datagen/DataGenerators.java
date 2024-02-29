package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e){
        DataGenerator generator = e.getGenerator();
        if(e.includeServer()){
            generator.addProvider(new ChocolateRecipes(generator));
            generator.addProvider(new ChocolateLootTables(generator));
            ChocolateBlockTags blockTags = new ChocolateBlockTags(generator, e.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new ChocolateItemTags(generator, blockTags, e.getExistingFileHelper()));
            generator.addProvider(new ChocolateBiomeTags(generator, e.getExistingFileHelper()));
            generator.addProvider(new ChocolateStructureTags(generator, e.getExistingFileHelper()));
        }
        if(e.includeClient()){
            generator.addProvider(new ChocolateBlockStates(generator, e.getExistingFileHelper()));
            generator.addProvider(new ChocolateItemModels(generator, e.getExistingFileHelper()));
            generator.addProvider(new ChocolateLanguageProvider(generator, "en_us"));
        }
    }
}