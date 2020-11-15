package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemHolystoneSpade extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemHolystoneSpade(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 1, enumtoolmaterial, ItemHolystoneSpade.blocksEffectiveAgainst);
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        if (ItemHolystoneSpade.random.nextInt(50) == 0) {
            entityliving.a(AetherItems.AmbrosiumShard.id, 1, 0.0f);
        }
        return super.a(itemstack, i, j, k, l, entityliving);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemHolystoneSpade.blocksEffectiveAgainst.length; ++i) {
            if (ItemHolystoneSpade.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemHolystoneSpade.blocksEffectiveAgainst = new Block[] { AetherBlocks.Quicksoil, AetherBlocks.Dirt, AetherBlocks.Grass, AetherBlocks.Aercloud, Block.SNOW };
        ItemHolystoneSpade.random = new Random();
    }
}
