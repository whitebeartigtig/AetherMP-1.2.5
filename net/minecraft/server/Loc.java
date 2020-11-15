package net.minecraft.server;

import java.util.*;

public class Loc
{
    public final double x;
    public final double y;
    public final double z;
    
    public Loc() {
        this(0, 0, 0);
    }
    
    public Loc(final int i, final int j) {
        this(i, 0, j);
    }
    
    public Loc(final int i, final int j, final int k) {
        this(i, j, (double)k);
    }
    
    public Loc(final double d, final double d1) {
        this(d, 0.0, d1);
    }
    
    public Loc(final World world) {
        this(world.getSpawn().x, world.getSpawn().y, world.getSpawn().z);
    }
    
    public Loc(final Loc loc) {
        this(loc.x, loc.y, loc.z);
    }
    
    public Loc(final double d, final double d1, final double d2) {
        this.x = d;
        this.y = d1;
        this.z = d2;
    }
    
    public int x() {
        return (int)this.x;
    }
    
    public int y() {
        return (int)this.y;
    }
    
    public int z() {
        return (int)this.z;
    }
    
    public Loc add(final int i, final int j, final int k) {
        return new Loc(this.x + i, this.y + j, this.z + k);
    }
    
    public Loc add(final double d, final double d1, final double d2) {
        return new Loc(this.x + d, this.y + d1, this.z + d2);
    }
    
    public Loc add(final Loc loc) {
        return new Loc(this.x + loc.x, this.y + loc.y, this.z + loc.z);
    }
    
    public Loc subtract(final int i, final int j, final int k) {
        return new Loc(this.x - i, this.y - j, this.z - k);
    }
    
    public Loc subtract(final double d, final double d1, final double d2) {
        return new Loc(this.x - d, this.y - d1, this.z - d2);
    }
    
    public Loc subtract(final Loc loc) {
        return new Loc(this.x - loc.x, this.y - loc.y, this.z - loc.z);
    }
    
    public Loc multiply(final double d, final double d1, final double d2) {
        return new Loc(this.x * d, this.y * d1, this.z * d2);
    }
    
    public Loc getSide(final int i) {
        switch (i) {
            case 0: {
                return new Loc(this.x, this.y - 1.0, this.z);
            }
            case 1: {
                return new Loc(this.x, this.y + 1.0, this.z);
            }
            case 2: {
                return new Loc(this.x, this.y, this.z - 1.0);
            }
            case 3: {
                return new Loc(this.x, this.y, this.z + 1.0);
            }
            case 4: {
                return new Loc(this.x - 1.0, this.y, this.z);
            }
            case 5: {
                return new Loc(this.x + 1.0, this.y, this.z);
            }
            default: {
                return new Loc(this.x, this.y, this.z);
            }
        }
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Loc) {
            final Loc loc = (Loc)obj;
            return this.x == loc.x && this.y == loc.y && this.z == loc.z;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }
    
    public int distSimple(final Loc loc) {
        return (int)(Math.abs(this.x - loc.x) + Math.abs(this.y - loc.y) + Math.abs(this.z - loc.z));
    }
    
    public double distAdv(final Loc loc) {
        return Math.sqrt(Math.pow(this.x - loc.x, 2.0) + Math.pow(this.y - loc.y, 2.0) + Math.pow(this.z - loc.z, 2.0));
    }
    
    public static Loc[] vecAdjacent() {
        final Loc[] aloc = { new Loc(0, 0, 1), new Loc(0, 0, -1), new Loc(0, 1, 0), new Loc(0, -1, 0), new Loc(1, 0, 0), new Loc(-1, 0, 0) };
        return aloc;
    }
    
    public Loc[] adjacent() {
        final Loc[] aloc = vecAdjacent();
        for (int i = 0; i < aloc.length; ++i) {
            aloc[i] = this.add(aloc[i]);
        }
        return aloc;
    }
    
    public static Loc[] vecAdjacent2D() {
        final Loc[] aloc = { new Loc(0, 1), new Loc(0, -1), new Loc(1, 0), new Loc(-1, 0) };
        return aloc;
    }
    
