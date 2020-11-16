package net.minecraft.server;

import java.util.*;

public class BlockChristmasLeaves extends AetherBlock
{
    public BlockChristmasLeaves(final int idBlockChristmasLeaves) {
        super(idBlockChristmasLeaves, 45, Material.LEAVES);
        this.a(true);
        this.c(0.2f);
        this.f(1);
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        return (j == 0) ? 45 : 46;
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public int idDropped(final int i, final Random random, final int j) {
        return 0;
    }
    
    
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random rand) {
        if (!this.nearTrunk(world, i, j, k)) {
            this.removeLeaves(world, i, j, k);
        }
    }
    
    private void removeLeaves(final World world, final int px, final int py, final int pz) {
        world.setTypeId(px, py, pz, 0);
    }
    
    private boolean nearTrunk(final World world, final int px, final int py, final int pz) {
        final Loc startLoc = new Loc(px, py, pz);
        final LinkedList toCheck = new LinkedList();
        final ArrayList checked = new ArrayList();
        toCheck.offer(new Loc(px, py, pz));
        final int bLeaves = super.id;
        while (!toCheck.isEmpty()) {
            final Loc curLoc = (Loc) toCheck.poll();
            if (checked.contains(curLoc)) {
                continue;
            }
            if (curLoc.distSimple(startLoc) <= 4) {
                final int block = curLoc.getBlock((IBlockAccess)world);
                final int meta = curLoc.getMeta((IBlockAccess)world);
                if (block == AetherBlocks.Log.id) {
                    return true;
                }
                if (block == bLeaves) {
                    toCheck.addAll(Arrays.asList(curLoc.adjacent()));
                }
            }
            checked.add(curLoc);
        }
        return false;
    }
    
    private boolean isMyTrunkMeta(final int meta) {
        if (super.id == AetherBlocks.ChristmasLeaves.id) {
            return meta <= 1;
        }
        return meta >= 2;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean shouldSideBeRendered(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        final int i2 = iblockaccess.getTypeId(i, j, k);
        return true;
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
    }
}
