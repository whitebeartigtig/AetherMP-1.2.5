package net.minecraft.server;

public class ContainerIncubator extends Container
{
    private TileEntityIncubator Incubator;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
    
    public ContainerIncubator(final PlayerInventory playerinventory, final TileEntityIncubator tileentityIncubator) {
        this.cookTime = 0;
        this.burnTime = 0;
        this.itemBurnTime = 0;
        this.Incubator = tileentityIncubator;
        this.a((Slot)new TileEntityIncubatorSlot((IInventory)tileentityIncubator, 1, 73, 17));
        this.a(new Slot((IInventory)tileentityIncubator, 0, 73, 53));
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 9; ++k) {
                this.a(new Slot((IInventory)playerinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.a(new Slot((IInventory)playerinventory, j, 8 + j * 18, 142));
        }
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return this.Incubator.isUseableByPlayer(entityplayer);
    }
    
    protected void retrySlotClick(final int par1, final int par2, final boolean par3, final EntityPlayer par4EntityPlayer) {
    }
    
    public ItemStack getStackInSlot(final int i) {
        ItemStack itemstack = null;
        final Slot slot = super.inventorySlots.get(i);
        if (slot != null && slot.c()) {
            final ItemStack itemstack2 = slot.getItem();
            itemstack = itemstack2.cloneItemStack();
            if (i == 2) {
                this.a(itemstack2, 3, 39, true);
            }
            else if (i >= 3 && i < 30) {
                this.a(itemstack2, 30, 39, false);
            }
            else if (i >= 30 && i < 39) {
                this.a(itemstack2, 3, 30, false);
            }
            else {
                this.a(itemstack2, 3, 39, false);
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
