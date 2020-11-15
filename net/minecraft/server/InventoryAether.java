package net.minecraft.server;

import java.util.List;

import org.bukkit.craftbukkit.entity.CraftHumanEntity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryHolder;

public class InventoryAether implements IInventory
{
    public ItemStack[] slots;
    public EntityPlayer player;
    
    public InventoryAether(final EntityPlayer entityplayer) {
        this.player = entityplayer;
        this.slots = new ItemStack[8];
    }
    
    public void readFromNBT(final NBTTagList nbttaglist) {
        this.slots = new ItemStack[8];
        for (int i = 0; i < nbttaglist.size(); ++i) {
            final NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.get(i);
            final int j = nbttagcompound.getByte("Slot") & 0xFF;
            final ItemStack itemstack = ItemStack.a(nbttagcompound);
            if (j > 8 || !(itemstack.getItem() instanceof ItemMoreArmor)) {
                this.readOldFile(nbttaglist);
                return;
            }
            if (itemstack.getItem() != null) {
                if (j < this.slots.length) {
                    this.slots[j] = itemstack;
                }
            }
        }
    }
    
    public void readOldFile(final NBTTagList nbttaglist) {
        for (int i = 0; i < nbttaglist.size(); ++i) {
            final NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.get(i);
            final int j = nbttagcompound.getByte("Slot") & 0xFF;
            final ItemStack itemstack = ItemStack.a(nbttagcompound);
            if (itemstack.getItem() != null) {
                if (j >= 104 && j < 112) {
                    this.slots[j - 104] = itemstack;
                }
            }
        }
    }
    
    public NBTTagList writeToNBT(final NBTTagList nbttaglist) {
        for (int j = 0; j < this.slots.length; ++j) {
            if (this.slots[j] != null) {
                final NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)j);
                this.slots[j].writeTobNBT(nbttagcompound1);
                nbttaglist.add((NBTBase)nbttagcompound1);
            }
        }
        return nbttaglist;
    }
    
    public ItemStack getStackInSlot(final int i) {
        return this.slots[i];
    }
    
    public ItemStack decrStackSize(final int i, final int j) {
        if (this.slots[i] == null) {
            return null;
        }
        if (this.slots[i].count <= j) {
            final ItemStack itemstack = this.slots[i];
            this.slots[i] = null;
            this.onInventoryChanged();
            return itemstack;
        }
        final ItemStack itemstack2 = this.slots[i].a(j);
        if (this.slots[i].count == 0) {
            this.slots[i] = null;
        }
        this.onInventoryChanged();
        return itemstack2;
    }
    
    public void setInventorySlotContents(final int i, final ItemStack itemstack) {
        this.slots[i] = itemstack;
        if (itemstack != null && itemstack.count > this.getInventoryStackLimit()) {
            itemstack.count = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }
    
    public int getSizeInventory() {
        return 8;
    }
    
    public String getInvName() {
        return "Aether Slots";
    }
    
    public int getInventoryStackLimit() {
        return 1;
    }
    
    public void onInventoryChanged() {
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return true;
    }
    
    public int getTotalArmorValue() {
        int i = 0;
        int j = 0;
        int k = 0;
        for (int l = 0; l < this.slots.length; ++l) {
            if (this.slots[l] != null && this.slots[l].getItem() instanceof ItemMoreArmor) {
                final int i2 = this.slots[l].i();
                final int j2 = this.slots[l].g();
                final int k2 = i2 - j2;
                j += k2;
                k += i2;
                final int l2 = ((ItemMoreArmor)this.slots[l].getItem()).damageReduceAmount;
                i += l2;
            }
        }
        if (k == 0) {
            return 0;
        }
        return (i - 1) * j / k + 1;
    }
    
    public void damageArmor(final int i) {
        for (int j = 0; j < this.slots.length; ++j) {
            if (this.slots[j] != null) {
                if (this.slots[j].getItem() instanceof ItemMoreArmor) {
                    this.slots[j].damage(i, (EntityLiving)this.player);
                    if (this.slots[j].count == 0) {
                        this.slots[j].a(this.player);
                        this.slots[j] = null;
                    }
                }
            }
        }
    }
    
    public void dropAllItems() {
        for (int j = 0; j < this.slots.length; ++j) {
            if (this.slots[j] != null) {
                this.player.a(this.slots[j], true);
                this.slots[j] = null;
            }
        }
    }
    
    public void openChest() {
    }
    
    public void closeChest() {
    }
    
    public boolean isUseableByPlayer(final EntityPlayer var1) {
        return true;
    }
    
    public ItemStack getStackInSlotOnClosing(final int var1) {
        return null;
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
	public InventoryHolder getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HumanEntity> getViewers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onClose(CraftHumanEntity arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOpen(CraftHumanEntity arg0) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
