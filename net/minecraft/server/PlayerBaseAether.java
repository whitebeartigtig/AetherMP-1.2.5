package net.minecraft.server;

import net.minecraft.server.*;
import java.util.*;
import cpw.mods.fml.common.*;
import java.io.*;

public class PlayerBaseAether extends PlayerBase
{
    public int timeUntilPortal;
    protected boolean inPortal;
    public float timeInPortal;
    public float prevTimeInPortal;
    public MinecraftServer mc;
    public int foodTimer;
    public TeleporterAether teleporter;
    public int maxHealth;
    public InventoryAether inv;
    public List extendedReachItems;
    
    public PlayerBaseAether(final PlayerAPI p) {
        super(p);
        this.timeUntilPortal = 20;
        this.inPortal = false;
        this.mc = (MinecraftServer) ModLoader.getMinecraftInstance();
        this.teleporter = new TeleporterAether();
        this.extendedReachItems = Arrays.asList(AetherItems.ShovelValkyrie, AetherItems.PickValkyrie, AetherItems.AxeValkyrie, AetherItems.Lance);
        this.maxHealth = 20;
        this.inv = new InventoryAether((EntityHuman)super.player);
        if (!((Entity)super.player).world.isStatic) {
            ((EntityHuman)super.player).defaultContainer = (Container)new ContainerAether(((EntityHuman)super.player).inventory, this.inv, !((Entity)super.player).world.isStatic);
            ((EntityHuman)super.player).activeContainer = ((EntityHuman)super.player).defaultContainer;
            this.readCustomData();
            mod_Aether.Player = this;
        }
    }
    
    public void setInPortal() {
        if (this.timeUntilPortal > 0) {
            this.timeUntilPortal = 10;
        }
        else {
            this.inPortal = true;
        }
    }
    
    public void increaseMaxHP(final int i) {
        if (this.maxHealth <= 40 - i) {
            this.maxHealth += i;
            super.player.setHealth(super.player.getHealth() + i);
        }
    }
    
    @Override
    public void heal(final int i) {
        if (super.player.getHealth() <= 0) {
            return;
        }
        super.player.setHealth(super.player.getHealth() + i);
        if (super.player.getHealth() > this.maxHealth) {
            super.player.setHealth(this.maxHealth);
        }
        ((Entity)super.player).noDamageTicks = ((EntityLiving)super.player).maxNoDamageTicks / 2;
    }
    /*
    @Override
    public boolean attackEntityFrom(final DamageSource var1, final int var2) {
        if (GuiMainMenu.mmactive) {
            final Entity attacker = var1.getEntity();
            if (attacker != null) {
                attacker.damageEntity(DamageSource.mobAttack((EntityLiving)attacker), var2);
            }
            return true;
        }
        return super.attackEntityFrom(var1, var2);
    }
    */
    @Override
    public void beforeOnUpdate() {
        if (this.isAboveBlock(AetherBlocks.Aercloud.id)) {
            ((Entity)super.player).fallDistance = 0.0f;
        }
    }
    
    public boolean isAboveBlock(final int blockID) {
        final int x = MathHelper.floor(((Entity)super.player).locX);
        final int y = MathHelper.floor(((Entity)super.player).boundingBox.b);
        final int z = MathHelper.floor(((Entity)super.player).locZ);
        return ((Entity)super.player).world.getTypeId(MathHelper.floor(((Entity)super.player).boundingBox.a), y - 1, MathHelper.floor(((Entity)super.player).boundingBox.c)) == blockID || ((Entity)super.player).world.getTypeId(MathHelper.floor(((Entity)super.player).boundingBox.d), y - 1, MathHelper.floor(((Entity)super.player).boundingBox.c)) == blockID || ((Entity)super.player).world.getTypeId(MathHelper.floor(((Entity)super.player).boundingBox.f), y - 1, MathHelper.floor(((Entity)super.player).boundingBox.f)) == blockID || ((Entity)super.player).world.getTypeId(MathHelper.floor(((Entity)super.player).boundingBox.a), y - 1, MathHelper.floor(((Entity)super.player).boundingBox.f)) == blockID;
    }
    
