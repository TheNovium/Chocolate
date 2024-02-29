package com.awriterish.chocolate.common.entity.neutral;

import com.awriterish.chocolate.Chocolate;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class CrabRenderer<T extends Crab> extends MobRenderer<T, CrabModel<T>> {

    private final ResourceLocation TEXTURE = new ResourceLocation(Chocolate.MODID, "textures/entity/crab/crab_pink.png");

    public CrabRenderer(EntityRendererProvider.Context context){
        super(context, new CrabModel(context.bakeLayer(CrabModel.LAYER_LOCATION)), 0.6f);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(Crab pEntity) {
        return new ResourceLocation(Chocolate.MODID, "textures/entity/crab/crab_" + pEntity.getColor() + ".png");
    }

}
