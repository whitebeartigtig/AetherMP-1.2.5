package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemSkyrootPickaxe extends ItemPickaxe implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemSkyrootPickaxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, enumtoolmaterial);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemSkyrootPickaxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemSkyrootPickaxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemSkyrootPickaxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Holystone, AetherBlocks.AmbrosiumOre, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass, AetherBlocks.Incubator };
        ItemSkyrootPickaxe.random = new Random();
    }
}
