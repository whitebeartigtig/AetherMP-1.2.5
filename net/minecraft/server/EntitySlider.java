package net.minecraft.server;

import forge.*;

public class EntitySlider extends EntityFlying implements IAetherBoss
{
    public int moveTimer;
    public int dennis;
    public int rennis;
    public int chatTime;
    public Entity target;
    public boolean awake;
    public boolean gotMovement;
    public boolean crushed;
    public float speedy;
    public float harvey;
    public int direction;
    private int dungeonX;
    private int dungeonY;
    private int dungeonZ;
    public String bossName;
    
    public EntitySlider(final World world) {
        super(world);
        ((Entity)this).yaw = 0.0f;
        ((Entity)this).pitch = 0.0f;
        this.b(2.0f, 2.0f);
        ((EntityLiving)this).health = this.getMaxHealth();
        this.dennis = 1;
        ((EntityLiving)this).texture = "/aether/mobs/sliderSleep.png";
        this.chatTime = 60;
        this.bossName = NameGen.gen();
    }
    
    public int getMaxHealth() {
        return 500;
    }
    
    public void entityInit() {
        super.b();
        ((Entity)this).locX = Math.floor(((Entity)this).locX + 0.5);
        ((Entity)this).locY = Math.floor(((Entity)this).locY + 0.5);
        ((Entity)this).locZ = Math.floor(((Entity)this).locZ + 0.5);
    }
    
    public boolean canDespawn() {
        return false;
    }
    
    protected String getLivingSound() {
        return "ambient.cave.cave";
    }
    
    protected String getHurtSound() {
        return "step.stone";
    }
    
    protected String getDeathSound() {
        return "aether.sound.bosses.slider.sliderDeath";
    }
    
    public Entity GetEntity() {
        return (Entity)this;
    }
    
    public void writeEntityToNBT(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setFloat("Speedy", this.speedy);
        nbttagcompound.setShort("MoveTimer", (short)this.moveTimer);
        nbttagcompound.setShort("Direction", (short)this.direction);
        nbttagcompound.setBoolean("GotMovement", this.gotMovement);
        nbttagcompound.setBoolean("Awake", this.awake);
        nbttagcompound.setInt("DungeonX", this.dungeonX);
        nbttagcompound.setInt("DungeonY", this.dungeonY);
        nbttagcompound.setInt("DungeonZ", this.dungeonZ);
        nbttagcompound.setBoolean("IsCurrentBoss", this.isCurrentBoss());
        nbttagcompound.setString("BossName", this.bossName);
    }
    
    public void readEntityFromNBT(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.speedy = nbttagcompound.getFloat("Speedy");
        this.moveTimer = nbttagcompound.getShort("MoveTimer");
        this.direction = nbttagcompound.getShort("Direction");
        this.gotMovement = nbttagcompound.getBoolean("GotMovement");
        this.awake = nbttagcompound.getBoolean("Awake");
        this.dungeonX = nbttagcompound.getInt("DungeonX");
        this.dungeonY = nbttagcompound.getInt("DungeonY");
        this.dungeonZ = nbttagcompound.getInt("DungeonZ");
        if (nbttagcompound.getBoolean("IsCurrentBoss")) {
            mod_Aether.currentBoss = this;
        }
        this.bossName = nbttagcompound.getString("BossName");
        if (this.awake) {
            if (this.criticalCondition()) {
                ((EntityLiving)this).texture = "/aether/mobs/sliderAwake_red.png";
            }
            else {
                ((EntityLiving)this).texture = "/aether/mobs/sliderAwake.png";
            }
        }
    }
    
    public boolean criticalCondition() {
        return ((EntityLiving)this).health <= 125;
    }
    
