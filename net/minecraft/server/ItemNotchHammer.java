package net.minecraft.server;

public class ItemNotchHammer extends AetherItem
{
    private int weaponDamage;
    
    public ItemNotchHammer(final int i) {
        super(i);
        super.maxStackSize = 1;
        this.setMaxDurability(EnumToolMaterial.IRON.a());
        this.weaponDamage = 4 + EnumToolMaterial.IRON.c() * 2;
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return 1.5f;
    }
    
    public boolean hitEntity(final ItemStack itemstack, final EntityLiving entityliving, final EntityLiving entityliving1) {
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
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        itemstack.damage(1, (EntityLiving)entityplayer);
        world.makeSound((Entity)entityplayer, "mob.ghast.fireball", 1.0f, 1.0f / (Item.c.nextFloat() * 0.4f + 0.8f));
        if (!world.isStatic) {
            final EntityNotchWave notchwave = new EntityNotchWave(world, (EntityLiving)entityplayer);
            world.addEntity((Entity)notchwave);
        }
        return itemstack;
    }
    
    public boolean isFull3D() {
        return true;
    }
}
