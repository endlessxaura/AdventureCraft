package com.villageofidiots.skillcraft.talents;

import java.util.ArrayList;

import net.minecraft.nbt.ListNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public interface ITalents extends ICapabilitySerializable<ListNBT> {
	ArrayList<Talent> getTalents();
}
