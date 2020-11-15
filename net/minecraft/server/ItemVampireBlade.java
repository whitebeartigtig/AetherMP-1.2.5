package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemVampireBlade extends Item implements ITextureProvider
{
    private int weaponDamage;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemVampireBlade(final int i) {
        super(i);
        super.maxStackSize = 1;
        this.setMaxDurability(EnumToolMaterial.DIAMOND.a());
        this.weaponDamage = 4 + EnumToolMaterial.DIAMOND.c() * 2;
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return 1.5f;
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        final EntityPlayer player = (EntityPlayer)entityliving1;
        if (((EntityLiving)player).health < mod_Aether.getPlayer(player).maxHealth) {
            final EntityPlayer entityPlayer = player;
            ++((EntityLiving)entityPlayer).health;
        }
        itemstack.damage(1, entityliving1);
        return true;
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        itemstack.damage(2, entityliving);
        return true;
    }
    
    public int getDamageVsEntity(final Entity entity) {
        return this.weaponDamage;
    }
    
    public boolean isFull3D() {
        return true;
    }
    
    static {
        ItemVampireBlade.random = new Random();
    }
}
