package com.awriterish.chocolate.setup;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.entity.neutral.Crab;
import com.awriterish.chocolate.setup.registration.ModEntities;
import com.awriterish.chocolate.setup.registration.ModItems;
import com.awriterish.chocolate.util.villagers.VillagerTradesAPI;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.StructureSpawnListGatherEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Entities {
    public static void spawnMobs(BiomeLoadingEvent e){
        MobSpawnSettingsBuilder spawnerData = e.getSpawns();
        switch(e.getCategory()){
            case BEACH -> spawnerData.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(ModEntities.CRAB.get(), 2, 1, 3));
        }
        switch(e.getClimate().precipitation){
            case SNOW -> spawnerData.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BABY_STRAY.get(), 7, 1, 3));
        }
        switch(e.getName().getPath()){
            case "soul_sand_valley" -> spawnerData.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BABY_SKELETON.get(), 7, 1, 3));
        }
        if(e.getCategory() == Biome.BiomeCategory.NETHER){

        } else if(e.getCategory() == Biome.BiomeCategory.THEEND){

        } else {
            if(e.getClimate().precipitation!=Biome.Precipitation.SNOW){
                spawnerData.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BABY_SKELETON.get(), 7, 1, 3));
            }
        }
    }

    public static void spawnStructureMobs(StructureSpawnListGatherEvent e){
        StructureFeature<?> structure = e.getStructure();
        switch(structure.getRegistryName().getPath()){
            case "fortress":
                e.addEntitySpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BABY_WITHER_SKELETON.get(), 7, 1, 3));
                e.addEntitySpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(ModEntities.BABY_SKELETON.get(), 7, 1, 3));
        }
    }

    public static void addVillagerTrades(){
        VillagerTradesAPI api = new VillagerTradesAPI();
        api.addTrade(VillagerProfession.ARMORER, 5, new ItemStack(ModItems.RUBY.get(), 1), new ItemStack(Items.EMERALD, 12), 32, 3);
        api.addTrade(VillagerProfession.FARMER, 1, new ItemStack(ModItems.RICE.get(), 25), new ItemStack(Items.EMERALD, 1), 4, 12);
        api.addTrade(VillagerProfession.FISHERMAN, 3, new ItemStack(Items.EMERALD, 3), new ItemStack(ModItems.SALMON_SUSHI_ROLL.get(), 2), 12, 5);
    }

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent e){
        e.put(ModEntities.CRAB.get(), Crab.prepareAttributes().build());
        e.put(ModEntities.BABY_SKELETON.get(), Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.375D).build());
        e.put(ModEntities.BABY_STRAY.get(), Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.375D).build());
        e.put(ModEntities.BABY_WITHER_SKELETON.get(), Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.375D).build());
    }
}
