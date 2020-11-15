package net.minecraft.server;

import java.util.*;

public class ItemDart extends AetherItem
{
    public static int sprGolden;
    public static int sprEnchanted;
    public static int sprPoison;
    
    protected ItemDart(final int itemID) {
        super(itemID);
        this.a(true);
    }
    
    public int getIconFromDamage(final int damage) {
        if (damage == 0) {
            return ItemDart.sprGolden;
        }
        if (damage == 1) {
            return ItemDart.sprEnchanted;
        }
        if (damage == 2) {
            return ItemDart.sprPoison;
        }
        return ItemDart.sprGolden;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > 2) {
            i = 2;
        }
        return this.getName() + i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
        itemList.add(new ItemStack((Item)this, 1, 2));
    }
    
    static {
        ItemDart.sprGolden = 19;
        ItemDart.sprEnchanted = 20;
        ItemDart.sprPoison = 18;
    }
}
