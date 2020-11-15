package net.minecraft.server;

public class ItemLifeShard extends AetherItem
{
    public ItemLifeShard(final int i) {
        super(i);
        super.maxStackSize = 1;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        --itemstack.count;
        mod_Aether.getPlayer(entityplayer).increaseMaxHP(2);
        return itemstack;
    }
}
