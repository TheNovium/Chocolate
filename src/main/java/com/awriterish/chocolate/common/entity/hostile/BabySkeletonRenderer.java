package com.awriterish.chocolate.common.entity.hostile;

import com.awriterish.chocolate.common.entity.ModModelRegistry;
import com.awriterish.chocolate.common.entity.layer.BackItemLayer;
import com.awriterish.chocolate.common.entity.layer.MainHandItemLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BabySkeletonRenderer extends MobRenderer<AbstractSkeleton, SkeletonModel<AbstractSkeleton>> {

    private static final ResourceLocation SKELETON_TEXTURE = new ResourceLocation("textures/entity/skeleton/skeleton.png");

    public BabySkeletonRenderer(EntityRendererProvider.Context context){
        this(context, ModModelRegistry.BABY_SKELETON, ModModelRegistry.BABY_SKELETON_ARMOR_INNER, ModModelRegistry.BABY_SKELETON_ARMOR_OUTER);
    }

    public BabySkeletonRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation, ModelLayerLocation innerArmor, ModelLayerLocation outerArmor){
        super(context, new SkeletonModel<>(context.bakeLayer(layerLocation)), 1.0f);
        this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), 2.67f, 2.67f, 2.67f));
        this.addLayer(new ElytraLayer<>(this, context.getModelSet()));
        this.addLayer(new MainHandItemLayer<>(this));
        this.addLayer(new BackItemLayer<>(this));
        this.addLayer(new HumanoidArmorLayer<>(this, new SkeletonModel<>(context.bakeLayer(innerArmor)), new SkeletonModel<>(context.bakeLayer(outerArmor))));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return SKELETON_TEXTURE;
    }

    @Override
    protected void scale(AbstractSkeleton livingEntity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.75f, 0.75f, 0.75f);
    }
}
