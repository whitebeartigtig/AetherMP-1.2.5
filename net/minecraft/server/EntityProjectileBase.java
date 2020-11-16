package net.minecraft.server;

import java.util.*;

public abstract class EntityProjectileBase extends Entity
{
    public float speed;
    public float slowdown;
    public float curvature;
    public float precision;
    public float hitBox;
    public int dmg;
    public ItemStack item;
    public int ttlInGround;
    public int xTile;
    public int yTile;
    public int zTile;
    public int inTile;
    public int inData;
    public boolean inGround;
    public int arrowShake;
    public EntityLiving shooter;
    public int ticksInGround;
    public int ticksFlying;
    public boolean shotByPlayer;
    
    public EntityProjectileBase(final World world) {
        super(world);
    }
    
    public EntityProjectileBase(final World world, final double d, final double d1, final double d2) {
        this(world);
        this.setLocation(d, d1, d2, super.yaw, super.pitch);
    }
    
    public EntityProjectileBase(final World world, final EntityLiving entityliving) {
        this(world);
        this.shooter = entityliving;
        this.shotByPlayer = (entityliving instanceof EntityPlayer);
        this.setPositionRotation(((Entity)entityliving).locX, ((Entity)entityliving).locY + entityliving.getHeadHeight(), ((Entity)entityliving).locZ, ((Entity)entityliving).yaw, ((Entity)entityliving).pitch);
        super.locX -= MathHelper.cos(super.yaw / 180.0f * 3.141593f) * 0.16f;
        super.locY -= 0.10000000149011612;
        super.locZ -= MathHelper.sin(super.yaw / 180.0f * 3.141593f) * 0.16f;
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
        super.motX = -MathHelper.sin(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f);
        super.motZ = MathHelper.cos(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f);
        super.motY = -MathHelper.sin(super.pitch / 180.0f * 3.141593f);
        this.setArrowHeading(super.motX, super.motY, super.motZ, this.speed, this.precision);
    }
    
    protected void entityInit() {
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.arrowShake = 0;
        this.ticksFlying = 0;
        this.b(0.5f, 0.5f);
        super.height = 0.0f;
        this.hitBox = 0.3f;
        this.speed = 1.0f;
        this.slowdown = 0.99f;
        this.curvature = 0.03f;
        this.dmg = 4;
        this.precision = 1.0f;
        this.ttlInGround = 1200;
        this.item = null;
    }
    
    public void setDead() {
        this.shooter = null;
        super.die();
    }
    
    public void setArrowHeading(double d, double d1, double d2, final float f, final float f1) {
        final float f2 = MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
        d /= f2;
        d1 /= f2;
        d2 /= f2;
        d += super.random.nextGaussian() * 0.007499999832361937 * f1;
        d1 += super.random.nextGaussian() * 0.007499999832361937 * f1;
        d2 += super.random.nextGaussian() * 0.007499999832361937 * f1;
        d *= f;
        d1 *= f;
        d2 *= f;
        super.motX = d;
        super.motY = d1;
        super.motZ = d2;
        final float f3 = MathHelper.sqrt(d * d + d2 * d2);
        final float n = (float)(Math.atan2(d, d2) * 180.0 / 3.1415927410125732);
        super.yaw = n;
        super.lastYaw = n;
        final float n2 = (float)(Math.atan2(d1, f3) * 180.0 / 3.1415927410125732);
        super.pitch = n2;
        super.lastPitch = n2;
        this.ticksInGround = 0;
    }
    
    public void setVelocity(final double d, final double d1, final double d2) {
        super.motX = d;
        super.motY = d1;
        super.motZ = d2;
        if (super.lastPitch == 0.0f && super.lastYaw == 0.0f) {
            final float f = MathHelper.sqrt(d * d + d2 * d2);
            final float n = (float)(Math.atan2(d, d2) * 180.0 / 3.1415927410125732);
            super.yaw = n;
            super.lastYaw = n;
            final float n2 = (float)(Math.atan2(d1, f) * 180.0 / 3.1415927410125732);
            super.pitch = n2;
            super.lastPitch = n2;
        }
    }
    
