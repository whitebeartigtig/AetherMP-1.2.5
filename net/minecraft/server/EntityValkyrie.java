package net.minecraft.server;

public class EntityValkyrie extends EntityDungeonMob implements IAetherBoss
{
    public boolean isSwinging;
    public boolean boss;
    public boolean duel;
    public boolean hasDungeon;
    public int teleTimer;
    public int angerLevel;
    public int timeLeft;
    public int chatTime;
    public int dungeonX;
    public int dungeonY;
    public int dungeonZ;
    public int dungeonEntranceZ;
    public double safeX;
    public double safeY;
    public double safeZ;
    public float sinage;
    public double lastMotionY;
    public String bossName;
    
    public EntityValkyrie(final World world) {
        super(world);
        this.b(0.8f, 1.6f);
        ((EntityLiving)this).texture = "/aether/mobs/valkyrie.png";
        this.teleTimer = ((Entity)this).random.nextInt(250);
        ((EntityLiving)this).health = 50;
        ((EntityLiving)this).bb = 0.5f;
        this.timeLeft = 1200;
        super.attackStrength = 7;
        this.safeX = ((Entity)this).locX;
        this.safeY = ((Entity)this).locY;
        this.safeZ = ((Entity)this).locZ;
    }
    
    public EntityValkyrie(final World world, final double x, final double y, final double z, final boolean flag) {
        super(world);
        this.b(0.8f, 1.6f);
        this.bossName = NameGen.gen();
        ((EntityLiving)this).texture = "/aether/mobs/valkyrie.png";
        if (flag) {
            ((EntityLiving)this).texture = "/aether/mobs/valkyrie2.png";
            ((EntityLiving)this).health = 500;
            this.boss = true;
        }
        else {
            ((EntityLiving)this).health = 50;
        }
        this.teleTimer = ((Entity)this).random.nextInt(250);
        ((EntityLiving)this).bb = 0.5f;
        this.timeLeft = 1200;
        super.attackStrength = 7;
        ((Entity)this).locX = x;
        this.safeX = x;
        ((Entity)this).locY = y;
        this.safeY = y;
        ((Entity)this).locZ = z;
        this.safeZ = z;
        this.hasDungeon = false;
    }
    
    public void fall(final float f) {
    }
    
    @Override
    public Entity GetEntity() {
        return (Entity)this;
    }
    
    public void onUpdate() {
        this.lastMotionY = ((Entity)this).motY;
        super.F_();
        if (!((Entity)this).onGround && super.target != null && this.lastMotionY >= 0.0 && ((Entity)this).motY < 0.0 && this.i(super.target) <= 16.0f && this.h(super.target)) {
            final double a = super.target.locX - ((Entity)this).locX;
            final double b = super.target.locZ - ((Entity)this).locZ;
            final double angle = Math.atan2(a, b);
            ((Entity)this).motX = Math.sin(angle) * 0.25;
            ((Entity)this).motZ = Math.cos(angle) * 0.25;
        }
        if (!((Entity)this).onGround && !this.t() && Math.abs(((Entity)this).motY - this.lastMotionY) > 0.07 && Math.abs(((Entity)this).motY - this.lastMotionY) < 0.09) {
            ((Entity)this).motY += 0.054999999701976776;
            if (((Entity)this).motY < -0.2750000059604645) {
                ((Entity)this).motY = -0.2750000059604645;
            }
        }
        ((EntityLiving)this).bb = ((super.target == null) ? 0.5f : 1.0f);
        if (((Entity)this).world.difficulty <= 0 && (super.target != null || this.angerLevel > 0)) {
            this.angerLevel = 0;
            super.target = null;
        }
        if (this.isSwinging) {
            ((EntityLiving)this).an += 0.15f;
            ((EntityLiving)this).ao += 0.15f;
            if (((EntityLiving)this).an > 1.0f || ((EntityLiving)this).ao > 1.0f) {
                this.isSwinging = false;
                ((EntityLiving)this).an = 0.0f;
                ((EntityLiving)this).ao = 0.0f;
            }
        }
        if (!((Entity)this).onGround) {
            this.sinage += 0.75f;
        }
        else {
            this.sinage += 0.15f;
        }
        if (this.sinage > 6.283186f) {
            this.sinage -= 6.283186f;
        }
        if (!this.otherDimension()) {
            --this.timeLeft;
            if (this.timeLeft <= 0) {
                ((Entity)this).dead = true;
                this.aC();
            }
        }
    }
    
    public boolean otherDimension() {
        return true;
    }
    
