package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockZaniteOre extends Block implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockZaniteOre(final int blockID) {
        super(blockID, 44, Material.STONE);
        this.c(3.0f);
    }
    
    public int idDropped(final int i, final Random random, final int k) {
        return AetherItems.Zanite.id;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
