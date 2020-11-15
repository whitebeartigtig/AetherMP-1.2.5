package net.minecraft.server;

import java.util.*;

public class AetherGenBuildings extends WorldGenerator
{
    public int blockID1;
    public int blockID2;
    public int meta1;
    public int meta2;
    public int chance;
    public boolean replaceAir;
    public boolean replaceSolid;
    
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        return false;
    }
    
    public void setBlocks(final int i, final int j, final int k) {
        this.blockID1 = i;
        this.blockID2 = j;
        this.chance = k;
        if (this.chance < 1) {
            this.chance = 1;
        }
    }
    
    public void setMetadata(final int i, final int j) {
        this.meta1 = i;
        this.meta2 = j;
    }
    
    public void addLineX(final World world, final Random random, final int i, final int j, final int k, final int length) {
        for (int x = i; x < i + length; ++x) {
            if ((this.replaceAir || world.getTypeId(x, j, k) != 0) && (this.replaceSolid || world.getTypeId(x, j, k) == 0)) {
                if (random.nextInt(this.chance) == 0) {
                    world.setRawTypeIdAndData(x, j, k, this.blockID2, this.meta2);
                }
                else {
                    world.setRawTypeIdAndData(x, j, k, this.blockID1, this.meta1);
                }
            }
        }
    }
    
    public void addLineY(final World world, final Random random, final int i, final int j, final int k, final int length) {
        for (int y = j; y < j + length; ++y) {
            if ((this.replaceAir || world.getTypeId(i, y, k) != 0) && (this.replaceSolid || world.getTypeId(i, y, k) == 0)) {
                if (random.nextInt(this.chance) == 0) {
                    world.setRawTypeIdAndData(i, y, k, this.blockID2, this.meta2);
                }
                else {
                    world.setRawTypeIdAndData(i, y, k, this.blockID1, this.meta1);
                }
            }
        }
    }
    
    public void addLineZ(final World world, final Random random, final int i, final int j, final int k, final int length) {
        for (int z = k; z < k + length; ++z) {
            if ((this.replaceAir || world.getTypeId(i, j, z) != 0) && (this.replaceSolid || world.getTypeId(i, j, z) == 0)) {
                if (random.nextInt(this.chance) == 0) {
                    world.setRawTypeIdAndData(i, j, z, this.blockID2, this.meta2);
                }
                else {
                    world.setRawTypeIdAndData(i, j, z, this.blockID1, this.meta1);
                }
            }
        }
    }
    
    public void addPlaneX(final World world, final Random random, final int i, final int j, final int k, final int dj, final int dk) {
        for (int y = j; y < j + dj; ++y) {
            for (int z = k; z < k + dk; ++z) {
                if ((this.replaceAir || world.getTypeId(i, y, z) != 0) && (this.replaceSolid || world.getTypeId(i, y, z) == 0)) {
                    if (random.nextInt(this.chance) == 0) {
                        world.setRawTypeIdAndData(i, y, z, this.blockID2, this.meta2);
                    }
                    else {
                        world.setRawTypeIdAndData(i, y, z, this.blockID1, this.meta1);
                    }
                }
            }
        }
    }
    
    public void addPlaneY(final World world, final Random random, final int i, final int j, final int k, final int di, final int dk) {
        for (int x = i; x < i + di; ++x) {
            for (int z = k; z < k + dk; ++z) {
                if ((this.replaceAir || world.getTypeId(x, j, z) != 0) && (this.replaceSolid || world.getTypeId(x, j, z) == 0)) {
                    if (random.nextInt(this.chance) == 0) {
                        world.setRawTypeIdAndData(x, j, z, this.blockID2, this.meta2);
                    }
                    else {
                        world.setRawTypeIdAndData(x, j, z, this.blockID1, this.meta1);
                    }
                }
            }
        }
    }
    
    public void addPlaneZ(final World world, final Random random, final int i, final int j, final int k, final int di, final int dj) {
        for (int x = i; x < i + di; ++x) {
            for (int y = j; y < j + dj; ++y) {
                if ((this.replaceAir || world.getTypeId(x, y, k) != 0) && (this.replaceSolid || world.getTypeId(x, y, k) == 0)) {
                    if (random.nextInt(this.chance) == 0) {
                        world.setRawTypeIdAndData(x, y, k, this.blockID2, this.meta2);
                    }
                    else {
                        world.setRawTypeIdAndData(x, y, k, this.blockID1, this.meta1);
                    }
                }
            }
        }
    }
    
    public void addHollowBox(final World world, final Random random, final int i, final int j, final int k, final int di, final int dj, final int dk) {
        final int temp1 = this.blockID1;
        final int temp2 = this.blockID2;
        this.setBlocks(0, 0, this.chance);
        this.addSolidBox(world, random, i, j, k, di, dj, dk);
        this.setBlocks(temp1, temp2, this.chance);
        this.addPlaneY(world, random, i, j, k, di, dk);
        this.addPlaneY(world, random, i, j + dj - 1, k, di, dk);
        this.addPlaneX(world, random, i, j, k, dj, dk);
        this.addPlaneX(world, random, i + di - 1, j, k, dj, dk);
        this.addPlaneZ(world, random, i, j, k, di, dj);
        this.addPlaneZ(world, random, i, j, k + dk - 1, di, dj);
    }
    
    public void addSquareTube(final World world, final Random random, final int i, final int j, final int k, final int di, final int dj, final int dk, final int dir) {
        final int temp1 = this.blockID1;
        final int temp2 = this.blockID2;
        this.setBlocks(0, 0, this.chance);
        this.addSolidBox(world, random, i, j, k, di, dj, dk);
        this.setBlocks(temp1, temp2, this.chance);
        if (dir == 0 || dir == 2) {
            this.addPlaneY(world, random, i, j, k, di, dk);
            this.addPlaneY(world, random, i, j + dj - 1, k, di, dk);
        }
        if (dir == 1 || dir == 2) {
            this.addPlaneX(world, random, i, j, k, dj, dk);
            this.addPlaneX(world, random, i + di - 1, j, k, dj, dk);
        }
        if (dir == 0 || dir == 1) {
            this.addPlaneZ(world, random, i, j, k, di, dj);
            this.addPlaneZ(world, random, i, j, k + dk - 1, di, dj);
        }
    }
    
    public void addSolidBox(final World world, final Random random, final int i, final int j, final int k, final int di, final int dj, final int dk) {
        for (int x = i; x < i + di; ++x) {
            for (int y = j; y < j + dj; ++y) {
                for (int z = k; z < k + dk; ++z) {
                    if ((this.replaceAir || world.getTypeId(x, y, z) != 0) && (this.replaceSolid || world.getTypeId(x, y, z) == 0)) {
                        if (random.nextInt(this.chance) == 0) {
                            world.setRawTypeIdAndData(x, y, z, this.blockID2, this.meta2);
                        }
                        else {
                            world.setRawTypeIdAndData(x, y, z, this.blockID1, this.meta1);
                        }
                    }
                }
            }
        }
    }
    
    public boolean isBoxSolid(final World world, final int i, final int j, final int k, final int di, final int dj, final int dk) {
        boolean flag = true;
        for (int x = i; x < i + di; ++x) {
            for (int y = j; y < j + dj; ++y) {
                for (int z = k; z < k + dk; ++z) {
                    if (world.getTypeId(x, y, z) == 0) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }
    
    public boolean isBoxEmpty(final World world, final int i, final int j, final int k, final int di, final int dj, final int dk) {
        boolean flag = true;
        for (int x = i; x < i + di; ++x) {
            for (int y = j; y < j + dj; ++y) {
                for (int z = k; z < k + dk; ++z) {
                    if (world.getTypeId(x, y, z) != 0) {
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
