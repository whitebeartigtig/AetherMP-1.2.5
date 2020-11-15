package net.minecraft.server;

import java.util.*;

public class EntityLightningKnife extends Entity
{
    private int xTileSnowball;
    private int yTileSnowball;
    private int zTileSnowball;
    private int inTileSnowball;
    private boolean inGroundSnowball;
    public int shakeSnowball;
    private EntityLiving thrower;
    private int ticksInGroundSnowball;
    private int ticksInAirSnowball;
    
    public EntityLightningKnife(final World world) {
        super(world);
        this.xTileSnowball = -1;
        this.yTileSnowball = -1;
        this.zTileSnowball = -1;
        this.inTileSnowball = 0;
        this.inGroundSnowball = false;
        this.shakeSnowball = 0;
        this.ticksInAirSnowball = 0;
        this.b(0.25f, 0.25f);
    }
    
    protected void entityInit() {
    }
    
    public boolean isInRangeToRenderDist(final double d) {
        double d2 = super.boundingBox.getAverageEdgeLength() * 4.0;
        d2 *= 64.0;
        return d < d2 * d2;
    }
    
    public EntityLightningKnife(final World world, final EntityLiving entityliving) {
        super(world);
        this.xTileSnowball = -1;
        this.yTileSnowball = -1;
        this.zTileSnowball = -1;
        this.inTileSnowball = 0;
        this.inGroundSnowball = false;
        this.shakeSnowball = 0;
        this.ticksInAirSnowball = 0;
        this.thrower = entityliving;
        this.b(0.25f, 0.25f);
        this.setPositionRotation(((Entity)entityliving).locX, ((Entity)entityliving).locY + entityliving.getHeadHeight(), ((Entity)entityliving).locZ, ((Entity)entityliving).yaw, ((Entity)entityliving).pitch);
        super.locX -= MathHelper.cos(super.yaw / 180.0f * 3.141593f) * 0.16f;
        super.locY -= 0.10000000149011612;
        super.locZ -= MathHelper.sin(super.yaw / 180.0f * 3.141593f) * 0.16f;
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
        super.height = 0.0f;
        final float f = 0.4f;
        super.motX = -MathHelper.sin(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f) * f;
        super.motZ = MathHelper.cos(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f) * f;
        super.motY = -MathHelper.sin(super.pitch / 180.0f * 3.141593f) * f;
        this.setSnowballHeading(super.motX, super.motY, super.motZ, 1.5f, 1.0f);
    }
    
    public EntityLightningKnife(final World world, final double d, final double d1, final double d2) {
        super(world);
        this.xTileSnowball = -1;
        this.yTileSnowball = -1;
        this.zTileSnowball = -1;
        this.inTileSnowball = 0;
        this.inGroundSnowball = false;
        this.shakeSnowball = 0;
        this.ticksInAirSnowball = 0;
        this.ticksInGroundSnowball = 0;
        this.b(0.25f, 0.25f);
        this.setLocation(d, d1, d2, super.yaw, super.pitch);
        super.height = 0.0f;
    }
    
