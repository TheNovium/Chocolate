package com.awriterish.chocolate.setup.registration;

import com.awriterish.chocolate.common.entity.hostile.BabySkeleton;
import com.awriterish.chocolate.common.entity.hostile.BabyStray;
import com.awriterish.chocolate.common.entity.hostile.BabyWitherSkeleton;
import com.awriterish.chocolate.common.entity.neutral.Crab;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.awriterish.chocolate.Chocolate.MODID;

public class ModEntities {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);

    public static void init(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(bus);
    }

    public static final RegistryObject<EntityType<BabySkeleton>> BABY_SKELETON = ENTITIES.register("baby_skeleton",
            () -> EntityType.Builder.of(BabySkeleton::new, MobCategory.MONSTER)
                    .sized(0.75f, 1.9f)
                    .setShouldReceiveVelocityUpdates(false)
                    .clientTrackingRange(8)
                    .build("baby_skeleton"));
    public static final RegistryObject<EntityType<BabyStray>> BABY_STRAY = ENTITIES.register("baby_stray",
            () -> EntityType.Builder.of(BabyStray::new, MobCategory.MONSTER)
                    .sized(0.75f, 1.9f)
                    .setShouldReceiveVelocityUpdates(false)
                    .clientTrackingRange(8)
                    .build("baby_stray"));
    public static final RegistryObject<EntityType<BabyWitherSkeleton>> BABY_WITHER_SKELETON = ENTITIES.register("baby_wither_skeleton",
            () -> EntityType.Builder.of(BabyWitherSkeleton::new, MobCategory.MONSTER)
                    .sized(0.33f, 1.1f)
                    .setShouldReceiveVelocityUpdates(false)
                    .clientTrackingRange(8)
                    .build("baby_wither_skeleton"));
    public static final RegistryObject<EntityType<Crab>> CRAB = ENTITIES.register("crab",
            () -> EntityType.Builder.of(Crab::new, MobCategory.AMBIENT)
                    .sized(0.4f, 0.35f)
                    .setShouldReceiveVelocityUpdates(false)
                    .build("crab"));
}
