package net.minecraft.server;

import java.util.*;

public class TileEntityFreezer extends TileEntity implements IInventory
{
    private static List frozen;
    private ItemStack[] frozenItemStacks;
    public int frozenProgress;
    public int frozenPowerRemaining;
    public int frozenTimeForItem;
    private Frozen currentFrozen;
    
    public TileEntityFreezer() {
        this.frozenItemStacks = new ItemStack[3];
        this.frozenProgress = 0;
        this.frozenPowerRemaining = 0;
        this.frozenTimeForItem = 0;
    }
    
    public int getSizeInventory() {
        return this.frozenItemStacks.length;
    }
    
    public ItemStack getStackInSlot(final int i) {
        return this.frozenItemStacks[i];
    }
    
    public ItemStack decrStackSize(final int i, final int j) {
        if (this.frozenItemStacks[i] == null) {
            return null;
        }
        if (this.frozenItemStacks[i].count <= j) {
            final ItemStack itemstack = this.frozenItemStacks[i];
            this.frozenItemStacks[i] = null;
            return itemstack;
        }
        final ItemStack itemstack2 = this.frozenItemStacks[i].a(j);
        if (this.frozenItemStacks[i].count == 0) {
            this.frozenItemStacks[i] = null;
        }
        return itemstack2;
    }
    