    public void setSnowballHeading(double d, double d1, double d2, final float f, final float f1) {
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
        this.ticksInGroundSnowball = 0;
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
        super.bL = super.locX;
        super.bM = super.locY;
        super.bN = super.locZ;
        super.F_();
        if (this.shakeSnowball > 0) {
            --this.shakeSnowball;
        }
        if (this.inGroundSnowball) {
            final int i = super.world.getTypeId(this.xTileSnowball, this.yTileSnowball, this.zTileSnowball);
            if (i == this.inTileSnowball) {
                ++this.ticksInGroundSnowball;
                if (this.ticksInGroundSnowball == 1200) {
                    this.die();
                }
                return;
            }
            this.inGroundSnowball = false;
            super.motX *= super.random.nextFloat() * 0.2f;
            super.motY *= super.random.nextFloat() * 0.2f;
            super.motZ *= super.random.nextFloat() * 0.2f;
            this.ticksInGroundSnowball = 0;
            this.ticksInAirSnowball = 0;
        }
        else {
            ++this.ticksInAirSnowball;
        }
        Vec3D vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
        Vec3D vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
        MovingObjectPosition movingobjectposition = super.world.a(vec3d, vec3d2);
        vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
        vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
        if (movingobjectposition != null) {
            vec3d2 = Vec3D.create(movingobjectposition.pos.a, movingobjectposition.pos.b, movingobjectposition.pos.c);
        }
        if (!super.world.isStatic) {
            Entity entity = null;
            final List list = super.world.getEntities((Entity)this, super.boundingBox.a(super.motX, super.motY, super.motZ).grow(1.0, 1.0, 1.0));
            double d = 0.0;
            for (int l = 0; l < list.size(); ++l) {
                final Entity entity2 = (Entity) list.get(l);
                if (entity2.o_()) {
                    if (entity2 != this.thrower || this.ticksInAirSnowball >= 5) {
                        final float f4 = 0.3f;
                        final AxisAlignedBB axisalignedbb = entity2.boundingBox.grow((double)f4, (double)f4, (double)f4);
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
        }
        if (movingobjectposition != null) {
            if (movingobjectposition.entity != null) {
                if (!movingobjectposition.entity.damageEntity(DamageSource.mobAttack(this.thrower), 0)) {}
                final int x = MathHelper.floor(movingobjectposition.entity.boundingBox.a);
                final int y = MathHelper.floor(movingobjectposition.entity.boundingBox.b);
                final int z = MathHelper.floor(movingobjectposition.entity.boundingBox.c);
                final EntityWeatherLighting EntityWeatherLighting = new EntityWeatherLighting(super.world, (double)x, (double)y, (double)z);
                EntityWeatherLighting.setPositionRotation((double)x, (double)y, (double)z, super.yaw, 0.0f);
                super.world.addEntity((Entity)EntityWeatherLighting);
            }
            else {
                final int j = MathHelper.floor(super.locX);
                final int k = MathHelper.floor(super.locY);
                final int m = MathHelper.floor(super.locZ);
                final EntityWeatherLighting entitylightningbolt = new EntityWeatherLighting(super.world, super.locX, super.locY, super.locZ);
                entitylightningbolt.setPositionRotation((double)j, (double)k, (double)m, super.yaw, 0.0f);
                super.world.addEntity((Entity)entitylightningbolt);
            }
            for (int j2 = 0; j2 < 8; ++j2) {
                super.world.a("largesmoke", super.locX, super.locY, super.locZ, 0.0, 0.0, 0.0);
            }
            this.die();
        }
        super.locX += super.motX;
        super.locY += super.motY;
        super.locZ += super.motZ;
        final float f5 = MathHelper.sqrt(super.motX * super.motX + super.motZ * super.motZ);
        super.yaw = (float)(Math.atan2(super.motX, super.motZ) * 180.0 / 3.1415927410125732);
        super.pitch = (float)(Math.atan2(super.motY, f5) * 180.0 / 3.1415927410125732);
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
        float f6 = 0.99f;
        final float f7 = 0.03f;
        if (this.aU()) {
            for (int k2 = 0; k2 < 4; ++k2) {
                final float f8 = 0.25f;
                super.world.a("bubble", super.locX - super.motX * f8, super.locY - super.motY * f8, super.locZ - super.motZ * f8, super.motX, super.motY, super.motZ);
            }
            f6 = 0.8f;
        }
        super.motX *= f6;
        super.motY *= f6;
        super.motZ *= f6;
        super.motY -= f7;
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.xTileSnowball);
        nbttagcompound.setShort("yTile", (short)this.yTileSnowball);
        nbttagcompound.setShort("zTile", (short)this.zTileSnowball);
        nbttagcompound.setByte("inTile", (byte)this.inTileSnowball);
        nbttagcompound.setByte("shake", (byte)this.shakeSnowball);
        nbttagcompound.setByte("inGround", (byte)(byte)(this.inGroundSnowball ? 1 : 0));
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.xTileSnowball = nbttagcompound.getShort("xTile");
        this.yTileSnowball = nbttagcompound.getShort("yTile");
        this.zTileSnowball = nbttagcompound.getShort("zTile");
        this.inTileSnowball = (nbttagcompound.getByte("inTile") & 0xFF);
        this.shakeSnowball = (nbttagcompound.getByte("shake") & 0xFF);
        this.inGroundSnowball = (nbttagcompound.getByte("inGround") == 1);
    }
    
    public void onCollideWithPlayer(final EntityPlayer entityplayer) {
        if (this.inGroundSnowball && this.thrower == entityplayer && this.shakeSnowball <= 0 && entityplayer.inventory.pickup(new ItemStack(Item.ARROW, 1))) {
            super.world.makeSound((Entity)this, "random.pop", 0.2f, ((super.random.nextFloat() - super.random.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            entityplayer.receive((Entity)this, 1);
            this.die();
        }
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
