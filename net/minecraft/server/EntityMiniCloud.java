package net.minecraft.server;

public class EntityMiniCloud extends EntityFlying
{
    public int shotTimer;
    public int lifeSpan;
    public boolean gotPlayer;
    public boolean toLeft;
    public EntityLiving dude;
    public double targetX;
    public double targetY;
    public double targetZ;
    
    public EntityMiniCloud(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/minicloud.png";
        this.b(0.0f, 0.0f);
        ((Entity)this).bQ = true;
        ((Entity)this).bR = 1.75f;
    }
    
    public int getMaxHealth() {
        return 5;
    }
    
    public EntityMiniCloud(final World world, final EntityPlayer ep, final boolean flag) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/minicloud.png";
        this.b(0.5f, 0.45f);
        this.dude = (EntityLiving)ep;
        this.toLeft = flag;
        this.lifeSpan = 3600;
        this.getTargetPos();
        this.setPosition(this.targetX, this.targetY, this.targetZ);
        ((Entity)this).pitch = ((Entity)this.dude).pitch;
        ((Entity)this).yaw = ((Entity)this.dude).yaw;
        ((Entity)this).bR = 1.75f;
        this.aC();
    }
    
    public boolean isInRangeToRenderDist(final double d) {
        return true;
    }
    
    public void getTargetPos() {
        if (this.i((Entity)this.dude) > 2.0f) {
            this.targetX = ((Entity)this.dude).locX;
            this.targetY = ((Entity)this.dude).locY - 0.10000000149011612;
            this.targetZ = ((Entity)this.dude).locZ;
        }
        else {
            double angle = ((Entity)this.dude).yaw;
            if (this.toLeft) {
                angle -= 90.0;
            }
            else {
                angle += 90.0;
            }
            angle /= -57.29577319531843;
            this.targetX = ((Entity)this.dude).locX + Math.sin(angle) * 1.05;
            this.targetY = ((Entity)this.dude).locY - 0.10000000149011612;
            this.targetZ = ((Entity)this.dude).locZ + Math.cos(angle) * 1.05;
        }
    }
    
    public boolean atShoulder() {
        final double a = ((Entity)this).locX - this.targetX;
        final double b = ((Entity)this).locY - this.targetY;
        final double c = ((Entity)this).locZ - this.targetZ;
        return Math.sqrt(a * a + b * b + c * c) < 0.3;
    }
    
    public void approachTarget() {
        final double a = this.targetX - ((Entity)this).locX;
        final double b = this.targetY - ((Entity)this).locY;
        final double c = this.targetZ - ((Entity)this).locZ;
        final double d = Math.sqrt(a * a + b * b + c * c) * 3.25;
        ((Entity)this).motX = (((Entity)this).motX + a / d) / 2.0;
        ((Entity)this).motY = (((Entity)this).motY + b / d) / 2.0;
        ((Entity)this).motZ = (((Entity)this).motZ + c / d) / 2.0;
        final double angle = Math.atan2(a, c);
    }
    
    protected Entity findPlayer() {
        final EntityHuman entityplayer = ((Entity)this).world.findNearbyPlayer((Entity)this, 16.0);
        /*
        if (entityplayer != null && this.h((Entity)entityplayer) && !GuiMainMenu.mmactive) {
            return (Entity)entityplayer;
        }
        */
        return null;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("LifeSpan", (short)this.lifeSpan);
        nbttagcompound.setShort("ShotTimer", (short)this.shotTimer);
        nbttagcompound.setBoolean("GotPlayer", this.gotPlayer = (this.dude != null));
        nbttagcompound.setBoolean("ToLeft", this.toLeft);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.lifeSpan = nbttagcompound.getShort("LifeSpan");
        this.shotTimer = nbttagcompound.getShort("ShotTimer");
        this.gotPlayer = nbttagcompound.getBoolean("GotPlayer");
        this.toLeft = nbttagcompound.getBoolean("ToLeft");
    }
    
    public void updateEntityActionState() {
        super.d_();
        --this.lifeSpan;
        if (this.lifeSpan <= 0) {
            this.aC();
            ((Entity)this).dead = true;
            return;
        }
        if (this.shotTimer > 0) {
            --this.shotTimer;
        }
        if (this.gotPlayer && this.dude == null) {
            this.gotPlayer = false;
            this.dude = (EntityLiving)this.findPlayer();
        }
        if (this.dude == null || ((Entity)this.dude).dead) {
            this.aC();
            ((Entity)this).dead = true;
            return;
        }
        this.getTargetPos();
        if (this.atShoulder()) {
            ((Entity)this).motX *= 0.65;
            ((Entity)this).motY *= 0.65;
            ((Entity)this).motZ *= 0.65;
            ((Entity)this).yaw = ((Entity)this.dude).yaw + (this.toLeft ? 1.0f : -1.0f);
            ((Entity)this).pitch = ((Entity)this.dude).pitch;
            if (this.shotTimer <= 0 && this.dude instanceof EntityPlayer && ((EntityPlayer)this.dude).t) {
                final float spanish = ((Entity)this).yaw - (this.toLeft ? 1.0f : -1.0f);
                final double a = ((Entity)this).locX + Math.sin(spanish / -57.29577319531843) * 1.6;
                final double b = ((Entity)this).locY - 0.25;
                final double c = ((Entity)this).locZ + Math.cos(spanish / -57.29577319531843) * 1.6;
                final EntityFiroBall eh = new EntityFiroBall(((Entity)this).world, a, b, c, true, true);
                ((Entity)this).world.addEntity((Entity)eh);
                final Vec3D vec3d = this.aJ();
                if (vec3d != null) {
                    eh.smotionX = vec3d.a * 1.5;
                    eh.smotionY = vec3d.b * 1.5;
                    eh.smotionZ = vec3d.c * 1.5;
                }
                eh.smacked = true;
                ((Entity)this).world.makeSound((Entity)this, "mob.zephyr.zephyrshoot", 0.75f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
                this.shotTimer = 40;
            }
        }
        else {
            this.approachTarget();
        }
    }
    
    public boolean attackEntityFrom(final EntityLiving e, final int i) {
        return (e == null || e != this.dude) && super.damageEntity(DamageSource.mobAttack(e), i);
    }
}
