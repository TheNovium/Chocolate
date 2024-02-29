package com.awriterish.chocolate.setup;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.item.Potions;
import com.awriterish.chocolate.setup.registration.ModBiomes;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModEntities;
import com.awriterish.chocolate.setup.registration.ModItems;
import com.awriterish.chocolate.util.CraftingAPI;
import com.awriterish.chocolate.worldgen.ores.Ores;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static final String TAB = "chocolate";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB) {
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(Items.COCOA_BEANS);
        }
    };

    public static void setup(){
        IEventBus bus = MinecraftForge.EVENT_BUS;;
        bus.addListener(Entities::spawnMobs);
        bus.addListener(Entities::spawnStructureMobs);
        bus.addListener(Ores::onBiomeLoadingEvent);
        bus.addListener(CraftingAPI::registerVillagerTrades);
    }

    public static void init(FMLCommonSetupEvent e){
        e.enqueueWork(() -> {
            ModBiomes.setup();
            Entities.addVillagerTrades();
            registerCompostableItems();
            Potions.registerPotions();
        });
        SpawnPlacements.register((EntityType)ModEntities.BABY_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register((EntityType)ModEntities.BABY_STRAY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Stray::checkStraySpawnRules);
        SpawnPlacements.register((EntityType)ModEntities.BABY_WITHER_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
    }

    private static void registerCompostableItems(){
        ComposterBlock.add(0.3F, Items.BROWN_MUSHROOM);
        ComposterBlock.add(0.65F, Items.BROWN_MUSHROOM_BLOCK);
        ComposterBlock.add(1F, ModItems.PURPLE_MUSHROOM_BLOCK_ITEM.get());
        ComposterBlock.add(0.5F, ModBlocks.PURPLE_MUSHROOM_CROP.get());
        ComposterBlock.add(0.3F, Items.RED_MUSHROOM);
        ComposterBlock.add(0.65F, Items.RED_MUSHROOM_BLOCK);
        ComposterBlock.add(0.3F, ModItems.RICE.get());
    }

    /*@SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent e){}*/
}
