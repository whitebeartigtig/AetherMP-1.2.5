package net.minecraft.server;

import forge.*;

public class ItemZaniteSpade extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemZaniteSpade(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 1, enumtoolmaterial, ItemZaniteSpade.blocksEffectiveAgainst);
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return super.getDestroySpeed(itemstack, block) * (itemstack.getData() / itemstack.getItem().getMaxDurability() + 0.5f);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemZaniteSpade.blocksEffectiveAgainst.length; ++i) {
            if (ItemZaniteSpade.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemZaniteSpade.blocksEffectiveAgainst = new Block[] { AetherBlocks.Quicksoil, AetherBlocks.Dirt, AetherBlocks.Grass, AetherBlocks.Aercloud, Block.SNOW };
    }
}