    private void performRepShieldEffect() {
        final ItemStack stack = this.inv.slots[2];
        final List ents = ((Entity)super.player).world.getEntities((Entity)super.player, ((Entity)super.player).boundingBox.grow(4.0, 4.0, 4.0));
        for (final Object o : ents) {
            final Entity ent = (Entity)o;
            if (!(ent instanceof EntityArrow) && !(ent instanceof EntityProjectile) && !(ent instanceof EntityProjectileBase) && !(ent instanceof EntityFireball) && !(ent instanceof EntityZephyrSnowball)) {
                continue;
            }
            final double distsq = super.player.j(ent);
            if (distsq > 9.0) {
                continue;
            }
            if (this.isInGround(ent)) {
                continue;
            }
            final Entity dick = this.getShooter(ent);
            if (dick == super.player) {
                continue;
            }
            this.setShooter(ent, (EntityLiving)super.player);
            double a;
            double b;
            double c;
            if (dick != null) {
                a = ent.locX - dick.locX;
                b = ent.boundingBox.b - dick.boundingBox.b;
                c = ent.locZ - dick.locZ;
            }
            else {
                a = ((Entity)super.player).locX - ent.locX;
                b = ((Entity)super.player).locY - ent.locY;
                c = ((Entity)super.player).locZ - ent.locZ;
            }
            final double d = Math.sqrt(a * a + b * b + c * c);
            a /= -d;
            b /= -d;
            c /= -d;
            ent.motX = a * 0.75;
            ent.motY = b * 0.75 + 0.05;
            ent.motZ = c * 0.75;
            this.setHeading(ent, ent.motX, ent.motY, ent.motZ, 0.8f, 0.5f);
            ((Entity)super.player).world.makeSound(ent, "note.snare", 1.0f, ((((Entity)super.player).random.nextFloat() - ((Entity)super.player).random.nextFloat()) * 0.4f + 0.8f) * 1.1f);
            for (int k = 0; k < 12; ++k) {
                double d2 = -ent.motX * 0.15000000596046448 + (ent.random.nextFloat() - 0.5f) * 0.05f;
                double e1 = -ent.motY * 0.15000000596046448 + (ent.random.nextFloat() - 0.5f) * 0.05f;
                double f1 = -ent.motZ * 0.15000000596046448 + (ent.random.nextFloat() - 0.5f) * 0.05f;
                d2 *= 0.625;
                e1 *= 0.625;
                f1 *= 0.625;
                ((Entity)super.player).world.a("flame", ent.locX, ent.locY, ent.locZ, d2, e1, f1);
            }
            stack.damage(1, (EntityLiving)super.player);
            if (stack.getData() != AetherItems.RepShield.getMaxDurability()) {
                continue;
            }
            this.inv.slots[2] = null;
        }
    }
    
