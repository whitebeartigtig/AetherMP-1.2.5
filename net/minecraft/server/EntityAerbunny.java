package net.minecraft.server;

import java.util.*;

public class EntityAerbunny extends EntityAetherAnimal
{
    public int age;
    public int mate;
    public boolean grab;
    public boolean fear;
    public boolean gotrider;
    public Entity runFrom;
    public float puffiness;
    
    public EntityAerbunny(final World world) {
        super(world);
        ((EntityLiving)this).bb = 2.5f;
        ((EntityLiving)this).texture = "/aether/mobs/aerbunny.png";
        ((Entity)this).height = -0.16f;
        this.b(0.4f, 0.4f);
        ((EntityLiving)this).health = 6;
        if (((Entity)this).be < 5.0) {
            ((Entity)this).be = 5.0;
        }
        this.age = ((Entity)this).random.nextInt(64);
        this.mate = 0;
    }
    
    public void onUpdate() {
        if (this.gotrider) {
            this.gotrider = false;
            if (((Entity)this).vehicle == null) {
                final EntityPlayer entityplayer = (EntityPlayer)this.findPlayerToRunFrom();
                if (entityplayer != null && this.i((Entity)entityplayer) < 2.0f && ((Entity)entityplayer).passenger == null) {
                    this.mount((Entity)entityplayer);
                }
            }
        }
        if (this.age < 1023) {
            ++this.age;
        }
        else if (this.mate < 127) {
            ++this.mate;
        }
        else {
            int i = 0;
            final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(16.0, 16.0, 16.0));
            for (int j = 0; j < list.size(); ++j) {
                final Entity entity = list.get(j);
                if (entity instanceof EntityAerbunny) {
                    ++i;
                }
            }
            if (i > 12) {
                this.proceed();
                return;
            }
            final List list2 = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(1.0, 1.0, 1.0));
            boolean flag = false;
            for (int k = 0; k < list.size(); ++k) {
                final Entity entity2 = list2.get(k);
                if (entity2 instanceof EntityAerbunny) {
                    if (entity2 != this) {
                        final EntityAerbunny entitybunny = (EntityAerbunny)entity2;
                        if (((Entity)entitybunny).vehicle == null) {
                            if (entitybunny.age >= 1023) {
                                final EntityAerbunny entitybunny2 = new EntityAerbunny(((Entity)this).world);
                                entitybunny2.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
                                ((Entity)this).world.addEntity((Entity)entitybunny2);
                                this.proceed();
                                entitybunny.proceed();
                                flag = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!flag) {
                this.mate = ((Entity)this).random.nextInt(16);
            }
        }
        if (this.puffiness > 0.0f) {
            this.puffiness -= 0.1f;
        }
        else {
            this.puffiness = 0.0f;
        }
        super.F_();
    }
    
    protected void fall(final float f) {
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setBoolean("Fear", this.fear);
        if (((Entity)this).passenger != null) {
            this.gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", this.gotrider);
        nbttagcompound.setShort("RepAge", (short)this.age);
        nbttagcompound.setShort("RepMate", (short)this.mate);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.fear = nbttagcompound.getBoolean("Fear");
        this.gotrider = nbttagcompound.getBoolean("GotRider");
        this.age = nbttagcompound.getShort("RepAge");
        this.mate = nbttagcompound.getShort("RepMate");
    }
    
    protected void updateEntityActionState() {
        if (((Entity)this).onGround) {
            if (((EntityLiving)this).aX != 0.0f) {
                this.ac();
            }
        }
        else if (((Entity)this).vehicle != null) {
            if (((Entity)this).vehicle.dead) {
                this.mount(((Entity)this).vehicle);
            }
            else if (!((Entity)this).vehicle.onGround && !((Entity)this).vehicle.h_()) {
                ((Entity)this).vehicle.fallDistance = 0.0f;
                final Entity ridingEntity = ((Entity)this).vehicle;
                ridingEntity.motY += 0.05000000074505806;
                if (((Entity)this).vehicle.motY < -0.22499999403953552 && ((Entity)this).vehicle instanceof EntityLiving && ((EntityLiving)((Entity)this).vehicle).aZ) {
                    ((Entity)this).vehicle.motY = 0.125;
                    this.cloudPoop();
                    this.puffiness = 1.15f;
                }
            }
        }
        else if (!this.grab) {
            if (((EntityLiving)this).aX != 0.0f) {
                final int j = MathHelper.floor(((Entity)this).locX);
                final int i1 = MathHelper.floor(((Entity)this).boundingBox.b);
                final int k1 = MathHelper.floor(((Entity)this).boundingBox.b - 0.5);
                final int l1 = MathHelper.floor(((Entity)this).locZ);
                if ((((Entity)this).world.getTypeId(j, i1 - 1, l1) != 0 || ((Entity)this).world.getTypeId(j, k1 - 1, l1) != 0) && ((Entity)this).world.getTypeId(j, i1 + 2, l1) == 0 && ((Entity)this).world.getTypeId(j, i1 + 1, l1) == 0) {
                    if (((Entity)this).motY < 0.0) {
                        this.cloudPoop();
                        this.puffiness = 0.9f;
                    }
                    ((Entity)this).motY = 0.2;
                }
            }
            if (((Entity)this).motY < -0.1) {
                ((Entity)this).motY = -0.1;
            }
        }
        if (!this.grab) {
            super.d_();
            if (this.fear && ((Entity)this).random.nextInt(4) == 0) {
                if (this.runFrom != null) {
                    this.runLikeHell();
                    ((Entity)this).world.a("splash", ((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, 0.0, 0.0, 0.0);
                    if (!this.H()) {
                        this.a(this.runFrom, 30.0f, 30.0f);
                    }
                    if (this.runFrom.dead || this.i(this.runFrom) > 16.0f) {
                        this.runFrom = null;
                    }
                }
                else {
                    this.runFrom = this.findPlayerToRunFrom();
                }
            }
        }
        else if (((Entity)this).onGround) {
            this.grab = false;
            final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(12.0, 12.0, 12.0));
            for (int m = 0; m < list.size(); ++m) {
                final Entity entity = list.get(m);
                if (entity instanceof EntityMonster) {
                    final EntityMonster entitymobs = (EntityMonster)entity;
                    entitymobs.setTarget((Entity)this);
                }
            }
        }
        if (this.h_()) {
            this.ac();
        }
    }
    
    public void cloudPoop() {
        final double a = ((Entity)this).random.nextFloat() - 0.5f;
        final double c = ((Entity)this).random.nextFloat() - 0.5f;
        final double d = ((Entity)this).locX + a * 0.4000000059604645;
        final double e = ((Entity)this).boundingBox.b;
        final double f = ((Entity)this).locZ + a * 0.4000000059604645;
        ((Entity)this).world.a("explode", d, e, f, 0.0, -0.07500000298023224, 0.0);
    }
    
    public boolean attackEntityFrom(final DamageSource src, final int i) {
        final boolean flag = super.damageEntity(src, i);
        if (flag && src.l().equals("player")) {
            this.fear = true;
        }
        return flag;
    }
    
    public boolean isOnLadder() {
        return ((EntityLiving)this).aX != 0.0f;
    }
    
    protected Entity findPlayerToRunFrom() {
        final EntityPlayer entityplayer = ((Entity)this).world.getClosestPlayerToEntity((Entity)this, 12.0);
        if (entityplayer != null && this.h((Entity)entityplayer)) {
            return (Entity)entityplayer;
        }
        return null;
    }
    
    public void runLikeHell() {
        final double a = ((Entity)this).locX - this.runFrom.locX;
        final double b = ((Entity)this).locZ - this.runFrom.locZ;
        double crazy = Math.atan2(a, b);
        crazy += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.75;
        final double c = ((Entity)this).locX + Math.sin(crazy) * 8.0;
        final double d = ((Entity)this).locZ + Math.cos(crazy) * 8.0;
        final int x = MathHelper.floor(c);
        final int y = MathHelper.floor(((Entity)this).boundingBox.b);
        final int z = MathHelper.floor(d);
        for (int q = 0; q < 16; ++q) {
            final int i = x + ((Entity)this).random.nextInt(4) - ((Entity)this).random.nextInt(4);
            final int j = y + ((Entity)this).random.nextInt(4) - ((Entity)this).random.nextInt(4) - 1;
            final int k = z + ((Entity)this).random.nextInt(4) - ((Entity)this).random.nextInt(4);
            if (j > 4 && (((Entity)this).world.getTypeId(i, j, k) == 0 || ((Entity)this).world.getTypeId(i, j, k) == Block.SNOW.id) && ((Entity)this).world.getTypeId(i, j - 1, k) != 0) {
                final PathEntity dogs = ((Entity)this).world.a((Entity)this, i, j, k, 16.0f, true, false, false, true);
                this.setPathEntity(dogs);
                break;
            }
        }
    }
    
    @Override
    public EntityAnimal spawnBabyAnimal(final EntityAnimal entityanimal) {
        return new EntityAerbunny(((Entity)this).world);
    }
    
    public boolean isWheat(final ItemStack itemstack) {
        return itemstack.id == Item.WHEAT.id;
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        final ItemStack itemstack = entityplayer.inventory.getItemInHand();
        if (itemstack != null && this.isWheat(itemstack)) {
            return super.b(entityplayer);
        }
        ((Entity)this).yaw = ((Entity)entityplayer).yaw;
        if (((Entity)this).vehicle != null) {
            ((EntityLiving)this).V = ((Entity)this).vehicle.yaw;
            ((Entity)this).yaw = ((Entity)this).vehicle.yaw;
        }
        this.mount((Entity)entityplayer);
        if (((Entity)this).vehicle == null) {
            this.grab = true;
        }
        else {
        }
        ((EntityLiving)this).aZ = false;
        ((EntityLiving)this).aX = 0.0f;
        ((EntityLiving)this).aW = 0.0f;
        this.setPathEntity((PathEntity)null);
        ((Entity)this).motX = ((Entity)entityplayer).motX * 5.0;
        ((Entity)this).motY = ((Entity)entityplayer).motY / 2.0 + 0.5;
        ((Entity)this).motZ = ((Entity)entityplayer).motZ * 5.0;
        return true;
    }
    
    public double getYOffset() {
        if (((Entity)this).vehicle instanceof EntityPlayer) {
            return ((Entity)this).height - 1.15f;
        }
        return ((Entity)this).height;
    }
    
    protected String getLivingSound() {
        return null;
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        if (mod_Aether.equippedSkyrootSword()) {
            this.b(Item.STRING.id, 2);
        }
        else {
            this.b(Item.STRING.id, 1);
        }
    }
    
    public void proceed() {
        this.mate = 0;
        this.age = ((Entity)this).random.nextInt(64);
    }
    
    protected boolean canTriggerWalking() {
        return ((Entity)this).onGround;
    }
    
    protected String getHurtSound() {
        return "aether.sound.mobs.aerbunny.aerbunnyHurt";
    }
    
    protected String getDeathSound() {
        return "aether.sound.mobs.aerbunny.aerbunnyDeath";
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere();
    }
    
    public int getMaxHealth() {
        return 20;
    }

	@Override
	public EntityAnimal createChild(EntityAnimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
