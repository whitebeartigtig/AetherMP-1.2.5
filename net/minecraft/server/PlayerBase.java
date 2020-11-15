package net.minecraft.server;

import net.minecraft.server.*;

public abstract class PlayerBase
{
    protected final EntityPlayerSP player;
    private final PlayerAPI playerAPI;
    
    public PlayerBase(final PlayerAPI var1) {
        this.playerAPI = var1;
        this.player = var1.player;
    }
    
    public void beforeLocalConstructing(final MinecraftServer var1, final World var2, final Session var3, final int var4) {
    }
    
    public void afterLocalConstructing(final MinecraftServer var1, final World var2, final Session var3, final int var4) {
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    public void beforeAddExhaustion(final float var1) {
    }
    
    public void addExhaustion(final float var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenAddExhaustion(this);
        if (var2 == null) {
            this.player.localAddExhaustion(var1);
        }
        else if (var2 != this) {
            var2.addExhaustion(var1);
        }
    }
    
    public void afterAddExhaustion(final float var1) {
    }
    
    public void beforeAddMovementStat(final double var1, final double var3, final double var5) {
    }
    
    public void addMovementStat(final double var1, final double var3, final double var5) {
        final PlayerBase var6 = this.playerAPI.GetOverwrittenAddMovementStat(this);
        if (var6 == null) {
            this.player.localAddMovementStat(var1, var3, var5);
        }
        else if (var6 != this) {
            var6.addMovementStat(var1, var3, var5);
        }
    }
    
    public void afterAddMovementStat(final double var1, final double var3, final double var5) {
    }
    
    public void beforeAddStat(final Statistic var1, final int var2) {
    }
    
    public void addStat(final Statistic var1, final int var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenAddStat(this);
        if (var3 == null) {
            this.player.localAddStat(var1, var2);
        }
        else if (var3 != this) {
            var3.addStat(var1, var2);
        }
    }
    
    public void afterAddStat(final Statistic var1, final int var2) {
    }
    
    public void beforeAttackEntityFrom(final DamageSource var1, final int var2) {
    }
    
    public boolean attackEntityFrom(final DamageSource var1, final int var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean var4;
        if (var3 == null) {
            var4 = this.player.localAttackEntityFrom(var1, var2);
        }
        else {
            var4 = (var3 != this && var3.attackEntityFrom(var1, var2));
        }
        return var4;
    }
    
    public void afterAttackEntityFrom(final DamageSource var1, final int var2) {
    }
    
    public void beforeAlertWolves(final EntityLiving var1, final boolean var2) {
    }
    
    public void alertWolves(final EntityLiving var1, final boolean var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenAlertWolves(this);
        if (var3 == null) {
            this.player.localAlertWolves(var1, var2);
        }
        else if (var3 != this) {
            var3.alertWolves(var1, var2);
        }
    }
    
    public void afterAlertWolves(final EntityLiving var1, final boolean var2) {
    }
    
    public void beforeAttackTargetEntityWithCurrentItem(final Entity var1) {
    }
    
    public void attackTargetEntityWithCurrentItem(final Entity var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if (var2 == null) {
            this.player.localAttackTargetEntityWithCurrentItem(var1);
        }
        else if (var2 != this) {
            var2.attackTargetEntityWithCurrentItem(var1);
        }
    }
    
    public void afterAttackTargetEntityWithCurrentItem(final Entity var1) {
    }
    
    public void beforeCanBreatheUnderwater() {
    }
    
    public boolean canBreatheUnderwater() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenCanBreatheUnderwater(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localCanBreatheUnderwater();
        }
        else {
            var2 = (var1 != this && var1.canBreatheUnderwater());
        }
        return var2;
    }
    
    public void afterCanBreatheUnderwater() {
    }
    
    public void beforeCanHarvestBlock(final Block var1) {
    }
    
    public boolean canHarvestBlock(final Block var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean var3;
        if (var2 == null) {
            var3 = this.player.localCanHarvestBlock(var1);
        }
        else {
            var3 = (var2 != this && var2.canHarvestBlock(var1));
        }
        return var3;
    }
    
