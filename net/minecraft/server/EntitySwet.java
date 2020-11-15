package net.minecraft.server;

import java.util.*;

public class EntitySwet extends EntityAetherAnimal
{
    public int ticker;
    public int flutter;
    public int hops;
    public int textureNum;
    public boolean textureSet;
    public boolean gotrider;
    public boolean kickoff;
    public boolean friendly;
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    public EntitySwet(final World world) {
        super(world);
        ((EntityLiving)this).health = 25;
        if (!this.textureSet) {
            if (((Entity)this).random.nextInt(2) == 0) {
                this.textureNum = 2;
                this.textureSet = true;
            }
            else {
                this.textureNum = 1;
                this.textureSet = true;
            }
        }
        if (this.textureNum == 1) {
            ((EntityLiving)this).texture = "/aether/mobs/swets.png";
            ((EntityLiving)this).bb = 1.5f;
        }
        else {
            ((EntityLiving)this).texture = "/aether/mobs/goldswets.png";
            ((EntityLiving)this).bb = 3.0f;
        }
        this.b(0.8f, 0.8f);
        this.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
        this.hops = 0;
        this.gotrider = false;
        this.flutter = 0;
        this.ticker = 0;
    }
    
    public void updateRidden() {
        super.R();
        if (((Entity)this).passenger != null && this.kickoff) {
            ((Entity)this).passenger.mount((Entity)this);
            this.kickoff = false;
        }
    }
    
    public void updateRiderPosition() {
        ((Entity)this).passenger.setPosition(((Entity)this).locX, ((Entity)this).boundingBox.b - 0.30000001192092896 + ((Entity)this).passenger.height, ((Entity)this).locZ);
    }
    
