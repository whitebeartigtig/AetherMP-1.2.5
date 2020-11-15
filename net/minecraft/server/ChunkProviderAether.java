package net.minecraft.server;

import java.util.*;

public class ChunkProviderAether implements IChunkProvider
{
    private BiomeBase[] biomesForGeneration;
    public static int gumCount;
    private Random random;
    private NoiseGeneratorOctaves noiseGenerator1;
    private NoiseGeneratorOctaves noiseGenerator2;
    private NoiseGeneratorOctaves noiseGenerator3;
    private NoiseGeneratorOctaves noiseGenerator4;
    private NoiseGeneratorOctaves noiseGenerator5;
    public NoiseGeneratorOctaves noiseGenerator6;
    public NoiseGeneratorOctaves noiseGenerator7;
    public NoiseGeneratorOctaves noiseGenerator8;
    private World worldObj;
    private double[] field_28080_q;
    private double[] field_28079_r;
    private double[] field_28078_s;
    private double[] field_28077_t;
    private WorldGenBase mapGenCaves;
    private BiomeBase[] field_28075_v;
    double[] field_28093_d;
    double[] field_28092_e;
    double[] field_28091_f;
    double[] field_28090_g;
    double[] field_28089_h;
    int[][] field_28088_i;
    private double[] field_28074_w;
    public byte topAetherBlock;
    public byte fillerAetherBlock;
    
    public ChunkProviderAether(final World world, final long l) {
        this.field_28079_r = new double[256];
        this.field_28078_s = new double[256];
        this.field_28077_t = new double[256];
        this.mapGenCaves = (WorldGenBase)new WorldGenCaves();
        this.field_28088_i = new int[32][32];
        this.worldObj = world;
        this.random = new Random(l);
        this.noiseGenerator1 = new NoiseGeneratorOctaves(this.random, 16);
        this.noiseGenerator2 = new NoiseGeneratorOctaves(this.random, 16);
        this.noiseGenerator3 = new NoiseGeneratorOctaves(this.random, 8);
        this.noiseGenerator4 = new NoiseGeneratorOctaves(this.random, 4);
        this.noiseGenerator5 = new NoiseGeneratorOctaves(this.random, 4);
        this.noiseGenerator6 = new NoiseGeneratorOctaves(this.random, 10);
        this.noiseGenerator7 = new NoiseGeneratorOctaves(this.random, 16);
        this.noiseGenerator8 = new NoiseGeneratorOctaves(this.random, 8);
    }
    
