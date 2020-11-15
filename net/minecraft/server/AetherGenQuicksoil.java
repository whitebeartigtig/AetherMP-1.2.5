package net.minecraft.server;

import java.util.*;

public class AetherGenQuicksoil extends WorldGenerator
{
    private int minableBlockId;
    
    public AetherGenQuicksoil(final int i) {
        this.minableBlockId = i;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        for (int x = i - 3; x < i + 4; ++x) {
            for (int z = k - 3; z < k + 4; ++z) {
                if (world.getTypeId(x, j, z) == 0 && (x - i) * (x - i) + (z - k) * (z - k) < 12) {
                    world.setRawTypeId(x, j, z, this.minableBlockId);
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
