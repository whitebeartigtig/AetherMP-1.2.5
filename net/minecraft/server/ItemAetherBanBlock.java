package net.minecraft.server;

public class ItemAetherBanBlock extends ItemBlock
{
    private int dimensionToBan;
    
    public ItemAetherBanBlock(final int par1) {
        super(par1);
        this.dimensionToBan = 3;
    }
    
    public ItemAetherBanBlock(final int par1, final int dimensionToBan) {
        this(par1);
        this.dimensionToBan = dimensionToBan;
    }
    
    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World, final int par4, final int par5, final int par6, final int par7) {
        return par2EntityPlayer.dimension != this.dimensionToBan && super.interactWith(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7);
    }
}
