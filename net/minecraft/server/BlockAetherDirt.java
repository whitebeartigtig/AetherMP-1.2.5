package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherDirt extends Block implements ITextureProvider
{
    protected BlockAetherDirt(final int blockID) {
        super(blockID, 6, Material.EARTH);
        this.c(0.2f);
    }
    
    public boolean isOpaqueCube() {
        return true;
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        world.setTypeId(i, j, k, super.id);
        world.setData(i, j, k, 1);
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        entityplayer.a(StatisticList.C[super.id], 1);
        /*
        if (l == 0 && mod_Aether.equippedSkyrootShovel()) {
            this.b(world, i, j, k, l, 0);
        }
        */
        this.b(world, i, j, k, l, 0);
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
        if (itemStack.id == AetherItems.SwetBall.id) {
            final ItemStack itemStack2 = itemStack;
            --itemStack2.count;
            int iSpawned = 0;
            int var9 = 0;
        Label_0238_Outer:
            while (var9 < 64) {
                int var10 = i;
                int var11 = j;
                int var12 = k;
                int var13 = 0;
                while (true) {
                    while (var13 < var9 / 16) {
                        var10 += world.random.nextInt(3) - 1;
                        var11 += (world.random.nextInt(3) - 1) * world.random.nextInt(3) / 2;
                        var12 += world.random.nextInt(3) - 1;
                        if (world.getTypeId(var10, var11, var12) == super.id) {
                            if (!world.e(var10, var11, var12)) {
                                ++var13;
                                continue Label_0238_Outer;
                            }
                        }
                        ++var9;
                        continue Label_0238_Outer;
                    }
                    if (world.getTypeId(var10, var11, var12) == super.id && world.random.nextInt(10 + 2 * iSpawned) <= 2) {
                        world.setTypeId(var10, var11, var12, mod_Aether.idBlockAetherGrass);
                        ++iSpawned;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
