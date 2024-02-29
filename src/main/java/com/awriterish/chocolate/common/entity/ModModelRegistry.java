package com.awriterish.chocolate.common.entity;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.common.client.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModModelRegistry {
    private static final ModelLayerRegistry MODEL_LAYER_REGISTRY = ModelLayerRegistry.of(Chocolate.MODID);
    public static final ModelLayerLocation BABY_SKELETON = MODEL_LAYER_REGISTRY.register("baby_skeleton");
    public static final ModelLayerLocation BABY_SKELETON_ARMOR_INNER = MODEL_LAYER_REGISTRY.register("baby_skeleton", ModelLayerRegistry.Layer.INNER_ARMOR);
    public static final ModelLayerLocation BABY_SKELETON_ARMOR_OUTER = MODEL_LAYER_REGISTRY.register("baby_skeleton", ModelLayerRegistry.Layer.OUTER_ARMOR);
    public static final ModelLayerLocation BABY_STRAY = MODEL_LAYER_REGISTRY.register("baby_stray");
    public static final ModelLayerLocation BABY_STRAY_ARMOR_INNER = MODEL_LAYER_REGISTRY.register("baby_stray", ModelLayerRegistry.Layer.INNER_ARMOR);
    public static final ModelLayerLocation BABY_STRAY_ARMOR_OUTER = MODEL_LAYER_REGISTRY.register("baby_stray", ModelLayerRegistry.Layer.OUTER_ARMOR);
    public static final ModelLayerLocation BABY_STRAY_OUTER_LAYER = MODEL_LAYER_REGISTRY.register("baby_stray", ModelLayerRegistry.Layer.CLOTHES);
    public static final ModelLayerLocation BABY_WITHER_SKELETON = MODEL_LAYER_REGISTRY.register("baby_wither_skeleton");
    public static final ModelLayerLocation BABY_WITHER_SKELETON_ARMOR_INNER = MODEL_LAYER_REGISTRY.register("baby_wither_skeleton", ModelLayerRegistry.Layer.INNER_ARMOR);
    public static final ModelLayerLocation BABY_WITHER_SKELETON_ARMOR_OUTER = MODEL_LAYER_REGISTRY.register("baby_wither_skeleton", ModelLayerRegistry.Layer.OUTER_ARMOR);
}
