package net.minecraft.server;

public class EntityHomeShot extends EntityFlying
{
    public float[] sinage;
    public EntityLiving target;
    public boolean firstRun;
    public int life;
    public int lifeSpan;
    private static final double topSpeed = 0.125;
    private static final float sponge = 57.295773f;
    
    public EntityHomeShot(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/electroball.png";
        this.lifeSpan = 200;
        this.life = this.lifeSpan;
        this.b(0.7f, 0.7f);
        this.firstRun = true;
        this.sinage = new float[3];
        ((Entity)this).fireProof = true;
        for (int i = 0; i < 3; ++i) {
            this.sinage[i] = ((Entity)this).random.nextFloat() * 6.0f;
        }
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    public EntityHomeShot(final World world, final double x, final double y, final double z, final EntityLiving ep) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/electroball.png";
        this.lifeSpan = 200;
        this.life = this.lifeSpan;
        this.b(0.7f, 0.7f);
        this.setPosition(x, y, z);
        this.target = ep;
        this.sinage = new float[3];
        ((Entity)this).fireProof = true;
        for (int i = 0; i < 3; ++i) {
            this.sinage[i] = ((Entity)this).random.nextFloat() * 6.0f;
        }
    }
    
    public void onUpdate() {
        super.F_();
        --this.life;
        if (this.firstRun && this.target == null) {
            this.target = (EntityLiving)this.findPlayerToAttack();
            this.firstRun = false;
        }
        if (this.target == null || ((Entity)this.target).dead || this.target.health <= 0) {
            ((Entity)this).dead = true;
        }
        else if (this.life <= 0) {
            final EntityWeatherLighting thunder = new EntityWeatherLighting(((Entity)this).world, ((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
            ((Entity)this).world.addEntity((Entity)thunder);
            ((Entity)this).dead = true;
        }
        else {
            this.updateAnims();
            this.faceIt();
            this.moveIt((Entity)this.target, 0.02);
        }
    }
    
    public void moveIt(final Entity e1, final double sped) {
        final double angle1 = ((Entity)this).yaw / 57.295773f;
        ((Entity)this).motX -= Math.sin(angle1) * sped;
        ((Entity)this).motZ += Math.cos(angle1) * sped;
        final double a = e1.locY - 0.75;
        if (a < ((Entity)this).boundingBox.b - 0.5) {
            ((Entity)this).motY -= sped / 2.0;
        }
        else if (a > ((Entity)this).boundingBox.b + 0.5) {
            ((Entity)this).motY += sped / 2.0;
        }
        else {
            ((Entity)this).motY += (a - ((Entity)this).boundingBox.b) * (sped / 2.0);
        }
        if (((Entity)this).onGround) {
            ((Entity)this).onGround = false;
            ((Entity)this).motY = 0.10000000149011612;
        }
    }
    
    public void faceIt() {
        this.a((Entity)this.target, 10.0f, 10.0f);
    }
    
    public void updateAnims() {
        for (int i = 0; i < 3; ++i) {
            final float[] sinage = this.sinage;
            final int n = i;
            sinage[n] += 0.3f + i * 0.13f;
            if (this.sinage[i] > 6.283186f) {
                final float[] sinage2 = this.sinage;
                final int n2 = i;
                sinage2[n2] -= 6.283186f;
            }
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("LifeLeft", (short)this.life);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.life = nbttagcompound.getShort("LifeLeft");
    }
    
    public void checkOverLimit() {
        final double a = ((Entity)this.target).locX - ((Entity)this).locX;
        final double b = ((Entity)this.target).locY - ((Entity)this).locY;
        final double c = ((Entity)this.target).locZ - ((Entity)this).locZ;
        final double d = Math.sqrt(a * a + b * b + c * c);
        if (d > 0.125) {
            final double e = 0.125 / d;
            ((Entity)this).motX *= e;
            ((Entity)this).motY *= e;
            ((Entity)this).motZ *= e;
        }
    }
    
    public Entity findPlayerToAttack() {
        final EntityHuman entityplayer = ((Entity)this).world.findNearbyPlayer((Entity)this, 16.0);
        if (entityplayer != null && this.h((Entity)entityplayer)) {
            return (Entity)entityplayer;
        }
        return null;
    }
    
    public void applyEntityCollision(final Entity entity) {
        super.collide(entity);
        if (entity != null && this.target != null && entity == this.target) {
            final boolean flag = entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), 1);
            if (flag) {
                this.moveIt(entity, -0.1);
            }
        }
    }
    
    public boolean attackEntityFrom(final Entity entity, final int i) {
        if (entity != null) {
            this.moveIt(entity, -0.15 - i / 8.0);
            return true;
        }
        return false;
    }
}
