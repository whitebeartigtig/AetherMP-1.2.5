package net.minecraft.server;

import net.minecraft.server.*;
import java.util.*;

public class EntityCockatrice extends EntityMonster
{
    public static MinecraftServer mc;
    public float field_752_b;
    public float destPos;
    public float field_757_d;
    public float field_756_e;
    public float field_755_h;
    public int timeUntilNextEgg;
    public int jumps;
    public int jrem;
    public boolean jpress;
    public boolean gotrider;
    
    public EntityCockatrice(final World world) {
        super(world);
        this.destPos = 0.0f;
        this.field_755_h = 1.0f;
        ((Entity)this).bP = 1.0f;
        this.jrem = 0;
        this.jumps = 3;
        ((EntityLiving)this).texture = "/aether/mobs/Cockatrice.png";
        this.b(1.0f, 2.0f);
        ((EntityLiving)this).health = 20;
        this.timeUntilNextEgg = ((Entity)this).random.nextInt(6000) + 6000;
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).random.nextInt(25) == 0 && this.a(i, j, k) >= 0.0f && ((Entity)this).world.containsEntity(((Entity)this).boundingBox) && ((Entity)this).world.getCubes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).world.containsLiquid(((Entity)this).boundingBox) && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.DungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.LockedLightDungeonStone.id && ((Entity)this).world.getTypeId(i, j - 1, k) != AetherBlocks.Holystone.id && ((Entity)this).world.difficulty > 0;
    }
    
    public void onUpdate() {
        super.F_();
        ((Entity)this).cd = (((Entity)this).passenger == EntityCockatrice.mc.thePlayer);
        if (!((Entity)this).world.isStatic && this.gotrider) {
            if (((Entity)this).passenger != null) {
                return;
            }
            final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(0.5, 0.75, 0.5));
            final int i = 0;
            if (i < list.size()) {
                final Entity entity = list.get(i);
                entity.mount((Entity)this);
            }
            this.gotrider = false;
        }
        if (!((Entity)this).world.isStatic && ((Entity)this).world.difficulty == 0) {
            this.die();
        }
    }
    
    protected void attackEntity(final Entity entity, final float f) {
        if (f < 10.0f) {
            final double d = entity.locX - ((Entity)this).locX;
            final double d2 = entity.locZ - ((Entity)this).locZ;
            if (((EntityLiving)this).attackTicks == 0) {
                final EntityPoisonNeedle entityPoisonNeedle;
                final EntityPoisonNeedle entityarrow = entityPoisonNeedle = new EntityPoisonNeedle(((Entity)this).world, (EntityLiving)this);
                entityPoisonNeedle.locY += 1.399999976158142;
                final double d3 = entity.locY + entity.getHeadHeight() - 0.20000000298023224 - entityarrow.locY;
                final float f2 = MathHelper.sqrt(d * d + d2 * d2) * 0.2f;
                ((Entity)this).world.makeSound((Entity)this, "mob.aether.dartshoot", 1.0f, 1.0f / (((Entity)this).random.nextFloat() * 0.4f + 0.8f));
                ((Entity)this).world.addEntity((Entity)entityarrow);
                entityarrow.setArrowHeading(d, d3 + f2, d2, 0.6f, 12.0f);
                ((EntityLiving)this).attackTicks = 30;
            }
            ((Entity)this).yaw = (float)(Math.atan2(d2, d) * 180.0 / 3.1415927410125732) - 90.0f;
            ((EntityCreature)this).e = true;
        }
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
            this.jrem = this.jumps;
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
        if (!((Entity)this).world.isStatic && --this.timeUntilNextEgg <= 0) {
            this.timeUntilNextEgg = ((Entity)this).random.nextInt(6000) + 6000;
        }
    }
    
    protected void fall(final float f) {
    }
    
    public boolean attackEntityFrom(final DamageSource src, final int i) {
        final Entity entity = src.getEntity();
        if (entity != null && ((Entity)this).passenger != null && entity == ((Entity)this).passenger) {
            return false;
        }
        final boolean flag = super.damageEntity(src, i);
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
            final float rotationYaw = ((Entity)this).passenger.yaw;
            ((Entity)this).yaw = rotationYaw;
            ((Entity)this).lastYaw = rotationYaw;
            final float rotationPitch = ((Entity)this).passenger.pitch;
            ((Entity)this).pitch = rotationPitch;
            ((Entity)this).lastPitch = rotationPitch;
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
        nbttagcompound.setShort("Jumps", (short)this.jumps);
        nbttagcompound.setShort("Remaining", (short)this.jrem);
        if (((Entity)this).passenger != null) {
            this.gotrider = true;
        }
        nbttagcompound.setBoolean("GotRider", this.gotrider);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.jumps = nbttagcompound.getShort("Jumps");
        this.jrem = nbttagcompound.getShort("Remaining");
        this.gotrider = nbttagcompound.getBoolean("GotRider");
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
        return true;
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.b(Item.FEATHER.id, 3 * (mod_Aether.equippedSkyrootSword() ? 2 : 1));
    }
    
    static {
        EntityCockatrice.mc = (MinecraftServer) ModLoader.getMinecraftInstance();
    }
}
