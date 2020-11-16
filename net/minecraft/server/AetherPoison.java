package net.minecraft.server;

import net.minecraft.server.*;
import java.util.*;

public class AetherPoison
{
    public static long clock;
    public static final float poisonRed = 1.0f;
    public static final float poisonBlue = 1.0f;
    public static final float poisonGreen = 0.0f;
    public static final float cureRed = 0.0f;
    public static final float cureBlue = 0.1f;
    public static final float cureGreen = 1.0f;
    public static int poisonTime;
    public static final int poisonInterval = 50;
    public static final int poisonDmg = 1;
    public static final int poisonHurts = 10;
    public static final int maxPoisonTime = 500;
    public static World world;
    public static MinecraftServer mc;
    public static double rotDFac;
    public static double rotD;
    public static double rotTaper;
    public static double motTaper;
    public static double motD;
    public static double motDFac;
    
    public AetherPoison() {
        ModLoader.registerEntityID((Class)EntityPoisonNeedle.class, "PoisonNeedle", ModLoader.getUniqueEntityId());
        ModLoader.registerEntityID((Class)EntityDartPoison.class, "PoisonDart", ModLoader.getUniqueEntityId());
        ModLoader.registerEntityID((Class)EntityDartGolden.class, "GoldenDart", ModLoader.getUniqueEntityId());
        ModLoader.registerEntityID((Class)EntityDartEnchanted.class, "EnchantedDart", ModLoader.getUniqueEntityId());
    }
    
    public static boolean canPoison(final Entity entity) {
        return !(entity instanceof EntitySlider) && !(entity instanceof EntitySentry) && !(entity instanceof EntityMiniCloud) && !(entity instanceof EntityFireMonster) && !(entity instanceof EntityAechorPlant) && !(entity instanceof EntityFiroBall) && !(entity instanceof EntityCockatrice) && !(entity instanceof EntityHomeShot);
    }
    
    public static void distractEntity(final Entity ent) {
        //final double gauss = AetherPoison.mc.theWorld.rand.nextGaussian();
        //final double newMotD = AetherPoison.motDFac * gauss;
        //AetherPoison.motD = AetherPoison.motTaper * newMotD + (1.0 - AetherPoison.motTaper) * AetherPoison.motD;
        ent.motX += AetherPoison.motD;
        ent.motZ += AetherPoison.motD;
        //final double newRotD = AetherPoison.rotDFac * gauss;
       // AetherPoison.rotD = AetherPoison.rotTaper * newRotD + (1.0 - AetherPoison.rotTaper) * AetherPoison.rotD;
        ent.yaw += (float)AetherPoison.rotD;
        ent.pitch += (float)AetherPoison.rotD;
    }
    /*
    public static void tickRender(final MinecraftServer game) {
        if (AetherPoison.world != game.theWorld || (game.thePlayer != null && (((Entity)game.thePlayer).dead || ((EntityLiving)game.thePlayer).health <= 0))) {
            AetherPoison.world = game.theWorld;
            AetherPoison.poisonTime = 0;
            return;
        }
        if (AetherPoison.world == null) {
            return;
        }
        if (AetherPoison.poisonTime < 0) {
            ++AetherPoison.poisonTime;
            //displayCureEffect();
            return;
        }
        if (AetherPoison.poisonTime == 0) {
            return;
        }
        final long time = AetherPoison.mc.theWorld.getWorldTime();
        final int mod = AetherPoison.poisonTime % 50;
        if (AetherPoison.clock != time) {
            distractEntity((Entity)game.thePlayer);
            if (mod == 0) {
                game.thePlayer.attackEntityFrom(DamageSource.GENERIC, 1);
            }
            --AetherPoison.poisonTime;
            AetherPoison.clock = time;
        }
        //displayPoisonEffect(mod);
    }
    
    public static boolean afflictPoison() {
        if (AetherPoison.poisonTime < 0) {
            return false;
        }
        AetherPoison.poisonTime = 500;
        AetherPoison.world = AetherPoison.mc.theWorld;
        return true;
    }
    
    public static boolean curePoison() {
        if (AetherPoison.poisonTime == -500) {
            return false;
        }
        AetherPoison.poisonTime = -600;
        AetherPoison.world = AetherPoison.mc.theWorld;
        return true;
    }
    
    public static float getPoisonAlpha(final float f) {
        return f * f / 5.0f + 0.4f;
    }
    
    public static float getCureAlpha(final float f) {
        return f * f / 10.0f + 0.4f;
    }
    /*
    public static void displayCureEffect() {
        if (AetherPoison.mc.currentScreen != null) {
            return;
        }
        flashColor("%blur%/aether/poison/curevignette.png", getCureAlpha(-(float)AetherPoison.poisonTime / 500.0f));
    }
    
    public static void displayPoisonEffect(final int mod) {
        if (AetherPoison.mc.currentScreen != null) {
            return;
        }
        flashColor("%blur%/aether/poison/poisonvignette.png", getPoisonAlpha(mod / 50.0f));
    }
    */


    
    static {
        AetherPoison.mc = (MinecraftServer) ModLoader.getMinecraftInstance();
        AetherPoison.rotDFac = 0.7853981633974483;
        AetherPoison.rotTaper = 0.125;
        AetherPoison.motTaper = 0.2;
        AetherPoison.motDFac = 0.1;
    }
}
