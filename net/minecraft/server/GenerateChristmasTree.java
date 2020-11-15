package net.minecraft.server;

import java.util.*;

public class GenerateChristmasTree extends WorldGenerator
{
    public boolean generate(final World world, final Random random, final int x, final int y, final int z) {
        int huhu = world.getTypeId(x, y - 1, z);
        if (huhu == AetherBlocks.Grass.id || huhu == AetherBlocks.Dirt.id) {
            if (y + 9 <= world.getHeight()) {
                for (int y2 = y; y2 <= y + 8; ++y2) {
                    world.setRawTypeId(x, y2, z, AetherBlocks.Log.id);
                }
                world.setTypeIdAndData(x, y + 9, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z + 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 2, z - 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 4, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 4, y + 2, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z + 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z + 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z - 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z - 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 4, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 4, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 4, y + 2, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 4, y + 2, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 2, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 2, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 2, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 2, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z + 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 3, z - 4, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 4, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 4, y + 3, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 3, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 3, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 3, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 3, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 3, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 3, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 4, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 4, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 4, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 4, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 4, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 4, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 4, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 4, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z + 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 5, z - 3, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 3, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 3, y + 5, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 5, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 5, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 5, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 5, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 5, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 5, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 6, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 6, z + 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 6, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 6, z - 2, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 6, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 2, y + 6, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 6, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 2, y + 6, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 6, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 6, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 6, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 6, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 6, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 6, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 6, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 6, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 7, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 7, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 7, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 7, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 7, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 7, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 7, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 7, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 7, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 7, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 7, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 7, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 8, z + 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x, y + 8, z - 1, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x + 1, y + 8, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                world.setTypeIdAndData(x - 1, y + 8, z, AetherBlocks.ChristmasLeaves.id, random.nextInt(2));
                huhu = world.getTypeId(x, y - 1, z);
                if (huhu == AetherBlocks.Grass.id || huhu == AetherBlocks.Dirt.id) {
                    world.setRawTypeId(x, y - 1, z, AetherBlocks.Dirt.id);
                }
                for (int xss = -20; xss < 20; ++xss) {
                    for (int yss = -20; yss < 20; ++yss) {
                        int hi = random.nextInt((int)(MathHelper.abs((float)yss) + MathHelper.abs((float)xss) + 1.0f));
                        if (MathHelper.abs((float)yss) + MathHelper.abs((float)xss) > 15.0f) {
                            hi += 5;
                        }
                        if (hi < 10) {
                            final int huhu2 = world.getTypeId(xss + x, world.getHighestBlockYAt(xss + x, yss + z) - 1, yss + z);
                            if (huhu2 != 0) {
                                if (random.nextInt(80) == 0 && (huhu2 == AetherBlocks.Grass.id || huhu2 == AetherBlocks.Dirt.id)) {
                                    world.setRawTypeId(xss + x, world.getHighestBlockYAt(xss + x, yss + z), yss + z, AetherBlocks.blockPresent.id);
                                }
                                else {
                                    world.setRawTypeId(xss + x, world.getHighestBlockYAt(xss + x, yss + z), yss + z, Block.SNOW.id);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

	@Override
	public boolean a(World arg0, Random arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return false;
	}
}
