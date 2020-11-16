package net.minecraft.server;

import java.util.*;

public class BlockSunAltar extends Block
{
    protected BlockSunAltar(final int par1) {
        super(par1, Material.STONE);
        super.textureId = BlockDungeon.sprGold;
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        return (i == 1) ? 57 : ((i == 0) ? BlockDungeon.sprGold : 58);
    }
    /*
    public boolean blockActivated(final World par1World, final int par2, final int par3, final int par4, final EntityPlayer par5EntityPlayer) {
        if (par5EntityPlayer.dimension != 3) {
            par5EntityPlayer.a("block.SunAltar.notPossibleHere");
            return true;
        }
        
        final boolean hasKilledGold = ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(AetherAchievements.defeatGold);
        if (!hasKilledGold) {
            par5EntityPlayer.a("block.SunAltar.notAllowed");
            return true;
        }
        /*
        ModLoader.getMinecraftInstance().displayGuiScreen((GuiScreen)new GuiSunAltar(par1World));
        return true;
        */
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
