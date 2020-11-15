package net.minecraft.server;

public class ContainerAether extends ContainerPlayer
{
    public ContainerAether(final PlayerInventory playerinventory, final InventoryAether inv) {
        this(playerinventory, inv, true);
    }
    
    public ContainerAether(final PlayerInventory playerinventory, final InventoryAether inv, final boolean flag) {
        super(playerinventory, flag);
        ((Container)this).e.clear();
        super.craftInventory = new InventoryCrafting((Container)this, 2, 2);
        super.resultInventory = (IInventory)new InventoryCraftResult();
        super.c = flag;
        this.a((Slot)new SlotResult(playerinventory.player, (IInventory)super.craftInventory, super.resultInventory, 0, 134, 62));
        for (int i = 0; i < 2; ++i) {
            for (int i2 = 0; i2 < 2; ++i2) {
                this.a(new Slot((IInventory)super.craftInventory, i2 + i * 2, 125 + i2 * 18, 8 + i * 18));
            }
        }
        for (int j = 0; j < 4; ++j) {
            final int j2 = j;
            this.a((Slot)new SlotArmor((ContainerPlayer)this, (IInventory)playerinventory, playerinventory.getSize() - 1 - j, 62, 8 + j * 18, j2));
        }
        for (int k = 0; k < 3; ++k) {
            for (int k2 = 0; k2 < 9; ++k2) {
                this.a(new Slot((IInventory)playerinventory, k2 + (k + 1) * 9, 8 + k2 * 18, 84 + k * 18));
            }
        }
        for (int l = 0; l < 9; ++l) {
            this.a(new Slot((IInventory)playerinventory, l, 8 + l * 18, 142));
        }
        for (int i = 1; i < 3; ++i) {
            for (int m = 0; m < 4; ++m) {
                final int slotId;
                final int armorType = slotId = 4 * (i - 1) + m;
                this.a((Slot)new SlotMoreArmor(this, (IInventory)inv, slotId, 62 + i * 18, 8 + m * 18, armorType + 4));
            }
        }
        this.a((IInventory)super.craftInventory);
    }
}