    public void onUpdate() {
        super.F_();
        final float renderYawOffset = 0.0f;
        ((Entity)this).yaw = renderYawOffset;
        ((Entity)this).pitch = renderYawOffset;
        ((EntityLiving)this).V = renderYawOffset;
        if (this.awake) {
            if (this.target != null && this.target instanceof EntityLiving) {
                final EntityLiving e1 = (EntityLiving)this.target;
                if (e1.health <= 0) {
                    this.awake = false;
                    mod_Aether.currentBoss = null;
                    this.target = null;
                    ((EntityLiving)this).texture = "/aether/mobs/sliderSleep.png";
                    this.stop();
                    this.openDoor();
                    this.moveTimer = 0;
                    return;
                }
            }
            else {
                if (this.target != null && this.target.dead) {
                    this.awake = false;
                    mod_Aether.currentBoss = null;
                    this.target = null;
                    ((EntityLiving)this).texture = "/aether/mobs/sliderSleep.png";
                    this.stop();
                    this.openDoor();
                    this.moveTimer = 0;
                    return;
                }
                if (this.target == null) {
                    this.target = (Entity)((Entity)this).world.findNearbyPlayer((Entity)this, -1.0);
                    if (this.target == null) {
                        this.awake = false;
                        mod_Aether.currentBoss = null;
                        this.target = null;
                        ((EntityLiving)this).texture = "/aether/mobs/sliderSleep.png";
                        this.stop();
                        this.openDoor();
                        this.moveTimer = 0;
                        return;
                    }
                }
            }
            if (this.gotMovement) {
                if (((Entity)this).bA) {
                    final double x = ((Entity)this).locX - 0.5;
                    final double y = ((Entity)this).boundingBox.b + 0.75;
                    final double z = ((Entity)this).locZ - 0.5;
                    this.crushed = false;
                    if (y < 124.0 && y > 4.0) {
                        if (this.direction == 0) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x + a), (int)(y + 1.5), (int)(z + b));
                            }
                        }
                        else if (this.direction == 1) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x + a), (int)(y - 1.5), (int)(z + b));
                            }
                        }
                        else if (this.direction == 2) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x + 1.5), (int)(y + a), (int)(z + b));
                            }
                        }
                        else if (this.direction == 3) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x - 1.5), (int)(y + a), (int)(z + b));
                            }
                        }
                        else if (this.direction == 4) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x + a), (int)(y + b), (int)(z + 1.5));
                            }
                        }
                        else if (this.direction == 5) {
                            for (int i = 0; i < 25; ++i) {
                                final double a = (i / 5 - 2) * 0.75;
                                final double b = (i % 5 - 2) * 0.75;
                                this.blockCrush((int)(x + a), (int)(y + b), (int)(z - 1.5));
                            }
                        }
                    }
                    if (this.crushed) {
                        ((Entity)this).world.makeSound(((Entity)this).locX, ((Entity)this).locY, ((Entity)this).locZ, "random.explode", 3.0f, (0.625f + (((Entity)this).world.random.nextFloat() - ((Entity)this).world.random.nextFloat()) * 0.2f) * 0.7f);
                        ((Entity)this).world.makeSound((Entity)this, "aether.sound.bosses.slider.sliderCollide", 2.5f, 1.0f / (((Entity)this).random.nextFloat() * 0.2f + 0.9f));
                    }
                    this.stop();
                }
                else {
                    if (this.speedy < 2.0f) {
                        this.speedy += (this.criticalCondition() ? 0.0325f : 0.025f);
                    }
                    ((Entity)this).motX = 0.0;
                    ((Entity)this).motY = 0.0;
                    ((Entity)this).motZ = 0.0;
                    if (this.direction == 0) {
                        ((Entity)this).motY = this.speedy;
                        if (((Entity)this).boundingBox.b > this.target.boundingBox.b + 0.35) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                    else if (this.direction == 1) {
                        ((Entity)this).motY = -this.speedy;
                        if (((Entity)this).boundingBox.b < this.target.boundingBox.b - 0.25) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                    else if (this.direction == 2) {
                        ((Entity)this).motX = this.speedy;
                        if (((Entity)this).locX > this.target.locX + 0.125) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                    else if (this.direction == 3) {
                        ((Entity)this).motX = -this.speedy;
                        if (((Entity)this).locX < this.target.locX - 0.125) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                    else if (this.direction == 4) {
                        ((Entity)this).motZ = this.speedy;
                        if (((Entity)this).locZ > this.target.locZ + 0.125) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                    else if (this.direction == 5) {
                        ((Entity)this).motZ = -this.speedy;
                        if (((Entity)this).locZ < this.target.locZ - 0.125) {
                            this.stop();
                            this.moveTimer = 8;
                        }
                    }
                }
            }
            else if (this.moveTimer > 0) {
                --this.moveTimer;
                if (this.criticalCondition() && ((Entity)this).random.nextInt(2) == 0) {
                    --this.moveTimer;
                }
                ((Entity)this).motX = 0.0;
                ((Entity)this).motY = 0.0;
                ((Entity)this).motZ = 0.0;
            }
            else {
                final double a2 = Math.abs(((Entity)this).locX - this.target.locX);
                final double b2 = Math.abs(((Entity)this).boundingBox.b - this.target.boundingBox.b);
                final double c = Math.abs(((Entity)this).locZ - this.target.locZ);
                if (a2 > c) {
                    this.direction = 2;
                    if (((Entity)this).locX > this.target.locX) {
                        this.direction = 3;
                    }
                }
                else {
                    this.direction = 4;
                    if (((Entity)this).locZ > this.target.locZ) {
                        this.direction = 5;
                    }
                }
                if ((b2 > a2 && b2 > c) || (b2 > 0.25 && ((Entity)this).random.nextInt(5) == 0)) {
                    this.direction = 0;
                    if (((Entity)this).locY > this.target.locY) {
                        this.direction = 1;
                    }
                }
                ((Entity)this).world.makeSound((Entity)this, "aether.sound.bosses.slider.sliderMove", 2.5f, 1.0f / (((Entity)this).random.nextFloat() * 0.2f + 0.9f));
                this.gotMovement = true;
            }
        }
        if (this.harvey > 0.01f) {
            this.harvey *= 0.8f;
        }
        if (this.chatTime > 0) {
            --this.chatTime;
        }
    }
    
    private void openDoor() {
        final int x = this.dungeonX + 15;
        for (int y = this.dungeonY + 1; y < this.dungeonY + 5; ++y) {
            for (int z = this.dungeonZ + 6; z < this.dungeonZ + 10; ++z) {
                ((Entity)this).world.setRawTypeId(x, y, z, 0);
            }
        }
    }
    
    public void applyEntityCollision(final Entity entity) {
        if (this.awake && this.gotMovement) {
            final boolean flag = entity.damageEntity(DamageSource.mobAttack((EntityLiving)this), 6);
            if (flag && entity instanceof EntityLiving) {
                ((Entity)this).world.makeSound((Entity)this, "aether.sound.bosses.slider.sliderCollide", 2.5f, 1.0f / (((Entity)this).random.nextFloat() * 0.2f + 0.9f));
                if (entity instanceof EntityCreature || entity instanceof EntityPlayer) {
                    final EntityLiving entityLiving;
                    final EntityLiving ek = entityLiving = (EntityLiving)entity;
                    ((Entity)entityLiving).motY += 0.35;
                    final EntityLiving entityLiving2 = ek;
                    ((Entity)entityLiving2).motX *= 2.0;
                    final EntityLiving entityLiving3 = ek;
                    ((Entity)entityLiving3).motZ *= 2.0;
                }
                this.stop();
            }
        }
    }
    
    protected void dropFewItems(final boolean var1, final int var2) {
        for (int i = 0; i < 7 + ((Entity)this).random.nextInt(3); ++i) {
            this.b(AetherBlocks.DungeonStone.id, 1);
        }
        this.a(new ItemStack(AetherItems.Key, 1, 0), 0.0f);
    }
    
    public boolean getCanSpawnHere() {
        final int i = MathHelper.floor(((Entity)this).locX);
        final int j = MathHelper.floor(((Entity)this).boundingBox.b);
        final int k = MathHelper.floor(((Entity)this).locZ);
        return ((Entity)this).world.getTypeId(i, j - 1, k) == ((Block)Block.GRASS).id && ((Entity)this).world.m(i, j, k) > 8 && super.canSpawn();
    }
    
    public void stop() {
        this.gotMovement = false;
        this.moveTimer = 12;
        this.direction = 0;
        this.speedy = 0.0f;
        ((Entity)this).motX = 0.0;
        ((Entity)this).motY = 0.0;
        ((Entity)this).motZ = 0.0;
    }
    
    private void chatItUp(final String s) {
        if (this.chatTime <= 0) {
            ModLoader.getMinecraftInstance().ingameGUI.addChatMessage(s);
            this.chatTime = 60;
        }
    }
    
    public boolean attackEntityFrom(final DamageSource ds, final int i) {
        if (ds.getEntity() == null || !(ds.getEntity() instanceof EntityPlayer)) {
            return false;
        }
        final EntityPlayer p1 = (EntityPlayer)ds.getEntity();
        final ItemStack stack = p1.U();
        if (stack == null || stack.getItem() == null) {
            return false;
        }
        if (!(stack.getItem() instanceof ItemPickaxe) && (!(stack.getItem() instanceof ITextureProvider) || !(stack.getItem() instanceof ItemTool))) {
            this.chatItUp("Hmm. Perhaps I need to attack it with a Pickaxe?");
            return false;
        }
        final boolean flag = super.damageEntity(ds, Math.max(0, i));
        if (flag) {
            for (int j = 0; j < ((((EntityLiving)this).health <= 0) ? 16 : 48); ++j) {
                final double a = ((Entity)this).locX + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 1.5;
                final double b = ((Entity)this).boundingBox.b + 1.75 + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 1.5;
                final double c = ((Entity)this).locZ + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 1.5;
                if (((EntityLiving)this).health <= 0) {
                    ((Entity)this).world.a("explode", a, b, c, 0.0, 0.0, 0.0);
                }
            }
            if (((EntityLiving)this).health <= 0) {
                ((Entity)this).dead = true;
                this.openDoor();
                this.unlockBlock(this.dungeonX, this.dungeonY, this.dungeonZ);
                ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 7, this.dungeonY + 1, this.dungeonZ + 7, Block.TRAP_DOOR.id, 3);
                ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 8, this.dungeonY + 1, this.dungeonZ + 7, Block.TRAP_DOOR.id, 2);
                ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 7, this.dungeonY + 1, this.dungeonZ + 8, Block.TRAP_DOOR.id, 3);
                ((Entity)this).world.setRawTypeIdAndData(this.dungeonX + 8, this.dungeonY + 1, this.dungeonZ + 8, Block.TRAP_DOOR.id, 2);
                mod_Aether.giveAchievement(AetherAchievements.defeatBronze);
                mod_Aether.currentBoss = null;
            }
            else if (!this.awake) {
                ((Entity)this).world.makeSound((Entity)this, "aether.sound.bosses.slider.sliderAwaken", 2.5f, 1.0f / (((Entity)this).random.nextFloat() * 0.2f + 0.9f));
                this.awake = true;
                this.target = ds.getEntity();
                ((EntityLiving)this).texture = "/aether/mobs/sliderAwake.png";
                final int x = this.dungeonX + 15;
                for (int y = this.dungeonY + 1; y < this.dungeonY + 8; ++y) {
                    for (int z = this.dungeonZ + 5; z < this.dungeonZ + 11; ++z) {
                        ((Entity)this).world.setRawTypeId(x, y, z, AetherBlocks.LockedDungeonStone.id);
                    }
                }
                mod_Aether.currentBoss = this;
            }
            else if (this.gotMovement) {
                this.speedy *= 0.75f;
            }
            final double a2 = Math.abs(((Entity)this).locX - ds.getEntity().locX);
            final double c2 = Math.abs(((Entity)this).locZ - ds.getEntity().locZ);
            if (a2 > c2) {
                this.dennis = 1;
                this.rennis = 0;
                if (((Entity)this).locX > ds.getEntity().locX) {
                    this.dennis = -1;
                }
            }
            else {
                this.rennis = 1;
                this.dennis = 0;
                if (((Entity)this).locZ > ds.getEntity().locZ) {
                    this.rennis = -1;
                }
            }
            this.harvey = 0.7f - ((EntityLiving)this).health / 875.0f;
            if (this.criticalCondition()) {
                ((EntityLiving)this).texture = "/aether/mobs/sliderAwake_red.png";
            }
            else {
                ((EntityLiving)this).texture = "/aether/mobs/sliderAwake.png";
            }
        }
        return flag;
    }
    
    private void unlockBlock(final int i, final int j, final int k) {
        final int id = ((Entity)this).world.getTypeId(i, j, k);
        if (id == AetherBlocks.LockedDungeonStone.id) {
            ((Entity)this).world.setRawTypeIdAndData(i, j, k, AetherBlocks.DungeonStone.id, ((Entity)this).world.getData(i, j, k));
            this.unlockBlock(i + 1, j, k);
            this.unlockBlock(i - 1, j, k);
            this.unlockBlock(i, j + 1, k);
            this.unlockBlock(i, j - 1, k);
            this.unlockBlock(i, j, k + 1);
            this.unlockBlock(i, j, k - 1);
        }
        if (id == AetherBlocks.LockedLightDungeonStone.id) {
            ((Entity)this).world.setRawTypeIdAndData(i, j, k, AetherBlocks.LightDungeonStone.id, ((Entity)this).world.getData(i, j, k));
            this.unlockBlock(i + 1, j, k);
            this.unlockBlock(i - 1, j, k);
            this.unlockBlock(i, j + 1, k);
            this.unlockBlock(i, j - 1, k);
            this.unlockBlock(i, j, k + 1);
            this.unlockBlock(i, j, k - 1);
        }
    }
    
    public void addVelocity(final double d, final double d1, final double d2) {
    }
    
    public void knockBack(final Entity entity, final int i, final double d, final double d1) {
    }
    
    public void blockCrush(final int x, final int y, final int z) {
        final int a = ((Entity)this).world.getTypeId(x, y, z);
        final int b = ((Entity)this).world.getData(x, y, z);
        if (a == 0 || a == AetherBlocks.LockedDungeonStone.id || a == AetherBlocks.LockedLightDungeonStone.id) {
            return;
        }
        /*
        ModLoader.getMinecraftInstance().effectRenderer.addBlockDestroyEffects(x, y, z, a, b);
        Block.byId[a].remove(((Entity)this).world, x, y, z);
        Block.byId[a].b(((Entity)this).world, x, y, z, b, 1);
        ((Entity)this).world.setTypeId(x, y, z, 0);
        this.crushed = true;
        if (ModLoader.getMinecraftInstance().gameSettings.fancyGraphics) {
            this.addSquirrelButts(x, y, z);
        }
        */
    }
    
    public void addSquirrelButts(final int x, final int y, final int z) {
        final double a = x + 0.5 + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.375;
        final double b = y + 0.5 + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.375;
        final double c = z + 0.5 + (((Entity)this).random.nextFloat() - ((Entity)this).random.nextFloat()) * 0.375;
        ((Entity)this).world.a("explode", a, b, c, 0.0, 0.0, 0.0);
    }
    
    public void setDungeon(final int i, final int j, final int k) {
        this.dungeonX = i;
        this.dungeonY = j;
        this.dungeonZ = k;
    }
    
    public int getBossHP() {
        return ((EntityLiving)this).health;
    }
    
    public int getBossMaxHP() {
        return 500;
    }
    
    public boolean isCurrentBoss() {
        return mod_Aether.currentBoss != null && this.equals(mod_Aether.currentBoss);
    }
    
    public int getBossEntityID() {
        return ((Entity)this).id;
    }
    
    public String getBossTitle() {
        return this.bossName + ", the Slider";
    }
}
