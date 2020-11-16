package net.minecraft.server;

import java.util.*;

public class EntityFireMonster extends EntityFlying implements IAetherBoss
{
    public int wideness;
    public int orgX;
    public int orgY;
    public int orgZ;
    public int motionTimer;
    public int entCount;
    public int flameCount;
    public int ballCount;
    public int chatLog;
    public int chatCount;
    public int hurtness;
    public int direction;
    public double rotary;
    public double speedness;
    public Entity target;
    public boolean gotTarget;
    public String bossName;
    public static final float jimz = 57.295773f;
    
    public EntityFireMonster(final World world) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firemonster.png";
        this.b(2.25f, 2.5f);
        ((Entity)this).bQ = true;
        this.orgX = MathHelper.floor(((Entity)this).locX);
        this.orgY = MathHelper.floor(((Entity)this).boundingBox.b) + 1;
        this.orgZ = MathHelper.floor(((Entity)this).locZ);
        this.wideness = 10;
        ((EntityLiving)this).health = this.getMaxHealth();
        this.speedness = 0.5 - ((EntityLiving)this).health / 70.0 * 0.2;
        this.direction = 0;
        this.entCount = ((Entity)this).random.nextInt(6);
        this.bossName = NameGen.gen();
    }
    
    public int getMaxHealth() {
        return 50;
    }
    
    public EntityFireMonster(final World world, final int x, final int y, final int z, final int rad, final int dir) {
        super(world);
        ((EntityLiving)this).texture = "/aether/mobs/firemonster.png";
        this.b(2.25f, 2.5f);
        this.setPosition(x + 0.5, (double)y, z + 0.5);
        this.wideness = rad - 2;
        this.orgX = x;
        this.orgY = y;
        this.orgZ = z;
        ((Entity)this).bQ = true;
        this.rotary = ((Entity)this).random.nextFloat() * 360.0;
        ((EntityLiving)this).health = 50;
        this.speedness = 0.5 - ((EntityLiving)this).health / 70.0 * 0.2;
        this.direction = dir;
        this.entCount = ((Entity)this).random.nextInt(6);
        this.bossName = NameGen.gen();
    }
    
    public boolean canDespawn() {
        return false;
    }
    
    public void onUpdate() {
        super.F_();
        if (((EntityLiving)this).health > 0) {
            final double a = ((Entity)this).random.nextFloat() - 0.5f;
            final double b = ((Entity)this).random.nextFloat();
            final double c = ((Entity)this).random.nextFloat() - 0.5f;
            final double d = ((Entity)this).locX + a * b;
            final double e = ((Entity)this).boundingBox.b + b - 0.5;
            final double f = ((Entity)this).locZ + c * b;
            ((Entity)this).world.a("flame", d, e, f, 0.0, -0.07500000298023224, 0.0);
            ++this.entCount;
            if (this.entCount >= 3) {
                this.burnEntities();
                this.evapWater();
                this.entCount = 0;
            }
            if (this.hurtness > 0) {
                --this.hurtness;
                if (this.hurtness == 0) {
                    ((EntityLiving)this).texture = "/aether/mobs/firemonster.png";
                }
            }
        }
        if (this.chatCount > 0) {
            --this.chatCount;
        }
    }
    
    protected Entity findPlayerToAttack() {
        final EntityHuman entityplayer = ((Entity)this).world.findNearbyPlayer((Entity)this, 32.0);
        if (entityplayer != null && this.h((Entity)entityplayer)) {
            return (Entity)entityplayer;
        }
        return null;
    }
    
    public void updateEntityActionState() {
        super.d_();
        if (this.gotTarget && this.target == null) {
            this.target = this.findPlayerToAttack();
            this.gotTarget = false;
        }
        if (this.target == null) {
            this.setPosition(this.orgX + 0.5, (double)this.orgY, this.orgZ + 0.5);
            this.setDoor(0);
            return;
        }
        ((EntityLiving)this).V = ((Entity)this).yaw;
        this.setPosition(((Entity)this).locX, (double)this.orgY, ((Entity)this).locZ);
        ((Entity)this).motY = 0.0;
        boolean pool = false;
        if (((Entity)this).motX > 0.0 && (int)Math.floor(((Entity)this).locX) > this.orgX + this.wideness) {
            this.rotary = 360.0 - this.rotary;
            pool = true;
        }
        else if (((Entity)this).motX < 0.0 && (int)Math.floor(((Entity)this).locX) < this.orgX - this.wideness) {
            this.rotary = 360.0 - this.rotary;
            pool = true;
        }
        if (((Entity)this).motZ > 0.0 && (int)Math.floor(((Entity)this).locZ) > this.orgZ + this.wideness) {
            this.rotary = 180.0 - this.rotary;
            pool = true;
        }
        else if (((Entity)this).motZ < 0.0 && (int)Math.floor(((Entity)this).locZ) < this.orgZ - this.wideness) {
            this.rotary = 180.0 - this.rotary;
            pool = true;
        }
        if (this.rotary > 360.0) {
            this.rotary -= 360.0;
        }
        else if (this.rotary < 0.0) {
            this.rotary += 360.0;
        }
        if (this.target != null) {
            this.a(this.target, 20.0f, 20.0f);
        }
        final double crazy = this.rotary / 57.295772552490234;
        ((Entity)this).motX = Math.sin(crazy) * this.speedness;
        ((Entity)this).motZ = Math.cos(crazy) * this.speedness;
        ++this.motionTimer;
        if (this.motionTimer >= 20 || pool) {
            this.motionTimer = 0;
            if (((Entity)this).random.nextInt(3) == 0) {
                this.rotary += (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 60.0;
            }
        }
        ++this.flameCount;
        if (this.flameCount == 40 && ((Entity)this).random.nextInt(2) == 0) {
            this.poopFire();
        }
        else if (this.flameCount >= 55 + ((EntityLiving)this).health / 2 && this.target != null && this.target instanceof EntityLiving) {
            this.makeFireBall(1);
            this.flameCount = 0;
        }
        if (this.target != null && this.target.dead) {
            this.setPosition(this.orgX + 0.5, (double)this.orgY, this.orgZ + 0.5);
            ((Entity)this).motX = 0.0;
            ((Entity)this).motY = 0.0;
            ((Entity)this).motZ = 0.0;
            this.target = null;
            this.chatLine("§cSuch is the fate of a being who opposes the might of the sun.");
            this.setDoor(0);
            mod_Aether.currentBoss = null;
            this.gotTarget = false;
        }
    }
    
    public void burnEntities() {
        final List list = ((Entity)this).world.getEntities((Entity)this, ((Entity)this).boundingBox.grow(0.0, 4.0, 0.0));
        for (int j = 0; j < list.size(); ++j) {
            final Entity entity1 = (Entity) list.get(j);
            if (entity1 instanceof EntityLiving && !entity1.fireProof) {
                entity1.damageEntity(DamageSource.mobAttack((EntityLiving)this), 10);
                entity1.setOnFire(300);
            }
        }
    }
    
    public void evapWater() {
        final int x = MathHelper.floor(((Entity)this).locX);
        final int z = MathHelper.floor(((Entity)this).locZ);
        for (int i = 0; i < 8; ++i) {
            final int b = this.orgY - 2 + i;
            if (((Entity)this).world.getMaterial(x, b, z) == Material.WATER) {
                ((Entity)this).world.setTypeId(x, b, z, 0);
                ((Entity)this).world.makeSound((double)(x + 0.5f), (double)(b + 0.5f), (double)(z + 0.5f), "random.fizz", 0.5f, 2.6f + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.8f);
                for (int l = 0; l < 8; ++l) {
                    ((Entity)this).world.a("largesmoke", x + Math.random(), b + 0.75, z + Math.random(), 0.0, 0.0, 0.0);
                }
            }
        }
    }
    
    public void makeFireBall(final int shots) {
        ((Entity)this).world.makeSound((Entity)this, "mob.ghast.fireball", 5.0f, (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.2f + 1.0f);
        boolean flag = false;
        ++this.ballCount;
        if (this.ballCount >= 3 + ((Entity)this).random.nextInt(3)) {
            flag = true;
            this.ballCount = 0;
        }
        for (int i = 0; i < shots; ++i) {
            final EntityFiroBall e1 = new EntityFiroBall(((Entity)this).world, ((Entity)this).locX - ((Entity)this).motX / 2.0, ((Entity)this).locY, ((Entity)this).locZ - ((Entity)this).motZ / 2.0, flag);
            ((Entity)this).world.addEntity((Entity)e1);
        }
    }
    
    public void poopFire() {
        final int x = MathHelper.floor(((Entity)this).locX);
        final int z = MathHelper.floor(((Entity)this).locZ);
        final int b = this.orgY - 2;
        if (AetherBlocks.isGood(((Entity)this).world.getTypeId(x, b, z), ((Entity)this).world.getData(x, b, z))) {
            ((Entity)this).world.setTypeId(x, b, z, ((Block)Block.FIRE).id);
        }
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setShort("OriginX", (short)this.orgX);
        nbttagcompound.setShort("OriginY", (short)this.orgY);
        nbttagcompound.setShort("OriginZ", (short)this.orgZ);
        nbttagcompound.setShort("Wideness", (short)this.wideness);
        nbttagcompound.setShort("FlameCount", (short)this.flameCount);
        nbttagcompound.setShort("BallCount", (short)this.ballCount);
        nbttagcompound.setShort("ChatLog", (short)this.chatLog);
        nbttagcompound.setShort("Direction", (short)this.direction);
        nbttagcompound.setFloat("Rotary", (float)this.rotary);
        nbttagcompound.setBoolean("GotTarget", this.gotTarget = (this.target != null));
        nbttagcompound.setBoolean("IsCurrentBoss", this.isCurrentBoss());
        nbttagcompound.setString("BossName", this.bossName);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.orgX = nbttagcompound.getShort("OriginX");
        this.orgY = nbttagcompound.getShort("OriginY");
        this.orgZ = nbttagcompound.getShort("OriginZ");
        this.wideness = nbttagcompound.getShort("Wideness");
        this.flameCount = nbttagcompound.getShort("FlameCount");
        this.ballCount = nbttagcompound.getShort("BallCount");
        this.chatLog = nbttagcompound.getShort("ChatLog");
        this.direction = nbttagcompound.getShort("Direction");
        this.rotary = nbttagcompound.getFloat("Rotary");
        this.gotTarget = nbttagcompound.getBoolean("GotTarget");
        this.speedness = 0.5 - ((EntityLiving)this).health / 70.0 * 0.2;
        if (nbttagcompound.getBoolean("IsCurrentBoss")) {
            mod_Aether.currentBoss = this;
        }
        this.bossName = nbttagcompound.getString("BossName");
    }
    
    public void chatLine(final String s) {
        //ModLoader.getMinecraftInstance().ingameGUI.addChatMessage(s);
    }
    
    public boolean chatWithMe() {
        if (this.chatCount <= 0) {
            if (this.chatLog == 0) {
                this.chatLine("§cYou are certainly a brave soul to have entered this chamber.");
                this.chatLog = 1;
                this.chatCount = 100;
            }
            else if (this.chatLog == 1) {
                this.chatLine("§cBegone human, you serve no purpose here.");
                this.chatLog = 2;
                this.chatCount = 100;
            }
            else if (this.chatLog == 2) {
                this.chatLine("§cYour presence annoys me. Do you not fear my burning aura?");
                this.chatLog = 3;
                this.chatCount = 100;
            }
            else if (this.chatLog == 3) {
                this.chatLine("§cI have nothing to offer you, fool. Leave me at peace.");
                this.chatLog = 4;
                this.chatCount = 100;
            }
            else if (this.chatLog == 4) {
                this.chatLine("§cPerhaps you are ignorant. Do you wish to know who I am?");
                this.chatLog = 5;
                this.chatCount = 100;
            }
            else if (this.chatLog == 5) {
                this.chatLine("§cI am a sun spirit, embodiment of Aether's eternal daylight.");
                this.chatLine("§cAs long as I am alive, the sun will never set on this world.");
                this.chatLog = 6;
                this.chatCount = 100;
            }
            else if (this.chatLog == 6) {
                this.chatLine("§cMy body burns with the anger of a thousand beasts.");
                this.chatLine("§cNo man, hero, or villain can harm me. You are no exception.");
                this.chatLog = 7;
                this.chatCount = 100;
            }
            else if (this.chatLog == 7) {
                this.chatLine("§cYou wish to challenge the might of the sun? You are mad.");
                this.chatLine("§cDo not further insult me or you will feel my wrath.");
                this.chatLog = 8;
                this.chatCount = 100;
            }
            else if (this.chatLog == 8) {
                this.chatLine("§cThis is your final warning. Leave now, or prepare to burn.");
                this.chatLog = 9;
                this.chatCount = 100;
            }
            else {
                if (this.chatLog == 9) {
                    this.chatLine("§6As you wish, your death will be slow and agonizing.");
                    this.chatLog = 10;
                    mod_Aether.currentBoss = this;
                    return true;
                }
                if (this.chatLog == 10 && this.target == null) {
                    this.chatLine("§cDid your previous death not satisfy your curiosity, human?");
                    this.chatLog = 9;
                    this.chatCount = 100;
                }
            }
        }
        return false;
    }
    
    public boolean interact(final EntityPlayer ep) {
        if (this.chatWithMe()) {
            this.rotary = 57.295772552490234 * Math.atan2(((Entity)this).locX - ((Entity)ep).locX, ((Entity)this).locZ - ((Entity)ep).locZ);
            this.target = (Entity)ep;
            this.setDoor(AetherBlocks.LockedDungeonStone.id);
            return true;
        }
        return false;
    }
    
    public void addVelocity(final double d, final double d1, final double d2) {
    }
    
    public void knockBack(final Entity entity, final int i, final double d, final double d1) {
    }
    
    public boolean attackEntityFrom(final DamageSource ds, final int i) {
        if (ds.getEntity() == null || !(ds.getEntity() instanceof EntityFiroBall)) {
            return false;
        }
        this.speedness = 0.5 - ((EntityLiving)this).health / 70.0 * 0.2;
        final boolean flag = super.damageEntity(ds, i);
        if (flag) {
            this.hurtness = 15;
            ((EntityLiving)this).texture = "/aether/mobs/firemonsterHurt.png";
            final EntityFireMinion minion = new EntityFireMinion(((Entity)this).world);
            minion.setPositionRotation(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, ((Entity)this).yaw, 0.0f);
            ((Entity)this).world.addEntity((Entity)minion);
            ((Entity)this).world.addEntity((Entity)minion);
            ((Entity)this).world.addEntity((Entity)minion);
            if (((EntityLiving)this).health <= 0) {
                mod_Aether.currentBoss = null;
                this.chatLine("§bSuch bitter cold... is this the feeling... of pain?");
                this.setDoor(0);
                this.unlockTreasure();
            }
        }
        return flag;
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        this.a(new ItemStack(AetherItems.Key, 1, 2), 0.0f);
        this.a(new ItemStack(AetherBlocks.SunAltar, 1, 0), 0.0f);
    }
    
    private void setDoor(final int ID) {
        if (this.direction / 2 == 0) {
            for (int y = this.orgY - 1; y < this.orgY + 2; ++y) {
                for (int z = this.orgZ - 1; z < this.orgZ + 2; ++z) {
                    ((Entity)this).world.setRawTypeIdAndData(this.orgX + ((this.direction == 0) ? -11 : 11), y, z, ID, 2);
                }
            }
        }
        else {
            for (int y = this.orgY - 1; y < this.orgY + 2; ++y) {
                for (int x = this.orgX - 1; x < this.orgX + 2; ++x) {
                    ((Entity)this).world.setRawTypeIdAndData(x, y, this.orgZ + ((this.direction == 3) ? 11 : -11), ID, 2);
                }
            }
        }
    }
    
    private void unlockTreasure() {
        if (this.direction / 2 == 0) {
            for (int y = this.orgY - 1; y < this.orgY + 2; ++y) {
                for (int z = this.orgZ - 1; z < this.orgZ + 2; ++z) {
                    ((Entity)this).world.setRawTypeId(this.orgX + ((this.direction == 0) ? 11 : -11), y, z, 0);
                }
            }
        }
        else {
            for (int y = this.orgY - 1; y < this.orgY + 2; ++y) {
                for (int x = this.orgX - 1; x < this.orgX + 2; ++x) {
                    ((Entity)this).world.setRawTypeId(x, y, this.orgZ + ((this.direction == 3) ? -11 : 11), 0);
                }
            }
        }
        /*
        mod_Aether.giveAchievement(AetherAchievements.defeatGold);
        for (int x2 = this.orgX - 20; x2 < this.orgX + 20; ++x2) {
            for (int y2 = this.orgY - 3; y2 < this.orgY + 6; ++y2) {
                for (int z2 = this.orgZ - 20; z2 < this.orgZ + 20; ++z2) {
                    final int id = ((Entity)this).world.getTypeId(x2, y2, z2);
                    if (id == AetherBlocks.LockedDungeonStone.id) {
                        ((Entity)this).world.setRawTypeIdAndData(x2, y2, z2, AetherBlocks.DungeonStone.id, ((Entity)this).world.getData(x2, y2, z2));
                    }
                    if (id == AetherBlocks.LockedLightDungeonStone.id) {
                        ((Entity)this).world.setRawTypeIdAndData(x2, y2, z2, AetherBlocks.LightDungeonStone.id, ((Entity)this).world.getData(x2, y2, z2));
                    }
                }
            }
            */
        }
    
    
    public int getBossHP() {
        return ((EntityLiving)this).health;
    }
    
    public int getBossMaxHP() {
        return 50;
    }
    
    public boolean isCurrentBoss() {
        return mod_Aether.currentBoss != null && this.equals(mod_Aether.currentBoss);
    }
    
    public int getBossEntityID() {
        return ((Entity)this).id;
    }
    
    public String getBossTitle() {
        return this.bossName + ", the Sun Spirit";
    }
    
    public Entity GetEntity() {
        return (Entity)this;
    }
}
