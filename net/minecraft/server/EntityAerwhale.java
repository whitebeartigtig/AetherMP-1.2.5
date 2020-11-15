package net.minecraft.server;

public class EntityAerwhale extends EntityFlying implements IMob
{
    private long checkTime;
    private final long checkTimeInterval = 3000L;
    private double checkX;
    private double checkY;
    private double checkZ;
    private final double minTraversalDist = 3.0;
    private boolean isStuckWarning;
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;
    public double motionYaw;
    public double motionPitch;
    
    public EntityAerwhale(final World world) {
        super(world);
        this.checkTime = 0L;
        this.checkX = 0.0;
        this.checkY = 0.0;
        this.checkZ = 0.0;
        this.isStuckWarning = false;
        this.courseChangeCooldown = 0;
        this.targetedEntity = null;
        ((Entity)this).isImmuneToFire = true;
        this.aggroCooldown = 0;
        this.prevAttackCounter = 0;
        this.attackCounter = 0;
        ((EntityLiving)this).texture = "/aether/mobs/Mob_Aerwhale.png";
        this.setSize(4.0f, 4.0f);
        ((EntityLiving)this).moveSpeed = 0.5f;
        ((EntityLiving)this).health = 20;
        ((Entity)this).rotationYaw = 360.0f * ((Entity)this).rand.nextFloat();
        ((Entity)this).rotationPitch = 90.0f * ((Entity)this).rand.nextFloat() - 45.0f;
        ((Entity)this).ignoreFrustumCheck = true;
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    protected void entityInit() {
        super.entityInit();
        ((Entity)this).dataWatcher.addObject(16, (Object)0);
    }
    
    public void onLivingUpdate() {
    }
    
    public void onUpdate() {
        final byte byte0 = ((Entity)this).dataWatcher.getWatchableObjectByte(16);
        ((EntityLiving)this).texture = ((byte0 != 1) ? "/aether/mobs/Mob_Aerwhale.png" : "/aether/mobs/Mob_Aerwhale.png");
        final double[] distances = { this.openSpace(0.0f, 0.0f), this.openSpace(45.0f, 0.0f), this.openSpace(0.0f, 45.0f), this.openSpace(-45.0f, 0.0f), this.openSpace(0.0f, -45.0f) };
        int longest = 0;
        for (int i = 1; i < 5; ++i) {
            if (distances[i] > distances[longest]) {
                longest = i;
            }
        }
        switch (longest) {
            case 0: {
                if (distances[0] != 50.0) {
                    ((Entity)this).rotationPitch = -((Entity)this).rotationPitch;
                    ((Entity)this).rotationYaw = -((Entity)this).rotationYaw;
                    break;
                }
                this.motionYaw *= 0.8999999761581421;
                this.motionPitch *= 0.8999999761581421;
                if (((Entity)this).posY > 100.0) {
                    this.motionPitch -= 2.0;
                }
                if (((Entity)this).posY < 20.0) {
                    this.motionPitch += 2.0;
                    break;
                }
                break;
            }
            case 1: {
                this.motionYaw += 5.0;
                break;
            }
            case 2: {
                this.motionPitch -= 5.0;
                break;
            }
            case 3: {
                this.motionYaw -= 5.0;
                break;
            }
            case 4: {
                this.motionPitch += 5.0;
                break;
            }
        }
        this.motionYaw += 2.0f * ((Entity)this).rand.nextFloat() - 1.0f;
        this.motionPitch += 2.0f * ((Entity)this).rand.nextFloat() - 1.0f;
        ((Entity)this).rotationPitch += (float)(0.1 * this.motionPitch);
        ((Entity)this).rotationYaw += (float)(0.1 * this.motionYaw);
        if (((Entity)this).rotationPitch < -60.0f) {
            ((Entity)this).rotationPitch = -60.0f;
        }
        if (((Entity)this).rotationPitch > 60.0f) {
            ((Entity)this).rotationPitch = 60.0f;
        }
        ((Entity)this).rotationPitch *= (float)0.99;
        ((Entity)this).motionX += 0.005 * Math.cos(((Entity)this).rotationYaw / 180.0 * 3.141592653589793) * Math.cos(((Entity)this).rotationPitch / 180.0 * 3.141592653589793);
        ((Entity)this).motionY += 0.005 * Math.sin(((Entity)this).rotationPitch / 180.0 * 3.141592653589793);
        ((Entity)this).motionZ += 0.005 * Math.sin(((Entity)this).rotationYaw / 180.0 * 3.141592653589793) * Math.cos(((Entity)this).rotationPitch / 180.0 * 3.141592653589793);
        ((Entity)this).motionX *= 0.98;
        ((Entity)this).motionY *= 0.98;
        ((Entity)this).motionZ *= 0.98;
        int i = MathHelper.floor_double(((Entity)this).posX);
        final int j = MathHelper.floor_double(((Entity)this).boundingBox.minY);
        final int k = MathHelper.floor_double(((Entity)this).posZ);
        if (((Entity)this).motionX > 0.0 && ((Entity)this).worldObj.getBlockId(i + 1, j, k) != 0) {
            ((Entity)this).motionX = -((Entity)this).motionX;
            this.motionYaw -= 10.0;
        }
        else if (((Entity)this).motionX < 0.0 && ((Entity)this).worldObj.getBlockId(i - 1, j, k) != 0) {
            ((Entity)this).motionX = -((Entity)this).motionX;
            this.motionYaw += 10.0;
        }
        if (((Entity)this).motionY > 0.0 && ((Entity)this).worldObj.getBlockId(i, j + 1, k) != 0) {
            ((Entity)this).motionY = -((Entity)this).motionY;
            this.motionPitch -= 10.0;
        }
        else if (((Entity)this).motionY < 0.0 && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != 0) {
            ((Entity)this).motionY = -((Entity)this).motionY;
            this.motionPitch += 10.0;
        }
        if (((Entity)this).motionZ > 0.0 && ((Entity)this).worldObj.getBlockId(i, j, k + 1) != 0) {
            ((Entity)this).motionZ = -((Entity)this).motionZ;
            this.motionYaw -= 10.0;
        }
        else if (((Entity)this).motionZ < 0.0 && ((Entity)this).worldObj.getBlockId(i, j, k - 1) != 0) {
            ((Entity)this).motionZ = -((Entity)this).motionZ;
            this.motionYaw += 10.0;
        }
        this.extinguish();
        this.moveEntity(((Entity)this).motionX, ((Entity)this).motionY, ((Entity)this).motionZ);
        this.checkForBeingStuck();
    }
    
    public double getSpeed() {
        return Math.sqrt(((Entity)this).motionX * ((Entity)this).motionX + ((Entity)this).motionY * ((Entity)this).motionY + ((Entity)this).motionZ * ((Entity)this).motionZ);
    }
    
    private double openSpace(final float rotationYawOffset, final float rotationPitchOffset) {
        final float yaw = ((Entity)this).rotationYaw + rotationYawOffset;
        final float pitch = ((Entity)this).rotationYaw + rotationYawOffset;
        final Vec3D vec3d = Vec3D.createVector(((Entity)this).posX, ((Entity)this).posY, ((Entity)this).posZ);
        final float f3 = MathHelper.cos(-yaw * 0.01745329f - 3.141593f);
        final float f4 = MathHelper.sin(-yaw * 0.01745329f - 3.141593f);
        final float f5 = MathHelper.cos(-pitch * 0.01745329f);
        final float f6 = MathHelper.sin(-pitch * 0.01745329f);
        final float f7 = f4 * f5;
        final float f8 = f6;
        final float f9 = f3 * f5;
        final double d3 = 50.0;
        final Vec3D vec3d2 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
        final MovingObjectPosition movingobjectposition = ((Entity)this).worldObj.rayTraceBlocks_do(vec3d, vec3d2, true);
        if (movingobjectposition == null) {
            return 50.0;
        }
        if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
            final double i = movingobjectposition.blockX - ((Entity)this).posX;
            final double j = movingobjectposition.blockY - ((Entity)this).posY;
            final double k = movingobjectposition.blockZ - ((Entity)this).posZ;
            return Math.sqrt(i * i + j * j + k * k);
        }
        return 50.0;
    }
    
