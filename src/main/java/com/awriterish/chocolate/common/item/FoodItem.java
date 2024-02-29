package com.awriterish.chocolate.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FoodItem extends Item {
    private final FoodProperties foodProperties;

    public FoodItem(Properties p, FoodProperties.Builder b){
        super(p);
        foodProperties = b.build();
    }

    public FoodProperties getFoodProperties(){
        return foodProperties;
    }

    @Override
    public boolean isEdible() {
        return true;
    }
}
