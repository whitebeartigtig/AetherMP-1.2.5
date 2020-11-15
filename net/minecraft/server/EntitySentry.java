package net.minecraft.server;

public class EntitySentry extends EntityDungeonMob
{
    public float field_100021_a;
    public float field_100020_b;
    private int jcount;
    public int size;
    public int counter;
    public int lostyou;
    public boolean active;
    
    public EntitySentry(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/Sentry.png";
        this.size = 2;
        ((Entity)this).height = 0.0f;
        ((EntityLiving)this).bb = 1.0f;
        this.field_100021_a = 1.0f;
        this.field_100020_b = 1.0f;
        this.jcount = ((Entity)this).random.nextInt(20) + 10;
        this.func_100019_e(this.size);
    }
    
    public EntitySentry(final World world, final double x, final double y, final double z) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/Sentry.png";
        this.size = 2;
        ((Entity)this).height = 0.0f;
        ((EntityLiving)this).bb = 1.0f;
        this.field_100021_a = 1.0f;
        this.field_100020_b = 1.0f;
        this.jcount = ((Entity)this).random.nextInt(20) + 10;
        this.func_100019_e(this.size);
        ((Entity)this).yaw = ((Entity)this).random.nextInt(4) * 1.5707965f;
        this.setPosition(x, y, z);
    }
    
    public void func_100019_e(final int i) {
        ((EntityLiving)this).health = 10;
        ((Entity)this).width = 0.85f;
        ((Entity)this).height = 0.85f;
        this.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInt("Size", this.size - 1);
        nbttagcompound.setInt("LostYou", this.lostyou);
        nbttagcompound.setInt("Counter", this.counter);
        nbttagcompound.setBoolean("Active", this.active);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.size = nbttagcompound.getInt("Size") + 1;
        this.lostyou = nbttagcompound.getInt("LostYou");
        this.counter = nbttagcompound.getInt("Counter");
        this.active = nbttagcompound.getBoolean("Active");
    }
    
    public void onUpdate() {
        final boolean flag = ((Entity)this).onGround;
        super.F_();
        if (((Entity)this).onGround && !flag) {
            ((Entity)this).world.makeSound((Entity)this, "mob.slime", this.getSoundVolume(), ((((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f) / 0.8f);
        }
        else if (!((Entity)this).onGround && flag && super.target != null) {
            ((Entity)this).motX *= 3.0;
            ((Entity)this).motZ *= 3.0;
        }
        if (super.target != null && super.target.dead) {
            super.target = null;
        }
    }
    
    public void die() {
        if (((EntityLiving)this).health <= 0 || ((Entity)this).dead) {
            super.die();
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource ds, final int i) {
        final boolean flag = super.attackEntityFrom(ds, i);
        if (flag && ds.getEntity() instanceof EntityLiving) {
            this.active = true;
            this.lostyou = 0;
            super.target = ds.getEntity();
            ((EntityLiving)this).texture = "/aether/mobs/SentryLit.png";
        }
        return flag;
    }
    
    public void shutdown() {
        this.counter = -64;
        this.active = false;
        super.target = null;
        ((EntityLiving)this).texture = "/aether/mobs/Sentry.png";
        this.setPathEntity((PathEntity)null);
        ((EntityLiving)this).aW = 0.0f;
        ((EntityLiving)this).aX = 0.0f;
        ((EntityLiving)this).aZ = false;
        ((Entity)this).motX = 0.0;
        ((Entity)this).motZ = 0.0;
    }
    
    public void applyEntityCollision(final Entity entity) {
        if (!((Entity)this).dead && super.target != null && entity != null && super.target == entity) {
            ((Entity)this).world.explode((Entity)this, ((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, 0.1f);
            entity.damageEntity(DamageSource.GENERIC, 2);
            if (entity instanceof EntityLiving) {
                final EntityLiving entityliving = (EntityLiving)entity;
                double d;
                double d2;
                for (d = ((Entity)entityliving).locX - ((Entity)this).locX, d2 = ((Entity)entityliving).locZ - ((Entity)this).locZ; d * d + d2 * d2 < 1.0E-4; d = (Math.random() - Math.random()) * 0.01, d2 = (Math.random() - Math.random()) * 0.01) {}
                entityliving.a((Entity)this, 5, -d, -d2);
                final EntityLiving entityLiving = entityliving;
                ((Entity)entityLiving).motX *= 4.0;
                final EntityLiving entityLiving2 = entityliving;
                ((Entity)entityLiving2).motY *= 4.0;
                final EntityLiving entityLiving3 = entityliving;
                ((Entity)entityLiving3).motZ *= 4.0;
            }
            final float f = 0.01745329f;
            for (int i = 0; i < 40; ++i) {
                final double d3 = (float)((Entity)this).locX + ((Entity)this).random.nextFloat() * 0.25f;
                final double d4 = (float)((Entity)this).locY + 0.5f;
                final double d5 = (float)((Entity)this).locZ + ((Entity)this).random.nextFloat() * 0.25f;
                final float f2 = ((Entity)this).random.nextFloat() * 360.0f;
                ((Entity)this).world.a("explode", d3, d4, d5, -Math.sin(f * f2) * 0.75, 0.125, Math.cos(f * f2) * 0.75);
            }
            ((EntityLiving)this).health = 0;
            this.die();
        }
    }
    
    protected void updateEntityActionState() {
        final EntityHuman entityplayer = ((Entity)this).world.findNearbyPlayer((Entity)this, 8.0);
        if (!this.active && this.counter >= 8) {
            if (entityplayer != null && this.h((Entity)entityplayer)) {
                this.a((Entity)entityplayer, 10.0f, 10.0f);
                super.target = (Entity)entityplayer;
                this.active = true;
                this.lostyou = 0;
                ((EntityLiving)this).texture = "/aether/mobs/SentryLit.png";
            }
            this.counter = 0;
        }
        else if (this.active && this.counter >= 8) {
            if (super.target == null) {
                if (entityplayer != null && this.h((Entity)entityplayer)) {
                    super.target = (Entity)entityplayer;
                    this.active = true;
                    this.lostyou = 0;
                }
                else {
                    ++this.lostyou;
                    if (this.lostyou >= 4) {
                        this.shutdown();
                    }
                }
            }
            else if (!this.h(super.target) || this.i(super.target) >= 16.0f) {
                ++this.lostyou;
                if (this.lostyou >= 4) {
                    this.shutdown();
                }
            }
            else {
                this.lostyou = 0;
            }
            this.counter = 0;
        }
        else {
            ++this.counter;
        }
        if (!this.active) {
            return;
        }
        if (super.target != null) {
            this.a(super.target, 10.0f, 10.0f);
        }
        if (((Entity)this).onGround && this.jcount-- <= 0) {
            this.jcount = ((Entity)this).random.nextInt(20) + 10;
            ((EntityLiving)this).aZ = true;
            ((EntityLiving)this).aW = 0.5f - ((Entity)this).random.nextFloat();
            ((EntityLiving)this).aX = 1.0f;
            ((Entity)this).world.makeSound((Entity)this, "mob.slime", this.getSoundVolume(), ((((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f) * 0.8f);
            if (super.target != null) {
                this.jcount /= 2;
                ((EntityLiving)this).aX = 1.0f;
            }
        }
        else {
            ((EntityLiving)this).aZ = false;
            if (((Entity)this).onGround) {
                final float n = 0.0f;
                ((EntityLiving)this).aX = n;
                ((EntityLiving)this).aW = n;
            }
        }
    }
    
    protected String getHurtSound() {
        return "mob.slime";
    }
    
    protected String getDeathSound() {
        return "mob.slime";
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere();
    }
    
    protected float getSoundVolume() {
        return 0.6f;
    }
    
    protected int getDropItemId() {
        if (((Entity)this).random.nextInt(5) == 0) {
            return AetherBlocks.LightDungeonStone.id;
        }
        return AetherBlocks.DungeonStone.id;
    }
}