    public void onUpdate() {
        if (((EntityCreature)this).target != null) {
            for (int i = 0; i < 3; ++i) {
                final float f = 0.01745278f;
                final double d = (float)((Entity)this).locX + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.3f;
                final double d2 = (float)((Entity)this).locY + ((Entity)this).height;
                final double d3 = (float)((Entity)this).locZ + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.3f;
                ((Entity)this).world.a("splash", d, d2 - 0.25, d3, 0.0, 0.0, 0.0);
            }
        }
        super.F_();
        if (this.gotrider) {
            if (((Entity)this).passenger != null) {
                return;
            }
            final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(0.5, 0.75, 0.5));
            final int j = 0;
            if (j < list.size()) {
                final Entity entity = (Entity) list.get(j);
                this.capturePrey(entity);
            }
            this.gotrider = false;
        }
        if (this.h_()) {
            this.dissolve();
        }
    }
    
    protected boolean canDespawn() {
        return true;
    }
    
    public void fall(final float f) {
        if (this.friendly) {
            return;
        }
        super.a(f);
        if (this.hops >= 3 && ((EntityLiving)this).health > 0) {
            this.dissolve();
        }
    }
    
    public void knockBack(final Entity entity, final int i, final double d, final double d1) {
        if (((Entity)this).passenger != null && entity == ((Entity)this).passenger) {
            return;
        }
        super.a(entity, i, d, d1);
    }
    
    public void dissolve() {
        for (int i = 0; i < 50; ++i) {
            final float f = ((Entity)this).random.nextFloat() * 3.141593f * 2.0f;
            final float f2 = ((Entity)this).random.nextFloat() * 0.5f + 0.25f;
            final float f3 = MathHelper.sin(f) * f2;
            final float f4 = MathHelper.cos(f) * f2;
            ((Entity)this).world.a("splash", ((Entity)this).locX + f3, ((Entity)this).boundingBox.b + 1.25, ((Entity)this).locZ + f4, f3 * 1.5 + ((Entity)this).motX, 4.0, f4 * 1.5 + ((Entity)this).motZ);
        }
        if (((Entity)this).passenger != null) {
            final Entity passenger = ((Entity)this).passenger;
            passenger.locY += ((Entity)this).passenger.height - 0.3f;
            ((Entity)this).passenger.mount((Entity)this);
        }
        this.die();
    }
    
    public void die() {
        super.die();
    }
    
    public void capturePrey(final Entity entity) {
        this.splorch();
        final double locX = entity.locX;
        ((Entity)this).locX = locX;
        ((Entity)this).lastX = locX;
        final double n = entity.locY + 0.009999999776482582;
        ((Entity)this).locY = n;
        ((Entity)this).lastY = n;
        final double locZ = entity.locZ;
        ((Entity)this).locZ = locZ;
        ((Entity)this).lastZ = locZ;
        final float yaw = entity.yaw;
        ((Entity)this).yaw = yaw;
        ((Entity)this).lastYaw = yaw;
        final float pitch = entity.pitch;
        ((Entity)this).pitch = pitch;
        ((Entity)this).lastPitch = pitch;
        ((Entity)this).motX = entity.motX;
        ((Entity)this).motY = entity.motY;
        ((Entity)this).motZ = entity.motZ;
        this.b(entity.width, entity.height);
        this.setPosition(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ);
        entity.mount((Entity)this);
        ((Entity)this).yaw = ((Entity)this).random.nextFloat() * 360.0f;
    }
    
    public boolean damageEntity(final EntityLiving entity, final int i) {
        if (this.hops == 3 && entity == null && ((EntityLiving)this).health > 1) {
            ((EntityLiving)this).health = 1;
        }
        final boolean flag = super.damageEntity(DamageSource.mobAttack(entity), i);
        if (flag && ((Entity)this).passenger != null && ((Entity)this).passenger instanceof EntityLiving) {
            if (entity != null && ((Entity)this).passenger == entity) {
                if (((Entity)this).random.nextInt(3) == 0) {
                    this.kickoff = true;
                }
            }
            else {
                ((Entity)this).passenger.damageEntity(DamageSource.mobAttack((EntityLiving)this), i);
                if (((EntityLiving)this).health <= 0) {
                    this.kickoff = true;
                }
            }
        }
        if (flag && ((EntityLiving)this).health <= 0) {
            this.dissolve();
        }
        else if (flag && entity instanceof EntityLiving) {
            final EntityLiving entityliving = entity;
            if (entityliving.health > 0 && (((Entity)this).passenger == null || entityliving != ((Entity)this).passenger)) {
                this.a(((EntityCreature)this).target = (Entity)entity, 180.0f, 180.0f);
                this.kickoff = true;
            }
        }
        if (this.friendly && ((EntityCreature)this).target instanceof EntityPlayer) {
            ((EntityCreature)this).target = null;
        }
        return flag;
    }
    
    public void d_2() {
        if (((Entity)this).passenger != null && ((Entity)this).passenger instanceof EntityLiving) {
            ((EntityLiving)this).aX = 0.0f;
            ((EntityLiving)this).aW = 0.0f;
            ((EntityLiving)this).aZ = false;
            ((Entity)this).passenger.fallDistance = 0.0f;
            final float yaw = ((Entity)this).passenger.yaw;
            ((Entity)this).yaw = yaw;
            ((Entity)this).lastYaw = yaw;
            final float n = 0.0f;
            ((Entity)this).pitch = n;
            ((Entity)this).lastPitch = n;
            final EntityLiving entityliving = (EntityLiving)((Entity)this).passenger;
            final float f = 3.141593f;
            final float f2 = f / 180.0f;
            final float f3 = ((Entity)entityliving).yaw * f2;
            if (((Entity)this).onGround) {
                if (entityliving.aZ) {
                    if (this.hops == 0) {
                        ((Entity)this).onGround = false;
                        ((Entity)this).motY = 0.8500000238418579;
                        this.hops = 1;
                        this.flutter = 5;
                    }
                    else if (this.hops == 1) {
                        ((Entity)this).onGround = false;
                        ((Entity)this).motY = 1.0499999523162842;
                        this.hops = 2;
                        this.flutter = 5;
                    }
                    else if (this.hops == 2) {
                        ((Entity)this).onGround = false;
                        ((Entity)this).motY = 1.25;
                        this.flutter = 5;
                    }
                }
                else if (entityliving.aX > 0.125f || entityliving.aX < -0.125f || entityliving.aW > 0.125f || entityliving.aW < -0.125f) {
                    ((Entity)this).onGround = false;
                    ((Entity)this).motY = 0.3499999940395355;
                    this.hops = 0;
                    this.flutter = 0;
                }
                else if (this.hops > 0) {
                    this.hops = 0;
                }
                entityliving.aX = 0.0f;
                entityliving.aW = 0.0f;
            }
            else {
                if (entityliving.aX > 0.1f) {
                    if (this.textureNum == 1) {
                        ((Entity)this).motX += entityliving.aX * -Math.sin(f3) * 0.125;
                        ((Entity)this).motZ += entityliving.aX * Math.cos(f3) * 0.125;
                    }
                    else {
                        ((Entity)this).motX += entityliving.aX * -Math.sin(f3) * 0.325;
                        ((Entity)this).motZ += entityliving.aX * Math.cos(f3) * 0.125;
                    }
                }
                else if (entityliving.aX < -0.1f) {
                    if (this.textureNum == 1) {
                        ((Entity)this).motX += entityliving.aX * -Math.sin(f3) * 0.125;
                        ((Entity)this).motZ += entityliving.aX * Math.cos(f3) * 0.125;
                    }
                    else {
                        ((Entity)this).motX += entityliving.aX * -Math.sin(f3) * 0.325;
                        ((Entity)this).motZ += entityliving.aX * Math.cos(f3) * 0.125;
                    }
                }
                if (entityliving.aW > 0.1f) {
                    if (this.textureNum == 1) {
                        ((Entity)this).motX += entityliving.aW * Math.cos(f3) * 0.125;
                        ((Entity)this).motZ += entityliving.aW * Math.sin(f3) * 0.125;
                    }
                    else {
                        ((Entity)this).motX += entityliving.aW * Math.cos(f3) * 0.325;
                        ((Entity)this).motZ += entityliving.aW * Math.sin(f3) * 0.125;
                    }
                }
                else if (entityliving.aW < -0.1f) {
                    if (this.textureNum == 1) {
                        ((Entity)this).motX += entityliving.aW * Math.cos(f3) * 0.125;
                        ((Entity)this).motZ += entityliving.aW * Math.sin(f3) * 0.125;
                    }
                    else {
                        ((Entity)this).motX += entityliving.aW * Math.cos(f3) * 0.325;
                        ((Entity)this).motZ += entityliving.aW * Math.sin(f3) * 0.125;
                    }
                }
                if (((Entity)this).motY < 0.05000000074505806 && this.flutter > 0 && entityliving.aZ) {
                    ((Entity)this).motY += 0.07000000029802322;
                    --this.flutter;
                }
            }
            final double d = Math.abs(Math.sqrt(((Entity)this).motX * ((Entity)this).motX + ((Entity)this).motZ * ((Entity)this).motZ));
            if (d > 0.2750000059604645) {
                final double d2 = 0.275 / d;
                ((Entity)this).motX *= d2;
                ((Entity)this).motZ *= d2;
            }
        }
    }
    
    public void updateEntityActionState() {
        ++((EntityLiving)this).aV;
        this.aG();
        if (this.friendly && ((Entity)this).passenger != null) {
            this.d_2();
            return;
        }
        if (!((Entity)this).onGround && ((EntityLiving)this).aZ) {
            ((EntityLiving)this).aZ = false;
        }
        else if (((Entity)this).onGround) {
            if (((EntityLiving)this).aX > 0.05f) {
                ((EntityLiving)this).aX *= 0.75f;
            }
            else {
                ((EntityLiving)this).aX = 0.0f;
            }
        }
        if (((EntityCreature)this).target != null && ((Entity)this).passenger == null && ((EntityLiving)this).health > 0) {
            this.a(((EntityCreature)this).target, 10.0f, 10.0f);
        }
        if (((EntityCreature)this).target != null && ((EntityCreature)this).target.dead) {
            ((EntityCreature)this).target = null;
        }
        if (!((Entity)this).onGround && ((Entity)this).motY < 0.05000000074505806 && this.flutter > 0) {
            ((Entity)this).motY += 0.07000000029802322;
            --this.flutter;
        }
        if (this.ticker < 4) {
            ++this.ticker;
        }
        else {
            if (((Entity)this).onGround && ((Entity)this).passenger == null && this.hops != 0 && this.hops != 3) {
                this.hops = 0;
            }
            if (((EntityCreature)this).target == null && ((Entity)this).passenger == null) {
                final Entity entity = this.getPrey();
                if (entity != null) {
                    ((EntityCreature)this).target = entity;
                }
            }
            else if (((EntityCreature)this).target != null && ((Entity)this).passenger == null) {
                if (this.i(((EntityCreature)this).target) <= 9.0f) {
                    if (((Entity)this).onGround && this.h(((EntityCreature)this).target)) {
                        this.splotch();
                        this.flutter = 10;
                        ((EntityLiving)this).aZ = true;
                        ((EntityLiving)this).aX = 1.0f;
                        ((Entity)this).yaw += 5.0f * (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat());
                    }
                }
                else {
                    ((EntityCreature)this).target = null;
                    ((EntityLiving)this).aZ = false;
                    ((EntityLiving)this).aX = 0.0f;
                }
            }
            else if (((Entity)this).passenger != null && ((Entity)this).onGround) {
                if (this.hops == 0) {
                    this.splotch();
                    ((Entity)this).onGround = false;
                    ((Entity)this).motY = 0.3499999940395355;
                    ((EntityLiving)this).aX = 0.8f;
                    this.hops = 1;
                    this.flutter = 5;
                    ((Entity)this).yaw += 20.0f * (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat());
                }
                else if (this.hops == 1) {
                    this.splotch();
                    ((Entity)this).onGround = false;
                    ((Entity)this).motY = 0.44999998807907104;
                    ((EntityLiving)this).aX = 0.9f;
                    this.hops = 2;
                    this.flutter = 5;
                    ((Entity)this).yaw += 20.0f * (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat());
                }
                else if (this.hops == 2) {
                    this.splotch();
                    ((Entity)this).onGround = false;
                    ((Entity)this).motY = 1.25;
                    ((EntityLiving)this).aX = 1.25f;
                    this.hops = 3;
                    this.flutter = 5;
                    ((Entity)this).yaw += 20.0f * (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat());
                }
            }
            this.ticker = 0;
        }
        if (((Entity)this).onGround && this.hops >= 3) {
            this.dissolve();
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("Hops", (short)this.hops);
        nbttagcompound.setShort("Flutter", (short)this.flutter);
        if (((Entity)this).passenger != null) {
            this.gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", this.gotrider);
        nbttagcompound.setBoolean("Friendly", this.friendly);
        nbttagcompound.setBoolean("textureSet", this.textureSet);
        nbttagcompound.setShort("textureNum", (short)this.textureNum);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.hops = nbttagcompound.getShort("Hops");
        this.flutter = nbttagcompound.getShort("Flutter");
        this.gotrider = nbttagcompound.getBoolean("GotRider");
        this.friendly = nbttagcompound.getBoolean("Friendly");
        this.textureSet = nbttagcompound.getBoolean("textureSet");
        this.textureNum = nbttagcompound.getShort("textureNum");
        if (this.textureNum == 1) {
            ((EntityLiving)this).texture = "/aether/mobs/swets.png";
            ((EntityLiving)this).bb = 1.5f;
        }
        else {
            ((EntityLiving)this).texture = "/aether/mobs/goldswets.png";
            ((EntityLiving)this).bb = 3.0f;
        }
    }
    
    public void splorch() {
        ((Entity)this).world.makeSound((Entity)this, "mob.slimeattack", 1.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
    }
    
    public void splotch() {
        ((Entity)this).world.makeSound((Entity)this, "mob.slime", 0.5f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
    }
    
    protected String getHurtSound() {
        return "mob.slime";
    }
    
    protected String getDeathSound() {
        return "mob.slime";
    }
    
    public void collide(final Entity entity) {
        if (this.hops == 0 && ((Entity)this).passenger == null && ((EntityCreature)this).target != null && entity != null && entity == ((EntityCreature)this).target && (entity.vehicle == null || !(entity.vehicle instanceof EntitySwet))) {
            if (entity.passenger != null) {
                entity.passenger.mount(entity);
            }
            this.capturePrey(entity);
        }
        super.collide(entity);
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        if (!((Entity)this).world.isStatic) {
            if (!this.friendly) {
                this.friendly = true;
                ((EntityCreature)this).target = null;
                return true;
            }
            if ((this.friendly && ((Entity)this).passenger == null) || ((Entity)this).passenger == entityplayer) {
                this.capturePrey((Entity)entityplayer);
            }
        }
        return true;
    }
    
    protected Entity getPrey() {
        final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(6.0, 6.0, 6.0));
        for (int i = 0; i < list.size(); ++i) {
            final Entity entity = (Entity) list.get(i);
            if (entity instanceof EntityLiving && !(entity instanceof EntitySwet)) {
                if (this.friendly) {
                    if (entity instanceof EntityPlayer) {
                        continue;
                    }
                }
                else if (entity instanceof EntityMonster) {
                    continue;
                }
                return entity;
            }
        }
        return null;
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        final ItemStack stack = new ItemStack((this.textureNum == 1) ? AetherItems.SwetBall.id : AetherItems.SwetBall.id, 6, (int)((this.textureNum == 1) ? 1 : 0));
        if (mod_Aether.equippedSkyrootSword()) {
            final ItemStack itemStack = stack;
            itemStack.count *= 2;
        }
        this.a(stack, 0.0f);
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
