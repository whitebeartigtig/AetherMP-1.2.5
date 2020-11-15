package net.minecraft.server;

import java.util.*;

public class ItemAetherKey extends AetherItem
{
    protected ItemAetherKey(final int itemID) {
        super(itemID);
        this.d(36);
        this.a("AetherKey");
        this.a(true);
        super.maxStackSize = 1;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > 2) {
            i = 2;
        }
        return this.getName() + i;
    }
    
    public int getColorFromDamage(final int damage, final int par2) {
        if (damage == 1) {
            return -6710887;
        }
        if (damage == 2) {
            return -13312;
        }
        return -7638187;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
        itemList.add(new ItemStack((Item)this, 1, 2));
    }
}
