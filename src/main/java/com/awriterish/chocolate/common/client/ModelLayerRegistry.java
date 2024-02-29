package com.awriterish.chocolate.common.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public record ModelLayerRegistry(String namespace) {

    public enum Layer {
        OUTER_ARMOR("outer_armor"),
        INNER_ARMOR("inner_armor"),
        CLOTHES("outer"),
        MAIN("main");

        private final String layerLoc;

        Layer(String layerLoc) {
            this.layerLoc = layerLoc;
        }

        public String getLayerLoc() {
            return layerLoc;
        }
    }

    public ModelLayerLocation register(String loc) {
        return this.register(loc, "main");
    }

    public ModelLayerLocation register(String loc, String layer) {
        return new ModelLayerLocation(new ResourceLocation(this.namespace, loc), layer);
    }

    public ModelLayerLocation register(String loc, ModelLayerRegistry.Layer layer) {
        return this.register(loc, layer.getLayerLoc());
    }

    public static ModelLayerRegistry of(String namespace) {
        return new ModelLayerRegistry(namespace);
    }

}
