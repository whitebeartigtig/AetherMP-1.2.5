package net.minecraft.server;

import forge.*;

public class ItemPoisonCure extends ItemFood implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemPoisonCure(final int i, final int j, final boolean flag) {
        super(i, j, flag);
    }
    /*
    public ItemStack onFoodEaten(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (AetherPoison.curePoison()) {
            --itemstack.count;
        }
        return itemstack;
    }
    */
}
