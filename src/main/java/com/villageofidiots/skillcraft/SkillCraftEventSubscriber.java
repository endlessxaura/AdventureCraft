package com.villageofidiots.skillcraft;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import com.villageofidiots.skillcraft.talents.TalentsHandler;

// This annotation specifically allows us to subscribe to mod lifecycles themselves, rather than in-game events
@Mod.EventBusSubscriber(modid = SkillCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkillCraftEventSubscriber {

	// This event listens to when setup for the mod may begin and then begins initializing
    @SubscribeEvent
    static void onCommonSetup(FMLCommonSetupEvent event) {
    	TalentsHandler.register();
    }
}
