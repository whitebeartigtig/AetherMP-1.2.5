package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherLeaves extends Block implements ITextureProvider
{
    public static int sprSkyroot;
    public static int sprGoldenOak;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public int getRenderColor(final int i) {
        return 16777215;
    }
    
    protected BlockAetherLeaves(final int blockID) {
        super(blockID, (blockID == mod_Aether.idBlockGoldenOakLeaves) ? BlockAetherLeaves.sprGoldenOak : BlockAetherLeaves.sprSkyroot, Material.LEAVES);
        this.a(true);
        this.c(0.2f);
        this.f(1);
    }
    
    public int quantityDropped(final Random random) {
        if (super.id == AetherBlocks.GoldenOakLeaves.id) {
            return (random.nextInt(10) == 0) ? 1 : 0;
        }
        return (random.nextInt(5) == 0) ? 1 : 0;
    }
    
    public int idDropped(final int i, final Random random, final int j) {
        if (super.id == AetherBlocks.SkyrootLeaves.id) {
            return AetherBlocks.SkyrootSapling.id;
        }
        if (random.nextInt(10) == 0) {
            return Item.GOLDEN_APPLE.id;
        }
        return AetherBlocks.GoldenOakSapling.id;
    }
    
    public void onBlockRemoval(final World world, final int i, final int j, final int k) {
        final int l = 1;
        final int i2 = l + 1;
        if (world.a(i - i2, j - i2, k - i2, i + i2, j + i2, k + i2)) {
            for (int j2 = -l; j2 <= l; ++j2) {
                for (int k2 = -l; k2 <= l; ++k2) {
                    for (int l2 = -l; l2 <= l; ++l2) {
                        final int i3 = world.getTypeId(i + j2, j + k2, k + l2);
                        if (i3 == super.id) {
                            final int j3 = world.getData(i + j2, j + k2, k + l2);
                            world.setRawData(i + j2, j + k2, k + l2, j3 | 0x8);
                        }
                    }
                }
            }
        }
    }
    
    
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random rand) {
        if (world.isStatic || AetherBlocks.GoldenOakSapling.id == super.id) {
            return;
        }
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
            final Loc curLoc = toCheck.poll();
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
        if (super.id == AetherBlocks.SkyrootLeaves.id) {
            return meta <= 1;
        }
        return meta >= 2;
    }
    
    protected int damageDropped(final int i) {
        return i & 0x3;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public void harvestBlock(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, final int l) {
        if (!world.isStatic && entityplayer.U() != null && entityplayer.U().id == ((Item)Item.SHEARS).id) {
            entityplayer.a(StatisticList.C[super.id], 1);
            this.a(world, i, j, k, new ItemStack(super.id, 1, l & 0x3));
        }
        else {
            super.a(world, entityplayer, i, j, k, l);
        }
    }
    
    public boolean shouldSideBeRendered(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        final int i2 = iblockaccess.getTypeId(i, j, k);
        return true;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        BlockAetherLeaves.sprSkyroot = 39;
        BlockAetherLeaves.sprGoldenOak = 12;
    }
}
