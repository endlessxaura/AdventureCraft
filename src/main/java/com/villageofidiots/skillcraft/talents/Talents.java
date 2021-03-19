package com.villageofidiots.skillcraft.talents;

import java.util.ArrayList;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class Talents implements ITalents {

	// Properties
	public ArrayList<Talent> talents = new ArrayList<Talent>();
	private LazyOptional<ITalents> talentsCapability = LazyOptional.of(() -> this);
	
	// Constructor
	
	// Methods
	@Override
	public ArrayList<Talent> getTalents() {
		return this.talents;
	}
	
	@SuppressWarnings({ "hiding" })
	@Override
	public <ITalents> LazyOptional<ITalents> getCapability(Capability<ITalents> cap, Direction side) {
		// PRE: the capability itself and the side we're pulling from
		// POST: gets an instance of the talents capability
		return cap == TalentsHandler.TALENT_HANDLER_CAPABILITY ? talentsCapability.cast() : LazyOptional.empty();
	}

	@Override
	public ListNBT serializeNBT() {
		// POST: serializes the data to the player NBTs
		ListNBT talentsNBT = new ListNBT();
		this.talents.forEach((Talent talent) -> {
			talentsNBT.add(talent.serializeNBT());
		});
		return talentsNBT;
	}

	@Override
	public void deserializeNBT(ListNBT nbt) {
		// POST: extracts the data from the player NBTs to form the list of talents
		nbt.forEach((INBT talentNBT) -> {
			Talent talent = new Talent();
			talent.deserializeNBT((StringNBT) talentNBT);
			this.talents.add(talent);
		});
	}
}
