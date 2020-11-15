package net.minecraft.server;

import forge.*;

public class ItemSkyrootSword extends ItemSword implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemSkyrootSword(final int itemID, final EnumToolMaterial mat) {
        super(itemID, mat);
    }
}
