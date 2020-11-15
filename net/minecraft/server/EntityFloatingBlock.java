package net.minecraft.server;

import java.util.*;

public class EntityFloatingBlock extends Entity
{
    public int blockID;
    public int metadata;
    public int flytime;
    
    public EntityFloatingBlock(final World world) {
        super(world);
        this.flytime = 0;
    }
    
    public EntityFloatingBlock(final World world, final double d, final double d1, final double d2, final int i, final int j) {
        super(world);
        this.flytime = 0;
        this.blockID = i;
        this.metadata = j;
        super.bf = true;
        this.b(0.98f, 0.98f);
        super.height = super.height / 2.0f;
        this.setPosition(d, d1, d2);
        super.motX = 0.0;
        super.motY = 0.0;
        super.motZ = 0.0;
        super.lastX = d;
        super.lastY = d1;
        super.lastZ = d2;
    }
    
    public EntityFloatingBlock(final World world, final double d, final double d1, final double d2, final int i) {
        this(world, d, d1, d2, i, 0);
    }
    
    protected boolean canTriggerWalking() {
        return false;
    }
    
    protected void entityInit() {
    }
    
    public boolean canBeCollidedWith() {
        return !super.dead;
    }
    
    public void onUpdate() {
        if (this.blockID == 0) {
            this.die();
            return;
        }
        super.lastX = super.locX;
        super.lastY = super.locY;
        super.lastZ = super.locZ;
        ++this.flytime;
        super.motY += 0.04;
        this.move(super.motX, super.motY, super.motZ);
        super.motX *= 0.9800000190734863;
        super.motY *= 0.9800000190734863;
        super.motZ *= 0.9800000190734863;
        final int i = MathHelper.floor(super.locX);
        final int j = MathHelper.floor(super.locY);
        final int k = MathHelper.floor(super.locZ);
        if (super.world.getTypeId(i, j, k) == this.blockID || (super.world.getTypeId(i, j, k) == AetherBlocks.Grass.id && this.blockID == AetherBlocks.Dirt.id)) {
            super.world.setTypeId(i, j, k, 0);
        }
        final List list = super.world.getEntities((Entity)this, super.boundingBox.grow(0.0, 1.0, 0.0));
        for (int n = 0; n < list.size(); ++n) {
            if (list.get(n) instanceof EntityFallingBlock && super.world.mayPlace(this.blockID, i, j, k, true, 1)) {
                super.world.setTypeIdAndData(i, j, k, this.blockID, this.metadata);
                this.die();
            }
        }
        if (super.bz && !super.onGround) {
            super.motX *= 0.699999988079071;
            super.motZ *= 0.699999988079071;
            super.motY *= -0.5;
            this.die();
            if ((!super.world.mayPlace(this.blockID, i, j, k, true, 1) || BlockFloating.canFallAbove(super.world, i, j + 1, k) || !super.world.setTypeIdAndData(i, j, k, this.blockID, this.metadata)) && !super.world.isStatic) {}
        }
        else if (this.flytime > 100 && !super.world.isStatic) {
            this.die();
        }
    }
    
    protected void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        nbttagcompound.setByte("Tile", (byte)this.blockID);
    }
    
    protected void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        this.blockID = (nbttagcompound.getByte("Tile") & 0xFF);
    }
    
    public float getShadowSize() {
        return 0.0f;
    }
    
    public World getWorld() {
        return super.world;
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
