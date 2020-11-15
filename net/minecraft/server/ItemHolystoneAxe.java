package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemHolystoneAxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemHolystoneAxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, ItemHolystoneAxe.blocksEffectiveAgainst);
    }
    
    public boolean a(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        if (ItemHolystoneAxe.random.nextInt(50) == 0) {
            entityliving.a(AetherItems.AmbrosiumShard.id, 1, 0.0f);
        }
        return super.a(itemstack, i, j, k, l, entityliving);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemHolystoneAxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemHolystoneAxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemHolystoneAxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Plank, AetherBlocks.Log };
        ItemHolystoneAxe.random = new Random();
    }
}