    public void teleport(double x, double y, double z, final int rad) {
        int a = ((Entity)this).random.nextInt(rad + 1);
        int b = ((Entity)this).random.nextInt(rad / 2);
        int c = rad - a;
        a *= ((Entity)this).random.nextInt(2) * 2 - 1;
        b *= ((Entity)this).random.nextInt(2) * 2 - 1;
        c *= ((Entity)this).random.nextInt(2) * 2 - 1;
        x += a;
        y += b;
        z += c;
        int newX = (int)Math.floor(x - 0.5);
        int newY = (int)Math.floor(y - 0.5);
        int newZ = (int)Math.floor(z - 0.5);
        boolean flag = false;
        for (int q = 0; q < 32 && !flag; ++q) {
            final int i = newX + (((Entity)this).random.nextInt(rad / 2) - ((Entity)this).random.nextInt(rad / 2));
            final int j = newY + (((Entity)this).random.nextInt(rad / 2) - ((Entity)this).random.nextInt(rad / 2));
            final int k = newZ + (((Entity)this).random.nextInt(rad / 2) - ((Entity)this).random.nextInt(rad / 2));
            if (j <= 124) {
                if (j >= 5) {
                    if (this.isAirySpace(i, j, k) && this.isAirySpace(i, j + 1, k) && !this.isAirySpace(i, j - 1, k) && (!this.hasDungeon || (i > this.dungeonX && i < this.dungeonX + 20 && j > this.dungeonY && j < this.dungeonY + 12 && k > this.dungeonZ && k < this.dungeonZ + 20))) {
                        newX = i;
                        newY = j;
                        newZ = k;
                        flag = true;
                    }
                }
            }
        }
        if (!flag) {
            this.teleFail();
        }
        else {
            this.aC();
            this.setPosition(newX + 0.5, newY + 0.5, newZ + 0.5);
            ((Entity)this).motX = 0.0;
            ((Entity)this).motY = 0.0;
            ((Entity)this).motZ = 0.0;
            ((EntityLiving)this).aX = 0.0f;
            ((EntityLiving)this).aW = 0.0f;
            ((EntityLiving)this).aZ = false;
            ((Entity)this).pitch = 0.0f;
            ((Entity)this).yaw = 0.0f;
            this.setPathEntity((PathEntity)null);
            ((EntityLiving)this).V = ((Entity)this).random.nextFloat() * 360.0f;
            this.aC();
            this.teleTimer = ((Entity)this).random.nextInt(40);
        }
    }
    
    public boolean isAirySpace(final int x, final int y, final int z) {
        final int p = ((Entity)this).world.getTypeId(x, y, z);
        return p == 0 || Block.byId[p].e(((Entity)this).world, x, y, z) == null;
    }
    
    public boolean canDespawn() {
        return !this.boss;
    }
    
    public boolean interact(final EntityPlayer entityplayer) {
        this.a((Entity)entityplayer, 180.0f, 180.0f);
        if (!this.boss) {
            if (this.timeLeft >= 1200) {
                final ItemStack itemstack = entityplayer.U();
                if (itemstack != null && itemstack.id == AetherItems.VictoryMedal.id && itemstack.count >= 0) {
                    if (itemstack.count >= 10) {
                        this.chatItUp("Umm... that's a nice pile of medallions you have there...");
                    }
                    else if (itemstack.count >= 5) {
                        this.chatItUp("That's pretty impressive, but you won't defeat me.");
                    }
                    else {
                        this.chatItUp("You think you're a tough guy, eh? Well, bring it on!");
                    }
                }
                else {
                    final int pokey = ((Entity)this).random.nextInt(3);
                    if (pokey == 2) {
                        this.chatItUp("What's that? You want to fight? Aww, what a cute little human.");
                    }
                    else if (pokey == 1) {
                        this.chatItUp("You're not thinking of fighting a big, strong Valkyrie are you?");
                    }
                    else {
                        this.chatItUp("I don't think you should bother me, you could get really hurt.");
                    }
                }
            }
        }
        else if (this.duel) {
            this.chatItUp("If you wish to challenge me, strike at any time.");
        }
        else if (!this.duel) {
            final ItemStack itemstack = entityplayer.U();
            if (itemstack != null && itemstack.id == AetherItems.VictoryMedal.id && itemstack.count >= 10) {
                final ItemStack itemStack = itemstack;
                itemStack.count -= 10;
                if (itemstack.count <= 0) {
                    itemstack.a(entityplayer);
                    entityplayer.V();
                    this.chatTime = 0;
                    this.chatItUp("Very well, attack me when you wish to begin.");
                    this.duel = true;
                }
            }
            else {
                this.chatItUp("Show me 10 victory medals, and I will fight you.");
            }
        }
        return true;
    }
    
