package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.block.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS =  DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
    }

    //public static final RegistryObject<Block> BARREL_OF = BLOCKS.register("barrel_of", () -> new BarrelOfBlock(Items.APPLE));
    public static final RegistryObject<Block> CARROT_CAKE = BLOCKS.register("carrot_cake", () -> new CarrotCakeBlock(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5f).sound(SoundType.WOOL)));
    public static final RegistryObject<Block> END_STONE_RUBY_ORE = BLOCKS.register("end_stone_ruby_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPLE_MUSHROOM_BLOCK = BLOCKS.register("purple_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT).strength(0.2F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PURPLE_MUSHROOM_CROP = BLOCKS.register("purple_mushroom_crop", PurpleMushroomBlock::new);
    public static final RegistryObject<Block> REDSTONE_GATE = BLOCKS.register("redstone_gate", () -> new RedstoneGateBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop", () -> new RiceBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(5.5f).requiresCorrectToolForDrops()));
}
