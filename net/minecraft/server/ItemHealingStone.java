package net.minecraft.server;

import forge.*;

public class ItemHealingStone extends ItemGoldenApple implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemHealingStone(final int i, final int j, final float f, final boolean flag) {
        super(i, j, f, flag);
    }
}
