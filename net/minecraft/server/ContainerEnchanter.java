package net.minecraft.server;

public class ContainerEnchanter extends Container
{
    private TileEntityEnchanter enchanter;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;
    
    public ContainerEnchanter(final PlayerInventory playerinventory, final TileEntityEnchanter tileentityenchanter) {
        this.cookTime = 0;
        this.burnTime = 0;
        this.itemBurnTime = 0;
        this.enchanter = tileentityenchanter;
        this.a(new Slot((IInventory)tileentityenchanter, 0, 56, 17));
        this.a(new Slot((IInventory)tileentityenchanter, 1, 56, 53));
        this.a((Slot)new SlotResult2(playerinventory.player, (IInventory)tileentityenchanter, 2, 116, 35));
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 9; ++k) {
                this.a(new Slot((IInventory)playerinventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }
        }
        for (int j = 0; j < 9; ++j) {
            this.a(new Slot((IInventory)playerinventory, j, 8 + j * 18, 142));
        }
    }
    
    public void updateCraftingResults() {
        super.a();
        for (int i = 0; i < super.listeners.size(); ++i) {
            final ICrafting icrafting = (ICrafting) super.listeners.get(i);
            if (this.cookTime != this.enchanter.enchantTimeForItem) {
                icrafting.setContainerData((Container)this, 0, this.enchanter.enchantTimeForItem);
            }
            if (this.burnTime != this.enchanter.enchantProgress) {
                icrafting.setContainerData((Container)this, 1, this.enchanter.enchantProgress);
            }
            if (this.itemBurnTime != this.enchanter.enchantPowerRemaining) {
                icrafting.setContainerData((Container)this, 2, this.enchanter.enchantPowerRemaining);
            }
        }
        this.cookTime = this.enchanter.enchantTimeForItem;
        this.burnTime = this.enchanter.enchantProgress;
        this.itemBurnTime = this.enchanter.enchantPowerRemaining;
    }
    
    public ItemStack transferStackInSlot(final int i) {
        ItemStack itemstack = null;
        final Slot slot = (Slot) super.e.get(i);
        if (slot != null && slot.c()) {
            final ItemStack itemstack2 = slot.getItem();
            itemstack = itemstack2.cloneItemStack();
            if (i == 2) {
                if (!this.a(itemstack2, 3, 39, true)) {
                    return null;
                }
            }
            else if (i >= 3 && i < 30) {
                if (!this.a(itemstack2, 30, 39, false)) {
                    return null;
                }
            }
            else if (i >= 30 && i < 39) {
                if (!this.a(itemstack2, 3, 30, false)) {
                    return null;
                }
            }
            else if (!this.a(itemstack2, 3, 39, false)) {
                return null;
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
    
    public void updateProgressBar(final int i, final int j) {
        if (i == 0) {
            this.enchanter.enchantTimeForItem = j;
        }
        if (i == 1) {
            this.enchanter.enchantProgress = j;
        }
        if (i == 2) {
            this.enchanter.enchantPowerRemaining = j;
        }
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return this.enchanter.isUseableByPlayer(entityplayer);
    }

	@Override
	public boolean b(EntityHuman arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
