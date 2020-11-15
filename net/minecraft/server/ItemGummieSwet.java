package net.minecraft.server;

import java.util.*;

public class ItemGummieSwet extends AetherFood
{
    private int healAmount;
    private boolean damZero;
    private boolean damOne;
    
    public ItemGummieSwet(final int i) {
        super(i, 20, false);
        ((Item)this).maxStackSize = 64;
        this.damZero = false;
        this.damOne = false;
        this.healAmount = 20;
        this.a(true);
    }
    
    public int getColorFromDamage(final int damage, final int j) {
        if (damage == 1) {
            return 16777087;
        }
        return 8765927;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > 1) {
            i = 1;
        }
        return this.getName() + i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
    }
}
