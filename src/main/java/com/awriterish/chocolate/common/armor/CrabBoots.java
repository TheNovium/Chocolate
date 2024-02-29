package com.awriterish.chocolate.common.armor;

import com.awriterish.chocolate.setup.registration.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CrabBoots extends ArmorItem {
    private boolean leftWater;

    public CrabBoots(){
        super(ModArmorMaterial.CRAB, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
        leftWater = true;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(player.isInWaterOrRain()){
            if(leftWater){
                player.addEffect(new MobEffectInstance(ModEffects.DEPTH_STRIDER.get(), 200, 2, true, false, true));
                leftWater = false;
            }
        } else {
            player.removeEffect(ModEffects.DEPTH_STRIDER.get());
            leftWater = true;
        }
    }
}
