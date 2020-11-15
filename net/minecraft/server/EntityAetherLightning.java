package net.minecraft.server;

import java.util.*;

public class EntityAetherLightning extends EntityWeatherLighting
{
    private int lightningState;
    public long a;
    private int boltLivingTime;
    
    public EntityAetherLightning(final World var1, final double var2, final double var4, final double var6) {
        super(var1, var2, var4, var6);
        this.a = 0L;
    }
    
    public void onUpdate() {
        super.F_();
        if (this.lightningState == 2) {
            ((Entity)this).world.makeSound(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, "ambient.weather.thunder", 10000.0f, 0.8f + ((Entity)this).random.nextFloat() * 0.2f);
            ((Entity)this).world.makeSound(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, "random.explode", 2.0f, 0.5f + ((Entity)this).random.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.die();
            }
            else if (this.lightningState < -((Entity)this).random.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.a = ((Entity)this).random.nextLong();
                if (((Entity)this).world.areChunksLoaded(MathHelper.floor(((Entity)this).locX), MathHelper.floor(((Entity)this).locY), MathHelper.floor(((Entity)this).locZ), 10)) {
                    final int var1 = MathHelper.floor(((Entity)this).locX);
                    final int var2 = MathHelper.floor(((Entity)this).locY);
                    final int var3 = MathHelper.floor(((Entity)this).locZ);
                    if (((Entity)this).world.getTypeId(var1, var2, var3) == 0 && Block.FIRE.canPlace(((Entity)this).world, var1, var2, var3)) {
                        ((Entity)this).world.setTypeId(var1, var2, var3, ((Block)Block.FIRE).id);
                    }
                }
            }
        }
        if (this.lightningState >= 0) {
            final double var4 = 3.0;
            final List var5 = ((Entity)this).world.getEntities((Entity)this, AxisAlignedBB.b(((Entity)this).locX - var4, ((Entity)this).locY - var4, ((Entity)this).locZ - var4, ((Entity)this).locX + var4, ((Entity)this).locY + 6.0 + var4, ((Entity)this).locZ + var4));
            for (int var6 = 0; var6 < var5.size(); ++var6) {
                final Entity var7 = (Entity) var5.get(var6);
                if (!(var7 instanceof EntityPlayer)) {
                    var7.a((EntityWeatherLighting)this);
                }
            }
            ((Entity)this).world.n = 2;
        }
    }
}
