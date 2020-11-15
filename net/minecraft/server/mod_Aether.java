package net.minecraft.server;

import net.minecraft.server.*;
import forge.*;
import java.util.*;

public class mod_Aether extends BaseMod implements ISoundHandler
{
    private static World world;
    private static World nbtWorld;
    private static long clock;
    private boolean cloudPara;
    private Random rand;
    private float zLevel;
    private int updateCounter;
    public static int renderID;
    @MLProp
    public static int raritySwet;
    @MLProp
    public static int rarityAechorPlant;
    @MLProp
    public static int rarityCockatrice;
    @MLProp
    public static int rarityAerwhale;
    @MLProp
    public static int rarityZephyr;
    @MLProp
    public static int raritySheepuff;
    @MLProp
    public static int rarityPhyg;
    @MLProp
    public static int rarityMoa;
    @MLProp
    public static int rarityFlyingCow;
    @MLProp
    public static int rarityWhirlwind;
    @MLProp
    public static int rarityAerbunny;
    @MLProp
    public static boolean worldMenu;
    @MLProp
    public static boolean aetherMenu;
    @MLProp
    public static boolean TMIhidden;
    @MLProp
    public static boolean christmasContent;
    @MLProp
    public static int idBlockAetherPortal;
    @MLProp
    public static int idBlockAetherDirt;
    @MLProp
    public static int idBlockAetherGrass;
    @MLProp
    public static int idBlockQuicksoil;
    @MLProp
    public static int idBlockHolystone;
    @MLProp
    public static int idBlockIcestone;
    @MLProp
    public static int idBlockAercloud;
    @MLProp
    public static int idBlockAerogel;
    @MLProp
    public static int idBlockEnchanter;
    @MLProp
    public static int idBlockIncubator;
    @MLProp
    public static int idBlockLog;
    @MLProp
    public static int idBlockPlank;
    @MLProp
    public static int idBlockSkyrootLeaves;
    @MLProp
    public static int idBlockGoldenOakLeaves;
    @MLProp
    public static int idBlockSkyrootSapling;
    @MLProp
    public static int idBlockGoldenOakSapling;
    @MLProp
    public static int idBlockAmbrosiumOre;
    @MLProp
    public static int idBlockAmbrosiumTorch;
    @MLProp
    public static int idBlockZaniteOre;
    @MLProp
    public static int idBlockGravititeOre;
    @MLProp
    public static int idBlockEnchantedGravitite;
    @MLProp
    public static int idBlockTrap;
    @MLProp
    public static int idBlockChestMimic;
    @MLProp
    public static int idBlockTreasureChest;
    @MLProp
    public static int idBlockDungeonStone;
    @MLProp
    public static int idBlockLightDungeonStone;
    @MLProp
    public static int idBlockLockedDungeonStone;
    @MLProp
    public static int idBlockLockedLightDungeonStone;
    @MLProp
    public static int idBlockPillar;
    @MLProp
    public static int idBlockZanite;
    @MLProp
    public static int idBlockQuicksoilGlass;
    @MLProp
    public static int idBlockFreezer;
    @MLProp
    public static int idBlockWhiteFlower;
    @MLProp
    public static int idBlockPurpleFlower;
    @MLProp
    public static int idBlockAetherBed;
    @MLProp
    public static int idBlockChristmasLeaves;
    @MLProp
    public static int idBlockPresent;
    @MLProp
    public static int idBerryBush;
    @MLProp
    public static int idBushStem;
    @MLProp
    public static int idBlockBlueLeaves;
    @MLProp
    public static int idBlockHolystoneStairs;
    @MLProp
    public static int idBlockMossyHolystoneStairs;
    @MLProp
    public static int idBlockIcestoneStairs;
    @MLProp
    public static int idBlockPlankStairs;
    @MLProp
    public static int idBlockCarvedStairs;
    @MLProp
    public static int idBlockAngelicStairs;
    @MLProp
    public static int idBlockHellfireStairs;
    @MLProp
    public static int idBlockHolystoneFence;
    @MLProp
    public static int idBlockMossyHolystoneFence;
    @MLProp
    public static int idBlockIcestoneFence;
    @MLProp
    public static int idBlockPlankFence;
    @MLProp
    public static int idBlockCarvedFence;
    @MLProp
    public static int idBlockAngelicFence;
    @MLProp
    public static int idBlockHellfireFence;
    @MLProp
    public static int idSunAltar;
    @MLProp
    public static int idItemVictoryMedal;
    @MLProp
    public static int idItemKey;
    @MLProp
    public static int idItemLoreBook;
    @MLProp
    public static int idItemMoaEgg;
    @MLProp
    public static int idItemBlueMusicDisk;
    @MLProp
    public static int idItemGoldenAmber;
    @MLProp
    public static int idItemAechorPetal;
    @MLProp
    public static int idItemStick;
    @MLProp
    public static int idItemDart;
    @MLProp
    public static int idItemDartShooter;
    @MLProp
    public static int idItemAmbrosiumShard;
    @MLProp
    public static int idItemZanite;
    @MLProp
    public static int idItemBucket;
    @MLProp
    public static int idItemPickSkyroot;
    @MLProp
    public static int idItemPickHolystone;
    @MLProp
    public static int idItemPickZanite;
    @MLProp
    public static int idItemPickGravitite;
    @MLProp
    public static int idItemShovelSkyroot;
    @MLProp
    public static int idItemShovelHolystone;
    @MLProp
    public static int idItemShovelZanite;
    @MLProp
    public static int idItemShovelGravitite;
    @MLProp
    public static int idItemAxeSkyroot;
    @MLProp
    public static int idItemAxeHolystone;
    @MLProp
    public static int idItemAxeZanite;
    @MLProp
    public static int idItemAxeGravitite;
    @MLProp
    public static int idItemSwordSkyroot;
    @MLProp
    public static int idItemSwordHolystone;
    @MLProp
    public static int idItemSwordZanite;
    @MLProp
    public static int idItemSwordGravitite;
    @MLProp
    public static int idItemIronBubble;
    @MLProp
    public static int idItemPigSlayer;
    @MLProp
    public static int idItemVampireBlade;
    @MLProp
    public static int idItemNatureStaff;
    @MLProp
    public static int idItemSwordFire;
    @MLProp
    public static int idItemSwordHoly;
    @MLProp
    public static int idItemSwordLightning;
    @MLProp
    public static int idItemLightningKnife;
    @MLProp
    public static int idItemGummieSwet;
    @MLProp
    public static int idItemHammerNotch;
    @MLProp
    public static int idItemPhoenixBow;
    @MLProp
    public static int idItemCloudParachute;
    @MLProp
    public static int idItemCloudParachuteGold;
    @MLProp
    public static int idItemCloudStaff;
    @MLProp
    public static int idItemLifeShard;
    @MLProp
    public static int idItemGoldenFeather;
    @MLProp
    public static int idItemLance;
    @MLProp
    public static int idItemIronRing;
    @MLProp
    public static int idItemGoldRing;
    @MLProp
    public static int idItemZaniteRing;
    @MLProp
    public static int idItemIronPendant;
    @MLProp
    public static int idItemGoldPendant;
    @MLProp
    public static int idItemZanitePendant;
    @MLProp
    public static int idItemRepShield;
    @MLProp
    public static int idItemAetherCape;
    @MLProp
    public static int idItemLeatherGlove;
    @MLProp
    public static int idItemIronGlove;
    @MLProp
    public static int idItemGoldGlove;
    @MLProp
    public static int idItemDiamondGlove;
    @MLProp
    public static int idItemZaniteGlove;
    @MLProp
    public static int idItemZaniteHelmet;
    @MLProp
    public static int idItemZaniteChestplate;
    @MLProp
    public static int idItemZaniteLeggings;
    @MLProp
    public static int idItemZaniteBoots;
    @MLProp
    public static int idItemGravititeGlove;
    @MLProp
    public static int idItemGravititeHelmet;
    @MLProp
    public static int idItemGravititeBodyplate;
    @MLProp
    public static int idItemGravititePlatelegs;
    @MLProp
    public static int idItemGravititeBoots;
    @MLProp
    public static int idItemPhoenixGlove;
    @MLProp
    public static int idItemPhoenixHelm;
    @MLProp
    public static int idItemPhoenixBody;
    @MLProp
    public static int idItemPhoenixLegs;
    @MLProp
    public static int idItemPhoenixBoots;
    @MLProp
    public static int idItemObsidianGlove;
    @MLProp
    public static int idItemObsidianBody;
    @MLProp
    public static int idItemObsidianHelm;
    @MLProp
    public static int idItemObsidianLegs;
    @MLProp
    public static int idItemObsidianBoots;
    @MLProp
    public static int idItemNeptuneGlove;
    @MLProp
    public static int idItemNeptuneHelmet;
    @MLProp
    public static int idItemNeptuneChestplate;
    @MLProp
    public static int idItemNeptuneLeggings;
    @MLProp
    public static int idItemNeptuneBoots;
    @MLProp
    public static int idItemRegenerationStone;
    @MLProp
    public static int idItemInvisibilityCloak;
    @MLProp
    public static int idItemAgilityCape;
    @MLProp
    public static int idItemWhiteCape;
    @MLProp
    public static int idItemRedCape;
    @MLProp
    public static int idItemYellowCape;
    @MLProp
    public static int idItemBlueCape;
    @MLProp
    public static int idItemPickValkyrie;
    @MLProp
    public static int idItemAxeValkyrie;
    @MLProp
    public static int idItemShovelValkyrie;
    @MLProp
    public static int idItemHealingStone;
    @MLProp
    public static int idItemIceRing;
    @MLProp
    public static int idItemIcePendant;
    @MLProp
    public static int idBlueBerry;
    @MLProp
    public static int idGingerBreadMan;
    @MLProp
    public static int idCandyCane;
    @MLProp
    public static int idCandySword;
    @MLProp
    public static int idWhiteBerry;
    @MLProp
    public static int idSwetBall;
    @MLProp
    public static int idItemSentryBoots;
    public static boolean hasLoreOverworld;
    public static boolean hasLoreNether;
    public static boolean hasLoreAether;
    public static IAetherBoss currentBoss;
    public static PlayerBaseAether Player;
    MinecraftServer mc;
    public static BiomeBase biomeAether;
    public static WorldProvider dim;
    public TeleporterAether teleporter;
    private KeyBinding key_loreGain;
    
