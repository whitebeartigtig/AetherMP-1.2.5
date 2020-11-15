package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemSkyrootSpade extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    public ItemSkyrootSpade(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 1, enumtoolmaterial, ItemSkyrootSpade.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemSkyrootSpade.blocksEffectiveAgainst.length; ++i) {
            if (ItemSkyrootSpade.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemSkyrootSpade.blocksEffectiveAgainst = new Block[] { AetherBlocks.Quicksoil, AetherBlocks.Dirt, AetherBlocks.Grass, AetherBlocks.Aercloud, Block.SNOW };
        ItemSkyrootSpade.random = new Random();
    }
}
