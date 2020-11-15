package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAmbrosiumOre extends Block implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public BlockAmbrosiumOre(final int blockID) {
        super(blockID, 2, Material.STONE);
        this.c(3.0f);
        this.b(5.0f);
    }
    
    public int idDropped(final int i, final Random random, final int k) {
        return AetherItems.AmbrosiumShard.id;
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        world.setTypeId(i, j, k, super.id);
        world.setData(i, j, k, 1);
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
