package net.minecraft.server;

import net.minecraft.server.*;
import java.util.*;

public class AetherItems
{
    public static final String dir = "/aether/items/";
    public static double motionOffset;
    public static double ybuff;
    public static Item VictoryMedal;
    public static Item Key;
    public static Item LoreBook;
    public static Item MoaEgg;
    public static Item AechorPetal;
    public static Item GoldenAmber;
    public static Item Stick;
    public static Item Dart;
    public static Item DartShooter;
    public static Item AmbrosiumShard;
    public static Item Zanite;
    public static Item BlueMusicDisk;
    public static Item Bucket;
    public static Item PickSkyroot;
    public static Item PickHolystone;
    public static Item PickZanite;
    public static Item PickGravitite;
    public static Item ShovelSkyroot;
    public static Item ShovelHolystone;
    public static Item ShovelZanite;
    public static Item ShovelGravitite;
    public static Item AxeSkyroot;
    public static Item AxeHolystone;
    public static Item AxeZanite;
    public static Item AxeGravitite;
    public static Item SwordSkyroot;
    public static Item SwordHolystone;
    public static Item SwordZanite;
    public static Item SwordGravitite;
    public static Item IronBubble;
    public static Item PigSlayer;
    public static Item VampireBlade;
    public static Item NatureStaff;
    public static Item SwordFire;
    public static Item SwordLightning;
    public static Item SwordHoly;
    public static Item LightningKnife;
    public static Item GummieSwet;
    public static Item HammerNotch;
    public static Item PhoenixBow;
    public static Item PhoenixHelm;
    public static Item PhoenixBody;
    public static Item PhoenixLegs;
    public static Item PhoenixBoots;
    public static Item ObsidianHelm;
    public static Item ObsidianBody;
    public static Item ObsidianLegs;
    public static Item ObsidianBoots;
    public static Item CloudStaff;
    public static Item CloudParachute;
    public static Item CloudParachuteGold;
    public static Item GravititeHelmet;
    public static Item GravititeBodyplate;
    public static Item GravititePlatelegs;
    public static Item GravititeBoots;
    public static Item ZaniteHelmet;
    public static Item ZaniteChestplate;
    public static Item ZaniteLeggings;
    public static Item ZaniteBoots;
    public static Item LifeShard;
    public static Item GoldenFeather;
    public static Item Lance;
    public static Item RepShield;
    public static Item AetherCape;
    public static Item IronRing;
    public static Item GoldRing;
    public static Item ZaniteRing;
    public static Item IronPendant;
    public static Item GoldPendant;
    public static Item ZanitePendant;
    public static Item LeatherGlove;
    public static Item IronGlove;
    public static Item GoldGlove;
    public static Item DiamondGlove;
    public static Item ZaniteGlove;
    public static Item GravititeGlove;
    public static Item PhoenixGlove;
    public static Item ObsidianGlove;
    public static Item NeptuneGlove;
    public static Item NeptuneHelmet;
    public static Item NeptuneChestplate;
    public static Item NeptuneLeggings;
    public static Item NeptuneBoots;
    public static Item RegenerationStone;
    public static Item InvisibilityCloak;
    public static Item AxeValkyrie;
    public static Item PickValkyrie;
    public static Item ShovelValkyrie;
    public static Item HealingStone;
    public static Item AgilityCape;
    public static Item WhiteCape;
    public static Item RedCape;
    public static Item YellowCape;
    public static Item BlueCape;
    public static Item IceRing;
    public static Item IcePendant;
    public static Item CandySword;
    public static Item CandyCane;
    public static Item GingerBreadMan;
    public static Item BlueBerry;
    public static Item WhiteBerry;
    public static Item SwetBall;
    public static Item SentryBoots;
    private static int ticks;
    private static boolean jumpBoosted;
    public static int ElementalSwordIcon;
    public static int gravArmour;
    public static int zaniteArmour;
    public static int neptuneArmour;
    private static boolean debug;
    
