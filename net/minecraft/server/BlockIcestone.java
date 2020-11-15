package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockIcestone extends Block implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockIcestone(final int blockID) {
        super(blockID, 20, Material.STONE);
        this.c(3.0f);
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        world.setTypeId(i, j, k, super.id);
        world.setData(i, j, k, 1);
        for (int x = i - 3; x < i + 4; ++x) {
            for (int y = j - 1; y < j + 2; ++y) {
                for (int z = k - 3; z < k + 4; ++z) {
                    if ((x - i) * (x - i) + (y - j) * (y - j) + (z - k) * (z - k) < 8 && world.getTypeId(x, y, z) == Block.STATIONARY_WATER.id) {
                        world.setTypeId(x, y, z, Block.ICE.id);
                    }
                    if ((x - i) * (x - i) + (y - j) * (y - j) + (z - k) * (z - k) < 8 && world.getTypeId(x, y, z) == Block.STATIONARY_LAVA.id) {
                        world.setTypeId(x, y, z, Block.OBSIDIAN.id);
                    }
                }
            }
        }
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        entityplayer.a(StatisticList.C[super.id], 1);
        if (l == 0 && mod_Aether.equippedSkyrootPick()) {
            this.b(world, i, j, k, l, 0);
        }
        this.b(world, i, j, k, l, 0);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
