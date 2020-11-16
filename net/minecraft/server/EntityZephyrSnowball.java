package net.minecraft.server;

import java.util.*;

public class EntityZephyrSnowball extends Entity
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    protected boolean inGround;
    public int field_9406_a;
    protected EntityLiving shootingEntity;
    private int ticksAlive;
    private int ticksInAir;
    public double accelerationX;
    public double accelerationY;
    public double accelerationZ;
    
    public EntityZephyrSnowball(final World world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.field_9406_a = 0;
        this.ticksInAir = 0;
        this.b(1.0f, 1.0f);
    }
    
    protected void entityInit() {
    }
    
    public EntityZephyrSnowball(final World world, final EntityLiving entityliving, double d, double d1, double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inGround = false;
        this.field_9406_a = 0;
        this.ticksInAir = 0;
        this.shootingEntity = entityliving;
        this.b(1.0f, 1.0f);
        this.setPositionRotation(((Entity)entityliving).locX, ((Entity)entityliving).locY, ((Entity)entityliving).locZ, ((Entity)entityliving).yaw, ((Entity)entityliving).pitch);
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
        super.height = 0.0f;
        final double motionX = 0.0;
        super.motZ = motionX;
        super.motY = motionX;
        super.motX = motionX;
        d += super.random.nextGaussian() * 0.4;
        d1 += super.random.nextGaussian() * 0.4;
        d2 += super.random.nextGaussian() * 0.4;
        final double d3 = MathHelper.sqrt(d * d + d1 * d1 + d2 * d2);
        this.accelerationX = d / d3 * 0.1;
        this.accelerationY = d1 / d3 * 0.1;
        this.accelerationZ = d2 / d3 * 0.1;
    }
    
    public void onUpdate() {
        super.F_();
        if (this.field_9406_a > 0) {
            --this.field_9406_a;
        }
        if (this.inGround) {
            final int i = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
            if (i == this.inTile) {
                ++this.ticksAlive;
                if (this.ticksAlive == 1200) {
                    this.die();
                }
                return;
            }
            this.inGround = false;
            super.motX *= super.random.nextFloat() * 0.2f;
            super.motY *= super.random.nextFloat() * 0.2f;
            super.motZ *= super.random.nextFloat() * 0.2f;
            this.ticksAlive = 0;
            this.ticksInAir = 0;
        }
        else {
            ++this.ticksInAir;
        }
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
            if (entity2.o_()) {
                if (entity2 != this.shootingEntity || this.ticksInAir >= 25) {
                    final float f2 = 0.3f;
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
        }
        if (entity != null) {
            movingobjectposition = new MovingObjectPosition(entity);
        }
        /*
        if (movingobjectposition != null) {
            final EntityPlayer player = (EntityPlayer)ModLoader.getMinecraftInstance().thePlayer;
            if (movingobjectposition.entity != null) {
                if (!movingobjectposition.entity.damageEntity(DamageSource.mobAttack(this.shootingEntity), 0)) {}
                if (movingobjectposition.entity instanceof EntityHuman && player.inventory.armor[0] != null && player.inventory.armor[0].id == AetherItems.SentryBoots.id) {
                    this.die();
                }
                else {
                    final Entity entity1 = movingobjectposition.entity;
                    entity1.motX += super.motX;
                    final Entity entityHit2 = movingobjectposition.entity;
                    entityHit2.motY += 0.2;
                    final Entity entityHit3 = movingobjectposition.entity;
                    entityHit3.motZ += super.motZ;
                }
            }
            this.die();
        }
        */
        super.locX += super.motX;
        super.locY += super.motY;
        super.locZ += super.motZ;
        final float f3 = MathHelper.sqrt(super.motX * super.motX + super.motZ * super.motZ);
        super.yaw = (float)(Math.atan2(super.motX, super.motZ) * 180.0 / 3.1415927410125732);
        super.pitch = (float)(Math.atan2(super.motY, f3) * 180.0 / 3.1415927410125732);
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
        float f4 = 0.95f;
        if (this.h_()) {
            for (int k = 0; k < 4; ++k) {
                final float f5 = 0.25f;
                super.world.a("bubble", super.locX - super.motX * f5, super.locY - super.motY * f5, super.locZ - super.motZ * f5, super.motX, super.motY, super.motZ);
            }
            f4 = 0.8f;
        }
        super.motX += this.accelerationX;
        super.motY += this.accelerationY;
        super.motZ += this.accelerationZ;
        super.motX *= f4;
        super.motY *= f4;
        super.motZ *= f4;
        super.world.a("smoke", super.locX, super.locY + 0.5, super.locZ, 0.0, 0.0, 0.0);
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.xTile);
        nbttagcompound.setShort("yTile", (short)this.yTile);
        nbttagcompound.setShort("zTile", (short)this.zTile);
        nbttagcompound.setByte("inTile", (byte)this.inTile);
        nbttagcompound.setByte("shake", (byte)this.field_9406_a);
        nbttagcompound.setByte("inGround", (byte)(byte)(this.inGround ? 1 : 0));
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = (nbttagcompound.getByte("inTile") & 0xFF);
        this.field_9406_a = (nbttagcompound.getByte("shake") & 0xFF);
        this.inGround = (nbttagcompound.getByte("inGround") == 1);
    }
    
    public float getCollisionBorderSize() {
        return 1.0f;
    }
    
    public boolean attackEntityFrom(final Entity entity, final int i) {
        this.aW();
        if (entity != null) {
            final Vec3D vec3d = entity.aJ();
            if (vec3d != null) {
                super.motX = vec3d.a;
                super.motY = vec3d.b;
                super.motZ = vec3d.c;
                this.accelerationX = super.motX * 0.1;
                this.accelerationY = super.motY * 0.1;
                this.accelerationZ = super.motZ * 0.1;
            }
            return true;
        }
        return false;
    }
    
    public float getShadowSize() {
        return 0.0f;
    }

	@Override
	protected void a(NBTTagCompound arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void b(NBTTagCompound arg0) {
		// TODO Auto-generated method stub
		
	}
}
