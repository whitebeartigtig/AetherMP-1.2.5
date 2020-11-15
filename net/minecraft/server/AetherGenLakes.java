package net.minecraft.server;

import java.util.*;

public class AetherGenLakes extends WorldGenerator
{
    private int blockIndex;
    
    public AetherGenLakes(final int i) {
        this.blockIndex = i;
    }
    
    public boolean generate(final World world, final Random random, int i, int j, int k) {
        for (i -= 8, k -= 8; j > 0 && world.isEmpty(i, j, k); --j) {}
        j -= 4;
        final boolean[] aflag = new boolean[2048];
        for (int l = random.nextInt(4) + 4, i2 = 0; i2 < l; ++i2) {
            final double d = random.nextDouble() * 6.0 + 3.0;
            final double d2 = random.nextDouble() * 4.0 + 2.0;
            final double d3 = random.nextDouble() * 6.0 + 3.0;
            final double d4 = random.nextDouble() * (16.0 - d - 2.0) + 1.0 + d / 2.0;
            final double d5 = random.nextDouble() * (8.0 - d2 - 4.0) + 2.0 + d2 / 2.0;
            final double d6 = random.nextDouble() * (16.0 - d3 - 2.0) + 1.0 + d3 / 2.0;
            for (int j2 = 1; j2 < 15; ++j2) {
                for (int k2 = 1; k2 < 15; ++k2) {
                    for (int l2 = 1; l2 < 7; ++l2) {
                        final double d7 = (j2 - d4) / (d / 2.0);
                        final double d8 = (l2 - d5) / (d2 / 2.0);
                        final double d9 = (k2 - d6) / (d3 / 2.0);
                        final double d10 = d7 * d7 + d8 * d8 + d9 * d9;
                        if (d10 < 1.0) {
                            aflag[(j2 * 16 + k2) * 8 + l2] = true;
                        }
                    }
                }
            }
        }
        for (int j3 = 0; j3 < 16; ++j3) {
            for (int j4 = 0; j4 < 16; ++j4) {
                for (int j5 = 0; j5 < 8; ++j5) {
                    final boolean flag = !aflag[(j3 * 16 + j4) * 8 + j5] && ((j3 < 15 && aflag[((j3 + 1) * 16 + j4) * 8 + j5]) || (j3 > 0 && aflag[((j3 - 1) * 16 + j4) * 8 + j5]) || (j4 < 15 && aflag[(j3 * 16 + (j4 + 1)) * 8 + j5]) || (j4 > 0 && aflag[(j3 * 16 + (j4 - 1)) * 8 + j5]) || (j5 < 7 && aflag[(j3 * 16 + j4) * 8 + (j5 + 1)]) || (j5 > 0 && aflag[(j3 * 16 + j4) * 8 + (j5 - 1)]));
                    if (flag) {
                        final Material material = world.getMaterial(i + j3, j + j5, k + j4);
                        if (j5 >= 4 && material.isLiquid()) {
                            return false;
                        }
                        if (j5 < 4 && !material.isSolid() && world.getTypeId(i + j3, j + j5, k + j4) != this.blockIndex) {
                            return false;
                        }
                    }
                }
            }
        }
        for (int k3 = 0; k3 < 16; ++k3) {
            for (int k4 = 0; k4 < 16; ++k4) {
                for (int k5 = 0; k5 < 8; ++k5) {
                    if (aflag[(k3 * 16 + k4) * 8 + k5]) {
                        world.setRawTypeId(i + k3, j + k5, k + k4, (k5 < 4) ? this.blockIndex : 0);
                    }
                }
            }
        }
        for (int l3 = 0; l3 < 16; ++l3) {
            for (int l4 = 0; l4 < 16; ++l4) {
                for (int l5 = 4; l5 < 8; ++l5) {
                    if (aflag[(l3 * 16 + l4) * 8 + l5] && world.getTypeId(i + l3, j + l5 - 1, k + l4) == AetherBlocks.Dirt.id && world.a(EnumSkyBlock.SKY, i + l3, j + l5, k + l4) > 0) {
                        world.setRawTypeId(i + l3, j + l5 - 1, k + l4, AetherBlocks.Grass.id);
                    }
                }
            }
        }
        if (Block.byId[this.blockIndex].material == Material.LAVA) {
            for (int i3 = 0; i3 < 16; ++i3) {
                for (int i4 = 0; i4 < 16; ++i4) {
                    for (int i5 = 0; i5 < 8; ++i5) {
                        final boolean flag2 = !aflag[(i3 * 16 + i4) * 8 + i5] && ((i3 < 15 && aflag[((i3 + 1) * 16 + i4) * 8 + i5]) || (i3 > 0 && aflag[((i3 - 1) * 16 + i4) * 8 + i5]) || (i4 < 15 && aflag[(i3 * 16 + (i4 + 1)) * 8 + i5]) || (i4 > 0 && aflag[(i3 * 16 + (i4 - 1)) * 8 + i5]) || (i5 < 7 && aflag[(i3 * 16 + i4) * 8 + (i5 + 1)]) || (i5 > 0 && aflag[(i3 * 16 + i4) * 8 + (i5 - 1)]));
                        if (flag2 && (i5 < 4 || random.nextInt(2) != 0) && world.getMaterial(i + i3, j + i5, k + i4).isSolid()) {
                            world.setRawTypeIdAndData(i + i3, j + i5, k + i4, AetherBlocks.Holystone.id, 0);
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
