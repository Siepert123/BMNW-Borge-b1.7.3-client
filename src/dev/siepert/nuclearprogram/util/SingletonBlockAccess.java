package dev.siepert.nuclearprogram.util;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class SingletonBlockAccess implements IBlockAccess {
	public static final SingletonBlockAccess INSTANCE = new SingletonBlockAccess();
	public static SingletonBlockAccess get(int blockID, int metadata) {
		INSTANCE.blockID = blockID;
		INSTANCE.metadata = metadata;
		return INSTANCE;
	}
	public static IBlockAccess or(IBlockAccess world, int blockID, int metadata) {
		if (world != null) return world;
		return get(blockID, metadata);
	}

	public int blockID = 0;
	public int metadata = 0;

	@Override
	public int getBlockId(int x, int y, int z) {
		if (x != 0 || y != 0 || z != 0) return 0;
		else return this.blockID;
	}

	@Override
	public TileEntity getBlockTileEntity(int x, int y, int z) {
		return null;
	}

	@Override
	public float getBrightness(int x, int y, int z, int minimum) {
		return 1.0F;
	}

	@Override
	public float getLightBrightness(int x, int y, int z) {
		return 1.0F;
	}

	@Override
	public int getBlockMetadata(int x, int y, int z) {
		if (x != 0 || y != 0 || z != 0) return 0;
		else return this.metadata;
	}

	@Override
	public Material getBlockMaterial(int x, int y, int z) {
		if (x != 0 || y != 0 || z != 0) return Material.air;
		else {
			Block block = Block.blocksList[this.blockID];
			return block != null ? block.blockMaterial : Material.air;
		}
	}

	@Override
	public boolean isBlockOpaqueCube(int x, int y, int z) {
		if (x != 0 || y != 0 || z != 0) return false;
		else {
			Block block = Block.blocksList[this.blockID];
			return block != null && block.isOpaqueCube();
		}
	}

	@Override
	public boolean isBlockNormalCube(int x, int y, int z) {
		if (x != 0 || y != 0 || z != 0) return false;
		else {
			Block block = Block.blocksList[this.blockID];
			return block != null && block.isOpaqueCube() && block.renderAsNormalBlock();
		}
	}

	@Override
	public WorldChunkManager getWorldChunkManager() {
		return Minecraft.getTheMinecraft().theWorld.getWorldChunkManager();
	}
}
