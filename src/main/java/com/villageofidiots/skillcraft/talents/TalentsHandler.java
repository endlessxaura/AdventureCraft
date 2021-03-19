package com.villageofidiots.skillcraft.talents;

import com.villageofidiots.skillcraft.SkillCraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TalentsHandler {
	
	// Properties
	@CapabilityInject(ITalents.class)	// This injects a globally exposed capability into this variable
    public static Capability<ITalents> TALENT_HANDLER_CAPABILITY = null;
	
	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		// POST: subscribes to the attach capability event. This attaches the capability to the player. (Supposedly: untested)
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(SkillCraft.MODID, "Talents"), new Talents());
		}
	}

	// This function registers the capability globally
	public static void register()
	{		
		// POST: registers this capability and sets up the event handler to attach the capability
		CapabilityManager.INSTANCE.register(
			ITalents.class, 
			new TalentsStorage(), 
			new TalentsFactory()
		);
		MinecraftForge.EVENT_BUS.register(TalentsHandler.class);
	}
}
