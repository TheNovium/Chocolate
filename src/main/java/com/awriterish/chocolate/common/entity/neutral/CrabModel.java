package com.awriterish.chocolate.common.entity.neutral;
// Made with Blockbench 4.1.1 (With some fixes from yours truly)
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.awriterish.chocolate.Chocolate;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CrabModel<T extends Crab> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Chocolate.MODID, "crab"), "main");
    private final ModelPart mainBody;
    private final ModelPart leftClawBottom;
    private final ModelPart leftClawTop;
    private final ModelPart rightClawBottom;
    private final ModelPart rightClawTop;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart leftBackLeg;

    private boolean swimming = false;

    public CrabModel(ModelPart root) {
        super();
        this.mainBody = root.getChild("mainbody");
        this.leftClawBottom = root.getChild("leftClawBottom");
        this.leftClawTop = root.getChild("leftClawTop");
        this.rightClawBottom = root.getChild("rightClawBottom");
        this.rightClawTop = root.getChild("RightClawTop");
        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightMiddleLeg = root.getChild("rightMiddleLeg");
        this.rightBackLeg = root.getChild("rightBackLeg");
        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftMiddleLeg = root.getChild("leftMiddleLeg");
        this.leftBackLeg = root.getChild("leftBackLeg");
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition mainbody = partdefinition.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -2.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition righteye_r1 = mainbody.addOrReplaceChild("righteye_r1", CubeListBuilder.create().texOffs(0, 0).addBox(1.5F, -4.5F, -2.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

        PartDefinition lefteye_r1 = mainbody.addOrReplaceChild("lefteye_r1", CubeListBuilder.create().texOffs(7, 7).addBox(-2.5F, -4.5F, -2.75F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition leftClawBottom = partdefinition.addOrReplaceChild("leftClawBottom", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-2.0F, 1.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(2, 10).addBox(-2.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-2.0F, 0.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 7).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 9).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 20.25F, -1.0F, 0.2618F, -0.2618F, 0.0F));

        PartDefinition leftClawTop = partdefinition.addOrReplaceChild("leftClawTop", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-2.0F, 0.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 9).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 9).addBox(0.0F, 0.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 0).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 20.25F, -1.0F, -0.0873F, -0.2618F, 0.0F));

        PartDefinition rightClawBottom = partdefinition.addOrReplaceChild("rightClawBottom", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(0.0F, 1.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).mirror().addBox(0.0F, 0.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(3, 0).addBox(1.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(2.0F, 0.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 20.25F, -1.0F, 0.2618F, 0.2618F, 0.0F));

        PartDefinition RightClawTop = partdefinition.addOrReplaceChild("RightClawTop", CubeListBuilder.create().texOffs(0, 7).addBox(0.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(4, 9).addBox(0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 9).addBox(2.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 9).addBox(2.0F, 0.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 0).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 20.25F, -1.0F, -0.0873F, 0.2618F, 0.0F));

        PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg", CubeListBuilder.create(), PartPose.offset(4.0F, 23.9821F, 0.0F));

        PartDefinition rightfrontleg_r1 = rightFrontLeg.addOrReplaceChild("rightfrontleg_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-0.5F, -2.0F, 1.5F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0179F, -1.75F, 0.0F, 0.0F, -0.5236F));

        PartDefinition rightMiddleLeg = partdefinition.addOrReplaceChild("rightMiddleLeg", CubeListBuilder.create(), PartPose.offset(4.0F, 23.9821F, 1.25F));

        PartDefinition rightmiddleleg_r1 = rightMiddleLeg.addOrReplaceChild("rightmiddleleg_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-0.5F, -2.0F, 2.75F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0179F, -3.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg", CubeListBuilder.create(), PartPose.offset(4.0F, 23.9821F, 2.5F));

        PartDefinition rightmiddleleg_r2 = rightBackLeg.addOrReplaceChild("rightmiddleleg_r2", CubeListBuilder.create().texOffs(1, 3).addBox(-0.5F, -2.0F, 4.0F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0179F, -4.25F, 0.0F, 0.0F, -0.5236F));

        PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, 23.9821F, 0.0F));

        PartDefinition leftfrontleg_r1 = leftFrontLeg.addOrReplaceChild("leftfrontleg_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-0.25F, -1.75F, 1.5F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7321F, -0.25F, -1.75F, 0.0F, 0.0F, 0.5236F));

        PartDefinition leftMiddleLeg = partdefinition.addOrReplaceChild("leftMiddleLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, 23.9821F, 1.25F));

        PartDefinition leftmiddleleg_r1 = leftMiddleLeg.addOrReplaceChild("leftmiddleleg_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-0.25F, -1.75F, 2.75F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7321F, -0.25F, -3.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, 23.9821F, 2.5F));

        PartDefinition leftbackleg_r1 = leftBackLeg.addOrReplaceChild("leftbackleg_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-0.25F, -1.75F, 4.0F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7321F, -0.25F, -4.25F, 0.0F, 0.0F, 0.5236F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public void prepareMobModel(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick) {
        this.swimming = pEntity.isVisuallySwimming();

        super.prepareMobModel(pEntity, pLimbSwing, pLimbSwingAmount, pPartialTick);
    }

    @Override
    public void setupAnim(Crab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftFrontLeg.yRot = Mth.cos(limbSwing * 3.0f) * 0.5f;
        this.leftMiddleLeg.yRot = Mth.cos(limbSwing * 3.0f + (float)Math.PI * 0.333f) * 0.5f;
        this.leftBackLeg.yRot = Mth.cos(limbSwing * 3.0f + (float)Math.PI * 0.666f) * 0.5f;
        this.rightFrontLeg.yRot = Mth.cos(limbSwing * 3.0f) * 0.5f;
        this.rightMiddleLeg.yRot = Mth.cos(limbSwing * 3.0f + (float)Math.PI * 0.333f) * 0.5f;
        this.rightBackLeg.yRot = Mth.cos(limbSwing * 3.0f + (float)Math.PI * 0.666f) * 0.5f;

        if(entity.isVisuallySwimming()){
            this.leftFrontLeg.yRot += 0.3f;
            this.leftMiddleLeg.yRot += 0.3f;
            this.leftBackLeg.yRot += 0.3f;
            this.rightFrontLeg.yRot += 0.3f;
            this.rightMiddleLeg.yRot += 0.3f;
            this.rightBackLeg.yRot += 0.3f;
        }

        if(entity.isAggressive()){
            this.leftClawBottom.xRot = 0.08f + Math.abs(Mth.cos(limbSwing *3.5f)) * 0.3f;
            this.leftClawTop.xRot = -0.011f - Math.abs(Mth.cos(limbSwing * 3.5f)) * 0.3f;
            this.rightClawBottom.xRot = 0.08f + Math.abs(Mth.cos(limbSwing * 3.5f)) * 0.3f;
            this.rightClawTop.xRot = -0.011f - Math.abs(Mth.cos(limbSwing * 3.5f)) * 0.3f;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(this.young){
            poseStack.scale(0.35f, 0.35f, 0.35f);
            poseStack.translate(0, 2.8, 0);
        }
        mainBody.render(poseStack, buffer, packedLight, packedOverlay);
        leftClawBottom.render(poseStack, buffer, packedLight, packedOverlay);
        leftClawTop.render(poseStack, buffer, packedLight, packedOverlay);
        rightClawBottom.render(poseStack, buffer, packedLight, packedOverlay);
        rightClawTop.render(poseStack, buffer, packedLight, packedOverlay);
        rightFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightMiddleLeg.render(poseStack, buffer, packedLight, packedOverlay);
        rightBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftFrontLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftMiddleLeg.render(poseStack, buffer, packedLight, packedOverlay);
        leftBackLeg.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
