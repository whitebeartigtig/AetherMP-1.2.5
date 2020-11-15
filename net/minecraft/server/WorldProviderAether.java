package net.minecraft.server;

public class WorldProviderAether extends WorldProvider
{
    private float[] colorsSunriseSunset;
    
    public WorldProviderAether() {
        this.colorsSunriseSunset = new float[4];
        super.dimension = 2;
    }
    
    public boolean isSkyColored() {
        return false;
    }
    
    public IChunkProvider getChunkProvider() {
        return (IChunkProvider)new ChunkProviderAether(super.a, super.a.getSeed());
    }
    
    public void registerWorldChunkManager() {
        super.c = new WorldChunkManagerAether(1.0);
        super.dimension = 2;
    }
    
    public float calculateCelestialAngle(final long l, final float f) {
        final boolean hasKilledGold = ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(AetherAchievements.defeatGold);
        if (hasKilledGold) {
            return super.a(l, f);
        }
        return 0.0f;
    }
    
    public float[] calcSunriseSunsetColors(final float f, final float f1) {
        final float f2 = 0.4f;
        final float f3 = MathHelper.cos(f * 3.141593f * 2.0f) - 0.0f;
        final float f4 = -0.0f;
        if (f3 >= f4 - f2 && f3 <= f4 + f2) {
            final float f5 = (f3 - f4) / f2 * 0.5f + 0.5f;
            float f6 = 1.0f - (1.0f - MathHelper.sin(f5 * 3.141593f)) * 0.99f;
            f6 *= f6;
            this.colorsSunriseSunset[0] = f5 * 0.3f + 0.1f;
            this.colorsSunriseSunset[1] = f5 * f5 * 0.7f + 0.2f;
            this.colorsSunriseSunset[2] = f5 * f5 * 0.7f + 0.2f;
            this.colorsSunriseSunset[3] = f6;
            return this.colorsSunriseSunset;
        }
        return null;
    }
    
    public Vec3D getFogColor(final float f, final float f1) {
        final int i = 8421536;
        float f2 = MathHelper.cos(f * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = (i >> 16 & 0xFF) / 255.0f;
        float f4 = (i >> 8 & 0xFF) / 255.0f;
        float f5 = (i & 0xFF) / 255.0f;
        f3 *= f2 * 0.94f + 0.06f;
        f4 *= f2 * 0.94f + 0.06f;
        f5 *= f2 * 0.91f + 0.09f;
        return Vec3D.create((double)f3, (double)f4, (double)f5);
    }
    
    public float getCloudHeight() {
        return 8.0f;
    }
    
    public boolean canCoordinateBeSpawn(final int i, final int j) {
        final int k = super.a.b(i, j);
        return k != 0 && Block.byId[k].material.isSolid();
    }
    
    public boolean canRespawnHere() {
        return false;
    }
    
    public double getVoidFogYFactor() {
        return 100.0;
    }
    
    public String getSaveFolder() {
        return "AETHER";
    }
    
    public String getWelcomeMessage() {
        return "Ascending into the Aether";
    }
    
    public String getDepartMessage() {
        return "Descending from the Aether";
    }
}
