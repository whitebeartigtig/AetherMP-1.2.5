package net.minecraft.server;

public class ItemCloudParachute extends AetherItem
{
    private static int tex;
    
    public ItemCloudParachute(final int i) {
        super(i);
        this.d(ItemCloudParachute.tex);
        super.maxStackSize = 1;
        this.setMaxDurability((i == mod_Aether.idItemCloudParachuteGold) ? 20 : 0);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (EntityCloudParachute.entityHasRoomForCloud(world, (EntityLiving)entityplayer)) {
            for (int i = 0; i < 32; ++i) {
                EntityCloudParachute.doCloudSmoke(world, (EntityLiving)entityplayer);
            }
            if (super.id == AetherItems.CloudParachuteGold.id) {
                itemstack.damage(1, (EntityLiving)entityplayer);
            }
            else {
                --itemstack.count;
            }
            world.makeSound((Entity)entityplayer, "cloud", 1.0f, 1.0f / (Item.c.nextFloat() * 0.1f + 0.95f));
            world.addEntity((Entity)new EntityCloudParachute(world, (EntityLiving)entityplayer, super.id == AetherItems.CloudParachuteGold.id));
        }
        return itemstack;
    }
    
    public int getColorFromDamage(final int i, final int j) {
        if (super.id == AetherItems.CloudParachuteGold.id) {
            return 16777087;
        }
        return 16777215;
    }
    
    static {
        ItemCloudParachute.tex = 16;
    }
}
