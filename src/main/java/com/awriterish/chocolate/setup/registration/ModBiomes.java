package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.util.biome.ChocolateBiomes;
import com.awriterish.chocolate.util.biome.Regions;
import com.awriterish.chocolate.worldgen.biomes.ChocolateOverworldBiomes;
import com.awriterish.chocolate.worldgen.biomes.ChocolateOverworldRegion;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.awriterish.chocolate.Chocolate.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomes {
    public static void setup(){
        Regions.register(new ChocolateOverworldRegion(13));
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event){
        registerBiome(ChocolateBiomes.DENSE_FOREST, ChocolateOverworldBiomes.denseForest());
        registerBiomeToDictionary();
        registerVillagerToBiome();
    }

    private static void registerBiomeToDictionary(){
        registerBiomeToDictionary(ChocolateBiomes.DENSE_FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST);
    }

    private static void registerVillagerToBiome(){
        registerVillagerType(ChocolateBiomes.DENSE_FOREST, VillagerType.TAIGA);
    }

    public static void registerBiome(ResourceKey<Biome> key, Biome biome){
        biome.setRegistryName(key.location());
        ForgeRegistries.BIOMES.register(biome);
        Chocolate.LOGGER.info("Register " + key.location() + " biome");
    }

    private static void registerBiomeToDictionary(ResourceKey<Biome> key, BiomeDictionary.Type... type){
        BiomeDictionary.addTypes(key, type);
    }

    private static void registerVillagerType(ResourceKey<Biome> key, VillagerType type){
        VillagerType.BY_BIOME.put(key, type);
    }
}
