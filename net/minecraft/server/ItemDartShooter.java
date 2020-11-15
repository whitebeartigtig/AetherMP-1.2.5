package net.minecraft.server;

import java.util.*;

public class ItemDartShooter extends AetherItem
{
    public static int sprNormal;
    public static int sprPoison;
    public static int sprEnchanted;
    
    public ItemDartShooter(final int i) {
        super(i);
        this.a(true);
        super.maxStackSize = 1;
    }
    
    public int getIconFromDamage(final int damage) {
        if (damage == 0) {
            return ItemDartShooter.sprNormal;
        }
        if (damage == 1) {
            return ItemDartShooter.sprPoison;
        }
        if (damage == 2) {
            return ItemDartShooter.sprEnchanted;
        }
        return ItemDartShooter.sprNormal;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > 2) {
            i = 2;
        }
        return this.getName() + i;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        final int consume = this.consumeItem(entityplayer, AetherItems.Dart.id, itemstack.getData());
        if (consume != -1) {
            world.makeSound((Entity)entityplayer, "aether.sound.other.dartshooter.shootDart", 2.0f, 1.0f / (Item.c.nextFloat() * 0.4f + 0.8f));
            if (!world.isStatic) {
                EntityDartGolden dart = null;
                if (consume == 1) {
                    dart = new EntityDartPoison(world, (EntityLiving)entityplayer);
                }
                if (consume == 2) {
                    dart = new EntityDartEnchanted(world, (EntityLiving)entityplayer);
                }
                if (dart == null) {
                    dart = new EntityDartGolden(world, (EntityLiving)entityplayer);
                }
                world.addEntity((Entity)dart);
            }
        }
        return itemstack;
    }
    
    private int consumeItem(final EntityPlayer player, final int itemID, final int maxDamage) {
        final IInventory inv = (IInventory)player.inventory;
        for (int i = 0; i < inv.getSize(); ++i) {
            ItemStack stack = inv.getItem(i);
            if (stack != null) {
                final int damage = stack.getData();
                if (stack.id == itemID && stack.getData() == maxDamage) {
                    final ItemStack itemStack = stack;
                    --itemStack.count;
                    if (stack.count == 0) {
                        stack = null;
                    }
                    inv.setItem(i, stack);
                    return damage;
                }
            }
        }
        return -1;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this, 1, 0));
        itemList.add(new ItemStack((Item)this, 1, 1));
        itemList.add(new ItemStack((Item)this, 1, 2));
    }
    
    static {
        ItemDartShooter.sprNormal = 21;
        ItemDartShooter.sprPoison = 23;
        ItemDartShooter.sprEnchanted = 22;
    }
}
