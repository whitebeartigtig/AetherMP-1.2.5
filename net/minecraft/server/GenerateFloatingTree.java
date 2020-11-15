package net.minecraft.server;

import java.util.*;

public class GenerateFloatingTree extends WorldGenerator
{
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        boolean cangen = true;
        for (int x2 = x - 6; x2 < x + 6 + 6; ++x2) {
            for (int y2 = y - 6; y2 < y + 11 + 6; ++y2) {
                for (int z2 = z - 6; z2 < z + 6 + 6; ++z2) {
                    if (world.getTypeId(x2, y2, z2) != 0) {
                        cangen = false;
                    }
                }
            }
        }
        if (y + 11 <= world.getHeight() && cangen) {
            world.setRawTypeId(x, y, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y, z + 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y, z - 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x + 1, y, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x - 1, y, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 1, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 1, z + 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 1, z + 2, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 1, z - 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 1, z - 2, AetherBlocks.Holystone.id);
            world.setRawTypeId(x + 1, y + 1, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x + 2, y + 1, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x - 1, y + 1, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x - 2, y + 1, z, AetherBlocks.Holystone.id);
            world.setRawTypeId(x + 1, y + 1, z + 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x + 1, y + 1, z - 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x - 1, y + 1, z - 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x - 1, y + 1, z + 1, AetherBlocks.Holystone.id);
            world.setRawTypeId(x, y + 2, z, AetherBlocks.Grass.id);
            world.setRawTypeId(x, y + 2, z + 1, AetherBlocks.Grass.id);
            world.setRawTypeId(x, y + 2, z + 2, AetherBlocks.Grass.id);
            world.setRawTypeId(x, y + 2, z - 1, AetherBlocks.Grass.id);
            world.setRawTypeId(x, y + 2, z - 2, AetherBlocks.Grass.id);
            world.setRawTypeId(x + 1, y + 2, z, AetherBlocks.Grass.id);
            world.setRawTypeId(x + 2, y + 2, z, AetherBlocks.Grass.id);
            world.setRawTypeId(x - 1, y + 2, z, AetherBlocks.Grass.id);
            world.setRawTypeId(x - 2, y + 2, z, AetherBlocks.Grass.id);
            world.setRawTypeId(x + 1, y + 2, z + 1, AetherBlocks.Grass.id);
            world.setRawTypeId(x + 1, y + 2, z - 1, AetherBlocks.Grass.id);
            world.setRawTypeId(x - 1, y + 2, z - 1, AetherBlocks.Grass.id);
            world.setRawTypeId(x - 1, y + 2, z + 1, AetherBlocks.Grass.id);
            for (int y3 = y + 3; y3 <= y + 9; ++y3) {
                world.setRawTypeId(x, y3, z, AetherBlocks.Log.id);
            }
            world.setTypeIdAndData(x, y + 10, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setRawTypeId(x + 1, y + 5, z, AetherBlocks.Log.id);
            world.setRawTypeId(x - 1, y + 5, z, AetherBlocks.Log.id);
            world.setRawTypeId(x, y + 5, z + 1, AetherBlocks.Log.id);
            world.setRawTypeId(x, y + 5, z - 1, AetherBlocks.Log.id);
            world.setTypeIdAndData(x, y + 5, z - 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 5, z + 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 2, y + 5, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 2, y + 5, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 5, z - 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 5, z - 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 5, z + 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 5, z + 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 2, y + 5, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 2, y + 5, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 2, y + 5, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 2, y + 5, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 5, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 5, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 5, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 5, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 6, z - 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 6, z + 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 2, y + 6, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 2, y + 6, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 6, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 6, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 6, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 6, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 6, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 6, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 6, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 6, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 7, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 7, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 7, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 7, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setRawTypeId(x + 1, y + 8, z, AetherBlocks.Log.id);
            world.setRawTypeId(x - 1, y + 8, z, AetherBlocks.Log.id);
            world.setRawTypeId(x, y + 8, z + 1, AetherBlocks.Log.id);
            world.setRawTypeId(x, y + 8, z - 1, AetherBlocks.Log.id);
            world.setTypeIdAndData(x, y + 8, z - 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 8, z + 2, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 2, y + 8, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 2, y + 8, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 8, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 8, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 8, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 8, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x + 1, y + 9, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x - 1, y + 9, z, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 9, z + 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            world.setTypeIdAndData(x, y + 9, z - 1, AetherBlocks.BlueLeaves.id, random.nextInt(2));
            return true;
        }
        return false;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
