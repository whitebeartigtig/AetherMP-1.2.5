package net.minecraft.server;

public abstract class EntityAetherAnimal extends EntityAnimal
{
    public EntityAetherAnimal(final World world) {
        super(world);
    }
    
    protected void entityInit() {
        super.b();
    }
    
    public float getBlockPathWeight(final int i, final int j, final int k) {
        float wieght = 0.0f;
        if (((Entity)this).world.getTypeId(i, j - 1, k) == AetherBlocks.Grass.id) {
            wieght += 10.0f;
        }
        wieght += ((Entity)this).world.p(i, j, k) - 0.5f;
        wieght += (float)(j - ((Entity)this).locY);
        return wieght;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).world.containsEntity(((Entity)this).boundingBox) && ((Entity)this).world.getCubes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).world.containsLiquid(((Entity)this).boundingBox) && ((Entity)this).world.getTypeId(i, j - 1, k) == AetherBlocks.Grass.id && ((Entity)this).world.m(i, j, k) > 8 && this.getBlockPathWeight(i, j, k) >= 0.0f;
    }
    
    public EntityAnimal spawnBabyAnimal(final EntityAnimal var1) {
        return null;
    }
}
