package net.minecraft.server;

import java.util.*;
import java.io.*;

public class Whirly extends EntityAetherAnimal
{
    public int entcount;
    public int Life;
    public List fluffies;
    public EffectRenderer Enty;
    public static final float pie = 3.141593f;
    public static final float pia = 0.01745329f;
    public float Angle;
    public float Speed;
    public float Curve;
    public boolean evil;
    
    public Whirly(final World world) {
        super(world);
        this.entcount = 0;
        this.b(0.6f, 0.8f);
        this.setPosition((()this).locX, (()this).locY, (()this).locZ);
        ((EntityLiving)this).bb = 0.6f;
        this.Angle = (()this).random.nextFloat() * 360.0f;
        this.Speed = (()this).random.nextFloat() * 0.025f + 0.025f;
        this.Curve = ((()this).random.nextFloat() - (()this).random.nextFloat()) * 0.1f;
        this.Life = (()this).random.nextInt(512) + 512;
        if ((()this).random.nextInt(10) == 0 && !this.shouldStopEvil()) {
            this.evil = true;
            this.Life /= 2;
        }
        this.fluffies = new ArrayList();
        this.Enty = ModLoader.getMinecraftInstance().effectRenderer;
    }
    
    public boolean canTriggerWalking() {
        return false;
    }
    
    public boolean shouldStopEvil() {
        if (!((()this).world.dataManager instanceof SaveHandler)) {
            return false;
        }
        final File file = new File(((SaveHandler)(()this).world.saveHandler).getSaveDirectory(), "stopevil.txt");
        return file.exists();
    }
    