    public mod_Aether() {
        this.cloudPara = false;
        this.rand = new Random();
        this.zLevel = -90.0f;
        this.mc = ModLoader.getMinecraftInstance();
        this.teleporter = new TeleporterAether();
        this.key_loreGain = new KeyBinding("key.loreGain", 48);
    }
    
    public void load() {
        Item.byId[Item.WATER_BUCKET.id] = null;
        final Item[] byId = Item.byId;
        final int id = Item.WATER_BUCKET.id;
        final Item a = new ItemAetherBucket(Item.WATER_BUCKET.id - 256, Block.WATER.id).a(11, 4).a("WATER_BUCKET").a(Item.BUCKET);
        byId[id] = a;
        Item.WATER_BUCKET = a;
        Item.byId[Item.LAVA_BUCKET.id] = null;
        final Item[] itemsList2 = Item.byId;
        final int shiftedIndex2 = Item.LAVA_BUCKET.id;
        final Item setContainerItem2 = new ItemAetherBucket(Item.LAVA_BUCKET.id - 256, Block.LAVA.id).a(12, 4).a("LAVA_BUCKET").a(Item.BUCKET);
        itemsList2[shiftedIndex2] = setContainerItem2;
        Item.LAVA_BUCKET = setContainerItem2;
        MinecraftForgeClient.registerSoundHandler((ISoundHandler)this);
        mod_Aether.renderID = ModLoader.getUniqueBlockModelID((BaseMod)this, true);
        MinecraftForgeClient.preloadTexture("/aetherBlocks.png");
        MinecraftForgeClient.preloadTexture("/aetherItems.png");
        MinecraftForgeClient.preloadTexture("/terrain.png");
        PlayerAPI.register("Aether", PlayerBaseAether.class);
        DimensionManager.registerDimension(3, mod_Aether.dim, true);
        final BiomeBase aether = new BiomeGenAether();
        new AetherBlocks();
        new AetherItems();
        new AetherMobs();
        new AetherPoison();
        new AetherAchievements();
        new AetherRecipes();
        ModLoader.registerKey((BaseMod)this, this.key_loreGain, false);
        ModLoader.addLocalization("key.loreGain", "Gain Lore");
        ModLoader.setInGameHook((BaseMod)this, true, false);
    }
    
