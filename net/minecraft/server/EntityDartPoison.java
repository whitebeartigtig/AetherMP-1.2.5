package net.minecraft.server;

import java.util.*;

public class EntityDartPoison extends EntityDartGolden
{
    public EntityLiving victim;
    public int poisonTime;
    
    public EntityDartPoison(final World world) {
        super(world);
    }
    
    public EntityDartPoison(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }
    
    public EntityDartPoison(final World world, final EntityLiving ent) {
        super(world, ent);
    }
    
    @Override
    public void entityInit() {
        super.entityInit();
        super.item = new ItemStack(AetherItems.Dart, 1, 1);
        super.dmg = 2;
    }
    
    @Override
    public boolean onHitTarget(final Entity entity) {
        if (!(entity instanceof EntityLiving) || !AetherPoison.canPoison(entity)) {
            return super.onHitTarget(entity);
        }
        final EntityLiving ent = (EntityLiving)entity;
        if (!(ent instanceof EntityHuman)) {
            final List list = super.world.getEntities((Entity)this, ((Entity)ent).boundingBox.grow(2.0, 2.0, 2.0));
            for (int i = 0; i < list.size(); ++i) {
                final Entity lr2 = (Entity) list.get(i);
                if (lr2 instanceof EntityDartPoison) {
                    final EntityDartPoison arr = (EntityDartPoison)lr2;
                    if (arr.victim == ent) {
                        arr.poisonTime = 500;
                        arr.dead = false;
                        ent.damageEntity(DamageSource.projectile((Entity)super.shooter, (Entity)this), super.dmg);
                        this.setDead();
                        return false;
                    }
                }
            }
            (this.victim = ent).damageEntity(DamageSource.mobAttack(super.shooter), super.dmg);
            this.poisonTime = 500;
            return false;
        }
        /*
        if (((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer).abilities.canInstantlyBuild) {
            this.setDead();
            return false;
        }
        
        AetherPoison.afflictPoison();
        return super.onHitTarget(entity);
        */
		return inGround;
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
            if (this.poisonTime % 50 == 0) {
                this.victim.damageEntity(DamageSource.projectile((Entity)this, (Entity)super.shooter), 1);
            }
            */
        }
    }
}
