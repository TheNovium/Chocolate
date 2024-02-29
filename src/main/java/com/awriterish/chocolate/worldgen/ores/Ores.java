package com.awriterish.chocolate.worldgen.ores;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class Ores {
    public static void onBiomeLoadingEvent(BiomeLoadingEvent e){
        switch(e.getCategory()){
            case THEEND -> {
                e.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ModOrePlacements.ORE_RUBY);
            }
        }
    }
}
