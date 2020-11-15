package net.minecraft.server;

import forge.*;

public class ItemSwordZanite extends ItemSword implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemSwordZanite(final int itemID, final EnumToolMaterial mat) {
        super(itemID, mat);
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return super.getDestroySpeed(itemstack, block) * (2.0f * itemstack.getData() / itemstack.getItem().getMaxDurability() + 0.5f);
    }
}
