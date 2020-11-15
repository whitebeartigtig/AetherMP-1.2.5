package net.minecraft.server;

import forge.*;

public class ItemSwordGravitite extends ItemSword implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemSwordGravitite(final int itemID, final EnumToolMaterial mat) {
        super(itemID, mat);
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        if (entityliving1 != null && entityliving1 instanceof EntityPlayer && (entityliving.hurtTicks > 0 || entityliving.deathTicks > 0)) {
            ++((Entity)entityliving).motY;
            itemstack.damage(1, entityliving1);
        }
        return true;
    }
}
