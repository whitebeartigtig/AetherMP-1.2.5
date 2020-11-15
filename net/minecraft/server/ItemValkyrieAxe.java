package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemValkyrieAxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemValkyrieAxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, ItemValkyrieAxe.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemValkyrieAxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemValkyrieAxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemValkyrieAxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Plank, AetherBlocks.Log };
        ItemValkyrieAxe.random = new Random();
    }
}
