package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemValkyrieSpade extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemValkyrieSpade(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 1, enumtoolmaterial, ItemValkyrieSpade.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemValkyrieSpade.blocksEffectiveAgainst.length; ++i) {
            if (ItemValkyrieSpade.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemValkyrieSpade.blocksEffectiveAgainst = new Block[] { AetherBlocks.Quicksoil, AetherBlocks.Dirt, AetherBlocks.Grass, AetherBlocks.Aercloud, Block.SNOW };
        ItemValkyrieSpade.random = new Random();
    }
}
