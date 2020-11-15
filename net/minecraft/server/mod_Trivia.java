package net.minecraft.server;

import java.util.logging.*;
import net.minecraft.client.*;
import java.io.*;
import java.util.*;

public class mod_Trivia extends BaseMod
{
    public String path;
    public File file;
    public Logger logger;
    public static Random random;
    public static List tnotesDefault;
    public static List tnotes;
    
    public mod_Trivia() {
        this.path = "mod_Trivia.txt";
        this.logger = ModLoader.getLogger();
    }
    
    public void load() {
        this.file = new File(Minecraft.getAppDir("minecraft/config"), this.path);
        ModLoader.getMinecraftInstance().loadingScreen = new LoadingScreenRendererTrivia(ModLoader.getMinecraftInstance());
        if (!this.file.getParentFile().exists()) {
            this.file.getParentFile().mkdirs();
        }
        if (this.file.exists()) {
            this.loadEntries();
        }
        else {
            this.saveEntries();
        }
    }
    
    public void saveEntries() {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(this.file));
            for (final String entry : mod_Trivia.tnotes) {
                writer.write(entry);
                writer.newLine();
            }
            this.logger.fine("Wrote " + mod_Trivia.tnotes.size() + " entries to " + this.file);
        }
        catch (Throwable e) {
            this.logger.warning("Could not save MinerTrivia entries to file, using defaults.");
            ModLoader.getLogger().throwing("mod_Trivia", "loadEntries", e);
        }
        finally {
            this.close(writer);
        }
    }
    
    public void loadEntries() {
        BufferedReader reader = null;
        final List entries = new ArrayList();
        try {
            reader = new BufferedReader(new FileReader(this.file));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }
                entries.add(line.trim());
            }
            this.logger.fine("Loaded " + entries.size() + " entries from " + this.file);
            mod_Trivia.tnotes = entries;
        }
        catch (Throwable e) {
            this.logger.warning("Could not load MinerTrivia entries from file, using defaults.");
            ModLoader.getLogger().throwing("mod_Trivia", "loadEntries", e);
        }
        finally {
            this.close(reader);
        }
    }
    
    public void close(final Closeable c) {
        if (c != null) {
            try {
                c.close();
            }
            catch (Throwable t) {}
        }
    }
    
    public static String getNewString() {
        final int i = mod_Trivia.random.nextInt(mod_Trivia.tnotes.size());
        return "Pro Tip: " + mod_Trivia.tnotes.get(i);
    }
    
    public String getVersion() {
        return "MC 1.0.0 Aether Edition";
    }
    
    static {
        mod_Trivia.random = new Random();
        mod_Trivia.tnotesDefault = Arrays.asList("Placing a saddle on Flying Pigs makes them a mount.", "Moa Eggs can be incubated into Baby Moas with the Incubator.", "Gravitite Ore can be enchanted into Enchanted Gravitite.", "Enchanted Gravitite only floats up when powered.", "Enchanted Gravitite can be crafted into armour and tools.", "Gravitite Armour grants you higher jumps and no fall damage.", "Gravitite Tools can levitate blocks when right-clicking.", "Baby Moas will follow you when right clicking them.", "Golden Oak trees yeild valuable Golden Amber in their logs.", "Enchanters can repair damaged items and enhance existing items.", "Skyroot tools gain double drops from blocks.", "Place water into a Glowstone frame for a Hostile Paradise.", "The Champs and Champettes are pretty baller.", "Zanite Tools gain strength the more they are used.", "Ambrosium Shards are great for fueling Enchanters and food.", "Icestone freezes water into ice and lava into obsidian.", "Some dungeons in the Aether contain chests which are Mimics.", "White Aerclouds prevent fall damage when landed upon.", "Blue Aerclouds are bouncy, and launch mobs very high in the air.", "Cloud Parachutes can be crafted with four White Aercloud blocks.", "Parachutes auto-activate when falling off an island.", "Golden Parachutes have twenty uses rather than one.", "The leaves of Golden Oak trees occasionally drop Golden Apples.", "Aerogel acts as an explosion-resistant, transparent block.", "Quicksoil increases the speed of walking mobs and sliding items.", "Holystone tools occasionally generate Ambrosium.", "Dungeons can contain extremely powerful and unique rewards.", "Dungeons have various difficulties: from Bronze, Silver, to Gold.", "Normal music disks can be enchanted into a Blue version.", "You can harvest Aechor Plant's poison with Skyroot Buckets.", "Golden, Poison, and Enchanted Darts are not affected by gravity.", "Dart Shooters can be crafted with Skyroot Logs and Zanite Gemstones.", "A Remedy Bucket for poison can be obtained by enchanting Poison.", "Gravitite Armour increases your jump-height when a full set is worn.", "Try submerging yourself in water while wearing Phoenix Armour.", "Zephyrs shoot snowballs with a force that can throw you off islands.", "Days in the Aether realm last three times longer than surface days.", "Sheepuff occasionally puff their wool out, making them float.", "When defeated, Valkyries they will drop a Victory Medal.", "Skeletons won't shoot if they can't see your face.", "Never dig straight down.", "If a drop looks too big, it probably is.", "A shelter made of dirt is still a shelter.", "Don't fear the Creeper.", "Before you jump, make sure the water isn't too shallow.", "Watch your back when running from spiders.", "Don't leave your house without closing the door.", "Check underneath a Diamond Ore block before mining it.", "Watch where you step - deep shafts can be anywhere.", "Cliff overhangs and lighting glitches can spawn hostile mobs.", "Gold may be weak, but it's better than nothing.", "Always bring tons of logs with you when exploring caves.", "Always check your surroundings before entering a fight.", "Don't store spare TNT blocks near your Redstone circuits.", "You can always come back later and mine some more.", "Unlike the other tools, the hoe is used by right-clicking.", "Always keep a spare stack of blocks in your active inventory.", "Raw meat is better than no meat.", "Blocks can be mined faster if you time your clicks correctly.", "Placing a torch under sand as it falls speeds up the process.", "Animals might push you around if you leave the game idle.", "Ghasts have lower health than any other hostile mob.", "You can reflect a Ghast's fireball by simply hitting it.", "Mobs might not drop loot if they die from explosions.", "Don't take huge risks far from home.", "If you hear a cave noise above ground, there's one nearby.", "If you hear a lot of monsters, it's probably a dungeon.", "Mining cave ceilings can easily lead to disaster.", "Catching on fire can easily drain an entire health bar.", "The best time to do anything is before it's too late.", "One boat is never enough.", "Wood is the most versatile resource in the game.", "Never expect that nothing will happen while you're gone.", "Always treat modders with respect.", "Baby slimes are terribly vulnerable to fall damage.", "Slimes do exist... I think.", "Only give away your personal information to Paypal.", "The sun and the compass are both useful for directions.", "Paintings aren't considered to be blocks.", "Sand on red dust on TNT can make a falling floor trap.", "Easier rarely means funner.", "Zombies can reach pretty far and hit pretty hard.", "Arrows reflect off of creatures recently damaged.", "Be careful not to misclick when building portals.", "Sand is useful for getting down from high places.", "If all you can hear is footsteps, it's a Creeper.", "It's misleading to locate monsters by sound alone.", "Spider jockeys will dismount after a save and reload.", "The game is only as fun as you make it.");
        mod_Trivia.tnotes = mod_Trivia.tnotesDefault;
    }
}
