package net.minecraft.server;

public class EntityDartEnchanted extends EntityDartGolden
{
    public EntityLiving victim;
    public static int texfxindex;
    
    public EntityDartEnchanted(final World world) {
        super(world);
    }
    
    public EntityDartEnchanted(final World world, final double x, final double y, final double z) {
        super(world, x, y, z);
    }
    
    public EntityDartEnchanted(final World world, final EntityLiving ent) {
        super(world, ent);
    }
    
    @Override
    public void entityInit() {
        super.entityInit();
        super.item = new ItemStack(AetherItems.Dart, 1, 2);
        super.dmg = 6;
    }
    
    static {
        EntityDartEnchanted.texfxindex = 94;
    }
}
