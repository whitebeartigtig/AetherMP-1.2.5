package net.minecraft.server;

import java.io.*;

public class AetherNBT
{
    public static void save(final World world) {
        try {
            final File f1 = GetWorldSaveLocation(world);
            final File f2 = new File(f1, "aether.dat");
            if (!f2.exists()) {
            	NBTCompressedStreamTools.a(new NBTTagCompound(), (OutputStream)new FileOutputStream(f2));
            }
            final NBTTagCompound compound = NBTCompressedStreamTools.a((InputStream)new FileInputStream(f2));
            compound.setBoolean("LoreOverworld", mod_Aether.hasLoreOverworld);
            compound.setBoolean("LoreNether", mod_Aether.hasLoreNether);
            compound.setBoolean("LoreAether", mod_Aether.hasLoreAether);
            NBTCompressedStreamTools.a(compound, (OutputStream)new FileOutputStream(f2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void load(final World world) {
        try {
            final File f1 = GetWorldSaveLocation(world);
            final File f2 = new File(f1, "aether.dat");
            if (!f2.exists()) {
                NBTCompressedStreamTools.a(new NBTTagCompound(), (OutputStream)new FileOutputStream(f2));
            }
            final NBTTagCompound compound = NBTCompressedStreamTools.a((InputStream)new FileInputStream(f2));
            mod_Aether.hasLoreOverworld = compound.getBoolean("LoreOverworld");
            mod_Aether.hasLoreNether = compound.getBoolean("LoreNether");
            mod_Aether.hasLoreAether = compound.getBoolean("LoreAether");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static File GetWorldSaveLocation(final World world) {
        return ((WorldNBTStorage)world.dataManager).getDirectory();
    }
}
