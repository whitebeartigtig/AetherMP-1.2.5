package net.minecraft.server;

import forge.*;

public class ItemBlockAetherGrass extends ItemBlock implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public ItemBlockAetherGrass(final int itemID) {
        super(itemID);
        this.a("BlockAetherGrass");
        this.a(true);
    }
    
    public String getItemNameIS(final ItemStack itemstack) {
        int i = itemstack.getData();
        if (i == 1) {
            i = 1;
        }
        if (i == 0) {
            i = 0;
        }
        return this.getName() + i;
    }
    
    public int getMetadata(final int damage) {
        if (damage == 1) {
            return 1;
        }
        return 0;
    }
}