    public boolean renderWorldBlock(final RenderBlocks renderblocks, final IBlockAccess iblockaccess, final int i, final int j, final int k, final Block block, final int l) {
        if (l == mod_Aether.renderID) {
            renderblocks.overrideBlockTexture = 49;
            renderblocks.renderCrossedSquares(block, i, j, k);
            renderblocks.overrideBlockTexture = -1;
            renderblocks.renderStandardBlock(block, i, j, k);
            return true;
        }
        return false;
    }
    
    public void renderInvBlock(final RenderBlocks renderblocks, final Block block, final int i, final int j) {
        if (j == mod_Aether.renderID) {
            final Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            renderblocks.overrideBlockTexture = 49;
            renderblocks.drawCrossedSquares(block, i, -0.5, -0.5, -0.5);
            tessellator.draw();
            renderblocks.overrideBlockTexture = -1;
            block.f();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            renderblocks.renderBottomFace(block, 0.0, 0.0, 0.0, block.a(0, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            renderblocks.renderTopFace(block, 0.0, 0.0, 0.0, block.a(1, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            renderblocks.renderEastFace(block, 0.0, 0.0, 0.0, block.a(2, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            renderblocks.renderWestFace(block, 0.0, 0.0, 0.0, block.a(3, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            renderblocks.renderNorthFace(block, 0.0, 0.0, 0.0, block.a(4, i));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            renderblocks.renderSouthFace(block, 0.0, 0.0, 0.0, block.a(5, i));
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        }
    }
    
    public void keyboardEvent(final KeyBinding event) {
        final Minecraft mc = ModLoader.getMinecraftInstance();
        if (event == this.key_loreGain) {
            final EntityPlayer entityplayer = (EntityPlayer)ModLoader.getMinecraftInstance().thePlayer;
            if (getCurrentDimension() == 3) {
                entityplayer.inventory.pickup(new ItemStack(AetherItems.LoreBook, 1, 2));
            }
            else if (getCurrentDimension() == 0) {
                entityplayer.inventory.pickup(new ItemStack(AetherItems.LoreBook, 1, 0));
            }
            else if (getCurrentDimension() == -1) {
                entityplayer.inventory.pickup(new ItemStack(AetherItems.LoreBook, 1, 1));
            }
        }
    }
    
    public boolean onTickInGame(final float ticks, final Minecraft game) {
        if (!(this.mc.renderGlobal instanceof RenderGlobalAether)) {
            (this.mc.renderGlobal = new RenderGlobalAether(this.mc, this.mc.renderEngine)).changeWorld(this.mc.theWorld);
        }
        if (mod_Aether.currentBoss != null) {
            final Entity boss = mod_Aether.currentBoss.GetEntity();
            if (Math.sqrt(Math.pow(boss.locX - ((Entity)game.thePlayer).locX, 2.0) + Math.pow(boss.locY - ((Entity)game.thePlayer).locY, 2.0) + Math.pow(boss.locZ - ((Entity)game.thePlayer).locZ, 2.0)) > 50.0) {
                mod_Aether.currentBoss = null;
            }
        }
        if (!game.theWorld.isStatic) {
            if (game.theWorld != mod_Aether.nbtWorld) {
                if (mod_Aether.nbtWorld != null) {
                    AetherNBT.save(mod_Aether.nbtWorld);
                }
                if (game.theWorld != null) {
                    AetherNBT.load(game.theWorld);
                }
                mod_Aether.nbtWorld = game.theWorld;
            }
            if (mod_Aether.nbtWorld != null && mod_Aether.nbtWorld.b().getWorldTime() % mod_Aether.nbtWorld.p == 0L) {
                AetherNBT.save(mod_Aether.nbtWorld);
            }
        }
        if (!(game.currentScreen instanceof GuiMainMenu)) {
            GuiMainMenu.mmactive = false;
        }
        if (game.thePlayer != null) {
            final EntityPlayer player = (EntityPlayer)game.thePlayer;
            if (player.dimension == 3 && ((Entity)player).locY < -2.0 && !GuiMainMenu.mmactive) {
                Class entityClass = null;
                final NBTTagCompound tag = new NBTTagCompound();
                if (((Entity)player).vehicle != null) {
                    entityClass = ((Entity)player).vehicle.getClass();
                    ((Entity)player).vehicle.b(tag);
                    ((Entity)player).vehicle.die();
                }
                final double motionY = ((Entity)player).motY;
                this.cloudPara = false;
                if (EntityCloudParachute.getCloudBelongingToEntity((EntityLiving)player) != null) {
                    this.cloudPara = true;
                }
                game.usePortal(((BlockAetherPortal)AetherBlocks.Portal).getDimNumber(), (Teleporter)this.teleporter);
                game.thePlayer.setPositionRotation(((Entity)player).locX, 127.0, ((Entity)player).locZ, ((Entity)player).yaw, 0.0f);
                if (entityClass != null && !game.theWorld.isStatic) {
                    Entity riding = null;
                    try {
                        riding = entityClass.getDeclaredConstructor(World.class).newInstance(game.theWorld);
                        riding.a(tag);
                        riding.setPositionRotation(((Entity)player).locX, 127.0, ((Entity)player).locZ, ((Entity)player).yaw, 0.0f);
                        game.theWorld.spawnEntityInWorld(riding);
                        player.mount(riding);
                    }
                    catch (Exception e) {
                        System.out.println("Failed to transfer mount.");
                    }
                }
                final EntityPlayer entityPlayer = player;
                final EntityPlayer entityPlayer2 = player;
                final double n = 0.0;
                ((Entity)entityPlayer2).motZ = n;
                ((Entity)entityPlayer).motX = n;
                ((Entity)player).motY = motionY;
                if (this.cloudPara && EntityCloudParachute.entityHasRoomForCloud(game.theWorld, (EntityLiving)player)) {
                    for (int i = 0; i < 32; ++i) {
                        EntityCloudParachute.doCloudSmoke(game.theWorld, (EntityLiving)player);
                    }
                    game.theWorld.playSoundAtEntity((Entity)player, "cloud", 1.0f, 1.0f / (game.theWorld.rand.nextFloat() * 0.1f + 0.95f));
                    if (!game.theWorld.isStatic) {
                        game.theWorld.spawnEntityInWorld((Entity)new EntityCloudParachute(game.theWorld, (EntityLiving)player, false));
                    }
                }
                if (game.gameSettings.difficulty == 0) {
                    ((Entity)player).fallDistance = -64.0f;
                }
                if (!this.cloudPara) {
                    if (player.inventory.c(AetherItems.CloudParachute.id)) {
                        if (EntityCloudParachute.entityHasRoomForCloud(game.theWorld, (EntityLiving)player)) {
                            for (int i = 0; i < 32; ++i) {
                                EntityCloudParachute.doCloudSmoke(game.theWorld, (EntityLiving)player);
                            }
                            game.theWorld.playSoundAtEntity((Entity)player, "cloud", 1.0f, 1.0f / (game.theWorld.rand.nextFloat() * 0.1f + 0.95f));
                            if (!game.theWorld.isStatic) {
                                game.theWorld.spawnEntityInWorld((Entity)new EntityCloudParachute(game.theWorld, (EntityLiving)player, false));
                            }
                        }
                    }
                    else {
                        for (int i = 0; i < player.inventory.getSize(); ++i) {
                            final ItemStack itemstack = player.inventory.getItem(i);
                            if (itemstack != null && itemstack.id == AetherItems.CloudParachuteGold.id && EntityCloudParachute.entityHasRoomForCloud(game.theWorld, (EntityLiving)player)) {
                                EntityCloudParachute.doCloudSmoke(game.theWorld, (EntityLiving)player);
                                game.theWorld.playSoundAtEntity((Entity)player, "cloud", 1.0f, 1.0f / (game.theWorld.rand.nextFloat() * 0.1f + 0.95f));
                                if (!game.theWorld.isStatic) {
                                    game.theWorld.spawnEntityInWorld((Entity)new EntityCloudParachute(game.theWorld, (EntityLiving)player, true));
                                }
                                itemstack.damage(1, (EntityLiving)player);
                                player.inventory.setItem(i, itemstack);
                            }
                        }
                    }
                }
            }
            if (getCurrentDimension() == 3) {
                final boolean enteredAether = ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(AetherAchievements.enterAether);
                if (!enteredAether) {
                    giveAchievement(AetherAchievements.enterAether, player);
                    player.inventory.pickup(new ItemStack(AetherItems.LoreBook, 1, 2));
                    player.inventory.pickup(new ItemStack(AetherItems.CloudParachuteGold, 1));
                    game.theWorld.playSoundAtEntity((Entity)player, "random.pop", 0.2f, 1.0f);
                }
            }
        }
        if (mod_Aether.world != game.theWorld || (game.thePlayer != null && (((Entity)game.thePlayer).dead || ((EntityLiving)game.thePlayer).health <= 0))) {
            mod_Aether.world = game.theWorld;
            return true;
        }
        if (mod_Aether.world == null) {
            return true;
        }
        if (!mod_Aether.world.isStatic && game.currentScreen == null) {
            this.renderHearts();
            this.renderJumps();
        }
        if (!mod_Aether.world.isStatic && game.currentScreen instanceof GuiInventory) {
            game.displayGuiScreen((GuiScreen)new GuiInventoryMoreSlots((EntityPlayer)game.thePlayer));
        }
        this.repShieldUpdate(game);
        AetherPoison.tickRender(game);
        this.renderBossHP();
        final float f1 = getPlayer().prevTimeInPortal * 1.2f + (getPlayer().timeInPortal - getPlayer().prevTimeInPortal);
        if (f1 > 0.0f) {
            GL11.glEnable(3042);
            final ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
            final int width = scaledresolution.getScaledWidth();
            final int height = scaledresolution.getScaledHeight();
            this.renderPortalOverlay(f1, width, height);
            GL11.glDisable(3042);
        }
        final long time = game.theWorld.getWorldTime();
        if (mod_Aether.clock != time) {
            AetherItems.tick(game);
            ++this.updateCounter;
            mod_Aether.clock = time;
        }
        return true;
    }
    
    private void renderPortalOverlay(float f, final int i, final int j) {
        if (f < 1.0f) {
            f *= f;
            f *= f;
            f = f * 0.8f + 0.2f;
        }
        GL11.glDisable(3008);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        GL11.glBindTexture(3553, this.mc.renderEngine.getTexture("/aetherBlocks.png"));
        final float f2 = AetherBlocks.Portal.textureId % 16 / 16.0f;
        final float f3 = AetherBlocks.Portal.textureId / 16 / 16.0f;
        final float f4 = (AetherBlocks.Portal.textureId % 16 + 1) / 16.0f;
        final float f5 = (AetherBlocks.Portal.textureId / 16 + 1) / 16.0f;
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, (double)j, -90.0, (double)f2, (double)f5);
        tessellator.addVertexWithUV((double)i, (double)j, -90.0, (double)f4, (double)f5);
        tessellator.addVertexWithUV((double)i, 0.0, -90.0, (double)f4, (double)f3);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, (double)f2, (double)f3);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public static void giveAchievement(final Achievement a) {
        giveAchievement(a, (EntityPlayer)ModLoader.getMinecraftInstance().thePlayer);
    }
    
    public static void giveAchievement(final Achievement a, final EntityPlayer p) {
        if (ModLoader.getMinecraftInstance().statFileWriter.hasAchievementUnlocked(a)) {
            return;
        }
        ModLoader.getMinecraftInstance().sndManager.playSoundFX("aether.sound.other.achievement.achievementGen", 1.0f, 1.0f);
        p.a((Statistic)a);
    }
    
    public void repShieldUpdate(final Minecraft game) {
        final PlayerBaseAether pbase = getPlayer();
        if (pbase.inv.slots[6] == null || pbase.inv.slots[6].id != AetherItems.RepShield.id) {
            return;
        }
        if (game.gameSettings.thirdPersonView == 0) {
            return;
        }
        this.renderShieldEffect(game);
    }
    
    private void renderShieldEffect(final Minecraft game) {
        final ScaledResolution scaledresolution = new ScaledResolution(game.gameSettings, game.displayWidth, game.displayHeight);
        final int i = scaledresolution.getScaledWidth();
        final int j = scaledresolution.getScaledHeight();
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBindTexture(3553, game.renderEngine.getTexture("/aether/other/shieldEffect.png"));
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0, (double)j, -90.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)i, (double)j, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)i, 0.0, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, -90.0, 0.0, 0.0);
        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glDisable(2977);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private String randomText() {
        final int i = this.rand.nextInt(19);
        switch (i) {
            case 0: {
                return "Taming Moas";
            }
            case 1: {
                return "Hiding Chests";
            }
            case 2: {
                return "Defying Gravity";
            }
            case 3: {
                return "Enchanting Darts";
            }
            case 4: {
                return "Sssssssss.....";
            }
            case 5: {
                return "Growing Skyroot";
            }
            case 6: {
                return "Writing Lore";
            }
            case 7: {
                return "Puffing Sheepuffs";
            }
            case 8: {
                return "Making Portals";
            }
            case 9: {
                return "Locking Chests";
            }
            case 10: {
                return "Making Pigs Fly";
            }
            case 11: {
                return "Growing Grass";
            }
            case 12: {
                return "Freezing Icestone";
            }
            case 13: {
                return "Building Temples";
            }
            case 14: {
                return "Planting Golden Oaks";
            }
            case 15: {
                return "Angering Zephyrs";
            }
            case 16: {
                return "Mimicing Chests";
            }
            case 17: {
                return "Poisoning Plants";
            }
            case 18: {
                return "Writing Music";
            }
            default: {
                return "Loading Aether Mod";
            }
        }
    }
    
    private void renderHearts() {
        final Minecraft mc = ModLoader.getMinecraftInstance();
        final ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        final int width = scaledresolution.getScaledWidth();
        final int height = scaledresolution.getScaledHeight();
        GL11.glBindTexture(3553, mc.renderEngine.getTexture("aether/gui/aethericons.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(775, 769);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        boolean flag1 = ((Entity)mc.thePlayer).heartsLife / 3 % 2 == 1;
        if (((Entity)mc.thePlayer).heartsLife < 10) {
            flag1 = false;
        }
        final int halfHearts = ((EntityLiving)mc.thePlayer).health - 20;
        final int prevHalfHearts = ((EntityLiving)mc.thePlayer).prevHealth - 20;
        this.rand.setSeed(this.updateCounter * 312871);
        if (mc.playerController.shouldDrawHUD()) {
            for (int heart = 0; heart < getPlayer((EntityPlayer)mc.thePlayer).maxHealth / 2 - 10; ++heart) {
                int yPos = height - 50;
                if (mc.thePlayer.getTotalArmorValue() > 0) {
                    yPos -= 8;
                }
                int k5 = 0;
                if (flag1) {
                    k5 = 1;
                }
                final int xPos = width / 2 - 91 + heart * 8;
                if (((EntityLiving)mc.thePlayer).health <= 4) {
                    yPos += this.rand.nextInt(2);
                }
                this.drawTexturedModalRect(xPos, yPos, 16 + k5 * 9, 0, 9, 9);
                if (flag1) {
                    if (heart * 2 + 1 < prevHalfHearts) {
                        this.drawTexturedModalRect(xPos, yPos, 70, 0, 9, 9);
                    }
                    if (heart * 2 + 1 == prevHalfHearts) {
                        this.drawTexturedModalRect(xPos, yPos, 79, 0, 9, 9);
                    }
                }
                if (heart * 2 + 1 < halfHearts) {
                    this.drawTexturedModalRect(xPos, yPos, 52, 0, 9, 9);
                }
                if (heart * 2 + 1 == halfHearts) {
                    this.drawTexturedModalRect(xPos, yPos, 61, 0, 9, 9);
                }
            }
        }
        GL11.glDisable(3042);
    }
    
    private void renderJumps() {
        final Minecraft mc = ModLoader.getMinecraftInstance();
        if (!(((Entity)mc.thePlayer).vehicle instanceof EntityMoa)) {
            return;
        }
        if (mc.playerController.shouldDrawHUD() && mc.inGameHasFocus) {
            final ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
            final EntityMoa moa = (EntityMoa)((Entity)mc.thePlayer).vehicle;
            final int width = scaledresolution.getScaledWidth();
            final int height = scaledresolution.getScaledHeight();
            GL11.glBindTexture(3553, mc.renderEngine.getTexture("/aether/gui/jumps.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            for (int jump = 0; jump < moa.colour.jumps; ++jump) {
                final int yPos = height - 44;
                final int xPos = width / 2 + 1 + 9 * (jump + 1);
                if (jump < moa.jrem) {
                    this.drawTexturedModalRect(xPos, yPos, 0, 0, 9, 11);
                }
                else {
                    this.drawTexturedModalRect(xPos, yPos, 10, 0, 9, 11);
                }
            }
        }
        GL11.glDisable(3042);
    }
    
    private void renderBossHP() {
        if (mod_Aether.currentBoss != null) {
            final Minecraft mc = ModLoader.getMinecraftInstance();
            final ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
            final int width = scaledresolution.getScaledWidth();
            final int height = scaledresolution.getScaledHeight();
            final String s = mod_Aether.currentBoss.getBossTitle();
            mc.fontRenderer.drawStringWithShadow(s, width / 2 - mc.fontRenderer.getStringWidth(s) / 2, 2, -1);
            GL11.glBindTexture(3553, mc.renderEngine.getTexture("/aether/gui/bossHPBar.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(775, 769);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            this.drawTexturedModalRect(width / 2 - 128, 12, 0, 16, 256, 32);
            final int w = (int)(mod_Aether.currentBoss.getBossHP() / (float)mod_Aether.currentBoss.getBossMaxHP() * 256.0f);
            this.drawTexturedModalRect(width / 2 - 128, 12, 0, 0, w, 16);
        }
    }
    
    public void drawTexturedModalRect(final int par1, final int par2, final int par3, final int par4, final int par5, final int par6) {
        final float var7 = 0.00390625f;
        final float var8 = 0.00390625f;
        final Tessellator var9 = Tessellator.instance;
        var9.startDrawingQuads();
        var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + par6) * var8));
        var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + par6) * var8));
        var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + par5) * var7), (double)((par4 + 0) * var8));
        var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((par3 + 0) * var7), (double)((par4 + 0) * var8));
        var9.draw();
    }
    
