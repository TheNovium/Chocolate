package com.awriterish.chocolate.common.entity.hostile;

import com.awriterish.chocolate.common.entity.ModModelRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.StrayClothingLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BabyStrayRenderer extends BabySkeletonRenderer {

    private static final ResourceLocation STRAY_TEXTURE = new ResourceLocation("textures/entity/skeleton/stray.png");

    public BabyStrayRenderer(EntityRendererProvider.Context context){
        super(context, ModModelRegistry.BABY_STRAY, ModModelRegistry.BABY_STRAY_ARMOR_INNER, ModModelRegistry.BABY_STRAY_ARMOR_OUTER);
        this.addLayer(new StrayClothingLayer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(AbstractSkeleton entity) {
        return STRAY_TEXTURE;
    }

}
