package com.villageofidiots.skillcraft.talents;

import java.util.concurrent.Callable;

public final class TalentsFactory implements Callable<ITalents> {

	@Override
	public ITalents call() throws Exception {
		// POST: returns the default implementation of the capability
		return new Talents();
	}
}