    protected void updateEntityActionState() {
    }
    
    private void checkForBeingStuck() {
        final long curtime = System.currentTimeMillis();
        if (curtime > this.checkTime + 3000L) {
            final double diffx = ((Entity)this).posX - this.checkX;
            final double diffy = ((Entity)this).posY - this.checkY;
            final double diffz = ((Entity)this).posZ - this.checkZ;
            final double distanceTravelled = Math.sqrt(diffx * diffx + diffy * diffy + diffz * diffz);
            if (distanceTravelled < 3.0) {
                if (!this.isStuckWarning) {
                    this.isStuckWarning = true;
                }
                else {
                    this.setDead();
                }
            }
            this.checkX = ((Entity)this).posX;
            this.checkY = ((Entity)this).posY;
            this.checkZ = ((Entity)this).posZ;
            this.checkTime = curtime;
        }
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - ((Entity)this).posX) / d3;
        final double d5 = (this.waypointY - ((Entity)this).posY) / d3;
        final double d6 = (this.waypointZ - ((Entity)this).posZ) / d3;
        final AxisAlignedBB axisalignedbb = ((Entity)this).boundingBox.copy();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.offset(d4, d5, d6);
            if (((Entity)this).worldObj.getCollidingBoundingBoxes((Entity)this, axisalignedbb).size() > 0) {
                return false;
            }
        }
        return true;
    }
    
    protected String getLivingSound() {
        return "aether.sound.mobs.aerwhale.aerwhaleCall";
    }
    
    protected String getHurtSound() {
        return "aether.sound.mobs.aerwhale.aerwhaleDeath";
    }
    
    protected String getDeathSound() {
        return "aether.sound.mobs.aerwhale.aerwhaleDeath";
    }
    
    protected float getSoundVolume() {
        return 3.0f;
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    public boolean canDespawn() {
        return true;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(((Entity)this).posX);
        final int j = MathHelper.floor_double(((Entity)this).boundingBox.minY);
        final int k = MathHelper.floor_double(((Entity)this).posZ);
        return ((Entity)this).rand.nextInt(65) == 0 && ((Entity)this).worldObj.checkIfAABBIsClear(((Entity)this).boundingBox) && ((Entity)this).worldObj.getCollidingBoundingBoxes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).worldObj.isAnyLiquid(((Entity)this).boundingBox) && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != AetherBlocks.DungeonStone.blockID && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LightDungeonStone.blockID && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.blockID && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.blockID && ((Entity)this).worldObj.getBlockId(i, j - 1, k) != AetherBlocks.Holystone.blockID;
    }
}
