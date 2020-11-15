package net.minecraft.server;

import java.util.*;

public class AetherGenGoldenOak extends WorldGenerator
{
    public boolean branch(final World world, final Random random, int i, int j, int k, final int slant) {
        final int directionX = random.nextInt(3) - 1;
        final int directionY = slant;
        final int directionZ = random.nextInt(3) - 1;
        for (int n = 0; n < random.nextInt(2) + 1; ++n) {
            i += directionX;
            j += directionY;
            k += directionZ;
            if (world.getTypeId(i, j, k) == AetherBlocks.GoldenOakLeaves.id) {
                world.setRawTypeIdAndData(i, j, k, AetherBlocks.Log.id, 2);
            }
        }
        return true;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        if (world.getTypeId(i, j - 1, k) != AetherBlocks.Grass.id && world.getTypeId(i, j - 1, k) != AetherBlocks.Dirt.id) {
            return false;
        }
        final int height = random.nextInt(5) + 6;
        for (int x = i - 3; x < i + 4; ++x) {
            for (int y = j + 5; y < j + 12; ++y) {
                for (int z = k - 3; z < k + 4; ++z) {
                    if ((x - i) * (x - i) + (y - j - 8) * (y - j - 8) + (z - k) * (z - k) < 12 + random.nextInt(5) && world.getTypeId(x, y, z) == 0) {
                        world.setRawTypeId(x, y, z, AetherBlocks.GoldenOakLeaves.id);
                    }
                }
            }
        }
        for (int n = 0; n < height; ++n) {
            if (n > 4 && random.nextInt(3) > 0) {
                this.branch(world, random, i, j + n, k, n / 4 - 1);
            }
            world.setRawTypeIdAndData(i, j + n, k, AetherBlocks.Log.id, 2);
        }
        return true;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
