package net.minecraft.server;

import forge.*;

public class ItemZanitePickaxe extends ItemTool implements ITextureProvider
{
    private static Block[] blocksEffectiveAgainst;
    
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemZanitePickaxe(final int i, final EnumToolMaterial enumtoolmaterial) {
        super(i, 2, enumtoolmaterial, ItemZanitePickaxe.blocksEffectiveAgainst);
    }
    
    public float getStrVsBlock(final ItemStack itemstack, final Block block) {
        return super.getDestroySpeed(itemstack, block) * (2.0f * itemstack.getData() / itemstack.getItem().getMaxDurability() + 0.5f);
    }
    
    public boolean canHarvestBlock(final Block block) {
        for (int i = 0; i < ItemZanitePickaxe.blocksEffectiveAgainst.length; ++i) {
            if (ItemZanitePickaxe.blocksEffectiveAgainst[i].id == block.id) {
                return true;
            }
        }
        return false;
    }
    
    static {
        ItemZanitePickaxe.blocksEffectiveAgainst = new Block[] { AetherBlocks.Holystone, AetherBlocks.Icestone, AetherBlocks.EnchantedGravitite, AetherBlocks.GravititeOre, AetherBlocks.ZaniteOre, AetherBlocks.AmbrosiumOre, AetherBlocks.LightDungeonStone, AetherBlocks.DungeonStone, AetherBlocks.Pillar, AetherBlocks.Enchanter, AetherBlocks.Incubator, AetherBlocks.ZaniteBlock, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass };
    }
}