    public void afterCanHarvestBlock(final Block var1) {
    }
    
    public void beforeCanPlayerEdit(final int var1, final int var2, final int var3) {
    }
    
    public boolean canPlayerEdit(final int var1, final int var2, final int var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean var5;
        if (var4 == null) {
            var5 = this.player.localCanPlayerEdit(var1, var2, var3);
        }
        else {
            var5 = (var4 != this && var4.canPlayerEdit(var1, var2, var3));
        }
        return var5;
    }
    
    public void afterCanPlayerEdit(final int var1, final int var2, final int var3) {
    }
    
    public void beforeCanTriggerWalking() {
    }
    
    public boolean canTriggerWalking() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localCanTriggerWalking();
        }
        else {
            var2 = (var1 != this && var1.canTriggerWalking());
        }
        return var2;
    }
    
    public void afterCanTriggerWalking() {
    }
    
    public void beforeCloseScreen() {
    }
    
    public void closeScreen() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenCloseScreen(this);
        if (var1 == null) {
            this.player.localCloseScreen();
        }
        else if (var1 != this) {
            var1.closeScreen();
        }
    }
    
    public void afterCloseScreen() {
    }
    
    public void beforeDamageEntity(final DamageSource var1, final int var2) {
    }
    
    public void damageEntity(final DamageSource var1, final int var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenDamageEntity(this);
        if (var3 == null) {
            this.player.localDamageEntity(var1, var2);
        }
        else if (var3 != this) {
            var3.damageEntity(var1, var2);
        }
    }
    
    public void afterDamageEntity(final DamageSource var1, final int var2) {
    }
    
    public void beforeDisplayGUIBrewingStand(final TileEntityBrewingStand var1) {
    }
    
    public void displayGUIBrewingStand(final TileEntityBrewingStand var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDisplayGUIBrewingStand(this);
        if (var2 == null) {
            this.player.localDisplayGUIBrewingStand(var1);
        }
        else if (var2 != this) {
            var2.displayGUIBrewingStand(var1);
        }
    }
    
    public void afterDisplayGUIBrewingStand(final TileEntityBrewingStand var1) {
    }
    
    public void beforeDisplayGUIChest(final IInventory var1) {
    }
    
    public void displayGUIChest(final IInventory var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDisplayGUIChest(this);
        if (var2 == null) {
            this.player.localDisplayGUIChest(var1);
        }
        else if (var2 != this) {
            var2.displayGUIChest(var1);
        }
    }
    
    public void afterDisplayGUIChest(final IInventory var1) {
    }
    
    public void beforeDisplayGUIDispenser(final TileEntityDispenser var1) {
    }
    
    public void displayGUIDispenser(final TileEntityDispenser var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (var2 == null) {
            this.player.localDisplayGUIDispenser(var1);
        }
        else if (var2 != this) {
            var2.displayGUIDispenser(var1);
        }
    }
    
    public void afterDisplayGUIDispenser(final TileEntityDispenser var1) {
    }
    
    public void beforeDisplayGUIEditSign(final TileEntitySign var1) {
    }
    
    public void displayGUIEditSign(final TileEntitySign var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDisplayGUIEditSign(this);
        if (var2 == null) {
            this.player.localDisplayGUIEditSign(var1);
        }
        else if (var2 != this) {
            var2.displayGUIEditSign(var1);
        }
    }
    
    public void afterDisplayGUIEditSign(final TileEntitySign var1) {
    }
    
    public void beforeDisplayGUIEnchantment(final int var1, final int var2, final int var3) {
    }
    
    public void displayGUIEnchantment(final int var1, final int var2, final int var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenDisplayGUIEnchantment(this);
        if (var4 == null) {
            this.player.localDisplayGUIEnchantment(var1, var2, var3);
        }
        else if (var4 != this) {
            var4.displayGUIEnchantment(var1, var2, var3);
        }
    }
    
    public void afterDisplayGUIEnchantment(final int var1, final int var2, final int var3) {
    }
    
    public void beforeDisplayGUIFurnace(final TileEntityFurnace var1) {
    }
    
    public void displayGUIFurnace(final TileEntityFurnace var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (var2 == null) {
            this.player.localDisplayGUIFurnace(var1);
        }
        else if (var2 != this) {
            var2.displayGUIFurnace(var1);
        }
    }
    
    public void afterDisplayGUIFurnace(final TileEntityFurnace var1) {
    }
    
    public void beforeDisplayWorkbenchGUI(final int var1, final int var2, final int var3) {
    }
    
    public void displayWorkbenchGUI(final int var1, final int var2, final int var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenDisplayWorkbenchGUI(this);
        if (var4 == null) {
            this.player.localDisplayWorkbenchGUI(var1, var2, var3);
        }
        else if (var4 != this) {
            var4.displayWorkbenchGUI(var1, var2, var3);
        }
    }
    
    public void afterDisplayWorkbenchGUI(final int var1, final int var2, final int var3) {
    }
    
    public void beforeDropOneItem() {
    }
    
    public EntityItem dropOneItem() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenDropOneItem(this);
        EntityItem var2;
        if (var1 == null) {
            var2 = this.player.localDropOneItem();
        }
        else if (var1 != this) {
            var2 = var1.dropOneItem();
        }
        else {
            var2 = null;
        }
        return var2;
    }
    
    public void afterDropOneItem() {
    }
    
    public void beforeDropPlayerItem(final ItemStack var1) {
    }
    
    public EntityItem dropPlayerItem(final ItemStack var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem var3;
        if (var2 == null) {
            var3 = this.player.localDropPlayerItem(var1);
        }
        else if (var2 != this) {
            var3 = var2.dropPlayerItem(var1);
        }
        else {
            var3 = null;
        }
        return var3;
    }
    
    public void afterDropPlayerItem(final ItemStack var1) {
    }
    
    public void beforeDropPlayerItemWithRandomChoice(final ItemStack var1, final boolean var2) {
    }
    
    public EntityItem dropPlayerItemWithRandomChoice(final ItemStack var1, final boolean var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenDropPlayerItemWithRandomChoice(this);
        EntityItem var4;
        if (var3 == null) {
            var4 = this.player.localDropPlayerItemWithRandomChoice(var1, var2);
        }
        else if (var3 != this) {
            var4 = var3.dropPlayerItemWithRandomChoice(var1, var2);
        }
        else {
            var4 = null;
        }
        return var4;
    }
    
    public void afterDropPlayerItemWithRandomChoice(final ItemStack var1, final boolean var2) {
    }
    
    public void beforeFall(final float var1) {
    }
    
    public void fall(final float var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenFall(this);
        if (var2 == null) {
            this.player.localFall(var1);
        }
        else if (var2 != this) {
            var2.fall(var1);
        }
    }
    
    public void afterFall(final float var1) {
    }
    
    public void beforeGetBrightness(final float var1) {
    }
    
    public float getBrightness(final float var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenGetBrightness(this);
        float var3;
        if (var2 == null) {
            var3 = this.player.localGetBrightness(var1);
        }
        else if (var2 != this) {
            var3 = var2.getBrightness(var1);
        }
        else {
            var3 = 0.0f;
        }
        return var3;
    }
    
    public void afterGetBrightness(final float var1) {
    }
    
    public void beforeGetBrightnessForRender(final float var1) {
    }
    
    public int getBrightnessForRender(final float var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenGetBrightnessForRender(this);
        int var3;
        if (var2 == null) {
            var3 = this.player.localGetBrightnessForRender(var1);
        }
        else if (var2 != this) {
            var3 = var2.getBrightnessForRender(var1);
        }
        else {
            var3 = 0;
        }
        return var3;
    }
    
    public void afterGetBrightnessForRender(final float var1) {
    }
    
    public void beforeGetCurrentPlayerStrVsBlock(final Block var1) {
    }
    
    public float getCurrentPlayerStrVsBlock(final Block var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float var3;
        if (var2 == null) {
            var3 = this.player.localGetCurrentPlayerStrVsBlock(var1);
        }
        else if (var2 != this) {
            var3 = var2.getCurrentPlayerStrVsBlock(var1);
        }
        else {
            var3 = 0.0f;
        }
        return var3;
    }
    
    public void afterGetCurrentPlayerStrVsBlock(final Block var1) {
    }
    
    public void beforeGetDistanceSq(final double var1, final double var3, final double var5) {
    }
    
    public double getDistanceSq(final double var1, final double var3, final double var5) {
        final PlayerBase var6 = this.playerAPI.GetOverwrittenGetDistanceSq(this);
        double var7;
        if (var6 == null) {
            var7 = this.player.localGetDistanceSq(var1, var3, var5);
        }
        else if (var6 != this) {
            var7 = var6.getDistanceSq(var1, var3, var5);
        }
        else {
            var7 = 0.0;
        }
        return var7;
    }
    
    public void afterGetDistanceSq(final double var1, final double var3, final double var5) {
    }
    
    public void beforeGetDistanceSqToEntity(final Entity var1) {
    }
    
    public double getDistanceSqToEntity(final Entity var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenGetDistanceSqToEntity(this);
        double var3;
        if (var2 == null) {
            var3 = this.player.localGetDistanceSqToEntity(var1);
        }
        else if (var2 != this) {
            var3 = var2.getDistanceSqToEntity(var1);
        }
        else {
            var3 = 0.0;
        }
        return var3;
    }
    
    public void afterGetDistanceSqToEntity(final Entity var1) {
    }
    
    public void beforeGetFOVMultiplier() {
    }
    
    public float getFOVMultiplier() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenGetFOVMultiplier(this);
        float var2;
        if (var1 == null) {
            var2 = this.player.localGetFOVMultiplier();
        }
        else if (var1 != this) {
            var2 = var1.getFOVMultiplier();
        }
        else {
            var2 = 0.0f;
        }
        return var2;
    }
    
    public void afterGetFOVMultiplier() {
    }
    
    public void beforeGetHurtSound() {
    }
    
    public String getHurtSound() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenGetHurtSound(this);
        String var2;
        if (var1 == null) {
            var2 = this.player.localGetHurtSound();
        }
        else if (var1 != this) {
            var2 = var1.getHurtSound();
        }
        else {
            var2 = null;
        }
        return var2;
    }
    
    public void afterGetHurtSound() {
    }
    
    public void beforeGetItemIcon(final ItemStack var1, final int var2) {
    }
    
    public int getItemIcon(final ItemStack var1, final int var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenGetItemIcon(this);
        int var4;
        if (var3 == null) {
            var4 = this.player.localGetItemIcon(var1, var2);
        }
        else if (var3 != this) {
            var4 = var3.getItemIcon(var1, var2);
        }
        else {
            var4 = 0;
        }
        return var4;
    }
    
    public void afterGetItemIcon(final ItemStack var1, final int var2) {
    }
    
    public void beforeGetSleepTimer() {
    }
    
    public int getSleepTimer() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenGetSleepTimer(this);
        int var2;
        if (var1 == null) {
            var2 = this.player.localGetSleepTimer();
        }
        else if (var1 != this) {
            var2 = var1.getSleepTimer();
        }
        else {
            var2 = 0;
        }
        return var2;
    }
    
    public void afterGetSleepTimer() {
    }
    
    public void beforeGetSpeedModifier() {
    }
    
    public float getSpeedModifier() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenGetSpeedModifier(this);
        float var2;
        if (var1 == null) {
            var2 = this.player.localGetSpeedModifier();
        }
        else if (var1 != this) {
            var2 = var1.getSpeedModifier();
        }
        else {
            var2 = 0.0f;
        }
        return var2;
    }
    
    public void afterGetSpeedModifier() {
    }
    
    public void beforeHandleLavaMovement() {
    }
    
    public boolean handleLavaMovement() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenHandleLavaMovement(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localHandleLavaMovement();
        }
        else {
            var2 = (var1 != this && var1.handleLavaMovement());
        }
        return var2;
    }
    
    public void afterHandleLavaMovement() {
    }
    
    public void beforeHandleWaterMovement() {
    }
    
    public boolean handleWaterMovement() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenHandleWaterMovement(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localHandleWaterMovement();
        }
        else {
            var2 = (var1 != this && var1.handleWaterMovement());
        }
        return var2;
    }
    
    public void afterHandleWaterMovement() {
    }
    
    public void beforeHeal(final int var1) {
    }
    
    public void heal(final int var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenHeal(this);
        if (var2 == null) {
            this.player.localHeal(var1);
        }
        else if (var2 != this) {
            var2.heal(var1);
        }
    }
    
    public void afterHeal(final int var1) {
    }
    
    public void beforeIsEntityInsideOpaqueBlock() {
    }
    
    public boolean isEntityInsideOpaqueBlock() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localIsEntityInsideOpaqueBlock();
        }
        else {
            var2 = (var1 != this && var1.isEntityInsideOpaqueBlock());
        }
        return var2;
    }
    
    public void afterIsEntityInsideOpaqueBlock() {
    }
    
    public void beforeIsInWater() {
    }
    
    public boolean isInWater() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenIsInWater(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localIsInWater();
        }
        else {
            var2 = (var1 != this && var1.isInWater());
        }
        return var2;
    }
    
    public void afterIsInWater() {
    }
    
    public void beforeIsInsideOfMaterial(final Material var1) {
    }
    
    public boolean isInsideOfMaterial(final Material var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean var3;
        if (var2 == null) {
            var3 = this.player.localIsInsideOfMaterial(var1);
        }
        else {
            var3 = (var2 != this && var2.isInsideOfMaterial(var1));
        }
        return var3;
    }
    
    public void afterIsInsideOfMaterial(final Material var1) {
    }
    
    public void beforeIsOnLadder() {
    }
    
    public boolean isOnLadder() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenIsOnLadder(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localIsOnLadder();
        }
        else {
            var2 = (var1 != this && var1.isOnLadder());
        }
        return var2;
    }
    
    public void afterIsOnLadder() {
    }
    
    public void beforeIsSneaking() {
    }
    
    public boolean isSneaking() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenIsSneaking(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localIsSneaking();
        }
        else {
            var2 = (var1 != this && var1.isSneaking());
        }
        return var2;
    }
    
    public void afterIsSneaking() {
    }
    
    public void beforeIsSprinting() {
    }
    
    public boolean isSprinting() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenIsSprinting(this);
        boolean var2;
        if (var1 == null) {
            var2 = this.player.localIsSprinting();
        }
        else {
            var2 = (var1 != this && var1.isSprinting());
        }
        return var2;
    }
    
    public void afterIsSprinting() {
    }
    
    public void beforeJump() {
    }
    
    public void jump() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenJump(this);
        if (var1 == null) {
            this.player.localJump();
        }
        else if (var1 != this) {
            var1.jump();
        }
    }
    
    public void afterJump() {
    }
    
    public void beforeKnockBack(final Entity var1, final int var2, final double var3, final double var5) {
    }
    
    public void knockBack(final Entity var1, final int var2, final double var3, final double var5) {
        final PlayerBase var6 = this.playerAPI.GetOverwrittenKnockBack(this);
        if (var6 == null) {
            this.player.localKnockBack(var1, var2, var3, var5);
        }
        else if (var6 != this) {
            var6.knockBack(var1, var2, var3, var5);
        }
    }
    
    public void afterKnockBack(final Entity var1, final int var2, final double var3, final double var5) {
    }
    
    public void beforeMoveEntity(final double var1, final double var3, final double var5) {
    }
    
    public void moveEntity(final double var1, final double var3, final double var5) {
        final PlayerBase var6 = this.playerAPI.GetOverwrittenMoveEntity(this);
        if (var6 == null) {
            this.player.localMoveEntity(var1, var3, var5);
        }
        else if (var6 != this) {
            var6.moveEntity(var1, var3, var5);
        }
    }
    
    public void afterMoveEntity(final double var1, final double var3, final double var5) {
    }
    
    public void beforeMoveEntityWithHeading(final float var1, final float var2) {
    }
    
    public void moveEntityWithHeading(final float var1, final float var2) {
        final PlayerBase var3 = this.playerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if (var3 == null) {
            this.player.localMoveEntityWithHeading(var1, var2);
        }
        else if (var3 != this) {
            var3.moveEntityWithHeading(var1, var2);
        }
    }
    
    public void afterMoveEntityWithHeading(final float var1, final float var2) {
    }
    
    public void beforeMoveFlying(final float var1, final float var2, final float var3) {
    }
    
    public void moveFlying(final float var1, final float var2, final float var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenMoveFlying(this);
        if (var4 == null) {
            this.player.localMoveFlying(var1, var2, var3);
        }
        else if (var4 != this) {
            var4.moveFlying(var1, var2, var3);
        }
    }
    
    public void afterMoveFlying(final float var1, final float var2, final float var3) {
    }
    
    public void beforeOnDeath(final DamageSource var1) {
    }
    
    public void onDeath(final DamageSource var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenOnDeath(this);
        if (var2 == null) {
            this.player.localOnDeath(var1);
        }
        else if (var2 != this) {
            var2.onDeath(var1);
        }
    }
    
    public void afterOnDeath(final DamageSource var1) {
    }
    
    public void beforeOnLivingUpdate() {
    }
    
    public void onLivingUpdate() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenOnLivingUpdate(this);
        if (var1 == null) {
            this.player.localOnLivingUpdate();
        }
        else if (var1 != this) {
            var1.onLivingUpdate();
        }
    }
    
    public void afterOnLivingUpdate() {
    }
    
    public void beforeOnKillEntity(final EntityLiving var1) {
    }
    
    public void onKillEntity(final EntityLiving var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenOnKillEntity(this);
        if (var2 == null) {
            this.player.localOnKillEntity(var1);
        }
        else if (var2 != this) {
            var2.onKillEntity(var1);
        }
    }
    
    public void afterOnKillEntity(final EntityLiving var1) {
    }
    
    public void beforeOnUpdate() {
    }
    
    public void onUpdate() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenOnUpdate(this);
        if (var1 == null) {
            this.player.localOnUpdate();
        }
        else if (var1 != this) {
            var1.onUpdate();
        }
    }
    
    public void afterOnUpdate() {
    }
    
    public void beforePlayStepSound(final int var1, final int var2, final int var3, final int var4) {
    }
    
    public void playStepSound(final int var1, final int var2, final int var3, final int var4) {
        final PlayerBase var5 = this.playerAPI.GetOverwrittenPlayStepSound(this);
        if (var5 == null) {
            this.player.localPlayStepSound(var1, var2, var3, var4);
        }
        else if (var5 != this) {
            var5.playStepSound(var1, var2, var3, var4);
        }
    }
    
    public void afterPlayStepSound(final int var1, final int var2, final int var3, final int var4) {
    }
    
    public void beforePushOutOfBlocks(final double var1, final double var3, final double var5) {
    }
    
    public boolean pushOutOfBlocks(final double var1, final double var3, final double var5) {
        final PlayerBase var6 = this.playerAPI.GetOverwrittenPushOutOfBlocks(this);
        boolean var7;
        if (var6 == null) {
            var7 = this.player.localPushOutOfBlocks(var1, var3, var5);
        }
        else {
            var7 = (var6 != this && var6.pushOutOfBlocks(var1, var3, var5));
        }
        return var7;
    }
    
    public void afterPushOutOfBlocks(final double var1, final double var3, final double var5) {
    }
    
    public void beforeRayTrace(final double var1, final float var3) {
    }
    
    public MovingObjectPosition rayTrace(final double var1, final float var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenRayTrace(this);
        MovingObjectPosition var5;
        if (var4 == null) {
            var5 = this.player.localRayTrace(var1, var3);
        }
        else if (var4 != this) {
            var5 = var4.rayTrace(var1, var3);
        }
        else {
            var5 = null;
        }
        return var5;
    }
    
    public void afterRayTrace(final double var1, final float var3) {
    }
    
    public void beforeReadEntityFromNBT(final NBTTagCompound var1) {
    }
    
    public void readEntityFromNBT(final NBTTagCompound var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (var2 == null) {
            this.player.localReadEntityFromNBT(var1);
        }
        else if (var2 != this) {
            var2.readEntityFromNBT(var1);
        }
    }
    
    public void afterReadEntityFromNBT(final NBTTagCompound var1) {
    }
    
    public void beforeRespawnPlayer() {
    }
    
    public void respawnPlayer() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenRespawnPlayer(this);
        if (var1 == null) {
            this.player.localRespawnPlayer();
        }
        else if (var1 != this) {
            var1.respawnPlayer();
        }
    }
    
    public void afterRespawnPlayer() {
    }
    
    public void beforeSendChatMessage(final String var1) {
    }
    
    public void sendChatMessage(final String var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenSendChatMessage(this);
        if (var2 == null) {
            this.player.localSendChatMessage(var1);
        }
        else if (var2 != this) {
            var2.sendChatMessage(var1);
        }
    }
    
    public void afterSendChatMessage(final String var1) {
    }
    
    public void beforeSetDead() {
    }
    
    public void setDead() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenSetDead(this);
        if (var1 == null) {
            this.player.localSetDead();
        }
        else if (var1 != this) {
            var1.setDead();
        }
    }
    
    public void afterSetDead() {
    }
    
    public void beforeSetPositionAndRotation(final double var1, final double var3, final double var5, final float var7, final float var8) {
    }
    
    public void setPositionAndRotation(final double var1, final double var3, final double var5, final float var7, final float var8) {
        final PlayerBase var9 = this.playerAPI.GetOverwrittenSetPositionAndRotation(this);
        if (var9 == null) {
            this.player.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        }
        else if (var9 != this) {
            var9.setPositionAndRotation(var1, var3, var5, var7, var8);
        }
    }
    
    public void afterSetPositionAndRotation(final double var1, final double var3, final double var5, final float var7, final float var8) {
    }
    
    public void beforeSleepInBedAt(final int var1, final int var2, final int var3) {
    }
    
    public EnumStatus sleepInBedAt(final int var1, final int var2, final int var3) {
        final PlayerBase var4 = this.playerAPI.GetOverwrittenSleepInBedAt(this);
        EnumStatus var5;
        if (var4 == null) {
            var5 = this.player.localSleepInBedAt(var1, var2, var3);
        }
        else if (var4 != this) {
            var5 = var4.sleepInBedAt(var1, var2, var3);
        }
        else {
            var5 = null;
        }
        return var5;
    }
    
    public void afterSleepInBedAt(final int var1, final int var2, final int var3) {
    }
    
    public void beforeSwingItem() {
    }
    
    public void swingItem() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenSwingItem(this);
        if (var1 == null) {
            this.player.localSwingItem();
        }
        else if (var1 != this) {
            var1.swingItem();
        }
    }
    
    public void afterSwingItem() {
    }
    
    public void beforeUpdateEntityActionState() {
    }
    
    public void updateEntityActionState() {
        final PlayerBase var1 = this.playerAPI.GetOverwrittenUpdateEntityActionState(this);
        if (var1 == null) {
            this.player.localUpdateEntityActionState();
        }
        else if (var1 != this) {
            var1.updateEntityActionState();
        }
    }
    
    public void afterUpdateEntityActionState() {
    }
    
    public void beforeWriteEntityToNBT(final NBTTagCompound var1) {
    }
    
    public void writeEntityToNBT(final NBTTagCompound var1) {
        final PlayerBase var2 = this.playerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (var2 == null) {
            this.player.localWriteEntityToNBT(var1);
        }
        else if (var2 != this) {
            var2.writeEntityToNBT(var1);
        }
    }
    
    public void afterWriteEntityToNBT(final NBTTagCompound var1) {
    }
}
