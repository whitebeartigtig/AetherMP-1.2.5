package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemValkyriePickaxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemValkyriePickaxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, ItemValkyriePickaxe.blocksEffectiveAgainst);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemValkyriePickaxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemValkyriePickaxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemValkyriePickaxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Holystone, AetherBlocks.Icestone, AetherBlocks.EnchantedGravitite, AetherBlocks.GravititeOre, AetherBlocks.ZaniteOre, AetherBlocks.AmbrosiumOre, AetherBlocks.LightDungeonStone, AetherBlocks.DungeonStone, AetherBlocks.Pillar, AetherBlocks.Aerogel, AetherBlocks.Enchanter, AetherBlocks.Incubator, AetherBlocks.ZaniteBlock, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass };
        ItemValkyriePickaxe.random = new Random();
    }
}
