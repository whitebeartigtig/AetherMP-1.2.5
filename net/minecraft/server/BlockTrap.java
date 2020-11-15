package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockTrap extends BlockHalfTransparant implements ITextureProvider
{
    public static int sprBronze;
    public static int sprSilver;
    public static int sprGold;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    public BlockTrap(final int blockID) {
        super(blockID, BlockTrap.sprBronze, Material.STONE, false);
        this.a(true);
        this.c(-1.0f);
        this.b(1000000.0f);
    }
    
    public boolean isOpaqueCube() {
        return true;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (j == 2) {
            return BlockTrap.sprGold;
        }
        if (j == 1) {
            return BlockTrap.sprSilver;
        }
        return BlockTrap.sprBronze;
    }
    
    public int quantityDropped(final Random random) {
        return 1;
    }
    
    public void onEntityWalking(final World world, final int i, final int j, final int k, final Entity entity) {
        if (entity instanceof EntityPlayer) {
            final int x = MathHelper.floor((double)i);
            final int y = MathHelper.floor((double)j);
            final int z = MathHelper.floor((double)k);
            switch (world.getData(i, j, k)) {
                case 0: {
                    final EntitySentry entitysentry = new EntitySentry(world);
                    entitysentry.setPosition(x + 0.5, y + 1.5, z + 0.5);
                    world.addEntity((Entity)entitysentry);
                    break;
                }
                case 1: {
                    final EntityValkyrie entityvalk = new EntityValkyrie(world);
                    entityvalk.setPosition(x + 0.5, y + 1.5, z + 0.5);
                    world.addEntity((Entity)entityvalk);
                    break;
                }
            }
            world.setTypeIdAndData(i, j, k, AetherBlocks.LockedDungeonStone.id, world.getData(i, j, k));
        }
    }
    
    protected int damageDropped(final int i) {
        return i;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
        itemList.add(new ItemStack((Block)this, 1, 2));
    }
    
    static {
        BlockTrap.sprBronze = 5;
        BlockTrap.sprSilver = 4;
        BlockTrap.sprGold = 18;
    }
}
