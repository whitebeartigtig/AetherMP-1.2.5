package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockQuicksoilGlass extends BlockHalfTransparant implements ITextureProvider
{
    public BlockQuicksoilGlass(final int blockID, final int texture) {
        super(blockID, texture, Material.SHATTERABLE, false);
        ((Block)this).frictionFactor = 1.05f;
        this.a(0.7375f);
        this.c(0.2f);
        this.f(0);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
