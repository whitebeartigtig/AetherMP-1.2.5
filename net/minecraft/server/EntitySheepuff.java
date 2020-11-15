package net.minecraft.server;

import java.util.*;

public class EntitySheepuff extends EntityAetherAnimal
{
    public static final float[][] fleeceColorTable;
    private int amountEaten;
    
    public EntitySheepuff(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/sheepuff.png";
        this.b(0.9f, 1.3f);
        this.setFleeceColor(getRandomFleeceColor(((Entity)this).random));
        this.amountEaten = 0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        ((Entity)this).datawatcher.a(16, (Object)new Byte((byte)0));
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        if (!this.getSheared()) {
            this.a(new ItemStack(Block.WOOL.id, 1 + ((Entity)this).random.nextInt(2), this.getFleeceColor()), 0.0f);
        }
    }
    
    @Override
    public EntityAnimal spawnBabyAnimal(final EntityAnimal entityanimal) {
        return new EntitySheepuff(((Entity)this).world);
    }
    
    public boolean isWheat(final ItemStack itemstack) {
        return itemstack.id == Item.WHEAT.id;
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        final ItemStack itemstack = entityplayer.inventory.getItemInHand();
        if (itemstack != null && this.isWheat(itemstack)) {
            return super.b(entityplayer);
        }
        if (itemstack != null && itemstack.id == ((Item)Item.SHEARS).id && !this.getSheared()) {
            if (!((Entity)this).world.isStatic) {
                if (this.getPuffed()) {
                    this.setPuffed(false);
                    for (int i = 2 + ((Entity)this).random.nextInt(3), j = 0; j < i; ++j) {
                        final EntityItem entityDropItem;
                        final EntityItem entityitem = entityDropItem = this.a(new ItemStack(Block.WOOL.id, 1, this.getFleeceColor()), 1.0f);
                        ((Entity)entityDropItem).motY += ((Entity)this).random.nextFloat() * 0.05f;
                        final EntityItem entityItem = entityitem;
                        ((Entity)entityItem).motX += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.1f;
                        final EntityItem entityItem2 = entityitem;
                        ((Entity)entityItem2).motZ += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.1f;
                    }
                }
                else {
                    this.setSheared(true);
                    for (int i = 2 + ((Entity)this).random.nextInt(3), j = 0; j < i; ++j) {
                        final EntityItem entityDropItem2;
                        final EntityItem entityitem = entityDropItem2 = this.a(new ItemStack(Block.WOOL.id, 1, this.getFleeceColor()), 1.0f);
                        ((Entity)entityDropItem2).motY += ((Entity)this).random.nextFloat() * 0.05f;
                        final EntityItem entityItem3 = entityitem;
                        ((Entity)entityItem3).motX += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.1f;
                        final EntityItem entityItem4 = entityitem;
                        ((Entity)entityItem4).motZ += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.1f;
                    }
                }
            }
            itemstack.damage(1, (EntityLiving)entityplayer);
        }
        if (itemstack != null && itemstack.id == Item.INK_SACK.id && !this.getSheared()) {
            final int colour = BlockCloth.d(itemstack.getData());
            if (this.getFleeceColor() != colour) {
                if (this.getPuffed() && itemstack.count >= 2) {
                    this.setFleeceColor(colour);
                    final ItemStack itemStack = itemstack;
                    itemStack.count -= 2;
                }
                else if (!this.getPuffed()) {
                    this.setFleeceColor(colour);
                    final ItemStack itemStack2 = itemstack;
                    --itemStack2.count;
                }
            }
        }
        return false;
    }
    
    protected void jump() {
        if (this.getPuffed()) {
            ((Entity)this).motY = 1.8;
            ((Entity)this).motX += ((Entity)this).random.nextGaussian() * 0.5;
            ((Entity)this).motZ += ((Entity)this).random.nextGaussian() * 0.5;
        }
        else {
            ((Entity)this).motY = 0.41999998688697815;
        }
    }
    
