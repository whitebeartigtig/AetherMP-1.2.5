package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockAercloud extends Block implements ITextureProvider
{
    public static final int bouncingMeta = 1;
    
    protected BlockAercloud(final int blockID) {
        super(blockID, 0, Material.ICE);
        this.c(0.2f);
        this.f(3);
    }
    
    public void onEntityCollidedWithBlock(final World world, final int i, final int j, final int k, final Entity entity) {
        entity.fallDistance = 0.0f;
        if (world.getData(i, j, k) == 1) {
            entity.motY = 2.0;
            entity.fallDistance = -20.0f;
            if (entity instanceof EntityPlayer) {
                //mod_Aether.giveAchievement(AetherAchievements.blueCloud, (EntityPlayer)entity);
            }
        }
        else if (entity.motY < 0.0) {
            entity.motY *= 0.005;
        }
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    protected int damageDropped(final int i) {
        return i;
    }
    
    public int getRenderColor(final int i) {
        if (i == 1) {
            return 13434879;
        }
        if (i == 2) {
            return 16777088;
        }
        return 16777215;
    }
    
    public int colorMultiplier(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        return this.getRenderColor(iblockaccess.getData(i, j, k));
    }
    
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World world, final int i, final int j, final int k) {
        if (world.getData(i, j, k) == 1) {
            return AxisAlignedBB.b((double)i, (double)j, (double)k, (double)i, (double)j, (double)k);
        }
        return AxisAlignedBB.b((double)i, (double)j, (double)k, (double)(i + 1), (double)j, (double)(k + 1));
    }
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
        itemList.add(new ItemStack((Block)this, 1, 2));
    }
}
