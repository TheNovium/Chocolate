package com.awriterish.chocolate.util.villagers;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VillagerTradeManager {
    protected VillagerProfession profession;
    private final VillagerTrades.ItemListing trade;
    private final int level;

    public VillagerTradeManager(VillagerProfession profession, VillagerTrades.ItemListing trade, int level){
        this.profession = profession;
        this.trade = trade;
        this.level = level;
    }

    public Int2ObjectMap<VillagerTrades.ItemListing[]> getDefaultTrades(){
        return VillagerTrades.TRADES.computeIfAbsent(profession, (villagerProfession) -> {
            return new Int2ObjectArrayMap<>();
        });
    }

    protected List<VillagerTrades.ItemListing> getVillagerTrades(){
        VillagerTrades.ItemListing[] trades = getDefaultTrades().computeIfAbsent(level, (integer) -> {
            return new VillagerTrades.ItemListing[0];
        });
        return new ArrayList<>(Arrays.asList(trades));
    }

    public void add(){
        List<VillagerTrades.ItemListing> tradeList = getVillagerTrades();
        add(tradeList);
    }

    public void add(List<VillagerTrades.ItemListing> tradeList){
        tradeList.add(trade);
    }

    public int getLevel() {
        return level;
    }

    public VillagerTrades.ItemListing getTrade() {
        return trade;
    }

    public VillagerProfession getProfession() {
        return profession;
    }
}
