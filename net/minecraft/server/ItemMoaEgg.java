package net.minecraft.server;

import java.util.*;

public class ItemMoaEgg extends AetherItem
{
    protected ItemMoaEgg(final int itemID) {
        super(itemID);
        this.a(true);
    }
    
    public int getColorFromDamage(final int damage, final int j) {
        return MoaColour.getColour(damage).colour;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > MoaColour.colours.size() - 1) {
            i = MoaColour.colours.size() - 1;
        }
        return this.getName() + i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
        itemList.add(new ItemStack((Item)this, 1, 2));
    }
}