    private void setHeading(final Entity ent, final double motionX, final double motionY, final double motionZ, final float f1, final float f2) {
        if (ent instanceof EntityArrow) {
            ((EntityArrow)ent).shoot(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityProjectile) {
            ((EntityProjectile)ent).a(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityProjectileBase) {
            ((EntityProjectileBase)ent).shoot(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityFireball) {
            final EntityFireball ball = (EntityFireball)ent;
            final double len = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
            ball.dirX = motionX / len * 0.1;
            ball.dirY = motionY / len * 0.1;
            ball.dirZ = motionZ / len * 0.1;
        }
        else if (ent instanceof EntityZephyrSnowball) {
            final EntityZephyrSnowball ball2 = (EntityZephyrSnowball)ent;
            final double len = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
            ball2.accelerationX = motionX / len * 0.1;
            ball2.accelerationY = motionY / len * 0.1;
            ball2.accelerationZ = motionZ / len * 0.1;
        }
    }
    
    private Entity getShooter(final Entity ent) {
        return (Entity)((ent instanceof EntityArrow) ? ((EntityArrow)ent).shooter : ((ent instanceof EntityProjectile) ? ((EntityProjectile)ent).shooter : ((ent instanceof EntityProjectileBase) ? ((EntityProjectileBase)ent).shooter : ((ent instanceof EntityFireball) ? ((EntityFireball)ent).shooter : ((ent instanceof EntityZephyrSnowball) ? ((EntityZephyrSnowball)ent).shootingEntity : null)))));
    }
    
    private void setShooter(final Entity ent, final EntityLiving shooter) {
        if (ent instanceof EntityArrow) {
            ((EntityArrow)ent).shooter = (Entity)shooter;
        }
        else if (ent instanceof EntityProjectile) {
            ((EntityProjectile)ent).shooter = shooter;
        }
        else if (ent instanceof EntityProjectileBase) {
            ((EntityProjectileBase)ent).shooter = shooter;
        }
        else if (ent instanceof EntityFireball) {
            ((EntityFireball)ent).shooter = shooter;
        }
        else if (ent instanceof EntityZephyrSnowball) {
            ((EntityZephyrSnowball)ent).shootingEntity = shooter;
        }
    }
    
    private boolean isInGround(final Entity ent) {
        try {
            return (ent instanceof EntityArrow) ? ModLoader.getPrivateValue((Class)EntityArrow.class, (Object)ent, ReflectionHelper.obfuscation ? "aq" : "inGround") : ((ent instanceof EntityProjectile) ? ((EntityProjectile)ent).inGround : ((ent instanceof EntityProjectileBase) ? ((EntityProjectileBase)ent).inGround : ((ent instanceof EntityFireball) ? ModLoader.getPrivateValue((Class)EntityFireball.class, (Object)ent, ReflectionHelper.obfuscation ? "ap" : "inGround") : (ent instanceof EntityZephyrSnowball && ((EntityZephyrSnowball)ent).inGround))));
        }
        catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void afterOnUpdate() {
        if (this.inv.slots[2] != null && this.inv.slots[2].id == AetherItems.RepShield.id && (((Entity)super.player).onGround || (((Entity)super.player).vehicle != null && ((Entity)super.player).vehicle.onGround)) && ((EntityLiving)super.player).aX == 0.0f && ((EntityLiving)super.player).aW == 0.0f) {
            this.performRepShieldEffect();
        }
        final MobEffect effect = super.player.getEffect(MobEffectList.REGENERATION);
        if (effect != null && effect.getDuration() > 0 && MobEffectList.byId[effect.getEffectId()].b(effect.getDuration(), effect.getAmplifier()) && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth) {
            super.player.heal(1);
        }
        if (super.player.getFoodData().a() >= 18 && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                this.foodTimer = 0;
                super.player.heal(1);
            }
        }
        else {
            this.foodTimer = 0;
        }
        this.prevTimeInPortal = this.timeInPortal;
        if (this.inPortal) {
            if (!((Entity)super.player).world.isStatic && ((Entity)super.player).vehicle != null) {
                super.player.mount((Entity)null);
            }
            /*
            if (this.mc.currentScreen != null) {
                this.mc.displayGuiScreen((GuiScreen)null);
            }
            */
            if (this.timeInPortal == 0.0f) {
                //this.mc.sndManager.playSoundFX("portal.trigger", 1.0f, super.player.getRandField().nextFloat() * 0.4f + 0.8f);
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
                if (!((Entity)super.player).world.isStatic) {
                    this.timeUntilPortal = 10;
                    //this.mc.sndManager.playSoundFX("portal.travel", 1.0f, super.player.getRandField().nextFloat() * 0.4f + 0.8f);
                    final boolean var1 = false;
                    this.mc.usePortal(((BlockAetherPortal)AetherBlocks.Portal).getDimNumber(), (PortalTravelAgent)this.teleporter);
                }
            }
            this.inPortal = false;
        }
        else if (super.player.hasEffect(MobEffectList.CONFUSION) && super.player.getEffect(MobEffectList.CONFUSION).getDuration() > 60) {
            this.timeInPortal += 0.006666667f;
            if (this.timeInPortal > 1.0f) {
                this.timeInPortal = 1.0f;
            }
        }
        else {
            if (this.timeInPortal > 0.0f) {
                this.timeInPortal -= 0.05f;
            }
            if (this.timeInPortal < 0.0f) {
                this.timeInPortal = 0.0f;
            }
        }
        if (this.timeUntilPortal > 0) {
            --this.timeUntilPortal;
        }
        /*
        if (GuiMainMenu.mmactive) {
            super.player.setPosition(((Entity)super.player).lastTickPosX, ((Entity)super.player).lastTickPosY, ((Entity)super.player).lastTickPosZ);
        }
        */
        if (((Entity)super.player).ticksLived % 400 == 0) {
            if (this.inv.slots[0] != null && this.inv.slots[0].id == AetherItems.ZanitePendant.id) {
                this.inv.slots[0].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[0].count < 1) {
                    this.inv.slots[0] = null;
                }
            }
            if (this.inv.slots[4] != null && this.inv.slots[4].id == AetherItems.ZaniteRing.id) {
                this.inv.slots[4].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[4].count < 1) {
                    this.inv.slots[4] = null;
                }
            }
            if (this.inv.slots[5] != null && this.inv.slots[5].id == AetherItems.ZaniteRing.id) {
                this.inv.slots[5].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[5].count < 1) {
                    this.inv.slots[5] = null;
                }
            }
            if (this.inv.slots[0] != null && this.inv.slots[0].id == AetherItems.IcePendant.id) {
                this.inv.slots[0].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[0].count < 1) {
                    this.inv.slots[0] = null;
                }
            }
            if (this.inv.slots[4] != null && this.inv.slots[4].id == AetherItems.IceRing.id) {
                this.inv.slots[4].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[4].count < 1) {
                    this.inv.slots[4] = null;
                }
            }
            if (this.inv.slots[5] != null && this.inv.slots[5].id == AetherItems.IceRing.id) {
                this.inv.slots[5].damage(1, (EntityLiving)super.player);
                if (this.inv.slots[5].count < 1) {
                    this.inv.slots[5] = null;
                }
            }
        }
        if (((Entity)super.player).world.f == 0 && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth && ((Entity)super.player).ticksLived % 20 == 0) {
            super.player.heal(1);
        }
    }
    
    public boolean invisible() {
        return !((EntityHuman)super.player).t && this.inv.slots[1] != null && this.inv.slots[1].id == AetherItems.InvisibilityCloak.id;
    }
    
    @Override
    public void beforeWriteEntityToNBT(final NBTTagCompound tag) {
        if (!((Entity)super.player).world.isStatic) {
            this.writeCustomData(this.inv);
        }
    }
    
    private void writeCustomData(final InventoryAether inv) {
        if (((Entity)super.player).world.isStatic) {
            return;
        }
        final NBTTagCompound customData = new NBTTagCompound();
        customData.setByte("MaxHealth", (byte)this.maxHealth);
        customData.set("Inventory", (NBTBase)inv.writeToNBT(new NBTTagList()));
        try {
            final File file = new File(((WorldNBTStorage)((Entity)super.player).world.getDataManager()).getDirectory(), "aether.dat");
            NBTCompressedStreamTools.a(customData, (OutputStream)new FileOutputStream(file));
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to create player data", ioexception);
        }
    }
    
    @Override
    public void beforeReadEntityFromNBT(final NBTTagCompound tag) {
        if (!((Entity)super.player).world.isStatic) {
            this.readCustomData();
        }
    }
    
    private void readCustomData() {
        if (((Entity)super.player).world.isStatic) {
            return;
        }
        NBTTagCompound customData = new NBTTagCompound();
        try {
            final File file = new File(((WorldNBTStorage)((Entity)super.player).world.getDataManager()).getDirectory(), "aether.dat");
            customData = NBTCompressedStreamTools.a((InputStream)new FileInputStream(file));
            this.maxHealth = customData.getByte("MaxHealth");
            if (this.maxHealth < 20) {
                this.maxHealth = 20;
            }
            final NBTTagList nbttaglist = customData.getList("Inventory");
            this.inv.readFromNBT(nbttaglist);
        }
        catch (IOException ioexception) {
            System.out.println("Failed to read player data. Making new");
            this.maxHealth = 20;
        }
    }
    
    @Override
    public void setDead() {
    	/*
        if (GuiMainMenu.mmactive) {
            return;
        }
        */
        if (!((Entity)super.player).world.isStatic) {
            this.writeCustomData(new InventoryAether((EntityHuman)super.player));
        }
        super.setDead();
    }
    
    @Override
    public double getDistanceSq(final double var1, final double var3, final double var5) {
        return this.invisible() ? 1.0E40 : super.getDistanceSq(var1, var3, var5);
    }
    /*
    @Override
    public boolean isInWater() {
        return super.isInWater() && (!this.wearingNeptuneArmor() || super.player.getIsJumpingField());
    }
    */
    @Override
    public float getCurrentPlayerStrVsBlock(final Block block) {
        int f = -1;
        if (this.inv.slots[0] != null && this.inv.slots[0].id == AetherItems.ZanitePendant.id) {
            f *= (int)(1.0f + this.inv.slots[0].getData() / (this.inv.slots[0].i() * 3.0f));
        }
        if (this.inv.slots[4] != null && this.inv.slots[4].id == AetherItems.ZaniteRing.id) {
            f *= (int)(1.0f + this.inv.slots[4].getData() / (this.inv.slots[4].i() * 3.0f));
        }
        if (this.inv.slots[5] != null && this.inv.slots[5].id == AetherItems.ZaniteRing.id) {
            f *= (int)(1.0f + this.inv.slots[5].getData() / (this.inv.slots[5].i() * 3.0f));
        }
        return (f == -1) ? super.getCurrentPlayerStrVsBlock(block) : ((float)f);
    }
    
    private boolean wearingNeptuneArmor() {
        return ((EntityHuman)super.player).inventory.armor[3] != null && ((EntityHuman)super.player).inventory.armor[3].id == AetherItems.NeptuneHelmet.id && ((EntityHuman)super.player).inventory.armor[2] != null && ((EntityHuman)super.player).inventory.armor[2].id == AetherItems.NeptuneChestplate.id && ((EntityHuman)super.player).inventory.armor[1] != null && ((EntityHuman)super.player).inventory.armor[1].id == AetherItems.NeptuneLeggings.id && ((EntityHuman)super.player).inventory.armor[0] != null && ((EntityHuman)super.player).inventory.armor[0].id == AetherItems.NeptuneBoots.id && this.inv.slots[6] != null && this.inv.slots[6].id == AetherItems.NeptuneGlove.id;
    }
    
    @Override
    public MovingObjectPosition rayTrace(double var1, final float var3) {
        final ItemStack stack = super.player.U();
        if (stack != null && stack.getItem() != null && this.extendedReachItems.contains(stack.getItem())) {
            var1 = 10.0;
        }
        //return super.player.superRayTrace(var1, var3);
		return null;
        
    }
}
