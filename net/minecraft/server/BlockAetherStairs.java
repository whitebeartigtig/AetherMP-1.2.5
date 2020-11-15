package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherStairs extends BlockStairs implements ITextureProvider
{
    private Block modelBlock;
    private int modelMeta;
    
    protected BlockAetherStairs(final int par1, final Block par2Block, final int metadata) {
        super(par1, par2Block);
        this.modelBlock = par2Block;
        this.modelMeta = metadata;
        this.c(par2Block.strength);
        this.b(par2Block.durability / 3.0f);
        this.f(0);
    }
    
    public int getBlockTextureFromSideAndMetadata(final int par1, final int par2) {
        return this.modelBlock.a(par1, this.modelMeta);
    }
    
    public int getBlockTextureFromSide(final int par1) {
        return this.modelBlock.a(par1, this.modelMeta);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
