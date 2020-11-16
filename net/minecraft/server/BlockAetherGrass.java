package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherGrass extends Block implements ITextureProvider
{
    public static int sprTop;
    public static int sprSide;
    public static int sprGoldTop;
    public static int sprGoldSide;
    
    protected BlockAetherGrass(final int blockID) {
        super(blockID, BlockAetherGrass.sprTop, Material.EARTH);
        this.a(true);
        this.j();
        this.c(0.2f);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public int getBlockTextureFromSideAndMetadata(final int j, final int i) {
        if (j == 1) {
            if (i == 0) {
                return BlockAetherGrass.sprTop;
            }
            if (i == 1) {
                return BlockAetherGrass.sprGoldTop;
            }
        }
        if (j == 0) {
            return AetherBlocks.Dirt.textureId;
        }
        if (i == 1) {
            return BlockAetherGrass.sprGoldSide;
        }
        return BlockAetherGrass.sprSide;
    }
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random random) {
        if (world.isStatic) {
            return;
        }
        if (world.getLightLevel(i, j + 1, k) < 4 && world.getMaterial(i, j + 1, k).blocksLight()) {
            if (random.nextInt(4) != 0) {
                return;
            }
            world.setTypeId(i, j, k, AetherBlocks.Dirt.id);
        }
        else if (world.getLightLevel(i, j + 1, k) >= 9) {
            final int l = i + random.nextInt(3) - 1;
            final int i2 = j + random.nextInt(5) - 3;
            final int j2 = k + random.nextInt(3) - 1;
            if (world.getTypeId(l, i2, j2) == AetherBlocks.Dirt.id && world.getLightLevel(l, i2 + 1, j2) >= 4 && !world.getMaterial(l, i2 + 1, j2).blocksLight()) {
                world.setTypeIdAndData(l, i2, j2, AetherBlocks.Grass.id, 0);
            }
        }
    }
    
    public int idDropped(final int i, final Random random, final int derp) {
        return AetherBlocks.Dirt.getDropType(0, random, derp);
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        entityplayer.a(StatisticList.C[super.id], 1);
        /*
        if (mod_Aether.equippedSkyrootShovel()) {
            this.b(world, i, j, k, l, 0);
        }
        */
        super.a(world, entityplayer, i, j, k, l);
    }
    
    
    
    public boolean blockActivated(final World world, final int i, final int j, final int k, final EntityPlayer entityPlayer) {
        if (world.isStatic) {
            return false;
        }
        if (entityPlayer == null) {
            return false;
        }
        final ItemStack itemStack = entityPlayer.U();
        if (itemStack == null) {
            return false;
        }
        if (itemStack.id == AetherItems.AmbrosiumShard.id && world.getData(i, j, k) == 0) {
            world.setData(i, j, k, 1);
            final ItemStack itemStack2 = itemStack;
            --itemStack2.count;
            return true;
        }
        if (itemStack.id == Item.INK_SACK.id && itemStack.getData() == 15) {
            final ItemStack itemStack3 = itemStack;
            --itemStack3.count;
            int iSpawned = 0;
            int var9 = 0;
        Label_0333_Outer:
            while (var9 < 64) {
                int var10 = i;
                int var11 = j + 1;
                int var12 = k;
                int var13 = 0;
                while (true) {
                    while (var13 < var9 / 16) {
                        var10 += world.random.nextInt(3) - 1;
                        var11 += (world.random.nextInt(3) - 1) * world.random.nextInt(3) / 2;
                        var12 += world.random.nextInt(3) - 1;
                        if (world.getTypeId(var10, var11 - 1, var12) == super.id) {
                            if (!world.e(var10, var11, var12)) {
                                ++var13;
                                continue Label_0333_Outer;
                            }
                        }
                        ++var9;
                        continue Label_0333_Outer;
                    }
                    if (world.getTypeId(var10, var11, var12) != 0) {
                        continue;
                    }
                    if (world.random.nextInt(20 + 10 * iSpawned) == 0) {
                        world.setTypeId(var10, var11, var12, mod_Aether.idBlockWhiteFlower);
                        ++iSpawned;
                        continue;
                    }
                    if (world.random.nextInt(10 + 2 * iSpawned) <= 2) {
                        world.setTypeId(var10, var11, var12, mod_Aether.idBlockPurpleFlower);
                        ++iSpawned;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
    }
    
    static {
        BlockAetherGrass.sprTop = 16;
        BlockAetherGrass.sprSide = 15;
        BlockAetherGrass.sprGoldTop = 53;
        BlockAetherGrass.sprGoldSide = 52;
    }
}
