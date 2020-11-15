package net.minecraft.server;

import java.util.*;

public class AetherMobs
{
    public AetherMobs() {
        ModLoader.registerEntityID((Class)EntityAerwhale.class, "Aerwhale", 100, 10470391, 8491933);
        ModLoader.registerEntityID((Class)EntityCockatrice.class, "Cockatrice", 101, 10470391, 4006712);
        ModLoader.registerEntityID((Class)EntitySwet.class, "Swets", 102, 10470391, 6258844);
        ModLoader.registerEntityID((Class)EntityZephyr.class, "Zephyr", 103, 10470391, 7970732);
        ModLoader.registerEntityID((Class)EntitySheepuff.class, "Sheepuff", 104, 10470391, 13340816);
        ModLoader.registerEntityID((Class)EntityPhyg.class, "FlyingPig", 105, 10470391, 14377823);
        ModLoader.registerEntityID((Class)EntityAechorPlant.class, "AechorPlant", 106, 10470391, 2729875);
        ModLoader.registerEntityID((Class)EntitySentry.class, "Sentry", 107, 10470391, 11382189);
        ModLoader.registerEntityID((Class)EntitySlider.class, "Slider", 108);
        ModLoader.registerEntityID((Class)EntityValkyrie.class, "Valkyrie", 109);
        ModLoader.registerEntityID((Class)EntityHomeShot.class, "HomeShot", 110);
        ModLoader.registerEntityID((Class)EntityFireMonster.class, "Fire Monster", 111);
        ModLoader.registerEntityID((Class)EntityFireMinion.class, "Fire Minion", 112);
        ModLoader.registerEntityID((Class)EntityFiroBall.class, "Firo Ball", 113);
        ModLoader.registerEntityID((Class)EntityMoa.class, "MoaBase", 114, 10470391, 3423812);
        ModLoader.registerEntityID((Class)EntityFlyingCow.class, "FlyingCow", 115, 10470391, 4075810);
        ModLoader.registerEntityID((Class)EntityAerbunny.class, "Aerbunny", 116, 10470391, 9532789);
        ModLoader.registerEntityID((Class)Whirly.class, "Whirlwind", 117, 10470391, 16777215);
        ModLoader.addLocalization("entity.Aerwhale.name", "Aerwhale");
        ModLoader.addLocalization("entity.Cockatrice.name", "Cockatrice");
        ModLoader.addLocalization("entity.Swets.name", "Swets");
        ModLoader.addLocalization("entity.Zephyr.name", "Zephyr");
        ModLoader.addLocalization("entity.Sheepuff.name", "Sheepuff");
        ModLoader.addLocalization("entity.FlyingPig.name", "Phyg");
        ModLoader.addLocalization("entity.AechorPlant.name", "Aechor Plant");
        ModLoader.addLocalization("entity.Sentry.name", "Sentry");
        ModLoader.addLocalization("entity.Slider.name", "Slider");
        ModLoader.addLocalization("entity.Valkyrie.name", "Valkyrie");
        ModLoader.addLocalization("entity.MoaBase.name", "Moa");
        ModLoader.addLocalization("entity.FlyingCow.name", "Flying Cow");
        ModLoader.addLocalization("entity.Aerbunny.name", "Aerbunny");
        ModLoader.addLocalization("entity.Whirlwind.name", "Whirlwind");
    }
    
}
