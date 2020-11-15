package net.minecraft.server;

public class ItemLightningKnife extends AetherItem
{
    public ItemLightningKnife(final int i) {
        super(i);
        super.maxStackSize = 16;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        --itemstack.count;
        world.makeSound((Entity)entityplayer, "mob.aether.dartshoot", 2.0f, 1.0f / (Item.c.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            world.addEntity((Entity)new EntityLightningKnife(world, (EntityLiving)entityplayer));
        }
        return itemstack;
    }
}