    public void onUpdate() {
        super.F_();
        if (super.lastPitch == 0.0f && super.lastYaw == 0.0f) {
            final float f = MathHelper.sqrt(super.motX * super.motX + super.motZ * super.motZ);
            final float n = (float)(Math.atan2(super.motX, super.motZ) * 180.0 / 3.1415927410125732);
            super.yaw = n;
            super.lastYaw = n;
            final float n2 = (float)(Math.atan2(super.motY, f) * 180.0 / 3.1415927410125732);
            super.pitch = n2;
            super.lastPitch = n2;
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            final int i = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
            final int k = super.world.getData(this.xTile, this.yTile, this.zTile);
            if (i == this.inTile && k == this.inData) {
                ++this.ticksInGround;
                this.tickInGround();
                if (this.ticksInGround == this.ttlInGround) {
                    this.setDead();
                }
                return;
            }
            this.inGround = false;
            super.motX *= super.random.nextFloat() * 0.2f;
            super.motY *= super.random.nextFloat() * 0.2f;
            super.motZ *= super.random.nextFloat() * 0.2f;
            this.ticksInGround = 0;
            this.ticksFlying = 0;
        }
        else {
            ++this.ticksFlying;
        }
        this.tickFlying();
        Vec3D vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
        Vec3D vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
        MovingObjectPosition movingobjectposition = super.world.a(vec3d, vec3d2);
        vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
        vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
        if (movingobjectposition != null) {
            vec3d2 = Vec3D.create(movingobjectposition.pos.a, movingobjectposition.pos.b, movingobjectposition.pos.c);
        }
        Entity entity = null;
        final List list = super.world.getEntities((Entity)this, super.boundingBox.a(super.motX, super.motY, super.motZ).grow(1.0, 1.0, 1.0));
        double d = 0.0;
        for (int j = 0; j < list.size(); ++j) {
            final Entity entity2 = (Entity) list.get(j);
            if (this.canBeShot(entity2)) {
                final float f2 = this.hitBox;
                final AxisAlignedBB axisalignedbb = entity2.boundingBox.grow((double)f2, (double)f2, (double)f2);
                final MovingObjectPosition movingobjectposition2 = axisalignedbb.a(vec3d, vec3d2);
                if (movingobjectposition2 != null) {
                    final double d2 = vec3d.b(movingobjectposition2.pos);
                    if (d2 < d || d == 0.0) {
                        entity = entity2;
                        d = d2;
                    }
                }
            }
        }
        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        if (movingobjectposition != null && this.onHit()) {
            final Entity ent = movingobjectposition.entity;
            if (ent != null) {
                if (this.onHitTarget(ent)) {
                    if (ent instanceof EntityLiving && !(ent instanceof EntityPlayer)) {
                        ((EntityLiving)ent).lastDamage = 0;
                    }
                    ent.damageEntity(DamageSource.projectile((Entity)this, (Entity)this.shooter), this.dmg);
                    this.setDead();
                }
            }
            else {
                this.xTile = movingobjectposition.b;
                this.yTile = movingobjectposition.c;
                this.zTile = movingobjectposition.d;
                this.inTile = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
                this.inData = super.world.getData(this.xTile, this.yTile, this.zTile);
                if (this.onHitBlock(movingobjectposition)) {
                    super.motX = (float)(movingobjectposition.pos.a - super.locX);
                    super.motY = (float)(movingobjectposition.pos.b - super.locY);
                    super.motZ = (float)(movingobjectposition.pos.c - super.locZ);
                    final float f3 = MathHelper.sqrt(super.motX * super.motX + super.motY * super.motY + super.motZ * super.motZ);
                    super.locX -= super.motX / f3 * 0.05000000074505806;
                    super.locY -= super.motY / f3 * 0.05000000074505806;
                    super.locZ -= super.motZ / f3 * 0.05000000074505806;
                    this.inGround = true;
                    this.arrowShake = 7;
                }
                else {
                    this.inTile = 0;
                    this.inData = 0;
                }
            }
        }
        super.locX += super.motX;
        super.locY += super.motY;
        super.locZ += super.motZ;
        this.handleMotionUpdate();
        final float f4 = MathHelper.sqrt(super.motX * super.motX + super.motZ * super.motZ);
        super.yaw = (float)(Math.atan2(super.motX, super.motZ) * 180.0 / 3.1415927410125732);
        super.pitch = (float)(Math.atan2(super.motY, f4) * 180.0 / 3.1415927410125732);
        while (super.pitch - super.lastPitch < -180.0f) {
            super.lastPitch -= 360.0f;
        }
        while (super.pitch - super.lastPitch >= 180.0f) {
            super.lastPitch += 360.0f;
        }
        while (super.yaw - super.lastYaw < -180.0f) {
            super.lastYaw -= 360.0f;
        }
        while (super.yaw - super.lastYaw >= 180.0f) {
            super.lastYaw += 360.0f;
        }
        super.pitch = super.lastPitch + (super.pitch - super.lastPitch) * 0.2f;
        super.yaw = super.lastYaw + (super.yaw - super.lastYaw) * 0.2f;
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
    }
    
