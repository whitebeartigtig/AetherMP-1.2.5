package net.minecraft.server;

public class TileEntityIncubatorSlot extends Slot
{
    public TileEntityIncubatorSlot(final IInventory inv, final int slot, final int x, final int y) {
        super(inv, slot, x, y);
    }
    
    public int getSlotStackLimit() {
        return 1;
    }
}