    private void chatItUp(final String s) {
        if (this.chatTime <= 0 && this.otherDimension()) {
            //ModLoader.getMinecraftInstance().ingameGUI.addChatMessage(s);
            this.chatTime = 60;
        }
    }
    
    public void makeHomeShot(final int shots, final EntityLiving ep) {
        for (int i = 0; i < shots; ++i) {
            final EntityHomeShot e1 = new EntityHomeShot(((Entity)this).world, ((Entity)this).locX - ((Entity)this).motX / 2.0, ((Entity)this).locY, ((Entity)this).locZ - ((Entity)this).motZ / 2.0, ep);
            ((Entity)this).world.addEntity((Entity)e1);
        }
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        if (this.boss) {
            this.a(new ItemStack(AetherItems.Key, 1, 1), 0.0f);
            this.a(Item.GOLD_SWORD.id, 1);
        }
        else {
            this.a(AetherItems.VictoryMedal.id, 1);
        }
    }
    
    public void updateEntityActionState() {
        super.d_();
        ++this.teleTimer;
        if (this.teleTimer >= 450) {
            if (super.target != null) {
                if (this.boss && ((Entity)this).onGround && ((Entity)this).random.nextInt(2) == 0 && super.target != null && super.target instanceof EntityLiving) {
                    this.makeHomeShot(1, (EntityLiving)super.target);
                    this.teleTimer = -100;
                }
                else {
                    this.teleport(super.target.locX, super.target.locY, super.target.locZ, 7);
                }
            }
            else if (!((Entity)this).onGround || this.boss) {
                this.teleport(this.safeX, this.safeY, this.safeZ, 6);
            }
            else {
                this.teleport(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, 12 + ((Entity)this).random.nextInt(12));
            }
        }
        else if (this.teleTimer < 446 && (((Entity)this).locY <= 0.0 || ((Entity)this).locY <= this.safeY - 16.0)) {
            this.teleTimer = 446;
        }
        else if (this.teleTimer % 5 == 0 && super.target != null && !this.h(super.target)) {
            this.teleTimer += 100;
        }
        if (((Entity)this).onGround && this.teleTimer % 10 == 0 && !this.boss) {
            this.safeX = ((Entity)this).locX;
            this.safeY = ((Entity)this).locY;
            this.safeZ = ((Entity)this).locZ;
        }
        if (super.target != null && super.target.dead) {
            super.target = null;
            if (this.boss) {
                this.unlockDoor();
                mod_Aether.currentBoss = null;
            }
            this.angerLevel = 0;
        }
        if (this.chatTime > 0) {
            --this.chatTime;
        }
    }
    
    public void swingArm() {
        if (!this.isSwinging) {
            this.isSwinging = true;
            ((EntityLiving)this).an = 0.0f;
            ((EntityLiving)this).ao = 0.0f;
        }
    }
    
