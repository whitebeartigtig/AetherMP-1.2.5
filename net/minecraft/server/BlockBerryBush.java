package net.minecraft.server;

import java.util.*;

public class BlockBerryBush extends BlockAetherFlower
{
    @Override
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockBerryBush(final int var1) {
        super(var1, 50);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.c(0.2f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int i, final int j, final int k) {
        return AxisAlignedBB.b(i + ((Block)this).minX, j + ((Block)this).minY, k + ((Block)this).minZ, i + ((Block)this).maxX, j + ((Block)this).maxY, k + ((Block)this).maxZ);
    }
    
    public void onBlockRemoval(final World world, final int x, final int y, final int z) {
        final EntityPlayer entityplayer = (EntityPlayer)ModLoader.getMinecraftInstance().thePlayer;
        final Random random = new Random();
        int min;
        int max;
        if (world.getTypeId(x, y - 1, z) == mod_Aether.idBlockAetherGrass && world.getData(x, y - 1, z) == 1) {
            min = 1;
            max = 3;
        }
        else {
            min = 0;
            max = 2;
        }
        final int randomNum = random.nextInt(max - min + 1) + min;
        entityplayer.a(StatisticList.C[((Block)this).id], 1);
        if (randomNum != 0) {
            final ItemStack stack = new ItemStack(AetherItems.BlueBerry.id, randomNum, 0);
            final EntityItem entityitem = new EntityItem(world, (double)x, (double)y, (double)z, stack);
            entityitem.pickupDelay = 10;
            world.addEntity((Entity)entityitem);
        }
        world.setTypeId(x, y, z, AetherBlocks.BushStem.id);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public int getRenderType() {
        return mod_Aether.renderID;
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
