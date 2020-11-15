package net.minecraft.server;

import java.util.*;

public class AetherGenDungeon extends WorldGenerator
{
    public int xoff;
    public int yoff;
    public int zoff;
    public int rad;
    public int truey;
    
    private int floors() {
        return Block.DOUBLE_STEP.id;
    }
    
    private int walls() {
        return AetherBlocks.LockedDungeonStone.id;
    }
    
    private int ceilings() {
        return AetherBlocks.LockedLightDungeonStone.id;
    }
    
    private int torches() {
        return 0;
    }
    
    private int doors() {
        return 0;
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        return this.generate(world, random, x, y, z, 24);
    }
    
    public boolean generate(final World world, final Random random, final int x, final int y, final int z, int r) {
        r = (int)Math.floor(r * 0.8);
        final int wid = (int)Math.sqrt(r * r / 2);
        for (int j = 4; j > -5; --j) {
            int a = wid;
            if (j >= 3 || j <= -3) {
                --a;
            }
            if (j == 4 || j == -4) {
                --a;
            }
            for (int i = -a; i <= a; ++i) {
                for (int k = -a; k <= a; ++k) {
                    if (j == 4) {
                        this.setBlock(world, random, x + i, y + j, z + k, this.walls(), 2, this.ceilings(), 2, 10);
                    }
                    else if (j > -4) {
                        if (i == a || -i == a || k == a || -k == a) {
                            this.setBlock(world, random, x + i, y + j, z + k, this.walls(), 2, this.ceilings(), 2, 10);
                        }
                        else {
                            world.setRawTypeId(x + i, y + j, z + k, 0);
                            if (j == -2 && (i == a - 1 || -i == a - 1 || k == a - 1 || -k == a - 1) && (i % 3 == 0 || k % 3 == 0)) {
                                world.setRawTypeId(x + i, y + j + 2, z + k, this.torches());
                            }
                        }
                    }
                    else {
                        this.setBlock(world, random, x + i, y + j, z + k, this.walls(), 2, this.ceilings(), 2, 10);
                        if ((i == a - 2 || -i == a - 2) && (k == a - 2 || -k == a - 2)) {
                            world.setRawTypeId(x + i, y + j + 1, z + k, Block.NETHERRACK.id);
                            world.setRawTypeId(x + i, y + j + 2, z + k, ((Block)Block.FIRE).id);
                        }
                    }
                }
            }
        }
        final int direction = random.nextInt(4);
        for (int l = wid; l < wid + 32; ++l) {
            boolean flag = false;
            for (int m = -3; m < 2; ++m) {
                for (int k2 = -3; k2 < 4; ++k2) {
                    int a2;
                    int b;
                    if (direction / 2 == 0) {
                        a2 = l;
                        b = k2;
                    }
                    else {
                        a2 = k2;
                        b = l;
                    }
                    if (direction % 2 == 0) {
                        a2 = -a2;
                        b = -b;
                    }
                    if (!AetherBlocks.isGood(world.getTypeId(x + a2, y + m, z + b), world.getData(x + a2, y + m, z + b))) {
                        flag = true;
                        if (m == -3) {
                            this.setBlock(world, random, x + a2, y + m, z + b, AetherBlocks.Holystone.id, 0, AetherBlocks.Holystone.id, 2, 5);
                        }
                        else if (m < 1) {
                            if (l == wid) {
                                if (k2 < 2 && k2 > -2 && m < 0) {
                                    world.setRawTypeId(x + a2, y + m, z + b, this.doors());
                                }
                                else {
                                    this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                                }
                            }
                            else if (k2 == 3 || k2 == -3) {
                                this.setBlock(world, random, x + a2, y + m, z + b, AetherBlocks.Holystone.id, 0, AetherBlocks.Holystone.id, 2, 5);
                            }
                            else {
                                world.setRawTypeId(x + a2, y + m, z + b, 0);
                                if (m == -1 && (k2 == 2 || k2 == -2) && (l - wid - 2) % 3 == 0) {
                                    world.setRawTypeId(x + a2, y + m, z + b, this.torches());
                                }
                            }
                        }
                        else if (l == wid) {
                            this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 5);
                        }
                        else {
                            this.setBlock(world, random, x + a2, y + m, z + b, AetherBlocks.Holystone.id, 0, AetherBlocks.Holystone.id, 2, 5);
                        }
                    }
                    a2 = -a2;
                    b = -b;
                    if (l < wid + 6) {
                        if (m == -3) {
                            this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                        }
                        else if (m < 1) {
                            if (l == wid) {
                                if (k2 < 2 && k2 > -2 && m < 0) {
                                    this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                                }
                                else {
                                    this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                                }
                            }
                            else if (l == wid + 5) {
                                this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                            }
                            else if (l == wid + 4 && k2 == 0 && m == -2) {
                                world.setTypeId(x + a2, y + m, z + b, AetherBlocks.TreasureChest.id);
                                final TileEntityChest chest = (TileEntityChest)world.getTileEntity(x + a2, y + m, z + b);
                                for (int p = 0; p < 3 + random.nextInt(3); ++p) {
                                    final ItemStack item = this.getGoldLoot(random);
                                    chest.setItem(random.nextInt(chest.getSize()), item);
                                }
                            }
                            else if (k2 == 3 || k2 == -3) {
                                this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                            }
                            else {
                                world.setRawTypeId(x + a2, y + m, z + b, 0);
                                if (m == -1 && (k2 == 2 || k2 == -2) && (l - wid - 2) % 3 == 0) {
                                    world.setRawTypeId(x + a2, y + m, z + b, this.torches());
                                }
                            }
                        }
                        else {
                            this.setBlock(world, random, x + a2, y + m, z + b, this.walls(), 2, this.ceilings(), 2, 10);
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        final EntityFireMonster boss = new EntityFireMonster(world, x, y - 1, z, wid, direction);
        world.addEntity((Entity)boss);
        return true;
    }
    
    private void setBlock(final World world, final Random random, final int i, final int j, final int k, final int block1, final int meta1, final int block2, final int meta2, final int chance) {
        if (random.nextInt(chance) == 0) {
            world.setRawTypeIdAndData(i, j, k, block2, meta2);
        }
        else {
            world.setRawTypeIdAndData(i, j, k, block1, meta1);
        }
    }
    
    private ItemStack getGoldLoot(final Random random) {
        final int item = random.nextInt(8);
        switch (item) {
            case 0: {
                return new ItemStack(AetherItems.IronBubble);
            }
            case 1: {
                return new ItemStack(AetherItems.VampireBlade);
            }
            case 2: {
                return new ItemStack(AetherItems.PigSlayer);
            }
            case 3: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixHelm);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixLegs);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixBody);
                }
                break;
            }
            case 4: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.PhoenixBoots);
                }
                return new ItemStack(AetherItems.PhoenixGlove);
            }
            case 5: {
                return new ItemStack(AetherItems.LifeShard);
            }
            case 6: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeHelmet);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititePlatelegs);
                }
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeBodyplate);
                }
                break;
            }
            case 7: {
                if (random.nextBoolean()) {
                    return new ItemStack(AetherItems.GravititeBoots);
                }
                return new ItemStack(AetherItems.GravititeGlove);
            }
        }
        return new ItemStack(AetherItems.ObsidianBody);
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
