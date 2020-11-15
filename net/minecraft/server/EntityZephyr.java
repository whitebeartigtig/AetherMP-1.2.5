package net.minecraft.server;

public class EntityZephyr extends EntityFlying implements IMonster
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
    
    public EntityZephyr(final World world) {
        super(world);
        this.checkTime = 0L;
        this.checkX = 0.0;
        this.checkY = 0.0;
        this.checkZ = 0.0;
        this.isStuckWarning = false;
        this.courseChangeCooldown = 0;
        this.targetedEntity = null;
        this.aggroCooldown = 0;
        this.prevAttackCounter = 0;
        this.attackCounter = 0;
        ((EntityLiving)this).texture = "/aether/mobs/Zephyr.png";
        this.b(4.0f, 4.0f);
    }
    
    public int getMaxHealth() {
        return 5;
    }
    
    protected void updateEntityActionState() {
        if (((Entity)this).locY < -2.0 || ((Entity)this).locY > 130.0) {
            this.aG();
        }
        this.prevAttackCounter = this.attackCounter;
        final double d = this.waypointX - ((Entity)this).locX;
        final double d2 = this.waypointY - ((Entity)this).locY;
        final double d3 = this.waypointZ - ((Entity)this).locZ;
        final double d4 = MathHelper.sqrt(d * d + d2 * d2 + d3 * d3);
        if (d4 < 1.0 || d4 > 60.0) {
            this.waypointX = ((Entity)this).locX + (((Entity)this).random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointY = ((Entity)this).locY + (((Entity)this).random.nextFloat() * 2.0f - 1.0f) * 16.0f;
            this.waypointZ = ((Entity)this).locZ + (((Entity)this).random.nextFloat() * 2.0f - 1.0f) * 16.0f;
        }
        if (this.courseChangeCooldown-- <= 0) {
            this.courseChangeCooldown += ((Entity)this).random.nextInt(5) + 2;
            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d4)) {
                ((Entity)this).motX += d / d4 * 0.1;
                ((Entity)this).motY += d2 / d4 * 0.1;
                ((Entity)this).motZ += d3 / d4 * 0.1;
            }
            else {
                this.waypointX = ((Entity)this).locX;
                this.waypointY = ((Entity)this).locY;
                this.waypointZ = ((Entity)this).locZ;
            }
        }
        if (this.targetedEntity != null && this.targetedEntity.dead) {
            this.targetedEntity = null;
        }
        if (this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = (Entity)((Entity)this).world.findNearbyPlayer((Entity)this, 100.0);
            if (this.targetedEntity != null) {
                this.aggroCooldown = 20;
            }
        }
        final double d5 = 64.0;
        if (this.targetedEntity != null && this.targetedEntity.j((Entity)this) < d5 * d5) {
            final double d6 = this.targetedEntity.locX - ((Entity)this).locX;
            final double d7 = this.targetedEntity.boundingBox.b + this.targetedEntity.height / 2.0f - (((Entity)this).locY + ((Entity)this).height / 2.0f);
            final double d8 = this.targetedEntity.locZ - ((Entity)this).locZ;
            final float n = -(float)Math.atan2(d6, d8) * 180.0f / 3.141593f;
            ((Entity)this).yaw = n;
            ((EntityLiving)this).V = n;
            if (this.h(this.targetedEntity)) {
                if (this.attackCounter == 10) {
                    ((Entity)this).world.makeSound((Entity)this, "aether.sound.mobs.zephyr.zephyrCall", this.getSoundVolume(), (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
                }
                ++this.attackCounter;
                if (this.attackCounter == 20) {
                    ((Entity)this).world.makeSound((Entity)this, "aether.sound.mobs.zephyr.zephyrShoot", this.getSoundVolume(), (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
                    final EntityZephyrSnowball entitysnowball = new EntityZephyrSnowball(((Entity)this).world, (EntityLiving)this, d6, d7, d8);
                    final double d9 = 4.0;
                    final Vec3D vec3d = this.f(1.0f);
                    entitysnowball.locX = ((Entity)this).locX + vec3d.a * d9;
                    entitysnowball.locY = ((Entity)this).locY + ((Entity)this).height / 2.0f + 0.5;
                    entitysnowball.locZ = ((Entity)this).locZ + vec3d.c * d9;
                    ((Entity)this).world.addEntity((Entity)entitysnowball);
                    this.attackCounter = -40;
                }
            }
            else if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        else {
            final float n2 = -(float)Math.atan2(((Entity)this).motX, ((Entity)this).motZ) * 180.0f / 3.141593f;
            ((Entity)this).yaw = n2;
            ((EntityLiving)this).V = n2;
            if (this.attackCounter > 0) {
                --this.attackCounter;
            }
        }
        ((EntityLiving)this).texture = ((this.attackCounter <= 10) ? "/aether/mobs/Zephyr.png" : "/aether/mobs/Zephyr.png");
        if (!((Entity)this).world.isStatic && ((Entity)this).world.difficulty == 0) {
            this.die();
        }
        this.checkForBeingStuck();
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
        return "aether.sound.mobs.zephyr.zephyrCall";
    }
    
    protected String getHurtSound() {
        return "aether.sound.mobs.zephyr.zephyrCall";
    }
    
    protected String getDeathSound() {
        return "aether.sound.mobs.zephyr.zephyrCall";
    }
    
    protected int getDropItemId() {
        return AetherBlocks.Aercloud.id;
    }
    
    public boolean canDespawn() {
        return true;
    }
    
    protected float getSoundVolume() {
        return 3.0f;
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
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).random.nextInt(85) == 0 && ((Entity)this).world.containsEntity(((Entity)this).boundingBox) && ((Entity)this).world.getCubes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).world.containsLiquid(((Entity)this).boundingBox) && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.DungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.Holystone.id && ((Entity)this).world.difficulty > 0;
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
}
