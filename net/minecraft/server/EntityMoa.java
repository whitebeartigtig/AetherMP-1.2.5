package net.minecraft.server;

import net.minecraft.server.*;

public class EntityMoa extends EntityAetherAnimal
{
    public static MinecraftServer mc;
    public float field_752_b;
    public float destPos;
    public float field_757_d;
    public float field_756_e;
    public float field_755_h;
    public int timeUntilNextEgg;
    public int jrem;
    int petalsEaten;
    boolean wellFed;
    boolean followPlayer;
    public boolean jpress;
    public boolean baby;
    public boolean grown;
    public boolean saddled;
    public MoaColour colour;
    
    public EntityMoa(final World world) {
        this(world, false, false, false);
    }
    
    public EntityMoa(final World world, final boolean babyBool, final boolean grownBool, final boolean saddledBool) {
        this(world, babyBool, grownBool, saddledBool, MoaColour.pickRandomMoa());
    }
    
    public EntityMoa(final World world, final boolean babyBool, final boolean grownBool, final boolean saddledBool, final MoaColour moaColour) {
        super(world);
        this.petalsEaten = 0;
        this.wellFed = false;
        this.followPlayer = false;
        this.baby = false;
        this.grown = false;
        this.saddled = false;
        this.destPos = 0.0f;
        this.field_755_h = 1.0f;
        ((Entity)this).bP = 1.0f;
        this.jrem = 0;
        this.baby = babyBool;
        this.grown = grownBool;
        this.saddled = saddledBool;
        if (this.baby) {
            this.b(0.4f, 0.5f);
        }
        this.colour = moaColour;
        ((EntityLiving)this).texture = this.colour.getTexture(this.saddled);
        this.b(1.0f, 2.0f);
        ((EntityLiving)this).health = 40;
        this.timeUntilNextEgg = ((Entity)this).random.nextInt(6000) + 6000;
    }
    
    public void onUpdate() {
        super.F_();
        ((Entity)this).cd = (((Entity)this).passenger == EntityMoa.mc.thePlayer);
    }
    
