package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.effect.ModEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModEffects {
    private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EFFECTS.register(bus);
    }

    public static final RegistryObject<MobEffect> DEPTH_STRIDER = EFFECTS.register("depth_strider", () -> new ModEffect(MobEffectCategory.BENEFICIAL, 0x006994)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, "736dc227-e77a-470d-a9ab-ec8b771c7712", 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL));
}