    public void onUpdate() {
        super.F_();
        if (this.getPuffed()) {
            ((Entity)this).fallDistance = 0.0f;
            if (((Entity)this).motY < -0.05) {
                ((Entity)this).motY = -0.05;
            }
        }
        if (((Entity)this).random.nextInt(100) == 0) {
            final int x = MathHelper.floor(((Entity)this).locX);
            final int y = MathHelper.floor(((Entity)this).locY);
            final int z = MathHelper.floor(((Entity)this).locZ);
            if (((Entity)this).world.getTypeId(x, y - 1, z) == AetherBlocks.Grass.id) {
                ((Entity)this).world.setTypeId(x, y - 1, z, AetherBlocks.Dirt.id);
                ++this.amountEaten;
            }
        }
        if (this.amountEaten == 5 && !this.getSheared() && !this.getPuffed()) {
            this.setPuffed(true);
            this.amountEaten = 0;
        }
        if (this.amountEaten == 10 && this.getSheared() && !this.getPuffed()) {
            this.setSheared(false);
            this.setFleeceColor(0);
            this.amountEaten = 0;
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setBoolean("Sheared", this.getSheared());
        nbttagcompound.setBoolean("Puffed", this.getPuffed());
        nbttagcompound.setByte("Color", (byte)this.getFleeceColor());
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.setSheared(nbttagcompound.getBoolean("Sheared"));
        this.setPuffed(nbttagcompound.getBoolean("Puffed"));
        this.setFleeceColor(nbttagcompound.getByte("Color"));
    }
    
    protected String getLivingSound() {
        return "mob.sheep";
    }
    
    protected String getHurtSound() {
        return "mob.sheep";
    }
    
    protected String getDeathSound() {
        return "mob.sheep";
    }
    
    public int getFleeceColor() {
        return ((Entity)this).datawatcher.getByte(16) & 0xF;
    }
    
    public void setFleeceColor(final int i) {
        final byte byte0 = ((Entity)this).datawatcher.getByte(16);
        ((Entity)this).datawatcher.watch(16, (Object)(byte)((byte0 & 0xF0) | (i & 0xF)));
    }
    
    public boolean getSheared() {
        return (((Entity)this).datawatcher.getByte(16) & 0x10) != 0x0;
    }
    
    public void setSheared(final boolean flag) {
        final byte byte0 = ((Entity)this).datawatcher.getByte(16);
        if (flag) {
            ((Entity)this).datawatcher.watch(16, (Object)(byte)(byte0 | 0x10));
        }
        else {
            ((Entity)this).datawatcher.watch(16, (Object)(byte)(byte0 & 0xFFFFFFEF));
        }
    }
    
    public boolean getPuffed() {
        return (((Entity)this).datawatcher.getByte(16) & 0x20) != 0x0;
    }
    
    public void setPuffed(final boolean flag) {
        final byte byte0 = ((Entity)this).datawatcher.getByte(16);
        if (flag) {
            ((Entity)this).datawatcher.watch(16, (Object)(byte)(byte0 | 0x20));
        }
        else {
            ((Entity)this).datawatcher.watch(16, (Object)(byte)(byte0 & 0xFFFFFFDF));
        }
    }
    
    public static int getRandomFleeceColor(final Random random) {
        final int i = random.nextInt(100);
        if (i < 5) {
            return 3;
        }
        if (i < 10) {
            return 9;
        }
        if (i < 15) {
            return 5;
        }
        if (i < 18) {
            return 6;
        }
        return (random.nextInt(500) != 0) ? 0 : 10;
    }
    
    public int getMaxHealth() {
        return 20;
    }
    
    static {
        fleeceColorTable = new float[][] { { 1.0f, 1.0f, 1.0f }, { 0.975f, 0.85f, 0.6f }, { 0.95f, 0.75f, 0.925f }, { 0.8f, 0.85f, 0.975f }, { 0.95f, 0.95f, 0.6f }, { 0.75f, 0.9f, 0.55f }, { 0.975f, 0.85f, 0.9f }, { 0.65f, 0.65f, 0.65f }, { 0.8f, 0.8f, 0.8f }, { 0.65f, 0.8f, 0.85f }, { 0.85f, 0.7f, 0.95f }, { 0.6f, 0.7f, 0.9f }, { 0.75f, 0.7f, 0.65f }, { 0.7f, 0.75f, 0.6f }, { 0.9f, 0.65f, 0.65f }, { 0.55f, 0.55f, 0.55f } };
    }

	@Override
	public EntityAnimal createChild(EntityAnimal arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
