package dev.siepert.nuclearprogram.world.block;

import dev.siepert.nuclearprogram.init.ItemInit;
import net.minecraft.src.BlockClay;

import java.util.Random;

public class BlockFireclay extends BlockClay {
	public BlockFireclay(int blockID) {
		super(blockID, 0);
	}

	@Override
	public int idDropped(int meta, Random random) {
		return ItemInit.ballFireclay.shiftedIndex;
	}
}