    public void handleMotionUpdate() {
        float slow = this.slowdown;
        if (this.h_()) {
            for (int k = 0; k < 4; ++k) {
                final float f6 = 0.25f;
                super.world.a("bubble", super.locX - super.motX * f6, super.locY - super.motY * f6, super.locZ - super.motZ * f6, super.motX, super.motY, super.motZ);
            }
            slow *= 0.8f;
        }
        super.motX *= slow;
        super.motY *= slow;
        super.motZ *= slow;
        super.motY -= this.curvature;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.xTile);
        nbttagcompound.setShort("yTile", (short)this.yTile);
        nbttagcompound.setShort("zTile", (short)this.zTile);
        nbttagcompound.setByte("inTile", (byte)this.inTile);
        nbttagcompound.setByte("inData", (byte)this.inData);
        nbttagcompound.setByte("shake", (byte)this.arrowShake);
        nbttagcompound.setByte("inGround", (byte)(byte)(this.inGround ? 1 : 0));
        nbttagcompound.setBoolean("player", this.shotByPlayer);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = (nbttagcompound.getByte("inTile") & 0xFF);
        this.inData = (nbttagcompound.getByte("inData") & 0xFF);
        this.arrowShake = (nbttagcompound.getByte("shake") & 0xFF);
        this.inGround = (nbttagcompound.getByte("inGround") == 1);
        this.shotByPlayer = nbttagcompound.getBoolean("player");
    }
    
    public void onCollideWithPlayer(final EntityPlayer entityplayer) {
        if (this.item == null) {
            return;
        }
        if (super.world.isStatic) {
            return;
        }
        if (this.inGround && this.shotByPlayer && this.arrowShake <= 0 && entityplayer.inventory.pickup(this.item.cloneItemStack())) {
            super.world.makeSound((Entity)this, "random.pop", 0.2f, ((super.random.nextFloat() - super.random.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityplayer.receive((Entity)this, 1);
            this.setDead();
        }
    }
    
    public boolean canBeShot(final Entity ent) {
        return ent.o_() && (ent != this.shooter || this.ticksFlying >= 5) && (!(ent instanceof EntityLiving) || ((EntityLiving)ent).deathTicks <= 0);
    }
    
    public boolean onHit() {
        return true;
    }
    
    public boolean onHitTarget(final Entity target) {
        super.world.makeSound((Entity)this, "random.drr", 1.0f, 1.2f / (super.random.nextFloat() * 0.2f + 0.9f));
        return true;
    }
    
    public void tickFlying() {
    }
    
    public void tickInGround() {
    }
    
    public boolean onHitBlock(final MovingObjectPosition mop) {
        return this.onHitBlock();
    }
    
    public boolean onHitBlock() {
        super.world.makeSound((Entity)this, "random.drr", 1.0f, 1.2f / (super.random.nextFloat() * 0.2f + 0.9f));
        return true;
    }
    
    public float getShadowSize() {
        return 0.0f;
    }

	public void shoot(double motionX, double motionY, double motionZ, float f1, float f2) {
		// TODO Auto-generated method stub
		
	}
}
