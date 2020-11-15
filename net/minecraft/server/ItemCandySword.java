package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemCandySword extends ItemSword implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemCandySword(final int itemID, final EnumToolMaterial mat) {
        super(itemID, mat);
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        if (new Random().nextInt(25) == 0 && entityliving1 != null && entityliving1 instanceof EntityPlayer && (entityliving.hurtTicks > 0 || entityliving.deathTicks > 0)) {
            entityliving.a(AetherItems.CandyCane.id, 1, 0.0f);
            itemstack.damage(1, entityliving1);
        }
        itemstack.damage(1, entityliving1);
        return true;
    }
}
