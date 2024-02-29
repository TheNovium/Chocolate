package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.block.entity.RedstoneGateBlockEntity;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModBlockEntities {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCK_ENTITIES.register(bus);
    }

    public static final RegistryObject<BlockEntityType<RedstoneGateBlockEntity>> REDSTONE_GATE_BLOCK = BLOCK_ENTITIES.register("redstone_gate_block", () -> BlockEntityType.Builder.of(RedstoneGateBlockEntity::new, ModBlocks.REDSTONE_GATE.get()).build(Util.fetchChoiceType(References.BLOCK_ENTITY, "redstone_gate")));
}
