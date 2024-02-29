package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.worldgen.features.HugePurpleMushroomFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModFeatures {
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FEATURES.register(bus);
    }

    public static final RegistryObject<Feature<HugeMushroomFeatureConfiguration>> HUGE_PURPLE_MUSHROOM_FEATURE = FEATURES.register("huge_purple_mushroom_feature", () -> new HugePurpleMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
}
