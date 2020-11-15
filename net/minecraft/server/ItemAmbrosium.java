package net.minecraft.server;

public class ItemAmbrosium extends AetherItem
{
    private int healAmount;
    
    public ItemAmbrosium(final int i, final int j) {
        super(i);
        this.healAmount = j;
        super.maxStackSize = 64;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        --itemstack.count;
        entityplayer.heal(this.healAmount);
        return itemstack;
    }
    
    public int getHealAmount() {
        return this.healAmount;
    }
}
