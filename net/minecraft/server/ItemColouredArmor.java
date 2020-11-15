package net.minecraft.server;

public class ItemColouredArmor extends ItemArmor
{
    private int colour;
    
    public ItemColouredArmor(final int i, final EnumArmorMaterial j, final int k, final int l, final int col) {
        super(i, j, k, l);
        this.colour = col;
    }
    
    public int getColorFromDamage(final int i, final int j) {
        return this.colour;
    }
}
