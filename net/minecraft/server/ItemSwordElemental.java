package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemSwordElemental extends ItemSword implements ITextureProvider
{
    public static ArrayList undead;
    private int weaponDamage;
    private int holyDamage;
    private EnumElement element;
    private int colour;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemSwordElemental(final int i, final EnumElement element, final int colour) {
        super(i, EnumToolMaterial.DIAMOND);
        this.d(AetherItems.ElementalSwordIcon);
        ((Item)this).maxStackSize = 1;
        this.setMaxDurability((element == EnumElement.Holy) ? 128 : 32);
        this.weaponDamage = 4;
        this.holyDamage = 20;
        this.element = element;
        this.colour = colour;
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return 1.5f;
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        itemstack.damage(2, entityliving);
        return true;
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        if (this.element == EnumElement.Fire) {
            entityliving.setOnFire(30);
        }
        /*
        else if (this.element == EnumElement.Lightning) {
            ModLoader.getMinecraftInstance().theWorld.spawnEntityInWorld((Entity)new EntityAetherLightning(ModLoader.getMinecraftInstance().theWorld, (int)((Entity)entityliving).locX, (int)((Entity)entityliving).locY, (int)((Entity)entityliving).locZ));
        }
        */
        itemstack.damage(1, entityliving1);
        return true;
    }
    
    public int getDamageVsEntity(final Entity entity) {
        if (this.element == EnumElement.Holy && entity instanceof EntityLiving) {
            final EntityLiving living = (EntityLiving)entity;
            for (final Class cls : ItemSwordElemental.undead) {
                if (living.getClass().isAssignableFrom(cls)) {
                    return this.holyDamage;
                }
            }
        }
        return this.weaponDamage;
    }
    
    public int getColorFromDamage(final int i, final int j) {
        return this.colour;
    }
    
    public boolean isFull3D() {
        return true;
    }
    
    static {
        (ItemSwordElemental.undead = new ArrayList()).add(EntityZombie.class);
        ItemSwordElemental.undead.add(EntitySkeleton.class);
        ItemSwordElemental.undead.add(EntityPigZombie.class);
    }
}