    public void teleFail() {
        this.teleTimer -= ((Entity)this).random.nextInt(40) + 40;
        if (((Entity)this).locY <= 0.0) {
            this.teleTimer = 446;
        }
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).world.m(i, j, k) > 8 && ((Entity)this).world.containsEntity(((Entity)this).boundingBox) && ((Entity)this).world.getCubes((Entity)this, ((Entity)this).boundingBox).size() == 0 && !((Entity)this).world.containsLiquid(((Entity)this).boundingBox);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Anger", (short)this.angerLevel);
        nbttagcompound.setShort("TeleTimer", (short)this.teleTimer);
        nbttagcompound.setShort("TimeLeft", (short)this.timeLeft);
        nbttagcompound.setBoolean("Boss", this.boss);
        nbttagcompound.setBoolean("Duel", this.duel);
        nbttagcompound.setInt("DungeonX", this.dungeonX);
        nbttagcompound.setInt("DungeonY", this.dungeonY);
        nbttagcompound.setInt("DungeonZ", this.dungeonZ);
        nbttagcompound.setInt("DungeonEntranceZ", this.dungeonEntranceZ);
        nbttagcompound.set("SafePos", (NBTBase)this.a(new double[] { this.safeX, this.safeY, this.safeZ }));
        nbttagcompound.setBoolean("IsCurrentBoss", this.isCurrentBoss());
        nbttagcompound.setString("BossName", this.bossName);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.angerLevel = nbttagcompound.getShort("Anger");
        this.teleTimer = nbttagcompound.getShort("TeleTimer");
        this.timeLeft = nbttagcompound.getShort("TimeLeft");
        this.duel = nbttagcompound.getBoolean("Duel");
        this.boss = nbttagcompound.getBoolean("Boss");
        this.dungeonX = nbttagcompound.getInt("DungeonX");
        this.dungeonY = nbttagcompound.getInt("DungeonY");
        this.dungeonZ = nbttagcompound.getInt("DungeonZ");
        this.dungeonEntranceZ = nbttagcompound.getInt("DungeonEntranceZ");
        if (this.boss) {
            ((EntityLiving)this).texture = "/aether/mobs/valkyrie2.png";
        }
        final NBTTagList nbttaglist = nbttagcompound.getList("SafePos");
        this.safeX = ((NBTTagDouble)nbttaglist.get(0)).data;
        this.safeY = ((NBTTagDouble)nbttaglist.get(1)).data;
        this.safeZ = ((NBTTagDouble)nbttaglist.get(2)).data;
        if (nbttagcompound.getBoolean("IsCurrentBoss")) {
            mod_Aether.currentBoss = this;
        }
        this.bossName = nbttagcompound.getString("BossName");
    }
    
    @Override
    protected Entity findPlayerToAttack() {
        if (this.otherDimension() && (((Entity)this).world.difficulty <= 0 || (this.boss && !this.duel) || this.angerLevel <= 0)) {
            return null;
        }
        return super.findPlayerToAttack();
    }
    
    @Override
    public boolean damageEntity(final DamageSource ds, final int i) {
        if (!(ds.getEntity() instanceof EntityPlayer) || ((Entity)this).world.difficulty <= 0) {
            this.teleport(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, 8);
            this.extinguish();
            return false;
        }
        if (this.boss && (!this.duel || ((Entity)this).world.difficulty <= 0)) {
            this.aC();
            final int pokey = ((Entity)this).random.nextInt(2);
            if (pokey == 2) {
                this.chatItUp("Sorry, I don't fight with weaklings.");
            }
            else {
                this.chatItUp("Try defeating some weaker valkyries first.");
            }
            return false;
        }
        if (this.boss) {
            if (super.target == null) {
                mod_Aether.currentBoss = this;
                this.chatTime = 0;
                this.chatItUp("This will be your final battle!");
            }
            else {
                this.teleTimer += 60;
            }
        }
        else if (super.target == null) {
            this.chatTime = 0;
            final int pokey = ((Entity)this).random.nextInt(3);
            if (pokey == 2) {
                this.chatItUp("I'm not going easy on you!");
            }
            else if (pokey == 1) {
                this.chatItUp("You're gonna regret that!");
            }
            else {
                this.chatItUp("Now you're in for it!");
            }
        }
        else {
            this.teleTimer -= 10;
        }
        this.becomeAngryAt(ds.getEntity());
        final boolean flag = super.damageEntity(ds, i);
        if (flag && ((EntityLiving)this).health <= 0) {
            final int pokey2 = ((Entity)this).random.nextInt(3);
            ((Entity)this).dead = true;
            if (this.boss) {
                ((Entity)this).dead = false;
                this.unlockDoor();
                this.unlockTreasure();
                this.chatItUp("You are truly... a mighty warrior...");
                mod_Aether.currentBoss = null;
            }
            else if (pokey2 == 2) {
                this.chatItUp("Alright, alright! You win!");
            }
            else if (pokey2 == 1) {
                this.chatItUp("Okay, I give up! Geez!");
            }
            else {
                this.chatItUp("Oww! Fine, here's your medal...");
            }
            this.aC();
        }
        return flag;
    }
    
    @Override
    protected void attackEntity(final Entity entity, final float f) {
        if (((EntityLiving)this).attackTicks <= 0 && f < 2.75f && entity.boundingBox.e > ((Entity)this).boundingBox.b && entity.boundingBox.b < ((Entity)this).boundingBox.e) {
            ((EntityLiving)this).attackTicks = 20;
            this.swingArm();
            entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), super.attackStrength);
            if (entity != null && super.target != null && entity == super.target && entity instanceof EntityLiving) {
                final EntityLiving e1 = (EntityLiving)entity;
                if (e1.health <= 0) {
                    super.target = null;
                    this.angerLevel = 0;
                    final int pokey = ((Entity)this).random.nextInt(3);
                    this.chatTime = 0;
                    if (this.boss) {
                        this.chatItUp("As expected of a human.");
                        this.unlockDoor();
                        mod_Aether.currentBoss = null;
                    }
                    else if (pokey == 2) {
                        this.chatItUp("You want a medallion? Try being less pathetic.");
                    }
                    else if (pokey == 1 && e1 instanceof EntityPlayer) {
                        final EntityPlayer ep = (EntityPlayer)e1;
                        final String s = ep.name;
                        this.chatItUp("Maybe some day, " + s + "... maybe some day.");
                    }
                    else {
                        this.chatItUp("Humans aren't nearly as cute when they're dead.");
                    }
                }
            }
        }
    }
    
    private void becomeAngryAt(final Entity entity) {
        super.target = entity;
        this.angerLevel = 200 + ((Entity)this).random.nextInt(200);
        if (this.boss) {
            for (int k = this.dungeonZ + 2; k < this.dungeonZ + 23; k += 7) {
                if (((Entity)this).world.getTypeId(this.dungeonX - 1, this.dungeonY, k) == 0) {
                    this.dungeonEntranceZ = k;
                    ((Entity)this).world.setRawTypeIdAndData(this.dungeonX - 1, this.dungeonY, k, AetherBlocks.LockedDungeonStone.id, 1);
                    ((Entity)this).world.setRawTypeIdAndData(this.dungeonX - 1, this.dungeonY, k + 1, AetherBlocks.LockedDungeonStone.id, 1);
                    ((Entity)this).world.setRawTypeIdAndData(this.dungeonX - 1, this.dungeonY + 1, k + 1, AetherBlocks.LockedDungeonStone.id, 1);
                    ((Entity)this).world.setRawTypeIdAndData(this.dungeonX - 1, this.dungeonY + 1, k, AetherBlocks.LockedDungeonStone.id, 1);
                    return;
                }
            }
        }
    }
    
    private void unlockDoor() {
        ((Entity)this).world.setRawTypeId(this.dungeonX - 1, this.dungeonY, this.dungeonEntranceZ, 0);
        ((Entity)this).world.setRawTypeId(this.dungeonX - 1, this.dungeonY, this.dungeonEntranceZ + 1, 0);
        ((Entity)this).world.setRawTypeId(this.dungeonX - 1, this.dungeonY + 1, this.dungeonEntranceZ + 1, 0);
        ((Entity)this).world.setRawTypeId(this.dungeonX - 1, this.dungeonY + 1, this.dungeonEntranceZ, 0);
    }
    
    private void unlockTreasure() {
        ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 16, this.dungeonY + 1, this.dungeonZ + 9, Block.TRAP_DOOR.id, 3);
        ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 17, this.dungeonY + 1, this.dungeonZ + 9, Block.TRAP_DOOR.id, 2);
        ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 16, this.dungeonY + 1, this.dungeonZ + 10, Block.TRAP_DOOR.id, 3);
        ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 17, this.dungeonY + 1, this.dungeonZ + 10, Block.TRAP_DOOR.id, 2);
        /*
        mod_Aether.giveAchievement(AetherAchievements.defeatSilver);
        for (int x = this.dungeonX - 26; x < this.dungeonX + 29; ++x) {
            for (int y = this.dungeonY - 1; y < this.dungeonY + 22; ++y) {
                for (int z = this.dungeonZ - 5; z < this.dungeonZ + 25; ++z) {
                    final int id = ((Entity)this).world.getTypeId(x, y, z);
                    if (id == AetherBlocks.LockedDungeonStone.id) {
                        ((Entity)this).world.setRawTypeIdAndData(x, y, z, AetherBlocks.DungeonStone.id, ((Entity)this).world.getData(x, y, z));
                    }
                    if (id == AetherBlocks.Trap.id) {
                        ((Entity)this).world.setRawTypeIdAndData(x, y, z, AetherBlocks.DungeonStone.id, ((Entity)this).world.getData(x, y, z));
                    }
                    if (id == AetherBlocks.LockedLightDungeonStone.id) {
                        ((Entity)this).world.setRawTypeIdAndData(x, y, z, AetherBlocks.LightDungeonStone.id, ((Entity)this).world.getData(x, y, z));
                    }
                }
            }
            */
        }
    
    
    public void setDungeon(final int i, final int j, final int k) {
        this.hasDungeon = true;
        this.dungeonX = i;
        this.dungeonY = j;
        this.dungeonZ = k;
    }
    
    @Override
    public int getBossHP() {
        return ((EntityLiving)this).health;
    }
    
    @Override
    public int getBossMaxHP() {
        return 500;
    }
    
    @Override
    public boolean isCurrentBoss() {
        return mod_Aether.currentBoss != null && this.equals(mod_Aether.currentBoss);
    }
    
    @Override
    public int getBossEntityID() {
        return ((Entity)this).id;
    }
    
    @Override
    public String getBossTitle() {
        return this.bossName + ", the Valkyrie Queen";
    }
}
