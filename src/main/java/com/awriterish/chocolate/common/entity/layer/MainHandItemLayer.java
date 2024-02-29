package com.awriterish.chocolate.common.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MainHandItemLayer<T extends LivingEntity, M extends EntityModel<T> & ArmedModel> extends RenderLayer<T, M> {

    public MainHandItemLayer(RenderLayerParent<T, M> parentLayer){
        super(parentLayer);
    }

    @Override
    public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack heldItem = entity.getMainHandItem();
        if(!heldItem.isEmpty()){
            matrixStack.pushPose();
            if(this.getParentModel().young){
                matrixStack.translate(0.0d, 0.75d, 0.0d);
                matrixStack.scale(0.5f, 0.5f, 0.5f);
            }

            if(entity.getMainArm() == HumanoidArm.RIGHT){
                renderArmWithItem(entity, heldItem, ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HumanoidArm.RIGHT, matrixStack, buffer, packedLight);
            } else if(entity.getMainArm() == HumanoidArm.LEFT) {
                renderArmWithItem(entity, heldItem, ItemTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HumanoidArm.LEFT, matrixStack, buffer, packedLight);
            }

            matrixStack.popPose();
        }
    }

    protected void renderArmWithItem(LivingEntity entity, ItemStack heldItem, ItemTransforms.TransformType transformType, HumanoidArm arm, PoseStack matrixStack, MultiBufferSource buffer, int packedLight){
        if(!heldItem.isEmpty()){
            matrixStack.pushPose();
            this.getParentModel().translateToHand(arm, matrixStack);
            matrixStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
            boolean flag = arm == HumanoidArm.LEFT;
            matrixStack.translate((double)((float)(flag ? -1 : 1) / 16.0F), 0.125D, -0.625D);
            Minecraft.getInstance().getItemInHandRenderer().renderItem(entity, heldItem, transformType, flag, matrixStack, buffer, packedLight);
            matrixStack.popPose();
        }
    }
}
