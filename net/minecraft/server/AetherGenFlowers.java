package net.minecraft.server;

import java.util.*;

public class AetherGenFlowers extends WorldGenerator
{
    private int plantBlockId;
    
    public AetherGenFlowers(final int i) {
        this.plantBlockId = i;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        for (int l = 0; l < 64; ++l) {
            final int i2 = i + random.nextInt(8) - random.nextInt(8);
            final int j2 = j + random.nextInt(4) - random.nextInt(4);
            final int k2 = k + random.nextInt(8) - random.nextInt(8);
            if (world.isEmpty(i2, j2, k2) && ((BlockAetherFlower)Block.byId[this.plantBlockId]).f(world, i2, j2, k2)) {
                world.setRawTypeId(i2, j2, k2, this.plantBlockId);
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
