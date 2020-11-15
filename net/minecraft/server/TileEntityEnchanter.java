package net.minecraft.server;

import java.util.*;

public class TileEntityEnchanter extends TileEntity implements IInventory
{
    private static List enchantments;
    private ItemStack[] enchanterItemStacks;
    public int enchantProgress;
    public int enchantPowerRemaining;
    public int enchantTimeForItem;
    private EnchantmentAether currentEnchantment;
    
    public TileEntityEnchanter() {
        this.enchanterItemStacks = new ItemStack[3];
        this.enchantProgress = 0;
        this.enchantPowerRemaining = 0;
        this.enchantTimeForItem = 0;
    }
    
    public int getSizeInventory() {
        return this.enchanterItemStacks.length;
    }
    
    public ItemStack getStackInSlot(final int i) {
        return this.enchanterItemStacks[i];
    }
    
    public ItemStack decrStackSize(final int i, final int j) {
        if (this.enchanterItemStacks[i] == null) {
            return null;
        }
        if (this.enchanterItemStacks[i].count <= j) {
            final ItemStack itemstack = this.enchanterItemStacks[i];
            this.enchanterItemStacks[i] = null;
            return itemstack;
        }
        final ItemStack itemstack2 = this.enchanterItemStacks[i].a(j);
        if (this.enchanterItemStacks[i].count == 0) {
            this.enchanterItemStacks[i] = null;
        }
        return itemstack2;
    }
    
    public void setInventorySlotContents(final int i, final ItemStack itemstack) {
        this.enchanterItemStacks[i] = itemstack;
        if (itemstack != null && itemstack.count > this.getInventoryStackLimit()) {
            itemstack.count = this.getInventoryStackLimit();
        }
    }
    
