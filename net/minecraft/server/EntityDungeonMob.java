package net.minecraft.server;

public class EntityDungeonMob extends EntityCreature implements IMonster
{
    protected int attackStrength;
    
    public EntityDungeonMob(final World world) {
        super(world);
        this.attackStrength = 2;
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    public void onLivingUpdate() {
        final float f = this.b(1.0f);
        if (f > 0.5f) {
            ((EntityLiving)this).aV += 2;
        }
        super.e();
    }
    
    protected Entity findPlayerToAttack() {
        final EntityHuman entityhuman = ((Entity)this).world.findNearbyPlayer((Entity)this, 16.0);
        if (entityhuman != null && this.h((Entity)entityhuman)) {
            return (Entity)entityhuman;
        }
        return null;
    }
    
    public boolean attackEntityFrom(final DamageSource src, final int i) {
        if (!super.damageEntity(src, i)) {
            return false;
        }
        final Entity entity = src.getEntity();
        if (entity != null) {
            if (((Entity)this).passenger == entity || ((Entity)this).vehicle == entity) {
                return true;
            }
            if (entity != this) {
                super.target = entity;
            }
        }
        return true;
    }
    
    protected void attackEntity(final Entity entity, final float f) {
        if (((EntityLiving)this).attackTicks <= 0 && f < 2.0f && entity.boundingBox.e > ((Entity)this).boundingBox.b && entity.boundingBox.b < ((Entity)this).boundingBox.e) {
            ((EntityLiving)this).attackTicks = 20;
            entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), this.attackStrength);
        }
    }
    
    public float getBlockPathWeight(final int i, final int j, final int k) {
        return 0.5f - ((Entity)this).world.p(i, j, k);
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        if (((Entity)this).world.a(EnumSkyBlock.SKY, i, j, k) > ((Entity)this).random.nextInt(32)) {
            return false;
        }
        int l = ((Entity)this).world.getLightLevel(i, j, k);
        if (((Entity)this).world.w()) {
            final int i2 = ((Entity)this).world.f;
            ((Entity)this).world.f = 10;
            l = ((Entity)this).world.getLightLevel(i, j, k);
            ((Entity)this).world.f = i2;
        }
        return l <= ((Entity)this).random.nextInt(8) && super.canSpawn();
    }
}
