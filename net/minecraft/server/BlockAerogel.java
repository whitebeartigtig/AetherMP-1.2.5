package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAerogel extends Block implements ITextureProvider
{
    public BlockAerogel(final int blockID) {
        super(blockID, 1, Material.STONE);
        this.c(1.0f);
        this.b(2000.0f);
        this.f(3);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
