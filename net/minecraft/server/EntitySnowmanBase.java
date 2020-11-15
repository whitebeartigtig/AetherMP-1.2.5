package net.minecraft.server;

public abstract class EntitySnowmanBase extends EntityCreature
{
    public EntitySnowmanBase(final World world) {
        super(world);
    }
    
    protected void fall(final float f) {
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }
    
    protected String getLivingSound() {
        return "none";
    }
    
    protected String getHurtSound() {
        return "none";
    }
    
    protected String getDeathSound() {
        return "none";
    }
    
    public int getTalkInterval() {
        return 120;
    }
    
    protected boolean canDespawn() {
        return false;
    }
}