    public void func_28071_a(final int i, final int j, final byte[] abyte0) {
        final byte byte0 = 2;
        final int k = byte0 + 1;
        final byte byte2 = 33;
        final int l = byte0 + 1;
        this.field_28080_q = this.func_28073_a(this.field_28080_q, i * byte0, 0, j * byte0, k, byte2, l);
        for (int i2 = 0; i2 < byte0; ++i2) {
            for (int j2 = 0; j2 < byte0; ++j2) {
                for (int k2 = 0; k2 < 32; ++k2) {
                    final double d = 0.25;
                    double d2 = this.field_28080_q[((i2 + 0) * l + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d3 = this.field_28080_q[((i2 + 0) * l + (j2 + 1)) * byte2 + (k2 + 0)];
                    double d4 = this.field_28080_q[((i2 + 1) * l + (j2 + 0)) * byte2 + (k2 + 0)];
                    double d5 = this.field_28080_q[((i2 + 1) * l + (j2 + 1)) * byte2 + (k2 + 0)];
                    final double d6 = (this.field_28080_q[((i2 + 0) * l + (j2 + 0)) * byte2 + (k2 + 1)] - d2) * d;
                    final double d7 = (this.field_28080_q[((i2 + 0) * l + (j2 + 1)) * byte2 + (k2 + 1)] - d3) * d;
                    final double d8 = (this.field_28080_q[((i2 + 1) * l + (j2 + 0)) * byte2 + (k2 + 1)] - d4) * d;
                    final double d9 = (this.field_28080_q[((i2 + 1) * l + (j2 + 1)) * byte2 + (k2 + 1)] - d5) * d;
                    for (int l2 = 0; l2 < 4; ++l2) {
                        final double d10 = 0.125;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 8; ++i3) {
                            int j3 = i3 + i2 * 8 << 11 | 0 + j2 * 8 << 7 | k2 * 4 + l2;
                            final char c = '\u0080';
                            final double d15 = 0.125;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            for (int k3 = 0; k3 < 8; ++k3) {
                                int l3 = 0;
                                if (d16 > 0.0) {
                                    l3 = AetherBlocks.Holystone.id;
                                }
                                abyte0[j3] = (byte)l3;
                                j3 += c;
                                d16 += d17;
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }
    
    public void func_28072_a(final int i, final int j, final byte[] abyte0) {
        final double d = 0.03125;
        this.field_28079_r = this.noiseGenerator4.a(this.field_28079_r, i * 16, j * 16, 0, 16, 16, 1, d, d, 1.0);
        this.field_28078_s = this.noiseGenerator4.a(this.field_28078_s, i * 16, 109, j * 16, 16, 1, 16, d, 1.0, d);
        this.field_28077_t = this.noiseGenerator5.a(this.field_28077_t, i * 16, j * 16, 0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final int i2 = (int)(this.field_28077_t[k + l * 16] / 3.0 + 3.0 + this.random.nextDouble() * 0.25);
                int j2 = -1;
                this.topAetherBlock = (byte)AetherBlocks.Grass.id;
                this.fillerAetherBlock = (byte)AetherBlocks.Dirt.id;
                byte byte0 = this.topAetherBlock;
                byte byte2 = this.fillerAetherBlock;
                byte stone = (byte)AetherBlocks.Holystone.id;
                if (byte0 < 0) {
                    byte0 += 0;
                }
                if (byte2 < 0) {
                    byte2 += 0;
                }
                if (stone < 0) {
                    stone += 0;
                }
                for (int k2 = 127; k2 >= 0; --k2) {
                    final int l2 = (l * 16 + k) * 128 + k2;
                    final byte byte3 = abyte0[l2];
                    if (byte3 == 0) {
                        j2 = -1;
                    }
                    else if (byte3 == stone) {
                        if (j2 == -1) {
                            if (i2 <= 0) {
                                byte0 = 0;
                                byte2 = stone;
                            }
                            j2 = i2;
                            if (k2 >= 0) {
                                abyte0[l2] = byte0;
                            }
                            else {
                                abyte0[l2] = byte2;
                            }
                        }
                        else if (j2 > 0) {
                            --j2;
                            abyte0[l2] = byte2;
                        }
                    }
                }
            }
        }
    }
    
    public Chunk prepareChunk(final int i, final int j) {
        return this.provideChunk(i, j);
    }
    
    public Chunk provideChunk(final int i, final int j) {
        this.random.setSeed(i * 341873128712L + j * 132897987541L);
        final byte[] abyte0 = new byte[32768];
        this.func_28071_a(i, j, abyte0);
        this.func_28072_a(i, j, abyte0);
        this.mapGenCaves.a((IChunkProvider)this, this.worldObj, i, j, abyte0);
        final Chunk chunk = new Chunk(this.worldObj, abyte0, i, j);
        chunk.initLighting();
        return chunk;
    }
    
    private double[] func_28073_a(double[] ad, final int i, final int j, final int k, final int l, final int i1, final int j1) {
        if (ad == null) {
            ad = new double[l * i1 * j1];
        }
        double d = 684.412;
        final double d2 = 684.412;
        this.field_28090_g = this.noiseGenerator6.a(this.field_28090_g, i, k, l, j1, 1.121, 1.121, 0.5);
        this.field_28089_h = this.noiseGenerator7.a(this.field_28089_h, i, k, l, j1, 200.0, 200.0, 0.5);
        d *= 2.0;
        this.field_28093_d = this.noiseGenerator3.a(this.field_28093_d, i, j, k, l, i1, j1, d / 80.0, d2 / 160.0, d / 80.0);
        this.field_28092_e = this.noiseGenerator1.a(this.field_28092_e, i, j, k, l, i1, j1, d, d2, d);
        this.field_28091_f = this.noiseGenerator2.a(this.field_28091_f, i, j, k, l, i1, j1, d, d2, d);
        int k2 = 0;
        int l2 = 0;
        final int i2 = 16 / l;
        for (int j2 = 0; j2 < l; ++j2) {
            final int k3 = j2 * i2 + i2 / 2;
            for (int l3 = 0; l3 < j1; ++l3) {
                final int i3 = l3 * i2 + i2 / 2;
                double d3 = 1.0;
                d3 *= d3;
                d3 *= d3;
                d3 = 1.0 - d3;
                double d4 = (this.field_28090_g[l2] + 256.0) / 512.0;
                d4 *= d3;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                double d5 = this.field_28089_h[l2] / 8000.0;
                if (d5 < 0.0) {
                    d5 = -d5 * 0.3;
                }
                d5 = d5 * 3.0 - 2.0;
                if (d5 > 1.0) {
                    d5 = 1.0;
                }
                d5 /= 8.0;
                d5 = 0.0;
                if (d4 < 0.0) {
                    d4 = 0.0;
                }
                d4 += 0.5;
                d5 = d5 * i1 / 16.0;
                ++l2;
                final double d6 = i1 / 2.0;
                for (int j3 = 0; j3 < i1; ++j3) {
                    double d7 = 0.0;
                    double d8 = (j3 - d6) * 8.0 / d4;
                    if (d8 < 0.0) {
                        d8 *= -1.0;
                    }
                    final double d9 = this.field_28092_e[k2] / 512.0;
                    final double d10 = this.field_28091_f[k2] / 512.0;
                    final double d11 = (this.field_28093_d[k2] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    }
                    else if (d11 > 1.0) {
                        d7 = d10;
                    }
                    else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= 8.0;
                    int k4 = 32;
                    if (j3 > i1 - k4) {
                        final double d12 = (j3 - (i1 - k4)) / (k4 - 1.0f);
                        d7 = d7 * (1.0 - d12) + -30.0 * d12;
                    }
                    k4 = 8;
                    if (j3 < k4) {
                        final double d13 = (k4 - j3) / (k4 - 1.0f);
                        d7 = d7 * (1.0 - d13) + -30.0 * d13;
                    }
                    ad[k2] = d7;
                    ++k2;
                }
            }
        }
        return ad;
    }
    
    public boolean chunkExists(final int i, final int j) {
        return true;
    }
    
    public void populate(final IChunkProvider ichunkprovider, final int i, final int j) {
        final BiomeBase biomebase = BiomeGenAether.me;
        BlockSand.instaFall = true;
        final int k = i * 16;
        final int l = j * 16;
        this.random.setSeed(this.worldObj.getSeed());
        final long l2 = this.random.nextLong() / 2L * 2L + 1L;
        final long l3 = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(i * l2 + j * l3 ^ this.worldObj.getSeed());
        double d = 0.25;
        if (this.random.nextInt(32) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(64) + 32;
            final int z = l + this.random.nextInt(16);
            new GenerateFloatingTree().generate(this.worldObj, this.random, x, y, z);
        }
        if (ChunkProviderAether.gumCount < 800) {
            ++ChunkProviderAether.gumCount;
        }
        else if (this.random.nextInt(32) == 0) {
            boolean flag = false;
            final int x2 = k + this.random.nextInt(16) + 8;
            final int y2 = this.random.nextInt(64) + 32;
            final int z2 = l + this.random.nextInt(16) + 8;
            flag = new AetherGenGumdrop().generate(this.worldObj, this.random, x2, y2, z2);
            if (flag) {
                ChunkProviderAether.gumCount = 0;
            }
        }
        for (int n = 0; n < 20; ++n) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = this.random.nextInt(128);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenMinable(AetherBlocks.Dirt.id, 32).generate(this.worldObj, this.random, x2, y2, z2);
        }
        for (int n = 0; n < 2; ++n) {
            final int x2 = k + this.random.nextInt(16) + 8;
            final int y2 = this.random.nextInt(128);
            final int z2 = l + this.random.nextInt(16) + 8;
            new AetherGenFlowers(AetherBlocks.WhiteFlower.id).generate(this.worldObj, this.random, x2, y2, z2);
        }
        for (int n = 0; n < 2; ++n) {
            if (this.random.nextInt(2) == 0) {
                final int x2 = k + this.random.nextInt(16) + 8;
                final int y2 = this.random.nextInt(128);
                final int z2 = l + this.random.nextInt(16) + 8;
                new AetherGenFlowers(AetherBlocks.PurpleFlower.id).generate(this.worldObj, this.random, x2, y2, z2);
            }
        }
        for (int n = 0; n < 10; ++n) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = this.random.nextInt(128);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenMinable(AetherBlocks.Icestone.id, 32).generate(this.worldObj, this.random, x2, y2, z2);
        }
        for (int n = 0; n < 20; ++n) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = this.random.nextInt(128);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenMinable(AetherBlocks.AmbrosiumOre.id, 16).generate(this.worldObj, this.random, x2, y2, z2);
        }
        for (int n = 0; n < 15; ++n) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = this.random.nextInt(64);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenMinable(AetherBlocks.ZaniteOre.id, 8).generate(this.worldObj, this.random, x2, y2, z2);
        }
        for (int n = 0; n < 8; ++n) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = this.random.nextInt(32);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenMinable(AetherBlocks.GravititeOre.id, 7).generate(this.worldObj, this.random, x2, y2, z2);
        }
        if (this.random.nextInt(50) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(32) + 96;
            final int z = l + this.random.nextInt(16);
            new AetherGenClouds(AetherBlocks.Aercloud.id, 2, 4, false).generate(this.worldObj, this.random, x, y, z);
        }
        if (this.random.nextInt(13) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(64) + 32;
            final int z = l + this.random.nextInt(16);
            new AetherGenClouds(AetherBlocks.Aercloud.id, 1, 8, false).generate(this.worldObj, this.random, x, y, z);
        }
        if (this.random.nextInt(7) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(64) + 32;
            final int z = l + this.random.nextInt(16);
            new AetherGenClouds(AetherBlocks.Aercloud.id, 0, 16, false).generate(this.worldObj, this.random, x, y, z);
        }
        if (this.random.nextInt(50) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(32);
            final int z = l + this.random.nextInt(16);
            new AetherGenClouds(AetherBlocks.Aercloud.id, 0, 64, true).generate(this.worldObj, this.random, x, y, z);
        }
        for (int qq = 0; qq < 2; ++qq) {
            final int x2 = k + this.random.nextInt(16);
            final int y2 = 32 + this.random.nextInt(64);
            final int z2 = l + this.random.nextInt(16);
            new AetherGenDungeonBronze(AetherBlocks.LockedDungeonStone.id, AetherBlocks.LockedLightDungeonStone.id, AetherBlocks.DungeonStone.id, AetherBlocks.LightDungeonStone.id, AetherBlocks.Holystone.id, 2, AetherBlocks.Holystone.id, 0, 16, true).generate(this.worldObj, this.random, x2, y2, z2);
        }
        if (this.random.nextInt(500) == 0) {
            final int x = k + this.random.nextInt(16);
            final int y = this.random.nextInt(32) + 64;
            final int z = l + this.random.nextInt(16);
            new AetherGenDungeonSilver(AetherBlocks.LockedDungeonStone.id, AetherBlocks.LockedLightDungeonStone.id, AetherBlocks.DungeonStone.id, AetherBlocks.LightDungeonStone.id, AetherBlocks.Holystone.id, 2, AetherBlocks.Holystone.id, 0, AetherBlocks.Pillar.id).generate(this.worldObj, this.random, x, y, z);
        }
        if (this.random.nextInt(5) == 0) {
            for (int x = k; x < k + 16; ++x) {
                for (int z3 = l; z3 < l + 16; ++z3) {
                    for (int n2 = 0; n2 < 48; ++n2) {
                        if (this.worldObj.getTypeId(x, n2, z3) == 0 && this.worldObj.getTypeId(x, n2 + 1, z3) == AetherBlocks.Grass.id && this.worldObj.getTypeId(x, n2 + 2, z3) == 0) {
                            new AetherGenQuicksoil(AetherBlocks.Quicksoil.id).generate(this.worldObj, this.random, x, n2, z3);
                            n2 = 128;
                        }
                    }
                }
            }
        }
        d = 0.5;
        for (int numberoftreegen = 3, i2 = 0; i2 < numberoftreegen; ++i2) {
            final int k2 = k + this.random.nextInt(16) + 8;
            final int j2 = l + this.random.nextInt(16) + 8;
            final WorldGenerator worldgenerator = biomebase.a(this.random);
            worldgenerator.a(1.0, 1.0, 1.0);
            worldgenerator.a(this.worldObj, this.random, k2, this.worldObj.b(k2, j2), j2);
        }
        if (this.random.nextInt(64) == 0 && mod_Aether.christmasContent) {
            final int k3 = k + this.random.nextInt(16) + 8;
            final int j3 = l + this.random.nextInt(16) + 8;
            final WorldGenerator worldgenerator2 = new GenerateChristmasTree();
            worldgenerator2.a(1.0, 1.0, 1.0);
            worldgenerator2.a(this.worldObj, this.random, k3, this.worldObj.b(k3, j3), j3);
        }
        for (int n3 = 0; n3 < 2; ++n3) {
            final int x3 = k + this.random.nextInt(16) + 8;
            final int y3 = this.random.nextInt(128);
            final int z4 = l + this.random.nextInt(16) + 8;
            new AetherGenFlowers(AetherBlocks.BerryBush.id).generate(this.worldObj, this.random, x3, y3, z4);
        }
        for (int k4 = 0; k4 < 50; ++k4) {
            final int j4 = k + this.random.nextInt(16) + 8;
            final int l4 = this.random.nextInt(this.random.nextInt(120) + 8);
            final int l5 = l + this.random.nextInt(16) + 8;
            new AetherGenLiquids(Block.WATER.id).generate(this.worldObj, this.random, j4, l4, l5);
        }
        SpawnerCreature.a(this.worldObj, biomebase, k + 8, l + 8, 16, 16, this.random);
        BlockSand.instaFall = false;
    }
    
    public boolean saveChunks(final boolean flag, final IProgressUpdate iprogressupdate) {
        return true;
    }
    
    public boolean unload100OldestChunks() {
        return false;
    }
    
    public String makeString() {
        return "RandomLevelSource";
    }
    
    public boolean canSave() {
        return true;
    }
    
    public ChunkPosition findClosestStructure(final World var1, final String var2, final int var3, final int var4, final int var5) {
        return null;
    }
    
    public Chunk loadChunk(final int i, final int j) {
        return this.provideChunk(i, j);
    }
    
    public List getPossibleCreatures(final EnumCreatureType enumcreaturetype, final int i, final int j, final int k) {
        final WorldChunkManager worldchunkmanager = this.worldObj.getWorldChunkManager();
        final BiomeBase biomegenbase = worldchunkmanager.getBiome(i >> 4, k >> 4);
        if (biomegenbase == null) {
            return null;
        }
        return biomegenbase.getMobs(enumcreaturetype);
    }

	@Override
	public ChunkPosition findNearestMapFeature(World arg0, String arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk getChunkAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getChunkAt(IChunkProvider arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List getMobsFor(EnumCreatureType arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk getOrCreateChunk(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChunkLoaded(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunks() {
		// TODO Auto-generated method stub
		return false;
	}
}
