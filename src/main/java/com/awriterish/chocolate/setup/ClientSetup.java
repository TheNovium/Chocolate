package com.awriterish.chocolate.setup;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.entity.ModModelRegistry;
import com.awriterish.chocolate.common.entity.hostile.BabySkeletonRenderer;
import com.awriterish.chocolate.common.entity.hostile.BabyStrayRenderer;
import com.awriterish.chocolate.common.entity.hostile.BabyWitherSkeletonRenderer;
import com.awriterish.chocolate.common.entity.neutral.CrabModel;
import com.awriterish.chocolate.common.entity.neutral.CrabRenderer;
import com.awriterish.chocolate.setup.registration.ModBlocks;
import com.awriterish.chocolate.setup.registration.ModEntities;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(FMLClientSetupEvent e){
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PURPLE_MUSHROOM_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RICE_CROP.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions e){
        //Register crabs
        e.registerLayerDefinition(CrabModel.LAYER_LOCATION, CrabModel::createBodyLayer);

        //Register the skeleton variants
        Supplier<LayerDefinition> skeletonLayer = SkeletonModel::createBodyLayer;
        Supplier<LayerDefinition> innerArmorLayer = () -> LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.INNER_ARMOR_DEFORMATION, 0.0f), 64, 32);
        Supplier<LayerDefinition> outerArmorLayer = () -> LayerDefinition.create(HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0f), 64, 32);
        Supplier<LayerDefinition> strayOuterLayer = () -> LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.25f), 0.0f), 64, 32);
        e.registerLayerDefinition(ModModelRegistry.BABY_SKELETON, skeletonLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_SKELETON_ARMOR_INNER, innerArmorLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_SKELETON_ARMOR_OUTER, outerArmorLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_STRAY, skeletonLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_STRAY_ARMOR_INNER, innerArmorLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_STRAY_ARMOR_OUTER, outerArmorLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_STRAY_OUTER_LAYER, strayOuterLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_WITHER_SKELETON, skeletonLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_WITHER_SKELETON_ARMOR_INNER, innerArmorLayer);
        e.registerLayerDefinition(ModModelRegistry.BABY_WITHER_SKELETON_ARMOR_OUTER, outerArmorLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers e){
        e.registerEntityRenderer(ModEntities.CRAB.get(), CrabRenderer::new);
        e.registerEntityRenderer(ModEntities.BABY_SKELETON.get(), BabySkeletonRenderer::new);
        e.registerEntityRenderer(ModEntities.BABY_STRAY.get(), BabyStrayRenderer::new);
        e.registerEntityRenderer(ModEntities.BABY_WITHER_SKELETON.get(), BabyWitherSkeletonRenderer::new);
    }
}