    public void onLivingUpdate() {
        super.e();
        this.field_756_e = this.field_752_b;
        this.field_757_d = this.destPos;
        this.destPos += (float)((((Entity)this).onGround ? -1 : 4) * 0.05);
        if (this.destPos < 0.01f) {
            this.destPos = 0.01f;
        }
        if (this.destPos > 1.0f) {
            this.destPos = 1.0f;
        }
        if (((Entity)this).onGround) {
            this.destPos = 0.0f;
            this.jpress = false;
            this.jrem = this.colour.jumps;
        }
        if (!((Entity)this).onGround && this.field_755_h < 1.0f) {
            this.field_755_h = 1.0f;
        }
        this.field_755_h *= (float)0.9;
        if (!((Entity)this).onGround && ((Entity)this).motY < 0.0) {
            if (((Entity)this).passenger == null) {
                ((Entity)this).motY *= 0.6;
            }
            else {
                ((Entity)this).motY *= 0.6375;
            }
        }
        this.field_752_b += this.field_755_h * 2.0f;
        if (!((Entity)this).world.isStatic && !this.baby && --this.timeUntilNextEgg <= 0) {
            ((Entity)this).world.makeSound((Entity)this, "mob.chickenplop", 1.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
            this.a(new ItemStack(AetherItems.MoaEgg, 1, this.colour.ID), 0.0f);
            this.timeUntilNextEgg = ((Entity)this).random.nextInt(6000) + 6000;
        }
        if (this.wellFed && ((Entity)this).random.nextInt(2000) == 0) {
            this.wellFed = false;
        }
        if (this.saddled && ((Entity)this).passenger == null) {
            ((EntityLiving)this).bb = 0.0f;
        }
        else {
            ((EntityLiving)this).bb = 0.7f;
        }
    }
    
    protected void fall(final float f) {
    }
    
    public boolean attackEntityFrom(final EntityLiving entity, final int i) {
        final boolean flag = super.damageEntity(DamageSource.mobAttack(entity), i);
        if (flag && ((Entity)this).passenger != null && (((EntityLiving)this).health <= 0 || ((Entity)this).random.nextInt(3) == 0)) {
            ((Entity)this).passenger.mount((Entity)this);
        }
        return flag;
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
                ((Entity)this).motY = 0.875;
                this.jpress = true;
                --this.jrem;
            }
            else if (this.h_() && entityliving.aZ) {
                ((Entity)this).motY = 0.5;
                this.jpress = true;
                --this.jrem;
            }
            else if (this.jrem > 0 && !this.jpress && entityliving.aZ) {
                ((Entity)this).motY = 0.75;
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
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("Remaining", (short)this.jrem);
        nbttagcompound.setShort("ColourNumber", (short)this.colour.ID);
        nbttagcompound.setBoolean("Baby", this.baby);
        nbttagcompound.setBoolean("Grown", this.grown);
        nbttagcompound.setBoolean("Saddled", this.saddled);
        nbttagcompound.setBoolean("wellFed", this.wellFed);
        nbttagcompound.setInt("petalsEaten", this.petalsEaten);
        nbttagcompound.setBoolean("followPlayer", this.followPlayer);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.jrem = nbttagcompound.getShort("Remaining");
        this.colour = MoaColour.getColour(nbttagcompound.getShort("ColourNumber"));
        this.baby = nbttagcompound.getBoolean("Baby");
        this.grown = nbttagcompound.getBoolean("Grown");
        this.saddled = nbttagcompound.getBoolean("Saddled");
        this.wellFed = nbttagcompound.getBoolean("wellFed");
        this.petalsEaten = nbttagcompound.getInt("petalsEaten");
        this.followPlayer = nbttagcompound.getBoolean("followPlayer");
        if (this.baby) {
            this.grown = false;
            this.saddled = false;
        }
        if (this.grown) {
            this.baby = false;
            this.saddled = false;
        }
        if (this.saddled) {
            this.baby = false;
            this.grown = false;
        }
        ((EntityLiving)this).texture = this.colour.getTexture(this.saddled);
    }
    
    protected String getLivingSound() {
        return "aether.sound.mobs.moa.idleCall";
    }
    
    protected String getHurtSound() {
        return "aether.sound.mobs.moa.idleCall";
    }
    
    protected String getDeathSound() {
        return "aether.sound.mobs.moa.idleCall";
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        if (!this.saddled && this.grown && !this.baby && entityplayer.inventory.getItemInHand() != null && entityplayer.inventory.getItemInHand().id == Item.SADDLE.id) {
            entityplayer.inventory.setItem(entityplayer.inventory.itemInHandIndex, (ItemStack)null);
            this.saddled = true;
            this.grown = false;
            ((EntityLiving)this).texture = this.colour.getTexture(this.saddled);
            return true;
        }
        if (this.saddled && !((Entity)this).world.isStatic && (((Entity)this).passenger == null || ((Entity)this).passenger == entityplayer)) {
            entityplayer.mount((Entity)this);
            final float yaw = ((Entity)this).yaw;
            ((Entity)entityplayer).yaw = yaw;
            ((Entity)entityplayer).lastYaw = yaw;
            return true;
        }
        if (!this.wellFed && !this.saddled && this.baby && !this.grown) {
            final ItemStack itemstack = entityplayer.inventory.getItemInHand();
            if (itemstack != null && itemstack.id == AetherItems.AechorPetal.id) {
                ++this.petalsEaten;
                entityplayer.inventory.splitStack(entityplayer.inventory.itemInHandIndex, 1);
                if (this.petalsEaten > this.colour.jumps) {
                    this.grown = true;
                    this.baby = false;
                }
                this.wellFed = true;
            }
            return true;
        }
        if (!this.saddled && (this.baby || this.grown)) {
            if (!this.followPlayer) {
                this.followPlayer = true;
                ((EntityCreature)this).target = (Entity)entityplayer;
            }
            else {
                this.followPlayer = false;
                ((EntityCreature)this).target = null;
            }
        }
        return true;
    }
    
    public boolean canDespawn() {
        return !this.baby && !this.grown && !this.saddled;
    }
    
    protected boolean canTriggerWalking() {
        return ((Entity)this).onGround;
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.a(Item.FEATHER.id, 3 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    static {
        EntityMoa.mc = (MinecraftServer) ModLoader.getMinecraftInstance();
    }

	@Override
	public EntityAnimal createChild(EntityAnimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
