package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherFlower extends BlockFlower implements ITextureProvider
{
    protected BlockAetherFlower(final int var1, final int var2) {
        super(var1, var2);
        ((Block)this).textureId = var2;
        this.a(true);
        final float var3 = 0.2f;
        this.c(0.0f);
        this.a("White_Flower");
        this.a(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, var3 * 3.0f, 0.5f + var3);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(final int var1) {
        return var1 == AetherBlocks.Grass.id || var1 == AetherBlocks.Dirt.id;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
