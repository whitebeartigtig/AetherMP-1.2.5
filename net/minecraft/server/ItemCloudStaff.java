package net.minecraft.server;

import java.util.*;

public class ItemCloudStaff extends AetherItem
{
    public ItemCloudStaff(final int i) {
        super(i);
        super.maxStackSize = 1;
        this.setMaxDurability(60);
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        if (!this.cloudsExist(world, entityplayer)) {
            final EntityMiniCloud c1 = new EntityMiniCloud(world, entityplayer, false);
            final EntityMiniCloud c2 = new EntityMiniCloud(world, entityplayer, true);
            world.addEntity((Entity)c1);
            world.addEntity((Entity)c2);
            itemstack.damage(1, (EntityLiving)entityplayer);
        }
        return itemstack;
    }
    
    private boolean cloudsExist(final World world, final EntityPlayer entityplayer) {
        final List list = world.getEntities((Entity)entityplayer, ((Entity)entityplayer).boundingBox.grow(128.0, 128.0, 128.0));
        for (int j = 0; j < list.size(); ++j) {
            final Entity entity1 = list.get(j);
            if (entity1 instanceof EntityMiniCloud) {
                return true;
            }
        }
        return false;
    }
}
