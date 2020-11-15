package net.minecraft.server;

import forge.*;
import java.util.*;

public class AetherBlock extends Block implements ITextureProvider
{
    protected AetherBlock(final int i, final int j, final Material material) {
        super(i, j, material);
    }
    
    protected AetherBlock(final int i, final Material material) {
        super(i, material);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
