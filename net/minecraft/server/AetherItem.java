package net.minecraft.server;

import forge.*;

public class AetherItem extends Item implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected AetherItem(final int i) {
        super(i);
    }
}
