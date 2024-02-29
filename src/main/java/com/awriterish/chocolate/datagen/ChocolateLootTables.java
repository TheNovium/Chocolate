package com.awriterish.chocolate.datagen;

import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModEntities;
import com.awriterish.chocolate.setup.registration.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;

import java.util.Map;

public class ChocolateLootTables extends BaseLootTableProvider{
    public ChocolateLootTables(DataGenerator gen){
        super(gen);
    }

    @Override
    protected void addTables(){
        //Mob drop tables
        entityLootTables.put(ModEntities.CRAB.get(), createMobLootTable("crab", Map.of(ModItems.CRAB_CLAW.get(), 1.0f, ModItems.RAW_CRAB_MEAT.get(), 2.0f), 1));

        //Mob drops with parent loot tables
        entityLootTables.put(ModEntities.BABY_SKELETON.get(), fromMobLootTable(EntityType.SKELETON));
        entityLootTables.put(ModEntities.BABY_STRAY.get(), fromMobLootTable(EntityType.STRAY));
        entityLootTables.put(ModEntities.BABY_WITHER_SKELETON.get(), fromMobLootTable(EntityType.WITHER_SKELETON));

        //Silk touch and fortune tables
        lootTables.put(ModBlocks.END_STONE_RUBY_ORE.get(), createSilkTouchTable("end_stone_ruby_ore", ModBlocks.END_STONE_RUBY_ORE.get(), ModItems.RUBY.get(), 1, 1));
        lootTables.put(ModBlocks.PURPLE_MUSHROOM_BLOCK.get(), createSilkTouchTable("purple_mushroom_block", ModBlocks.PURPLE_MUSHROOM_BLOCK.get(), ModItems.PURPLE_MUSHROOM.get(), 0, 1));

        //Fortune only tables

        //Standard tables
        lootTables.put(ModBlocks.PURPLE_MUSHROOM_CROP.get(), createSimpleTable("purple_mushroom", ModBlocks.PURPLE_MUSHROOM_CROP.get()));
        lootTables.put(ModBlocks.RUBY_BLOCK.get(), createSimpleTable("ruby_block", ModBlocks.RUBY_BLOCK.get()));
        lootTables.put(ModBlocks.REDSTONE_GATE.get(), createSimpleTable("redstone_gate", ModBlocks.REDSTONE_GATE.get()));
    }
}
