package net.minecraft.server;

import java.util.*;

public class BlockZanite extends Block
{
    protected BlockZanite(final int blockID, final int j) {
        super(blockID, j, Material.STONE);
        this.c(3.0f);
    }
    
    public int getRenderColor(final int i) {
        return 10066431;
    }
    
    public int colorMultiplier(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        return this.getRenderColor(iblockaccess.getData(i, j, k));
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
