package net.minecraft.server;

import java.util.*;

public class BlockAetherBed extends Block
{
    public static final int[][] headBlockToFootBlockMap;
    
    public BlockAetherBed(final int i) {
        super(i, 134, Material.CLOTH);
        this.setBounds();
        this.c(0.2f);
        this.s();
        this.j();
    }
    
    public boolean blockActivated(final World world, int i, final int j, int k, final EntityPlayer entityplayer) {
        if (world.isStatic) {
            return true;
        }
        int l = world.getData(i, j, k);
        if (!isBlockFootOfBed(l)) {
            final int i2 = getDirectionFromMetadata(l);
            i += BlockAetherBed.headBlockToFootBlockMap[i2][0];
            k += BlockAetherBed.headBlockToFootBlockMap[i2][1];
            if (world.getTypeId(i, j, k) != super.id) {
                return true;
            }
            l = world.getData(i, j, k);
        }
        if (isBedOccupied(l)) {
            EntityPlayer entityplayer2 = null;
            for (final EntityPlayer entityplayer3 : world.playerEntities) {
                if (entityplayer3.isSleeping()) {
                    final ChunkCoordinates chunkcoordinates = entityplayer3.getBed();
                    if (chunkcoordinates.x != i || chunkcoordinates.y != j || chunkcoordinates.z != k) {
                        continue;
                    }
                    entityplayer2 = entityplayer3;
                }
            }
            if (entityplayer2 != null) {
                entityplayer.a("tile.bed.occupied");
                return true;
            }
            setBedOccupied(world, i, j, k, false);
        }
        final EnumBedResult enumstatus = entityplayer.a(i, j, k);
        if (enumstatus == EnumBedResult.OK) {
            setBedOccupied(world, i, j, k, true);
            return true;
        }
        if (enumstatus == EnumBedResult.NOT_POSSIBLE_NOW) {
            entityplayer.a("tile.bed.noSleep");
        }
        else if (enumstatus == EnumBedResult.NOT_SAFE) {
            entityplayer.a("tile.bed.notSafe");
        }
        return true;
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (i == 0) {
            return Block.WOOD.textureId;
        }
        final int k = getDirectionFromMetadata(j);
        final int l = Direction.h[k][i];
        if (isBlockFootOfBed(j)) {
            if (l == 2) {
                return super.textureId + 2 + 16;
            }
            if (l == 5 || l == 4) {
                return super.textureId + 1 + 16;
            }
            return super.textureId + 1;
        }
        else {
            if (l == 3) {
                return super.textureId - 1 + 16;
            }
            if (l == 5 || l == 4) {
                return super.textureId + 16;
            }
            return super.textureId;
        }
    }
    
    public int getRenderType() {
        return 14;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public void setBlockBoundsBasedOnState(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        this.setBounds();
    }
    
    public void onNeighborBlockChange(final World world, final int i, final int j, final int k, final int l) {
        final int i2 = world.getData(i, j, k);
        final int j2 = getDirectionFromMetadata(i2);
        if (isBlockFootOfBed(i2)) {
            if (world.getTypeId(i - BlockAetherBed.headBlockToFootBlockMap[j2][0], j, k - BlockAetherBed.headBlockToFootBlockMap[j2][1]) != super.id) {
                world.setTypeId(i, j, k, 0);
            }
        }
        else if (world.getTypeId(i + BlockAetherBed.headBlockToFootBlockMap[j2][0], j, k + BlockAetherBed.headBlockToFootBlockMap[j2][1]) != super.id) {
            world.setTypeId(i, j, k, 0);
            if (!world.isStatic) {
                this.b(world, i, j, k, i2, 0);
            }
        }
    }
    
    public int idDropped(final int i, final Random random, final int j) {
        if (isBlockFootOfBed(i)) {
            return 0;
        }
        return Item.BED.id;
    }
    
    private void setBounds() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5625f, 1.0f);
    }
    
    public static int getDirectionFromMetadata(final int i) {
        return i & 0x3;
    }
    
    public static boolean isBlockFootOfBed(final int i) {
        return (i & 0x8) != 0x0;
    }
    
    public static boolean isBedOccupied(final int i) {
        return (i & 0x4) != 0x0;
    }
    
    public static void setBedOccupied(final World world, final int i, final int j, final int k, final boolean flag) {
        int l = world.getData(i, j, k);
        if (flag) {
            l |= 0x4;
        }
        else {
            l &= 0xFFFFFFFB;
        }
        world.setData(i, j, k, l);
    }
    
    public static ChunkCoordinates getNearestEmptyChunkCoordinates(final World world, final int i, final int j, final int k, int l) {
        final int i2 = world.getData(i, j, k);
        final int j2 = getDirectionFromMetadata(i2);
        for (int k2 = 0; k2 <= 1; ++k2) {
            final int l2 = i - BlockAetherBed.headBlockToFootBlockMap[j2][0] * k2 - 1;
            final int i3 = k - BlockAetherBed.headBlockToFootBlockMap[j2][1] * k2 - 1;
            final int j3 = l2 + 2;
            final int k3 = i3 + 2;
            for (int l3 = l2; l3 <= j3; ++l3) {
                for (int i4 = i3; i4 <= k3; ++i4) {
                    if (world.e(l3, j - 1, i4) && world.isEmpty(l3, j, i4)) {
                        if (world.isEmpty(l3, j + 1, i4)) {
                            if (l <= 0) {
                                return new ChunkCoordinates(l3, j, i4);
                            }
                            --l;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public void dropBlockAsItemWithChance(final World world, final int i, final int j, final int k, final int l, final float f, final int i1) {
        if (!isBlockFootOfBed(l)) {
            super.dropNaturally(world, i, j, k, l, f, 0);
        }
    }
    
    public int getMobilityFlag() {
        return 1;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        headBlockToFootBlockMap = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
    }
}
