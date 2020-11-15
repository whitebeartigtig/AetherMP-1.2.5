package net.minecraft.server;

import forge.*;
import java.util.*;

public class ItemHolystonePickaxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    private static Random random;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemHolystonePickaxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, ItemHolystonePickaxe.blocksEffectiveAgainst);
    }
    
    public boolean onBlockDestroyed(final ItemStack itemstack, final int i, final int j, final int k, final int l, final EntityLiving entityliving) {
        if (ItemHolystonePickaxe.random.nextInt(50) == 0) {
            entityliving.a(AetherItems.AmbrosiumShard.id, 1, 0.0f);
        }
        return super.a(itemstack, i, j, k, l, entityliving);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemHolystonePickaxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemHolystonePickaxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemHolystonePickaxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Holystone, AetherBlocks.Icestone, AetherBlocks.ZaniteOre, AetherBlocks.AmbrosiumOre, AetherBlocks.LightDungeonStone, AetherBlocks.DungeonStone, AetherBlocks.Pillar, AetherBlocks.Enchanter, AetherBlocks.Incubator, AetherBlocks.ZaniteBlock, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass };
        ItemHolystonePickaxe.random = new Random();
    }
}
