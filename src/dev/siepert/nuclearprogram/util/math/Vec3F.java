package dev.siepert.nuclearprogram.util.math;

public class Vec3F {
	public float x, y, z;

	public Vec3F(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vec3F() {
		this(0.0F, 0.0F, 0.0F);
	}

	public void set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void set(Vec3F vec) {
		this.set(vec.x, vec.y, vec.z);
	}
}