    public void addRenderer(final Map map) {
        AetherBlocks.AddRenderer(map);
        AetherItems.AddRenderer(map);
        AetherMobs.AddRenderer(map);
        AetherPoison.AddRenderer(map);
        map.put(EntityPlayer.class, new RenderPlayerAether());
    }
    
    public void takenFromCrafting(final EntityPlayer player, final ItemStack item, final IInventory inventory) {
        AetherItems.takenCrafting(player, item);
    }
    
    public static boolean equippedSkyrootSword() {
        final ItemStack itemstack = ((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer).inventory.getItemInHand();
        return itemstack != null && itemstack.id == AetherItems.SwordSkyroot.id;
    }
    
    public static boolean equippedSkyrootPick() {
        final ItemStack itemstack = ((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer).inventory.getItemInHand();
        return itemstack != null && itemstack.id == AetherItems.PickSkyroot.id;
    }
    
    public static boolean equippedSkyrootShovel() {
        final ItemStack itemstack = ((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer).inventory.getItemInHand();
        return itemstack != null && itemstack.id == AetherItems.ShovelSkyroot.id;
    }
    
    public static boolean equippedSkyrootAxe() {
        final ItemStack itemstack = ((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer).inventory.getItemInHand();
        return itemstack != null && itemstack.id == AetherItems.AxeSkyroot.id;
    }
    
    public static int getCurrentDimension() {
        final EntityPlayer player = (EntityPlayer)ModLoader.getMinecraftInstance().thePlayer;
        if (player == null) {
            return 0;
        }
        return player.dimension;
    }
    
    public String getVersion() {
        return "MC 1.2.5 Version 1.9";
    }
    
    public static PlayerBaseAether getPlayer() {
        return getPlayer((EntityPlayer)ModLoader.getMinecraftInstance().thePlayer);
    }
    
    public static PlayerBaseAether getPlayer(final EntityPlayer player) {
        if (player instanceof EntityPlayerSP) {
            return (PlayerBaseAether)((EntityPlayerSP)player).playerAPI.getPlayerBase("Aether");
        }
        return null;
    }
    
    public void onSetupAudio(final SoundManager soundManager) {
    }
    
    public void onLoadSoundSettings(final SoundManager soundManager) {
    }
    
    public SoundPoolEntry onPlayBackgroundMusic(final SoundManager soundManager, final SoundPoolEntry entry) {
        if (getCurrentDimension() == 3) {
            return soundManager.getMusicPool().getRandomSoundFromSoundPool("aether");
        }
        return entry;
    }
    
    public SoundPoolEntry onPlayStreaming(final SoundManager soundManager, final SoundPoolEntry entry, final String soundName, final float x, final float y, final float z) {
        return entry;
    }
    
    public SoundPoolEntry onPlaySound(final SoundManager soundManager, final SoundPoolEntry entry, final String soundName, final float x, final float y, final float z, final float volume, final float pitch) {
        return entry;
    }
    
    public SoundPoolEntry onPlaySoundEffect(final SoundManager soundManager, final SoundPoolEntry entry, final String soundName, final float volume, final float pitch) {
        return entry;
    }
    
    public String onPlaySoundAtEntity(final Entity entity, final String soundName, final float volume, final float pitch) {
        return soundName;
    }
    
    static {
        mod_Aether.raritySwet = 8;
        mod_Aether.rarityAechorPlant = 8;
        mod_Aether.rarityCockatrice = 3;
        mod_Aether.rarityAerwhale = 8;
        mod_Aether.rarityZephyr = 5;
        mod_Aether.raritySheepuff = 10;
        mod_Aether.rarityPhyg = 12;
        mod_Aether.rarityMoa = 10;
        mod_Aether.rarityFlyingCow = 10;
        mod_Aether.rarityWhirlwind = 8;
        mod_Aether.rarityAerbunny = 11;
        mod_Aether.worldMenu = true;
        mod_Aether.aetherMenu = true;
        mod_Aether.TMIhidden = true;
        mod_Aether.christmasContent = false;
        mod_Aether.idBlockAetherPortal = 165;
        mod_Aether.idBlockAetherDirt = 166;
        mod_Aether.idBlockAetherGrass = 167;
        mod_Aether.idBlockQuicksoil = 168;
        mod_Aether.idBlockHolystone = 169;
        mod_Aether.idBlockIcestone = 170;
        mod_Aether.idBlockAercloud = 171;
        mod_Aether.idBlockAerogel = 172;
        mod_Aether.idBlockEnchanter = 173;
        mod_Aether.idBlockIncubator = 174;
        mod_Aether.idBlockLog = 175;
        mod_Aether.idBlockPlank = 176;
        mod_Aether.idBlockSkyrootLeaves = 177;
        mod_Aether.idBlockGoldenOakLeaves = 178;
        mod_Aether.idBlockSkyrootSapling = 179;
        mod_Aether.idBlockGoldenOakSapling = 180;
        mod_Aether.idBlockAmbrosiumOre = 181;
        mod_Aether.idBlockAmbrosiumTorch = 182;
        mod_Aether.idBlockZaniteOre = 183;
        mod_Aether.idBlockGravititeOre = 184;
        mod_Aether.idBlockEnchantedGravitite = 185;
        mod_Aether.idBlockTrap = 186;
        mod_Aether.idBlockChestMimic = 187;
        mod_Aether.idBlockTreasureChest = 188;
        mod_Aether.idBlockDungeonStone = 189;
        mod_Aether.idBlockLightDungeonStone = 190;
        mod_Aether.idBlockLockedDungeonStone = 191;
        mod_Aether.idBlockLockedLightDungeonStone = 192;
        mod_Aether.idBlockPillar = 193;
        mod_Aether.idBlockZanite = 194;
        mod_Aether.idBlockQuicksoilGlass = 195;
        mod_Aether.idBlockFreezer = 196;
        mod_Aether.idBlockWhiteFlower = 197;
        mod_Aether.idBlockPurpleFlower = 198;
        mod_Aether.idBlockAetherBed = 199;
        mod_Aether.idBlockChristmasLeaves = 200;
        mod_Aether.idBlockPresent = 201;
        mod_Aether.idBerryBush = 202;
        mod_Aether.idBushStem = 203;
        mod_Aether.idBlockBlueLeaves = 204;
        mod_Aether.idBlockHolystoneStairs = 205;
        mod_Aether.idBlockMossyHolystoneStairs = 206;
        mod_Aether.idBlockIcestoneStairs = 207;
        mod_Aether.idBlockPlankStairs = 208;
        mod_Aether.idBlockCarvedStairs = 209;
        mod_Aether.idBlockAngelicStairs = 210;
        mod_Aether.idBlockHellfireStairs = 211;
        mod_Aether.idBlockHolystoneFence = 212;
        mod_Aether.idBlockMossyHolystoneFence = 213;
        mod_Aether.idBlockIcestoneFence = 214;
        mod_Aether.idBlockPlankFence = 215;
        mod_Aether.idBlockCarvedFence = 216;
        mod_Aether.idBlockAngelicFence = 217;
        mod_Aether.idBlockHellfireFence = 218;
        mod_Aether.idSunAltar = 219;
        mod_Aether.idItemVictoryMedal = 17000;
        mod_Aether.idItemKey = 17001;
        mod_Aether.idItemLoreBook = 17002;
        mod_Aether.idItemMoaEgg = 17003;
        mod_Aether.idItemBlueMusicDisk = 17004;
        mod_Aether.idItemGoldenAmber = 17005;
        mod_Aether.idItemAechorPetal = 17006;
        mod_Aether.idItemStick = 17007;
        mod_Aether.idItemDart = 17008;
        mod_Aether.idItemDartShooter = 17009;
        mod_Aether.idItemAmbrosiumShard = 17010;
        mod_Aether.idItemZanite = 17011;
        mod_Aether.idItemBucket = 17012;
        mod_Aether.idItemPickSkyroot = 17013;
        mod_Aether.idItemPickHolystone = 17014;
        mod_Aether.idItemPickZanite = 17015;
        mod_Aether.idItemPickGravitite = 17016;
        mod_Aether.idItemShovelSkyroot = 17017;
        mod_Aether.idItemShovelHolystone = 17018;
        mod_Aether.idItemShovelZanite = 17019;
        mod_Aether.idItemShovelGravitite = 17020;
        mod_Aether.idItemAxeSkyroot = 17021;
        mod_Aether.idItemAxeHolystone = 17022;
        mod_Aether.idItemAxeZanite = 17023;
        mod_Aether.idItemAxeGravitite = 17024;
        mod_Aether.idItemSwordSkyroot = 17025;
        mod_Aether.idItemSwordHolystone = 17026;
        mod_Aether.idItemSwordZanite = 17027;
        mod_Aether.idItemSwordGravitite = 17028;
        mod_Aether.idItemIronBubble = 17029;
        mod_Aether.idItemPigSlayer = 17030;
        mod_Aether.idItemVampireBlade = 17031;
        mod_Aether.idItemNatureStaff = 17032;
        mod_Aether.idItemSwordFire = 17033;
        mod_Aether.idItemSwordHoly = 17034;
        mod_Aether.idItemSwordLightning = 17035;
        mod_Aether.idItemLightningKnife = 17036;
        mod_Aether.idItemGummieSwet = 17037;
        mod_Aether.idItemHammerNotch = 17038;
        mod_Aether.idItemPhoenixBow = 17039;
        mod_Aether.idItemCloudParachute = 17040;
        mod_Aether.idItemCloudParachuteGold = 17041;
        mod_Aether.idItemCloudStaff = 17042;
        mod_Aether.idItemLifeShard = 17043;
        mod_Aether.idItemGoldenFeather = 17044;
        mod_Aether.idItemLance = 17045;
        mod_Aether.idItemIronRing = 17046;
        mod_Aether.idItemGoldRing = 17047;
        mod_Aether.idItemZaniteRing = 17048;
        mod_Aether.idItemIronPendant = 17049;
        mod_Aether.idItemGoldPendant = 17050;
        mod_Aether.idItemZanitePendant = 17051;
        mod_Aether.idItemRepShield = 17052;
        mod_Aether.idItemAetherCape = 17053;
        mod_Aether.idItemLeatherGlove = 17054;
        mod_Aether.idItemIronGlove = 17055;
        mod_Aether.idItemGoldGlove = 17056;
        mod_Aether.idItemDiamondGlove = 17057;
        mod_Aether.idItemZaniteGlove = 17058;
        mod_Aether.idItemZaniteHelmet = 17059;
        mod_Aether.idItemZaniteChestplate = 17060;
        mod_Aether.idItemZaniteLeggings = 17061;
        mod_Aether.idItemZaniteBoots = 17062;
        mod_Aether.idItemGravititeGlove = 17063;
        mod_Aether.idItemGravititeHelmet = 17064;
        mod_Aether.idItemGravititeBodyplate = 17065;
        mod_Aether.idItemGravititePlatelegs = 17066;
        mod_Aether.idItemGravititeBoots = 17067;
        mod_Aether.idItemPhoenixGlove = 17068;
        mod_Aether.idItemPhoenixHelm = 17069;
        mod_Aether.idItemPhoenixBody = 17070;
        mod_Aether.idItemPhoenixLegs = 17071;
        mod_Aether.idItemPhoenixBoots = 17072;
        mod_Aether.idItemObsidianGlove = 17073;
        mod_Aether.idItemObsidianBody = 17074;
        mod_Aether.idItemObsidianHelm = 17075;
        mod_Aether.idItemObsidianLegs = 17076;
        mod_Aether.idItemObsidianBoots = 17077;
        mod_Aether.idItemNeptuneGlove = 17078;
        mod_Aether.idItemNeptuneHelmet = 17079;
        mod_Aether.idItemNeptuneChestplate = 17080;
        mod_Aether.idItemNeptuneLeggings = 17081;
        mod_Aether.idItemNeptuneBoots = 17082;
        mod_Aether.idItemRegenerationStone = 17083;
        mod_Aether.idItemInvisibilityCloak = 17084;
        mod_Aether.idItemAgilityCape = 17085;
        mod_Aether.idItemWhiteCape = 17086;
        mod_Aether.idItemRedCape = 17087;
        mod_Aether.idItemYellowCape = 17088;
        mod_Aether.idItemBlueCape = 17089;
        mod_Aether.idItemPickValkyrie = 17090;
        mod_Aether.idItemAxeValkyrie = 17091;
        mod_Aether.idItemShovelValkyrie = 17092;
        mod_Aether.idItemHealingStone = 17093;
        mod_Aether.idItemIceRing = 17094;
        mod_Aether.idItemIcePendant = 17095;
        mod_Aether.idBlueBerry = 17096;
        mod_Aether.idGingerBreadMan = 17097;
        mod_Aether.idCandyCane = 17098;
        mod_Aether.idCandySword = 17099;
        mod_Aether.idWhiteBerry = 17100;
        mod_Aether.idSwetBall = 17101;
        mod_Aether.idItemSentryBoots = 17102;
        mod_Aether.hasLoreOverworld = false;
        mod_Aether.hasLoreNether = false;
        mod_Aether.hasLoreAether = false;
        mod_Aether.currentBoss = null;
        mod_Aether.biomeAether = new BiomeGenAether();
        mod_Aether.dim = new WorldProviderAether();
    }
}
