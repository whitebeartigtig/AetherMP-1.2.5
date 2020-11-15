package net.minecraft.server;

import java.util.*;

public class AetherGenDungeonSilver extends AetherGenBuildings
{
    private int baseMeta1;
    private int baseMeta2;
    private int lockedBlockID1;
    private int lockedBlockID2;
    private int wallBlockID1;
    private int wallBlockID2;
    private int baseID1;
    private int baseID2;
    private int columnID;
    private int[][][] rooms;
    
    public AetherGenDungeonSilver(final int i, final int j, final int k, final int l, final int m, final int m1, final int o, final int o1, final int p) {
        this.rooms = new int[3][3][3];
        this.lockedBlockID1 = i;
        this.lockedBlockID2 = j;
        this.wallBlockID1 = k;
        this.wallBlockID2 = l;
        this.baseID1 = m;
        this.baseMeta1 = m1;
        this.baseID2 = o;
        this.baseMeta2 = o1;
        this.columnID = p;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int j, final int k) {
        super.replaceAir = true;
        if (!this.isBoxEmpty(world, i, j, k, 55, 20, 30)) {
            return false;
        }
        if (world.getTypeId(i, j - 5, k) == 0 || world.getTypeId(i + 55, j - 5, k) == 0 || world.getTypeId(i, j - 5, k + 30) == 0 || world.getTypeId(i + 55, j - 5, k + 30) == 0) {
            for (int n = 0; n < 100; ++n) {
                final int x = i - 11 + random.nextInt(77);
                final int y = j - 7;
                final int z = k - 10 + random.nextInt(50);
                new AetherGenClouds(AetherBlocks.Aercloud.id, 0, 10, false).generate(world, random, x, y, z);
            }
        }
        super.replaceSolid = true;
        this.setBlocks(this.baseID2, this.baseID1, 30);
        this.setMetadata(this.baseMeta2, this.baseMeta1);
        this.addSolidBox(world, random, i, j - 5, k, 55, 5, 30);
        for (int x2 = i; x2 < i + 55; x2 += 4) {
            this.addColumn(world, random, x2, j, k, 14);
            this.addColumn(world, random, x2, j, k + 27, 14);
        }
        for (int z2 = k; z2 < k + 12; z2 += 4) {
            this.addColumn(world, random, i, j, z2, 14);
            this.addColumn(world, random, i + 52, j, z2, 14);
        }
        for (int z2 = k + 19; z2 < k + 30; z2 += 4) {
            this.addColumn(world, random, i, j, z2, 14);
            this.addColumn(world, random, i + 52, j, z2, 14);
        }
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 20);
        this.setMetadata(1, 1);
        this.addHollowBox(world, random, i + 4, j - 1, k + 4, 47, 16, 22);
        this.addPlaneX(world, random, i + 11, j, k + 5, 15, 20);
        this.addPlaneX(world, random, i + 18, j, k + 5, 15, 20);
        this.addPlaneX(world, random, i + 25, j, k + 5, 15, 20);
        this.addPlaneZ(world, random, i + 5, j, k + 11, 20, 15);
        this.addPlaneZ(world, random, i + 5, j, k + 18, 20, 15);
        this.setBlocks(this.lockedBlockID1, AetherBlocks.Trap.id, 15);
        this.setMetadata(1, 1);
        this.addPlaneY(world, random, i + 5, j + 4, k + 5, 20, 20);
        this.addPlaneY(world, random, i + 5, j + 9, k + 5, 20, 20);
        for (int y2 = j; y2 < j + 2; ++y2) {
            for (int z3 = k + 14; z3 < k + 16; ++z3) {
                world.setRawTypeId(i + 4, y2, z3, 0);
            }
        }
        this.setBlocks(0, 0, 1);
        this.addSolidBox(world, random, i, j - 4, k + 14, 1, 4, 2);
        this.addSolidBox(world, random, i + 1, j - 3, k + 14, 1, 3, 2);
        this.addSolidBox(world, random, i + 2, j - 2, k + 14, 1, 2, 2);
        this.addSolidBox(world, random, i + 3, j - 1, k + 14, 1, 1, 2);
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 20);
        this.setMetadata(1, 1);
        for (int y2 = 0; y2 < 7; ++y2) {
            this.addPlaneY(world, random, i - 1, j + 15 + y2, k - 1 + 2 * y2, 57, 32 - 4 * y2);
        }
        int row = random.nextInt(3);
        this.addStaircase(world, random, i + 19, j, k + 5 + row * 7, 10);
        this.rooms[2][0][row] = 2;
        this.rooms[2][1][row] = 2;
        this.rooms[2][2][row] = 1;
        int x = i + 25;
        for (int y = j; y < j + 2; ++y) {
            for (int z = k + 7 + 7 * row; z < k + 9 + 7 * row; ++z) {
                world.setRawTypeId(x, y, z, 0);
            }
        }
        row = random.nextInt(3);
        this.addStaircase(world, random, i + 12, j, k + 5 + row * 7, 5);
        this.rooms[1][0][row] = 1;
        this.rooms[1][1][row] = 1;
        row = random.nextInt(3);
        this.addStaircase(world, random, i + 5, j + 5, k + 5 + row * 7, 5);
        this.rooms[0][0][row] = 1;
        this.rooms[0][1][row] = 1;
        for (int p = 0; p < 3; ++p) {
            for (int q = 0; q < 3; ++q) {
                for (int r = 0; r < 3; ++r) {
                    int type = this.rooms[p][q][r];
                    if (p + 1 < 3 && (type == 0 || type == 1 || random.nextBoolean()) && type != 2) {
                        final int newType = this.rooms[p + 1][q][r];
                        if (newType != 2 && (newType != 1 || type != 1)) {
                            this.rooms[p][q][r] = 3;
                            type = 3;
                            x = i + 11 + 7 * p;
                            for (int y = j + 5 * q; y < j + 2 + 5 * q; ++y) {
                                for (int z = k + 7 + 7 * r; z < k + 9 + 7 * r; ++z) {
                                    world.setRawTypeId(x, y, z, 0);
                                }
                            }
                        }
                    }
                    if (p - 1 > 0 && (type == 0 || type == 1 || random.nextBoolean()) && type != 2) {
                        final int newType = this.rooms[p - 1][q][r];
                        if (newType != 2 && (newType != 1 || type != 1)) {
                            this.rooms[p][q][r] = 4;
                            type = 4;
                            x = i + 4 + 7 * p;
                            for (int y = j + 5 * q; y < j + 2 + 5 * q; ++y) {
                                for (int z = k + 7 + 7 * r; z < k + 9 + 7 * r; ++z) {
                                    world.setRawTypeId(x, y, z, 0);
                                }
                            }
                        }
                    }
                    if (r + 1 < 3 && (type == 0 || type == 1 || random.nextBoolean()) && type != 2) {
                        final int newType = this.rooms[p][q][r + 1];
                        if (newType != 2 && (newType != 1 || type != 1)) {
                            this.rooms[p][q][r] = 5;
                            type = 5;
                            final int z = k + 11 + 7 * r;
                            for (int y = j + 5 * q; y < j + 2 + 5 * q; ++y) {
                                for (int x1 = i + 7 + 7 * p; x1 < i + 9 + 7 * p; ++x1) {
                                    world.setRawTypeId(x1, y, z, 0);
                                }
                            }
                        }
                    }
                    if (r - 1 > 0 && (type == 0 || type == 1 || random.nextBoolean()) && type != 2) {
                        final int newType = this.rooms[p][q][r - 1];
                        if (newType != 2 && (newType != 1 || type != 1)) {
                            this.rooms[p][q][r] = 6;
                            type = 6;
                            final int z = k + 4 + 7 * r;
                            for (int y = j + 5 * q; y < j + 2 + 5 * q; ++y) {
                                for (int x1 = i + 7 + 7 * p; x1 < i + 9 + 7 * p; ++x1) {
                                    world.setRawTypeId(x1, y, z, 0);
                                }
                            }
                        }
                    }
                    final int roomType = random.nextInt(3);
                    if (type >= 3) {
                        switch (roomType) {
                            case 0: {
                                world.setRawTypeIdAndData(i + 7 + p * 7, j - 1 + q * 5, k + 7 + r * 7, AetherBlocks.Trap.id, 1);
                                break;
                            }
                            case 1: {
                                this.addPlaneY(world, random, i + 7 + 7 * p, j + 5 * q, k + 7 + 7 * r, 2, 2);
                                int u = i + 7 + 7 * p + random.nextInt(2);
                                final int v = k + 7 + 7 * r + random.nextInt(2);
                                if (world.getTypeId(u, j + 5 * q + 1, v) == 0) {
                                    world.setTypeId(u, j + 5 * q + 1, v, Block.CHEST.id);
                                    final TileEntityChest chest = (TileEntityChest)world.getTileEntity(u, j + 5 * q + 1, v);
                                    for (u = 0; u < 3 + random.nextInt(3); ++u) {
                                        final ItemStack item = this.getNormalLoot(random);
                                        chest.setItem(random.nextInt(chest.getSize()), item);
                                    }
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                this.addPlaneY(world, random, i + 7 + 7 * p, j + 5 * q, k + 7 + 7 * r, 2, 2);
                                world.setTypeId(i + 7 + 7 * p + random.nextInt(2), j + 5 * q + 1, k + 7 + 7 * r + random.nextInt(2), AetherBlocks.ChestMimic.id);
                                world.setTypeId(i + 7 + 7 * p + random.nextInt(2), j + 5 * q + 1, k + 7 + 7 * r + random.nextInt(2), AetherBlocks.ChestMimic.id);
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (x = 0; x < 24; ++x) {
            for (int z = 0; z < 20; ++z) {
                final int distance = (int)(Math.sqrt(x * x + (z - 7) * (z - 7)) + Math.sqrt(x * x + (z - 12) * (z - 12)));
                if (distance == 21) {
                    world.setRawTypeIdAndData(i + 26 + x, j, k + 5 + z, this.lockedBlockID2, 1);
                }
                else if (distance > 21) {
                    world.setRawTypeIdAndData(i + 26 + x, j, k + 5 + z, this.lockedBlockID1, 1);
                }
            }
        }
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID1, 1);
        this.setMetadata(1, 1);
        this.addPlaneY(world, random, i + 44, j + 1, k + 11, 6, 8);
        this.addSolidBox(world, random, i + 46, j + 2, k + 13, 4, 2, 4);
        this.addLineX(world, random, i + 46, j + 4, k + 13, 4);
        this.addLineX(world, random, i + 46, j + 4, k + 16, 4);
        this.addPlaneX(world, random, i + 49, j + 4, k + 13, 4, 4);
        this.setBlocks(Block.WOOL.id, Block.WOOL.id, 1);
        this.setMetadata(11, 11);
        this.addPlaneY(world, random, i + 47, j + 3, k + 14, 2, 2);
        for (x = 0; x < 2; ++x) {
            for (int z = 0; z < 2; ++z) {
                world.setRawTypeId(i + 44 + x * 5, j + 2, k + 11 + z * 7, AetherBlocks.AmbrosiumTorch.id);
            }
        }
        this.setBlocks(Block.STATIONARY_WATER.id, Block.STATIONARY_WATER.id, 1);
        this.setMetadata(0, 0);
        this.addPlaneY(world, random, i + 35, j + 1, k + 5, 6, 3);
        this.addPlaneY(world, random, i + 35, j + 1, k + 22, 6, 3);
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID1, 1);
        this.setMetadata(1, 1);
        this.addLineZ(world, random, i + 34, j + 1, k + 5, 2);
        this.addLineZ(world, random, i + 41, j + 1, k + 5, 2);
        this.addLineX(world, random, i + 36, j + 1, k + 8, 4);
        world.setRawTypeIdAndData(i + 35, j + 1, k + 7, this.lockedBlockID1, 1);
        world.setRawTypeIdAndData(i + 40, j + 1, k + 7, this.lockedBlockID1, 1);
        this.addLineZ(world, random, i + 34, j + 1, k + 23, 2);
        this.addLineZ(world, random, i + 41, j + 1, k + 23, 2);
        this.addLineX(world, random, i + 36, j + 1, k + 21, 4);
        world.setRawTypeIdAndData(i + 35, j + 1, k + 22, this.lockedBlockID1, 1);
        world.setRawTypeIdAndData(i + 40, j + 1, k + 22, this.lockedBlockID1, 1);
        for (x = i + 36; x < i + 40; x += 3) {
            for (int z = k + 8; z < k + 22; z += 13) {
                world.setRawTypeId(x, j + 2, z, AetherBlocks.AmbrosiumTorch.id);
            }
        }
        this.addChandelier(world, i + 28, j, k + 10, 8);
        this.addChandelier(world, i + 43, j, k + 10, 8);
        this.addChandelier(world, i + 43, j, k + 19, 8);
        this.addChandelier(world, i + 28, j, k + 19, 8);
        this.addSapling(world, random, i + 45, j + 1, k + 6);
        this.addSapling(world, random, i + 45, j + 1, k + 21);
        final EntityValkyrie valk = new EntityValkyrie(world, i + 40.0, j + 1.5, k + 15.0, true);
        valk.setPosition((double)(i + 40), (double)(j + 2), (double)(k + 15));
        valk.setDungeon(i + 26, j, k + 5);
        world.addEntity((Entity)valk);
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID1, 1);
        this.setMetadata(1, 1);
        this.addHollowBox(world, random, i + 41, j - 2, k + 13, 4, 4, 4);
        x = i + 42 + random.nextInt(2);
        int z = k + 14 + random.nextInt(2);
        world.setTypeId(x, j - 1, z, AetherBlocks.TreasureChest.id);
        final TileEntityChest chest2 = (TileEntityChest)world.getTileEntity(x, j - 1, z);
        for (int p2 = 0; p2 < 3 + random.nextInt(3); ++p2) {
            final ItemStack item2 = this.getSilverLoot(random);
            chest2.setItem(random.nextInt(chest2.getSize()), item2);
        }
        world.setRawData(x, j - 1, z, 2);
        return true;
    }
    
    private void addSapling(final World world, final Random random, final int i, final int j, final int k) {
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID1, 1);
        this.setMetadata(1, 1);
        this.addPlaneY(world, random, i, j, k, 3, 3);
        world.setRawTypeId(i + 1, j, k + 1, AetherBlocks.Dirt.id);
        world.setRawTypeId(i + 1, j + 1, k + 1, AetherBlocks.GoldenOakSapling.id);
        for (int x = i; x < i + 3; x += 2) {
            for (int z = k; z < k + 3; z += 2) {
                world.setRawTypeId(x, j + 1, z, AetherBlocks.AmbrosiumTorch.id);
            }
        }
    }
    
    private void addChandelier(final World world, final int i, final int j, final int k, final int h) {
        for (int y = j + h + 3; y < j + h + 6; ++y) {
            world.setRawTypeId(i, y, k, Block.FENCE.id);
        }
        for (int x = i - 1; x < i + 2; ++x) {
            world.setRawTypeId(x, j + h + 1, k, Block.GLOWSTONE.id);
        }
        for (int y = j + h; y < j + h + 3; ++y) {
            world.setRawTypeId(i, y, k, Block.GLOWSTONE.id);
        }
        for (int z = k - 1; z < k + 2; ++z) {
            world.setRawTypeId(i, j + h + 1, z, Block.GLOWSTONE.id);
        }
    }
    
    private void addColumn(final World world, final Random random, final int i, final int j, final int k, final int h) {
        this.setBlocks(this.wallBlockID1, this.wallBlockID2, 20);
        this.setMetadata(1, 1);
        this.addPlaneY(world, random, i, j, k, 3, 3);
        this.addPlaneY(world, random, i, j + h, k, 3, 3);
        this.setBlocks(this.columnID, this.columnID, 1);
        this.setMetadata(0, 0);
        this.addLineY(world, random, i + 1, j, k + 1, h - 1);
        world.setRawTypeIdAndData(i + 1, j + h - 1, k + 1, this.columnID, 1);
    }
    
    private void addStaircase(final World world, final Random random, final int i, final int j, final int k, final int h) {
        this.setBlocks(0, 0, 1);
        this.addSolidBox(world, random, i + 1, j, k + 1, 4, h, 4);
        this.setBlocks(this.lockedBlockID1, this.lockedBlockID2, 5);
        this.setMetadata(1, 1);
        this.addSolidBox(world, random, i + 2, j, k + 2, 2, h + 4, 2);
        world.setRawTypeId(i + 1, j + 0, k + 1, Block.STEP.id);
        world.setRawTypeId(i + 2, j + 0, k + 1, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 3, j + 1, k + 1, Block.STEP.id);
        world.setRawTypeId(i + 4, j + 1, k + 1, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 4, j + 2, k + 2, Block.STEP.id);
        world.setRawTypeId(i + 4, j + 2, k + 3, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 4, j + 3, k + 4, Block.STEP.id);
        world.setRawTypeId(i + 3, j + 3, k + 4, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 2, j + 4, k + 4, Block.STEP.id);
        world.setRawTypeId(i + 1, j + 4, k + 4, Block.DOUBLE_STEP.id);
        if (h == 5) {
            return;
        }
        world.setRawTypeId(i + 1, j + 5, k + 3, Block.STEP.id);
        world.setRawTypeId(i + 1, j + 5, k + 2, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 1, j + 6, k + 1, Block.STEP.id);
        world.setRawTypeId(i + 2, j + 6, k + 1, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 3, j + 7, k + 1, Block.STEP.id);
        world.setRawTypeId(i + 4, j + 7, k + 1, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 4, j + 8, k + 2, Block.STEP.id);
        world.setRawTypeId(i + 4, j + 8, k + 3, Block.DOUBLE_STEP.id);
        world.setRawTypeId(i + 4, j + 9, k + 4, Block.STEP.id);
        world.setRawTypeId(i + 3, j + 9, k + 4, Block.DOUBLE_STEP.id);
    }
    
    private ItemStack getNormalLoot(final Random random) {
        final int item = random.nextInt(15);
        switch (item) {
            case 0: {
                return new ItemStack(AetherItems.PickZanite);
            }
            case 1: {
                return new ItemStack(AetherItems.Bucket, 1, 2);
            }
            case 2: {
                return new ItemStack(AetherItems.DartShooter);
            }
            case 3: {
                return new ItemStack(AetherItems.MoaEgg, 1, 0);
            }
            case 4: {
                return new ItemStack(AetherItems.AmbrosiumShard, random.nextInt(10) + 1);
            }
            case 5: {
                return new ItemStack(AetherItems.Dart, random.nextInt(5) + 1, 0);
            }
            case 6: {
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 1);
            }
            case 7: {
                return new ItemStack(AetherItems.Dart, random.nextInt(3) + 1, 2);
            }
            case 8: {
                if (random.nextInt(20) == 0) {
                    return new ItemStack(AetherItems.BlueMusicDisk);
                }
                break;
            }
            case 9: {
                return new ItemStack(AetherItems.Bucket);
            }
            case 10: {
                if (random.nextInt(10) == 0) {
                    return new ItemStack(Item.byId[Item.RECORD_1.id + random.nextInt(2)]);
                }
                break;
            }
            case 11: {
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteBoots);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteHelmet);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteLeggings);
                }
                if (random.nextInt(2) == 0) {
                    return new ItemStack(AetherItems.ZaniteChestplate);
                }
                break;
            }
            case 12: {
                if (random.nextInt(4) == 0) {
                    return new ItemStack(AetherItems.IronPendant);
                }
            }
            case 13: {
                if (random.nextInt(10) == 0) {
                    return new ItemStack(AetherItems.GoldPendant);
                }
            }
            case 14: {
                if (random.nextInt(15) == 0) {
                    return new ItemStack(AetherItems.ZaniteRing);
                }
                break;
            }
        }
        return new ItemStack(AetherBlocks.AmbrosiumTorch, random.nextInt(5));
    }
    
    private ItemStack getSilverLoot(final Random random) {
        final int item = random.nextInt(9);
        switch (item) {
            case 0: {
                return new ItemStack(AetherItems.GummieSwet, random.nextInt(16));
            }
            case 1: {
                return new ItemStack(AetherItems.SwordLightning);
            }
            case 2: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.AxeValkyrie);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.ShovelValkyrie);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PickValkyrie);
                }
                break;
            }
            case 3: {
                return new ItemStack(AetherItems.SwordHoly);
            }
            case 4: {
                return new ItemStack(AetherItems.GoldenFeather);
            }
            case 5: {
                return new ItemStack(AetherItems.RegenerationStone);
            }
            case 6: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneHelmet);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneLeggings);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneChestplate);
                }
                break;
            }
            case 7: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.NeptuneBoots);
                }
                return new ItemStack(AetherItems.NeptuneGlove);
            }
            case 8: {
                return new ItemStack(AetherItems.InvisibilityCloak);
            }
        }
        return new ItemStack(AetherItems.ZanitePendant);
    }
}
