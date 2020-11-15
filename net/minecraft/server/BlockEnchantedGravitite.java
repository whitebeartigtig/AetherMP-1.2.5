package net.minecraft.server;

import forge.*;
import java.util.*;

public class BlockEnchantedGravitite extends BlockFloating implements ITextureProvider
{
    @Override
    public String getTextureFile() {
        return "/terrain.png";
    }
    
    public BlockEnchantedGravitite(final int i, final int j, final boolean bool) {
        super(i, j, bool);
        this.c(5.0f);
    }
    
    public int getRenderColor(final int i) {
        return 16755455;
    }
    
    public int colorMultiplier(final IBlockAccess iblockaccess, final int i, final int j, final int k) {
        return this.getRenderColor(iblockaccess.getData(i, j, k));
    }
    
    @Override
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new ItemStack((Block)this));
    }
}
