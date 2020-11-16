package net.minecraft.server;

import net.minecraft.server.*;
import java.util.*;

public class BlockPresent extends AetherBlock
{
    public static int sprTop;
    public static int sprSide;
    int rarity;
    int randStart;
    int randEnd;
    long range;
    long fraction;
    int randomNumber;
    int crateType;
    
    protected BlockPresent(final int var1) {
        super(var1, 48, Material.WOOD);
        this.randStart = 6;
        this.randEnd = 9;
        this.range = this.randEnd - (long)this.randStart + 1L;
        this.c(0.1f);
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        final Random random = new Random();
        this.fraction = (long)(this.range * random.nextDouble());
        this.randomNumber = (int)(this.fraction + this.randStart);
        this.crateType = random.nextInt(4);
        this.rarity = random.nextInt(9);
    }
    
    public int getBlockTextureFromSide(final int var1) {
        return (var1 == 0) ? BlockPresent.sprTop : ((var1 == 1) ? BlockPresent.sprTop : BlockPresent.sprSide);
    }
    
    public int quantityDroppedWithBonus(final int i, final Random random) {
        return this.quantityDropped(random);
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public int idDropped(final int i, final Random random, final int k) {
        return 0;
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        final MinecraftServer game = (MinecraftServer) ModLoader.getMinecraftInstance();
        //final EntityPlayer player = (EntityPlayer)game.thePlayer;
        final Random random = new Random();
        final int randStart = 6;
        final int randEnd = 9;
        final long range = randEnd - (long)randStart + 1L;
        final long fraction = (long)(range * random.nextDouble());
        final int randomNumber = (int)(fraction + randStart);
        final int crateType = random.nextInt(4);
        if (crateType == 0) {
            for (int index = 1; index <= randomNumber; ++index) {
                world.addEntity((Entity)new EntityExperienceOrb(world, (double)i, (double)j, (double)k, 1));
            }
        }
        else if (crateType == 1) {
            if (random.nextInt(9) == 0) {
                this.a(world, i, j, k, new ItemStack(AetherItems.CandySword, 1));
            }
            else {
                for (int index = 1; index <= randomNumber; ++index) {
                    this.a(world, i, j, k, new ItemStack(AetherItems.GingerBreadMan, 1));
                }
            }
        }
        else {
            final EntityTNTPresent entitytntprimed = new EntityTNTPresent(world, i + 0.5f, j + 0.5f, k + 0.5f);
            world.addEntity((Entity)entitytntprimed);
        }
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        BlockPresent.sprTop = 47;
        BlockPresent.sprSide = 48;
    }
}
