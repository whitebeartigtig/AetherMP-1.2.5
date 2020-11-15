package net.minecraft.server;

public class EntityAerwhale extends EntityFlying implements IMonster
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
        ((Entity)this).fireProof = true;
        this.aggroCooldown = 0;
        this.prevAttackCounter = 0;
        this.attackCounter = 0;
        ((EntityLiving)this).texture = "/aether/mobs/Mob_Aerwhale.png";
        this.b(4.0f, 4.0f);
        ((EntityLiving)this).bb = 0.5f;
        ((EntityLiving)this).health = 20;
        ((Entity)this).yaw = 360.0f * ((Entity)this).random.nextFloat();
        ((Entity)this).pitch = 90.0f * ((Entity)this).random.nextFloat() - 45.0f;
        ((Entity)this).cd = true;
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    protected void entityInit() {
        super.b();
        ((Entity)this).datawatcher.a(16, (Object)0);
    }
    
    public void onLivingUpdate() {
    }
    
    public void onUpdate() {
        final byte byte0 = ((Entity)this).datawatcher.getByte(16);
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
                    ((Entity)this).pitch = -((Entity)this).pitch;
                    ((Entity)this).yaw = -((Entity)this).yaw;
                    break;
                }
                this.motionYaw *= 0.8999999761581421;
                this.motionPitch *= 0.8999999761581421;
                if (((Entity)this).locY > 100.0) {
                    this.motionPitch -= 2.0;
                }
                if (((Entity)this).locY < 20.0) {
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
        this.motionYaw += 2.0f * ((Entity)this).random.nextFloat() - 1.0f;
        this.motionPitch += 2.0f * ((Entity)this).random.nextFloat() - 1.0f;
        ((Entity)this).pitch += (float)(0.1 * this.motionPitch);
        ((Entity)this).yaw += (float)(0.1 * this.motionYaw);
        if (((Entity)this).pitch < -60.0f) {
            ((Entity)this).pitch = -60.0f;
        }
        if (((Entity)this).pitch > 60.0f) {
            ((Entity)this).pitch = 60.0f;
        }
        ((Entity)this).pitch *= (float)0.99;
        ((Entity)this).motX += 0.005 * Math.cos(((Entity)this).yaw / 180.0 * 3.141592653589793) * Math.cos(((Entity)this).pitch / 180.0 * 3.141592653589793);
        ((Entity)this).motY += 0.005 * Math.sin(((Entity)this).pitch / 180.0 * 3.141592653589793);
        ((Entity)this).motZ += 0.005 * Math.sin(((Entity)this).yaw / 180.0 * 3.141592653589793) * Math.cos(((Entity)this).pitch / 180.0 * 3.141592653589793);
        ((Entity)this).motX *= 0.98;
        ((Entity)this).motY *= 0.98;
        ((Entity)this).motZ *= 0.98;
        int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        if (((Entity)this).motX > 0.0 && ((Entity)this).world.getTypeId(i + 1, j, k) != 0) {
            ((Entity)this).motX = -((Entity)this).motX;
            this.motionYaw -= 10.0;
        }
        else if (((Entity)this).motX < 0.0 && ((Entity)this).world.getTypeId(i - 1, j, k) != 0) {
            ((Entity)this).motX = -((Entity)this).motX;
            this.motionYaw += 10.0;
        }
        if (((Entity)this).motY > 0.0 && ((Entity)this).world.getTypeId(i, j + 1, k) != 0) {
            ((Entity)this).motY = -((Entity)this).motY;
            this.motionPitch -= 10.0;
        }
        else if (((Entity)this).motY < 0.0 && ((Entity)this).world.getTypeId(i, j - 1, k) != 0) {
            ((Entity)this).motY = -((Entity)this).motY;
            this.motionPitch += 10.0;
        }
        if (((Entity)this).motZ > 0.0 && ((Entity)this).world.getTypeId(i, j, k + 1) != 0) {
            ((Entity)this).motZ = -((Entity)this).motZ;
            this.motionYaw -= 10.0;
        }
        else if (((Entity)this).motZ < 0.0 && ((Entity)this).world.getTypeId(i, j, k - 1) != 0) {
            ((Entity)this).motZ = -((Entity)this).motZ;
            this.motionYaw += 10.0;
        }
        this.extinguish();
        this.move(((Entity)this).motX, ((Entity)this).motY, ((Entity)this).motZ);
        this.checkForBeingStuck();
    }
    
    public double getSpeed() {
        return Math.sqrt(((Entity)this).motX * ((Entity)this).motX + ((Entity)this).motY * ((Entity)this).motY + ((Entity)this).motZ * ((Entity)this).motZ);
    }
    
    private double openSpace(final float rotationYawOffset, final float rotationPitchOffset) {
        final float yaw = ((Entity)this).yaw + rotationYawOffset;
        final float pitch = ((Entity)this).yaw + rotationYawOffset;
        final Vec3D vec3d = Vec3D.create(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
        final float f3 = MathHelper.cos(-yaw * 0.01745329f - 3.141593f);
        final float f4 = MathHelper.sin(-yaw * 0.01745329f - 3.141593f);
        final float f5 = MathHelper.cos(-pitch * 0.01745329f);
        final float f6 = MathHelper.sin(-pitch * 0.01745329f);
        final float f7 = f4 * f5;
        final float f8 = f6;
        final float f9 = f3 * f5;
        final double d3 = 50.0;
        final Vec3D vec3d2 = vec3d.add(f7 * d3, f8 * d3, f9 * d3);
        final MovingObjectPosition movingobjectposition = ((Entity)this).world.rayTrace(vec3d, vec3d2, true);
        if (movingobjectposition == null) {
            return 50.0;
        }
        if (movingobjectposition.type == EnumMovingObjectType.TILE) {
            final double i = movingobjectposition.b - ((Entity)this).locX;
            final double j = movingobjectposition.c - ((Entity)this).locY;
            final double k = movingobjectposition.d - ((Entity)this).locZ;
            return Math.sqrt(i * i + j * j + k * k);
        }
        return 50.0;
    }
    
    protected void updateEntityActionState() {
    }
    
    private void checkForBeingStuck() {
        final long curtime = System.currentTimeMillis();
        if (curtime > this.checkTime + 3000L) {
            final double diffx = ((Entity)this).locX - this.checkX;
            final double diffy = ((Entity)this).locY - this.checkY;
            final double diffz = ((Entity)this).locZ - this.checkZ;
            final double distanceTravelled = Math.sqrt(diffx * diffx + diffy * diffy + diffz * diffz);
            if (distanceTravelled < 3.0) {
                if (!this.isStuckWarning) {
                    this.isStuckWarning = true;
                }
                else {
                    this.die();
                }
            }
            this.checkX = ((Entity)this).locX;
            this.checkY = ((Entity)this).locY;
            this.checkZ = ((Entity)this).locZ;
            this.checkTime = curtime;
        }
    }
    
    private boolean isCourseTraversable(final double d, final double d1, final double d2, final double d3) {
        final double d4 = (this.waypointX - ((Entity)this).locX) / d3;
        final double d5 = (this.waypointY - ((Entity)this).locY) / d3;
        final double d6 = (this.waypointZ - ((Entity)this).locZ) / d3;
        final AxisAlignedBB axisalignedbb = ((Entity)this).boundingBox.clone();
        for (int i = 1; i < d3; ++i) {
            axisalignedbb.a(d4, d5, d6);
            if (((Entity)this).world.getCubes((Entity)this, axisalignedbb).size() > 0) {
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
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).random.nextInt(65) == 0 && ((Entity)this).world.containsEntity(((Entity)this).boundingBox) && ((Entity)this).world.getCubes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).world.containsLiquid(((Entity)this).boundingBox) && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.DungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.Holystone.id;
    }
}
