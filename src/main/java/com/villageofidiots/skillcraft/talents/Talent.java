package com.villageofidiots.skillcraft.talents;

import net.minecraft.nbt.StringNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class Talent implements ITalent, INBTSerializable<StringNBT> {
	
	// Properties
	public String name = "Default";
	
	// Constructors
	public Talent() {}
	
	public Talent(String name) {
		this.name = name;
	}
	
	// ITalent Methods
	public String getName() {
		return this.name;
	}
	
	public void onAttack() {
		// TODO: perform something when the player hits an enemy
	}

	// ICapabilitySerializable
	@Override
	public StringNBT serializeNBT() {
		// POST: serializes this talent as an NBT
		return StringNBT.valueOf(this.name);
	}

	@Override
	public void deserializeNBT(StringNBT nbt) {
		// POST: deserializes this talent to obtain its data
		this.name = nbt.getAsString();
	}
}
