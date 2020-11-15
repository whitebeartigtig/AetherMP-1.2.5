package net.minecraft.server;

public abstract class EntityAetherAnimal extends EntityAnimal
{
    public EntityAetherAnimal(final World world) {
        super(world);
    }
    
    protected void entityInit() {
        super.entityInit();
    }
    
    public float getBlockPathWeight(final int i, final int j, final int k) {
        float wieght = 0.0f;
        if (((Entity)this).worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID) {
            wieght += 10.0f;
        }
        wieght += ((Entity)this).worldObj.getLightBrightness(i, j, k) - 0.5f;
        wieght += (float)(j - ((Entity)this).posY);
        return wieght;
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor_double(((Entity)this).posX);
        final int j = MathHelper.floor_double(((Entity)this).boundingBox.minY);
        final int k = MathHelper.floor_double(((Entity)this).posZ);
        return ((Entity)this).worldObj.checkIfAABBIsClear(((Entity)this).boundingBox) && ((Entity)this).worldObj.getCollidingBoundingBoxes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).worldObj.isAnyLiquid(((Entity)this).boundingBox) && ((Entity)this).worldObj.getBlockId(i, j - 1, k) == AetherBlocks.Grass.blockID && ((Entity)this).worldObj.getFullBlockLightValue(i, j, k) > 8 && this.getBlockPathWeight(i, j, k) >= 0.0f;
    }
    
    public EntityAnimal spawnBabyAnimal(final EntityAnimal var1) {
        return null;
    }
}
