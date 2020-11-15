package net.minecraft.server;

public class TileEntityIncubator extends TileEntity implements IInventory
{
    private ItemStack[] IncubatorItemStacks;
    public int torchPower;
    public int progress;
    
    public TileEntityIncubator() {
        this.IncubatorItemStacks = new ItemStack[2];
        this.progress = 0;
    }
    
    public int getSizeInventory() {
        return this.IncubatorItemStacks.length;
    }
    
    public ItemStack getStackInSlot(final int i) {
        return this.IncubatorItemStacks[i];
    }
    
    public ItemStack decrStackSize(final int i, final int j) {
        if (this.IncubatorItemStacks[i] == null) {
            return null;
        }
        if (this.IncubatorItemStacks[i].count <= j) {
            final ItemStack itemstack = this.IncubatorItemStacks[i];
            this.IncubatorItemStacks[i] = null;
            return itemstack;
        }
        final ItemStack itemstack2 = this.IncubatorItemStacks[i].a(j);
        if (this.IncubatorItemStacks[i].count == 0) {
            this.IncubatorItemStacks[i] = null;
        }
        return itemstack2;
    }
    
    public void setInventorySlotContents(final int i, final ItemStack itemstack) {
        this.IncubatorItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.count > this.getInventoryStackLimit()) {
            itemstack.count = this.getInventoryStackLimit();
        }
    }
    
    public String getInvName() {
        return "Incubator";
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        final NBTTagList nbttaglist = nbttagcompound.getList("Items");
        this.IncubatorItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.size(); ++i) {
            final NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist.get(i);
            final byte byte0 = nbttagcompound2.getByte("Slot");
            if (byte0 >= 0 && byte0 < this.IncubatorItemStacks.length) {
                this.IncubatorItemStacks[byte0] = ItemStack.a(nbttagcompound2);
            }
        }
        this.progress = nbttagcompound.getShort("BurnTime");
    }
    
    public void openChest() {
    }
    
    public void closeChest() {
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)this.progress);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.IncubatorItemStacks.length; ++i) {
            if (this.IncubatorItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                nbttagcompound2.setByte("Slot", (byte)i);
                this.IncubatorItemStacks[i].save(nbttagcompound2);
                nbttaglist.add((NBTBase)nbttagcompound2);
            }
        }
        nbttagcompound.set("Items", (NBTBase)nbttaglist);
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public int getCookProgressScaled(final int i) {
        return this.progress * i / 6000;
    }
    
    public int getBurnTimeRemainingScaled(final int i) {
        return this.torchPower * i / 500;
    }
    
    public boolean isBurning() {
        return this.torchPower > 0;
    }
    
    public void updateEntity() {
        if (this.torchPower > 0) {
            --this.torchPower;
            if (this.getStackInSlot(1) != null) {
                ++this.progress;
            }
        }
        if (this.IncubatorItemStacks[1] == null || this.IncubatorItemStacks[1].id != AetherItems.MoaEgg.id) {
            this.progress = 0;
        }
        if (this.progress >= 6000) {
            if (this.IncubatorItemStacks[1] != null) {
                final EntityMoa moa = new EntityMoa(super.world, true, false, false, MoaColour.getColour(this.IncubatorItemStacks[1].getData()));
                moa.setPosition(super.x + 0.5, super.y + 1.5, super.z + 0.5);
                super.world.addEntity((Entity)moa);
            }
            mod_Aether.giveAchievement(AetherAchievements.incubator);
            this.decrStackSize(1, 1);
            this.progress = 0;
        }
        if (this.torchPower <= 0 && this.IncubatorItemStacks[1] != null && this.IncubatorItemStacks[1].id == AetherItems.MoaEgg.id && this.getStackInSlot(0) != null && this.getStackInSlot(0).id == AetherBlocks.AmbrosiumTorch.id) {
            this.torchPower += 1000;
            this.decrStackSize(0, 1);
        }
    }
    
    public boolean isUseableByPlayer(final EntityPlayer entityplayer) {
        return super.world.getTileEntity(super.x, super.y, super.z) == this && entityplayer.e(super.x + 0.5, super.y + 0.5, super.z + 0.5) <= 64.0;
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
