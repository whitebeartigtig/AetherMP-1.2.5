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
    public Minecraft mc;
    public int foodTimer;
    public TeleporterAether teleporter;
    public int maxHealth;
    public InventoryAether inv;
    public List extendedReachItems;
    
    public PlayerBaseAether(final PlayerAPI p) {
        super(p);
        this.timeUntilPortal = 20;
        this.inPortal = false;
        this.mc = ModLoader.getMinecraftInstance();
        this.teleporter = new TeleporterAether();
        this.extendedReachItems = Arrays.asList(AetherItems.ShovelValkyrie, AetherItems.PickValkyrie, AetherItems.AxeValkyrie, AetherItems.Lance);
        this.maxHealth = 20;
        this.inv = new InventoryAether((EntityPlayer)super.player);
        if (!((Entity)super.player).worldObj.isRemote) {
            ((EntityPlayer)super.player).inventorySlots = (Container)new ContainerAether(((EntityPlayer)super.player).inventory, this.inv, !((Entity)super.player).worldObj.isRemote);
            ((EntityPlayer)super.player).craftingInventory = ((EntityPlayer)super.player).inventorySlots;
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
        ((Entity)super.player).heartsLife = ((EntityLiving)super.player).heartsHalvesLife / 2;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource var1, final int var2) {
        if (GuiMainMenu.mmactive) {
            final Entity attacker = var1.getEntity();
            if (attacker != null) {
                attacker.attackEntityFrom(DamageSource.causeMobDamage((EntityLiving)attacker), var2);
            }
            return true;
        }
        return super.attackEntityFrom(var1, var2);
    }
    
    @Override
    public void beforeOnUpdate() {
        if (this.isAboveBlock(AetherBlocks.Aercloud.blockID)) {
            ((Entity)super.player).fallDistance = 0.0f;
        }
    }
    
    public boolean isAboveBlock(final int blockID) {
        final int x = MathHelper.floor_double(((Entity)super.player).posX);
        final int y = MathHelper.floor_double(((Entity)super.player).boundingBox.minY);
        final int z = MathHelper.floor_double(((Entity)super.player).posZ);
        return ((Entity)super.player).worldObj.getBlockId(MathHelper.floor_double(((Entity)super.player).boundingBox.minX), y - 1, MathHelper.floor_double(((Entity)super.player).boundingBox.minZ)) == blockID || ((Entity)super.player).worldObj.getBlockId(MathHelper.floor_double(((Entity)super.player).boundingBox.maxX), y - 1, MathHelper.floor_double(((Entity)super.player).boundingBox.minZ)) == blockID || ((Entity)super.player).worldObj.getBlockId(MathHelper.floor_double(((Entity)super.player).boundingBox.maxX), y - 1, MathHelper.floor_double(((Entity)super.player).boundingBox.maxZ)) == blockID || ((Entity)super.player).worldObj.getBlockId(MathHelper.floor_double(((Entity)super.player).boundingBox.minX), y - 1, MathHelper.floor_double(((Entity)super.player).boundingBox.maxZ)) == blockID;
    }
    
    private void performRepShieldEffect() {
        final ItemStack stack = this.inv.slots[2];
        final List ents = ((Entity)super.player).worldObj.getEntitiesWithinAABBExcludingEntity((Entity)super.player, ((Entity)super.player).boundingBox.expand(4.0, 4.0, 4.0));
        for (final Object o : ents) {
            final Entity ent = (Entity)o;
            if (!(ent instanceof EntityArrow) && !(ent instanceof EntityThrowable) && !(ent instanceof EntityProjectileBase) && !(ent instanceof EntityFireball) && !(ent instanceof EntityZephyrSnowball)) {
                continue;
            }
            final double distsq = super.player.getDistanceSqToEntity(ent);
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
                a = ent.posX - dick.posX;
                b = ent.boundingBox.minY - dick.boundingBox.minY;
                c = ent.posZ - dick.posZ;
            }
            else {
                a = ((Entity)super.player).posX - ent.posX;
                b = ((Entity)super.player).posY - ent.posY;
                c = ((Entity)super.player).posZ - ent.posZ;
            }
            final double d = Math.sqrt(a * a + b * b + c * c);
            a /= -d;
            b /= -d;
            c /= -d;
            ent.motionX = a * 0.75;
            ent.motionY = b * 0.75 + 0.05;
            ent.motionZ = c * 0.75;
            this.setHeading(ent, ent.motionX, ent.motionY, ent.motionZ, 0.8f, 0.5f);
            ((Entity)super.player).worldObj.playSoundAtEntity(ent, "note.snare", 1.0f, ((((Entity)super.player).rand.nextFloat() - ((Entity)super.player).rand.nextFloat()) * 0.4f + 0.8f) * 1.1f);
            for (int k = 0; k < 12; ++k) {
                double d2 = -ent.motionX * 0.15000000596046448 + (ent.rand.nextFloat() - 0.5f) * 0.05f;
                double e1 = -ent.motionY * 0.15000000596046448 + (ent.rand.nextFloat() - 0.5f) * 0.05f;
                double f1 = -ent.motionZ * 0.15000000596046448 + (ent.rand.nextFloat() - 0.5f) * 0.05f;
                d2 *= 0.625;
                e1 *= 0.625;
                f1 *= 0.625;
                ((Entity)super.player).worldObj.spawnParticle("flame", ent.posX, ent.posY, ent.posZ, d2, e1, f1);
            }
            stack.damageItem(1, (EntityLiving)super.player);
            if (stack.getItemDamage() != AetherItems.RepShield.getMaxDamage()) {
                continue;
            }
            this.inv.slots[2] = null;
        }
    }
    
    private void setHeading(final Entity ent, final double motionX, final double motionY, final double motionZ, final float f1, final float f2) {
        if (ent instanceof EntityArrow) {
            ((EntityArrow)ent).setArrowHeading(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityThrowable) {
            ((EntityThrowable)ent).setThrowableHeading(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityProjectileBase) {
            ((EntityProjectileBase)ent).setArrowHeading(motionX, motionY, motionZ, f1, f2);
        }
        else if (ent instanceof EntityFireball) {
            final EntityFireball ball = (EntityFireball)ent;
            final double len = Math.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
            ball.accelerationX = motionX / len * 0.1;
            ball.accelerationY = motionY / len * 0.1;
            ball.accelerationZ = motionZ / len * 0.1;
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
        return (Entity)((ent instanceof EntityArrow) ? ((EntityArrow)ent).shootingEntity : ((ent instanceof EntityThrowable) ? ((EntityThrowable)ent).thrower : ((ent instanceof EntityProjectileBase) ? ((EntityProjectileBase)ent).shooter : ((ent instanceof EntityFireball) ? ((EntityFireball)ent).shootingEntity : ((ent instanceof EntityZephyrSnowball) ? ((EntityZephyrSnowball)ent).shootingEntity : null)))));
    }
    
    private void setShooter(final Entity ent, final EntityLiving shooter) {
        if (ent instanceof EntityArrow) {
            ((EntityArrow)ent).shootingEntity = (Entity)shooter;
        }
        else if (ent instanceof EntityThrowable) {
            ((EntityThrowable)ent).thrower = shooter;
        }
        else if (ent instanceof EntityProjectileBase) {
            ((EntityProjectileBase)ent).shooter = shooter;
        }
        else if (ent instanceof EntityFireball) {
            ((EntityFireball)ent).shootingEntity = shooter;
        }
        else if (ent instanceof EntityZephyrSnowball) {
            ((EntityZephyrSnowball)ent).shootingEntity = shooter;
        }
    }
    
    private boolean isInGround(final Entity ent) {
        try {
            return (ent instanceof EntityArrow) ? ModLoader.getPrivateValue((Class)EntityArrow.class, (Object)ent, ReflectionHelper.obfuscation ? "aq" : "inGround") : ((ent instanceof EntityThrowable) ? ((EntityThrowable)ent).inGround : ((ent instanceof EntityProjectileBase) ? ((EntityProjectileBase)ent).inGround : ((ent instanceof EntityFireball) ? ModLoader.getPrivateValue((Class)EntityFireball.class, (Object)ent, ReflectionHelper.obfuscation ? "ap" : "inGround") : (ent instanceof EntityZephyrSnowball && ((EntityZephyrSnowball)ent).inGround))));
        }
        catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public void afterOnUpdate() {
        if (this.inv.slots[2] != null && this.inv.slots[2].itemID == AetherItems.RepShield.shiftedIndex && (((Entity)super.player).onGround || (((Entity)super.player).ridingEntity != null && ((Entity)super.player).ridingEntity.onGround)) && ((EntityLiving)super.player).moveForward == 0.0f && ((EntityLiving)super.player).moveStrafing == 0.0f) {
            this.performRepShieldEffect();
        }
        final PotionEffect effect = super.player.getActivePotionEffect(Potion.regeneration);
        if (effect != null && effect.getDuration() > 0 && Potion.potionTypes[effect.getPotionID()].isReady(effect.getDuration(), effect.getAmplifier()) && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth) {
            super.player.heal(1);
        }
        if (super.player.getFoodStats().getFoodLevel() >= 18 && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth) {
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
            if (!((Entity)super.player).worldObj.isRemote && ((Entity)super.player).ridingEntity != null) {
                super.player.mountEntity((Entity)null);
            }
            if (this.mc.currentScreen != null) {
                this.mc.displayGuiScreen((GuiScreen)null);
            }
            if (this.timeInPortal == 0.0f) {
                this.mc.sndManager.playSoundFX("portal.trigger", 1.0f, super.player.getRandField().nextFloat() * 0.4f + 0.8f);
            }
            this.timeInPortal += 0.0125f;
            if (this.timeInPortal >= 1.0f) {
                this.timeInPortal = 1.0f;
                if (!((Entity)super.player).worldObj.isRemote) {
                    this.timeUntilPortal = 10;
                    this.mc.sndManager.playSoundFX("portal.travel", 1.0f, super.player.getRandField().nextFloat() * 0.4f + 0.8f);
                    final boolean var1 = false;
                    this.mc.usePortal(((BlockAetherPortal)AetherBlocks.Portal).getDimNumber(), (Teleporter)this.teleporter);
                }
            }
            this.inPortal = false;
        }
        else if (super.player.isPotionActive(Potion.confusion) && super.player.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
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
        if (GuiMainMenu.mmactive) {
            super.player.setPosition(((Entity)super.player).lastTickPosX, ((Entity)super.player).lastTickPosY, ((Entity)super.player).lastTickPosZ);
        }
        if (((Entity)super.player).ticksExisted % 400 == 0) {
            if (this.inv.slots[0] != null && this.inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex) {
                this.inv.slots[0].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[0].stackSize < 1) {
                    this.inv.slots[0] = null;
                }
            }
            if (this.inv.slots[4] != null && this.inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex) {
                this.inv.slots[4].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[4].stackSize < 1) {
                    this.inv.slots[4] = null;
                }
            }
            if (this.inv.slots[5] != null && this.inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex) {
                this.inv.slots[5].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[5].stackSize < 1) {
                    this.inv.slots[5] = null;
                }
            }
            if (this.inv.slots[0] != null && this.inv.slots[0].itemID == AetherItems.IcePendant.shiftedIndex) {
                this.inv.slots[0].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[0].stackSize < 1) {
                    this.inv.slots[0] = null;
                }
            }
            if (this.inv.slots[4] != null && this.inv.slots[4].itemID == AetherItems.IceRing.shiftedIndex) {
                this.inv.slots[4].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[4].stackSize < 1) {
                    this.inv.slots[4] = null;
                }
            }
            if (this.inv.slots[5] != null && this.inv.slots[5].itemID == AetherItems.IceRing.shiftedIndex) {
                this.inv.slots[5].damageItem(1, (EntityLiving)super.player);
                if (this.inv.slots[5].stackSize < 1) {
                    this.inv.slots[5] = null;
                }
            }
        }
        if (((Entity)super.player).worldObj.difficultySetting == 0 && super.player.getHealth() >= 20 && super.player.getHealth() < this.maxHealth && ((Entity)super.player).ticksExisted % 20 == 0) {
            super.player.heal(1);
        }
    }
    
    public boolean invisible() {
        return !((EntityPlayer)super.player).isSwinging && this.inv.slots[1] != null && this.inv.slots[1].itemID == AetherItems.InvisibilityCloak.shiftedIndex;
    }
    
    @Override
    public void beforeWriteEntityToNBT(final NBTTagCompound tag) {
        if (!((Entity)super.player).worldObj.isRemote) {
            this.writeCustomData(this.inv);
        }
    }
    
    private void writeCustomData(final InventoryAether inv) {
        if (((Entity)super.player).worldObj.isRemote) {
            return;
        }
        final NBTTagCompound customData = new NBTTagCompound();
        customData.setByte("MaxHealth", (byte)this.maxHealth);
        customData.setTag("Inventory", (NBTBase)inv.writeToNBT(new NBTTagList()));
        try {
            final File file = new File(((SaveHandler)((Entity)super.player).worldObj.getSaveHandler()).getSaveDirectory(), "aether.dat");
            CompressedStreamTools.writeCompressed(customData, (OutputStream)new FileOutputStream(file));
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to create player data", ioexception);
        }
    }
    
    @Override
    public void beforeReadEntityFromNBT(final NBTTagCompound tag) {
        if (!((Entity)super.player).worldObj.isRemote) {
            this.readCustomData();
        }
    }
    
    private void readCustomData() {
        if (((Entity)super.player).worldObj.isRemote) {
            return;
        }
        NBTTagCompound customData = new NBTTagCompound();
        try {
            final File file = new File(((SaveHandler)((Entity)super.player).worldObj.getSaveHandler()).getSaveDirectory(), "aether.dat");
            customData = CompressedStreamTools.readCompressed((InputStream)new FileInputStream(file));
            this.maxHealth = customData.getByte("MaxHealth");
            if (this.maxHealth < 20) {
                this.maxHealth = 20;
            }
            final NBTTagList nbttaglist = customData.getTagList("Inventory");
            this.inv.readFromNBT(nbttaglist);
        }
        catch (IOException ioexception) {
            System.out.println("Failed to read player data. Making new");
            this.maxHealth = 20;
        }
    }
    
    @Override
    public void setDead() {
        if (GuiMainMenu.mmactive) {
            return;
        }
        if (!((Entity)super.player).worldObj.isRemote) {
            this.writeCustomData(new InventoryAether((EntityPlayer)super.player));
        }
        super.setDead();
    }
    
    @Override
    public double getDistanceSq(final double var1, final double var3, final double var5) {
        return this.invisible() ? 1.0E40 : super.getDistanceSq(var1, var3, var5);
    }
    
    @Override
    public boolean isInWater() {
        return super.isInWater() && (!this.wearingNeptuneArmor() || super.player.getIsJumpingField());
    }
    
    @Override
    public float getCurrentPlayerStrVsBlock(final Block block) {
        int f = -1;
        if (this.inv.slots[0] != null && this.inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex) {
            f *= (int)(1.0f + this.inv.slots[0].getItemDamage() / (this.inv.slots[0].getMaxDamage() * 3.0f));
        }
        if (this.inv.slots[4] != null && this.inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex) {
            f *= (int)(1.0f + this.inv.slots[4].getItemDamage() / (this.inv.slots[4].getMaxDamage() * 3.0f));
        }
        if (this.inv.slots[5] != null && this.inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex) {
            f *= (int)(1.0f + this.inv.slots[5].getItemDamage() / (this.inv.slots[5].getMaxDamage() * 3.0f));
        }
        return (f == -1) ? super.getCurrentPlayerStrVsBlock(block) : ((float)f);
    }
    
    private boolean wearingNeptuneArmor() {
        return ((EntityPlayer)super.player).inventory.armorInventory[3] != null && ((EntityPlayer)super.player).inventory.armorInventory[3].itemID == AetherItems.NeptuneHelmet.shiftedIndex && ((EntityPlayer)super.player).inventory.armorInventory[2] != null && ((EntityPlayer)super.player).inventory.armorInventory[2].itemID == AetherItems.NeptuneChestplate.shiftedIndex && ((EntityPlayer)super.player).inventory.armorInventory[1] != null && ((EntityPlayer)super.player).inventory.armorInventory[1].itemID == AetherItems.NeptuneLeggings.shiftedIndex && ((EntityPlayer)super.player).inventory.armorInventory[0] != null && ((EntityPlayer)super.player).inventory.armorInventory[0].itemID == AetherItems.NeptuneBoots.shiftedIndex && this.inv.slots[6] != null && this.inv.slots[6].itemID == AetherItems.NeptuneGlove.shiftedIndex;
    }
    
    @Override
    public MovingObjectPosition rayTrace(double var1, final float var3) {
        final ItemStack stack = super.player.getCurrentEquippedItem();
        if (stack != null && stack.getItem() != null && this.extendedReachItems.contains(stack.getItem())) {
            var1 = 10.0;
        }
        return super.player.superRayTrace(var1, var3);
    }
}
