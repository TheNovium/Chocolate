package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.worldgen.structures.MushroomHouseFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModStructures {
    private static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        STRUCTURES.register(bus);
    }

    public static final RegistryObject<StructureFeature<JigsawConfiguration>> MUSHROOM_HOUSE = STRUCTURES.register("mushroom_house", MushroomHouseFeature::new);
}
