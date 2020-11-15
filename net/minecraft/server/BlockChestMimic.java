package net.minecraft.server;

import java.util.*;

public class BlockChestMimic extends BlockChest
{
    protected BlockChestMimic(final int i) {
        super(i);
        ((Block)this).textureId = 26;
        this.c(2.0f);
    }
    
    public int getBlockTexture(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        if (l == 1) {
            return ((Block)this).textureId - 1;
        }
        if (l == 0) {
            return ((Block)this).textureId - 1;
        }
        final int i2 = iblockaccess.getTypeId(i, j, k - 1);
        final int j2 = iblockaccess.getTypeId(i, j, k + 1);
        final int k2 = iblockaccess.getTypeId(i - 1, j, k);
        final int l2 = iblockaccess.getTypeId(i + 1, j, k);
        if (i2 == ((Block)this).id || j2 == ((Block)this).id) {
            if (l == 2 || l == 3) {
                return ((Block)this).textureId;
            }
            int i3 = 0;
            if (i2 == ((Block)this).id) {
                i3 = -1;
            }
            final int k3 = iblockaccess.getTypeId(i - 1, j, (i2 != ((Block)this).id) ? (k + 1) : (k - 1));
            final int i4 = iblockaccess.getTypeId(i + 1, j, (i2 != ((Block)this).id) ? (k + 1) : (k - 1));
            if (l == 4) {
                i3 = -1 - i3;
            }
            byte byte1 = 5;
            if ((Block.n[k2] || Block.n[k3]) && !Block.n[l2] && !Block.n[i4]) {
                byte1 = 5;
            }
            if ((Block.n[l2] || Block.n[i4]) && !Block.n[k2] && !Block.n[k3]) {
                byte1 = 4;
            }
            return ((l != byte1) ? (((Block)this).textureId + 32) : (((Block)this).textureId + 16)) + i3;
        }
        else {
            if (k2 != ((Block)this).id && l2 != ((Block)this).id) {
                byte byte2 = 3;
                if (Block.n[i2] && !Block.n[j2]) {
                    byte2 = 3;
                }
                if (Block.n[j2] && !Block.n[i2]) {
                    byte2 = 2;
                }
                if (Block.n[k2] && !Block.n[l2]) {
                    byte2 = 5;
                }
                if (Block.n[l2] && !Block.n[k2]) {
                    byte2 = 4;
                }
                return (l != byte2) ? ((Block)this).textureId : (((Block)this).textureId + 1);
            }
            if (l == 4 || l == 5) {
                return ((Block)this).textureId;
            }
            int j3 = 0;
            if (k2 == ((Block)this).id) {
                j3 = -1;
            }
            final int l3 = iblockaccess.getTypeId((k2 != ((Block)this).id) ? (i + 1) : (i - 1), j, k - 1);
            final int j4 = iblockaccess.getTypeId((k2 != ((Block)this).id) ? (i + 1) : (i - 1), j, k + 1);
            if (l == 3) {
                j3 = -1 - j3;
            }
            byte byte3 = 3;
            if ((Block.n[i2] || Block.n[l3]) && !Block.n[j2] && !Block.n[j4]) {
                byte3 = 3;
            }
            if ((Block.n[j2] || Block.n[j4]) && !Block.n[i2] && !Block.n[l3]) {
                byte3 = 2;
            }
            return ((l != byte3) ? (((Block)this).textureId + 32) : (((Block)this).textureId + 16)) + j3;
        }
    }
    
    public int getBlockTextureFromSide(final int i) {
        if (i == 1) {
            return ((Block)this).textureId - 1;
        }
        if (i == 0) {
            return ((Block)this).textureId - 1;
        }
        if (i == 3) {
            return ((Block)this).textureId + 1;
        }
        return ((Block)this).textureId;
    }
    
    public boolean canPlaceBlockAt(final World world, final int i, final int j, final int k) {
        int l = 0;
        if (world.getTypeId(i - 1, j, k) == ((Block)this).id) {
            ++l;
        }
        if (world.getTypeId(i + 1, j, k) == ((Block)this).id) {
            ++l;
        }
        if (world.getTypeId(i, j, k - 1) == ((Block)this).id) {
            ++l;
        }
        if (world.getTypeId(i, j, k + 1) == ((Block)this).id) {
            ++l;
        }
        return l <= 1 && !this.isThereANeighborChest(world, i - 1, j, k) && !this.isThereANeighborChest(world, i + 1, j, k) && !this.isThereANeighborChest(world, i, j, k - 1) && !this.isThereANeighborChest(world, i, j, k + 1);
    }
    
    private boolean isThereANeighborChest(final World world, final int i, final int j, final int k) {
        return world.getTypeId(i, j, k) == ((Block)this).id && (world.getTypeId(i - 1, j, k) == ((Block)this).id || world.getTypeId(i + 1, j, k) == ((Block)this).id || world.getTypeId(i, j, k - 1) == ((Block)this).id || world.getTypeId(i, j, k + 1) == ((Block)this).id);
    }
    
    public void onBlockRemoval(final World world, final int i, final int j, final int k) {
        world.setTypeId(i, j, k, 0);
        final EntityMimic mimic = new EntityMimic(world);
        mimic.setPosition(i + 0.5, j + 1.5, k + 0.5);
        world.addEntity((Entity)mimic);
    }
    
    public boolean blockActivated(final World world, final int i, final int j, final int k, final EntityPlayer entityplayer) {
        world.setTypeId(i, j, k, 0);
        return true;
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
