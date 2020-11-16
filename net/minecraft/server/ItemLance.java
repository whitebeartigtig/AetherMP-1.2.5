package net.minecraft.server;

import java.util.*;

public class ItemLance extends AetherItem
{
    private int weaponDamage;
    
    public ItemLance(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i);
        super.maxStackSize = 1;
        this.setMaxDurability(enumtoolmaterial.a());
        this.weaponDamage = 4 + enumtoolmaterial.c() * 2;
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return (block.id != Block.WEB.id) ? 1.5f : 15.0f;
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        return false;
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        itemstack.damage(2, entityliving);
        return true;
    }
    
    public int getDamageVsEntity(final Entity entity) {
        return 0;
    }
    
    public boolean isFull3D() {
        return true;
    }
    
    public boolean canHarvestBlock(final Block block) {
        return block.id == Block.WEB.id;
    }
    
    public void onUpdate(final ItemStack itemstack, final World world, final Entity entity, final int i, final boolean flag) {
        if (!flag) {
            return;
        }
        if (!(entity instanceof EntityHuman)) {
            return;
        }
        final EntityHuman player = (EntityHuman)entity;
        /*
        if (!Mouse.isButtonDown(0)) {
            return;
        }
        */
        if (player.u != -1) {
            return;
        }
        final Vec3D look = player.aJ();
        final double dist = 8.0;
        final AxisAlignedBB aabb = ((Entity)player).boundingBox.grow(dist, dist, dist);
        final List list = world.a((Class)Entity.class, aabb);
        Entity found = null;
        double foundLen = 0.0;
        for (final Object o : list) {
            if (o == player) {
                continue;
            }
            final Entity ent = (Entity)o;
            if (!ent.o_()) {
                continue;
            }
            Vec3D vec = Vec3D.create(ent.locX - ((Entity)player).locX, ent.boundingBox.b + ent.height / 2.0f - ((Entity)player).locY - player.getHeadHeight(), ent.locZ - ((Entity)player).locZ);
            final double len = vec.c();
            if (len > dist) {
                continue;
            }
            vec = vec.b();
            final double dot = look.a(vec);
            if (dot < 1.0 - 0.125 / len) {
                continue;
            }
            if (!player.h(ent)) {
                continue;
            }
            if (foundLen != 0.0 && len >= foundLen) {
                continue;
            }
            found = ent;
            foundLen = len;
        }
        if (found == null) {
            return;
        }
        found.damageEntity(DamageSource.playerAttack(player), this.weaponDamage);
        if (found instanceof EntityLiving) {
            itemstack.damage(1, (EntityLiving)found);
        }
    }
}
