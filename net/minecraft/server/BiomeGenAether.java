package net.minecraft.server;

import cpw.mods.fml.common.*;
import java.util.*;

public class BiomeGenAether extends BiomeBase
{
    public static BiomeGenAether me;
    
    public BiomeGenAether() {
        super(237);
        super.G = 0.0f;
        super.J.clear();
        super.K.clear();
        super.L.clear();
        this.a("Aether");
        try {
            ModLoader.setPrivateValue((Class)BiomeBase.class, (Object)this, ReflectionHelper.obfuscation ? "S" : "enableRain", (Object)Boolean.FALSE);
            ModLoader.setPrivateValue((Class)BiomeBase.class, (Object)this, ReflectionHelper.obfuscation ? "R" : "enableSnow", (Object)Boolean.FALSE);
        }
        catch (Exception e) {
            ModLoader.getLogger().warning("Could not disable rain and snow in the Aether. Did obfuscation change?");
        }
        if (mod_Aether.raritySwet != 0) {
            super.K.add(new BiomeMeta((Class)EntitySwet.class, mod_Aether.raritySwet, 4, 4));
        }
        if (mod_Aether.rarityAechorPlant != 0) {
            super.K.add(new BiomeMeta((Class)EntityAechorPlant.class, mod_Aether.rarityAechorPlant, 3, 3));
        }
        if (mod_Aether.rarityCockatrice != 0) {
            super.J.add(new BiomeMeta((Class)EntityCockatrice.class, mod_Aether.rarityCockatrice, 4, 4));
        }
        if (mod_Aether.rarityAerwhale != 0) {
            super.J.add(new BiomeMeta((Class)EntityAerwhale.class, mod_Aether.rarityAerwhale, 3, 3));
        }
        if (mod_Aether.rarityZephyr != 0) {
            super.J.add(new BiomeMeta((Class)EntityZephyr.class, mod_Aether.rarityZephyr, 1, 1));
        }
        if (mod_Aether.raritySheepuff != 0) {
            super.K.add(new BiomeMeta((Class)EntitySheepuff.class, mod_Aether.raritySheepuff, 6, 6));
        }
        if (mod_Aether.rarityPhyg != 0) {
            super.K.add(new BiomeMeta((Class)EntityPhyg.class, mod_Aether.rarityPhyg, 8, 8));
        }
        if (mod_Aether.rarityMoa != 0) {
            super.K.add(new BiomeMeta((Class)EntityMoa.class, mod_Aether.rarityMoa, 3, 3));
        }
        if (mod_Aether.rarityFlyingCow != 0) {
            super.K.add(new BiomeMeta((Class)EntityFlyingCow.class, mod_Aether.rarityFlyingCow, 6, 6));
        }
        if (mod_Aether.rarityWhirlwind != 0) {
            super.K.add(new BiomeMeta((Class)Whirly.class, mod_Aether.rarityWhirlwind, 2, 2));
        }
        if (mod_Aether.rarityAerbunny != 0) {
            super.K.add(new BiomeMeta((Class)EntityAerbunny.class, mod_Aether.rarityAerbunny, 10, 10));
        }
        BiomeGenAether.me = this;
    }
    
    public WorldGenerator getRandomWorldGenForTrees(final Random random) {
        if (random.nextInt(100) == 0) {
            return new AetherGenGoldenOak();
        }
        return new AetherGenSkyroot();
    }
    
    public int getSkyColorByTemp(final float f) {
        return 12632319;
    }
    
    static {
        BiomeGenAether.me = null;
    }
}
