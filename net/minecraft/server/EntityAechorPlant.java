package net.minecraft.server;

import java.util.*;

public class EntityAechorPlant extends EntityAetherAnimal
{
    public EntityLiving target;
    public int size;
    public int attTime;
    public int smokeTime;
    public boolean seeprey;
    public boolean grounded;
    public boolean noDespawn;
    public float sinage;
    private int poisonLeft;
    
    public EntityAechorPlant(final World world1) {
        super(world1);
        ((EntityLiving)this).texture = "/aether/mobs/aechorplant.png";
        this.size = ((Entity)this).random.nextInt(4) + 1;
        ((EntityLiving)this).health = 10 + this.size * 2;
        this.sinage = ((Entity)this).random.nextFloat() * 6.0f;
        final int n = 0;
        this.attTime = n;
        this.smokeTime = n;
        this.seeprey = false;
        this.b(0.75f + this.size * 0.125f, 0.5f + this.size * 0.075f);
        this.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
        this.poisonLeft = 2;
    }
    
    public int getMaxSpawnedInChunk() {
        return 3;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).world.getTypeId(i, j - 1, k) == AetherBlocks.Grass.id && ((Entity)this).world.getLightLevel(i, j, k) > 8 && super.getCanSpawnHere();
    }
    
    public void onLivingUpdate() {
        if (((EntityLiving)this).health <= 0 || !this.grounded) {
            super.e();
            if (((EntityLiving)this).health <= 0) {
                return;
            }
        }
        else {
            ++((EntityLiving)this).aV;
            this.aG();
        }
        if (((Entity)this).onGround) {
            this.grounded = true;
        }
        if (((EntityLiving)this).hurtTicks > 0) {
            this.sinage += 0.9f;
        }
        else if (this.seeprey) {
            this.sinage += 0.3f;
        }
        else {
            this.sinage += 0.1f;
        }
        if (this.sinage > 6.283186f) {
            this.sinage -= 6.283186f;
        }
        if (this.target == null) {
            final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(10.0, 10.0, 10.0));
            for (int j = 0; j < list.size(); ++j) {
                final Entity entity1 = list.get(j);
                if (entity1 instanceof EntityLiving && !(entity1 instanceof EntityAechorPlant) && !(entity1 instanceof EntityCreeper)) {
                    if (entity1 instanceof EntityPlayer) {
                        final EntityPlayer player1 = (EntityPlayer)entity1;
                        final boolean flag = false;
                        if (flag) {
                            continue;
                        }
                    }
                    this.target = (EntityLiving)entity1;
                    break;
                }
            }
        }
        if (this.target != null) {
            if (((Entity)this.target).dead || this.target.i((Entity)this) > 12.0) {
                this.target = null;
                this.attTime = 0;
            }
            else if (this.target instanceof EntityPlayer) {
                final EntityPlayer player2 = (EntityPlayer)this.target;
                final boolean flag2 = false;
                if (flag2) {
                    this.target = null;
                    this.attTime = 0;
                }
            }
            if (this.target != null && this.attTime >= 20 && this.h((Entity)this.target) && this.target.i((Entity)this) < 5.5 + this.size / 2.0) {
                this.shootTarget();
                this.attTime = -10;
            }
            if (this.attTime < 20) {
                ++this.attTime;
            }
        }
        ++this.smokeTime;
        if (this.smokeTime >= (this.seeprey ? 3 : 8)) {
            this.smokeTime = 0;
            final int i = MathHelper.floor(((Entity)this).locX);
            final int j = MathHelper.floor(((Entity)this).boundingBox.b);
            final int k = MathHelper.floor(((Entity)this).locZ);
            if (((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.Grass.id && this.grounded) {
                ((Entity)this).dead = true;
            }
        }
        this.seeprey = (this.target != null);
    }
    
    public void setDead() {
        if (!this.noDespawn || ((EntityLiving)this).health <= 0) {
            super.die();
        }
    }
    
    public void shootTarget() {
        if (((Entity)this).world.difficulty == 0) {
            return;
        }
        double d1 = ((Entity)this.target).locX - ((Entity)this).locX;
        double d2 = ((Entity)this.target).locZ - ((Entity)this).locZ;
        final double d3 = 1.5 / Math.sqrt(d1 * d1 + d2 * d2 + 0.1);
        final double d4 = 0.1 + Math.sqrt(d1 * d1 + d2 * d2 + 0.1) * 0.5 + (((Entity)this).locY - ((Entity)this.target).locY) * 0.25;
        d1 *= d3;
        d2 *= d3;
        final EntityPoisonNeedle entityarrow = new EntityPoisonNeedle(((Entity)this).world, (EntityLiving)this);
        entityarrow.locY = ((Entity)this).locY + 0.5;
        ((Entity)this).world.addEntity((Entity)entityarrow);
        entityarrow.setArrowHeading(d1, d4, d2, 0.285f + (float)d4 * 0.05f, 1.0f);
    }
    
    protected String getHurtSound() {
        return "damage.hurtflesh";
    }
    
    protected String getDeathSound() {
        return "damage.fallbig";
    }
    
    public void knockBack(final Entity entity, final int ii, final double dd, final double dd1) {
        for (int i = 0; i < 8; ++i) {
            final double d1 = ((Entity)this).locX + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.5;
            final double d2 = ((Entity)this).locY + 0.25 + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.5;
            final double d3 = ((Entity)this).locZ + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.5;
            final double d4 = (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.5;
            final double d5 = (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.5;
            ((Entity)this).world.a("portal", d1, d2, d3, d4, 0.25, d5);
        }
        if (((EntityLiving)this).health > 0) {
            return;
        }
        super.a(entity, ii, dd, dd1);
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        final boolean flag = false;
        final ItemStack stack = entityplayer.inventory.getItemInHand();
        if (stack != null && stack.id == AetherItems.Bucket.id && this.poisonLeft > 0) {
            --this.poisonLeft;
            entityplayer.inventory.setItem(entityplayer.inventory.itemInHandIndex, (ItemStack)null);
            entityplayer.inventory.setItem(entityplayer.inventory.itemInHandIndex, new ItemStack(AetherItems.Bucket, 1, 2));
            return true;
        }
        if (flag) {
            this.noDespawn = true;
            final String s = "heart";
            for (int i = 0; i < 7; ++i) {
                final double d = ((Entity)this).random.nextGaussian() * 0.02;
                final double d2 = ((Entity)this).random.nextGaussian() * 0.02;
                final double d3 = ((Entity)this).random.nextGaussian() * 0.02;
                ((Entity)this).world.a(s, ((Entity)this).locX + ((Entity)this).random.nextFloat() * ((Entity)this).width * 2.0f - ((Entity)this).width, ((Entity)this).locY + 0.5 + ((Entity)this).random.nextFloat() * ((Entity)this).height, ((Entity)this).locZ + ((Entity)this).random.nextFloat() * ((Entity)this).width * 2.0f - ((Entity)this).width, d, d2, d3);
            }
        }
        return false;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setBoolean("Grounded", this.grounded);
        nbttagcompound.setBoolean("NoDespawn", this.noDespawn);
        nbttagcompound.setShort("AttTime", (short)this.attTime);
        nbttagcompound.setShort("Size", (short)this.size);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.grounded = nbttagcompound.getBoolean("Grounded");
        this.noDespawn = nbttagcompound.getBoolean("NoDespawn");
        this.attTime = nbttagcompound.getShort("AttTime");
        this.size = nbttagcompound.getShort("Size");
        this.b(0.75f + this.size * 0.125f, 0.5f + this.size * 0.075f);
        this.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.b(AetherItems.AechorPetal.id, 2 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
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
