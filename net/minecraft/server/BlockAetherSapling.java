package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherSapling extends BlockFlower implements ITextureProvider
{
    public static int sprSkyroot;
    public static int sprGoldenOak;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockAetherSapling(final int blockID) {
        super(blockID, (blockID == mod_Aether.idBlockGoldenOakSapling) ? BlockAetherSapling.sprGoldenOak : BlockAetherSapling.sprSkyroot);
        final float f = 0.4f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.c(0.0f);
    }
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random random) {
        if (world.isStatic) {
            return;
        }
        super.a(world, i, j, k, random);
        if (world.getLightLevel(i, j + 1, k) >= 9 && random.nextInt(30) == 0) {
            this.growTree(world, i, j, k, random);
        }
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (((Block)this).id == AetherBlocks.GoldenOakSapling.id) {
            return BlockAetherSapling.sprGoldenOak;
        }
        return BlockAetherSapling.sprSkyroot;
    }
    
    public boolean canPlaceBlockAt(final World world, final int i, final int j, final int k) {
        return super.canPlace(world, i, j, k) && this.canThisPlantGrowOnThisBlockID(world.getTypeId(i, j - 1, k));
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(final int i) {
        return i == AetherBlocks.Grass.id || i == AetherBlocks.Dirt.id;
    }
    
    public boolean blockActivated(final World world, final int i, final int j, final int k, final EntityPlayer entityPlayer) {
        if (world.isStatic) {
            return false;
        }
        if (entityPlayer == null) {
            return false;
        }
        final ItemStack itemStack = entityPlayer.U();
        if (itemStack == null) {
            return false;
        }
        if (itemStack.id != Item.INK_SACK.id) {
            return false;
        }
        if (itemStack.getData() != 15) {
            return false;
        }
        this.growTree(world, i, j, k, world.random);
        final ItemStack itemStack2 = itemStack;
        --itemStack2.count;
        return true;
    }
    
    public void growTree(final World world, final int i, final int j, final int k, final Random random) {
        world.setRawTypeId(i, j, k, 0);
        Object obj = null;
        if (((Block)this).id == AetherBlocks.GoldenOakSapling.id) {
            obj = new AetherGenGoldenOak();
        }
        else {
            obj = new AetherGenSkyroot();
        }
        if (!((WorldGenerator)obj).a(world, random, i, j, k)) {
            world.setRawTypeId(i, j, k, ((Block)this).id);
        }
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        BlockAetherSapling.sprSkyroot = 42;
        BlockAetherSapling.sprGoldenOak = 13;
    }
}
