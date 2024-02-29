package com.awriterish.chocolate.util.mixin;

import com.awriterish.chocolate.worldgen.IExtendedBiomeSource;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

@Mixin({BiomeSource.class})
public abstract class MixinBiomeSource implements BiomeResolver, IExtendedBiomeSource {
    @Shadow
    public Set<Holder<Biome>> biomes;
    @Shadow
    public Supplier<List<BiomeSource.StepFeatureData>> featuresPerStep;
    private List<Holder<Biome>> originalBiomeList;

    public MixinBiomeSource(){}

    @Shadow
    abstract List<BiomeSource.StepFeatureData> getFeatures(List<Holder<Biome>> biome, boolean find);

    @Inject(
            method = {"<init>(Ljava/util/List;)V"},
            at = {@At("RETURN")}
    )
    protected void onInit(List<Holder<Biome>> biomes, CallbackInfo info){
        originalBiomeList = biomes;
    }

    @Override
    public void appendDeferredBiomesList(List<Holder<Biome>> biomesToAdd) {
        ImmutableList.Builder<Holder<Biome>> builder = ImmutableList.builder();
        builder.addAll(originalBiomeList);
        builder.addAll(biomesToAdd);
        ImmutableList<Holder<Biome>> biomeList = builder.build().stream().distinct().collect(ImmutableList.toImmutableList());
        biomes = new ObjectLinkedOpenHashSet<>(biomeList);
        featuresPerStep = Suppliers.memoize(() -> {
            return getFeatures(biomeList, true);
        });
    }
}
