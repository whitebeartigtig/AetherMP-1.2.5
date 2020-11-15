package net.minecraft.server;

import forge.*;

public class ItemZaniteAxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemZaniteAxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, ItemZaniteAxe.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemZaniteAxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemZaniteAxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return super.getDestroySpeed(itemstack, block) * (2.0f * itemstack.getData() / itemstack.getItem().getMaxDurability() + 0.5f);
    }
    
    static {
        ItemZaniteAxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Plank, AetherBlocks.Log };
    }
}
