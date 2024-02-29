package com.awriterish.chocolate.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class MushroomGrowthParticle extends TextureSheetParticle {
    public MushroomGrowthParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.setSize(0.02f, 0.02f);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.5F;
        this.lifetime = (int)(15.0D / (Math.random() * 0.8D + 0.2D));
    }

    public void move(double pX, double pY, double pZ) {
        this.setBoundingBox(this.getBoundingBox().move(pX, pY, pZ));
        this.setLocationFromBoundingbox();
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 0.99D;
            this.yd *= 0.99D;
            this.zd *= 0.99D;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class PurpleParticleProvider implements ParticleProvider<SimpleParticleType> {
        protected final SpriteSet sprites;

        public PurpleParticleProvider(SpriteSet sprites){
            this.sprites = sprites;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            MushroomGrowthParticle particle = new MushroomGrowthParticle(pLevel, pX, pY, pZ);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }

}
