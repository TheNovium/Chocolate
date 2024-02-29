package com.awriterish.chocolate.setup.registration;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModParticles {
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        PARTICLE_TYPES.register(bus);
    }

    public static final RegistryObject<SimpleParticleType> MUSHROOM_PARTICLE = PARTICLE_TYPES.register("mushroom_growth", () -> new SimpleParticleType(false));
}
