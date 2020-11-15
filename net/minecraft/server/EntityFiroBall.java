package net.minecraft.server;

public class EntityFiroBall extends EntityFlying
{
    public float[] sinage;
    public double smotionX;
    public double smotionY;
    public double smotionZ;
    public int life;
    public int lifeSpan;
    public boolean frosty;
    public boolean smacked;
    public boolean fromCloud;
    private static final double topSpeed = 0.125;
    private static final float sponge = 57.295773f;
    
    public EntityFiroBall(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firoball.png";
        this.lifeSpan = 300;
        this.life = this.lifeSpan;
        this.b(0.9f, 0.9f);
        this.sinage = new float[3];
        ((Entity)this).fireProof = true;
        for (int i = 0; i < 3; ++i) {
            this.sinage[i] = ((Entity)this).random.nextFloat() * 6.0f;
        }
    }
    
    public int getMaxHealth() {
        return 5;
    }
    
    public EntityFiroBall(final World world, final double x, final double y, final double z, final boolean flag) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firoball.png";
        this.lifeSpan = 300;
        this.life = this.lifeSpan;
        this.b(0.9f, 0.9f);
        this.setLocation(x, y, z, ((Entity)this).yaw, ((Entity)this).pitch);
        this.sinage = new float[3];
        ((Entity)this).fireProof = true;
        for (int i = 0; i < 3; ++i) {
            this.sinage[i] = ((Entity)this).random.nextFloat() * 6.0f;
        }
        this.smotionX = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        this.smotionY = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        this.smotionZ = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        if (flag) {
            this.frosty = true;
            ((EntityLiving)this).texture = "/aether/mobs/iceyball.png";
            this.smotionX /= 3.0;
            this.smotionY = 0.0;
            this.smotionZ /= 3.0;
        }
    }
    
    public EntityFiroBall(final World world, final double x, final double y, final double z, final boolean flag, final boolean flag2) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firoball.png";
        this.lifeSpan = 300;
        this.life = this.lifeSpan;
        this.b(0.9f, 0.9f);
        this.setLocation(x, y, z, ((Entity)this).yaw, ((Entity)this).pitch);
        this.sinage = new float[3];
        ((Entity)this).fireProof = true;
        for (int i = 0; i < 3; ++i) {
            this.sinage[i] = ((Entity)this).random.nextFloat() * 6.0f;
        }
        this.smotionX = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        this.smotionY = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        this.smotionZ = (0.2 + ((Entity)this).random.nextFloat() * 0.15) * ((((Entity)this).random.nextInt(2) == 0) ? 1.0 : -1.0);
        if (flag) {
            this.frosty = true;
            ((EntityLiving)this).texture = "/aether/mobs/iceyball.png";
            this.smotionX /= 3.0;
            this.smotionY = 0.0;
            this.smotionZ /= 3.0;
        }
        this.fromCloud = flag2;
    }
    
    public void onUpdate() {
        super.F_();
        --this.life;
        if (this.life <= 0) {
            this.fizzle();
            ((Entity)this).dead = true;
        }
    }
    
    public void fizzle() {
        if (this.frosty) {
            ((Entity)this).world.makeSound((Entity)this, "random.glass", 2.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.2f);
        }
        else {
            ((Entity)this).world.makeSound((Entity)this, "random.fizz", 2.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.2f);
        }
        for (int j = 0; j < 16; ++j) {
            final double a = ((Entity)this).locX + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.25;
            final double b = ((Entity)this).locY + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.25;
            final double c = ((Entity)this).locZ + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.25;
            if (!this.frosty) {
                ((Entity)this).world.a("largesmoke", a, b, c, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void splode() {
        if (this.frosty) {
            ((Entity)this).world.makeSound((Entity)this, "random.glass", 2.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.2f);
        }
        else {
            ((Entity)this).world.makeSound((Entity)this, "random.explode", 2.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.2f);
        }
        for (int j = 0; j < 40; ++j) {
            double a = (((Entity)this).random.nextFloat() - 0.5f) * 0.5f;
            double b = (((Entity)this).random.nextFloat() - 0.5f) * 0.5f;
            double c = (((Entity)this).random.nextFloat() - 0.5f) * 0.5f;
            if (this.frosty) {
                a *= 0.5;
                b *= 0.5;
                c *= 0.5;
                ((Entity)this).world.a("snowshovel", ((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, a, b + 0.125, c);
            }
            else {
                ((Entity)this).world.a("flame", ((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, a, b, c);
            }
        }
    }
    
    public void updateAnims() {
        if (!this.frosty) {
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
    }
    
    public void updateEntityActionState() {
        ((Entity)this).motX = this.smotionX;
        ((Entity)this).motY = this.smotionY;
        ((Entity)this).motZ = this.smotionZ;
        if (((Entity)this).bA) {
            if (this.frosty && this.smacked) {
                this.splode();
                this.fizzle();
                ((Entity)this).dead = true;
            }
            else {
                final int i = MathHelper.floor(((Entity)this).locX);
                final int j = MathHelper.floor(((Entity)this).boundingBox.b);
                final int k = MathHelper.floor(((Entity)this).locZ);
                if (this.smotionX > 0.0 && ((Entity)this).world.getTypeId(i + 1, j, k) != 0) {
                    final double n = -this.smotionX;
                    this.smotionX = n;
                    ((Entity)this).motX = n;
                }
                else if (this.smotionX < 0.0 && ((Entity)this).world.getTypeId(i - 1, j, k) != 0) {
                    final double n2 = -this.smotionX;
                    this.smotionX = n2;
                    ((Entity)this).motX = n2;
                }
                if (this.smotionY > 0.0 && ((Entity)this).world.getTypeId(i, j + 1, k) != 0) {
                    final double n3 = -this.smotionY;
                    this.smotionY = n3;
                    ((Entity)this).motY = n3;
                }
                else if (this.smotionY < 0.0 && ((Entity)this).world.getTypeId(i, j - 1, k) != 0) {
                    final double n4 = -this.smotionY;
                    this.smotionY = n4;
                    ((Entity)this).motY = n4;
                }
                if (this.smotionZ > 0.0 && ((Entity)this).world.getTypeId(i, j, k + 1) != 0) {
                    final double n5 = -this.smotionZ;
                    this.smotionZ = n5;
                    ((Entity)this).motZ = n5;
                }
                else if (this.smotionZ < 0.0 && ((Entity)this).world.getTypeId(i, j, k - 1) != 0) {
                    final double n6 = -this.smotionZ;
                    this.smotionZ = n6;
                    ((Entity)this).motZ = n6;
                }
            }
        }
        this.updateAnims();
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("LifeLeft", (short)this.life);
        nbttagcompound.set("SeriousKingVampire", (NBTBase)this.a(new double[] { this.smotionX, this.smotionY, this.smotionZ }));
        nbttagcompound.setBoolean("Frosty", this.frosty);
        nbttagcompound.setBoolean("FromCloud", this.fromCloud);
        nbttagcompound.setBoolean("Smacked", this.smacked);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.life = nbttagcompound.getShort("LifeLeft");
        this.frosty = nbttagcompound.getBoolean("Frosty");
        this.fromCloud = nbttagcompound.getBoolean("FromCloud");
        if (this.frosty) {
            ((EntityLiving)this).texture = "/aether/mobs/iceyball.png";
        }
        this.smacked = nbttagcompound.getBoolean("Smacked");
        final NBTTagList nbttaglist = nbttagcompound.getList("SeriousKingVampire");
        this.smotionX = (float)((NBTTagDouble)nbttaglist.get(0)).data;
        this.smotionY = (float)((NBTTagDouble)nbttaglist.get(1)).data;
        this.smotionZ = (float)((NBTTagDouble)nbttaglist.get(2)).data;
    }
    
    public void applyEntityCollision(final Entity entity) {
        super.collide(entity);
        boolean flag = false;
        if (entity != null && entity instanceof EntityLiving && !(entity instanceof EntityFiroBall)) {
            if (this.frosty && (!(entity instanceof EntityFireMonster) || (this.smacked && !this.fromCloud)) && !(entity instanceof EntityFireMinion)) {
                flag = entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), 5);
            }
            else if (!this.frosty && !(entity instanceof EntityFireMonster) && !(entity instanceof EntityFireMinion)) {
                flag = entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), 5);
                if (flag) {
                    this.setOnFire(100);
                }
            }
        }
        if (flag) {
            this.splode();
            this.fizzle();
            ((Entity)this).dead = true;
        }
    }
    
    public boolean attackEntityFrom(final DamageSource ds, final int i) {
        if (ds.getEntity() != null) {
            final Vec3D vec3d = ds.getEntity().aJ();
            if (vec3d != null) {
                this.smotionX = vec3d.a;
                this.smotionY = vec3d.b;
                this.smotionZ = vec3d.c;
            }
            return this.smacked = true;
        }
        return false;
    }
}
