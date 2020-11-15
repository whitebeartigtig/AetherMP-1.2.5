package net.minecraft.server;

import java.util.*;

public class AetherGenGumdrop extends WorldGenerator
{
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        return this.func_100009_a(world, random, i, j, k, 24);
    }
    
    public boolean func_100009_a(final World world, final Random random, final int i, int j, final int k, final int l) {
        if (j - l <= 0) {
            j = l + 1;
        }
        if (j + l >= 116) {
            j = 116 - l - 1;
        }
        int i2 = 0;
        final int j2 = MathHelper.floor(l * 0.875);
        for (int k2 = -j2; k2 <= j2; ++k2) {
            for (int l2 = l; l2 >= -j2; --l2) {
                for (int k3 = -j2; k3 <= j2; ++k3) {
                    if (!AetherBlocks.isGood(world.getTypeId(k2 + i, l2 + j, k3 + k), world.getData(k2 + i, l2 + j, k3 + k)) && ++i2 > l / 2) {
                        return false;
                    }
                }
            }
        }
        final float f = 0.8f;
        for (int i3 = -l; i3 <= l; ++i3) {
            for (int l3 = l; l3 >= -l; --l3) {
                for (int i4 = -l; i4 <= l; ++i4) {
                    final int k4 = MathHelper.floor(i3 * (1.0 + l3 / (l * 10.0)) / f);
                    int i5 = l3;
                    if (l3 > l * 0.625) {
                        i5 = MathHelper.floor(i5 * 1.375);
                        i5 -= MathHelper.floor(l * 0.25);
                    }
                    else if (l3 < l * -0.625) {
                        i5 = MathHelper.floor(i5 * 1.350000023841858);
                        i5 += MathHelper.floor(l * 0.25);
                    }
                    final int k5 = MathHelper.floor(i4 * (1.0 + l3 / (l * 10.0)) / f);
                    if (Math.sqrt(k4 * k4 + i5 * i5 + k5 * k5) <= l) {
                        if (AetherBlocks.isGood(world.getTypeId(i3 + i, l3 + j + 1, i4 + k), world.getData(i3 + i, l3 + j + 1, i4 + k)) && l3 > (double)MathHelper.floor(l / 5.0)) {
                            world.setRawTypeId(i3 + i, l3 + j, i4 + k, AetherBlocks.Grass.id);
                            world.setRawTypeId(i3 + i, l3 + j - 1, i4 + k, AetherBlocks.Dirt.id);
                            world.setRawTypeId(i3 + i, l3 + j - (1 + random.nextInt(2)), i4 + k, AetherBlocks.Dirt.id);
                            if (l3 >= l / 2) {
                                final int j3 = random.nextInt(48);
                                if (j3 < 2) {
                                    new AetherGenGoldenOak().generate(world, random, i3 + i, l3 + j + 1, i4 + k);
                                }
                                else if (j3 == 3) {
                                    if (random.nextInt(2) == 0) {
                                        new WorldGenLakes(Block.STATIONARY_WATER.id).a(world, random, i3 + i + random.nextInt(3) - random.nextInt(3), l3 + j, i4 + k + random.nextInt(3) - random.nextInt(3));
                                    }
                                }
                                else if (j3 == 4) {
                                    if (random.nextInt(2) == 0) {
                                        new WorldGenFlowers(((Block)Block.YELLOW_FLOWER).id).a(world, random, i3 + i + random.nextInt(3) - random.nextInt(3), l3 + j + 1, i4 + k + random.nextInt(3) - random.nextInt(3));
                                    }
                                    else {
                                        new WorldGenFlowers(((Block)Block.RED_ROSE).id).a(world, random, i3 + i + random.nextInt(3) - random.nextInt(3), l3 + j + 1, i4 + k + random.nextInt(3) - random.nextInt(3));
                                    }
                                }
                            }
                        }
                        else if (AetherBlocks.isGood(world.getTypeId(i3 + i, l3 + j, i4 + k), world.getData(i3 + i, l3 + j, i4 + k))) {
                            world.setRawTypeIdAndData(i3 + i, l3 + j, i4 + k, AetherBlocks.Holystone.id, 0);
                        }
                    }
                }
            }
        }
        final int j4 = 8 + random.nextInt(5);
        final float f2 = 0.01745329f;
        for (int j5 = 0; j5 < j4; ++j5) {
            final float f3 = random.nextFloat() * 360.0f;
            final float f4 = (random.nextFloat() * 0.125f + 0.7f) * l;
            final int l4 = i + MathHelper.floor(Math.cos(f2 * f3) * f4);
            final int k6 = j - MathHelper.floor(l * (double)random.nextFloat() * 0.3);
            final int i6 = k + MathHelper.floor(-Math.sin(f2 * f3) * f4);
            this.func_100008_b(world, random, l4, k6, i6, MathHelper.floor(l / 3.0), true);
        }
        boolean flag = false;
        flag = new AetherGenDungeon().generate(world, random, i, j, k, j2);
        for (int l5 = MathHelper.floor(l * 0.75), j6 = 0; j6 < l5; ++j6) {
            final int i7 = i + random.nextInt(l) - random.nextInt(l);
            final int l6 = j + random.nextInt(l) - random.nextInt(l);
            final int j7 = k + random.nextInt(l) - random.nextInt(l);
            new AetherGenGumdropCaves(0, 24 + l5 / 3).generate(world, random, i7, l6, j7);
        }
        return true;
    }
    
    public boolean func_100008_b(final World world, final Random random, final int i, int j, final int k, final int l, final boolean flag) {
        if (j - l <= 0) {
            j = l + 1;
        }
        if (j + l >= 127) {
            j = 127 - l - 1;
        }
        final float f = 1.0f;
        for (int i2 = -l; i2 <= l; ++i2) {
            for (int k2 = l; k2 >= -l; --k2) {
                for (int i3 = -l; i3 <= l; ++i3) {
                    final int k3 = MathHelper.floor(i2 / (double)f);
                    int i4 = k2;
                    if (k2 > l * 0.625) {
                        i4 = MathHelper.floor(i4 * 1.375);
                        i4 -= MathHelper.floor(l * 0.25);
                    }
                    else if (k2 < l * -0.625) {
                        i4 = MathHelper.floor(i4 * 1.350000023841858);
                        i4 += MathHelper.floor(l * 0.25);
                    }
                    final int k4 = MathHelper.floor(i3 / (double)f);
                    if (Math.sqrt(k3 * k3 + i4 * i4 + k4 * k4) <= l) {
                        if (AetherBlocks.isGood(world.getTypeId(i2 + i, k2 + j + 1, i3 + k), world.getData(i2 + i, k2 + j + 1, i3 + k)) && k2 > (double)MathHelper.floor(l / 5.0)) {
                            world.setRawTypeId(i2 + i, k2 + j, i3 + k, AetherBlocks.Grass.id);
                            world.setRawTypeId(i2 + i, k2 + j - 1, i3 + k, AetherBlocks.Dirt.id);
                            world.setRawTypeId(i2 + i, k2 + j - (1 + random.nextInt(2)), i3 + k, AetherBlocks.Dirt.id);
                            if (k2 >= l / 2) {
                                final int l2 = random.nextInt(64);
                                if (l2 == 0) {
                                    new AetherGenGoldenOak().generate(world, random, i2 + i, k2 + j + 1, i3 + k);
                                }
                                else if (l2 == 5 && random.nextInt(3) == 0) {
                                    new WorldGenLakes(Block.STATIONARY_WATER.id).a(world, random, i2 + i + random.nextInt(3) - random.nextInt(3), k2 + j, i3 + k + random.nextInt(3) - random.nextInt(3));
                                }
                            }
                        }
                        else if (AetherBlocks.isGood(world.getTypeId(i2 + i, k2 + j, i3 + k), world.getData(i2 + i, k2 + j, i3 + k))) {
                            world.setRawTypeIdAndData(i2 + i, k2 + j, i3 + k, AetherBlocks.Holystone.id, 0);
                        }
                    }
                }
            }
        }
        if (!flag) {
            for (int j2 = MathHelper.floor(l * 1.25), l3 = 0; l3 < j2; ++l3) {
                final int j3 = i + random.nextInt(l) - random.nextInt(l);
                final int l4 = j + random.nextInt(l) - random.nextInt(l);
                final int j4 = k + random.nextInt(l) - random.nextInt(l);
                new AetherGenGumdropCaves(0, 16 + j2 / 3).generate(world, random, j3, l4, j4);
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
