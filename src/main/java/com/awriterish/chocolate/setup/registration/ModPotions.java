package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.item.Potions;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        POTIONS.register(bus);
    }

    public static final RegistryObject<Potion> POTION_OF_VITALITY_I = POTIONS.register("potion_of_vitality_i", Potions.POTION_OF_VITALITY_I::getPotion);
    public static final RegistryObject<Potion> POTION_OF_VITALITY_II = POTIONS.register("position_of_vitality_ii", Potions.POTION_OF_VITALITY_II::getPotion);
}
