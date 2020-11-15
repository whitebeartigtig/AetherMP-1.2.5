package net.minecraft.server;

public class ContainerFreezer extends Container
{
    private TileEntityFreezer freezer;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
    
    public ContainerFreezer(final PlayerInventory playerinventory, final TileEntityFreezer tileentityfreezer) {
        this.cookTime = 0;
        this.burnTime = 0;
        this.itemBurnTime = 0;
        this.freezer = tileentityfreezer;
        this.a(new Slot((IInventory)tileentityfreezer, 0, 56, 17));
        this.a(new Slot((IInventory)tileentityfreezer, 1, 56, 53));
        this.a((Slot)new SlotResult2(playerinventory.player, (IInventory)tileentityfreezer, 2, 116, 35));
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 9; ++k) {
                this.a(new Slot((IInventory)playerinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.a(new Slot((IInventory)playerinventory, j, 8 + j * 18, 142));
        }
    }
    
    protected void retrySlotClick(final int par1, final int par2, final boolean par3, final EntityPlayer par4EntityPlayer) {
    }
    
    public void updateCraftingResults() {
        super.a();
        for (int i = 0; i < super.listeners.size(); ++i) {
            final ICrafting icrafting = super.crafters.get(i);
            if (this.cookTime != this.freezer.frozenTimeForItem) {
                icrafting.setContainerData((Container)this, 0, this.freezer.frozenTimeForItem);
            }
            if (this.burnTime != this.freezer.frozenProgress) {
                icrafting.setContainerData((Container)this, 1, this.freezer.frozenProgress);
            }
            if (this.itemBurnTime != this.freezer.frozenPowerRemaining) {
                icrafting.setContainerData((Container)this, 2, this.freezer.frozenPowerRemaining);
            }
        }
        this.cookTime = this.freezer.frozenTimeForItem;
        this.burnTime = this.freezer.frozenProgress;
        this.itemBurnTime = this.freezer.frozenPowerRemaining;
    }
    
    public void updateProgressBar(final int i, final int j) {
        if (i == 0) {
            this.freezer.frozenTimeForItem = j;
        }
        if (i == 1) {
            this.freezer.frozenProgress = j;
        }
        if (i == 2) {
            this.freezer.frozenPowerRemaining = j;
        }
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return this.freezer.isUseableByPlayer(entityplayer);
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
