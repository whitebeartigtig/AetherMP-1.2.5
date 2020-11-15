package net.minecraft.server;

import java.util.*;

public class BlockAetherPlank extends AetherBlock
{
    protected BlockAetherPlank(final int i, final int j, final Material material) {
        super(i, j, material);
        this.b(2.0f);
        this.c(5.0f);
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
