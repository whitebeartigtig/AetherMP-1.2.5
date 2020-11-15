package net.minecraft.server;

public class ItemSkyrootBucket extends AetherItem
{
    public static int sprEmpty;
    public static int sprWater;
    public static int sprMilk;
    public static int sprPoison;
    public static int sprRemedy;
    
    public ItemSkyrootBucket(final int i) {
        super(i);
        this.a(true);
        super.maxStackSize = 1;
    }
    
    public int getIconFromDamage(final int damage) {
        if (damage == 3) {
            return ItemSkyrootBucket.sprRemedy;
        }
        if (damage == 2) {
            return ItemSkyrootBucket.sprPoison;
        }
        if (damage == 1) {
            return ItemSkyrootBucket.sprMilk;
        }
        if (damage == Block.WATER.id) {
            return ItemSkyrootBucket.sprWater;
        }
        return ItemSkyrootBucket.sprEmpty;
    }
    
    public String getItemNameIS(final ItemStack stack) {
        int i = stack.getData();
        if (i > 3 && i != Block.WATER.id) {
            i = 0;
        }
        return this.getName() + i;
    }
    
    public ItemStack onItemRightClick(final ItemStack itemstack, final World world, final EntityPlayer entityplayer) {
        final float f = 1.0f;
        final float f2 = ((Entity)entityplayer).lastPitch + (((Entity)entityplayer).pitch - ((Entity)entityplayer).lastPitch) * f;
        final float f3 = ((Entity)entityplayer).lastYaw + (((Entity)entityplayer).yaw - ((Entity)entityplayer).lastYaw) * f;
        final double d = ((Entity)entityplayer).lastX + (((Entity)entityplayer).locX - ((Entity)entityplayer).lastX) * f;
        final double d2 = ((Entity)entityplayer).lastY + (((Entity)entityplayer).locY - ((Entity)entityplayer).lastY) * f + 1.62 - ((Entity)entityplayer).height;
        final double d3 = ((Entity)entityplayer).lastZ + (((Entity)entityplayer).locZ - ((Entity)entityplayer).lastZ) * f;
        final Vec3D vec3d = Vec3D.create(d, d2, d3);
        final float f4 = MathHelper.cos(-f3 * 0.01745329f - 3.141593f);
        final float f5 = MathHelper.sin(-f3 * 0.01745329f - 3.141593f);
        final float f6 = -MathHelper.cos(-f2 * 0.01745329f);
        final float f7 = MathHelper.sin(-f2 * 0.01745329f);
        final float f8 = f5 * f6;
        final float f9 = f7;
        final float f10 = f4 * f6;
        final double d4 = 5.0;
        final Vec3D vec3d2 = vec3d.add(f8 * d4, f9 * d4, f10 * d4);
        final MovingObjectPosition movingobjectposition = world.rayTrace(vec3d, vec3d2, itemstack.getData() == 0);
        if (itemstack.getData() == 2 && (ModLoader.getMinecraftInstance().objectMouseOver == null || ModLoader.getMinecraftInstance().objectMouseOver.entityHit == null || !(ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityAechorPlant))) {
            if (AetherPoison.afflictPoison()) {
                itemstack.setData(0);
                return itemstack;
            }
        }
        else if (itemstack.getData() == 3 && AetherPoison.curePoison()) {
            itemstack.setData(0);
            return itemstack;
        }
        if (movingobjectposition != null && movingobjectposition.type == EnumMovingObjectType.TILE && (itemstack.getData() == 0 || itemstack.getData() == Block.WATER.id)) {
            int i = movingobjectposition.b;
            int j = movingobjectposition.c;
            int k = movingobjectposition.d;
            if (!world.a(entityplayer, i, j, k)) {
                return itemstack;
            }
            if (itemstack.getData() == 0) {
                if (world.getMaterial(i, j, k) == Material.WATER && world.getData(i, j, k) == 0) {
                    world.setTypeId(i, j, k, 0);
                    itemstack.setData(Block.WATER.id);
                    return itemstack;
                }
            }
            else {
                if (itemstack.getData() <= 3 && itemstack.getData() != 0) {
                    return new ItemStack(AetherItems.Bucket);
                }
                if (movingobjectposition.face == 0) {
                    --j;
                }
                if (movingobjectposition.face == 1) {
                    ++j;
                }
                if (movingobjectposition.face == 2) {
                    --k;
                }
                if (movingobjectposition.face == 3) {
                    ++k;
                }
                if (movingobjectposition.face == 4) {
                    --i;
                }
                if (movingobjectposition.face == 5) {
                    ++i;
                }
                if (world.isEmpty(i, j, k) || !world.getMaterial(i, j, k).isSolid()) {
                    if (world.worldProvider.d && itemstack.getData() == Block.WATER.id) {
                        world.makeSound(d + 0.5, d2 + 0.5, d3 + 0.5, "random.fizz", 0.5f, 2.6f + (world.random.nextFloat() - world.random.nextFloat()) * 0.8f);
                        for (int l = 0; l < 8; ++l) {
                            world.a("largesmoke", i + Math.random(), j + Math.random(), k + Math.random(), 0.0, 0.0, 0.0);
                        }
                    }
                    else {
                        world.setTypeIdAndData(i, j, k, itemstack.getData(), 0);
                    }
                    return new ItemStack(AetherItems.Bucket);
                }
            }
        }
        else if (itemstack.getData() == 0 && ModLoader.getMinecraftInstance().objectMouseOver != null && ModLoader.getMinecraftInstance().objectMouseOver.entityHit != null && (ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityCow || ModLoader.getMinecraftInstance().objectMouseOver.entityHit instanceof EntityFlyingCow)) {
            itemstack.setData(1);
            return itemstack;
        }
        return itemstack;
    }
    
    static {
        ItemSkyrootBucket.sprEmpty = 10;
        ItemSkyrootBucket.sprWater = 14;
        ItemSkyrootBucket.sprMilk = 11;
        ItemSkyrootBucket.sprPoison = 12;
        ItemSkyrootBucket.sprRemedy = 13;
    }
}
