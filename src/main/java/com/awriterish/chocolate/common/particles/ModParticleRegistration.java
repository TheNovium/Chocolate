package com.awriterish.chocolate.common.particles;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.setup.registration.ModParticles;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModParticleRegistration {

    @SubscribeEvent
    public static void registerModParticles(ParticleFactoryRegisterEvent e){
        Minecraft.getInstance().particleEngine.register(ModParticles.MUSHROOM_PARTICLE.get(), MushroomGrowthParticle.PurpleParticleProvider::new);
    }

}
