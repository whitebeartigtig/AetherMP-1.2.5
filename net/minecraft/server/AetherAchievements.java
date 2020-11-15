package net.minecraft.server;

import forge.*;

public class AetherAchievements
{
    public static final int acOff = 800;
    public static Achievement enterAether;
    public static Achievement defeatBronze;
    public static Achievement defeatSilver;
    public static Achievement defeatGold;
    public static Achievement enchanter;
    public static Achievement incubator;
    public static Achievement gravTools;
    public static Achievement blueCloud;
    public static Achievement flyingPig;
    public static Achievement lore;
    public static Achievement loreception;
    
    public AetherAchievements() {
        AetherAchievements.enterAether = new Achievement(800, "enterAether", 0, 0, Block.GLOWSTONE, (Achievement)null).c();
        AetherAchievements.defeatBronze = new Achievement(801, "defeatBronze", -2, 3, new ItemStack(AetherItems.Key, 1, 0), AetherAchievements.enterAether).c();
        AetherAchievements.defeatSilver = new Achievement(802, "defeatSilver", 0, 4, new ItemStack(AetherItems.Key, 1, 1), AetherAchievements.enterAether).c();
        AetherAchievements.defeatGold = new Achievement(803, "defeatGold", 2, 3, new ItemStack(AetherItems.Key, 1, 2), AetherAchievements.enterAether).c();
        AetherAchievements.enchanter = new Achievement(804, "enchanter", 2, 1, AetherBlocks.Enchanter, AetherAchievements.enterAether).c();
        AetherAchievements.incubator = new Achievement(805, "incubator", 2, -1, AetherBlocks.Incubator, AetherAchievements.enterAether).c();
        AetherAchievements.blueCloud = new Achievement(806, "blueCloud", -2, -1, new ItemStack(AetherBlocks.Aercloud, 1, 1), AetherAchievements.enterAether).c();
        AetherAchievements.flyingPig = new Achievement(807, "flyingPig", -2, 1, Item.SADDLE, AetherAchievements.enterAether).c();
        AetherAchievements.gravTools = new Achievement(808, "gravTools", -1, -3, AetherItems.PickGravitite, AetherAchievements.enterAether).c();
        AetherAchievements.lore = new Achievement(809, "lore", 1, -3, Item.BOOK, AetherAchievements.enterAether).c();
        AetherAchievements.loreception = new Achievement(810, "loreception", 1, -5, Item.BOOK, AetherAchievements.lore).c();
        ModLoader.addAchievementDesc(AetherAchievements.enterAether, "Hostile Paradise", "Ascend to the Aether");
        ModLoader.addAchievementDesc(AetherAchievements.defeatBronze, "Like a Bossaru!", "Defeat the bronze boss");
        ModLoader.addAchievementDesc(AetherAchievements.defeatSilver, "Dethroned", "Defeat the silver boss");
        ModLoader.addAchievementDesc(AetherAchievements.defeatGold, "Extinguished", "Defeat the gold boss");
        ModLoader.addAchievementDesc(AetherAchievements.enchanter, "Do you believe in magic?", "Craft an enchanter");
        ModLoader.addAchievementDesc(AetherAchievements.incubator, "Now you're family", "Incubate a moa");
        ModLoader.addAchievementDesc(AetherAchievements.blueCloud, "To infinity and beyond!", "Bounce on a blue cloud");
        ModLoader.addAchievementDesc(AetherAchievements.flyingPig, "When phygs fly!", "Fly on a phyg");
        ModLoader.addAchievementDesc(AetherAchievements.gravTools, "Pink is the new blue", "Craft a gravitite tool");
        ModLoader.addAchievementDesc(AetherAchievements.lore, "The more you know!", "Read a book of lore");
        ModLoader.addAchievementDesc(AetherAchievements.loreception, "Lore-ception", "It's a book in a book in a book in...");
        final AchievementPage page = new AetherACPage(new Achievement[] { AetherAchievements.enterAether, AetherAchievements.defeatBronze, AetherAchievements.defeatSilver, AetherAchievements.defeatGold, AetherAchievements.enchanter, AetherAchievements.incubator, AetherAchievements.gravTools, AetherAchievements.blueCloud, AetherAchievements.flyingPig, AetherAchievements.lore, AetherAchievements.loreception });
    }
}
