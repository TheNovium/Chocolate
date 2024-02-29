package com.awriterish.chocolate.util.villagers;

import com.awriterish.chocolate.util.CraftingAPI;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class VillagerTradesAPI {
    public static final List<VillagerTradeManager> VILLAGER_TRADES = new ArrayList<>();
    public static final List<VillagerTradeManager> WANDERING_TRADES = new ArrayList<>();

    public VillagerTradesAPI(){}

    public void addTrade(VillagerProfession profession, int level, ItemStack buying, ItemStack selling, int xp, int maxTrades){
        TradeLists trade = new TradeLists(buying, ItemStack.EMPTY, selling, maxTrades, xp, 1.0f);
        addTrade(profession, level, trade);
    }

    public void addTrade(VillagerProfession profession, int level, int emeralds, ItemStack selling, int xp, int maxTrades){
        TradeLists trade = new TradeLists(emeralds, selling, maxTrades, xp);
        addTrade(profession, level, trade);
    }

    public void addTrade(VillagerTradeManager tradeManager){
        applyTrade(tradeManager, false);
    }

    private void addTrade(VillagerProfession profession, int level, TradeLists trade){
        applyTrade(new VillagerTradeManager(profession, trade, level), false);
    }

    private void addWanderingTrade(int level, VillagerTrades.ItemListing trade){
        applyTrade(new VillagerTradeManager(VillagerProfession.NONE, trade, level), true);
    }

    private void applyTrade(VillagerTradeManager trades, boolean wandering){
        if(wandering){
            WANDERING_TRADES.add(trades);
        } else {
            VILLAGER_TRADES.add(trades);
        }
        CraftingAPI.applyTrade(trades);
    }
}
