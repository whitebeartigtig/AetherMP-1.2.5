package net.minecraft.server;

import forge.*;

public class ItemAetherRecord extends ItemRecord implements ITextureProvider
{
    public String getTextureFile() {
        return "/aetherItems.png";
    }
    
    protected ItemAetherRecord(final int i, final String s) {
        super(i, s);
    }
    
    public boolean onItemUse(final ItemStack itemstack, final EntityPlayer entityplayer, final World world, final int i, final int j, final int k, final int l) {
        if (world.getTypeId(i, j, k) != Block.JUKEBOX.id || world.getData(i, j, k) != 0) {
            return false;
        }
        if (world.isStatic) {
            return true;
        }
        ((BlockJukeBox)Block.JUKEBOX).f(world, i, j, k, ((Item)this).id);
        world.a((EntityPlayer)null, 1005, i, j, k, ((Item)this).id);
        ModLoader.getMinecraftInstance().ingameGUI.setRecordPlayingMessage("Noisestorm - " + super.a);
        --itemstack.count;
        return true;
    }
}
