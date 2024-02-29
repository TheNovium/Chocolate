package com.awriterish.chocolate.common.entity.hostile;

import com.awriterish.chocolate.common.entity.ModModelRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BabyWitherSkeletonRenderer extends SkeletonRenderer {
    private static final ResourceLocation WITHER_SKELETON_TEXTURE = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");

    public BabyWitherSkeletonRenderer(EntityRendererProvider.Context context){
        this(context, ModModelRegistry.BABY_WITHER_SKELETON, ModModelRegistry.BABY_WITHER_SKELETON_ARMOR_INNER, ModModelRegistry.BABY_WITHER_SKELETON_ARMOR_OUTER);
    }

    public BabyWitherSkeletonRenderer(EntityRendererProvider.Context context, ModelLayerLocation layerLocation, ModelLayerLocation innerArmor, ModelLayerLocation outerArmor) {
        super(context);
        this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), 2.0f, 2.0f, 2.0f));
        this.addLayer(new ElytraLayer<>(this, context.getModelSet()));
        this.addLayer(new ItemInHandLayer<>(this));
        this.addLayer(new HumanoidArmorLayer(this, new SkeletonModel<>(context.bakeLayer(innerArmor)), new SkeletonModel<>(context.bakeLayer(outerArmor))));

    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return WITHER_SKELETON_TEXTURE;
    }

    protected void scale(AbstractSkeleton livingEntity, PoseStack matrixStack, float partialTickTime) {
        matrixStack.scale(0.6f, 0.6f, 0.6f);
    }

}
