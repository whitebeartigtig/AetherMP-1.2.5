package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAmbrosiumTorch extends Block implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockAmbrosiumTorch(final int blockID) {
        super(blockID, 3, Material.ORIENTABLE);
        this.a(true);
        this.a(0.9375f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return 2;
    }
    
    public boolean canPlaceBlockAt(final World world, final int i, final int j, final int k) {
        return world.r(i - 1, j, k) || world.r(i + 1, j, k) || world.r(i, j, k - 1) || world.r(i, j, k + 1) || world.r(i, j - 1, k);
    }
    
    public void onBlockPlaced(final World world, final int i, final int j, final int k, final int l) {
        int i2 = world.getData(i, j, k);
        if (l == 1 && world.r(i, j - 1, k)) {
            i2 = 5;
        }
        if (l == 2 && world.r(i, j, k + 1)) {
            i2 = 4;
        }
        if (l == 3 && world.r(i, j, k - 1)) {
            i2 = 3;
        }
        if (l == 4 && world.r(i + 1, j, k)) {
            i2 = 2;
        }
        if (l == 5 && world.r(i - 1, j, k)) {
            i2 = 1;
        }
        world.setData(i, j, k, i2);
    }
    
    public void updateTick(final World world, final int i, final int j, final int k, final Random random) {
        super.a(world, i, j, k, random);
        if (world.getData(i, j, k) == 0) {
            this.onBlockAdded(world, i, j, k);
        }
    }
    
    public void onBlockAdded(final World world, final int i, final int j, final int k) {
        if (world.r(i - 1, j, k)) {
            world.setData(i, j, k, 1);
        }
        else if (world.r(i + 1, j, k)) {
            world.setData(i, j, k, 2);
        }
        else if (world.r(i, j, k - 1)) {
            world.setData(i, j, k, 3);
        }
        else if (world.r(i, j, k + 1)) {
            world.setData(i, j, k, 4);
        }
        else if (world.r(i, j - 1, k)) {
            world.setData(i, j, k, 5);
        }
        this.dropTorchIfCantStay(world, i, j, k);
    }
    
    public void onNeighborBlockChange(final World world, final int i, final int j, final int k, final int l) {
        if (this.dropTorchIfCantStay(world, i, j, k)) {
            final int i2 = world.getData(i, j, k);
            boolean flag = false;
            if (!world.r(i - 1, j, k) && i2 == 1) {
                flag = true;
            }
            if (!world.r(i + 1, j, k) && i2 == 2) {
                flag = true;
            }
            if (!world.r(i, j, k - 1) && i2 == 3) {
                flag = true;
            }
            if (!world.r(i, j, k + 1) && i2 == 4) {
                flag = true;
            }
            if (!world.r(i, j - 1, k) && i2 == 5) {
                flag = true;
            }
            if (flag) {
                this.b(world, i, j, k, world.getData(i, j, k), 0);
                world.setTypeId(i, j, k, 0);
            }
        }
    }
    
    private boolean dropTorchIfCantStay(final World world, final int i, final int j, final int k) {
        if (!this.canPlaceBlockAt(world, i, j, k)) {
            this.b(world, i, j, k, world.getData(i, j, k), 0);
            world.setTypeId(i, j, k, 0);
            return false;
        }
        return true;
    }
    
    public MovingObjectPosition collisionRayTrace(final World world, final int i, final int j, final int k, final Vec3D vec3d, final Vec3D vec3d1) {
        final int l = world.getData(i, j, k) & 0x7;
        final float f = 0.15f;
        if (l == 1) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        }
        else if (l == 2) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        }
        else if (l == 3) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        }
        else if (l == 4) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
        else {
            final float f2 = 0.1f;
            this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.6f, 0.5f + f2);
        }
        return super.a(world, i, j, k, vec3d, vec3d1);
    }
    
    public void randomDisplayTick(final World world, final int i, final int j, final int k, final Random random) {
        final int l = world.getData(i, j, k);
        final double d = i + 0.5f;
        final double d2 = j + 0.7f;
        final double d3 = k + 0.5f;
        final double d4 = 0.2199999988079071;
        final double d5 = 0.27000001072883606;
        if (l == 1) {
            world.a("flame", d - d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        }
        else if (l == 2) {
            world.a("flame", d + d5, d2 + d4, d3, 0.0, 0.0, 0.0);
        }
        else if (l == 3) {
            world.a("flame", d, d2 + d4, d3 - d5, 0.0, 0.0, 0.0);
        }
        else if (l == 4) {
            world.a("flame", d, d2 + d4, d3 + d5, 0.0, 0.0, 0.0);
        }
        else {
            world.a("flame", d, d2, d3, 0.0, 0.0, 0.0);
        }
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