    public String getInvName() {
        return "Enchanter";
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        final NBTTagList nbttaglist = nbttagcompound.getList("Items");
        this.enchanterItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.size(); ++i) {
            final NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist.get(i);
            final byte byte0 = nbttagcompound2.getByte("Slot");
            if (byte0 >= 0 && byte0 < this.enchanterItemStacks.length) {
                this.enchanterItemStacks[byte0] = ItemStack.a(nbttagcompound2);
            }
        }
        this.enchantProgress = nbttagcompound.getShort("BurnTime");
        this.enchantTimeForItem = nbttagcompound.getShort("CookTime");
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)this.enchantProgress);
        nbttagcompound.setShort("CookTime", (short)this.enchantTimeForItem);
        final NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.enchanterItemStacks.length; ++i) {
            if (this.enchanterItemStacks[i] != null) {
                final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                nbttagcompound2.setByte("Slot", (byte)i);
                this.enchanterItemStacks[i].save(nbttagcompound2);
                nbttaglist.add((NBTBase)nbttagcompound2);
            }
        }
        nbttagcompound.set("Items", (NBTBase)nbttaglist);
    }
    
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public int getCookProgressScaled(final int i) {
        if (this.enchantTimeForItem == 0) {
            return 0;
        }
        return this.enchantProgress * i / this.enchantTimeForItem;
    }
    
    public int getBurnTimeRemainingScaled(final int i) {
        return this.enchantPowerRemaining * i / 500;
    }
    
    public boolean isBurning() {
        return this.enchantPowerRemaining > 0;
    }
    
    public void updateEntity() {
        if (this.enchantPowerRemaining > 0) {
            --this.enchantPowerRemaining;
            if (this.currentEnchantment != null) {
                ++this.enchantProgress;
            }
        }
        if (this.currentEnchantment != null && (this.enchanterItemStacks[0] == null || this.enchanterItemStacks[0].id != this.currentEnchantment.enchantFrom.id)) {
            this.currentEnchantment = null;
            this.enchantProgress = 0;
        }
        if (this.currentEnchantment != null && this.enchantProgress >= this.currentEnchantment.enchantPowerNeeded) {
            if (this.enchanterItemStacks[2] == null) {
                this.setInventorySlotContents(2, new ItemStack(this.currentEnchantment.enchantTo.getItem(), 1, this.currentEnchantment.enchantTo.getData()));
            }
            else {
                this.setInventorySlotContents(2, new ItemStack(this.currentEnchantment.enchantTo.getItem(), this.getStackInSlot(2).count + 1, this.currentEnchantment.enchantTo.getData()));
            }
            this.decrStackSize(0, 1);
            this.enchantProgress = 0;
            this.currentEnchantment = null;
            this.enchantTimeForItem = 0;
        }
        if (this.enchantPowerRemaining <= 0 && this.currentEnchantment != null && this.getStackInSlot(1) != null && this.getStackInSlot(1).id == AetherItems.AmbrosiumShard.id) {
            this.enchantPowerRemaining += 500;
            this.decrStackSize(1, 1);
        }
        if (this.currentEnchantment == null) {
            final ItemStack itemstack = this.getStackInSlot(0);
            for (int i = 0; i < TileEntityEnchanter.enchantments.size(); ++i) {
                if (itemstack != null && TileEntityEnchanter.enchantments.get(i) != null && itemstack.id == TileEntityEnchanter.enchantments.get(i).enchantFrom.id) {
                    if (this.enchanterItemStacks[2] == null) {
                        this.currentEnchantment = TileEntityEnchanter.enchantments.get(i);
                        this.enchantTimeForItem = this.currentEnchantment.enchantPowerNeeded;
                    }
                    else if (this.enchanterItemStacks[2].id == TileEntityEnchanter.enchantments.get(i).enchantTo.id && TileEntityEnchanter.enchantments.get(i).enchantTo.getItem().getItemStackLimit() > this.enchanterItemStacks[2].count) {
                        this.currentEnchantment = TileEntityEnchanter.enchantments.get(i);
                        this.enchantTimeForItem = this.currentEnchantment.enchantPowerNeeded;
                    }
                }
            }
        }
    }
    
    public boolean isUseableByPlayer(final EntityPlayer entityplayer) {
        return super.world.getTileEntity(super.x, super.y, super.z) == this && entityplayer.e(super.x + 0.5, super.y + 0.5, super.z + 0.5) <= 64.0;
    }
    
    public static void addEnchantment(final ItemStack from, final ItemStack to, final int i) {
        TileEntityEnchanter.enchantments.add(new EnchantmentAether(from, to, i));
    }
    
    public void openChest() {
    }
    
    public void closeChest() {
    }
    
    public ItemStack getStackInSlotOnClosing(final int var1) {
        return null;
    }
    
    static {
        TileEntityEnchanter.enchantments = new ArrayList();
        addEnchantment(new ItemStack(AetherBlocks.GravititeOre, 1), new ItemStack(AetherBlocks.EnchantedGravitite, 1), 1000);
        addEnchantment(new ItemStack(AetherItems.PickSkyroot, 1), new ItemStack(AetherItems.PickSkyroot, 1), 250);
        addEnchantment(new ItemStack(AetherItems.SwordSkyroot, 1), new ItemStack(AetherItems.SwordSkyroot, 1), 250);
        addEnchantment(new ItemStack(AetherItems.ShovelSkyroot, 1), new ItemStack(AetherItems.ShovelSkyroot, 1), 200);
        addEnchantment(new ItemStack(AetherItems.AxeSkyroot, 1), new ItemStack(AetherItems.AxeSkyroot, 1), 200);
        addEnchantment(new ItemStack(AetherItems.PickHolystone, 1), new ItemStack(AetherItems.PickHolystone, 1), 600);
        addEnchantment(new ItemStack(AetherItems.SwordHolystone, 1), new ItemStack(AetherItems.SwordHolystone, 1), 600);
        addEnchantment(new ItemStack(AetherItems.ShovelHolystone, 1), new ItemStack(AetherItems.ShovelHolystone, 1), 500);
        addEnchantment(new ItemStack(AetherItems.AxeHolystone, 1), new ItemStack(AetherItems.AxeHolystone, 1), 500);
        addEnchantment(new ItemStack(AetherItems.PickZanite, 1), new ItemStack(AetherItems.PickZanite, 1), 2500);
        addEnchantment(new ItemStack(AetherItems.SwordZanite, 1), new ItemStack(AetherItems.SwordZanite, 1), 2500);
        addEnchantment(new ItemStack(AetherItems.ShovelZanite, 1), new ItemStack(AetherItems.ShovelZanite, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.AxeZanite, 1), new ItemStack(AetherItems.AxeZanite, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.PickGravitite, 1), new ItemStack(AetherItems.PickGravitite, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.SwordGravitite, 1), new ItemStack(AetherItems.SwordGravitite, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.ShovelGravitite, 1), new ItemStack(AetherItems.ShovelGravitite, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.AxeGravitite, 1), new ItemStack(AetherItems.AxeGravitite, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.Dart, 1, 0), new ItemStack(AetherItems.Dart, 1, 2), 250);
        addEnchantment(new ItemStack(AetherItems.Bucket, 1, 2), new ItemStack(AetherItems.Bucket, 1, 3), 1000);
        addEnchantment(new ItemStack(Item.RECORD_1, 1), new ItemStack(AetherItems.BlueMusicDisk, 1), 2500);
        addEnchantment(new ItemStack(Item.RECORD_2, 1), new ItemStack(AetherItems.BlueMusicDisk, 1), 2500);
        addEnchantment(new ItemStack(Item.LEATHER, 1), new ItemStack(Item.LEATHER, 1), 400);
        addEnchantment(new ItemStack(Item.LEATHER_CHESTPLATE, 1), new ItemStack(Item.LEATHER_CHESTPLATE, 1), 500);
        addEnchantment(new ItemStack(Item.LEATHER_LEGGINGS, 1), new ItemStack(Item.LEATHER_LEGGINGS, 1), 500);
        addEnchantment(new ItemStack(Item.LEATHER_BOOTS, 1), new ItemStack(Item.LEATHER_BOOTS, 1), 400);
        addEnchantment(new ItemStack(Item.WOOD_PICKAXE, 1), new ItemStack(Item.WOOD_PICKAXE, 1), 500);
        addEnchantment(new ItemStack(Item.WOOD_SPADE, 1), new ItemStack(Item.WOOD_SPADE, 1), 400);
        addEnchantment(new ItemStack(Item.WOOD_SWORD, 1), new ItemStack(Item.WOOD_SWORD, 1), 500);
        addEnchantment(new ItemStack(Item.WOOD_AXE, 1), new ItemStack(Item.WOOD_AXE, 1), 400);
        addEnchantment(new ItemStack(Item.WOOD_HOE, 1), new ItemStack(Item.WOOD_HOE, 1), 300);
        addEnchantment(new ItemStack(Item.STONE_PICKAXE, 1), new ItemStack(Item.STONE_PICKAXE, 1), 1000);
        addEnchantment(new ItemStack(Item.STONE_SPADE, 1), new ItemStack(Item.STONE_SPADE, 1), 750);
        addEnchantment(new ItemStack(Item.STONE_SWORD, 1), new ItemStack(Item.STONE_SWORD, 1), 1000);
        addEnchantment(new ItemStack(Item.STONE_AXE, 1), new ItemStack(Item.STONE_AXE, 1), 750);
        addEnchantment(new ItemStack(Item.STONE_HOE, 1), new ItemStack(Item.STONE_HOE, 1), 750);
        addEnchantment(new ItemStack(Item.IRON_HELMET, 1), new ItemStack(Item.IRON_HELMET, 1), 1500);
        addEnchantment(new ItemStack(Item.IRON_CHESTPLATE, 1), new ItemStack(Item.IRON_CHESTPLATE, 1), 2000);
        addEnchantment(new ItemStack(Item.IRON_LEGGINGS, 1), new ItemStack(Item.IRON_LEGGINGS, 1), 2000);
        addEnchantment(new ItemStack(Item.IRON_BOOTS, 1), new ItemStack(Item.IRON_BOOTS, 1), 1500);
        addEnchantment(new ItemStack(Item.IRON_PICKAXE, 1), new ItemStack(Item.IRON_PICKAXE, 1), 2500);
        addEnchantment(new ItemStack(Item.IRON_SPADE, 1), new ItemStack(Item.IRON_SPADE, 1), 2000);
        addEnchantment(new ItemStack(Item.IRON_SWORD, 1), new ItemStack(Item.IRON_SWORD, 1), 2500);
        addEnchantment(new ItemStack(Item.IRON_AXE, 1), new ItemStack(Item.IRON_AXE, 1), 1500);
        addEnchantment(new ItemStack(Item.IRON_HOE, 1), new ItemStack(Item.IRON_HOE, 1), 1500);
        addEnchantment(new ItemStack(Item.GOLD_HELMET, 1), new ItemStack(Item.GOLD_HELMET, 1), 1000);
        addEnchantment(new ItemStack(Item.GOLD_CHESTPLATE, 1), new ItemStack(Item.GOLD_CHESTPLATE, 1), 1200);
        addEnchantment(new ItemStack(Item.GOLD_LEGGINGS, 1), new ItemStack(Item.GOLD_LEGGINGS, 1), 1200);
        addEnchantment(new ItemStack(Item.GOLD_BOOTS, 1), new ItemStack(Item.GOLD_BOOTS, 1), 1000);
        addEnchantment(new ItemStack(Item.GOLD_PICKAXE, 1), new ItemStack(Item.GOLD_PICKAXE, 1), 1500);
        addEnchantment(new ItemStack(Item.GOLD_SPADE, 1), new ItemStack(Item.GOLD_SPADE, 1), 1000);
        addEnchantment(new ItemStack(Item.GOLD_SWORD, 1), new ItemStack(Item.GOLD_SWORD, 1), 1500);
        addEnchantment(new ItemStack(Item.GOLD_AXE, 1), new ItemStack(Item.GOLD_AXE, 1), 1000);
        addEnchantment(new ItemStack(Item.GOLD_HOE, 1), new ItemStack(Item.GOLD_HOE, 1), 1000);
        addEnchantment(new ItemStack(Item.DIAMOND_HELMET, 1), new ItemStack(Item.DIAMOND_HELMET, 1), 5000);
        addEnchantment(new ItemStack(Item.DIAMOND_CHESTPLATE, 1), new ItemStack(Item.DIAMOND_CHESTPLATE, 1), 6000);
        addEnchantment(new ItemStack(Item.DIAMOND_LEGGINGS, 1), new ItemStack(Item.DIAMOND_LEGGINGS, 1), 6000);
        addEnchantment(new ItemStack(Item.DIAMOND_BOOTS, 1), new ItemStack(Item.DIAMOND_BOOTS, 1), 5000);
        addEnchantment(new ItemStack(Item.DIAMOND_PICKAXE, 1), new ItemStack(Item.DIAMOND_PICKAXE, 1), 7000);
        addEnchantment(new ItemStack(Item.DIAMOND_SPADE, 1), new ItemStack(Item.DIAMOND_SPADE, 1), 6000);
        addEnchantment(new ItemStack(Item.DIAMOND_SWORD, 1), new ItemStack(Item.DIAMOND_SWORD, 1), 6500);
        addEnchantment(new ItemStack(Item.DIAMOND_AXE, 1), new ItemStack(Item.DIAMOND_AXE, 1), 6000);
        addEnchantment(new ItemStack(Item.DIAMOND_HOE, 1), new ItemStack(Item.DIAMOND_HOE, 1), 6000);
        addEnchantment(new ItemStack(Item.FISHING_ROD, 1), new ItemStack(Item.FISHING_ROD, 1), 500);
        addEnchantment(new ItemStack(AetherBlocks.Quicksoil, 1), new ItemStack(AetherBlocks.QuicksoilGlass, 1), 250);
        addEnchantment(new ItemStack(AetherBlocks.Holystone, 1), new ItemStack(AetherItems.HealingStone, 1), 750);
        addEnchantment(new ItemStack(AetherItems.GravititeHelmet, 1), new ItemStack(AetherItems.GravititeHelmet, 1), 12000);
        addEnchantment(new ItemStack(AetherItems.GravititeBodyplate, 1), new ItemStack(AetherItems.GravititeBodyplate, 1), 20000);
        addEnchantment(new ItemStack(AetherItems.GravititePlatelegs, 1), new ItemStack(AetherItems.GravititePlatelegs, 1), 15000);
        addEnchantment(new ItemStack(AetherItems.GravititeBoots, 1), new ItemStack(AetherItems.GravititeBoots, 1), 12000);
        addEnchantment(new ItemStack(AetherItems.GravititeGlove, 1), new ItemStack(AetherItems.GravititeGlove, 1), 10000);
        addEnchantment(new ItemStack(AetherItems.ZaniteHelmet, 1), new ItemStack(AetherItems.ZaniteHelmet, 1), 6000);
        addEnchantment(new ItemStack(AetherItems.ZaniteChestplate, 1), new ItemStack(AetherItems.ZaniteChestplate, 1), 10000);
        addEnchantment(new ItemStack(AetherItems.ZaniteLeggings, 1), new ItemStack(AetherItems.ZaniteLeggings, 1), 8000);
        addEnchantment(new ItemStack(AetherItems.ZaniteBoots, 1), new ItemStack(AetherItems.ZaniteBoots, 1), 5000);
        addEnchantment(new ItemStack(AetherItems.ZaniteGlove, 1), new ItemStack(AetherItems.ZaniteGlove, 1), 4000);
        addEnchantment(new ItemStack(AetherItems.ZaniteRing, 1), new ItemStack(AetherItems.ZaniteRing, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.ZanitePendant, 1), new ItemStack(AetherItems.ZanitePendant, 1), 2000);
        addEnchantment(new ItemStack(AetherItems.LeatherGlove, 1), new ItemStack(AetherItems.LeatherGlove, 1), 300);
        addEnchantment(new ItemStack(AetherItems.IronGlove, 1), new ItemStack(AetherItems.IronGlove, 1), 1200);
        addEnchantment(new ItemStack(AetherItems.GoldGlove, 1), new ItemStack(AetherItems.GoldGlove, 1), 800);
        addEnchantment(new ItemStack(AetherItems.DiamondGlove, 1), new ItemStack(AetherItems.DiamondGlove, 1), 4000);
        addEnchantment(new ItemStack(AetherItems.DartShooter, 1, 0), new ItemStack(AetherItems.DartShooter, 1, 2), 2000);
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
