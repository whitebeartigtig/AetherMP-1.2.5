package net.minecraft.server;

public class EntityFireMinion extends EntityMonster
{
    public EntityFireMinion(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firemonster.png";
        super.damage = 5;
        ((EntityLiving)this).health = this.getMaxHealth();
        ((Entity)this).fireProof = true;
    }
    
    public int getMaxHealth() {
        return 40;
    }
    
    public void onUpdate() {
        super.F_();
        if (((EntityLiving)this).health > 0) {
            for (int j = 0; j < 4; ++j) {
                final double a = ((Entity)this).random.nextFloat() - 0.5f;
                final double b = ((Entity)this).random.nextFloat();
                final double c = ((Entity)this).random.nextFloat() - 0.5f;
                final double d = ((Entity)this).locX + a * b;
                final double e = ((Entity)this).boundingBox.b + b - 0.5;
                final double f = ((Entity)this).locZ + c * b;
                ((Entity)this).world.a("flame", d, e, f, 0.0, -0.07500000298023224, 0.0);
            }
        }
    }
}
