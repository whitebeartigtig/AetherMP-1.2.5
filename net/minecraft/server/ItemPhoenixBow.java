package net.minecraft.server;

public class ItemPhoenixBow extends AetherItem
{
    public ItemPhoenixBow(final int i) {
        super(i);
        super.maxStackSize = 1;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (entityplayer.inventory.c(Item.ARROW.id)) {
            world.makeSound((Entity)entityplayer, "mob.ghast.fireball", 1.0f, 1.0f / (Item.c.nextFloat() * 0.4f + 0.8f));
            if (!world.isStatic) {
                world.addEntity((Entity)new EntityFlamingArrow(world, (EntityLiving)entityplayer));
            }
        }
        return itemstack;
    }
}