    public AetherItems() {
        AetherItems.VictoryMedal = new AetherItem(mod_Aether.idItemVictoryMedal).d(70).e(10).a("VictoryMedal");
        AetherItems.Key = new ItemAetherKey(mod_Aether.idItemKey).a("AetherKey");
        AetherItems.LoreBook = new ItemLoreBook(mod_Aether.idItemLoreBook).d(59).a("LoreBook");
        AetherItems.MoaEgg = new ItemMoaEgg(mod_Aether.idItemMoaEgg).d(1).a("MoaEgg");
        AetherItems.AechorPetal = new AetherItem(mod_Aether.idItemAechorPetal).d(0).a("AechorPetal");
        AetherItems.GoldenAmber = new AetherItem(mod_Aether.idItemGoldenAmber).d(28).a("GoldenAmber");
        AetherItems.Stick = new AetherItem(mod_Aether.idItemStick).d(61).a("SkyrootStick");
        AetherItems.Dart = new ItemDart(mod_Aether.idItemDart).a(true).a("Dart");
        AetherItems.DartShooter = new ItemDartShooter(mod_Aether.idItemDartShooter).a("DartShooter");
        AetherItems.AmbrosiumShard = new AetherItem(mod_Aether.idItemAmbrosiumShard).d(4).a("AmbrosiumShard");
        AetherItems.HealingStone = new ItemHealingStone(mod_Aether.idItemHealingStone, 0, 1.2f, false).r().a(MobEffectList.REGENERATION.id, 30, 0, 1.0f).d(33).a("Healing_Stone");
        AetherItems.Zanite = new AetherItem(mod_Aether.idItemZanite).d(71).a("Zanite");
        AetherItems.BlueMusicDisk = new ItemAetherRecord(mod_Aether.idItemBlueMusicDisk, "AetherTune").d(9).a("BlueMusicDisk");
        AetherItems.Bucket = new ItemSkyrootBucket(mod_Aether.idItemBucket).a("SkyrootBucket");
        EnumToolMaterial mat = EnumToolMaterial.WOOD;
        AetherItems.PickSkyroot = new ItemSkyrootPickaxe(mod_Aether.idItemPickSkyroot, mat).d(50).a("PickSkyroot");
        AetherItems.ShovelSkyroot = new ItemSkyrootSpade(mod_Aether.idItemShovelSkyroot, mat).d(59).a("ShovelSkyroot");
        AetherItems.AxeSkyroot = new ItemSkyrootAxe(mod_Aether.idItemAxeSkyroot, mat).d(7).a("AxeSkyroot");
        AetherItems.SwordSkyroot = new ItemSkyrootSword(mod_Aether.idItemSwordSkyroot, mat).d(64).a("SwordSkyroot");
        mat = EnumToolMaterial.STONE;
        AetherItems.PickHolystone = new ItemHolystonePickaxe(mod_Aether.idItemPickHolystone, mat).d(49).a("PickHolystone");
        AetherItems.ShovelHolystone = new ItemHolystoneSpade(mod_Aether.idItemShovelHolystone, mat).d(58).a("ShovelHolystone");
        AetherItems.AxeHolystone = new ItemHolystoneSpade(mod_Aether.idItemAxeHolystone, mat).d(6).a("AxeHolystone");
        AetherItems.SwordHolystone = new ItemSwordHolystone(mod_Aether.idItemSwordHolystone, mat).d(63).a("SwordHolystone");
        mat = EnumToolMaterial.IRON;
        AetherItems.PickZanite = new ItemZanitePickaxe(mod_Aether.idItemPickZanite, mat).d(51).a("PickZanite");
        AetherItems.ShovelZanite = new ItemZaniteSpade(mod_Aether.idItemShovelZanite, mat).d(60).a("ShovelZanite");
        AetherItems.AxeZanite = new ItemZaniteAxe(mod_Aether.idItemAxeZanite, mat).d(8).a("AxeZanite");
        AetherItems.SwordZanite = new ItemSwordZanite(mod_Aether.idItemSwordZanite, mat).d(65).a("SwordZanite");
        mat = EnumToolMaterial.DIAMOND;
        AetherItems.PickGravitite = new ItemGravititePickaxe(mod_Aether.idItemPickGravitite, mat).d(48).a("PickGravitite");
        AetherItems.ShovelGravitite = new ItemGravititeSpade(mod_Aether.idItemShovelGravitite, mat).d(57).a("ShovelGravitite");
        AetherItems.AxeGravitite = new ItemGravititeAxe(mod_Aether.idItemAxeGravitite, mat).d(5).a("AxeGravitite");
        AetherItems.SwordGravitite = new ItemSwordGravitite(mod_Aether.idItemSwordGravitite, mat).d(62).a("SwordGravitite");
        AetherItems.PickValkyrie = new ItemValkyriePickaxe(mod_Aether.idItemPickValkyrie, mat).d(67).a("PickValkyrie");
        AetherItems.ShovelValkyrie = new ItemValkyrieSpade(mod_Aether.idItemShovelValkyrie, mat).d(68).a("ShovelValkyrie");
        AetherItems.AxeValkyrie = new ItemValkyrieAxe(mod_Aether.idItemAxeValkyrie, mat).d(66).a("AxeValkyrie");
        AetherItems.IronBubble = new ItemMoreArmor(mod_Aether.idItemIronBubble, 0, 0, 7).d(35).a("IronBubble");
        AetherItems.PigSlayer = new ItemPigSlayer(mod_Aether.idItemPigSlayer).d(52).a("PigSlayer");
        AetherItems.VampireBlade = new ItemVampireBlade(mod_Aether.idItemVampireBlade).d(69).a("VampireBlade");
        AetherItems.NatureStaff = new AetherItem(mod_Aether.idItemNatureStaff).d(41).e(1).a("NatureStaff");
        AetherItems.SwordFire = new ItemSwordElemental(mod_Aether.idItemSwordFire, EnumElement.Fire, -20609).a("SwordFire");
        AetherItems.SwordHoly = new ItemSwordElemental(mod_Aether.idItemSwordHoly, EnumElement.Holy, -81).a("SwordHoly");
        AetherItems.SwordLightning = new ItemSwordElemental(mod_Aether.idItemSwordLightning, EnumElement.Lightning, -5242881).a("SwordLightning");
        AetherItems.LightningKnife = new ItemLightningKnife(mod_Aether.idItemLightningKnife).d(39).a("LightningKnife");
        AetherItems.GummieSwet = new ItemGummieSwet(mod_Aether.idItemGummieSwet).d(30).a("GummieSwet");
        AetherItems.HammerNotch = new ItemNotchHammer(mod_Aether.idItemHammerNotch).d(32).a("HammerNotch");
        AetherItems.CloudStaff = new ItemCloudStaff(mod_Aether.idItemCloudStaff).d(17).a("CloudStaff");
        AetherItems.PhoenixBow = new ItemPhoenixBow(mod_Aether.idItemPhoenixBow).d(44).a("PhoenixBow");
        AetherItems.PhoenixHelm = new ItemColouredArmor(mod_Aether.idItemPhoenixHelm, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Phoenix"), 0, 16742144).d(1).a("PhoenixHelm");
        AetherItems.PhoenixBody = new ItemColouredArmor(mod_Aether.idItemPhoenixBody, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Phoenix"), 1, 16742144).d(17).a("PhoenixBody");
        AetherItems.PhoenixLegs = new ItemColouredArmor(mod_Aether.idItemPhoenixLegs, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Phoenix"), 2, 16742144).d(33).a("PhoenixLegs");
        AetherItems.PhoenixBoots = new ItemColouredArmor(mod_Aether.idItemPhoenixBoots, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Phoenix"), 3, 16742144).d(49).a("PhoenixBoots");
        AetherItems.ObsidianHelm = new ItemColouredArmor(mod_Aether.idItemObsidianHelm, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Obsidian"), 0, 1774663).d(2).a("ObsidianHelm");
        AetherItems.ObsidianBody = new ItemColouredArmor(mod_Aether.idItemObsidianBody, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Obsidian"), 1, 1774663).d(18).a("ObsidianBody");
        AetherItems.ObsidianLegs = new ItemColouredArmor(mod_Aether.idItemObsidianLegs, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Obsidian"), 2, 1774663).d(34).a("ObsidianLegs");
        AetherItems.ObsidianBoots = new ItemColouredArmor(mod_Aether.idItemObsidianBoots, EnumArmorMaterial.DIAMOND, ModLoader.addArmor("Obsidian"), 3, 1774663).d(50).a("ObsidianBoots");
        AetherItems.GravititeHelmet = new ItemColouredArmor(mod_Aether.idItemGravititeHelmet, EnumArmorMaterial.DIAMOND, AetherItems.gravArmour, 0, 15160027).d(2).a("GravHelm");
        AetherItems.GravititeBodyplate = new ItemColouredArmor(mod_Aether.idItemGravititeBodyplate, EnumArmorMaterial.DIAMOND, AetherItems.gravArmour, 1, 15160027).d(18).a("GravBody");
        AetherItems.GravititePlatelegs = new ItemColouredArmor(mod_Aether.idItemGravititePlatelegs, EnumArmorMaterial.DIAMOND, AetherItems.gravArmour, 2, 15160027).d(34).a("GravLegs");
        AetherItems.GravititeBoots = new ItemColouredArmor(mod_Aether.idItemGravititeBoots, EnumArmorMaterial.DIAMOND, AetherItems.gravArmour, 3, 15160027).d(50).a("GravBoots");
        AetherItems.ZaniteHelmet = new ItemColouredArmor(mod_Aether.idItemZaniteHelmet, EnumArmorMaterial.IRON, AetherItems.zaniteArmour, 0, 7412456).d(2).a("ZaniteHelm");
        AetherItems.ZaniteChestplate = new ItemColouredArmor(mod_Aether.idItemZaniteChestplate, EnumArmorMaterial.IRON, AetherItems.zaniteArmour, 1, 7412456).d(18).a("ZaniteBody");
        AetherItems.ZaniteLeggings = new ItemColouredArmor(mod_Aether.idItemZaniteLeggings, EnumArmorMaterial.IRON, AetherItems.zaniteArmour, 2, 7412456).d(34).a("ZaniteLegs");
        AetherItems.ZaniteBoots = new ItemColouredArmor(mod_Aether.idItemZaniteBoots, EnumArmorMaterial.IRON, AetherItems.zaniteArmour, 3, 7412456).d(50).a("ZaniteBoots");
        AetherItems.NeptuneHelmet = new ItemColouredArmor(mod_Aether.idItemNeptuneHelmet, EnumArmorMaterial.DIAMOND, AetherItems.neptuneArmour, 0, 2512127).d(1).a("NeptuneHelm");
        AetherItems.NeptuneChestplate = new ItemColouredArmor(mod_Aether.idItemNeptuneChestplate, EnumArmorMaterial.DIAMOND, AetherItems.neptuneArmour, 1, 2512127).d(17).a("NeptuneBody");
        AetherItems.NeptuneLeggings = new ItemColouredArmor(mod_Aether.idItemNeptuneLeggings, EnumArmorMaterial.DIAMOND, AetherItems.neptuneArmour, 2, 2512127).d(33).a("NeptuneLegs");
        AetherItems.NeptuneBoots = new ItemColouredArmor(mod_Aether.idItemNeptuneBoots, EnumArmorMaterial.DIAMOND, AetherItems.neptuneArmour, 3, 2512127).d(49).a("NeptuneBoots");
        AetherItems.LifeShard = new ItemLifeShard(mod_Aether.idItemLifeShard).d(38).a("LifeShard");
        AetherItems.GoldenFeather = new ItemMoreArmor(mod_Aether.idItemGoldenFeather, 0, 0, 7).d(29).a("GoldenFeather");
        AetherItems.Lance = new ItemLance(mod_Aether.idItemLance, mat).d(37).a("Lance");
        AetherItems.RepShield = new ItemMoreArmor(mod_Aether.idItemRepShield, 0, 0, 6, 16777215).d(54).a("RepShield").setMaxDurability(512);
        final int Ring = 55;
        AetherItems.IronRing = new ItemMoreArmor(mod_Aether.idItemIronRing, 0, "/armor/Accessories.png", 8, 16777215).d(Ring).a("IronRing");
        AetherItems.GoldRing = new ItemMoreArmor(mod_Aether.idItemGoldRing, 0, "/armor/Accessories.png", 8, 16776994).d(Ring).a("GoldRing");
        AetherItems.ZaniteRing = new ItemMoreArmor(mod_Aether.idItemZaniteRing, 0, "/armor/Accessories.png", 8, 7412456).d(Ring).a("ZaniteRing");
        AetherItems.IceRing = new ItemMoreArmor(mod_Aether.idItemIceRing, 0, "/armor/Accessories.png", 8, 9823975).d(Ring).a("IceRing");
        final int Pendant = 42;
        AetherItems.IronPendant = new ItemMoreArmor(mod_Aether.idItemIronPendant, 0, "/armor/Accessories.png", 4, 16777215).d(Pendant).a("IronPendant");
        AetherItems.GoldPendant = new ItemMoreArmor(mod_Aether.idItemGoldPendant, 0, "/armor/Accessories.png", 4, 16776994).d(Pendant).a("GoldPendant");
        AetherItems.ZanitePendant = new ItemMoreArmor(mod_Aether.idItemZanitePendant, 0, "/armor/Accessories.png", 4, 7412456).d(Pendant).a("ZanitePendant");
        AetherItems.IcePendant = new ItemMoreArmor(mod_Aether.idItemIcePendant, 0, "/armor/Accessories.png", 4, 9823975).d(Pendant).a("IcePendant");
        AetherItems.AetherCape = new ItemMoreArmor(mod_Aether.idItemAetherCape, 0, "/aether/other/AetherCape.png", 5).d(2).a("AetherCape");
        AetherItems.RegenerationStone = new ItemMoreArmor(mod_Aether.idItemRegenerationStone, 0, 0, 7).d(53).a("RegenerationStone");
        AetherItems.InvisibilityCloak = new ItemMoreArmor(mod_Aether.idItemInvisibilityCloak, 0, 0, 5).d(34).a("InvisibilityCloak");
        AetherItems.AgilityCape = new ItemMoreArmor(mod_Aether.idItemAgilityCape, 0, "/aether/other/AgilityCape.png", 5).d(3).a("AgilityCape");
        final int CapeTexture = 15;
        AetherItems.WhiteCape = new ItemMoreArmor(mod_Aether.idItemWhiteCape, 0, "/aether/other/WhiteCape.png", 5).d(CapeTexture).a("WhiteCape");
        AetherItems.RedCape = new ItemMoreArmor(mod_Aether.idItemRedCape, 0, "/aether/other/RedCape.png", 5, 15208721).d(CapeTexture).a("RedCape");
        AetherItems.YellowCape = new ItemMoreArmor(mod_Aether.idItemYellowCape, 0, "/aether/other/YellowCape.png", 5, 13486862).d(CapeTexture).a("YellowCape");
        AetherItems.BlueCape = new ItemMoreArmor(mod_Aether.idItemBlueCape, 0, "/aether/other/BlueCape.png", 5, 1277879).d(CapeTexture).a("BlueCape");
        final int Glove = 26;
        final int GloveChain = 27;
        AetherItems.LeatherGlove = new ItemMoreArmor(mod_Aether.idItemLeatherGlove, 0, "/armor/Accessories.png", 10, 12999733).d(Glove).a("LeatherGlove");
        AetherItems.IronGlove = new ItemMoreArmor(mod_Aether.idItemIronGlove, 2, "/armor/Accessories.png", 10, 14540253).d(Glove).a("IronGlove");
        AetherItems.GoldGlove = new ItemMoreArmor(mod_Aether.idItemGoldGlove, 1, "/armor/Accessories.png", 10, 15396439).d(Glove).a("GoldGlove");
        AetherItems.DiamondGlove = new ItemMoreArmor(mod_Aether.idItemDiamondGlove, 3, "/armor/Accessories.png", 10, 3402699).d(Glove).a("DiamondGlove");
        AetherItems.ZaniteGlove = new ItemMoreArmor(mod_Aether.idItemZaniteGlove, 2, "/armor/Accessories.png", 10, 7412456).d(Glove).a("ZaniteGlove");
        AetherItems.GravititeGlove = new ItemMoreArmor(mod_Aether.idItemGravititeGlove, 3, "/armor/Accessories.png", 10, 15160027).d(Glove).a("GravititeGlove");
        AetherItems.PhoenixGlove = new ItemMoreArmor(mod_Aether.idItemPhoenixGlove, 3, "/armor/Phoenix.png", 10, 16742144, false).d(GloveChain).a("PhoenixGlove");
        AetherItems.ObsidianGlove = new ItemMoreArmor(mod_Aether.idItemObsidianGlove, 4, "/armor/Accessories.png", 10, 1774663).d(Glove).a("ObsidianGlove");
        AetherItems.NeptuneGlove = new ItemMoreArmor(mod_Aether.idItemNeptuneGlove, 3, "/armor/Accessories.png", 10, 2512127).d(GloveChain).a("NeptuneGlove");
        AetherItems.CloudParachute = new ItemCloudParachute(mod_Aether.idItemCloudParachute).a("CloudParachute");
        AetherItems.CloudParachuteGold = new ItemCloudParachute(mod_Aether.idItemCloudParachuteGold).a("CloudParachuteGold");
        AetherItems.BlueBerry = new AetherFood(mod_Aether.idBlueBerry, 2, false).d(75).a("BlueBerry");
        AetherItems.SwetBall = new AetherItem(mod_Aether.idSwetBall).d(77).a("SwetBall");
        AetherItems.WhiteBerry = new ItemPoisonCure(mod_Aether.idWhiteBerry, 0, false).r().d(76).a("WhiteBerry");
        AetherItems.GingerBreadMan = new AetherFood(mod_Aether.idGingerBreadMan, 2, false).d(72).a("GingerBreadMan");
        AetherItems.CandyCane = new AetherFood(mod_Aether.idCandyCane, 2, false).d(73).a("CandyCane");
        AetherItems.CandySword = new ItemCandySword(mod_Aether.idCandySword, EnumToolMaterial.WOOD).d(74).a("CandySword");
        AetherItems.SentryBoots = new ItemAetherArmor(mod_Aether.idItemSentryBoots, EnumArmorMaterial.IRON, ModLoader.addArmor("Sentry"), 3).d(78).a("SentryBoots");
        ModLoader.registerEntityID((Class)EntityFlamingArrow.class, "FlamingArrow", ModLoader.getUniqueEntityId());
        ModLoader.registerEntityID((Class)EntityMiniCloud.class, "Mini Cloud", ModLoader.getUniqueEntityId());
        ModLoader.addName((Object)AetherItems.VictoryMedal, "§aVictory Medal");
        ModLoader.addName((Object)new ItemStack(AetherItems.Key, 1, 0), "§aBronze Key");
        ModLoader.addName((Object)new ItemStack(AetherItems.Key, 1, 1), "§aSilver Key");
        ModLoader.addName((Object)new ItemStack(AetherItems.Key, 1, 2), "§aGold Key");
        ModLoader.addName((Object)new ItemStack(AetherItems.LoreBook, 1, 0), "§aBook of Lore : Volume 1");
        ModLoader.addName((Object)new ItemStack(AetherItems.LoreBook, 1, 1), "§aBook of Lore : Volume 2");
        ModLoader.addName((Object)new ItemStack(AetherItems.LoreBook, 1, 2), "§aBook of Lore : Volume 3");
        ModLoader.addName((Object)AetherItems.AechorPetal, "Aechor Petal");
        ModLoader.addName((Object)AetherItems.GoldenAmber, "Golden Amber");
        ModLoader.addName((Object)AetherItems.SwetBall, "Swetty Ball");
        ModLoader.addName((Object)AetherItems.Stick, "Skyroot Stick");
        ModLoader.addName((Object)AetherItems.BlueBerry, "Blue Berry");
        ModLoader.addName((Object)AetherItems.WhiteBerry, "White Apple");
        ModLoader.addName((Object)AetherItems.GingerBreadMan, "Ginger Bread Man");
        ModLoader.addName((Object)AetherItems.CandyCane, "Candy Cane");
        ModLoader.addName((Object)AetherItems.CandySword, "Candy Sword");
        ModLoader.addName((Object)new ItemStack(AetherItems.Dart, 1, 0), "Golden Dart");
        ModLoader.addName((Object)new ItemStack(AetherItems.Dart, 1, 1), "Poison Dart");
        ModLoader.addName((Object)new ItemStack(AetherItems.Dart, 1, 2), "§bEnchanted Dart");
        ModLoader.addName((Object)new ItemStack(AetherItems.DartShooter, 1, 0), "Dart Shooter");
        ModLoader.addName((Object)new ItemStack(AetherItems.DartShooter, 1, 1), "Poison Shooter");
        ModLoader.addName((Object)new ItemStack(AetherItems.DartShooter, 1, 2), "§bEnchanted Shooter");
        ModLoader.addName((Object)AetherItems.AmbrosiumShard, "Ambrosium Shard");
        ModLoader.addName((Object)AetherItems.Zanite, "Zanite Gemstone");
        ModLoader.addName((Object)AetherItems.BlueMusicDisk, "§bBlue Music Disk");
        ModLoader.addName((Object)new ItemStack(AetherItems.Bucket, 1, 0), "Skyroot Bucket");
        ModLoader.addName((Object)new ItemStack(AetherItems.Bucket, 1, Block.WATER.id), "Water Bucket");
        ModLoader.addName((Object)new ItemStack(AetherItems.Bucket, 1, 1), "Milk Bucket");
        ModLoader.addName((Object)new ItemStack(AetherItems.Bucket, 1, 2), "Poison Bucket");
        ModLoader.addName((Object)new ItemStack(AetherItems.Bucket, 1, 3), "§bRemedy Bucket");
        ModLoader.addName((Object)AetherItems.PickSkyroot, "Skyroot Pickaxe");
        ModLoader.addName((Object)AetherItems.ShovelSkyroot, "Skyroot Shovel");
        ModLoader.addName((Object)AetherItems.AxeSkyroot, "Skyroot Axe");
        ModLoader.addName((Object)AetherItems.SwordSkyroot, "Skyroot Sword");
        ModLoader.addName((Object)AetherItems.PickHolystone, "Holystone Pickaxe");
        ModLoader.addName((Object)AetherItems.ShovelHolystone, "Holystone Shovel");
        ModLoader.addName((Object)AetherItems.AxeHolystone, "Holystone Axe");
        ModLoader.addName((Object)AetherItems.SwordHolystone, "Holystone Sword");
        ModLoader.addName((Object)AetherItems.PickZanite, "Zanite Pickaxe");
        ModLoader.addName((Object)AetherItems.ShovelZanite, "Zanite Shovel");
        ModLoader.addName((Object)AetherItems.AxeZanite, "Zanite Axe");
        ModLoader.addName((Object)AetherItems.SwordZanite, "Zanite Sword");
        ModLoader.addName((Object)AetherItems.PickGravitite, "Gravitite Pickaxe");
        ModLoader.addName((Object)AetherItems.ShovelGravitite, "Gravitite Shovel");
        ModLoader.addName((Object)AetherItems.AxeGravitite, "Gravitite Axe");
        ModLoader.addName((Object)AetherItems.SwordGravitite, "Gravitite Sword");
        ModLoader.addName((Object)AetherItems.IronBubble, "§aIron Bubble");
        ModLoader.addName((Object)AetherItems.PigSlayer, "§aPig Slayer");
        ModLoader.addName((Object)AetherItems.VampireBlade, "§aVampire Blade");
        ModLoader.addName((Object)AetherItems.NatureStaff, "Nature Staff");
        ModLoader.addName((Object)AetherItems.SwordFire, "§aFlaming Sword");
        ModLoader.addName((Object)AetherItems.SwordHoly, "§aHoly Sword");
        ModLoader.addName((Object)AetherItems.SwordLightning, "§aLightning Sword");
        ModLoader.addName((Object)AetherItems.LightningKnife, "§aLightning Knife");
        ModLoader.addName((Object)AetherItems.GummieSwet, "§aGummie Swet");
        ModLoader.addName((Object)AetherItems.HammerNotch, "§aHammer of Notch");
        ModLoader.addName((Object)AetherItems.CloudStaff, "§aCloud Staff");
        ModLoader.addName((Object)AetherItems.PhoenixBow, "§aPhoenix Bow");
        ModLoader.addName((Object)AetherItems.PhoenixHelm, "§aPhoenix Helmet");
        ModLoader.addName((Object)AetherItems.PhoenixBody, "§aPhoenix Chestplate");
        ModLoader.addName((Object)AetherItems.PhoenixLegs, "§aPhoenix Leggings");
        ModLoader.addName((Object)AetherItems.PhoenixBoots, "§aPhoenix Boots");
        ModLoader.addName((Object)AetherItems.ObsidianHelm, "§aObsidian Helmet");
        ModLoader.addName((Object)AetherItems.ObsidianBody, "§aObsidian Chestplate");
        ModLoader.addName((Object)AetherItems.ObsidianLegs, "§aObsidian Leggings");
        ModLoader.addName((Object)AetherItems.ObsidianBoots, "§aObsidian Boots");
        ModLoader.addName((Object)AetherItems.CloudParachute, "Cloud Parachute");
        ModLoader.addName((Object)AetherItems.CloudParachuteGold, "Golden Parachute");
        ModLoader.addName((Object)AetherItems.GravititeHelmet, "Gravitite Helmet");
        ModLoader.addName((Object)AetherItems.GravititeBodyplate, "Gravitite Chestplate");
        ModLoader.addName((Object)AetherItems.GravititePlatelegs, "Gravitite Leggings");
        ModLoader.addName((Object)AetherItems.GravititeBoots, "Gravitite Boots");
        ModLoader.addName((Object)AetherItems.ZaniteHelmet, "Zanite Helmet");
        ModLoader.addName((Object)AetherItems.ZaniteChestplate, "Zanite Chestplate");
        ModLoader.addName((Object)AetherItems.ZaniteLeggings, "Zanite Leggings");
        ModLoader.addName((Object)AetherItems.ZaniteBoots, "Zanite Boots");
        ModLoader.addName((Object)AetherItems.NeptuneHelmet, "§aNeptune Helmet");
        ModLoader.addName((Object)AetherItems.NeptuneChestplate, "§aNeptune Chestplate");
        ModLoader.addName((Object)AetherItems.NeptuneLeggings, "§aNeptune Leggings");
        ModLoader.addName((Object)AetherItems.NeptuneBoots, "§aNeptune Boots");
        ModLoader.addName((Object)AetherItems.LifeShard, "§aLife Shard");
        ModLoader.addName((Object)AetherItems.GoldenFeather, "§aGolden Feather");
        ModLoader.addName((Object)AetherItems.Lance, "§aValkyrie Lance");
        ModLoader.addName((Object)AetherItems.RepShield, "§aShield of Repulsion");
        ModLoader.addName((Object)AetherItems.IronRing, "Iron Ring");
        ModLoader.addName((Object)AetherItems.GoldRing, "Gold Ring");
        ModLoader.addName((Object)AetherItems.ZaniteRing, "Zanite Ring");
        ModLoader.addName((Object)AetherItems.IronPendant, "Iron Pendant");
        ModLoader.addName((Object)AetherItems.GoldPendant, "Gold Pendant");
        ModLoader.addName((Object)AetherItems.ZanitePendant, "Zanite Pendant");
        ModLoader.addName((Object)AetherItems.AetherCape, "Swet Cape");
        ModLoader.addName((Object)AetherItems.LeatherGlove, "Leather Glove");
        ModLoader.addName((Object)AetherItems.IronGlove, "Iron Gloves");
        ModLoader.addName((Object)AetherItems.GoldGlove, "Gold Gloves");
        ModLoader.addName((Object)AetherItems.DiamondGlove, "Diamond Gloves");
        ModLoader.addName((Object)AetherItems.ZaniteGlove, "Zanite Gloves");
        ModLoader.addName((Object)AetherItems.GravititeGlove, "Gravitite Gloves");
        ModLoader.addName((Object)AetherItems.PhoenixGlove, "§aPhoenix Gloves");
        ModLoader.addName((Object)AetherItems.ObsidianGlove, "§aObsidian Gloves");
        ModLoader.addName((Object)AetherItems.NeptuneGlove, "§aNeptune Gloves");
        ModLoader.addName((Object)new ItemStack(AetherItems.GummieSwet, 1, 0), "§aBlue Gummie Swet");
        ModLoader.addName((Object)new ItemStack(AetherItems.GummieSwet, 1, 1), "§aGold Gummie Swet");
        ModLoader.addName((Object)AetherItems.RegenerationStone, "§aRegeneration Stone");
        ModLoader.addName((Object)AetherItems.InvisibilityCloak, "§aInvisibility Cloak");
        ModLoader.addName((Object)AetherItems.AgilityCape, "§aAgility Cape");
        ModLoader.addName((Object)AetherItems.WhiteCape, "White Cape");
        ModLoader.addName((Object)AetherItems.RedCape, "Red Cape");
        ModLoader.addName((Object)AetherItems.YellowCape, "Yellow Cape");
        ModLoader.addName((Object)AetherItems.BlueCape, "Blue Cape");
        ModLoader.addName((Object)AetherItems.HealingStone, "§bHealing Stone");
        ModLoader.addName((Object)AetherItems.IcePendant, "Ice Pendant");
        ModLoader.addName((Object)AetherItems.IceRing, "Ice Ring");
        ModLoader.addName((Object)AetherItems.PickValkyrie, "§aValkyrie Pickaxe");
        ModLoader.addName((Object)AetherItems.ShovelValkyrie, "§aValkyrie Shovel");
        ModLoader.addName((Object)AetherItems.AxeValkyrie, "§aValkyrie Axe");
        ModLoader.addName((Object)AetherItems.SentryBoots, "§aSentry Boots");
        for (int i = 0; i < MoaColour.colours.size(); ++i) {
            ModLoader.addName((Object)new ItemStack(AetherItems.MoaEgg, 1, i), MoaColour.getColour(i).name + " Moa Egg");
        }
        if (mod_Aether.TMIhidden) {}
    }
    
    public static void tick(final MinecraftServer game) {
        if (!game.theWorld.isStatic) {
            final EntityPlayer player = (EntityPlayer)game.thePlayer;
            final InventoryAether inv = mod_Aether.getPlayer(player).inv;
            if (player.inventory.armor[3] != null && player.inventory.armor[3].id == AetherItems.PhoenixHelm.id && player.inventory.armor[2] != null && player.inventory.armor[2].id == AetherItems.PhoenixBody.id && player.inventory.armor[1] != null && player.inventory.armor[1].id == AetherItems.PhoenixLegs.id && player.inventory.armor[0] != null && player.inventory.armor[0].id == AetherItems.PhoenixBoots.id && inv.slots[6] != null && inv.slots[6].id == AetherItems.PhoenixGlove.id) {
                ((Entity)player).fireProof = true;
                player.extinguish();
                if (!GuiMainMenu.mmactive) {
                    game.theWorld.spawnParticle("flame", ((Entity)player).locX + ((Entity)player).random.nextGaussian() / 5.0, ((Entity)player).locY - 0.5 + ((Entity)player).random.nextGaussian() / 5.0, ((Entity)player).locZ + ((Entity)player).random.nextGaussian() / 3.0, 0.0, 0.0, 0.0);
                }
            }
            else {
                ((Entity)player).fireProof = false;
            }
            if (player.aT()) {
                final int playerBlock = game.theWorld.getBlockId(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ));
                if (player.inventory.armor[0] != null && player.inventory.armor[0].id == AetherItems.PhoenixBoots.id) {
                    player.inventory.armor[0].damage(1, (EntityLiving)player);
                    if (playerBlock == Block.STATIONARY_WATER.id) {
                        player.inventory.armor[0].damage(4, (EntityLiving)player);
                        game.theWorld.setBlockWithNotify(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ), 0);
                    }
                    if (player.inventory.armor[0] == null || player.inventory.armor[0].count < 1) {
                        player.inventory.armor[0] = new ItemStack(AetherItems.ObsidianBoots, 1, 0);
                    }
                }
                if (player.inventory.armor[1] != null && player.inventory.armor[1].id == AetherItems.PhoenixLegs.id) {
                    player.inventory.armor[1].damage(1, (EntityLiving)player);
                    if (playerBlock == Block.STATIONARY_WATER.id) {
                        player.inventory.armor[1].damage(4, (EntityLiving)player);
                        game.theWorld.setBlockWithNotify(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ), 0);
                    }
                    if (player.inventory.armor[1] == null || player.inventory.armor[1].count < 1) {
                        player.inventory.armor[1] = new ItemStack(AetherItems.ObsidianLegs, 1, 0);
                    }
                }
                if (player.inventory.armor[2] != null && player.inventory.armor[2].id == AetherItems.PhoenixBody.id) {
                    player.inventory.armor[2].damage(1, (EntityLiving)player);
                    if (playerBlock == Block.STATIONARY_WATER.id) {
                        player.inventory.armor[2].damage(4, (EntityLiving)player);
                        game.theWorld.setBlockWithNotify(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ), 0);
                    }
                    if (player.inventory.armor[2] == null || player.inventory.armor[2].count < 1) {
                        player.inventory.armor[2] = new ItemStack(AetherItems.ObsidianBody, 1, 0);
                    }
                }
                if (player.inventory.armor[3] != null && player.inventory.armor[3].id == AetherItems.PhoenixHelm.id) {
                    player.inventory.armor[3].damage(1, (EntityLiving)player);
                    if (playerBlock == Block.STATIONARY_WATER.id) {
                        player.inventory.armor[3].damage(4, (EntityLiving)player);
                        game.theWorld.setBlockWithNotify(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ), 0);
                    }
                    if (player.inventory.armor[3] == null || player.inventory.armor[3].count < 1) {
                        player.inventory.armor[3] = new ItemStack(AetherItems.ObsidianHelm, 1, 0);
                    }
                }
                if (inv.slots[6] != null && inv.slots[6].id == AetherItems.PhoenixGlove.id) {
                    inv.slots[6].damage(1, (EntityLiving)player);
                    if (playerBlock == Block.STATIONARY_WATER.id) {
                        inv.slots[6].damage(4, (EntityLiving)player);
                        game.theWorld.setBlockWithNotify(MathHelper.floor(((Entity)player).locX), MathHelper.floor(((Entity)player).locY), MathHelper.floor(((Entity)player).locZ), 0);
                    }
                    if (inv.slots[6] == null || inv.slots[6].count < 1) {
                        inv.slots[6] = new ItemStack(AetherItems.ObsidianGlove, 1, 0);
                    }
                }
            }
            if (player.inventory.armor[3] != null && player.inventory.armor[3].id == AetherItems.GravititeHelmet.id && player.inventory.armor[2] != null && player.inventory.armor[2].id == AetherItems.GravititeBodyplate.id && player.inventory.armor[1] != null && player.inventory.armor[1].id == AetherItems.GravititePlatelegs.id && player.inventory.armor[0] != null && player.inventory.armor[0].id == AetherItems.GravititeBoots.id && inv.slots[6] != null && inv.slots[6].id == AetherItems.GravititeGlove.id) {
                if (((EntityLiving)player).aZ && !AetherItems.jumpBoosted) {
                    ((Entity)player).motY = 1.0;
                    AetherItems.jumpBoosted = true;
                }
                ((Entity)player).fallDistance = -1.0f;
            }
            if (!((EntityLiving)player).aZ && ((Entity)player).onGround) {
                AetherItems.jumpBoosted = false;
            }
            if ((inv.slots[3] != null && inv.slots[3].id == AetherItems.IronBubble.id) || (inv.slots[7] != null && inv.slots[7].id == AetherItems.IronBubble.id)) {
                player.setAirTicks(20);
            }
            if ((inv.slots[0] != null && inv.slots[0].id == AetherItems.IcePendant.id) || (inv.slots[4] != null && inv.slots[4].id == AetherItems.IceRing.id) || (inv.slots[5] != null && inv.slots[5].id == AetherItems.IceRing.id)) {
                final int i = MathHelper.floor(((Entity)player).locX);
                final int j = MathHelper.floor(((Entity)player).boundingBox.b);
                final int k = MathHelper.floor(((Entity)player).locZ);
                final double yoff = ((Entity)player).locY - j;
                final Material mat0 = game.theWorld.getBlockMaterial(i, j, k);
                final Material mat2 = game.theWorld.getBlockMaterial(i, j - 1, k);
                for (int l = i - 1; l <= i + 1; ++l) {
                    for (int i2 = j - 1; i2 <= j + 1; ++i2) {
                        for (int j2 = k - 1; j2 <= k + 1; ++j2) {
                            if (game.theWorld.getBlockId(l, i2, j2) == 8) {
                                game.theWorld.setBlockWithNotify(l, i2, j2, 79);
                            }
                            else if (game.theWorld.getBlockId(l, i2, j2) == 9) {
                                game.theWorld.setBlockWithNotify(l, i2, j2, 79);
                            }
                            else if (game.theWorld.getBlockId(l, i2, j2) == 10) {
                                game.theWorld.setBlockWithNotify(l, i2, j2, 49);
                            }
                            else if (game.theWorld.getBlockId(l, i2, j2) == 11) {
                                game.theWorld.setBlockWithNotify(l, i2, j2, 49);
                            }
                        }
                    }
                }
            }
            if ((inv.slots[3] != null && inv.slots[3].id == AetherItems.GoldenFeather.id) || (inv.slots[7] != null && inv.slots[7].id == AetherItems.GoldenFeather.id)) {
                if (!((Entity)player).onGround && ((Entity)player).motY < 0.0 && !((Entity)player).bV) {
                    final EntityPlayer entityPlayer = player;
                    ((Entity)entityPlayer).motY *= 0.6;
                }
                ((Entity)player).fallDistance = -1.0f;
            }
            if (inv.slots[1] != null && inv.slots[1].id == AetherItems.AgilityCape.id) {
                ((Entity)player).bP = 1.0f;
            }
            else {
                ((Entity)player).bP = 0.5f;
            }
            if (AetherItems.ticks % 200 == 0 && ((EntityLiving)player).health < mod_Aether.getPlayer(player).maxHealth && ((inv.slots[3] != null && inv.slots[3].id == AetherItems.RegenerationStone.id) || (inv.slots[7] != null && inv.slots[7].id == AetherItems.RegenerationStone.id))) {
                player.heal(1);
            }
            ++AetherItems.ticks;
        }
    }
    
    
    public static void takenCrafting(final EntityPlayer player, final ItemStack stack) {
        if (stack.id == AetherBlocks.Enchanter.id) {
            mod_Aether.giveAchievement(AetherAchievements.enchanter, player);
        }
        if (stack.id == AetherItems.PickGravitite.id || stack.id == AetherItems.ShovelGravitite.id || stack.id == AetherItems.AxeGravitite.id || stack.id == AetherItems.SwordGravitite.id) {
            mod_Aether.giveAchievement(AetherAchievements.gravTools, player);
        }
    }
    
    public int override(final String path) {
        return ModLoader.addOverride("/gui/items.png", "/aether/items/" + path);
    }
    
    static {
        AetherItems.motionOffset = 0.05;
        AetherItems.ybuff = 0.3;
        AetherItems.ticks = 0;
        AetherItems.ElementalSwordIcon = 24;
        AetherItems.gravArmour = ModLoader.addArmor("Gravitite");
        AetherItems.zaniteArmour = ModLoader.addArmor("Zanite");
        AetherItems.neptuneArmour = ModLoader.addArmor("Neptune");
        AetherItems.debug = false;
    }
}
