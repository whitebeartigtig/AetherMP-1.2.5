package net.minecraft.server;

import java.util.*;

public class AetherGenClouds extends WorldGenerator
{
    private int cloudBlockId;
    private int meta;
    private int numberOfBlocks;
    private boolean flat;
    
    public AetherGenClouds(final int i, final int meta, final int j, final boolean flag) {
        this.cloudBlockId = i;
        this.meta = meta;
        this.numberOfBlocks = j;
        this.flat = flag;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        int x = i;
        int y = j;
        int z = k;
        final int xTendency = random.nextInt(3) - 1;
        final int zTendency = random.nextInt(3) - 1;
        for (int n = 0; n < this.numberOfBlocks; ++n) {
            x += random.nextInt(3) - 1 + xTendency;
            if ((random.nextBoolean() && !this.flat) || (this.flat && random.nextInt(10) == 0)) {
                y += random.nextInt(3) - 1;
            }
            z += random.nextInt(3) - 1 + zTendency;
            for (int x2 = x; x2 < x + random.nextInt(4) + 3 * (this.flat ? 3 : 1); ++x2) {
                for (int y2 = y; y2 < y + random.nextInt(1) + 2; ++y2) {
                    for (int z2 = z; z2 < z + random.nextInt(4) + 3 * (this.flat ? 3 : 1); ++z2) {
                        if (world.getTypeId(x2, y2, z2) == 0 && Math.abs(x2 - x) + Math.abs(y2 - y) + Math.abs(z2 - z) < 4 * (this.flat ? 3 : 1) + random.nextInt(2)) {
                            world.setTypeIdAndData(x2, y2, z2, this.cloudBlockId, this.meta);
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
