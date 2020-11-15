package net.minecraft.server;

import forge.*;

public class ItemPigSlayer extends ItemSword implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemPigSlayer(final int i) {
        super(i, EnumToolMaterial.IRON);
        this.setMaxDurability(0);
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
        if (entityliving == null || entityliving1 == null) {
            return false;
        }
        final String s = EntityTypes.b((Entity)entityliving);
        if (!s.equals("") && s.toLowerCase().contains("pig")) {
            if (entityliving.health > 0) {
                entityliving.health = 1;
                entityliving.hurtTicks = 0;
                entityliving.damageEntity(DamageSource.mobAttack(entityliving1), 9999);
            }
            for (int j = 0; j < 20; ++j) {
                final double d = ((Entity)entityliving1).random.nextGaussian() * 0.02;
                final double d2 = ((Entity)entityliving1).random.nextGaussian() * 0.02;
                final double d3 = ((Entity)entityliving1).random.nextGaussian() * 0.02;
                final double d4 = 5.0;
                ((Entity)entityliving).world.a("flame", ((Entity)entityliving).locX + ((Entity)entityliving).random.nextFloat() * ((Entity)entityliving).width * 2.0f - ((Entity)entityliving).width - d * d4, ((Entity)entityliving).locY + ((Entity)entityliving).random.nextFloat() * ((Entity)entityliving).height - d2 * d4, ((Entity)entityliving).locZ + ((Entity)entityliving).random.nextFloat() * ((Entity)entityliving).width * 2.0f - ((Entity)entityliving).width - d3 * d4, d, d2, d3);
            }
            int lootingModifier = 0;
            if (entityliving1 instanceof EntityPlayer) {
                lootingModifier = EnchantmentManager.getBonusMonsterLootEnchantmentLevel(((EntityPlayer)entityliving1).inventory);
            }
            entityliving.dropDeathLoot(entityliving1 instanceof EntityPlayer, lootingModifier);
            ((Entity)entityliving).dead = true;
        }
        return true;
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        return true;
    }
}
