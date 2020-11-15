package net.minecraft.server;

import java.util.*;

public class AetherGenDungeonBronze extends AetherGenBuildings
{
    private int corridorMeta1;
    private int corridorMeta2;
    private int lockedBlockID1;
    private int lockedBlockID2;
    private int wallBlockID1;
    private int wallBlockID2;
    private int corridorBlockID1;
    private int corridorBlockID2;
    private int numRooms;
    private int n;
    private boolean finished;
    private boolean flat;
    
    public AetherGenDungeonBronze(final int i, final int j, final int k, final int l, final int m, final int m1, final int o, final int o1, final int p, final boolean flag) {
        this.lockedBlockID1 = i;
        this.lockedBlockID2 = j;
        this.wallBlockID1 = k;
        this.wallBlockID2 = l;
        this.corridorBlockID1 = m;
        this.corridorMeta1 = m1;
        this.corridorBlockID2 = o;
        this.corridorMeta2 = o1;
        this.numRooms = p;
        this.flat = flag;
        this.finished = false;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        super.replaceAir = true;
        super.replaceSolid = true;
        this.n = 0;
        if (!this.isBoxSolid(world, i, j, k, 16, 12, 16) || !this.isBoxSolid(world, i + 20, j, k + 2, 12, 12, 12)) {
            return false;
        }
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 20);
        this.addHollowBox(world, random, i, j, k, 16, 12, 16);
        this.addHollowBox(world, random, i + 6, j - 2, k + 6, 4, 4, 4);
        final EntitySlider slider = new EntitySlider(world);
        slider.setPosition((double)(i + 8), (double)(j + 2), (double)(k + 8));
        slider.setDungeon(i, j, k);
        world.addEntity((Entity)slider);
        int x = i + 7 + random.nextInt(2);
        int y = j - 1;
        int z = k + 7 + random.nextInt(2);
        world.setTypeId(x, y, z, AetherBlocks.TreasureChest.id);
        final TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y, z);
        for (int p = 0; p < 3 + random.nextInt(3); ++p) {
            final ItemStack item = this.getBronzeLoot(random);
            chest.setItem(random.nextInt(chest.getSize()), item);
        }
        x = i + 20;
        y = j;
        z = k + 2;
        if (!this.isBoxSolid(world, x, y, z, 12, 12, 12)) {
            return true;
        }
        this.setBlocks(this.wallBlockID1, this.wallBlockID2, 20);
        this.addHollowBox(world, random, x, y, z, 12, 12, 12);
        this.setBlocks(this.corridorBlockID2, this.corridorBlockID1, 5);
        this.setMetadata(this.corridorMeta2, this.corridorMeta1);
        this.addSquareTube(world, random, x - 5, y, z + 3, 6, 6, 6, 0);
        for (int p = x + 2; p < x + 10; p += 3) {
            for (int q = z + 2; q < z + 10; q += 3) {
                world.setRawTypeIdAndData(p, j, q, AetherBlocks.Trap.id, 0);
            }
        }
        ++this.n;
        this.generateNextRoom(world, random, x, y, z);
        this.generateNextRoom(world, random, x, y, z);
        if (this.n > this.numRooms || !this.finished) {
            this.endCorridor(world, random, x, y, z);
        }
        return true;
    }
    
    public boolean generateNextRoom(final World world, final Random random, final int i, final int j, final int k) {
        if (this.n > this.numRooms && !this.finished) {
            this.endCorridor(world, random, i, j, k);
            return false;
        }
        final int dir = random.nextInt(4);
        int x = i;
        final int y = j;
        int z = k;
        if (dir == 0) {
            x += 16;
            z += 0;
        }
        if (dir == 1) {
            x += 0;
            z += 16;
        }
        if (dir == 2) {
            x -= 16;
            z += 0;
        }
        if (dir == 3) {
            x += 0;
            z -= 16;
        }
        if (!this.isBoxSolid(world, x, y, z, 12, 8, 12)) {
            return false;
        }
        this.setBlocks(this.wallBlockID1, this.wallBlockID2, 20);
        this.setMetadata(0, 0);
        this.addHollowBox(world, random, x, y, z, 12, 8, 12);
        for (int p = x; p < x + 12; ++p) {
            for (int q = y; q < y + 8; ++q) {
                for (int r = z; r < z + 12; ++r) {
                    if (world.getTypeId(p, q, r) == this.wallBlockID1 && random.nextInt(100) == 0) {
                        world.setRawTypeId(p, q, r, AetherBlocks.Trap.id);
                    }
                }
            }
        }
        for (int p = x + 2; p < x + 10; p += 7) {
            for (int q = z + 2; q < z + 10; q += 7) {
                world.setRawTypeIdAndData(p, j, q, AetherBlocks.Trap.id, 0);
            }
        }
        this.addPlaneY(world, random, x + 4, y + 1, z + 4, 4, 4);
        final int type = random.nextInt(2);
        int p2 = x + 5 + random.nextInt(2);
        final int q2 = z + 5 + random.nextInt(2);
        switch (type) {
            case 0: {
                world.setTypeId(p2, y + 2, q2, AetherBlocks.ChestMimic.id);
                break;
            }
            case 1: {
                if (world.getTypeId(p2, y + 2, q2) == 0) {
                    world.setTypeId(p2, y + 2, q2, Block.CHEST.id);
                    final TileEntityChest chest = (TileEntityChest)world.getTileEntity(p2, y + 2, q2);
                    for (p2 = 0; p2 < 3 + random.nextInt(3); ++p2) {
                        final ItemStack item = this.getNormalLoot(random);
                        chest.setItem(random.nextInt(chest.getSize()), item);
                    }
                    break;
                }
                break;
            }
        }
        this.setBlocks(this.corridorBlockID2, this.corridorBlockID1, 5);
        this.setMetadata(this.corridorMeta2, this.corridorMeta1);
        switch (dir) {
            case 0: {
                this.addSquareTube(world, random, x - 5, y, z + 3, 6, 6, 6, 0);
                break;
            }
            case 1: {
                this.addSquareTube(world, random, x + 3, y, z - 5, 6, 6, 6, 2);
                break;
            }
            case 2: {
                this.addSquareTube(world, random, x + 11, y, z + 3, 6, 6, 6, 0);
                break;
            }
            case 3: {
                this.addSquareTube(world, random, x + 3, y, z + 11, 6, 6, 6, 2);
                break;
            }
        }
        ++this.n;
        return this.generateNextRoom(world, random, x, y, z) && this.generateNextRoom(world, random, x, y, z);
    }
    
    public void endCorridor(final World world, final Random random, final int i, final int j, final int k) {
        super.replaceAir = false;
        boolean tunnelling = true;
        final int dir = random.nextInt(3);
        int x = i;
        final int y = j;
        int z = k;
        if (dir == 0) {
            x += 11;
            z += 3;
            while (tunnelling) {
                if (this.isBoxEmpty(world, x, y, z, 1, 8, 6) || x - i > 100) {
                    tunnelling = false;
                }
                boolean flag = true;
                while (flag && (world.getTypeId(x, y, z) == this.wallBlockID1 || world.getTypeId(x, y, z) == this.wallBlockID2 || world.getTypeId(x, y, z) == this.lockedBlockID1 || world.getTypeId(x, y, z) == this.lockedBlockID2)) {
                    if (world.getTypeId(x + 1, y, z) == this.wallBlockID1 || world.getTypeId(x + 1, y, z) == this.wallBlockID2 || world.getTypeId(x + 1, y, z) == this.lockedBlockID1 || world.getTypeId(x + 1, y, z) == this.lockedBlockID2) {
                        ++x;
                    }
                    else {
                        flag = false;
                    }
                }
                this.setBlocks(this.corridorBlockID2, this.corridorBlockID1, 5);
                this.setMetadata(this.corridorMeta2, this.corridorMeta1);
                this.addPlaneX(world, random, x, y, z, 8, 6);
                this.setBlocks(0, 0, 1);
                this.addPlaneX(world, random, x, y + 1, z + 1, 6, 4);
                ++x;
            }
        }
        if (dir == 1) {
            x += 3;
            z += 11;
            while (tunnelling) {
                if (this.isBoxEmpty(world, x, y, z, 6, 8, 1) || z - k > 100) {
                    tunnelling = false;
                }
                boolean flag = true;
                while (flag && (world.getTypeId(x, y, z) == this.wallBlockID1 || world.getTypeId(x, y, z) == this.wallBlockID2 || world.getTypeId(x, y, z) == this.lockedBlockID1 || world.getTypeId(x, y, z) == this.lockedBlockID2)) {
                    if (world.getTypeId(x, y, z + 1) == this.wallBlockID1 || world.getTypeId(x, y, z + 1) == this.wallBlockID2 || world.getTypeId(x, y, z + 1) == this.lockedBlockID1 || world.getTypeId(x, y, z + 1) == this.lockedBlockID2) {
                        ++z;
                    }
                    else {
                        flag = false;
                    }
                }
                this.setBlocks(this.corridorBlockID2, this.corridorBlockID1, 5);
                this.setMetadata(this.corridorMeta2, this.corridorMeta1);
                this.addPlaneZ(world, random, x, y, z, 6, 8);
                this.setBlocks(0, 0, 1);
                this.addPlaneZ(world, random, x + 1, y + 1, z, 4, 6);
                ++z;
            }
        }
        if (dir == 2) {
            x += 3;
            z += 0;
            while (tunnelling) {
                if (this.isBoxEmpty(world, x, y, z, 6, 8, 1) || j - z > 100) {
                    tunnelling = false;
                }
                boolean flag = true;
                while (flag && (world.getTypeId(x, y, z) == this.wallBlockID1 || world.getTypeId(x, y, z) == this.wallBlockID2 || world.getTypeId(x, y, z) == this.lockedBlockID1 || world.getTypeId(x, y, z) == this.lockedBlockID2)) {
                    if (world.getTypeId(x, y, z - 1) == this.wallBlockID1 || world.getTypeId(x, y, z - 1) == this.wallBlockID2 || world.getTypeId(x, y, z - 1) == this.lockedBlockID1 || world.getTypeId(x, y, z - 1) == this.lockedBlockID2) {
                        --z;
                    }
                    else {
                        flag = false;
                    }
                }
                this.setBlocks(this.corridorBlockID2, this.corridorBlockID1, 5);
                this.setMetadata(this.corridorMeta2, this.corridorMeta1);
                this.addPlaneZ(world, random, x, y, z, 6, 8);
                this.setBlocks(0, 0, 1);
                this.addPlaneZ(world, random, x + 1, y + 1, z, 4, 6);
                --z;
            }
        }
        this.finished = true;
    }
    
    private ItemStack getNormalLoot(final Random random) {
        final int item = random.nextInt(14);
        switch (item) {
            case 0: {
                return new ItemStack(AetherItems.PickZanite);
            }
            case 1: {
                return new ItemStack(AetherItems.AxeZanite);
            }
            case 2: {
                return new ItemStack(AetherItems.SwordZanite);
            }
            case 3: {
                return new ItemStack(AetherItems.ShovelZanite);
            }
            case 4: {
                return new ItemStack(AetherItems.AetherCape);
            }
            case 5: {
                return new ItemStack(AetherItems.AmbrosiumShard, random.nextInt(10) + 1);
            }
            case 6: {
                return new ItemStack(AetherItems.Dart, random.nextInt(5) + 1, 0);
            }
            case 7: {
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 1);
            }
            case 8: {
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 2);
            }
            case 9: {
                if (random.nextInt(20) == 0) {
                    return new ItemStack(AetherItems.BlueMusicDisk);
                }
                break;
            }
            case 10: {
                return new ItemStack(AetherItems.Bucket);
            }
            case 11: {
                if (random.nextInt(10) == 0) {
                    return new ItemStack(Item.byId[Item.RECORD_1.id + random.nextInt(2)]);
                }
                break;
            }
            case 12: {
                if (random.nextInt(4) == 0) {
                    return new ItemStack(AetherItems.IronRing);
                }
                break;
            }
            case 13: {
                if (random.nextInt(10) == 0) {
                    return new ItemStack(AetherItems.GoldRing);
                }
                break;
            }
        }
        return new ItemStack(AetherBlocks.AmbrosiumTorch);
    }
    
    private ItemStack getBronzeLoot(final Random random) {
        final int item = random.nextInt(8);
        switch (item) {
            case 0: {
                return new ItemStack(AetherItems.GummieSwet, random.nextInt(8), random.nextInt(2));
            }
            case 1: {
                return new ItemStack(AetherItems.PhoenixBow);
            }
            case 2: {
                return new ItemStack(AetherItems.SwordFire);
            }
            case 3: {
                return new ItemStack(AetherItems.HammerNotch);
            }
            case 4: {
                return new ItemStack(AetherItems.LightningKnife, random.nextInt(16));
            }
            case 5: {
                return new ItemStack(AetherItems.Lance);
            }
            case 6: {
                return new ItemStack(AetherItems.AgilityCape);
            }
            case 7: {
                return new ItemStack(AetherItems.SentryBoots);
            }
            default: {
                return new ItemStack(AetherItems.Stick);
            }
        }
    }
}
