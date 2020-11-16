package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherLog extends Block implements ITextureProvider
{
    public static int sprTop;
    public static int sprSide;
    public static int sprGoldenSide;
    private static Random rand;
    
    protected BlockAetherLog(final int blockID) {
        super(blockID, BlockAetherLog.sprSide, Material.WOOD);
        this.c(2.0f);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (i <= 1 && j <= 3) {
            return BlockAetherLog.sprTop;
        }
        if (j <= 1) {
            return BlockAetherLog.sprSide;
        }
        return BlockAetherLog.sprGoldenSide;
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int x, final int y, final int z, final int meta) {
        entityplayer.a(StatisticList.C[super.id], 1);
        ItemStack stack = new ItemStack(super.id, 1, 0);
        /*
        if (mod_Aether.equippedSkyrootAxe() && meta != 1) {
            final ItemStack itemStack = stack;
            itemStack.count *= 2;
        }
        */
        final EntityItem entityitem = new EntityItem(world, (double)x, (double)y, (double)z, stack);
        entityitem.pickupDelay = 10;
        world.addEntity((Entity)entityitem);
        final ItemStack itemstack = entityplayer.inventory.getItemInHand();
        if (itemstack == null || (itemstack.id != AetherItems.AxeZanite.id && itemstack.id != AetherItems.AxeGravitite.id && meta >= 2)) {
            return;
        }
        if (meta > 1 && BlockAetherLog.rand.nextBoolean()) {
            stack = new ItemStack(AetherItems.GoldenAmber.id, 2 + BlockAetherLog.rand.nextInt(2), 0);
            final EntityItem entityitem2 = new EntityItem(world, (double)x, (double)y, (double)z, stack);
            entityitem2.pickupDelay = 10;
            world.addEntity((Entity)entityitem2);
        }
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        BlockAetherLog.sprTop = 41;
        BlockAetherLog.sprSide = 40;
        BlockAetherLog.sprGoldenSide = 11;
        BlockAetherLog.rand = new Random();
    }
}
