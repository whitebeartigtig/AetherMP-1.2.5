package net.minecraft.server;

public class EntityDartGolden extends EntityProjectileBase
{
    public EntityLiving victim;
    public static int texfxindex;
    
    public EntityDartGolden(final World world) {
        super(world);
    }
    
    public EntityDartGolden(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }
    
    public EntityDartGolden(final World world, final EntityLiving ent) {
        super(world, ent);
    }
    
    public void entityInit() {
        super.entityInit();
        super.item = new ItemStack(AetherItems.Dart, 1, 0);
        super.curvature = 0.0f;
        super.dmg = 4;
        super.speed = 1.5f;
    }
    
    public boolean handleWaterMovement() {
        return this.victim == null && super.h_();
    }
    
    @Override
    public void setDead() {
        this.victim = null;
        super.setDead();
    }
    
    @Override
    public boolean onHitBlock() {
        super.curvature = 0.03f;
        super.world.makeSound((Entity)this, "random.drr", 1.0f, 1.2f / (super.random.nextFloat() * 0.2f + 0.9f));
        return this.victim == null;
    }
    
    @Override
    public boolean canBeShot(final Entity ent) {
        return super.canBeShot(ent) && this.victim == null;
    }
    
    static {
        EntityDartGolden.texfxindex = 94;
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