    public void updateEntityActionState() {
        boolean flag = false;
        if (this.evil) {
            final EntityPlayer entityplayer = (EntityPlayer)this.getPlayer();
            if (entityplayer != null && (()entityplayer).onGround) {
                ((EntityCreature)this).target = ()entityplayer;
                flag = true;
            }
        }
        if (((EntityCreature)this).target == null) {
            (()this).motX = Math.cos(0.01745329f * this.Angle) * this.Speed;
            (()this).motZ = -Math.sin(0.01745329f * this.Angle) * this.Speed;
            this.Angle += this.Curve;
        }
        else {
            super.d_();
        }
        final List list = (()this).world.getEntities(()this, (()this).boundingBox.grow(2.5, 2.5, 2.5));
        if (this.Life-- <= 0 || this.h_()) {
            this.setDead();
        }
        if (this.getPlayer() != null) {
            ++this.entcount;
        }
        if (this.entcount >= 128) {
            if (this.evil && ((EntityCreature)this).target != null) {
                final EntityCreeper entitycreeper = new EntityCreeper((()this).world);
                entitycreeper.setPositionRotation((()this).locX, (()this).locY - 0.75, (()this).locZ, (()this).random.nextFloat() * 360.0f, 0.0f);
                (()entitycreeper).motX = ((()this).random.nextFloat() - (()this).random.nextFloat()) * 0.125;
                (()entitycreeper).motZ = ((()this).random.nextFloat() - (()this).random.nextFloat()) * 0.125;
                (()this).world.addEntity(()entitycreeper);
                this.entcount = 0;
            }
            else {
                final int i = this.loot();
                if (i != 0) {
                    this.b(i, 1);
                    this.entcount = 0;
                }
            }
        }
        if (!flag && ((EntityCreature)this).target == null) {
            for (int j = 0; j < 2; ++j) {
                final double d1 = (float)(()this).locX + (()this).random.nextFloat() * 0.25f;
                final double d2 = (float)(()this).locY + (()this).height + 0.125f;
                final double d3 = (float)(()this).locZ + (()this).random.nextFloat() * 0.25f;
                final float f = (()this).random.nextFloat() * 360.0f;
                final EntityExplodeFX entityexplodefx = new EntityExplodeFX((()this).world, -Math.sin(0.01745329f * f) * 0.75, d2 - 0.25, Math.cos(0.01745329f * f) * 0.75, d1, 0.125, d3);
                this.Enty.addEffect((EntityFX)entityexplodefx);
                this.fluffies.add(entityexplodefx);
                (()entityexplodefx).renderDistanceWeight = 10.0;
                (()entityexplodefx).noClip = true;
                entityexplodefx.b(0.25f, 0.25f);
                entityexplodefx.setPosition((()this).locX, (()this).locY, (()this).locZ);
                (()entityexplodefx).locY = d2;
            }
        }
        else {
            for (int k = 0; k < 3; ++k) {
                final double d4 = (float)(()this).locX + (()this).random.nextFloat() * 0.25f;
                final double d5 = (float)(()this).locY + (()this).height + 0.125f;
                final double d6 = (float)(()this).locZ + (()this).random.nextFloat() * 0.25f;
                final float f2 = (()this).random.nextFloat() * 360.0f;
                final EntitySmokeFX entitysmokefx = new EntitySmokeFX((()this).world, -Math.sin(0.01745329f * f2) * 0.75, d5 - 0.25, Math.cos(0.01745329f * f2) * 0.75, d4, 0.125, d6, 3.5f);
                this.Enty.addEffect((EntityFX)entitysmokefx);
                this.fluffies.add(entitysmokefx);
                (()entitysmokefx).renderDistanceWeight = 10.0;
                (()entitysmokefx).noClip = true;
                entitysmokefx.b(0.25f, 0.25f);
                entitysmokefx.setPosition((()this).locX, (()this).locY, (()this).locZ);
                (()entitysmokefx).locY = d5;
            }
        }
        final double d7 = (float)(()this).locX;
        final double d8 = (float)(()this).locY;
        final double d9 = (float)(()this).locZ;
        for (int l = 0; l < list.size(); ++l) {
            final  entity = list.get(l);
            final double d10 = (float)entity.locX;
            final double d11 = (float)entity.locY - entity.yOffset * 0.6f;
            final double d12 = (float)entity.locZ;
            double d13 = this.getDistanceToEntity(entity);
            final double d14 = d11 - d8;
            if (d13 <= 1.5 + d14) {
                entity.motionY = 0.15000000596046448;
                entity.fallDistance = 0.0f;
                if (d14 > 1.5) {
                    entity.motionY = -0.44999998807907104 + d14 * 0.3499999940395355;
                    d13 += d14 * 1.5;
                    if (entity == ((EntityCreature)this).target) {
                        ((EntityCreature)this).target = null;
                        this.setPathToEntity((PathEntity)null);
                    }
                }
                else {
                    entity.motionY = 0.125;
                }
                double d15 = Math.atan2(d7 - d10, d9 - d12) / 0.01745329424738884;
                d15 += 160.0;
                entity.motX = -Math.cos(0.01745329424738884 * d15) * (d13 + 0.25) * 0.10000000149011612;
                entity.motZ = Math.sin(0.01745329424738884 * d15) * (d13 + 0.25) * 0.10000000149011612;
                if (entity instanceof Whirly) {
                    entity.setDead();
                    if (!this.shouldStopEvil() && !this.evil) {
                        this.evil = true;
                        this.Life /= 2;
                    }
                }
            }
            else {
                final double d16 = Math.atan2(d7 - d10, d9 - d12) / 0.01745329424738884;
                final  entity2 = entity;
                entity2.motX += Math.sin(0.01745329424738884 * d16) * 0.009999999776482582;
                final  entity3 = entity;
                entity3.motZ += Math.cos(0.01745329424738884 * d16) * 0.009999999776482582;
            }
            final int j2 = MathHelper.floor((()this).locX);
            final int k2 = MathHelper.floor((()this).locY);
            final int l2 = MathHelper.floor((()this).locZ);
            if ((()this).world.getBlockId(j2, k2 + 1, l2) != 0) {
                this.Life -= 50;
            }
            final int i2 = j2 - 1 + (()this).random.nextInt(3);
            final int j3 = k2 + (()this).random.nextInt(5);
            final int k3 = l2 - 1 + (()this).random.nextInt(3);
            if ((()this).world.getBlockId(i2, j3, k3) == ((Block)Block.leaves).blockID) {
                (()this).world.setBlockWithNotify(i2, j3, k3, 0);
            }
        }
        if (this.fluffies.size() > 0) {
            for (int i3 = 0; i3 < this.fluffies.size(); ++i3) {
                final EntityFX entityfx = this.fluffies.get(i3);
                if ((()entityfx).isDead) {
                    this.fluffies.remove(entityfx);
                }
                else {
                    final double d17 = (float)(()entityfx).locX;
                    final double d18 = (float)(()entityfx).boundingBox.b;
                    final double d19 = (float)(()entityfx).locZ;
                    final double d20 = this.getDistanceToEntity(()entityfx);
                    final double d21 = d18 - d8;
                    (()entityfx).motionY = 0.11500000208616257;
                    double d22 = Math.atan2(d7 - d17, d9 - d19) / 0.01745329424738884;
                    d22 += 160.0;
                    (()entityfx).motX = -Math.cos(0.01745329424738884 * d22) * (d20 * 2.5 - d21) * 0.10000000149011612;
                    (()entityfx).motZ = Math.sin(0.01745329424738884 * d22) * (d20 * 2.5 - d21) * 0.10000000149011612;
                }
            }
        }
    }
    
