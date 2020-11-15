package net.minecraft.server;

import java.util.*;

public class AetherGenMinable extends WorldGenerator
{
    private int minableBlockId;
    private int numberOfBlocks;
    
    public AetherGenMinable(final int i, final int j) {
        this.minableBlockId = i;
        this.numberOfBlocks = j;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        final float f = random.nextFloat() * 3.141593f;
        final double d = i + 8 + MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d2 = i + 8 - MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d3 = k + 8 + MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d4 = k + 8 - MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d5 = j + random.nextInt(3) + 2;
        final double d6 = j + random.nextInt(3) + 2;
        for (int l = 0; l <= this.numberOfBlocks; ++l) {
            final double d7 = d + (d2 - d) * l / this.numberOfBlocks;
            final double d8 = d5 + (d6 - d5) * l / this.numberOfBlocks;
            final double d9 = d3 + (d4 - d3) * l / this.numberOfBlocks;
            final double d10 = random.nextDouble() * this.numberOfBlocks / 16.0;
            final double d11 = (MathHelper.sin(l * 3.141593f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final double d12 = (MathHelper.sin(l * 3.141593f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final int i2 = MathHelper.floor(d7 - d11 / 2.0);
            final int j2 = MathHelper.floor(d8 - d12 / 2.0);
            final int k2 = MathHelper.floor(d9 - d11 / 2.0);
            final int l2 = MathHelper.floor(d7 + d11 / 2.0);
            final int i3 = MathHelper.floor(d8 + d12 / 2.0);
            final int j3 = MathHelper.floor(d9 + d11 / 2.0);
            for (int k3 = i2; k3 <= l2; ++k3) {
                final double d13 = (k3 + 0.5 - d7) / (d11 / 2.0);
                if (d13 * d13 < 1.0) {
                    for (int l3 = j2; l3 <= i3; ++l3) {
                        final double d14 = (l3 + 0.5 - d8) / (d12 / 2.0);
                        if (d13 * d13 + d14 * d14 < 1.0) {
                            for (int i4 = k2; i4 <= j3; ++i4) {
                                final double d15 = (i4 + 0.5 - d9) / (d11 / 2.0);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && world.getTypeId(k3, l3, i4) == AetherBlocks.Holystone.id && world.getData(k3, l3, i4) <= 1) {
                                    world.setRawTypeId(k3, l3, i4, this.minableBlockId);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
