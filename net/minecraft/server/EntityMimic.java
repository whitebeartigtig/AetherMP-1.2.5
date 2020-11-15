package net.minecraft.server;

public class EntityMimic extends EntityDungeonMob
{
    public float mouth;
    public float legs;
    private float legsDirection;
    
    public EntityMimic(final World world) {
        super(world);
        this.legsDirection = 1.0f;
        ((EntityLiving)this).texture = "/aether/mobs/Mimic.png";
        ((Entity)this).height = 0.0f;
        this.b(1.0f, 2.0f);
        ((EntityLiving)this).health = 40;
        super.attackStrength = 5;
        super.target = (Entity)world.findNearbyPlayer((Entity)this, 64.0);
    }
    
    public void onUpdate() {
        super.F_();
        this.mouth = (float)(Math.cos(((Entity)this).ticksLived / 10.0f * 3.1415927f) + 1.0) * 0.6f;
        this.legs *= 0.9f;
        if (((Entity)this).motX > 0.001 || ((Entity)this).motX < -0.001 || ((Entity)this).motZ > 0.001 || ((Entity)this).motZ < -0.001) {
            this.legs += this.legsDirection * 0.2f;
            if (this.legs > 1.0f) {
                this.legsDirection = -1.0f;
            }
            if (this.legs < -1.0f) {
                this.legsDirection = 1.0f;
            }
        }
    }
    
    public void applyEntityCollision(final Entity entity) {
        if (!((Entity)this).dead && entity != null) {
            entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), 4);
        }
    }
    
    public boolean attackEntityFrom(final EntityLiving entity, final int i) {
        if (entity instanceof EntityPlayer) {
            this.a((Entity)entity, 10.0f, 10.0f);
            super.target = (Entity)entity;
        }
        return super.attackEntityFrom(DamageSource.mobAttack(entity), i);
    }
    
    protected String getHurtSound() {
        return "mob.slime";
    }
    
    protected String getDeathSound() {
        return "mob.slime";
    }
    
    protected float getSoundVolume() {
        return 0.6f;
    }
    
    protected int getDropItemId() {
        return Block.CHEST.id;
    }
}
