package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockBushStem extends BlockAetherFlower implements ITextureProvider
{
    @Override
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockBushStem(final int blockID) {
        super(blockID, 49);
        this.j();
        final float f = 0.4f;
        this.a(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 2.0f, 0.5f + f);
        this.c(0.2f);
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        this.h(world, i, j, k);
    }
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random random) {
        System.out.println("tick");
        if (world.isStatic) {
            return;
        }
        super.a(world, i, j, k, random);
        if (world.getLightLevel(i, j + 1, k) >= 9 && random.nextInt(30) == 0) {
            world.setRawTypeId(i, j, k, AetherBlocks.BerryBush.id);
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int i, final int j, final int k) {
        return AxisAlignedBB.b(i + ((Block)this).minX, j + ((Block)this).minY, k + ((Block)this).minZ, i + ((Block)this).maxX, j + ((Block)this).maxY, k + ((Block)this).maxZ);
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
        final ItemStack itemStack2 = itemStack;
        --itemStack2.count;
        world.setTypeId(i, j, k, 0);
        world.setTypeId(i, j, k, AetherBlocks.BerryBush.id);
        return true;
    }
    
    @Override
    protected boolean canThisPlantGrowOnThisBlockID(final int i) {
        return i == AetherBlocks.Grass.id || i == AetherBlocks.Dirt.id;
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
