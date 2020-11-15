package net.minecraft.server;

public class EntityPhyg extends EntityAetherAnimal
{
    public boolean getSaddled;
    public float wingFold;
    public float wingAngle;
    private float aimingForFold;
    public int jumps;
    public int jrem;
    private boolean jpress;
    private int ticks;
    
    public EntityPhyg(final World world) {
        super(world);
        this.getSaddled = false;
        ((EntityLiving)this).texture = "/aether/mobs/Mob_FlyingPigBase.png";
        this.b(0.9f, 1.3f);
        this.jrem = 0;
        this.jumps = 1;
        this.ticks = 0;
        ((Entity)this).bP = 1.0f;
        ((Entity)this).cd = true;
    }
    
    protected boolean canDespawn() {
        return !this.getSaddled;
    }
    
    protected boolean canTriggerWalking() {
        return ((Entity)this).onGround;
    }
    
    @Override
    protected void entityInit() {
        ((Entity)this).datawatcher.a(16, (Object)0);
        super.entityInit();
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("Jumps", (short)this.jumps);
        nbttagcompound.setShort("Remaining", (short)this.jrem);
        nbttagcompound.setBoolean("getSaddled", this.getSaddled);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.jumps = nbttagcompound.getShort("Jumps");
        this.jrem = nbttagcompound.getShort("Remaining");
        this.getSaddled = nbttagcompound.getBoolean("getSaddled");
        if (this.getSaddled) {
            ((EntityLiving)this).texture = "/aether/mobs/Mob_FlyingPigSaddle.png";
        }
    }
    
    protected void jump() {
        ((Entity)this).motY = 0.6;
    }
    
    public void onUpdate() {
        super.F_();
        if (((Entity)this).onGround) {
            this.wingAngle *= 0.8f;
            this.aimingForFold = 0.1f;
            this.jpress = false;
            this.jrem = this.jumps;
        }
        else {
            this.aimingForFold = 1.0f;
        }
        ++this.ticks;
        this.wingAngle = this.wingFold * (float)Math.sin(this.ticks / 31.830988f);
        this.wingFold += (this.aimingForFold - this.wingFold) / 5.0f;
        ((Entity)this).fallDistance = 0.0f;
        if (((Entity)this).motY < -0.2) {
            ((Entity)this).motY = -0.2;
        }
    }
    
    public void updateEntityActionState() {
        if (((Entity)this).world.isStatic) {
            return;
        }
        if (((Entity)this).passenger != null && ((Entity)this).passenger instanceof EntityLiving) {
            ((EntityLiving)this).aX = 0.0f;
            ((EntityLiving)this).aW = 0.0f;
            ((EntityLiving)this).aZ = false;
            ((Entity)this).passenger.fallDistance = 0.0f;
            final float yaw = ((Entity)this).passenger.yaw;
            ((Entity)this).yaw = yaw;
            ((Entity)this).lastYaw = yaw;
            final float pitch = ((Entity)this).passenger.pitch;
            ((Entity)this).pitch = pitch;
            ((Entity)this).lastPitch = pitch;
            final EntityLiving entityliving = (EntityLiving)((Entity)this).passenger;
            final float f = 3.141593f;
            final float f2 = f / 180.0f;
            if (entityliving.aX > 0.1f) {
                final float f3 = ((Entity)entityliving).yaw * f2;
                ((Entity)this).motX += entityliving.aX * -Math.sin(f3) * 0.17499999701976776;
                ((Entity)this).motZ += entityliving.aX * Math.cos(f3) * 0.17499999701976776;
            }
            else if (entityliving.aX < -0.1f) {
                final float f4 = ((Entity)entityliving).yaw * f2;
                ((Entity)this).motX += entityliving.aX * -Math.sin(f4) * 0.17499999701976776;
                ((Entity)this).motZ += entityliving.aX * Math.cos(f4) * 0.17499999701976776;
            }
            if (entityliving.aW > 0.1f) {
                final float f5 = ((Entity)entityliving).yaw * f2;
                ((Entity)this).motX += entityliving.aW * Math.cos(f5) * 0.17499999701976776;
                ((Entity)this).motZ += entityliving.aW * Math.sin(f5) * 0.17499999701976776;
            }
            else if (entityliving.aW < -0.1f) {
                final float f6 = ((Entity)entityliving).yaw * f2;
                ((Entity)this).motX += entityliving.aW * Math.cos(f6) * 0.17499999701976776;
                ((Entity)this).motZ += entityliving.aW * Math.sin(f6) * 0.17499999701976776;
            }
            if (((Entity)this).onGround && entityliving.aZ) {
                ((Entity)this).onGround = false;
                ((Entity)this).motY = 1.4;
                this.jpress = true;
                --this.jrem;
            }
            else if (this.h_() && entityliving.aZ) {
                ((Entity)this).motY = 0.5;
                this.jpress = true;
                --this.jrem;
            }
            else if (this.jrem > 0 && !this.jpress && entityliving.aZ) {
                ((Entity)this).motY = 1.2;
                this.jpress = true;
                --this.jrem;
            }
            if (this.jpress && !entityliving.aZ) {
                this.jpress = false;
            }
            final double d = Math.abs(Math.sqrt(((Entity)this).motX * ((Entity)this).motX + ((Entity)this).motZ * ((Entity)this).motZ));
            if (d > 0.375) {
                final double d2 = 0.375 / d;
                ((Entity)this).motX *= d2;
                ((Entity)this).motZ *= d2;
            }
            return;
        }
        super.d_();
    }
    
    protected String getLivingSound() {
        return "mob.pig";
    }
    
    protected String getHurtSound() {
        return "mob.pig";
    }
    
    protected String getDeathSound() {
        return "mob.pigdeath";
    }
    
    @Override
    public EntityAnimal spawnBabyAnimal(final EntityAnimal entityanimal) {
        return new EntityPhyg(((Entity)this).world);
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        if (!this.getSaddled && entityplayer.inventory.getItemInHand() != null && entityplayer.inventory.getItemInHand().id == Item.SADDLE.id && !this.isBaby()) {
            entityplayer.inventory.setItem(entityplayer.inventory.itemInHandIndex, (ItemStack)null);
            this.getSaddled = true;
            ((EntityLiving)this).texture = "/aether/mobs/Mob_FlyingPigSaddle.png";
            return true;
        }
        if (this.getSaddled && !((Entity)this).world.isStatic && (((Entity)this).passenger == null || ((Entity)this).passenger == entityplayer)) {
            entityplayer.mount((Entity)this);
            mod_Aether.giveAchievement(AetherAchievements.flyingPig, entityplayer);
            return true;
        }
        return super.b(entityplayer);
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.a(((Entity)this).random.nextBoolean() ? Item.FEATHER.id : Item.PORK.id, 1 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
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
