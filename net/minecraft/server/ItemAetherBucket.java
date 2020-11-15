package net.minecraft.server;

import java.util.*;

public class ItemAetherBucket extends ItemBucket
{
    private int contents;
    
    public ItemAetherBucket(final int id, final int isFull) {
        super(id, isFull);
        this.contents = isFull;
    }
    
    public ItemStack a(final ItemStack itemStack, final World world, final EntityPlayer player) {
        if (this.contents == 0) {
            return super.a(itemStack, world, player);
        }
        final float var4 = 1.0f;
        final double px = ((Entity)player).lastX + (((Entity)player).locX - ((Entity)player).lastX) * var4;
        final double py = ((Entity)player).lastY + (((Entity)player).locY - ((Entity)player).lastY) * var4 + 1.62 - ((Entity)player).height;
        final double pz = ((Entity)player).lastZ + (((Entity)player).locZ - ((Entity)player).lastZ) * var4;
        final MovingObjectPosition mop = this.a(world, player, false);
        if (mop == null) {
            return itemStack;
        }
        int x = mop.b;
        int y = mop.c;
        int z = mop.d;
        if (mop.face == 0) {
            --y;
        }
        if (mop.face == 1) {
            ++y;
        }
        if (mop.face == 2) {
            --z;
        }
        if (mop.face == 3) {
            ++z;
        }
        if (mop.face == 4) {
            --x;
        }
        if (mop.face == 5) {
            ++x;
        }
        if (!player.d(x, y, z)) {
            return itemStack;
        }
        if (!world.isEmpty(x, y, z) && world.getMaterial(x, y, z).isSolid()) {
            return itemStack;
        }
        if (world.worldProvider.d && this.contents == Block.WATER.id) {
            world.makeSound(px + 0.5, py + 0.5, pz + 0.5, "random.fizz", 0.5f, 2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f);
            for (int var5 = 0; var5 < 8; ++var5) {
                world.a("largesmoke", x + Math.random(), y + Math.random(), z + Math.random(), 0.0, 0.0, 0.0);
            }
        }
        else if (world.worldProvider.dimension == 2 && this.contents == Block.LAVA.id) {
            world.setTypeIdAndData(x, y, z, AetherBlocks.Aerogel.id, 0);
        }
        else if (world.getTypeId(mop.b, mop.c, mop.d) == Block.GLOWSTONE.id && ((BlockAetherPortal)AetherBlocks.Portal).tryToCreatePortal(world, x, y, z)) {
            world.setTypeIdAndData(x, y, z, AetherBlocks.Portal.id, 0);
        }
        else {
            world.setTypeIdAndData(x, y, z, this.contents, 0);
        }
        if (player.abilities.canInstantlyBuild) {
            return itemStack;
        }
        return new ItemStack(Item.BUCKET);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Item)this));
    }
}