    public void setInventorySlotContents(final int i, final ItemStack itemstack) {
        this.frozenItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.count > this.getInventoryStackLimit()) {
            itemstack.count = this.getInventoryStackLimit();
        }
    }
    
    public String getInvName() {
        return "Freezer";
    }
    
    public void openChest() {
    }
    
    public void closeChest() {
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        final NBTTagList nbttaglist = nbttagcompound.getList("Items");
        this.frozenItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.size(); ++i) {
            final NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist.get(i);
            final byte byte0 = nbttagcompound2.getByte("Slot");
            if (byte0 >= 0 && byte0 < this.frozenItemStacks.length) {
                this.frozenItemStacks[byte0] = ItemStack.a(nbttagcompound2);
            }
        }
        this.frozenProgress = nbttagcompound.getShort("BurnTime");
        this.frozenTimeForItem = nbttagcompound.getShort("CookTime");
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)this.frozenProgress);
        nbttagcompound.setShort("CookTime", (short)this.frozenTimeForItem);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.frozenItemStacks.length; ++i) {
            if (this.frozenItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                nbttagcompound2.setByte("Slot", (byte)i);
                this.frozenItemStacks[i].save(nbttagcompound2);
                nbttaglist.add((NBTBase)nbttagcompound2);
            }
        }
        nbttagcompound.set("Items", (NBTBase)nbttaglist);
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public int getCookProgressScaled(final int i) {
        if (this.frozenTimeForItem == 0) {
            return 0;
        }
        return this.frozenProgress * i / this.frozenTimeForItem;
    }
    
    public int getBurnTimeRemainingScaled(final int i) {
        return this.frozenPowerRemaining * i / 500;
    }
    
    public boolean isBurning() {
        return this.frozenPowerRemaining > 0;
    }
    
    public void updateEntity() {
        if (this.frozenPowerRemaining > 0) {
            --this.frozenPowerRemaining;
            if (this.currentFrozen != null) {
                ++this.frozenProgress;
            }
        }
        if (this.currentFrozen != null && (this.frozenItemStacks[0] == null || this.frozenItemStacks[0].id != this.currentFrozen.frozenFrom.id)) {
            this.currentFrozen = null;
            this.frozenProgress = 0;
        }
        if (this.currentFrozen != null && this.frozenProgress >= this.currentFrozen.frozenPowerNeeded) {
            if (this.frozenItemStacks[2] == null) {
                this.setInventorySlotContents(2, new ItemStack(this.currentFrozen.frozenTo.getItem(), 1, this.currentFrozen.frozenTo.getData()));
            }
            else {
                this.setInventorySlotContents(2, new ItemStack(this.currentFrozen.frozenTo.getItem(), this.getStackInSlot(2).count + 1, this.currentFrozen.frozenTo.getData()));
            }
            if (this.getStackInSlot(0).id == Item.WATER_BUCKET.id || this.getStackInSlot(0).id == Item.LAVA_BUCKET.id) {
                this.setInventorySlotContents(0, new ItemStack(Item.BUCKET));
            }
            else if (this.getStackInSlot(0).id == AetherItems.Bucket.id) {
                this.setInventorySlotContents(0, new ItemStack(AetherItems.Bucket));
            }
            else {
                this.decrStackSize(0, 1);
            }
            this.frozenProgress = 0;
            this.currentFrozen = null;
            this.frozenTimeForItem = 0;
        }
        if (this.frozenPowerRemaining <= 0 && this.currentFrozen != null && this.getStackInSlot(1) != null && this.getStackInSlot(1).id == AetherBlocks.Icestone.id) {
            this.frozenPowerRemaining += 500;
            this.decrStackSize(1, 1);
        }
        if (this.currentFrozen == null) {
            final ItemStack itemstack = this.getStackInSlot(0);
            for (int i = 0; i < TileEntityFreezer.frozen.size(); ++i) {
                if (itemstack != null && TileEntityFreezer.frozen.get(i) != null && itemstack.id == TileEntityFreezer.frozen.get(i).frozenFrom.id && itemstack.getData() == TileEntityFreezer.frozen.get(i).frozenFrom.getData()) {
                    if (this.frozenItemStacks[2] == null) {
                        this.currentFrozen = (Frozen) TileEntityFreezer.frozen.get(i);
                        this.frozenTimeForItem = this.currentFrozen.frozenPowerNeeded;
                    }
                    else if (this.frozenItemStacks[2].id == TileEntityFreezer.frozen.get(i).frozenTo.id && TileEntityFreezer.frozen.get(i).frozenTo.getItem().getItemStackLimit() > this.frozenItemStacks[2].count) {
                        this.currentFrozen = (Frozen) TileEntityFreezer.frozen.get(i);
                        this.frozenTimeForItem = this.currentFrozen.frozenPowerNeeded;
                    }
                }
            }
        }
    }
    
    public boolean isUseableByPlayer(final EntityPlayer entityplayer) {
        return super.world.getTileEntity(super.x, super.y, super.z) == this && entityplayer.e(super.x + 0.5, super.y + 0.5, super.z + 0.5) <= 64.0;
    }
    
    public static void addFrozen(final ItemStack from, final ItemStack to, final int i) {
        TileEntityFreezer.frozen.add(new Frozen(from, to, i));
    }
    
    public ItemStack getStackInSlotOnClosing(final int var1) {
        return null;
    }
    
    static {
        TileEntityFreezer.frozen = new ArrayList();
        addFrozen(new ItemStack(Item.WATER_BUCKET, 1), new ItemStack(Block.ICE, 5), 500);
        addFrozen(new ItemStack(AetherItems.Bucket, 1, 8), new ItemStack(Block.ICE, 5), 500);
        addFrozen(new ItemStack(Item.LAVA_BUCKET, 1), new ItemStack(Block.OBSIDIAN, 2), 500);
        addFrozen(new ItemStack(AetherBlocks.Aercloud, 1, 0), new ItemStack(AetherBlocks.Aercloud, 1, 1), 50);
        addFrozen(new ItemStack(AetherItems.GoldPendant, 1), new ItemStack(AetherItems.IcePendant, 1), 2500);
        addFrozen(new ItemStack(AetherItems.GoldRing, 1), new ItemStack(AetherItems.IceRing, 1), 1500);
        addFrozen(new ItemStack(AetherItems.IronRing, 1), new ItemStack(AetherItems.IceRing, 1), 1500);
        addFrozen(new ItemStack(AetherItems.IronPendant, 1), new ItemStack(AetherItems.IcePendant, 1), 2500);
    }

	@Override
	public boolean a(EntityHuman arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void g() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack[] getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxStackSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setItem(int arg0, ItemStack arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxStackSize(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemStack splitStack(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack splitWithoutUpdate(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
