package net.minecraft.server;

import forge.*;

public class ItemBlockAercloud extends ItemBlock implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public ItemBlockAercloud(final int itemID) {
        super(itemID);
        this.a("BlockAercloud");
        this.a(true);
    }
    
    public String getItemNameIS(final ItemStack itemstack) {
        int i = itemstack.getData();
        if (i > 2) {
            i = 2;
        }
        return this.getName() + i;
    }
    
    public int getColorFromDamage(final int damage) {
        if (damage == 1) {
            return -7829249;
        }
        if (damage == 2) {
            return -120;
        }
        return -1;
    }
    
    public int getMetadata(final int damage) {
        return damage;
    }
}
