package net.minecraft.server;

import java.util.*;

public class DungeonLoot
{
    public final ItemStack loot;
    public final int min;
    public final int max;
    
    public DungeonLoot(final ItemStack itemstack) {
        this.loot = new ItemStack(itemstack.id, 1, itemstack.getData());
        final int stackSize = itemstack.count;
        this.max = stackSize;
        this.min = stackSize;
    }
    
    public DungeonLoot(final ItemStack itemstack, final int i, final int j) {
        this.loot = new ItemStack(itemstack.id, 1, itemstack.getData());
        this.min = i;
        this.max = j;
    }
    
    public ItemStack getStack() {
        int i = 0;
        if (this.loot.id <= 255) {
            if (Block.byId[this.loot.id].getRenderColor(1) != 1) {
                i = this.loot.getData();
            }
            else if (!this.loot.getItem().g()) {
                i = this.loot.getData();
            }
        }
        return new ItemStack(this.loot.id, this.min + new Random().nextInt(this.max - this.min + 1), i);
    }
}
