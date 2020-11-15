package net.minecraft.server;

class SlotMoreArmor extends Slot
{
    final int armorType;
    final ContainerAether inventory;
    
    SlotMoreArmor(final ContainerAether containerplayer, final IInventory iinventory, final int i, final int j, final int k, final int l) {
        super(iinventory, i, j, k);
        this.inventory = containerplayer;
        this.armorType = l;
    }
    
    public int getSlotStackLimit() {
        return 1;
    }
    
    public boolean isItemValid(final ItemStack itemstack) {
        return itemstack.getItem() instanceof ItemMoreArmor && ((ItemMoreArmor)itemstack.getItem()).isTypeValid(this.armorType);
    }
}
