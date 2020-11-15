package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockTreasureChest extends BlockChest implements ITextureProvider
{
    private Random random;
    private int sideTexture;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockTreasureChest(final int i, final int j, final int k) {
        super(i);
        this.random = new Random();
        ((Block)this).textureId = j;
        this.sideTexture = k;
        this.c(-1.0f);
    }
    
    public int quantityDropped(final Random random) {
        return 0;
    }
    
    public int getBlockTexture(final IBlockAccess iblockaccess, final int i, final int j, final int k, final int l) {
        if (l == 1) {
            return 62;
        }
        if (l == 0) {
            return 62;
        }
        final int i2 = iblockaccess.getTypeId(i, j, k - 1);
        final int j2 = iblockaccess.getTypeId(i, j, k + 1);
        final int k2 = iblockaccess.getTypeId(i - 1, j, k);
        final int l2 = iblockaccess.getTypeId(i + 1, j, k);
        byte byte0 = 3;
        if (Block.n[i2] && !Block.n[j2]) {
            byte0 = 3;
        }
        if (Block.n[j2] && !Block.n[i2]) {
            byte0 = 2;
        }
        if (Block.n[k2] && !Block.n[l2]) {
            byte0 = 5;
        }
        if (Block.n[l2] && !Block.n[k2]) {
            byte0 = 4;
        }
        return (l != byte0) ? this.sideTexture : ((Block)this).textureId;
    }
    
    public int getBlockTextureFromSide(final int i) {
        if (i == 1) {
            return 51;
        }
        if (i == 0) {
            return 51;
        }
        if (i == 3) {
            return ((Block)this).textureId;
        }
        return this.sideTexture;
    }
    
    public boolean canPlaceBlockAt(final World world, final int i, final int j, final int k) {
        return false;
    }
    
    public boolean blockActivated(final World world, final int i, final int j, final int k, final EntityPlayer entityplayer) {
        if (world.isStatic) {
            return true;
        }
        final TileEntityChest chest = (TileEntityChest)world.getTileEntity(i, j, k);
        final ItemStack itemstack = entityplayer.inventory.getItemInHand();
        if (itemstack != null && itemstack.id == AetherItems.Key.id && itemstack.getData() == 0) {
            ModLoader.openGUI(entityplayer, (GuiScreen)new GuiTreasureChest((IInventory)entityplayer.inventory, (IInventory)chest, 1));
            return true;
        }
        if (itemstack != null && itemstack.id == AetherItems.Key.id && itemstack.getData() == 1) {
            ModLoader.openGUI(entityplayer, (GuiScreen)new GuiTreasureChest((IInventory)entityplayer.inventory, (IInventory)chest, 3));
            return true;
        }
        if (itemstack != null && itemstack.id == AetherItems.Key.id && itemstack.getData() == 2) {
            ModLoader.openGUI(entityplayer, (GuiScreen)new GuiTreasureChest((IInventory)entityplayer.inventory, (IInventory)chest, 5));
            return true;
        }
        return false;
    }
    
    public void checkForAdjacentChests() {
    }
    
    public TileEntity getBlockEntity() {
        return (TileEntity)new TileEntityTreasureChest();
    }
}