    public Loc[] adjacent2D() {
        final Loc[] aloc = vecAdjacent();
        for (int i = 0; i < aloc.length; ++i) {
            aloc[i] = this.add(aloc[i]);
        }
        return aloc;
    }
    
    public static ArrayList vecInRadius(final int i, final boolean flag) {
        final ArrayList arraylist = new ArrayList();
        final Loc loc = new Loc();
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                for (int l = -i; l <= i; ++l) {
                    final Loc loc2 = new Loc(j, l, k);
                    final double d = flag ? loc.distAdv(loc2) : loc.distSimple(loc2);
                    if (d <= i) {
                        arraylist.add(loc2);
                    }
                }
            }
        }
        return arraylist;
    }
    
    public ArrayList inRadius(final int i, final boolean flag) {
        final ArrayList arraylist = new ArrayList();
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                for (int l = -i; l <= i; ++l) {
                    final Loc loc = new Loc(j, l, k).add(this);
                    final double d = flag ? this.distAdv(loc) : this.distSimple(loc);
                    if (d <= i) {
                        arraylist.add(loc);
                    }
                }
            }
        }
        return arraylist;
    }
    
    public static ArrayList vecInRadius2D(final int i, final boolean flag) {
        final ArrayList arraylist = new ArrayList();
        final Loc loc = new Loc();
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                final Loc loc2 = new Loc(j, k);
                final double d = flag ? loc.distAdv(loc2) : loc.distSimple(loc2);
                if (d <= i) {
                    arraylist.add(loc2);
                }
            }
        }
        return arraylist;
    }
    
    public ArrayList inRadius2D(final int i, final boolean flag) {
        final ArrayList arraylist = new ArrayList();
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                final Loc loc = new Loc(j, k).add(this);
                final double d = flag ? this.distAdv(loc) : this.distSimple(loc);
                if (d <= i) {
                    arraylist.add(loc);
                }
            }
        }
        return arraylist;
    }
    
    public int getBlock(final IBlockAccess iblockaccess) {
        return iblockaccess.getTypeId(this.x(), this.y(), this.z());
    }
    
    public Loc setBlockNotify(final World world, final int i) {
        world.setTypeId(this.x(), this.y(), this.z(), i);
        return this;
    }
    
    public Loc setRawTypeId(final World world, final int i) {
        world.setRawTypeId(this.x(), this.y(), this.z(), i);
        return this;
    }
    
    public int getMeta(final IBlockAccess iblockaccess) {
        return iblockaccess.getData(this.x(), this.y(), this.z());
    }
    
    public Loc setMeta(final World world, final int i) {
        world.setRawData(this.x(), this.y(), this.z(), i);
        return this;
    }
    
    public Loc setMetaNotify(final World world, final int i) {
        world.setData(this.x(), this.y(), this.z(), i);
        return this;
    }
    
    public Loc setBlockAndMeta(final World world, final int i, final int j) {
        world.setRawTypeIdAndData(this.x(), this.y(), this.z(), i, j);
        return this;
    }
    
    public Loc setBlockAndMetaNotify(final World world, final int i, final int j) {
        world.setTypeIdAndData(this.x(), this.y(), this.z(), i, j);
        return this;
    }
    
    public TileEntity getTileEntity(final IBlockAccess iblockaccess) {
        return iblockaccess.getTileEntity(this.x(), this.y(), this.z());
    }
    
    public Loc setTileEntity(final World world, final TileEntity tileentity) {
        world.setTileEntity(this.x(), this.y(), this.z(), tileentity);
        return this;
    }
    
    public Loc removeTileEntity(final World world) {
        world.q(this.x(), this.y(), this.z());
        return this;
    }
    
    public int getLight(final World world) {
        return world.m(this.x(), this.y(), this.z());
    }
    
    public Loc notify(final World world) {
        world.applyPhysics(this.x(), this.y(), this.z(), this.getBlock((IBlockAccess)world));
        return this;
    }
    
    public Loc setSpawnPoint(final World world) {
        world.setSpawnPoint(new ChunkCoordinates(this.x(), this.y(), this.z()));
        return this;
    }
}
