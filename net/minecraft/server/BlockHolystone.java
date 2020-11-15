package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockHolystone extends Block implements ITextureProvider
{
    public static int sprNormal;
    public static int sprMossy;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockHolystone(final int blockID) {
        super(blockID, BlockHolystone.sprNormal, Material.STONE);
        this.c(0.5f);
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int x, final int y, final int z, final int meta) {
        entityplayer.a(StatisticList.C[super.id], 1);
        final ItemStack stack = new ItemStack(super.id, 1, (meta <= 1) ? 0 : 2);
        if (mod_Aether.equippedSkyrootPick() && (meta == 0 || meta == 2)) {
            final ItemStack itemStack = stack;
            itemStack.count *= 2;
        }
        final EntityItem entityitem = new EntityItem(world, (double)x, (double)y, (double)z, stack);
        entityitem.pickupDelay = 10;
        world.addEntity((Entity)entityitem);
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (j > 1) {
            return BlockHolystone.sprMossy;
        }
        return BlockHolystone.sprNormal;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 2));
    }
    
    static {
        BlockHolystone.sprNormal = 19;
        BlockHolystone.sprMossy = 30;
    }
}
