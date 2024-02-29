package com.awriterish.chocolate.common.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.FoodOnAStickItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;

public class BackItemLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {

    public BackItemLayer(RenderLayerParent<T, M> renderLayer){
        super(renderLayer);
    }

    @Override
    public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack backItem = entity.getOffhandItem();
        if(!backItem.isEmpty()){
            matrixStack.pushPose();
            ModelPart body = this.getParentModel().body;
            body.translateAndRotate(matrixStack);
            float scale = 2.0f;
            float armorOffset = entity.getItemBySlot(EquipmentSlot.CHEST).isEmpty() ? 0.18f : 0.24f;
            if(this.getParentModel().young){
                matrixStack.translate(0.0d, 0.75d, 0.0d);
                scale *= 0.5f;
                armorOffset *= 0.5f;
            }

            if(backItem.getItem() instanceof TridentItem){
                scale *= 0.5f;
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(40.0f));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(52.0f));
                matrixStack.mulPose(Vector3f.ZP.rotationDegrees(-25.0f));
                matrixStack.scale(scale, -scale, -scale);
                matrixStack.translate(-armorOffset, 0.0d, 0.0d);
                Minecraft.getInstance().getItemInHandRenderer().renderItem(entity, backItem, ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, false, matrixStack, buffer, packedLight);
            } else {
                matrixStack.translate(0.0d, 0.0d, armorOffset);
                matrixStack.scale(scale, scale, scale);
                if(backItem.getItem() instanceof FishingRodItem || backItem.getItem() instanceof FoodOnAStickItem){
                    matrixStack.mulPose(Vector3f.ZP.rotationDegrees(180.0f));
                    matrixStack.translate(0.0d, -0.3d, 0.0d);
                }
                Minecraft.getInstance().getItemInHandRenderer().renderItem(entity, backItem, ItemTransforms.TransformType.GROUND, false, matrixStack, buffer, packedLight);
            }

            matrixStack.popPose();
        }
    }
}
