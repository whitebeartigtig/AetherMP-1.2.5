package net.minecraft.server;

import forge.*;
import java.util.*;

public class AetherACPage extends AchievementPage
{
    public AetherACPage(final Achievement... pages) {
        super("Aether", pages);
    }
    
    public int bgGetSprite(final Random random, final int i, final int j) {
        int k = Block.SAND.textureId;
        final int l = random.nextInt(1 + j) + j / 2;
        if (l > 37 || j == 35) {
            k = AetherBlocks.Aercloud.textureId;
        }
        else if (l == 22) {
            k = ((random.nextInt(2) != 0) ? BlockHolystone.sprMossy : AetherBlocks.GravititeOre.textureId);
        }
        else if (l == 10) {
            k = AetherBlocks.ZaniteOre.textureId;
        }
        else if (l == 8) {
            k = AetherBlocks.AmbrosiumOre.textureId;
        }
        else if (l > 4) {
            k = AetherBlocks.Holystone.textureId;
        }
        else if (l > 0) {
            k = AetherBlocks.Dirt.textureId;
        }
        return k;
    }
}
