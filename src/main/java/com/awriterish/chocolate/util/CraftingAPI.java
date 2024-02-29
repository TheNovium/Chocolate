package com.awriterish.chocolate.util;

import com.awriterish.chocolate.Chocolate;
import com.awriterish.chocolate.util.villagers.VillagerTradeManager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Chocolate.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CraftingAPI {
    private static final List<VillagerTradeManager> VILLAGER_TRADES = new ArrayList<>();
    private static final List<VillagerTradeManager> WANDERING_TRADES = new ArrayList<>();

    public static void applyTrade(VillagerTradeManager trades){
        VILLAGER_TRADES.add(trades);
    }

    public static void applyTrade(VillagerTradeManager trades, boolean wandering){
        if(wandering){
            WANDERING_TRADES.add(trades);
        } else {
            applyTrade(trades);
        }
    }

    public static void registerVillagerTrades(VillagerTradesEvent e){
        if(e.getType()!= VillagerProfession.NONE){
            for(VillagerTradeManager currentManager : VILLAGER_TRADES){
                if(e.getType().equals(currentManager.getProfession())){
                    e.getTrades().get(currentManager.getLevel()).add(currentManager.getTrade());
                }
            }
        }
    }
}
