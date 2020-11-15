package net.minecraft.server;

import java.util.*;

public class EntityPoisonNeedle extends EntityProjectileBase
{
    public EntityLiving victim;
    public int poisonTime;
    
    public EntityPoisonNeedle(final World world) {
        super(world);
    }
    
    public EntityPoisonNeedle(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }
    
    public EntityPoisonNeedle(final World world, final EntityLiving ent) {
        super(world, ent);
    }
    
    public void entityInit() {
        super.entityInit();
        super.dmg = 0;
        super.speed = 1.5f;
    }
    
    public boolean handleWaterMovement() {
        return this.victim == null && super.h_();
    }
    
    @Override
    public boolean onHitTarget(final Entity entity) {
        if (!(entity instanceof EntityLiving) || !AetherPoison.canPoison(entity)) {
            return super.onHitTarget(entity);
        }
        final EntityLiving ent = (EntityLiving)entity;
        if (!(ent instanceof EntityPlayerSP)) {
            final List list = super.world.getEntities((Entity)this, ((Entity)ent).boundingBox.grow(2.0, 2.0, 2.0));
            for (int i = 0; i < list.size(); ++i) {
                final Entity lr2 = (Entity) list.get(i);
                if (lr2 instanceof EntityPoisonNeedle) {
                    final EntityPoisonNeedle arr = (EntityPoisonNeedle)lr2;
                    if (arr.victim == ent) {
                        arr.poisonTime = 500;
                        arr.dead = false;
                        this.setDead();
                        return false;
                    }
                }
            }
            (this.victim = ent).damageEntity(DamageSource.mobAttack(super.shooter), super.dmg);
            this.poisonTime = 500;
            return false;
        }
        if (((EntityHuman)ModLoader.getMinecraftInstance().thePlayer).abilities.canInstantlyBuild) {
            this.setDead();
            return false;
        }
        AetherPoison.afflictPoison();
        return super.onHitTarget(entity);
    }
    
    @Override
    public void setDead() {
        this.victim = null;
        super.setDead();
    }
    
    @Override
    public boolean onHitBlock() {
        return this.victim == null;
    }
    
    @Override
    public boolean canBeShot(final Entity ent) {
        return super.canBeShot(ent) && this.victim == null;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (super.dead) {
            return;
        }
        if (this.victim != null) {
            if (((Entity)this.victim).dead || this.poisonTime == 0) {
                this.setDead();
                return;
            }
            /*
            final EntityFX fx = (EntityFX)new EntityBreakingFX(super.world, super.locX, super.locY, super.locZ, Item.SLIME_BALL);
            ((Entity)fx).be = 10.0;
            fx.setParticleTextureIndex(94);
            AetherPoison.mc.effectRenderer.addEffect(fx);
            super.dead = false;
            super.inGround = false;
            super.locX = ((Entity)this.victim).locX;
            super.locY = ((Entity)this.victim).boundingBox.b + ((Entity)this.victim).height * 0.8;
            super.locZ = ((Entity)this.victim).locZ;
            AetherPoison.distractEntity((Entity)this.victim);
            --this.poisonTime;
            */
        }
    }

	@Override
	protected void a(NBTTagCompound arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void b(NBTTagCompound arg0) {
		// TODO Auto-generated method stub
		
	}
}
