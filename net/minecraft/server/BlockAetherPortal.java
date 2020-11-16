package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAetherPortal extends BlockPortal implements ITextureProvider
{
    public BlockAetherPortal(final int blockID) {
        super(blockID, 35);
        this.c(-1.0f);
        this.b(6000000.0f);
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    /*
    public void onEntityCollidedWithBlock(final World world, final int i, final int j, final int k, final Entity entity) {
        if (entity instanceof EntityPlayer) {
            mod_Aether.getPlayer().setInPortal();
        }
    }
    */
    public boolean tryToCreatePortal(final World world, int i, final int j, int k) {
        int l = 0;
        int i2 = 0;
        if (world.getTypeId(i - 1, j, k) == Block.GLOWSTONE.id || world.getTypeId(i + 1, j, k) == Block.GLOWSTONE.id) {
            l = 1;
        }
        if (world.getTypeId(i, j, k - 1) == Block.GLOWSTONE.id || world.getTypeId(i, j, k + 1) == Block.GLOWSTONE.id) {
            i2 = 1;
        }
        if (l == i2) {
            return false;
        }
        if (world.getTypeId(i - l, j, k - i2) == 0) {
            i -= l;
            k -= i2;
        }
        for (int j2 = -1; j2 <= 2; ++j2) {
            for (int l2 = -1; l2 <= 3; ++l2) {
                final boolean flag = j2 == -1 || j2 == 2 || l2 == -1 || l2 == 3;
                if (j2 == -1 || j2 == 2) {
                    if (l2 == -1) {
                        continue;
                    }
                    if (l2 == 3) {
                        continue;
                    }
                }
                final int j3 = world.getTypeId(i + l * j2, j + l2, k + i2 * j2);
                if (flag) {
                    if (j3 != Block.GLOWSTONE.id) {
                        return false;
                    }
                }
                else if (j3 != 0 && j3 != Block.WATER.id) {
                    return false;
                }
            }
        }
        world.suppressPhysics = true;
        for (int k2 = 0; k2 < 2; ++k2) {
            for (int i3 = 0; i3 < 3; ++i3) {
                world.setTypeId(i + l * k2, j + i3, k + i2 * k2, ((Block)this).id);
            }
        }
        world.suppressPhysics = false;
        return true;
    }
    
    public void onNeighborBlockChange(final World world, final int i, final int j, final int k, final int l) {
        int i2 = 0;
        int j2 = 1;
        if (world.getTypeId(i - 1, j, k) == ((Block)this).id || world.getTypeId(i + 1, j, k) == ((Block)this).id) {
            i2 = 1;
            j2 = 0;
        }
        int k2;
        for (k2 = j; world.getTypeId(i, k2 - 1, k) == ((Block)this).id; --k2) {}
        if (world.getTypeId(i, k2 - 1, k) != Block.GLOWSTONE.id) {
            world.setTypeId(i, j, k, 0);
            return;
        }
        int l2;
        for (l2 = 1; l2 < 4 && world.getTypeId(i, k2 + l2, k) == ((Block)this).id; ++l2) {}
        if (l2 != 3 || world.getTypeId(i, k2 + l2, k) != Block.GLOWSTONE.id) {
            world.setTypeId(i, j, k, 0);
            return;
        }
        final boolean flag = world.getTypeId(i - 1, j, k) == ((Block)this).id || world.getTypeId(i + 1, j, k) == ((Block)this).id;
        final boolean flag2 = world.getTypeId(i, j, k - 1) == ((Block)this).id || world.getTypeId(i, j, k + 1) == ((Block)this).id;
        if (flag && flag2) {
            world.setTypeId(i, j, k, 0);
            return;
        }
        if ((world.getTypeId(i + i2, j, k + j2) != Block.GLOWSTONE.id || world.getTypeId(i - i2, j, k - j2) != ((Block)this).id) && (world.getTypeId(i - i2, j, k - j2) != Block.GLOWSTONE.id || world.getTypeId(i + i2, j, k + j2) != ((Block)this).id)) {
            world.setTypeId(i, j, k, 0);
        }
    }
    

    
    public int getDimNumber() {
        return (mod_Aether.getCurrentDimension() == 0) ? 3 : 0;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
