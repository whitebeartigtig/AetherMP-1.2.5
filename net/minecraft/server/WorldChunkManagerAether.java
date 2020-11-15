package net.minecraft.server;

import java.util.*;

public class WorldChunkManagerAether extends WorldChunkManager
{
    private BiomeBase biomeGenerator;
    
    public WorldChunkManagerAether(final double d) {
        this.biomeGenerator = BiomeGenAether.me;
    }
    
    public BiomeBase getBiomeGenAtChunkCoord(final ChunkCoordIntPair chunkcoordintpair) {
        return this.biomeGenerator;
    }
    
    public BiomeBase getBiomeGenAt(final int i, final int j) {
        return this.biomeGenerator;
    }
    
    public float[] getTemperatures(float[] af, final int i, final int j, final int k, final int l) {
        if (af == null || af.length < k * l) {
            af = new float[k * l];
        }
        Arrays.fill(af, 0, k * l, 1.0f);
        return af;
    }
    
    public float[] func_40539_b(final int i, final int j, final int k, final int l) {
        return this.getTemperatures(new float[k * l], i, j, k, l);
    }
    
    public float[] getRainfall(float[] af, final int i, final int j, final int k, final int l) {
        if (af == null || af.length < k * l) {
            af = new float[k * l];
        }
        Arrays.fill(af, 0, k * l, 0.0f);
        return af;
    }
    
    public ChunkPosition findBiomePosition(final int i, final int j, final int k, final List list, final Random random) {
        if (list.contains(this.biomeGenerator)) {
            return new ChunkPosition(i - k + random.nextInt(k * 2 + 1), 0, j - k + random.nextInt(k * 2 + 1));
        }
        return null;
    }
    
    public BiomeBase[] getBiomeGenAt(final BiomeBase[] abiomegenbase, final int i, final int j, final int k, final int l, final boolean flag) {
        return this.loadBlockGeneratorData(abiomegenbase, i, j, k, l);
    }
    
    public boolean areBiomesViable(final int i, final int j, final int k, final List list) {
        return list.contains(this.biomeGenerator);
    }
    
    public float func_35558_c(final int i, final int j) {
        return 0.0f;
    }
    
    public BiomeBase[] loadBlockGeneratorData(BiomeBase[] abiomegenbase, final int i, final int j, final int k, final int l) {
        if (abiomegenbase == null || abiomegenbase.length < k * l) {
            abiomegenbase = new BiomeBase[k * l];
        }
        Arrays.fill(abiomegenbase, 0, k * l, this.biomeGenerator);
        return abiomegenbase;
    }
}
