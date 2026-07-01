package dev.siepert.nuclearprogram.world.block;

import net.minecraft.src.World;

public interface IDetonateBehaviour {
	Callback detonate(World world, int x, int y, int z);

	enum Callback {
		SUCCESS, INVALID, MISSING_COMPONENTS;
	}
}
