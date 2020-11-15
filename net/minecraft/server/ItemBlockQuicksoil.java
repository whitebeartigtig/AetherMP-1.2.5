package net.minecraft.server;

import forge.*;

public class ItemBlockQuicksoil extends ItemBlock implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public ItemBlockQuicksoil(final int itemID) {
        super(itemID);
        this.a("BlockQuicksoil");
        this.a(true);
    }
    
    public String getItemNameIS(final ItemStack itemstack) {
        return this.getName();
    }
    
    public int getMetadata(final int damage) {
        return 1;
    }
}
