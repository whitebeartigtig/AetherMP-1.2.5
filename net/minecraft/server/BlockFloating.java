package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockFloating extends Block implements ITextureProvider
{
    public static boolean fallInstantly;
    private boolean enchanted;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public BlockFloating(final int i, final int j, final boolean bool) {
        super(i, j, Material.STONE);
        this.enchanted = bool;
        this.c(5.0f);
    }
    
    public void onBlockAdded(final World world, final int i, final int j, final int k) {
        world.c(i, j, k, super.id, this.tickRate());
    }
    
    public void onNeighborBlockChange(final World world, final int i, final int j, final int k, final int l) {
        world.c(i, j, k, super.id, this.tickRate());
    }
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random random) {
        if (!this.enchanted || (this.enchanted && world.isBlockPowered(i, j, k))) {
            this.tryToFall(world, i, j, k);
        }
    }
    
    private void tryToFall(final World world, final int i, int j, final int k) {
        final int l = i;
        final int i2 = j;
        final int j2 = k;
        if (canFallAbove(world, l, i2 + 1, j2) && i2 < 128) {
            final byte byte0 = 32;
            if (BlockFloating.fallInstantly || !world.a(i - byte0, j - byte0, k - byte0, i + byte0, j + byte0, k + byte0)) {
                world.setTypeId(i, j, k, 0);
                while (canFallAbove(world, i, j + 1, k) && j < 128) {
                    ++j;
                }
                if (j > 0) {
                    world.setTypeId(i, j, k, super.id);
                }
            }
            else {
                final EntityFloatingBlock floating = new EntityFloatingBlock(world, i + 0.5f, j + 0.5f, k + 0.5f, super.id);
                world.addEntity((Entity)floating);
            }
        }
    }
    
    public int tickRate() {
        return 3;
    }
    
    public static boolean canFallAbove(final World world, final int i, final int j, final int k) {
        final int l = world.getTypeId(i, j, k);
        if (l == 0) {
            return true;
        }
        if (l == ((Block)Block.FIRE).id) {
            return true;
        }
        final Material material = Block.byId[l].material;
        return material == Material.WATER || material == Material.LAVA;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
    
    static {
        BlockFloating.fallInstantly = false;
    }
}
