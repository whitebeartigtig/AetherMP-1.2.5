package net.minecraft.server;

import java.util.*;

public class AetherGenLiquids extends WorldGenerator
{
    private int liquidBlockId;
    
    public AetherGenLiquids(final int i) {
        this.liquidBlockId = i;
    }
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        if (world.getTypeId(i, j + 1, k) != AetherBlocks.Holystone.id || world.getData(i, j + 1, k) >= 2) {
            return false;
        }
        if (world.getTypeId(i, j - 1, k) != AetherBlocks.Holystone.id || world.getData(i, j - 1, k) >= 2) {
            return false;
        }
        if (world.getTypeId(i, j, k) != 0 && (world.getTypeId(i, j, k) != AetherBlocks.Holystone.id || world.getData(i, j, k) >= 2)) {
            return false;
        }
        int l = 0;
        if (world.getTypeId(i - 1, j, k) == AetherBlocks.Holystone.id || world.getData(i - 1, j, k) >= 2) {
            ++l;
        }
        if (world.getTypeId(i + 1, j, k) == AetherBlocks.Holystone.id || world.getData(i + 1, j, k) >= 2) {
            ++l;
        }
        if (world.getTypeId(i, j, k - 1) == AetherBlocks.Holystone.id || world.getData(i, j, k - 1) >= 2) {
            ++l;
        }
        if (world.getTypeId(i, j, k + 1) == AetherBlocks.Holystone.id || world.getData(i, j, k + 1) >= 2) {
            ++l;
        }
        int i2 = 0;
        if (world.isEmpty(i - 1, j, k)) {
            ++i2;
        }
        if (world.isEmpty(i + 1, j, k)) {
            ++i2;
        }
        if (world.isEmpty(i, j, k - 1)) {
            ++i2;
        }
        if (world.isEmpty(i, j, k + 1)) {
            ++i2;
        }
        if (l == 3 && i2 == 1) {
            world.setTypeId(i, j, k, this.liquidBlockId);
            world.a = true;
            Block.byId[this.liquidBlockId].a(world, i, j, k, random);
            world.a = false;
        }
        return true;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
