package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockPillar extends Block implements ITextureProvider
{
    public static int sprTop;
    public static int sprSide;
    public static int sprTopSide;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockPillar(final int i) {
        super(i, Material.STONE);
        this.c(0.5f);
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (i == 0 || i == 1) {
            return BlockPillar.sprTop;
        }
        if (j == 0) {
            return BlockPillar.sprSide;
        }
        return BlockPillar.sprTopSide;
    }
    
    protected int damageDropped(final int i) {
        return i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
        itemList.add(new ItemStack((Block)this, 1, 2));
    }
    
    static {
        BlockPillar.sprTop = 33;
        BlockPillar.sprSide = 32;
        BlockPillar.sprTopSide = 31;
    }
}
