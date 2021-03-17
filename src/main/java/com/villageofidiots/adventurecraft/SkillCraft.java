package com.villageofidiots.adventurecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod("skillcraft")
public class SkillCraft {
	public static final String MODID = "skillcraft";
	public static final Logger LOGGER = LogManager.getLogger();

	// Constructor
	public SkillCraft() {
		LOGGER.debug("Hello!");
	}
}
