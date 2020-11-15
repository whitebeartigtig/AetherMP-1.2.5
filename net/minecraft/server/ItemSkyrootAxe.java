package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemSkyrootAxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemSkyrootAxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 3, enumtoolmaterial, ItemSkyrootAxe.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemSkyrootAxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemSkyrootAxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemSkyrootAxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Plank, AetherBlocks.Log };
        ItemSkyrootAxe.random = new Random();
    }
}
