package net.minecraft.server;

import java.util.*;

public class EntityFlamingArrow extends Entity
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int inData;
    private boolean inGround;
    public boolean doesArrowBelongToPlayer;
    public int arrowShake;
    public EntityLiving owner;
    private int ticksInGround;
    private int ticksInAir;
    
    public EntityFlamingArrow(final World world) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.b(0.5f, 0.5f);
        this.setOnFire(1);
    }
    
    public EntityFlamingArrow(final World world, final double d, final double d1, final double d2) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.b(0.5f, 0.5f);
        this.setLocation(d, d1, d2, super.yaw, super.pitch);
        super.height = 0.0f;
    }
    
    public EntityFlamingArrow(final World world, final EntityLiving entityliving) {
        super(world);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = 0;
        this.inData = 0;
        this.inGround = false;
        this.doesArrowBelongToPlayer = false;
        this.arrowShake = 0;
        this.ticksInAir = 0;
        this.owner = entityliving;
        this.doesArrowBelongToPlayer = (entityliving instanceof EntityPlayer);
        this.b(0.5f, 0.5f);
        this.setPositionRotation(((Entity)entityliving).locX, ((Entity)entityliving).locY + entityliving.getHeadHeight(), ((Entity)entityliving).locZ, ((Entity)entityliving).yaw, ((Entity)entityliving).pitch);
        super.locX -= MathHelper.cos(super.yaw / 180.0f * 3.141593f) * 0.16f;
        super.locY -= 0.10000000149011612;
        super.locZ -= MathHelper.sin(super.yaw / 180.0f * 3.141593f) * 0.16f;
        this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
        super.height = 0.0f;
        super.motX = -MathHelper.sin(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f);
        super.motZ = MathHelper.cos(super.yaw / 180.0f * 3.141593f) * MathHelper.cos(super.pitch / 180.0f * 3.141593f);
        super.motY = -MathHelper.sin(super.pitch / 180.0f * 3.141593f);
        this.setArrowHeading(super.motX, super.motY, super.motZ, 1.5f, 1.0f);
    }
    
    protected void entityInit() {
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
            super.lastPitch = super.pitch;
            super.lastYaw = super.yaw;
            this.setPositionRotation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
            this.ticksInGround = 0;
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
        final int i = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
        if (i > 0) {
            Block.byId[i].updateShape((IBlockAccess)super.world, this.xTile, this.yTile, this.zTile);
            final AxisAlignedBB axisalignedbb = Block.byId[i].e(super.world, this.xTile, this.yTile, this.zTile);
            if (axisalignedbb != null && axisalignedbb.a(Vec3D.create(super.locX, super.locY, super.locZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (!this.inGround) {
            super.world.a(super.random.nextBoolean() ? "flame" : "smoke", super.locX, super.locY, super.locZ, 0.0, 0.0, 0.0);
            ++this.ticksInAir;
            Vec3D vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
            Vec3D vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
            MovingObjectPosition movingobjectposition = super.world.rayTrace(vec3d, vec3d2, false, true);
            vec3d = Vec3D.create(super.locX, super.locY, super.locZ);
            vec3d2 = Vec3D.create(super.locX + super.motX, super.locY + super.motY, super.locZ + super.motZ);
            if (movingobjectposition != null) {
                vec3d2 = Vec3D.create(movingobjectposition.pos.a, movingobjectposition.pos.b, movingobjectposition.pos.c);
            }
            Entity entity = null;
            final List list = super.world.getEntities((Entity)this, super.boundingBox.a(super.motX, super.motY, super.motZ).grow(1.0, 1.0, 1.0));
            double d = 0.0;
            for (int l = 0; l < list.size(); ++l) {
                final Entity entity2 = (Entity) list.get(l);
                if (entity2.o_()) {
                    if (entity2 != this.owner || this.ticksInAir >= 5) {
                        final float f2 = 0.3f;
                        final AxisAlignedBB axisalignedbb2 = entity2.boundingBox.grow((double)f2, (double)f2, (double)f2);
                        final MovingObjectPosition movingobjectposition2 = axisalignedbb2.a(vec3d, vec3d2);
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
            if (movingobjectposition != null) {
                if (movingobjectposition.entity != null) {
                    if (movingobjectposition.entity.damageEntity(DamageSource.mobAttack(this.owner), 4)) {
                        super.world.makeSound((Entity)this, "random.drr", 1.0f, 1.2f / (super.random.nextFloat() * 0.2f + 0.9f));
                        movingobjectposition.entity.setOnFire(100);
                        final int x = MathHelper.floor(movingobjectposition.entity.boundingBox.a);
                        final int y = MathHelper.floor(movingobjectposition.entity.boundingBox.b);
                        final int z = MathHelper.floor(movingobjectposition.entity.boundingBox.c);
                        super.world.setTypeId(x, y, z, 51);
                        this.die();
                    }
                    else {
                        super.motX *= -0.10000000149011612;
                        super.motY *= -0.10000000149011612;
                        super.motZ *= -0.10000000149011612;
                        super.yaw += 180.0f;
                        super.lastYaw += 180.0f;
                        this.ticksInAir = 0;
                    }
                }
                else {
                    this.xTile = movingobjectposition.b;
                    this.yTile = movingobjectposition.c;
                    this.zTile = movingobjectposition.d;
                    this.inTile = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
                    this.inData = super.world.getData(this.xTile, this.yTile, this.zTile);
                    super.motX = (float)(movingobjectposition.pos.a - super.locX);
                    super.motY = (float)(movingobjectposition.pos.b - super.locY);
                    super.motZ = (float)(movingobjectposition.pos.c - super.locZ);
                    final float f3 = MathHelper.sqrt(super.motX * super.motX + super.motY * super.motY + super.motZ * super.motZ);
                    super.locX -= super.motX / f3 * 0.05000000074505806;
                    super.locY -= super.motY / f3 * 0.05000000074505806;
                    super.locZ -= super.motZ / f3 * 0.05000000074505806;
                    super.world.makeSound((Entity)this, "random.drr", 1.0f, 1.2f / (super.random.nextFloat() * 0.2f + 0.9f));
                    final int xPos = MathHelper.floor(super.locX);
                    final int yPos = MathHelper.floor(super.locY);
                    final int zPos = MathHelper.floor(super.locZ);
                    super.world.setTypeId(xPos, yPos, zPos, 51);
                    this.inGround = true;
                    this.arrowShake = 7;
                }
            }
            super.locX += super.motX;
            super.locY += super.motY;
            super.locZ += super.motZ;
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
            float f5 = 0.99f;
            final float f6 = 0.03f;
            if (this.aU()) {
                for (int i2 = 0; i2 < 4; ++i2) {
                    final float f7 = 0.25f;
                    super.world.a("bubble", super.locX - super.motX * f7, super.locY - super.motY * f7, super.locZ - super.motZ * f7, super.motX, super.motY, super.motZ);
                }
                f5 = 0.8f;
            }
            super.motX *= f5;
            super.motY *= f5;
            super.motZ *= f5;
            super.motY -= f6;
            this.setLocation(super.locX, super.locY, super.locZ, super.yaw, super.pitch);
            return;
        }
        final int j = super.world.getTypeId(this.xTile, this.yTile, this.zTile);
        final int k = super.world.getData(this.xTile, this.yTile, this.zTile);
        if (j != this.inTile || k != this.inData) {
            this.inGround = false;
            super.motX *= super.random.nextFloat() * 0.2f;
            super.motY *= super.random.nextFloat() * 0.2f;
            super.motZ *= super.random.nextFloat() * 0.2f;
            this.ticksInGround = 0;
            this.ticksInAir = 0;
            return;
        }
        ++this.ticksInGround;
        if (this.ticksInGround == 1200) {
            this.die();
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setShort("xTile", (short)this.xTile);
        nbttagcompound.setShort("yTile", (short)this.yTile);
        nbttagcompound.setShort("zTile", (short)this.zTile);
        nbttagcompound.setByte("inTile", (byte)this.inTile);
        nbttagcompound.setByte("inData", (byte)this.inData);
        nbttagcompound.setByte("shake", (byte)this.arrowShake);
        nbttagcompound.setByte("inGround", (byte)(byte)(this.inGround ? 1 : 0));
        nbttagcompound.setBoolean("player", this.doesArrowBelongToPlayer);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.xTile = nbttagcompound.getShort("xTile");
        this.yTile = nbttagcompound.getShort("yTile");
        this.zTile = nbttagcompound.getShort("zTile");
        this.inTile = (nbttagcompound.getByte("inTile") & 0xFF);
        this.inData = (nbttagcompound.getByte("inData") & 0xFF);
        this.arrowShake = (nbttagcompound.getByte("shake") & 0xFF);
        this.inGround = (nbttagcompound.getByte("inGround") == 1);
        this.doesArrowBelongToPlayer = nbttagcompound.getBoolean("player");
    }
    
    public void onCollideWithPlayer(final EntityPlayer entityplayer) {
        if (super.world.isStatic) {
            return;
        }
        if (this.inGround && this.doesArrowBelongToPlayer && this.arrowShake <= 0 && entityplayer.inventory.pickup(new ItemStack(Item.ARROW, 1))) {
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