    public int loot() {
        final int i = (()this).random.nextInt(100) + 1;
        if (i == 100) {
            return Item.diamond.shiftedIndex;
        }
        if (i >= 96) {
            return Item.ingotIron.shiftedIndex;
        }
        if (i >= 91) {
            return Item.ingotGold.shiftedIndex;
        }
        if (i >= 82) {
            return Item.coal.shiftedIndex;
        }
        if (i >= 75) {
            return Block.gravel.blockID;
        }
        if (i >= 64) {
            return Block.blockClay.blockID;
        }
        if (i >= 52) {
            return Item.stick.shiftedIndex;
        }
        if (i >= 38) {
            return Item.flint.shiftedIndex;
        }
        if (i > 20) {
            return Block.wood.blockID;
        }
        return Block.sand.blockID;
    }
    
    public void setDead() {
        if (this.fluffies.size() > 0) {
            for (int i = 0; i < this.fluffies.size(); ++i) {
                final EntityFX entityFX;
                final EntityFX entityfx = entityFX = this.fluffies.get(i);
                (()entityFX).motX *= 0.5;
                final EntityFX entityFX2 = entityfx;
                (()entityFX2).motionY *= 0.75;
                final EntityFX entityFX3 = entityfx;
                (()entityFX3).motZ *= 0.5;
                this.fluffies.remove(entityfx);
            }
        }
        super.setDead();
    }
    
    @Override
    public boolean getCanSpawnHere() {
        if ((()this).locY < 64.0) {
            (()this).locY += 64.0;
        }
        if (!(()this).world.containsEntity((()this).boundingBox) || (()this).world.getCollidingBoundingBoxes(()this, (()this).boundingBox).size() != 0 || (()this).world.isAnyLiquid((()this).boundingBox)) {
            return false;
        }
        final int i = MathHelper.floor((()this).locX);
        final int j = MathHelper.floor((()this).boundingBox.b);
        final int k = MathHelper.floor((()this).locZ);
        boolean flag = true;
        for (int l = 1; l < 20; ++l) {
            if (l + j >= 125) {
                break;
            }
            if ((()this).world.getBlockLightValue(i, j + l, k) <= 12 || (()this).world.getBlockId(i, j + l, k) != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    public  getPlayer() {
        final EntityPlayer entityplayer = (()this).world.getClosestPlayerToEntity(()this, 16.0);
        if (entityplayer != null && this.canEntityBeSeen(()entityplayer)) {
            return ()entityplayer;
        }
        return null;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setFloat("Angle", this.Angle);
        nbttagcompound.setFloat("Speed", this.Speed);
        nbttagcompound.setFloat("Curve", this.Curve);
        nbttagcompound.setShort("Life", (short)this.Life);
        nbttagcompound.setShort("Counter", (short)this.entcount);
        nbttagcompound.setBoolean("Evil", this.evil);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.Angle = nbttagcompound.getFloat("Angle");
        this.Speed = nbttagcompound.getFloat("Speed");
        this.Curve = nbttagcompound.getFloat("Curve");
        this.Life = nbttagcompound.getShort("Life");
        this.entcount = nbttagcompound.getShort("Counter");
        this.evil = nbttagcompound.getBoolean("Evil");
    }
    
    public boolean attackEntityFrom(final entity, final int i) {
        return false;
    }
    
    public void applyEntityCollision(final entity) {
    }
    
    public int getMaxSpawnedInChunk() {
        return 1;
    }
    
    public boolean isOnLadder() {
        return (()this).isCollidedHorizontally;
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
