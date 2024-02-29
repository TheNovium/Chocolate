package com.awriterish.chocolate.util.villagers;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TradeLists implements VillagerTrades.ItemListing{
    protected final ItemStack price;
    protected final ItemStack altPrice;
    protected final ItemStack forSale;
    protected final int maxTrades;
    protected final int xp;
    protected final float priceMultiplier;

    public TradeLists(ItemStack price, ItemStack altPrice, ItemStack forSale, int maxTrades, int xp, float priceMultiplier){
        this.price = price;
        this.altPrice = altPrice;
        this.forSale = forSale;
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMultiplier = priceMultiplier;
    }

    public TradeLists(int emeralds, ItemStack forSale, int maxTrades, int xp){
        this(new ItemStack(Items.EMERALD, emeralds), ItemStack.EMPTY, forSale, maxTrades, xp, 1.0f);
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(Entity trader, Random random) {
        return new MerchantOffer(price, altPrice, forSale, maxTrades, xp, priceMultiplier);
    }
}
