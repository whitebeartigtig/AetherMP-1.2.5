package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemAetherArmor extends ItemArmor implements ITextureProvider
{
    public ItemAetherArmor(final int i, final EnumArmorMaterial j, final int k, final int l) {
        super(i, j, k, l);
    }
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this));
    }
}
