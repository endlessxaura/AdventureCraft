package com.villageofidiots.skillcraft.talents;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public final class TalentsStorage implements Capability.IStorage<ITalents> {

	@Override
	public INBT writeNBT(Capability<ITalents> capability, ITalents instance, Direction side) {
		// POST: saves the talents to NBT data
		return instance.serializeNBT();
	}

	@Override
	public void readNBT(Capability<ITalents> capability, ITalents instance, Direction side, INBT nbt) {
		// POST: extracts the talents from NBT data
		instance.deserializeNBT((ListNBT) nbt);
	}

}
