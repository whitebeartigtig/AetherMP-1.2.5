package net.minecraft.server;

import java.util.*;

public class AetherGenSkyroot extends WorldGenerator
{
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        final int l = random.nextInt(3) + 4;
        boolean flag = true;
        if (j < 1 || j + l + 1 > 128) {
            return false;
        }
        for (int i2 = j; i2 <= j + 1 + l; ++i2) {
            byte byte0 = 1;
            if (i2 == j) {
                byte0 = 0;
            }
            if (i2 >= j + 1 + l - 2) {
                byte0 = 2;
            }
            for (int i3 = i - byte0; i3 <= i + byte0 && flag; ++i3) {
                for (int l2 = k - byte0; l2 <= k + byte0 && flag; ++l2) {
                    if (i2 >= 0 && i2 < 128) {
                        final int j2 = world.getTypeId(i3, i2, l2);
                        if (j2 != 0 && j2 != AetherBlocks.SkyrootLeaves.id) {
                            flag = false;
                        }
                    }
                    else {
                        flag = false;
                    }
                }
            }
        }
        if (!flag) {
            return false;
        }
        final int j3 = world.getTypeId(i, j - 1, k);
        if ((j3 != AetherBlocks.Grass.id && j3 != AetherBlocks.Dirt.id) || j >= 128 - l - 1) {
            return false;
        }
        world.setRawTypeId(i, j - 1, k, AetherBlocks.Dirt.id);
        for (int k2 = j - 3 + l; k2 <= j + l; ++k2) {
            final int j4 = k2 - (j + l);
            for (int i4 = 1 - j4 / 2, k3 = i - i4; k3 <= i + i4; ++k3) {
                final int l3 = k3 - i;
                for (int i5 = k - i4; i5 <= k + i4; ++i5) {
                    final int j5 = i5 - k;
                    if ((Math.abs(l3) != i4 || Math.abs(j5) != i4 || (random.nextInt(2) != 0 && j4 != 0)) && !Block.n[world.getTypeId(k3, k2, i5)]) {
                        world.setRawTypeId(k3, k2, i5, AetherBlocks.SkyrootLeaves.id);
                    }
                }
            }
        }
        for (int l4 = 0; l4 < l; ++l4) {
            final int k4 = world.getTypeId(i, j + l4, k);
            if (k4 == 0 || k4 == AetherBlocks.SkyrootLeaves.id) {
                world.setRawTypeIdAndData(i, j + l4, k, AetherBlocks.Log.id, 0);
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
