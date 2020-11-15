package net.minecraft.server;

import java.util.*;

public class ItemLoreBook extends Item
{
    public ItemLoreBook(final int i) {
        super(i);
        super.maxStackSize = 1;
        this.a(true);
        this.setMaxDurability(0);
    }
    
    public int getColorFromDamage(final int i, final int j) {
        if (i == 0) {
            return 8388479;
        }
        if (i == 1) {
            return 16744319;
        }
        return 8355839;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        ModLoader.openGUI(entityplayer, (GuiScreen)new GuiLore(entityplayer.inventory, itemstack.getData()));
        return itemstack;
    }
    
    public String getItemNameIS(final ItemStack itemstack) {
        int i = itemstack.getData();
        if (i > 2) {
            i = 2;
        }
        return super.getName() + "." + i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
        itemList.add(new ItemStack((Item)this, 1, 2));
    }
}
