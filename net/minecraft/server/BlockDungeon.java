package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockDungeon extends Block implements ITextureProvider
{
    public static int sprBronze;
    public static int sprSilver;
    public static int sprGold;
    public static int sprBronzeLit;
    public static int sprSilverLit;
    public static int sprGoldLit;
    
    public String getTextureFile() {
        return "/aetherBlocks.png";
    }
    
    protected BlockDungeon(final int i, final float hardness, final float light) {
        super(i, Material.STONE);
        this.c(hardness);
        this.a(light);
    }
    
    protected BlockDungeon(final int i, final float hardness, final float light, final float resistance) {
        this(i, hardness, light);
        this.b(resistance);
    }
    
    public int getBlockTextureFromSideAndMetadata(final int i, final int j) {
        if (j == 2) {
            return this.isLit() ? BlockDungeon.sprGoldLit : BlockDungeon.sprGold;
        }
        if (j == 1) {
            return this.isLit() ? BlockDungeon.sprSilverLit : BlockDungeon.sprSilver;
        }
        return this.isLit() ? BlockDungeon.sprBronzeLit : BlockDungeon.sprBronze;
    }
    
    private boolean isLit() {
        return super.id == AetherBlocks.LightDungeonStone.id || super.id == AetherBlocks.LockedLightDungeonStone.id;
    }
    
    protected int damageDropped(final int i) {
        return i;
    }
    
    public static int getBlockFromDye(final int i) {
        return ~i & 0xF;
    }
    
    public static int getDyeFromBlock(final int i) {
        return ~i & 0xF;
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this, 1, 0));
        itemList.add(new ItemStack((Block)this, 1, 1));
        itemList.add(new ItemStack((Block)this, 1, 2));
    }
    
    static {
        BlockDungeon.sprBronze = BlockTrap.sprBronze;
        BlockDungeon.sprSilver = BlockTrap.sprSilver;
        BlockDungeon.sprGold = BlockTrap.sprGold;
        BlockDungeon.sprBronzeLit = 26;
        BlockDungeon.sprSilverLit = 25;
        BlockDungeon.sprGoldLit = 27;
    }
}
