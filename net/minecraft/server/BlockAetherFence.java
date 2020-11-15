package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherFence extends BlockFence implements ITextureProvider
{
    public BlockAetherFence(final int par1, final int par2) {
        super(par1, par2, Material.WOOD);
    }
    
    public BlockAetherFence(final int par1, final int par2, final Material par3Material) {
        super(par1, par2, par3Material);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
