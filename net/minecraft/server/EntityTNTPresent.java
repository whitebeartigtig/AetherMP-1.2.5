package net.minecraft.server;

public class EntityTNTPresent extends Entity
{
    public int fuse;
    
    public EntityTNTPresent(final World world) {
        super(world);
        this.fuse = 0;
        super.bf = true;
        this.b(0.98f, 0.98f);
        super.height = super.height / 2.0f;
    }
    
    public EntityTNTPresent(final World world, final double d, final double d1, final double d2) {
        this(world);
        this.setPosition(d, d1, d2);
        final float f = (float)(Math.random() * 3.1415927410125732 * 2.0);
        super.motX = -MathHelper.sin(f * 3.141593f / 180.0f) * 0.02f;
        super.motY = 0.20000000298023224;
        super.motZ = -MathHelper.cos(f * 3.141593f / 180.0f) * 0.02f;
        this.fuse = 80;
        super.lastX = d;
        super.lastY = d1;
        super.lastZ = d2;
    }
    
    protected void entityInit() {
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public boolean canBeCollidedWith() {
        return !super.dead;
    }
    
    public void onUpdate() {
        super.lastX = super.locX;
        super.lastY = super.locY;
        super.lastZ = super.locZ;
        super.motY -= 0.03999999910593033;
        this.move(super.motX, super.motY, super.motZ);
        super.motX *= 0.9800000190734863;
        super.motY *= 0.9800000190734863;
        super.motZ *= 0.9800000190734863;
        if (super.onGround) {
            super.motX *= 0.699999988079071;
            super.motZ *= 0.699999988079071;
            super.motY *= -0.5;
        }
        if (this.fuse-- <= 0) {
            if (!super.world.isStatic) {
                this.die();
                this.explode();
            }
            else {
                this.die();
            }
        }
        else {
            super.world.a("smoke", super.locX, super.locY + 0.5, super.locZ, 0.0, 0.0, 0.0);
        }
    }
    
    private void explode() {
        final float f = 0.5f;
        super.world.explode((Entity)null, super.locX, super.locY, super.locZ, f);
    }
    
    protected void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Fuse", (byte)this.fuse);
    }
    
    protected void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.fuse = nbttagcompound.getByte("Fuse");
    }
    
    public float getShadowSize() {
        return 0.0f;
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
