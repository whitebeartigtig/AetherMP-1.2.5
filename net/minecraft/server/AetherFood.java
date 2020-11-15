package net.minecraft.server;

import forge.*;

public class AetherFood extends ItemFood implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public AetherFood(final int i, final int j, final boolean flag) {
        super(i, j, flag);
    }
}
