package net.minecraft.server;

public class ContainerLore extends Container
{
    public IInventory loreSlot;
    
    public ContainerLore(final PlayerInventory playerinventory) {
        this.loreSlot = (IInventory)new ContainerEnchantTableSubcontainer("Lore Item", 1);
        this.a(new Slot(this.loreSlot, 0, 82, 66));
        for (int i1 = 0; i1 < 3; ++i1) {
            for (int l1 = 0; l1 < 9; ++l1) {
                this.a(new Slot((IInventory)playerinventory, l1 + i1 * 9 + 9, 48 + l1 * 18, 113 + i1 * 18));
            }
        }
        for (int j1 = 0; j1 < 9; ++j1) {
            this.a(new Slot((IInventory)playerinventory, j1, 48 + j1 * 18, 171));
        }
    }
    
    protected void retrySlotClick(final int par1, final int par2, final boolean par3, final EntityPlayer par4EntityPlayer) {
    }
    
    public void onCraftGuiClosed(final EntityPlayer entityplayer) {
        super.a(entityplayer);
        final ItemStack itemstack = this.loreSlot.getItem(0);
        if (itemstack != null) {
            entityplayer.drop(itemstack);
        }
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return true;
    }
    
    public ItemStack getStackInSlot(final int i) {
        ItemStack itemstack = null;
        final Slot slot = (Slot) super.e.get(i);
        if (slot != null && slot.c()) {
            final ItemStack itemstack2 = slot.getItem();
            itemstack = itemstack2.cloneItemStack();
            if (i == 0) {
                this.a(itemstack2, 10, 46, true);
            }
            else if (i >= 10 && i < 37) {
                this.a(itemstack2, 37, 46, false);
            }
            else if (i >= 37 && i < 46) {
                this.a(itemstack2, 10, 37, false);
            }
            else {
                this.a(itemstack2, 10, 46, false);
            }
            if (itemstack2.count == 0) {
                slot.set((ItemStack)null);
            }
            else {
                slot.d();
            }
            if (itemstack2.count == itemstack.count) {
                return null;
            }
            slot.c(itemstack2);
        }
        return itemstack;
    }

	@Override
	public boolean b(EntityHuman arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
