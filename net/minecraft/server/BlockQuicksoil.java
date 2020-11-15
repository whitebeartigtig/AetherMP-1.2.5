package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockQuicksoil extends Block implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public BlockQuicksoil(final int blockID) {
        super(blockID, 37, Material.SAND);
        super.frictionFactor = 1.1f;
        this.c(0.5f);
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        entityplayer.a(StatisticList.C[super.id], 1);
        if (l == 0 && mod_Aether.equippedSkyrootShovel()) {
            this.b(world, i, j, k, l, 0);
        }
        this.b(world, i, j, k, l, 0);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
