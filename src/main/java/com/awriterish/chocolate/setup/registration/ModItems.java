package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.armor.CrabBoots;
import com.awriterish.chocolate.common.armor.ModArmorMaterial;
import com.awriterish.chocolate.common.block.BarrelOfBlock;
import com.awriterish.chocolate.common.item.FoodItem;
import com.awriterish.chocolate.common.tool.ModItemTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }


    //Block Items
    //public static final RegistryObject<Item> BARREL_OF_ITEM = fromBlock(ModBlocks.BARREL_OF, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Item> END_STONE_RUBY_ORE_ITEM = fromBlock(ModBlocks.END_STONE_RUBY_ORE, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
    public static final RegistryObject<Item> PURPLE_MUSHROOM = fromBlock(ModBlocks.PURPLE_MUSHROOM_CROP, new Item.Properties().tab(CreativeModeTab.TAB_FOOD));
    public static final RegistryObject<Item> PURPLE_MUSHROOM_BLOCK_ITEM = fromBlock(ModBlocks.PURPLE_MUSHROOM_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS));
    public static final RegistryObject<Item> REDSTONE_GATE_ITEM = fromBlock(ModBlocks.REDSTONE_GATE, new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE));
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM= fromBlock(ModBlocks.RUBY_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS));

    //Standard Items
    public static final RegistryObject<Item> BABY_STRAY_SPAWN_EGG = ITEMS.register("baby_stray", () -> new ForgeSpawnEggItem(ModEntities.BABY_STRAY, 0xdcecf1, 0x91dcf5, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BABY_SKELETON_SPAWN_EGG = ITEMS.register("baby_skeleton", () -> new ForgeSpawnEggItem(ModEntities.BABY_SKELETON, 0xf8f8f8, 0xcecfd2, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> BABY_WITHER_SKELETON_SPAWN_EGG = ITEMS.register("baby_wither_skeletons", () -> new ForgeSpawnEggItem(ModEntities.BABY_WITHER_SKELETON, 0x59181a, 0x6a3839, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CARROT_CAKE_ITEM = ITEMS.register("carrot_cake_item", () -> new BlockItem(ModBlocks.CARROT_CAKE.get(), (new Item.Properties()).stacksTo(64).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> CRAB_CLAW = ITEMS.register("crab_claw", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> CRAB_SPAWN_EGG = ITEMS.register("crab", () -> new ForgeSpawnEggItem(ModEntities.CRAB, 0x764246, 0xf2cfd2, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    //Tools registration
    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", () -> new AxeItem(ModItemTier.RUBY, 9, -3.2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", () -> new HoeItem(ModItemTier.RUBY, 0, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () -> new ShovelItem(ModItemTier.RUBY, 3, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", () -> new SwordItem(ModItemTier.RUBY, 7, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModItemTier.RUBY, 0, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    //Armor registration
    public static final RegistryObject<ArmorItem> CRAB_BOOTS = ITEMS.register("crab_boots", CrabBoots::new);
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    //Food Items
    public static final RegistryObject<Item> COOKED_CRAB_MEAT = ITEMS.register("cooked_crab_meat", () -> new FoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD), new FoodProperties.Builder()
            .meat()
            .nutrition(6)
            .saturationMod(0.9f)));
    public static final RegistryObject<Item> RAW_CRAB_MEAT = ITEMS.register("raw_crab_meat", () -> new FoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD), new FoodProperties.Builder()
            .meat()
            .nutrition(2)
            .saturationMod(0.3f)));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice", () -> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), (new Item.Properties()).tab(CreativeModeTab.TAB_FOOD).food(
            (new FoodProperties.Builder())
                    .nutrition(3)
                    .saturationMod(0.2F)
                    .build()
    )));
    public static final RegistryObject<Item> SALMON_SUSHI_ROLL = ITEMS.register("salmon_sushi_roll", () -> new FoodItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD), new FoodProperties.Builder()
            .meat()
            .nutrition(7)
            .saturationMod(1.0f)));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties itemProps){
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), itemProps));
    }
}
