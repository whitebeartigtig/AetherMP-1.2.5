package net.minecraft.server;

import java.util.logging.*;
import net.minecraft.server.*;
import java.lang.reflect.*;
import java.util.*;

public final class PlayerAPI
{
    private static final Class[] Class;
    private static final Class[] Classes;
    private static boolean isCreated;
    private static final Logger logger;
    private static final List beforeAddExhaustionHookTypes;
    private static final List overrideAddExhaustionHookTypes;
    private static final List afterAddExhaustionHookTypes;
    private final PlayerBase[] beforeAddExhaustionHooks;
    private final PlayerBase[] overrideAddExhaustionHooks;
    private final PlayerBase[] afterAddExhaustionHooks;
    protected final boolean isAddExhaustionModded;
    private static final List beforeAddMovementStatHookTypes;
    private static final List overrideAddMovementStatHookTypes;
    private static final List afterAddMovementStatHookTypes;
    private final PlayerBase[] beforeAddMovementStatHooks;
    private final PlayerBase[] overrideAddMovementStatHooks;
    private final PlayerBase[] afterAddMovementStatHooks;
    protected final boolean isAddMovementStatModded;
    private static final List beforeAddStatHookTypes;
    private static final List overrideAddStatHookTypes;
    private static final List afterAddStatHookTypes;
    private final PlayerBase[] beforeAddStatHooks;
    private final PlayerBase[] overrideAddStatHooks;
    private final PlayerBase[] afterAddStatHooks;
    protected final boolean isAddStatModded;
    private static final List beforeAttackEntityFromHookTypes;
    private static final List overrideAttackEntityFromHookTypes;
    private static final List afterAttackEntityFromHookTypes;
    private final PlayerBase[] beforeAttackEntityFromHooks;
    private final PlayerBase[] overrideAttackEntityFromHooks;
    private final PlayerBase[] afterAttackEntityFromHooks;
    protected final boolean isAttackEntityFromModded;
    private static final List beforeAlertWolvesHookTypes;
    private static final List overrideAlertWolvesHookTypes;
    private static final List afterAlertWolvesHookTypes;
    private final PlayerBase[] beforeAlertWolvesHooks;
    private final PlayerBase[] overrideAlertWolvesHooks;
    private final PlayerBase[] afterAlertWolvesHooks;
    protected final boolean isAlertWolvesModded;
    private static final List beforeAttackTargetEntityWithCurrentItemHookTypes;
    private static final List overrideAttackTargetEntityWithCurrentItemHookTypes;
    private static final List afterAttackTargetEntityWithCurrentItemHookTypes;
    private final PlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
    private final PlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
    private final PlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
    protected final boolean isAttackTargetEntityWithCurrentItemModded;
    private static final List beforeCanBreatheUnderwaterHookTypes;
    private static final List overrideCanBreatheUnderwaterHookTypes;
    private static final List afterCanBreatheUnderwaterHookTypes;
    private final PlayerBase[] beforeCanBreatheUnderwaterHooks;
    private final PlayerBase[] overrideCanBreatheUnderwaterHooks;
    private final PlayerBase[] afterCanBreatheUnderwaterHooks;
    protected final boolean isCanBreatheUnderwaterModded;
    private static final List beforeCanHarvestBlockHookTypes;
    private static final List overrideCanHarvestBlockHookTypes;
    private static final List afterCanHarvestBlockHookTypes;
    private final PlayerBase[] beforeCanHarvestBlockHooks;
    private final PlayerBase[] overrideCanHarvestBlockHooks;
    private final PlayerBase[] afterCanHarvestBlockHooks;
    protected final boolean isCanHarvestBlockModded;
    private static final List beforeCanPlayerEditHookTypes;
    private static final List overrideCanPlayerEditHookTypes;
    private static final List afterCanPlayerEditHookTypes;
    private final PlayerBase[] beforeCanPlayerEditHooks;
    private final PlayerBase[] overrideCanPlayerEditHooks;
    private final PlayerBase[] afterCanPlayerEditHooks;
    protected final boolean isCanPlayerEditModded;
    private static final List beforeCanTriggerWalkingHookTypes;
    private static final List overrideCanTriggerWalkingHookTypes;
    private static final List afterCanTriggerWalkingHookTypes;
    private final PlayerBase[] beforeCanTriggerWalkingHooks;
    private final PlayerBase[] overrideCanTriggerWalkingHooks;
    private final PlayerBase[] afterCanTriggerWalkingHooks;
    protected final boolean isCanTriggerWalkingModded;
    private static final List beforeCloseScreenHookTypes;
    private static final List overrideCloseScreenHookTypes;
    private static final List afterCloseScreenHookTypes;
    private final PlayerBase[] beforeCloseScreenHooks;
    private final PlayerBase[] overrideCloseScreenHooks;
    private final PlayerBase[] afterCloseScreenHooks;
    protected final boolean isCloseScreenModded;
    private static final List beforeDamageEntityHookTypes;
    private static final List overrideDamageEntityHookTypes;
    private static final List afterDamageEntityHookTypes;
    private final PlayerBase[] beforeDamageEntityHooks;
    private final PlayerBase[] overrideDamageEntityHooks;
    private final PlayerBase[] afterDamageEntityHooks;
    protected final boolean isDamageEntityModded;
    private static final List beforeDisplayGUIBrewingStandHookTypes;
    private static final List overrideDisplayGUIBrewingStandHookTypes;
    private static final List afterDisplayGUIBrewingStandHookTypes;
    private final PlayerBase[] beforeDisplayGUIBrewingStandHooks;
    private final PlayerBase[] overrideDisplayGUIBrewingStandHooks;
    private final PlayerBase[] afterDisplayGUIBrewingStandHooks;
    protected final boolean isDisplayGUIBrewingStandModded;
    private static final List beforeDisplayGUIChestHookTypes;
    private static final List overrideDisplayGUIChestHookTypes;
    private static final List afterDisplayGUIChestHookTypes;
    private final PlayerBase[] beforeDisplayGUIChestHooks;
    private final PlayerBase[] overrideDisplayGUIChestHooks;
    private final PlayerBase[] afterDisplayGUIChestHooks;
    protected final boolean isDisplayGUIChestModded;
    private static final List beforeDisplayGUIDispenserHookTypes;
    private static final List overrideDisplayGUIDispenserHookTypes;
    private static final List afterDisplayGUIDispenserHookTypes;
    private final PlayerBase[] beforeDisplayGUIDispenserHooks;
    private final PlayerBase[] overrideDisplayGUIDispenserHooks;
    private final PlayerBase[] afterDisplayGUIDispenserHooks;
    protected final boolean isDisplayGUIDispenserModded;
    private static final List beforeDisplayGUIEditSignHookTypes;
    private static final List overrideDisplayGUIEditSignHookTypes;
    private static final List afterDisplayGUIEditSignHookTypes;
    private final PlayerBase[] beforeDisplayGUIEditSignHooks;
    private final PlayerBase[] overrideDisplayGUIEditSignHooks;
    private final PlayerBase[] afterDisplayGUIEditSignHooks;
    protected final boolean isDisplayGUIEditSignModded;
    private static final List beforeDisplayGUIEnchantmentHookTypes;
    private static final List overrideDisplayGUIEnchantmentHookTypes;
    private static final List afterDisplayGUIEnchantmentHookTypes;
    private final PlayerBase[] beforeDisplayGUIEnchantmentHooks;
    private final PlayerBase[] overrideDisplayGUIEnchantmentHooks;
    private final PlayerBase[] afterDisplayGUIEnchantmentHooks;
    protected final boolean isDisplayGUIEnchantmentModded;
    private static final List beforeDisplayGUIFurnaceHookTypes;
    private static final List overrideDisplayGUIFurnaceHookTypes;
    private static final List afterDisplayGUIFurnaceHookTypes;
    private final PlayerBase[] beforeDisplayGUIFurnaceHooks;
    private final PlayerBase[] overrideDisplayGUIFurnaceHooks;
    private final PlayerBase[] afterDisplayGUIFurnaceHooks;
    protected final boolean isDisplayGUIFurnaceModded;
    private static final List beforeDisplayWorkbenchGUIHookTypes;
    private static final List overrideDisplayWorkbenchGUIHookTypes;
    private static final List afterDisplayWorkbenchGUIHookTypes;
    private final PlayerBase[] beforeDisplayWorkbenchGUIHooks;
    private final PlayerBase[] overrideDisplayWorkbenchGUIHooks;
    private final PlayerBase[] afterDisplayWorkbenchGUIHooks;
    protected final boolean isDisplayWorkbenchGUIModded;
    private static final List beforeDropOneItemHookTypes;
    private static final List overrideDropOneItemHookTypes;
    private static final List afterDropOneItemHookTypes;
    private final PlayerBase[] beforeDropOneItemHooks;
    private final PlayerBase[] overrideDropOneItemHooks;
    private final PlayerBase[] afterDropOneItemHooks;
    protected final boolean isDropOneItemModded;
    private static final List beforeDropPlayerItemHookTypes;
    private static final List overrideDropPlayerItemHookTypes;
    private static final List afterDropPlayerItemHookTypes;
    private final PlayerBase[] beforeDropPlayerItemHooks;
    private final PlayerBase[] overrideDropPlayerItemHooks;
    private final PlayerBase[] afterDropPlayerItemHooks;
    protected final boolean isDropPlayerItemModded;
    private static final List beforeDropPlayerItemWithRandomChoiceHookTypes;
    private static final List overrideDropPlayerItemWithRandomChoiceHookTypes;
    private static final List afterDropPlayerItemWithRandomChoiceHookTypes;
    private final PlayerBase[] beforeDropPlayerItemWithRandomChoiceHooks;
    private final PlayerBase[] overrideDropPlayerItemWithRandomChoiceHooks;
    private final PlayerBase[] afterDropPlayerItemWithRandomChoiceHooks;
    protected final boolean isDropPlayerItemWithRandomChoiceModded;
    private static final List beforeFallHookTypes;
    private static final List overrideFallHookTypes;
    private static final List afterFallHookTypes;
    private final PlayerBase[] beforeFallHooks;
    private final PlayerBase[] overrideFallHooks;
    private final PlayerBase[] afterFallHooks;
    protected final boolean isFallModded;
    private static final List beforeGetBrightnessHookTypes;
    private static final List overrideGetBrightnessHookTypes;
    private static final List afterGetBrightnessHookTypes;
    private final PlayerBase[] beforeGetBrightnessHooks;
    private final PlayerBase[] overrideGetBrightnessHooks;
    private final PlayerBase[] afterGetBrightnessHooks;
    protected final boolean isGetBrightnessModded;
    private static final List beforeGetBrightnessForRenderHookTypes;
    private static final List overrideGetBrightnessForRenderHookTypes;
    private static final List afterGetBrightnessForRenderHookTypes;
    private final PlayerBase[] beforeGetBrightnessForRenderHooks;
    private final PlayerBase[] overrideGetBrightnessForRenderHooks;
    private final PlayerBase[] afterGetBrightnessForRenderHooks;
    protected final boolean isGetBrightnessForRenderModded;
    private static final List beforeGetCurrentPlayerStrVsBlockHookTypes;
    private static final List overrideGetCurrentPlayerStrVsBlockHookTypes;
    private static final List afterGetCurrentPlayerStrVsBlockHookTypes;
    private final PlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
    private final PlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
    private final PlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
    protected final boolean isGetCurrentPlayerStrVsBlockModded;
    private static final List beforeGetDistanceSqHookTypes;
    private static final List overrideGetDistanceSqHookTypes;
    private static final List afterGetDistanceSqHookTypes;
    private final PlayerBase[] beforeGetDistanceSqHooks;
    private final PlayerBase[] overrideGetDistanceSqHooks;
    private final PlayerBase[] afterGetDistanceSqHooks;
    protected final boolean isGetDistanceSqModded;
    private static final List beforeGetDistanceSqToEntityHookTypes;
    private static final List overrideGetDistanceSqToEntityHookTypes;
    private static final List afterGetDistanceSqToEntityHookTypes;
    private final PlayerBase[] beforeGetDistanceSqToEntityHooks;
    private final PlayerBase[] overrideGetDistanceSqToEntityHooks;
    private final PlayerBase[] afterGetDistanceSqToEntityHooks;
    protected final boolean isGetDistanceSqToEntityModded;
    private static final List beforeGetFOVMultiplierHookTypes;
    private static final List overrideGetFOVMultiplierHookTypes;
    private static final List afterGetFOVMultiplierHookTypes;
    private final PlayerBase[] beforeGetFOVMultiplierHooks;
    private final PlayerBase[] overrideGetFOVMultiplierHooks;
    private final PlayerBase[] afterGetFOVMultiplierHooks;
    protected final boolean isGetFOVMultiplierModded;
    private static final List beforeGetHurtSoundHookTypes;
    private static final List overrideGetHurtSoundHookTypes;
    private static final List afterGetHurtSoundHookTypes;
    private final PlayerBase[] beforeGetHurtSoundHooks;
    private final PlayerBase[] overrideGetHurtSoundHooks;
    private final PlayerBase[] afterGetHurtSoundHooks;
    protected final boolean isGetHurtSoundModded;
    private static final List beforeGetItemIconHookTypes;
    private static final List overrideGetItemIconHookTypes;
    private static final List afterGetItemIconHookTypes;
    private final PlayerBase[] beforeGetItemIconHooks;
    private final PlayerBase[] overrideGetItemIconHooks;
    private final PlayerBase[] afterGetItemIconHooks;
    protected final boolean isGetItemIconModded;
    private static final List beforeGetSleepTimerHookTypes;
    private static final List overrideGetSleepTimerHookTypes;
    private static final List afterGetSleepTimerHookTypes;
    private final PlayerBase[] beforeGetSleepTimerHooks;
    private final PlayerBase[] overrideGetSleepTimerHooks;
    private final PlayerBase[] afterGetSleepTimerHooks;
    protected final boolean isGetSleepTimerModded;
    private static final List beforeGetSpeedModifierHookTypes;
    private static final List overrideGetSpeedModifierHookTypes;
    private static final List afterGetSpeedModifierHookTypes;
    private final PlayerBase[] beforeGetSpeedModifierHooks;
    private final PlayerBase[] overrideGetSpeedModifierHooks;
    private final PlayerBase[] afterGetSpeedModifierHooks;
    protected final boolean isGetSpeedModifierModded;
    private static final List beforeHandleLavaMovementHookTypes;
    private static final List overrideHandleLavaMovementHookTypes;
    private static final List afterHandleLavaMovementHookTypes;
    private final PlayerBase[] beforeHandleLavaMovementHooks;
    private final PlayerBase[] overrideHandleLavaMovementHooks;
    private final PlayerBase[] afterHandleLavaMovementHooks;
    protected final boolean isHandleLavaMovementModded;
    private static final List beforeHandleWaterMovementHookTypes;
    private static final List overrideHandleWaterMovementHookTypes;
    private static final List afterHandleWaterMovementHookTypes;
    private final PlayerBase[] beforeHandleWaterMovementHooks;
    private final PlayerBase[] overrideHandleWaterMovementHooks;
    private final PlayerBase[] afterHandleWaterMovementHooks;
    protected final boolean isHandleWaterMovementModded;
    private static final List beforeHealHookTypes;
    private static final List overrideHealHookTypes;
    private static final List afterHealHookTypes;
    private final PlayerBase[] beforeHealHooks;
    private final PlayerBase[] overrideHealHooks;
    private final PlayerBase[] afterHealHooks;
    protected final boolean isHealModded;
    private static final List beforeIsEntityInsideOpaqueBlockHookTypes;
    private static final List overrideIsEntityInsideOpaqueBlockHookTypes;
    private static final List afterIsEntityInsideOpaqueBlockHookTypes;
    private final PlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
    private final PlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
    private final PlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
    protected final boolean isIsEntityInsideOpaqueBlockModded;
    private static final List beforeIsInWaterHookTypes;
    private static final List overrideIsInWaterHookTypes;
    private static final List afterIsInWaterHookTypes;
    private final PlayerBase[] beforeIsInWaterHooks;
    private final PlayerBase[] overrideIsInWaterHooks;
    private final PlayerBase[] afterIsInWaterHooks;
    protected final boolean isIsInWaterModded;
    private static final List beforeIsInsideOfMaterialHookTypes;
    private static final List overrideIsInsideOfMaterialHookTypes;
    private static final List afterIsInsideOfMaterialHookTypes;
    private final PlayerBase[] beforeIsInsideOfMaterialHooks;
    private final PlayerBase[] overrideIsInsideOfMaterialHooks;
    private final PlayerBase[] afterIsInsideOfMaterialHooks;
    protected final boolean isIsInsideOfMaterialModded;
    private static final List beforeIsOnLadderHookTypes;
    private static final List overrideIsOnLadderHookTypes;
    private static final List afterIsOnLadderHookTypes;
    private final PlayerBase[] beforeIsOnLadderHooks;
    private final PlayerBase[] overrideIsOnLadderHooks;
    private final PlayerBase[] afterIsOnLadderHooks;
    protected final boolean isIsOnLadderModded;
    private static final List beforeIsSneakingHookTypes;
    private static final List overrideIsSneakingHookTypes;
    private static final List afterIsSneakingHookTypes;
    private final PlayerBase[] beforeIsSneakingHooks;
    private final PlayerBase[] overrideIsSneakingHooks;
    private final PlayerBase[] afterIsSneakingHooks;
    protected final boolean isIsSneakingModded;
    private static final List beforeIsSprintingHookTypes;
    private static final List overrideIsSprintingHookTypes;
    private static final List afterIsSprintingHookTypes;
    private final PlayerBase[] beforeIsSprintingHooks;
    private final PlayerBase[] overrideIsSprintingHooks;
    private final PlayerBase[] afterIsSprintingHooks;
    protected final boolean isIsSprintingModded;
    private static final List beforeJumpHookTypes;
    private static final List overrideJumpHookTypes;
    private static final List afterJumpHookTypes;
    private final PlayerBase[] beforeJumpHooks;
    private final PlayerBase[] overrideJumpHooks;
    private final PlayerBase[] afterJumpHooks;
    protected final boolean isJumpModded;
    private static final List beforeKnockBackHookTypes;
    private static final List overrideKnockBackHookTypes;
    private static final List afterKnockBackHookTypes;
    private final PlayerBase[] beforeKnockBackHooks;
    private final PlayerBase[] overrideKnockBackHooks;
    private final PlayerBase[] afterKnockBackHooks;
    protected final boolean isKnockBackModded;
    private static final List beforeMoveEntityHookTypes;
    private static final List overrideMoveEntityHookTypes;
    private static final List afterMoveEntityHookTypes;
    private final PlayerBase[] beforeMoveEntityHooks;
    private final PlayerBase[] overrideMoveEntityHooks;
    private final PlayerBase[] afterMoveEntityHooks;
    protected final boolean isMoveEntityModded;
    private static final List beforeMoveEntityWithHeadingHookTypes;
    private static final List overrideMoveEntityWithHeadingHookTypes;
    private static final List afterMoveEntityWithHeadingHookTypes;
    private final PlayerBase[] beforeMoveEntityWithHeadingHooks;
    private final PlayerBase[] overrideMoveEntityWithHeadingHooks;
    private final PlayerBase[] afterMoveEntityWithHeadingHooks;
    protected final boolean isMoveEntityWithHeadingModded;
    private static final List beforeMoveFlyingHookTypes;
    private static final List overrideMoveFlyingHookTypes;
    private static final List afterMoveFlyingHookTypes;
    private final PlayerBase[] beforeMoveFlyingHooks;
    private final PlayerBase[] overrideMoveFlyingHooks;
    private final PlayerBase[] afterMoveFlyingHooks;
    protected final boolean isMoveFlyingModded;
    private static final List beforeOnDeathHookTypes;
    private static final List overrideOnDeathHookTypes;
    private static final List afterOnDeathHookTypes;
    private final PlayerBase[] beforeOnDeathHooks;
    private final PlayerBase[] overrideOnDeathHooks;
    private final PlayerBase[] afterOnDeathHooks;
    protected final boolean isOnDeathModded;
    private static final List beforeOnLivingUpdateHookTypes;
    private static final List overrideOnLivingUpdateHookTypes;
    private static final List afterOnLivingUpdateHookTypes;
    private final PlayerBase[] beforeOnLivingUpdateHooks;
    private final PlayerBase[] overrideOnLivingUpdateHooks;
    private final PlayerBase[] afterOnLivingUpdateHooks;
    protected final boolean isOnLivingUpdateModded;
    private static final List beforeOnKillEntityHookTypes;
    private static final List overrideOnKillEntityHookTypes;
    private static final List afterOnKillEntityHookTypes;
    private final PlayerBase[] beforeOnKillEntityHooks;
    private final PlayerBase[] overrideOnKillEntityHooks;
    private final PlayerBase[] afterOnKillEntityHooks;
    protected final boolean isOnKillEntityModded;
    private static final List beforeOnUpdateHookTypes;
    private static final List overrideOnUpdateHookTypes;
    private static final List afterOnUpdateHookTypes;
    private final PlayerBase[] beforeOnUpdateHooks;
    private final PlayerBase[] overrideOnUpdateHooks;
    private final PlayerBase[] afterOnUpdateHooks;
    protected final boolean isOnUpdateModded;
    private static final List beforePlayStepSoundHookTypes;
    private static final List overridePlayStepSoundHookTypes;
    private static final List afterPlayStepSoundHookTypes;
    private final PlayerBase[] beforePlayStepSoundHooks;
    private final PlayerBase[] overridePlayStepSoundHooks;
    private final PlayerBase[] afterPlayStepSoundHooks;
    protected final boolean isPlayStepSoundModded;
    private static final List beforePushOutOfBlocksHookTypes;
    private static final List overridePushOutOfBlocksHookTypes;
    private static final List afterPushOutOfBlocksHookTypes;
    private final PlayerBase[] beforePushOutOfBlocksHooks;
    private final PlayerBase[] overridePushOutOfBlocksHooks;
    private final PlayerBase[] afterPushOutOfBlocksHooks;
    protected final boolean isPushOutOfBlocksModded;
    private static final List beforeRayTraceHookTypes;
    private static final List overrideRayTraceHookTypes;
    private static final List afterRayTraceHookTypes;
    private final PlayerBase[] beforeRayTraceHooks;
    private final PlayerBase[] overrideRayTraceHooks;
    private final PlayerBase[] afterRayTraceHooks;
    protected final boolean isRayTraceModded;
    private static final List beforeReadEntityFromNBTHookTypes;
    private static final List overrideReadEntityFromNBTHookTypes;
    private static final List afterReadEntityFromNBTHookTypes;
    private final PlayerBase[] beforeReadEntityFromNBTHooks;
    private final PlayerBase[] overrideReadEntityFromNBTHooks;
    private final PlayerBase[] afterReadEntityFromNBTHooks;
    protected final boolean isReadEntityFromNBTModded;
    private static final List beforeRespawnPlayerHookTypes;
    private static final List overrideRespawnPlayerHookTypes;
    private static final List afterRespawnPlayerHookTypes;
    private final PlayerBase[] beforeRespawnPlayerHooks;
    private final PlayerBase[] overrideRespawnPlayerHooks;
    private final PlayerBase[] afterRespawnPlayerHooks;
    protected final boolean isRespawnPlayerModded;
    private static final List beforeSendChatMessageHookTypes;
    private static final List overrideSendChatMessageHookTypes;
    private static final List afterSendChatMessageHookTypes;
    private final PlayerBase[] beforeSendChatMessageHooks;
    private final PlayerBase[] overrideSendChatMessageHooks;
    private final PlayerBase[] afterSendChatMessageHooks;
    protected final boolean isSendChatMessageModded;
    private static final List beforeSetDeadHookTypes;
    private static final List overrideSetDeadHookTypes;
    private static final List afterSetDeadHookTypes;
    private final PlayerBase[] beforeSetDeadHooks;
    private final PlayerBase[] overrideSetDeadHooks;
    private final PlayerBase[] afterSetDeadHooks;
    protected final boolean isSetDeadModded;
    private static final List beforeSetPositionAndRotationHookTypes;
    private static final List overrideSetPositionAndRotationHookTypes;
    private static final List afterSetPositionAndRotationHookTypes;
    private final PlayerBase[] beforeSetPositionAndRotationHooks;
    private final PlayerBase[] overrideSetPositionAndRotationHooks;
    private final PlayerBase[] afterSetPositionAndRotationHooks;
    protected final boolean isSetPositionAndRotationModded;
    private static final List beforeSleepInBedAtHookTypes;
    private static final List overrideSleepInBedAtHookTypes;
    private static final List afterSleepInBedAtHookTypes;
    private final PlayerBase[] beforeSleepInBedAtHooks;
    private final PlayerBase[] overrideSleepInBedAtHooks;
    private final PlayerBase[] afterSleepInBedAtHooks;
    protected final boolean isSleepInBedAtModded;
    private static final List beforeSwingItemHookTypes;
    private static final List overrideSwingItemHookTypes;
    private static final List afterSwingItemHookTypes;
    private final PlayerBase[] beforeSwingItemHooks;
    private final PlayerBase[] overrideSwingItemHooks;
    private final PlayerBase[] afterSwingItemHooks;
    protected final boolean isSwingItemModded;
    private static final List beforeUpdateEntityActionStateHookTypes;
    private static final List overrideUpdateEntityActionStateHookTypes;
    private static final List afterUpdateEntityActionStateHookTypes;
    private final PlayerBase[] beforeUpdateEntityActionStateHooks;
    private final PlayerBase[] overrideUpdateEntityActionStateHooks;
    private final PlayerBase[] afterUpdateEntityActionStateHooks;
    protected final boolean isUpdateEntityActionStateModded;
    private static final List beforeWriteEntityToNBTHookTypes;
    private static final List overrideWriteEntityToNBTHookTypes;
    private static final List afterWriteEntityToNBTHookTypes;
    private final PlayerBase[] beforeWriteEntityToNBTHooks;
    private final PlayerBase[] overrideWriteEntityToNBTHooks;
    private final PlayerBase[] afterWriteEntityToNBTHooks;
    protected final boolean isWriteEntityToNBTModded;
    protected final EntityPlayerSP player;
    private static final List beforeLocalConstructingHookTypes;
    private static final List afterLocalConstructingHookTypes;
    private final PlayerBase[] beforeLocalConstructingHooks;
    private final PlayerBase[] afterLocalConstructingHooks;
    private final Map allBaseObjects;
    private final Set unmodifiableAllBaseIds;
    private static final Map allBaseConstructors;
    private static final Set unmodifiableAllIds;
    private static final Map allBaseBeforeSuperiors;
    private static final Map allBaseBeforeInferiors;
    private static final Map allBaseOverrideSuperiors;
    private static final Map allBaseOverrideInferiors;
    private static final Map allBaseAfterSuperiors;
    private static final Map allBaseAfterInferiors;
    private static boolean initialized;
    
    private static void log(final String var0) {
        System.out.println(var0);
        PlayerAPI.logger.fine(var0);
    }
    
    public static void register(final String var0, final Class var1) {
        register(var0, var1, null);
    }
    
    public static void register(final String var0, final Class var1, final PlayerBaseSorting var2) {
        try {
            register(var1, var0, var2);
        }
        catch (RuntimeException var3) {
            if (var0 != null) {
                log("PlayerAPI: failed to register id '" + var0 + "'");
            }
            else {
                log("PlayerAPI: failed to register PlayerBase");
            }
            throw var3;
        }
    }
    
    private static void register(final Class var0, final String var1, final PlayerBaseSorting var2) {
        if (!PlayerAPI.isCreated) {
            log("PlayerAPI 1.5 Created");
            PlayerAPI.isCreated = true;
        }
        if (var1 == null) {
            throw new NullPointerException("Argument 'id' can not be null");
        }
        if (var0 == null) {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        }
        final Constructor var3 = PlayerAPI.allBaseConstructors.get(var1);
        if (var3 != null) {
            throw new IllegalArgumentException("The class '" + var0.getName() + "' can not be registered with the id '" + var1 + "' because the class '" + var3.getDeclaringClass().getName() + "' has allready been registered with the same id");
        }
        Constructor var4;
        try {
            var4 = var0.getDeclaredConstructor((Class[])PlayerAPI.Classes);
        }
        catch (Exception var5) {
            try {
                var4 = var0.getDeclaredConstructor((Class[])PlayerAPI.Class);
            }
            catch (Exception var6) {
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + PlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + var0.getName() + "'", var5);
            }
        }
        PlayerAPI.allBaseConstructors.put(var1, var4);
        if (var2 != null) {
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeLocalConstructingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeLocalConstructingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterLocalConstructingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterLocalConstructingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAddExhaustionSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAddExhaustionInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAddExhaustionSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAddExhaustionInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAddExhaustionSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAddExhaustionInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAddMovementStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAddMovementStatInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAddMovementStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAddMovementStatInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAddMovementStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAddMovementStatInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAddStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAddStatInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAddStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAddStatInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAddStatSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAddStatInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAttackEntityFromSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAttackEntityFromInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAttackEntityFromSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAttackEntityFromInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAttackEntityFromSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAttackEntityFromInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAlertWolvesSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAlertWolvesInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAlertWolvesSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAlertWolvesInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAlertWolvesSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAlertWolvesInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeAttackTargetEntityWithCurrentItemInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideAttackTargetEntityWithCurrentItemInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterAttackTargetEntityWithCurrentItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterAttackTargetEntityWithCurrentItemInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeCanBreatheUnderwaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeCanBreatheUnderwaterInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideCanBreatheUnderwaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideCanBreatheUnderwaterInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterCanBreatheUnderwaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterCanBreatheUnderwaterInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeCanHarvestBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeCanHarvestBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideCanHarvestBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideCanHarvestBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterCanHarvestBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterCanHarvestBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeCanPlayerEditSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeCanPlayerEditInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideCanPlayerEditSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideCanPlayerEditInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterCanPlayerEditSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterCanPlayerEditInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeCanTriggerWalkingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeCanTriggerWalkingInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideCanTriggerWalkingSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideCanTriggerWalkingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterCanTriggerWalkingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterCanTriggerWalkingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeCloseScreenSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeCloseScreenInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideCloseScreenSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideCloseScreenInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterCloseScreenSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterCloseScreenInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDamageEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDamageEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDamageEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDamageEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDamageEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDamageEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIBrewingStandSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIBrewingStandInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIBrewingStandSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIBrewingStandInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIBrewingStandSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIBrewingStandInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIChestSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIChestInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIChestSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIChestInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIChestSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIChestInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIDispenserSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIDispenserInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIDispenserSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIDispenserInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIDispenserSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIDispenserInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIEditSignSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIEditSignInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIEditSignSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIEditSignInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIEditSignSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIEditSignInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIEnchantmentSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIEnchantmentInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIEnchantmentSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIEnchantmentInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIEnchantmentSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIEnchantmentInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayGUIFurnaceSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayGUIFurnaceInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayGUIFurnaceSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayGUIFurnaceInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayGUIFurnaceSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayGUIFurnaceInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDisplayWorkbenchGUISuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDisplayWorkbenchGUIInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDisplayWorkbenchGUISuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDisplayWorkbenchGUIInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDisplayWorkbenchGUISuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDisplayWorkbenchGUIInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDropOneItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDropOneItemInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDropOneItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDropOneItemInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDropOneItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDropOneItemInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDropPlayerItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDropPlayerItemInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDropPlayerItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDropPlayerItemInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDropPlayerItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDropPlayerItemInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeDropPlayerItemWithRandomChoiceSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeDropPlayerItemWithRandomChoiceInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideDropPlayerItemWithRandomChoiceSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideDropPlayerItemWithRandomChoiceInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterDropPlayerItemWithRandomChoiceSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterDropPlayerItemWithRandomChoiceInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeFallSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeFallInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideFallSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideFallInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterFallSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterFallInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetBrightnessSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetBrightnessInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetBrightnessSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetBrightnessInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetBrightnessSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetBrightnessInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetBrightnessForRenderSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetBrightnessForRenderInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetBrightnessForRenderSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetBrightnessForRenderInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetBrightnessForRenderSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetBrightnessForRenderInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetCurrentPlayerStrVsBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetCurrentPlayerStrVsBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetCurrentPlayerStrVsBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetCurrentPlayerStrVsBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetDistanceSqSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetDistanceSqInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetDistanceSqSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetDistanceSqInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetDistanceSqSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetDistanceSqInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetDistanceSqToEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetDistanceSqToEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetDistanceSqToEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetDistanceSqToEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetDistanceSqToEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetDistanceSqToEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetFOVMultiplierSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetFOVMultiplierInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetFOVMultiplierSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetFOVMultiplierInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetFOVMultiplierSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetFOVMultiplierInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetHurtSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetHurtSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetHurtSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetHurtSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetHurtSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetHurtSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetItemIconSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetItemIconInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetItemIconSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetItemIconInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetItemIconSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetItemIconInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetSleepTimerSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetSleepTimerInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetSleepTimerSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetSleepTimerInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetSleepTimerSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetSleepTimerInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeGetSpeedModifierSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeGetSpeedModifierInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideGetSpeedModifierSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideGetSpeedModifierInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterGetSpeedModifierSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterGetSpeedModifierInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeHandleLavaMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeHandleLavaMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideHandleLavaMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideHandleLavaMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterHandleLavaMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterHandleLavaMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeHandleWaterMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeHandleWaterMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideHandleWaterMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideHandleWaterMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterHandleWaterMovementSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterHandleWaterMovementInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeHealSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeHealInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideHealSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideHealInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterHealSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterHealInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsEntityInsideOpaqueBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsEntityInsideOpaqueBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsEntityInsideOpaqueBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsEntityInsideOpaqueBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsEntityInsideOpaqueBlockSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsEntityInsideOpaqueBlockInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsInWaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsInWaterInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsInWaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsInWaterInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsInWaterSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsInWaterInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsInsideOfMaterialSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsInsideOfMaterialInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsInsideOfMaterialSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsInsideOfMaterialInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsInsideOfMaterialSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsInsideOfMaterialInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsOnLadderSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsOnLadderInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsOnLadderSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsOnLadderInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsOnLadderSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsOnLadderInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsSneakingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsSneakingInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsSneakingSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsSneakingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsSneakingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsSneakingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeIsSprintingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeIsSprintingInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideIsSprintingSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideIsSprintingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterIsSprintingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterIsSprintingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeJumpSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeJumpInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideJumpSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideJumpInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterJumpSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterJumpInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeKnockBackSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeKnockBackInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideKnockBackSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideKnockBackInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterKnockBackSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterKnockBackInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeMoveEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeMoveEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideMoveEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideMoveEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterMoveEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterMoveEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeMoveEntityWithHeadingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeMoveEntityWithHeadingInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideMoveEntityWithHeadingSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideMoveEntityWithHeadingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterMoveEntityWithHeadingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterMoveEntityWithHeadingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeMoveFlyingSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeMoveFlyingInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideMoveFlyingSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideMoveFlyingInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterMoveFlyingSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterMoveFlyingInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeOnDeathSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeOnDeathInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideOnDeathSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideOnDeathInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterOnDeathSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterOnDeathInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeOnLivingUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeOnLivingUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideOnLivingUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideOnLivingUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterOnLivingUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterOnLivingUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeOnKillEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeOnKillEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideOnKillEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideOnKillEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterOnKillEntitySuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterOnKillEntityInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeOnUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeOnUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideOnUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideOnUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterOnUpdateSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterOnUpdateInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforePlayStepSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforePlayStepSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverridePlayStepSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverridePlayStepSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterPlayStepSoundSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterPlayStepSoundInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforePushOutOfBlocksSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforePushOutOfBlocksInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverridePushOutOfBlocksSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverridePushOutOfBlocksInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterPushOutOfBlocksSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterPushOutOfBlocksInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeRayTraceSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeRayTraceInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideRayTraceSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideRayTraceInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterRayTraceSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterRayTraceInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeReadEntityFromNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeReadEntityFromNBTInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideReadEntityFromNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideReadEntityFromNBTInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterReadEntityFromNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterReadEntityFromNBTInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeRespawnPlayerSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeRespawnPlayerInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideRespawnPlayerSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideRespawnPlayerInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterRespawnPlayerSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterRespawnPlayerInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeSendChatMessageSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeSendChatMessageInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideSendChatMessageSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideSendChatMessageInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterSendChatMessageSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterSendChatMessageInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeSetDeadSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeSetDeadInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideSetDeadSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideSetDeadInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterSetDeadSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterSetDeadInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeSetPositionAndRotationSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeSetPositionAndRotationInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideSetPositionAndRotationSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideSetPositionAndRotationInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterSetPositionAndRotationSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterSetPositionAndRotationInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeSleepInBedAtSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeSleepInBedAtInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideSleepInBedAtSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideSleepInBedAtInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterSleepInBedAtSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterSleepInBedAtInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeSwingItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeSwingItemInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideSwingItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideSwingItemInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterSwingItemSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterSwingItemInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeUpdateEntityActionStateSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeUpdateEntityActionStateInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideUpdateEntityActionStateSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideUpdateEntityActionStateInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterUpdateEntityActionStateSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterUpdateEntityActionStateInferiors());
            addSorting(var1, PlayerAPI.allBaseBeforeSuperiors, var2.getBeforeWriteEntityToNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseBeforeInferiors, var2.getBeforeWriteEntityToNBTInferiors());
            addSorting(var1, PlayerAPI.allBaseOverrideSuperiors, var2.getOverrideWriteEntityToNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseOverrideInferiors, var2.getOverrideWriteEntityToNBTInferiors());
            addSorting(var1, PlayerAPI.allBaseAfterSuperiors, var2.getAfterWriteEntityToNBTSuperiors());
            addSorting(var1, PlayerAPI.allBaseAfterInferiors, var2.getAfterWriteEntityToNBTInferiors());
        }
        addMethod(var1, var0, PlayerAPI.beforeLocalConstructingHookTypes, "beforeLocalConstructing", Minecraft.class, World.class, Session.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterLocalConstructingHookTypes, "afterLocalConstructing", Minecraft.class, World.class, Session.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAddExhaustionHookTypes, "beforeAddExhaustion", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideAddExhaustionHookTypes, "addExhaustion", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterAddExhaustionHookTypes, "afterAddExhaustion", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAddMovementStatHookTypes, "beforeAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideAddMovementStatHookTypes, "addMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.afterAddMovementStatHookTypes, "afterAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAddStatHookTypes, "beforeAddStat", StatBase.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideAddStatHookTypes, "addStat", StatBase.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterAddStatHookTypes, "afterAddStat", StatBase.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideAttackEntityFromHookTypes, "attackEntityFrom", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterAttackEntityFromHookTypes, "afterAttackEntityFrom", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAlertWolvesHookTypes, "beforeAlertWolves", EntityLiving.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideAlertWolvesHookTypes, "alertWolves", EntityLiving.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.afterAlertWolvesHookTypes, "afterAlertWolves", EntityLiving.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", Entity.class);
        addMethod(var1, var0, PlayerAPI.overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", Entity.class);
        addMethod(var1, var0, PlayerAPI.afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", Entity.class);
        addMethod(var1, var0, PlayerAPI.beforeCanBreatheUnderwaterHookTypes, "beforeCanBreatheUnderwater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideCanBreatheUnderwaterHookTypes, "canBreatheUnderwater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterCanBreatheUnderwaterHookTypes, "afterCanBreatheUnderwater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.overrideCanHarvestBlockHookTypes, "canHarvestBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideCanPlayerEditHookTypes, "canPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterCanPlayerEditHookTypes, "afterCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideCanTriggerWalkingHookTypes, "canTriggerWalking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeCloseScreenHookTypes, "beforeCloseScreen", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideCloseScreenHookTypes, "closeScreen", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterCloseScreenHookTypes, "afterCloseScreen", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeDamageEntityHookTypes, "beforeDamageEntity", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideDamageEntityHookTypes, "damageEntity", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterDamageEntityHookTypes, "afterDamageEntity", DamageSource.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIBrewingStandHookTypes, "beforeDisplayGUIBrewingStand", TileEntityBrewingStand.class);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIBrewingStandHookTypes, "displayGUIBrewingStand", TileEntityBrewingStand.class);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIBrewingStandHookTypes, "afterDisplayGUIBrewingStand", TileEntityBrewingStand.class);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", IInventory.class);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIChestHookTypes, "displayGUIChest", IInventory.class);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", IInventory.class);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", TileEntityDispenser.class);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", TileEntityDispenser.class);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", TileEntityDispenser.class);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIEditSignHookTypes, "beforeDisplayGUIEditSign", TileEntitySign.class);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIEditSignHookTypes, "displayGUIEditSign", TileEntitySign.class);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIEditSignHookTypes, "afterDisplayGUIEditSign", TileEntitySign.class);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIEnchantmentHookTypes, "beforeDisplayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIEnchantmentHookTypes, "displayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIEnchantmentHookTypes, "afterDisplayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", TileEntityFurnace.class);
        addMethod(var1, var0, PlayerAPI.overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", TileEntityFurnace.class);
        addMethod(var1, var0, PlayerAPI.afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", TileEntityFurnace.class);
        addMethod(var1, var0, PlayerAPI.beforeDisplayWorkbenchGUIHookTypes, "beforeDisplayWorkbenchGUI", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideDisplayWorkbenchGUIHookTypes, "displayWorkbenchGUI", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterDisplayWorkbenchGUIHookTypes, "afterDisplayWorkbenchGUI", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeDropOneItemHookTypes, "beforeDropOneItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideDropOneItemHookTypes, "dropOneItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterDropOneItemHookTypes, "afterDropOneItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", ItemStack.class);
        addMethod(var1, var0, PlayerAPI.overrideDropPlayerItemHookTypes, "dropPlayerItem", ItemStack.class);
        addMethod(var1, var0, PlayerAPI.afterDropPlayerItemHookTypes, "afterDropPlayerItem", ItemStack.class);
        addMethod(var1, var0, PlayerAPI.beforeDropPlayerItemWithRandomChoiceHookTypes, "beforeDropPlayerItemWithRandomChoice", ItemStack.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideDropPlayerItemWithRandomChoiceHookTypes, "dropPlayerItemWithRandomChoice", ItemStack.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.afterDropPlayerItemWithRandomChoiceHookTypes, "afterDropPlayerItemWithRandomChoice", ItemStack.class, Boolean.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeFallHookTypes, "beforeFall", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideFallHookTypes, "fall", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterFallHookTypes, "afterFall", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeGetBrightnessHookTypes, "beforeGetBrightness", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideGetBrightnessHookTypes, "getBrightness", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterGetBrightnessHookTypes, "afterGetBrightness", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeGetBrightnessForRenderHookTypes, "beforeGetBrightnessForRender", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideGetBrightnessForRenderHookTypes, "getBrightnessForRender", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterGetBrightnessForRenderHookTypes, "afterGetBrightnessForRender", Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", Block.class);
        addMethod(var1, var0, PlayerAPI.beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideGetDistanceSqHookTypes, "getDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.afterGetDistanceSqHookTypes, "afterGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeGetDistanceSqToEntityHookTypes, "beforeGetDistanceSqToEntity", Entity.class);
        addMethod(var1, var0, PlayerAPI.overrideGetDistanceSqToEntityHookTypes, "getDistanceSqToEntity", Entity.class);
        addMethod(var1, var0, PlayerAPI.afterGetDistanceSqToEntityHookTypes, "afterGetDistanceSqToEntity", Entity.class);
        addMethod(var1, var0, PlayerAPI.beforeGetFOVMultiplierHookTypes, "beforeGetFOVMultiplier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideGetFOVMultiplierHookTypes, "getFOVMultiplier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterGetFOVMultiplierHookTypes, "afterGetFOVMultiplier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeGetHurtSoundHookTypes, "beforeGetHurtSound", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideGetHurtSoundHookTypes, "getHurtSound", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterGetHurtSoundHookTypes, "afterGetHurtSound", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeGetItemIconHookTypes, "beforeGetItemIcon", ItemStack.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideGetItemIconHookTypes, "getItemIcon", ItemStack.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterGetItemIconHookTypes, "afterGetItemIcon", ItemStack.class, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeGetSleepTimerHookTypes, "beforeGetSleepTimer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideGetSleepTimerHookTypes, "getSleepTimer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterGetSleepTimerHookTypes, "afterGetSleepTimer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeGetSpeedModifierHookTypes, "beforeGetSpeedModifier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideGetSpeedModifierHookTypes, "getSpeedModifier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterGetSpeedModifierHookTypes, "afterGetSpeedModifier", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeHandleLavaMovementHookTypes, "beforeHandleLavaMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideHandleLavaMovementHookTypes, "handleLavaMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterHandleLavaMovementHookTypes, "afterHandleLavaMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeHandleWaterMovementHookTypes, "beforeHandleWaterMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideHandleWaterMovementHookTypes, "handleWaterMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterHandleWaterMovementHookTypes, "afterHandleWaterMovement", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeHealHookTypes, "beforeHeal", Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideHealHookTypes, "heal", Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterHealHookTypes, "afterHeal", Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeIsInWaterHookTypes, "beforeIsInWater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideIsInWaterHookTypes, "isInWater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterIsInWaterHookTypes, "afterIsInWater", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", Material.class);
        addMethod(var1, var0, PlayerAPI.overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", Material.class);
        addMethod(var1, var0, PlayerAPI.afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", Material.class);
        addMethod(var1, var0, PlayerAPI.beforeIsOnLadderHookTypes, "beforeIsOnLadder", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideIsOnLadderHookTypes, "isOnLadder", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterIsOnLadderHookTypes, "afterIsOnLadder", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeIsSneakingHookTypes, "beforeIsSneaking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideIsSneakingHookTypes, "isSneaking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterIsSneakingHookTypes, "afterIsSneaking", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeIsSprintingHookTypes, "beforeIsSprinting", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideIsSprintingHookTypes, "isSprinting", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterIsSprintingHookTypes, "afterIsSprinting", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeJumpHookTypes, "beforeJump", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideJumpHookTypes, "jump", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterJumpHookTypes, "afterJump", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeKnockBackHookTypes, "beforeKnockBack", Entity.class, Integer.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideKnockBackHookTypes, "knockBack", Entity.class, Integer.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.afterKnockBackHookTypes, "afterKnockBack", Entity.class, Integer.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeMoveEntityHookTypes, "beforeMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideMoveEntityHookTypes, "moveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.afterMoveEntityHookTypes, "afterMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeMoveFlyingHookTypes, "beforeMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideMoveFlyingHookTypes, "moveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterMoveFlyingHookTypes, "afterMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeOnDeathHookTypes, "beforeOnDeath", DamageSource.class);
        addMethod(var1, var0, PlayerAPI.overrideOnDeathHookTypes, "onDeath", DamageSource.class);
        addMethod(var1, var0, PlayerAPI.afterOnDeathHookTypes, "afterOnDeath", DamageSource.class);
        addMethod(var1, var0, PlayerAPI.beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideOnLivingUpdateHookTypes, "onLivingUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterOnLivingUpdateHookTypes, "afterOnLivingUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeOnKillEntityHookTypes, "beforeOnKillEntity", EntityLiving.class);
        addMethod(var1, var0, PlayerAPI.overrideOnKillEntityHookTypes, "onKillEntity", EntityLiving.class);
        addMethod(var1, var0, PlayerAPI.afterOnKillEntityHookTypes, "afterOnKillEntity", EntityLiving.class);
        addMethod(var1, var0, PlayerAPI.beforeOnUpdateHookTypes, "beforeOnUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideOnUpdateHookTypes, "onUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterOnUpdateHookTypes, "afterOnUpdate", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforePlayStepSoundHookTypes, "beforePlayStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overridePlayStepSoundHookTypes, "playStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterPlayStepSoundHookTypes, "afterPlayStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforePushOutOfBlocksHookTypes, "beforePushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.overridePushOutOfBlocksHookTypes, "pushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.afterPushOutOfBlocksHookTypes, "afterPushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeRayTraceHookTypes, "beforeRayTrace", Double.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideRayTraceHookTypes, "rayTrace", Double.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterRayTraceHookTypes, "afterRayTrace", Double.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", NBTTagCompound.class);
        addMethod(var1, var0, PlayerAPI.overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", NBTTagCompound.class);
        addMethod(var1, var0, PlayerAPI.afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", NBTTagCompound.class);
        addMethod(var1, var0, PlayerAPI.beforeRespawnPlayerHookTypes, "beforeRespawnPlayer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideRespawnPlayerHookTypes, "respawnPlayer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterRespawnPlayerHookTypes, "afterRespawnPlayer", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeSendChatMessageHookTypes, "beforeSendChatMessage", String.class);
        addMethod(var1, var0, PlayerAPI.overrideSendChatMessageHookTypes, "sendChatMessage", String.class);
        addMethod(var1, var0, PlayerAPI.afterSendChatMessageHookTypes, "afterSendChatMessage", String.class);
        addMethod(var1, var0, PlayerAPI.beforeSetDeadHookTypes, "beforeSetDead", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideSetDeadHookTypes, "setDead", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterSetDeadHookTypes, "afterSetDead", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeSetPositionAndRotationHookTypes, "beforeSetPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideSetPositionAndRotationHookTypes, "setPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.afterSetPositionAndRotationHookTypes, "afterSetPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeSleepInBedAtHookTypes, "beforeSleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.overrideSleepInBedAtHookTypes, "sleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.afterSleepInBedAtHookTypes, "afterSleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        addMethod(var1, var0, PlayerAPI.beforeSwingItemHookTypes, "beforeSwingItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideSwingItemHookTypes, "swingItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterSwingItemHookTypes, "afterSwingItem", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState", new Class[0]);
        addMethod(var1, var0, PlayerAPI.overrideUpdateEntityActionStateHookTypes, "updateEntityActionState", new Class[0]);
        addMethod(var1, var0, PlayerAPI.afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState", new Class[0]);
        addMethod(var1, var0, PlayerAPI.beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", NBTTagCompound.class);
        addMethod(var1, var0, PlayerAPI.overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", NBTTagCompound.class);
        addMethod(var1, var0, PlayerAPI.afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", NBTTagCompound.class);
        System.out.println("PlayerAPI: registered " + var1);
        PlayerAPI.logger.fine("PlayerAPI: registered class '" + var0.getName() + "' with id '" + var1 + "'");
        PlayerAPI.initialized = false;
    }
    
    public static boolean unregister(final String var0) {
        if (var0 != null && PlayerAPI.allBaseConstructors.remove(var0) != null) {
            PlayerAPI.allBaseBeforeSuperiors.remove(var0);
            PlayerAPI.allBaseBeforeInferiors.remove(var0);
            PlayerAPI.allBaseOverrideSuperiors.remove(var0);
            PlayerAPI.allBaseOverrideInferiors.remove(var0);
            PlayerAPI.allBaseAfterSuperiors.remove(var0);
            PlayerAPI.allBaseAfterInferiors.remove(var0);
            PlayerAPI.beforeLocalConstructingHookTypes.remove(var0);
            PlayerAPI.afterLocalConstructingHookTypes.remove(var0);
            PlayerAPI.beforeAddExhaustionHookTypes.remove(var0);
            PlayerAPI.overrideAddExhaustionHookTypes.remove(var0);
            PlayerAPI.afterAddExhaustionHookTypes.remove(var0);
            PlayerAPI.beforeAddMovementStatHookTypes.remove(var0);
            PlayerAPI.overrideAddMovementStatHookTypes.remove(var0);
            PlayerAPI.afterAddMovementStatHookTypes.remove(var0);
            PlayerAPI.beforeAddStatHookTypes.remove(var0);
            PlayerAPI.overrideAddStatHookTypes.remove(var0);
            PlayerAPI.afterAddStatHookTypes.remove(var0);
            PlayerAPI.beforeAttackEntityFromHookTypes.remove(var0);
            PlayerAPI.overrideAttackEntityFromHookTypes.remove(var0);
            PlayerAPI.afterAttackEntityFromHookTypes.remove(var0);
            PlayerAPI.beforeAlertWolvesHookTypes.remove(var0);
            PlayerAPI.overrideAlertWolvesHookTypes.remove(var0);
            PlayerAPI.afterAlertWolvesHookTypes.remove(var0);
            PlayerAPI.beforeAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            PlayerAPI.overrideAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            PlayerAPI.afterAttackTargetEntityWithCurrentItemHookTypes.remove(var0);
            PlayerAPI.beforeCanBreatheUnderwaterHookTypes.remove(var0);
            PlayerAPI.overrideCanBreatheUnderwaterHookTypes.remove(var0);
            PlayerAPI.afterCanBreatheUnderwaterHookTypes.remove(var0);
            PlayerAPI.beforeCanHarvestBlockHookTypes.remove(var0);
            PlayerAPI.overrideCanHarvestBlockHookTypes.remove(var0);
            PlayerAPI.afterCanHarvestBlockHookTypes.remove(var0);
            PlayerAPI.beforeCanPlayerEditHookTypes.remove(var0);
            PlayerAPI.overrideCanPlayerEditHookTypes.remove(var0);
            PlayerAPI.afterCanPlayerEditHookTypes.remove(var0);
            PlayerAPI.beforeCanTriggerWalkingHookTypes.remove(var0);
            PlayerAPI.overrideCanTriggerWalkingHookTypes.remove(var0);
            PlayerAPI.afterCanTriggerWalkingHookTypes.remove(var0);
            PlayerAPI.beforeCloseScreenHookTypes.remove(var0);
            PlayerAPI.overrideCloseScreenHookTypes.remove(var0);
            PlayerAPI.afterCloseScreenHookTypes.remove(var0);
            PlayerAPI.beforeDamageEntityHookTypes.remove(var0);
            PlayerAPI.overrideDamageEntityHookTypes.remove(var0);
            PlayerAPI.afterDamageEntityHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIBrewingStandHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIBrewingStandHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIBrewingStandHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIChestHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIChestHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIChestHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIDispenserHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIDispenserHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIDispenserHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIEditSignHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIEditSignHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIEditSignHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIEnchantmentHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIEnchantmentHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIEnchantmentHookTypes.remove(var0);
            PlayerAPI.beforeDisplayGUIFurnaceHookTypes.remove(var0);
            PlayerAPI.overrideDisplayGUIFurnaceHookTypes.remove(var0);
            PlayerAPI.afterDisplayGUIFurnaceHookTypes.remove(var0);
            PlayerAPI.beforeDisplayWorkbenchGUIHookTypes.remove(var0);
            PlayerAPI.overrideDisplayWorkbenchGUIHookTypes.remove(var0);
            PlayerAPI.afterDisplayWorkbenchGUIHookTypes.remove(var0);
            PlayerAPI.beforeDropOneItemHookTypes.remove(var0);
            PlayerAPI.overrideDropOneItemHookTypes.remove(var0);
            PlayerAPI.afterDropOneItemHookTypes.remove(var0);
            PlayerAPI.beforeDropPlayerItemHookTypes.remove(var0);
            PlayerAPI.overrideDropPlayerItemHookTypes.remove(var0);
            PlayerAPI.afterDropPlayerItemHookTypes.remove(var0);
            PlayerAPI.beforeDropPlayerItemWithRandomChoiceHookTypes.remove(var0);
            PlayerAPI.overrideDropPlayerItemWithRandomChoiceHookTypes.remove(var0);
            PlayerAPI.afterDropPlayerItemWithRandomChoiceHookTypes.remove(var0);
            PlayerAPI.beforeFallHookTypes.remove(var0);
            PlayerAPI.overrideFallHookTypes.remove(var0);
            PlayerAPI.afterFallHookTypes.remove(var0);
            PlayerAPI.beforeGetBrightnessHookTypes.remove(var0);
            PlayerAPI.overrideGetBrightnessHookTypes.remove(var0);
            PlayerAPI.afterGetBrightnessHookTypes.remove(var0);
            PlayerAPI.beforeGetBrightnessForRenderHookTypes.remove(var0);
            PlayerAPI.overrideGetBrightnessForRenderHookTypes.remove(var0);
            PlayerAPI.afterGetBrightnessForRenderHookTypes.remove(var0);
            PlayerAPI.beforeGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            PlayerAPI.overrideGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            PlayerAPI.afterGetCurrentPlayerStrVsBlockHookTypes.remove(var0);
            PlayerAPI.beforeGetDistanceSqHookTypes.remove(var0);
            PlayerAPI.overrideGetDistanceSqHookTypes.remove(var0);
            PlayerAPI.afterGetDistanceSqHookTypes.remove(var0);
            PlayerAPI.beforeGetDistanceSqToEntityHookTypes.remove(var0);
            PlayerAPI.overrideGetDistanceSqToEntityHookTypes.remove(var0);
            PlayerAPI.afterGetDistanceSqToEntityHookTypes.remove(var0);
            PlayerAPI.beforeGetFOVMultiplierHookTypes.remove(var0);
            PlayerAPI.overrideGetFOVMultiplierHookTypes.remove(var0);
            PlayerAPI.afterGetFOVMultiplierHookTypes.remove(var0);
            PlayerAPI.beforeGetHurtSoundHookTypes.remove(var0);
            PlayerAPI.overrideGetHurtSoundHookTypes.remove(var0);
            PlayerAPI.afterGetHurtSoundHookTypes.remove(var0);
            PlayerAPI.beforeGetItemIconHookTypes.remove(var0);
            PlayerAPI.overrideGetItemIconHookTypes.remove(var0);
            PlayerAPI.afterGetItemIconHookTypes.remove(var0);
            PlayerAPI.beforeGetSleepTimerHookTypes.remove(var0);
            PlayerAPI.overrideGetSleepTimerHookTypes.remove(var0);
            PlayerAPI.afterGetSleepTimerHookTypes.remove(var0);
            PlayerAPI.beforeGetSpeedModifierHookTypes.remove(var0);
            PlayerAPI.overrideGetSpeedModifierHookTypes.remove(var0);
            PlayerAPI.afterGetSpeedModifierHookTypes.remove(var0);
            PlayerAPI.beforeHandleLavaMovementHookTypes.remove(var0);
            PlayerAPI.overrideHandleLavaMovementHookTypes.remove(var0);
            PlayerAPI.afterHandleLavaMovementHookTypes.remove(var0);
            PlayerAPI.beforeHandleWaterMovementHookTypes.remove(var0);
            PlayerAPI.overrideHandleWaterMovementHookTypes.remove(var0);
            PlayerAPI.afterHandleWaterMovementHookTypes.remove(var0);
            PlayerAPI.beforeHealHookTypes.remove(var0);
            PlayerAPI.overrideHealHookTypes.remove(var0);
            PlayerAPI.afterHealHookTypes.remove(var0);
            PlayerAPI.beforeIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            PlayerAPI.overrideIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            PlayerAPI.afterIsEntityInsideOpaqueBlockHookTypes.remove(var0);
            PlayerAPI.beforeIsInWaterHookTypes.remove(var0);
            PlayerAPI.overrideIsInWaterHookTypes.remove(var0);
            PlayerAPI.afterIsInWaterHookTypes.remove(var0);
            PlayerAPI.beforeIsInsideOfMaterialHookTypes.remove(var0);
            PlayerAPI.overrideIsInsideOfMaterialHookTypes.remove(var0);
            PlayerAPI.afterIsInsideOfMaterialHookTypes.remove(var0);
            PlayerAPI.beforeIsOnLadderHookTypes.remove(var0);
            PlayerAPI.overrideIsOnLadderHookTypes.remove(var0);
            PlayerAPI.afterIsOnLadderHookTypes.remove(var0);
            PlayerAPI.beforeIsSneakingHookTypes.remove(var0);
            PlayerAPI.overrideIsSneakingHookTypes.remove(var0);
            PlayerAPI.afterIsSneakingHookTypes.remove(var0);
            PlayerAPI.beforeIsSprintingHookTypes.remove(var0);
            PlayerAPI.overrideIsSprintingHookTypes.remove(var0);
            PlayerAPI.afterIsSprintingHookTypes.remove(var0);
            PlayerAPI.beforeJumpHookTypes.remove(var0);
            PlayerAPI.overrideJumpHookTypes.remove(var0);
            PlayerAPI.afterJumpHookTypes.remove(var0);
            PlayerAPI.beforeKnockBackHookTypes.remove(var0);
            PlayerAPI.overrideKnockBackHookTypes.remove(var0);
            PlayerAPI.afterKnockBackHookTypes.remove(var0);
            PlayerAPI.beforeMoveEntityHookTypes.remove(var0);
            PlayerAPI.overrideMoveEntityHookTypes.remove(var0);
            PlayerAPI.afterMoveEntityHookTypes.remove(var0);
            PlayerAPI.beforeMoveEntityWithHeadingHookTypes.remove(var0);
            PlayerAPI.overrideMoveEntityWithHeadingHookTypes.remove(var0);
            PlayerAPI.afterMoveEntityWithHeadingHookTypes.remove(var0);
            PlayerAPI.beforeMoveFlyingHookTypes.remove(var0);
            PlayerAPI.overrideMoveFlyingHookTypes.remove(var0);
            PlayerAPI.afterMoveFlyingHookTypes.remove(var0);
            PlayerAPI.beforeOnDeathHookTypes.remove(var0);
            PlayerAPI.overrideOnDeathHookTypes.remove(var0);
            PlayerAPI.afterOnDeathHookTypes.remove(var0);
            PlayerAPI.beforeOnLivingUpdateHookTypes.remove(var0);
            PlayerAPI.overrideOnLivingUpdateHookTypes.remove(var0);
            PlayerAPI.afterOnLivingUpdateHookTypes.remove(var0);
            PlayerAPI.beforeOnKillEntityHookTypes.remove(var0);
            PlayerAPI.overrideOnKillEntityHookTypes.remove(var0);
            PlayerAPI.afterOnKillEntityHookTypes.remove(var0);
            PlayerAPI.beforeOnUpdateHookTypes.remove(var0);
            PlayerAPI.overrideOnUpdateHookTypes.remove(var0);
            PlayerAPI.afterOnUpdateHookTypes.remove(var0);
            PlayerAPI.beforePlayStepSoundHookTypes.remove(var0);
            PlayerAPI.overridePlayStepSoundHookTypes.remove(var0);
            PlayerAPI.afterPlayStepSoundHookTypes.remove(var0);
            PlayerAPI.beforePushOutOfBlocksHookTypes.remove(var0);
            PlayerAPI.overridePushOutOfBlocksHookTypes.remove(var0);
            PlayerAPI.afterPushOutOfBlocksHookTypes.remove(var0);
            PlayerAPI.beforeRayTraceHookTypes.remove(var0);
            PlayerAPI.overrideRayTraceHookTypes.remove(var0);
            PlayerAPI.afterRayTraceHookTypes.remove(var0);
            PlayerAPI.beforeReadEntityFromNBTHookTypes.remove(var0);
            PlayerAPI.overrideReadEntityFromNBTHookTypes.remove(var0);
            PlayerAPI.afterReadEntityFromNBTHookTypes.remove(var0);
            PlayerAPI.beforeRespawnPlayerHookTypes.remove(var0);
            PlayerAPI.overrideRespawnPlayerHookTypes.remove(var0);
            PlayerAPI.afterRespawnPlayerHookTypes.remove(var0);
            PlayerAPI.beforeSendChatMessageHookTypes.remove(var0);
            PlayerAPI.overrideSendChatMessageHookTypes.remove(var0);
            PlayerAPI.afterSendChatMessageHookTypes.remove(var0);
            PlayerAPI.beforeSetDeadHookTypes.remove(var0);
            PlayerAPI.overrideSetDeadHookTypes.remove(var0);
            PlayerAPI.afterSetDeadHookTypes.remove(var0);
            PlayerAPI.beforeSetPositionAndRotationHookTypes.remove(var0);
            PlayerAPI.overrideSetPositionAndRotationHookTypes.remove(var0);
            PlayerAPI.afterSetPositionAndRotationHookTypes.remove(var0);
            PlayerAPI.beforeSleepInBedAtHookTypes.remove(var0);
            PlayerAPI.overrideSleepInBedAtHookTypes.remove(var0);
            PlayerAPI.afterSleepInBedAtHookTypes.remove(var0);
            PlayerAPI.beforeSwingItemHookTypes.remove(var0);
            PlayerAPI.overrideSwingItemHookTypes.remove(var0);
            PlayerAPI.afterSwingItemHookTypes.remove(var0);
            PlayerAPI.beforeUpdateEntityActionStateHookTypes.remove(var0);
            PlayerAPI.overrideUpdateEntityActionStateHookTypes.remove(var0);
            PlayerAPI.afterUpdateEntityActionStateHookTypes.remove(var0);
            PlayerAPI.beforeWriteEntityToNBTHookTypes.remove(var0);
            PlayerAPI.overrideWriteEntityToNBTHookTypes.remove(var0);
            PlayerAPI.afterWriteEntityToNBTHookTypes.remove(var0);
            log("PlayerAPI: unregistered id '" + var0 + "'");
            return true;
        }
        return false;
    }
    
    public static Set getRegisteredIds() {
        return PlayerAPI.unmodifiableAllIds;
    }
    
    private static void addSorting(final String var0, final Map var1, final String[] var2) {
        if (var2 != null && var2.length > 0) {
            var1.put(var0, var2);
        }
    }
    
    private static boolean addMethod(final String var0, final Class var1, final List var2, final String var3, final Class... var4) {
        try {
            final Method var5 = var1.getMethod(var3, (Class[])var4);
            final boolean var6 = var5.getDeclaringClass() != PlayerBase.class;
            if (var6) {
                var2.add(var0);
            }
            return var6;
        }
        catch (Exception var7) {
            throw new RuntimeException("Can not reflect method '" + var3 + "' of class '" + var1.getName() + "'", var7);
        }
    }
    
    public static PlayerAPI create(final EntityPlayerSP var0) {
        if (PlayerAPI.allBaseConstructors.size() > 0) {
            if (!PlayerAPI.initialized) {
                initialize();
            }
            return new PlayerAPI(var0);
        }
        return null;
    }
    
    private static void initialize() {
        sortBases(PlayerAPI.beforeLocalConstructingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeLocalConstructing");
        sortBases(PlayerAPI.afterLocalConstructingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterLocalConstructing");
        sortBases(PlayerAPI.beforeAddExhaustionHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAddExhaustion");
        sortBases(PlayerAPI.overrideAddExhaustionHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAddExhaustion");
        sortBases(PlayerAPI.afterAddExhaustionHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAddExhaustion");
        sortBases(PlayerAPI.beforeAddMovementStatHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAddMovementStat");
        sortBases(PlayerAPI.overrideAddMovementStatHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAddMovementStat");
        sortBases(PlayerAPI.afterAddMovementStatHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAddMovementStat");
        sortBases(PlayerAPI.beforeAddStatHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAddStat");
        sortBases(PlayerAPI.overrideAddStatHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAddStat");
        sortBases(PlayerAPI.afterAddStatHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAddStat");
        sortBases(PlayerAPI.beforeAttackEntityFromHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAttackEntityFrom");
        sortBases(PlayerAPI.overrideAttackEntityFromHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAttackEntityFrom");
        sortBases(PlayerAPI.afterAttackEntityFromHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAttackEntityFrom");
        sortBases(PlayerAPI.beforeAlertWolvesHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAlertWolves");
        sortBases(PlayerAPI.overrideAlertWolvesHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAlertWolves");
        sortBases(PlayerAPI.afterAlertWolvesHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAlertWolves");
        sortBases(PlayerAPI.beforeAttackTargetEntityWithCurrentItemHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeAttackTargetEntityWithCurrentItem");
        sortBases(PlayerAPI.overrideAttackTargetEntityWithCurrentItemHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideAttackTargetEntityWithCurrentItem");
        sortBases(PlayerAPI.afterAttackTargetEntityWithCurrentItemHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterAttackTargetEntityWithCurrentItem");
        sortBases(PlayerAPI.beforeCanBreatheUnderwaterHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeCanBreatheUnderwater");
        sortBases(PlayerAPI.overrideCanBreatheUnderwaterHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideCanBreatheUnderwater");
        sortBases(PlayerAPI.afterCanBreatheUnderwaterHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterCanBreatheUnderwater");
        sortBases(PlayerAPI.beforeCanHarvestBlockHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeCanHarvestBlock");
        sortBases(PlayerAPI.overrideCanHarvestBlockHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideCanHarvestBlock");
        sortBases(PlayerAPI.afterCanHarvestBlockHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterCanHarvestBlock");
        sortBases(PlayerAPI.beforeCanPlayerEditHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeCanPlayerEdit");
        sortBases(PlayerAPI.overrideCanPlayerEditHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideCanPlayerEdit");
        sortBases(PlayerAPI.afterCanPlayerEditHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterCanPlayerEdit");
        sortBases(PlayerAPI.beforeCanTriggerWalkingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeCanTriggerWalking");
        sortBases(PlayerAPI.overrideCanTriggerWalkingHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideCanTriggerWalking");
        sortBases(PlayerAPI.afterCanTriggerWalkingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterCanTriggerWalking");
        sortBases(PlayerAPI.beforeCloseScreenHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeCloseScreen");
        sortBases(PlayerAPI.overrideCloseScreenHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideCloseScreen");
        sortBases(PlayerAPI.afterCloseScreenHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterCloseScreen");
        sortBases(PlayerAPI.beforeDamageEntityHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDamageEntity");
        sortBases(PlayerAPI.overrideDamageEntityHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDamageEntity");
        sortBases(PlayerAPI.afterDamageEntityHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDamageEntity");
        sortBases(PlayerAPI.beforeDisplayGUIBrewingStandHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIBrewingStand");
        sortBases(PlayerAPI.overrideDisplayGUIBrewingStandHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIBrewingStand");
        sortBases(PlayerAPI.afterDisplayGUIBrewingStandHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIBrewingStand");
        sortBases(PlayerAPI.beforeDisplayGUIChestHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIChest");
        sortBases(PlayerAPI.overrideDisplayGUIChestHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIChest");
        sortBases(PlayerAPI.afterDisplayGUIChestHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIChest");
        sortBases(PlayerAPI.beforeDisplayGUIDispenserHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIDispenser");
        sortBases(PlayerAPI.overrideDisplayGUIDispenserHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIDispenser");
        sortBases(PlayerAPI.afterDisplayGUIDispenserHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIDispenser");
        sortBases(PlayerAPI.beforeDisplayGUIEditSignHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIEditSign");
        sortBases(PlayerAPI.overrideDisplayGUIEditSignHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIEditSign");
        sortBases(PlayerAPI.afterDisplayGUIEditSignHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIEditSign");
        sortBases(PlayerAPI.beforeDisplayGUIEnchantmentHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIEnchantment");
        sortBases(PlayerAPI.overrideDisplayGUIEnchantmentHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIEnchantment");
        sortBases(PlayerAPI.afterDisplayGUIEnchantmentHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIEnchantment");
        sortBases(PlayerAPI.beforeDisplayGUIFurnaceHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayGUIFurnace");
        sortBases(PlayerAPI.overrideDisplayGUIFurnaceHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayGUIFurnace");
        sortBases(PlayerAPI.afterDisplayGUIFurnaceHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayGUIFurnace");
        sortBases(PlayerAPI.beforeDisplayWorkbenchGUIHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDisplayWorkbenchGUI");
        sortBases(PlayerAPI.overrideDisplayWorkbenchGUIHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDisplayWorkbenchGUI");
        sortBases(PlayerAPI.afterDisplayWorkbenchGUIHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDisplayWorkbenchGUI");
        sortBases(PlayerAPI.beforeDropOneItemHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDropOneItem");
        sortBases(PlayerAPI.overrideDropOneItemHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDropOneItem");
        sortBases(PlayerAPI.afterDropOneItemHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDropOneItem");
        sortBases(PlayerAPI.beforeDropPlayerItemHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDropPlayerItem");
        sortBases(PlayerAPI.overrideDropPlayerItemHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDropPlayerItem");
        sortBases(PlayerAPI.afterDropPlayerItemHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDropPlayerItem");
        sortBases(PlayerAPI.beforeDropPlayerItemWithRandomChoiceHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeDropPlayerItemWithRandomChoice");
        sortBases(PlayerAPI.overrideDropPlayerItemWithRandomChoiceHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideDropPlayerItemWithRandomChoice");
        sortBases(PlayerAPI.afterDropPlayerItemWithRandomChoiceHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterDropPlayerItemWithRandomChoice");
        sortBases(PlayerAPI.beforeFallHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeFall");
        sortBases(PlayerAPI.overrideFallHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideFall");
        sortBases(PlayerAPI.afterFallHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterFall");
        sortBases(PlayerAPI.beforeGetBrightnessHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetBrightness");
        sortBases(PlayerAPI.overrideGetBrightnessHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetBrightness");
        sortBases(PlayerAPI.afterGetBrightnessHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetBrightness");
        sortBases(PlayerAPI.beforeGetBrightnessForRenderHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetBrightnessForRender");
        sortBases(PlayerAPI.overrideGetBrightnessForRenderHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetBrightnessForRender");
        sortBases(PlayerAPI.afterGetBrightnessForRenderHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetBrightnessForRender");
        sortBases(PlayerAPI.beforeGetCurrentPlayerStrVsBlockHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetCurrentPlayerStrVsBlock");
        sortBases(PlayerAPI.overrideGetCurrentPlayerStrVsBlockHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetCurrentPlayerStrVsBlock");
        sortBases(PlayerAPI.afterGetCurrentPlayerStrVsBlockHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetCurrentPlayerStrVsBlock");
        sortBases(PlayerAPI.beforeGetDistanceSqHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetDistanceSq");
        sortBases(PlayerAPI.overrideGetDistanceSqHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetDistanceSq");
        sortBases(PlayerAPI.afterGetDistanceSqHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetDistanceSq");
        sortBases(PlayerAPI.beforeGetDistanceSqToEntityHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetDistanceSqToEntity");
        sortBases(PlayerAPI.overrideGetDistanceSqToEntityHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetDistanceSqToEntity");
        sortBases(PlayerAPI.afterGetDistanceSqToEntityHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetDistanceSqToEntity");
        sortBases(PlayerAPI.beforeGetFOVMultiplierHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetFOVMultiplier");
        sortBases(PlayerAPI.overrideGetFOVMultiplierHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetFOVMultiplier");
        sortBases(PlayerAPI.afterGetFOVMultiplierHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetFOVMultiplier");
        sortBases(PlayerAPI.beforeGetHurtSoundHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetHurtSound");
        sortBases(PlayerAPI.overrideGetHurtSoundHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetHurtSound");
        sortBases(PlayerAPI.afterGetHurtSoundHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetHurtSound");
        sortBases(PlayerAPI.beforeGetItemIconHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetItemIcon");
        sortBases(PlayerAPI.overrideGetItemIconHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetItemIcon");
        sortBases(PlayerAPI.afterGetItemIconHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetItemIcon");
        sortBases(PlayerAPI.beforeGetSleepTimerHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetSleepTimer");
        sortBases(PlayerAPI.overrideGetSleepTimerHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetSleepTimer");
        sortBases(PlayerAPI.afterGetSleepTimerHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetSleepTimer");
        sortBases(PlayerAPI.beforeGetSpeedModifierHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeGetSpeedModifier");
        sortBases(PlayerAPI.overrideGetSpeedModifierHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideGetSpeedModifier");
        sortBases(PlayerAPI.afterGetSpeedModifierHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterGetSpeedModifier");
        sortBases(PlayerAPI.beforeHandleLavaMovementHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeHandleLavaMovement");
        sortBases(PlayerAPI.overrideHandleLavaMovementHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideHandleLavaMovement");
        sortBases(PlayerAPI.afterHandleLavaMovementHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterHandleLavaMovement");
        sortBases(PlayerAPI.beforeHandleWaterMovementHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeHandleWaterMovement");
        sortBases(PlayerAPI.overrideHandleWaterMovementHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideHandleWaterMovement");
        sortBases(PlayerAPI.afterHandleWaterMovementHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterHandleWaterMovement");
        sortBases(PlayerAPI.beforeHealHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeHeal");
        sortBases(PlayerAPI.overrideHealHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideHeal");
        sortBases(PlayerAPI.afterHealHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterHeal");
        sortBases(PlayerAPI.beforeIsEntityInsideOpaqueBlockHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsEntityInsideOpaqueBlock");
        sortBases(PlayerAPI.overrideIsEntityInsideOpaqueBlockHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsEntityInsideOpaqueBlock");
        sortBases(PlayerAPI.afterIsEntityInsideOpaqueBlockHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsEntityInsideOpaqueBlock");
        sortBases(PlayerAPI.beforeIsInWaterHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsInWater");
        sortBases(PlayerAPI.overrideIsInWaterHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsInWater");
        sortBases(PlayerAPI.afterIsInWaterHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsInWater");
        sortBases(PlayerAPI.beforeIsInsideOfMaterialHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsInsideOfMaterial");
        sortBases(PlayerAPI.overrideIsInsideOfMaterialHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsInsideOfMaterial");
        sortBases(PlayerAPI.afterIsInsideOfMaterialHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsInsideOfMaterial");
        sortBases(PlayerAPI.beforeIsOnLadderHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsOnLadder");
        sortBases(PlayerAPI.overrideIsOnLadderHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsOnLadder");
        sortBases(PlayerAPI.afterIsOnLadderHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsOnLadder");
        sortBases(PlayerAPI.beforeIsSneakingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsSneaking");
        sortBases(PlayerAPI.overrideIsSneakingHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsSneaking");
        sortBases(PlayerAPI.afterIsSneakingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsSneaking");
        sortBases(PlayerAPI.beforeIsSprintingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeIsSprinting");
        sortBases(PlayerAPI.overrideIsSprintingHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideIsSprinting");
        sortBases(PlayerAPI.afterIsSprintingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterIsSprinting");
        sortBases(PlayerAPI.beforeJumpHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeJump");
        sortBases(PlayerAPI.overrideJumpHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideJump");
        sortBases(PlayerAPI.afterJumpHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterJump");
        sortBases(PlayerAPI.beforeKnockBackHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeKnockBack");
        sortBases(PlayerAPI.overrideKnockBackHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideKnockBack");
        sortBases(PlayerAPI.afterKnockBackHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterKnockBack");
        sortBases(PlayerAPI.beforeMoveEntityHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeMoveEntity");
        sortBases(PlayerAPI.overrideMoveEntityHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideMoveEntity");
        sortBases(PlayerAPI.afterMoveEntityHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterMoveEntity");
        sortBases(PlayerAPI.beforeMoveEntityWithHeadingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeMoveEntityWithHeading");
        sortBases(PlayerAPI.overrideMoveEntityWithHeadingHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideMoveEntityWithHeading");
        sortBases(PlayerAPI.afterMoveEntityWithHeadingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterMoveEntityWithHeading");
        sortBases(PlayerAPI.beforeMoveFlyingHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeMoveFlying");
        sortBases(PlayerAPI.overrideMoveFlyingHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideMoveFlying");
        sortBases(PlayerAPI.afterMoveFlyingHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterMoveFlying");
        sortBases(PlayerAPI.beforeOnDeathHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeOnDeath");
        sortBases(PlayerAPI.overrideOnDeathHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideOnDeath");
        sortBases(PlayerAPI.afterOnDeathHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterOnDeath");
        sortBases(PlayerAPI.beforeOnLivingUpdateHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeOnLivingUpdate");
        sortBases(PlayerAPI.overrideOnLivingUpdateHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideOnLivingUpdate");
        sortBases(PlayerAPI.afterOnLivingUpdateHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterOnLivingUpdate");
        sortBases(PlayerAPI.beforeOnKillEntityHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeOnKillEntity");
        sortBases(PlayerAPI.overrideOnKillEntityHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideOnKillEntity");
        sortBases(PlayerAPI.afterOnKillEntityHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterOnKillEntity");
        sortBases(PlayerAPI.beforeOnUpdateHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeOnUpdate");
        sortBases(PlayerAPI.overrideOnUpdateHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideOnUpdate");
        sortBases(PlayerAPI.afterOnUpdateHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterOnUpdate");
        sortBases(PlayerAPI.beforePlayStepSoundHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforePlayStepSound");
        sortBases(PlayerAPI.overridePlayStepSoundHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overridePlayStepSound");
        sortBases(PlayerAPI.afterPlayStepSoundHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterPlayStepSound");
        sortBases(PlayerAPI.beforePushOutOfBlocksHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforePushOutOfBlocks");
        sortBases(PlayerAPI.overridePushOutOfBlocksHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overridePushOutOfBlocks");
        sortBases(PlayerAPI.afterPushOutOfBlocksHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterPushOutOfBlocks");
        sortBases(PlayerAPI.beforeRayTraceHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeRayTrace");
        sortBases(PlayerAPI.overrideRayTraceHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideRayTrace");
        sortBases(PlayerAPI.afterRayTraceHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterRayTrace");
        sortBases(PlayerAPI.beforeReadEntityFromNBTHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeReadEntityFromNBT");
        sortBases(PlayerAPI.overrideReadEntityFromNBTHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideReadEntityFromNBT");
        sortBases(PlayerAPI.afterReadEntityFromNBTHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterReadEntityFromNBT");
        sortBases(PlayerAPI.beforeRespawnPlayerHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeRespawnPlayer");
        sortBases(PlayerAPI.overrideRespawnPlayerHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideRespawnPlayer");
        sortBases(PlayerAPI.afterRespawnPlayerHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterRespawnPlayer");
        sortBases(PlayerAPI.beforeSendChatMessageHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeSendChatMessage");
        sortBases(PlayerAPI.overrideSendChatMessageHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideSendChatMessage");
        sortBases(PlayerAPI.afterSendChatMessageHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterSendChatMessage");
        sortBases(PlayerAPI.beforeSetDeadHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeSetDead");
        sortBases(PlayerAPI.overrideSetDeadHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideSetDead");
        sortBases(PlayerAPI.afterSetDeadHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterSetDead");
        sortBases(PlayerAPI.beforeSetPositionAndRotationHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeSetPositionAndRotation");
        sortBases(PlayerAPI.overrideSetPositionAndRotationHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideSetPositionAndRotation");
        sortBases(PlayerAPI.afterSetPositionAndRotationHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterSetPositionAndRotation");
        sortBases(PlayerAPI.beforeSleepInBedAtHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeSleepInBedAt");
        sortBases(PlayerAPI.overrideSleepInBedAtHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideSleepInBedAt");
        sortBases(PlayerAPI.afterSleepInBedAtHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterSleepInBedAt");
        sortBases(PlayerAPI.beforeSwingItemHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeSwingItem");
        sortBases(PlayerAPI.overrideSwingItemHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideSwingItem");
        sortBases(PlayerAPI.afterSwingItemHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterSwingItem");
        sortBases(PlayerAPI.beforeUpdateEntityActionStateHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeUpdateEntityActionState");
        sortBases(PlayerAPI.overrideUpdateEntityActionStateHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideUpdateEntityActionState");
        sortBases(PlayerAPI.afterUpdateEntityActionStateHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterUpdateEntityActionState");
        sortBases(PlayerAPI.beforeWriteEntityToNBTHookTypes, PlayerAPI.allBaseBeforeSuperiors, PlayerAPI.allBaseBeforeInferiors, "beforeWriteEntityToNBT");
        sortBases(PlayerAPI.overrideWriteEntityToNBTHookTypes, PlayerAPI.allBaseOverrideSuperiors, PlayerAPI.allBaseOverrideInferiors, "overrideWriteEntityToNBT");
        sortBases(PlayerAPI.afterWriteEntityToNBTHookTypes, PlayerAPI.allBaseAfterSuperiors, PlayerAPI.allBaseAfterInferiors, "afterWriteEntityToNBT");
        PlayerAPI.initialized = true;
    }
    
    public static void beforeLocalConstructing(final EntityPlayerSP var0, final Minecraft var1, final World var2, final Session var3, final int var4) {
        if (var0.playerAPI != null) {
            var0.playerAPI.beforeLocalConstructing(var1, var2, var3, var4);
        }
    }
    
    public static void afterLocalConstructing(final EntityPlayerSP var0, final Minecraft var1, final World var2, final Session var3, final int var4) {
        if (var0.playerAPI != null) {
            var0.playerAPI.afterLocalConstructing(var1, var2, var3, var4);
        }
    }
    
    private static void sortBases(final List var0, final Map var1, final Map var2, final String var3) {
        new PlayerBaseSorter(var0, var1, var2, var3).Sort();
    }
    
    private PlayerAPI(final EntityPlayerSP var1) {
        this.allBaseObjects = new Hashtable();
        this.unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
        this.player = var1;
        final Object[] var2 = { this };
        final Object[] var3 = { this, null };
        for (final Map.Entry var5 : PlayerAPI.allBaseConstructors.entrySet()) {
            final Constructor var6 = var5.getValue();
            var3[1] = var5.getKey();
            PlayerBase var7;
            try {
                if (var6.getParameterTypes().length == 1) {
                    var7 = var6.newInstance(var2);
                }
                else {
                    var7 = var6.newInstance(var3);
                }
            }
            catch (Exception var8) {
                throw new RuntimeException("Exception while creating a PlayerBase of type '" + var6.getDeclaringClass() + "'", var8);
            }
            this.allBaseObjects.put(var5.getKey(), var7);
        }
        this.beforeLocalConstructingHooks = this.create(PlayerAPI.beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(PlayerAPI.afterLocalConstructingHookTypes);
        this.beforeAddExhaustionHooks = this.create(PlayerAPI.beforeAddExhaustionHookTypes);
        this.overrideAddExhaustionHooks = this.create(PlayerAPI.overrideAddExhaustionHookTypes);
        this.afterAddExhaustionHooks = this.create(PlayerAPI.afterAddExhaustionHookTypes);
        this.isAddExhaustionModded = (this.beforeAddExhaustionHooks != null || this.overrideAddExhaustionHooks != null || this.afterAddExhaustionHooks != null);
        this.beforeAddMovementStatHooks = this.create(PlayerAPI.beforeAddMovementStatHookTypes);
        this.overrideAddMovementStatHooks = this.create(PlayerAPI.overrideAddMovementStatHookTypes);
        this.afterAddMovementStatHooks = this.create(PlayerAPI.afterAddMovementStatHookTypes);
        this.isAddMovementStatModded = (this.beforeAddMovementStatHooks != null || this.overrideAddMovementStatHooks != null || this.afterAddMovementStatHooks != null);
        this.beforeAddStatHooks = this.create(PlayerAPI.beforeAddStatHookTypes);
        this.overrideAddStatHooks = this.create(PlayerAPI.overrideAddStatHookTypes);
        this.afterAddStatHooks = this.create(PlayerAPI.afterAddStatHookTypes);
        this.isAddStatModded = (this.beforeAddStatHooks != null || this.overrideAddStatHooks != null || this.afterAddStatHooks != null);
        this.beforeAttackEntityFromHooks = this.create(PlayerAPI.beforeAttackEntityFromHookTypes);
        this.overrideAttackEntityFromHooks = this.create(PlayerAPI.overrideAttackEntityFromHookTypes);
        this.afterAttackEntityFromHooks = this.create(PlayerAPI.afterAttackEntityFromHookTypes);
        this.isAttackEntityFromModded = (this.beforeAttackEntityFromHooks != null || this.overrideAttackEntityFromHooks != null || this.afterAttackEntityFromHooks != null);
        this.beforeAlertWolvesHooks = this.create(PlayerAPI.beforeAlertWolvesHookTypes);
        this.overrideAlertWolvesHooks = this.create(PlayerAPI.overrideAlertWolvesHookTypes);
        this.afterAlertWolvesHooks = this.create(PlayerAPI.afterAlertWolvesHookTypes);
        this.isAlertWolvesModded = (this.beforeAlertWolvesHooks != null || this.overrideAlertWolvesHooks != null || this.afterAlertWolvesHooks != null);
        this.beforeAttackTargetEntityWithCurrentItemHooks = this.create(PlayerAPI.beforeAttackTargetEntityWithCurrentItemHookTypes);
        this.overrideAttackTargetEntityWithCurrentItemHooks = this.create(PlayerAPI.overrideAttackTargetEntityWithCurrentItemHookTypes);
        this.afterAttackTargetEntityWithCurrentItemHooks = this.create(PlayerAPI.afterAttackTargetEntityWithCurrentItemHookTypes);
        this.isAttackTargetEntityWithCurrentItemModded = (this.beforeAttackTargetEntityWithCurrentItemHooks != null || this.overrideAttackTargetEntityWithCurrentItemHooks != null || this.afterAttackTargetEntityWithCurrentItemHooks != null);
        this.beforeCanBreatheUnderwaterHooks = this.create(PlayerAPI.beforeCanBreatheUnderwaterHookTypes);
        this.overrideCanBreatheUnderwaterHooks = this.create(PlayerAPI.overrideCanBreatheUnderwaterHookTypes);
        this.afterCanBreatheUnderwaterHooks = this.create(PlayerAPI.afterCanBreatheUnderwaterHookTypes);
        this.isCanBreatheUnderwaterModded = (this.beforeCanBreatheUnderwaterHooks != null || this.overrideCanBreatheUnderwaterHooks != null || this.afterCanBreatheUnderwaterHooks != null);
        this.beforeCanHarvestBlockHooks = this.create(PlayerAPI.beforeCanHarvestBlockHookTypes);
        this.overrideCanHarvestBlockHooks = this.create(PlayerAPI.overrideCanHarvestBlockHookTypes);
        this.afterCanHarvestBlockHooks = this.create(PlayerAPI.afterCanHarvestBlockHookTypes);
        this.isCanHarvestBlockModded = (this.beforeCanHarvestBlockHooks != null || this.overrideCanHarvestBlockHooks != null || this.afterCanHarvestBlockHooks != null);
        this.beforeCanPlayerEditHooks = this.create(PlayerAPI.beforeCanPlayerEditHookTypes);
        this.overrideCanPlayerEditHooks = this.create(PlayerAPI.overrideCanPlayerEditHookTypes);
        this.afterCanPlayerEditHooks = this.create(PlayerAPI.afterCanPlayerEditHookTypes);
        this.isCanPlayerEditModded = (this.beforeCanPlayerEditHooks != null || this.overrideCanPlayerEditHooks != null || this.afterCanPlayerEditHooks != null);
        this.beforeCanTriggerWalkingHooks = this.create(PlayerAPI.beforeCanTriggerWalkingHookTypes);
        this.overrideCanTriggerWalkingHooks = this.create(PlayerAPI.overrideCanTriggerWalkingHookTypes);
        this.afterCanTriggerWalkingHooks = this.create(PlayerAPI.afterCanTriggerWalkingHookTypes);
        this.isCanTriggerWalkingModded = (this.beforeCanTriggerWalkingHooks != null || this.overrideCanTriggerWalkingHooks != null || this.afterCanTriggerWalkingHooks != null);
        this.beforeCloseScreenHooks = this.create(PlayerAPI.beforeCloseScreenHookTypes);
        this.overrideCloseScreenHooks = this.create(PlayerAPI.overrideCloseScreenHookTypes);
        this.afterCloseScreenHooks = this.create(PlayerAPI.afterCloseScreenHookTypes);
        this.isCloseScreenModded = (this.beforeCloseScreenHooks != null || this.overrideCloseScreenHooks != null || this.afterCloseScreenHooks != null);
        this.beforeDamageEntityHooks = this.create(PlayerAPI.beforeDamageEntityHookTypes);
        this.overrideDamageEntityHooks = this.create(PlayerAPI.overrideDamageEntityHookTypes);
        this.afterDamageEntityHooks = this.create(PlayerAPI.afterDamageEntityHookTypes);
        this.isDamageEntityModded = (this.beforeDamageEntityHooks != null || this.overrideDamageEntityHooks != null || this.afterDamageEntityHooks != null);
        this.beforeDisplayGUIBrewingStandHooks = this.create(PlayerAPI.beforeDisplayGUIBrewingStandHookTypes);
        this.overrideDisplayGUIBrewingStandHooks = this.create(PlayerAPI.overrideDisplayGUIBrewingStandHookTypes);
        this.afterDisplayGUIBrewingStandHooks = this.create(PlayerAPI.afterDisplayGUIBrewingStandHookTypes);
        this.isDisplayGUIBrewingStandModded = (this.beforeDisplayGUIBrewingStandHooks != null || this.overrideDisplayGUIBrewingStandHooks != null || this.afterDisplayGUIBrewingStandHooks != null);
        this.beforeDisplayGUIChestHooks = this.create(PlayerAPI.beforeDisplayGUIChestHookTypes);
        this.overrideDisplayGUIChestHooks = this.create(PlayerAPI.overrideDisplayGUIChestHookTypes);
        this.afterDisplayGUIChestHooks = this.create(PlayerAPI.afterDisplayGUIChestHookTypes);
        this.isDisplayGUIChestModded = (this.beforeDisplayGUIChestHooks != null || this.overrideDisplayGUIChestHooks != null || this.afterDisplayGUIChestHooks != null);
        this.beforeDisplayGUIDispenserHooks = this.create(PlayerAPI.beforeDisplayGUIDispenserHookTypes);
        this.overrideDisplayGUIDispenserHooks = this.create(PlayerAPI.overrideDisplayGUIDispenserHookTypes);
        this.afterDisplayGUIDispenserHooks = this.create(PlayerAPI.afterDisplayGUIDispenserHookTypes);
        this.isDisplayGUIDispenserModded = (this.beforeDisplayGUIDispenserHooks != null || this.overrideDisplayGUIDispenserHooks != null || this.afterDisplayGUIDispenserHooks != null);
        this.beforeDisplayGUIEditSignHooks = this.create(PlayerAPI.beforeDisplayGUIEditSignHookTypes);
        this.overrideDisplayGUIEditSignHooks = this.create(PlayerAPI.overrideDisplayGUIEditSignHookTypes);
        this.afterDisplayGUIEditSignHooks = this.create(PlayerAPI.afterDisplayGUIEditSignHookTypes);
        this.isDisplayGUIEditSignModded = (this.beforeDisplayGUIEditSignHooks != null || this.overrideDisplayGUIEditSignHooks != null || this.afterDisplayGUIEditSignHooks != null);
        this.beforeDisplayGUIEnchantmentHooks = this.create(PlayerAPI.beforeDisplayGUIEnchantmentHookTypes);
        this.overrideDisplayGUIEnchantmentHooks = this.create(PlayerAPI.overrideDisplayGUIEnchantmentHookTypes);
        this.afterDisplayGUIEnchantmentHooks = this.create(PlayerAPI.afterDisplayGUIEnchantmentHookTypes);
        this.isDisplayGUIEnchantmentModded = (this.beforeDisplayGUIEnchantmentHooks != null || this.overrideDisplayGUIEnchantmentHooks != null || this.afterDisplayGUIEnchantmentHooks != null);
        this.beforeDisplayGUIFurnaceHooks = this.create(PlayerAPI.beforeDisplayGUIFurnaceHookTypes);
        this.overrideDisplayGUIFurnaceHooks = this.create(PlayerAPI.overrideDisplayGUIFurnaceHookTypes);
        this.afterDisplayGUIFurnaceHooks = this.create(PlayerAPI.afterDisplayGUIFurnaceHookTypes);
        this.isDisplayGUIFurnaceModded = (this.beforeDisplayGUIFurnaceHooks != null || this.overrideDisplayGUIFurnaceHooks != null || this.afterDisplayGUIFurnaceHooks != null);
        this.beforeDisplayWorkbenchGUIHooks = this.create(PlayerAPI.beforeDisplayWorkbenchGUIHookTypes);
        this.overrideDisplayWorkbenchGUIHooks = this.create(PlayerAPI.overrideDisplayWorkbenchGUIHookTypes);
        this.afterDisplayWorkbenchGUIHooks = this.create(PlayerAPI.afterDisplayWorkbenchGUIHookTypes);
        this.isDisplayWorkbenchGUIModded = (this.beforeDisplayWorkbenchGUIHooks != null || this.overrideDisplayWorkbenchGUIHooks != null || this.afterDisplayWorkbenchGUIHooks != null);
        this.beforeDropOneItemHooks = this.create(PlayerAPI.beforeDropOneItemHookTypes);
        this.overrideDropOneItemHooks = this.create(PlayerAPI.overrideDropOneItemHookTypes);
        this.afterDropOneItemHooks = this.create(PlayerAPI.afterDropOneItemHookTypes);
        this.isDropOneItemModded = (this.beforeDropOneItemHooks != null || this.overrideDropOneItemHooks != null || this.afterDropOneItemHooks != null);
        this.beforeDropPlayerItemHooks = this.create(PlayerAPI.beforeDropPlayerItemHookTypes);
        this.overrideDropPlayerItemHooks = this.create(PlayerAPI.overrideDropPlayerItemHookTypes);
        this.afterDropPlayerItemHooks = this.create(PlayerAPI.afterDropPlayerItemHookTypes);
        this.isDropPlayerItemModded = (this.beforeDropPlayerItemHooks != null || this.overrideDropPlayerItemHooks != null || this.afterDropPlayerItemHooks != null);
        this.beforeDropPlayerItemWithRandomChoiceHooks = this.create(PlayerAPI.beforeDropPlayerItemWithRandomChoiceHookTypes);
        this.overrideDropPlayerItemWithRandomChoiceHooks = this.create(PlayerAPI.overrideDropPlayerItemWithRandomChoiceHookTypes);
        this.afterDropPlayerItemWithRandomChoiceHooks = this.create(PlayerAPI.afterDropPlayerItemWithRandomChoiceHookTypes);
        this.isDropPlayerItemWithRandomChoiceModded = (this.beforeDropPlayerItemWithRandomChoiceHooks != null || this.overrideDropPlayerItemWithRandomChoiceHooks != null || this.afterDropPlayerItemWithRandomChoiceHooks != null);
        this.beforeFallHooks = this.create(PlayerAPI.beforeFallHookTypes);
        this.overrideFallHooks = this.create(PlayerAPI.overrideFallHookTypes);
        this.afterFallHooks = this.create(PlayerAPI.afterFallHookTypes);
        this.isFallModded = (this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null);
        this.beforeGetBrightnessHooks = this.create(PlayerAPI.beforeGetBrightnessHookTypes);
        this.overrideGetBrightnessHooks = this.create(PlayerAPI.overrideGetBrightnessHookTypes);
        this.afterGetBrightnessHooks = this.create(PlayerAPI.afterGetBrightnessHookTypes);
        this.isGetBrightnessModded = (this.beforeGetBrightnessHooks != null || this.overrideGetBrightnessHooks != null || this.afterGetBrightnessHooks != null);
        this.beforeGetBrightnessForRenderHooks = this.create(PlayerAPI.beforeGetBrightnessForRenderHookTypes);
        this.overrideGetBrightnessForRenderHooks = this.create(PlayerAPI.overrideGetBrightnessForRenderHookTypes);
        this.afterGetBrightnessForRenderHooks = this.create(PlayerAPI.afterGetBrightnessForRenderHookTypes);
        this.isGetBrightnessForRenderModded = (this.beforeGetBrightnessForRenderHooks != null || this.overrideGetBrightnessForRenderHooks != null || this.afterGetBrightnessForRenderHooks != null);
        this.beforeGetCurrentPlayerStrVsBlockHooks = this.create(PlayerAPI.beforeGetCurrentPlayerStrVsBlockHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockHooks = this.create(PlayerAPI.overrideGetCurrentPlayerStrVsBlockHookTypes);
        this.afterGetCurrentPlayerStrVsBlockHooks = this.create(PlayerAPI.afterGetCurrentPlayerStrVsBlockHookTypes);
        this.isGetCurrentPlayerStrVsBlockModded = (this.beforeGetCurrentPlayerStrVsBlockHooks != null || this.overrideGetCurrentPlayerStrVsBlockHooks != null || this.afterGetCurrentPlayerStrVsBlockHooks != null);
        this.beforeGetDistanceSqHooks = this.create(PlayerAPI.beforeGetDistanceSqHookTypes);
        this.overrideGetDistanceSqHooks = this.create(PlayerAPI.overrideGetDistanceSqHookTypes);
        this.afterGetDistanceSqHooks = this.create(PlayerAPI.afterGetDistanceSqHookTypes);
        this.isGetDistanceSqModded = (this.beforeGetDistanceSqHooks != null || this.overrideGetDistanceSqHooks != null || this.afterGetDistanceSqHooks != null);
        this.beforeGetDistanceSqToEntityHooks = this.create(PlayerAPI.beforeGetDistanceSqToEntityHookTypes);
        this.overrideGetDistanceSqToEntityHooks = this.create(PlayerAPI.overrideGetDistanceSqToEntityHookTypes);
        this.afterGetDistanceSqToEntityHooks = this.create(PlayerAPI.afterGetDistanceSqToEntityHookTypes);
        this.isGetDistanceSqToEntityModded = (this.beforeGetDistanceSqToEntityHooks != null || this.overrideGetDistanceSqToEntityHooks != null || this.afterGetDistanceSqToEntityHooks != null);
        this.beforeGetFOVMultiplierHooks = this.create(PlayerAPI.beforeGetFOVMultiplierHookTypes);
        this.overrideGetFOVMultiplierHooks = this.create(PlayerAPI.overrideGetFOVMultiplierHookTypes);
        this.afterGetFOVMultiplierHooks = this.create(PlayerAPI.afterGetFOVMultiplierHookTypes);
        this.isGetFOVMultiplierModded = (this.beforeGetFOVMultiplierHooks != null || this.overrideGetFOVMultiplierHooks != null || this.afterGetFOVMultiplierHooks != null);
        this.beforeGetHurtSoundHooks = this.create(PlayerAPI.beforeGetHurtSoundHookTypes);
        this.overrideGetHurtSoundHooks = this.create(PlayerAPI.overrideGetHurtSoundHookTypes);
        this.afterGetHurtSoundHooks = this.create(PlayerAPI.afterGetHurtSoundHookTypes);
        this.isGetHurtSoundModded = (this.beforeGetHurtSoundHooks != null || this.overrideGetHurtSoundHooks != null || this.afterGetHurtSoundHooks != null);
        this.beforeGetItemIconHooks = this.create(PlayerAPI.beforeGetItemIconHookTypes);
        this.overrideGetItemIconHooks = this.create(PlayerAPI.overrideGetItemIconHookTypes);
        this.afterGetItemIconHooks = this.create(PlayerAPI.afterGetItemIconHookTypes);
        this.isGetItemIconModded = (this.beforeGetItemIconHooks != null || this.overrideGetItemIconHooks != null || this.afterGetItemIconHooks != null);
        this.beforeGetSleepTimerHooks = this.create(PlayerAPI.beforeGetSleepTimerHookTypes);
        this.overrideGetSleepTimerHooks = this.create(PlayerAPI.overrideGetSleepTimerHookTypes);
        this.afterGetSleepTimerHooks = this.create(PlayerAPI.afterGetSleepTimerHookTypes);
        this.isGetSleepTimerModded = (this.beforeGetSleepTimerHooks != null || this.overrideGetSleepTimerHooks != null || this.afterGetSleepTimerHooks != null);
        this.beforeGetSpeedModifierHooks = this.create(PlayerAPI.beforeGetSpeedModifierHookTypes);
        this.overrideGetSpeedModifierHooks = this.create(PlayerAPI.overrideGetSpeedModifierHookTypes);
        this.afterGetSpeedModifierHooks = this.create(PlayerAPI.afterGetSpeedModifierHookTypes);
        this.isGetSpeedModifierModded = (this.beforeGetSpeedModifierHooks != null || this.overrideGetSpeedModifierHooks != null || this.afterGetSpeedModifierHooks != null);
        this.beforeHandleLavaMovementHooks = this.create(PlayerAPI.beforeHandleLavaMovementHookTypes);
        this.overrideHandleLavaMovementHooks = this.create(PlayerAPI.overrideHandleLavaMovementHookTypes);
        this.afterHandleLavaMovementHooks = this.create(PlayerAPI.afterHandleLavaMovementHookTypes);
        this.isHandleLavaMovementModded = (this.beforeHandleLavaMovementHooks != null || this.overrideHandleLavaMovementHooks != null || this.afterHandleLavaMovementHooks != null);
        this.beforeHandleWaterMovementHooks = this.create(PlayerAPI.beforeHandleWaterMovementHookTypes);
        this.overrideHandleWaterMovementHooks = this.create(PlayerAPI.overrideHandleWaterMovementHookTypes);
        this.afterHandleWaterMovementHooks = this.create(PlayerAPI.afterHandleWaterMovementHookTypes);
        this.isHandleWaterMovementModded = (this.beforeHandleWaterMovementHooks != null || this.overrideHandleWaterMovementHooks != null || this.afterHandleWaterMovementHooks != null);
        this.beforeHealHooks = this.create(PlayerAPI.beforeHealHookTypes);
        this.overrideHealHooks = this.create(PlayerAPI.overrideHealHookTypes);
        this.afterHealHooks = this.create(PlayerAPI.afterHealHookTypes);
        this.isHealModded = (this.beforeHealHooks != null || this.overrideHealHooks != null || this.afterHealHooks != null);
        this.beforeIsEntityInsideOpaqueBlockHooks = this.create(PlayerAPI.beforeIsEntityInsideOpaqueBlockHookTypes);
        this.overrideIsEntityInsideOpaqueBlockHooks = this.create(PlayerAPI.overrideIsEntityInsideOpaqueBlockHookTypes);
        this.afterIsEntityInsideOpaqueBlockHooks = this.create(PlayerAPI.afterIsEntityInsideOpaqueBlockHookTypes);
        this.isIsEntityInsideOpaqueBlockModded = (this.beforeIsEntityInsideOpaqueBlockHooks != null || this.overrideIsEntityInsideOpaqueBlockHooks != null || this.afterIsEntityInsideOpaqueBlockHooks != null);
        this.beforeIsInWaterHooks = this.create(PlayerAPI.beforeIsInWaterHookTypes);
        this.overrideIsInWaterHooks = this.create(PlayerAPI.overrideIsInWaterHookTypes);
        this.afterIsInWaterHooks = this.create(PlayerAPI.afterIsInWaterHookTypes);
        this.isIsInWaterModded = (this.beforeIsInWaterHooks != null || this.overrideIsInWaterHooks != null || this.afterIsInWaterHooks != null);
        this.beforeIsInsideOfMaterialHooks = this.create(PlayerAPI.beforeIsInsideOfMaterialHookTypes);
        this.overrideIsInsideOfMaterialHooks = this.create(PlayerAPI.overrideIsInsideOfMaterialHookTypes);
        this.afterIsInsideOfMaterialHooks = this.create(PlayerAPI.afterIsInsideOfMaterialHookTypes);
        this.isIsInsideOfMaterialModded = (this.beforeIsInsideOfMaterialHooks != null || this.overrideIsInsideOfMaterialHooks != null || this.afterIsInsideOfMaterialHooks != null);
        this.beforeIsOnLadderHooks = this.create(PlayerAPI.beforeIsOnLadderHookTypes);
        this.overrideIsOnLadderHooks = this.create(PlayerAPI.overrideIsOnLadderHookTypes);
        this.afterIsOnLadderHooks = this.create(PlayerAPI.afterIsOnLadderHookTypes);
        this.isIsOnLadderModded = (this.beforeIsOnLadderHooks != null || this.overrideIsOnLadderHooks != null || this.afterIsOnLadderHooks != null);
        this.beforeIsSneakingHooks = this.create(PlayerAPI.beforeIsSneakingHookTypes);
        this.overrideIsSneakingHooks = this.create(PlayerAPI.overrideIsSneakingHookTypes);
        this.afterIsSneakingHooks = this.create(PlayerAPI.afterIsSneakingHookTypes);
        this.isIsSneakingModded = (this.beforeIsSneakingHooks != null || this.overrideIsSneakingHooks != null || this.afterIsSneakingHooks != null);
        this.beforeIsSprintingHooks = this.create(PlayerAPI.beforeIsSprintingHookTypes);
        this.overrideIsSprintingHooks = this.create(PlayerAPI.overrideIsSprintingHookTypes);
        this.afterIsSprintingHooks = this.create(PlayerAPI.afterIsSprintingHookTypes);
        this.isIsSprintingModded = (this.beforeIsSprintingHooks != null || this.overrideIsSprintingHooks != null || this.afterIsSprintingHooks != null);
        this.beforeJumpHooks = this.create(PlayerAPI.beforeJumpHookTypes);
        this.overrideJumpHooks = this.create(PlayerAPI.overrideJumpHookTypes);
        this.afterJumpHooks = this.create(PlayerAPI.afterJumpHookTypes);
        this.isJumpModded = (this.beforeJumpHooks != null || this.overrideJumpHooks != null || this.afterJumpHooks != null);
        this.beforeKnockBackHooks = this.create(PlayerAPI.beforeKnockBackHookTypes);
        this.overrideKnockBackHooks = this.create(PlayerAPI.overrideKnockBackHookTypes);
        this.afterKnockBackHooks = this.create(PlayerAPI.afterKnockBackHookTypes);
        this.isKnockBackModded = (this.beforeKnockBackHooks != null || this.overrideKnockBackHooks != null || this.afterKnockBackHooks != null);
        this.beforeMoveEntityHooks = this.create(PlayerAPI.beforeMoveEntityHookTypes);
        this.overrideMoveEntityHooks = this.create(PlayerAPI.overrideMoveEntityHookTypes);
        this.afterMoveEntityHooks = this.create(PlayerAPI.afterMoveEntityHookTypes);
        this.isMoveEntityModded = (this.beforeMoveEntityHooks != null || this.overrideMoveEntityHooks != null || this.afterMoveEntityHooks != null);
        this.beforeMoveEntityWithHeadingHooks = this.create(PlayerAPI.beforeMoveEntityWithHeadingHookTypes);
        this.overrideMoveEntityWithHeadingHooks = this.create(PlayerAPI.overrideMoveEntityWithHeadingHookTypes);
        this.afterMoveEntityWithHeadingHooks = this.create(PlayerAPI.afterMoveEntityWithHeadingHookTypes);
        this.isMoveEntityWithHeadingModded = (this.beforeMoveEntityWithHeadingHooks != null || this.overrideMoveEntityWithHeadingHooks != null || this.afterMoveEntityWithHeadingHooks != null);
        this.beforeMoveFlyingHooks = this.create(PlayerAPI.beforeMoveFlyingHookTypes);
        this.overrideMoveFlyingHooks = this.create(PlayerAPI.overrideMoveFlyingHookTypes);
        this.afterMoveFlyingHooks = this.create(PlayerAPI.afterMoveFlyingHookTypes);
        this.isMoveFlyingModded = (this.beforeMoveFlyingHooks != null || this.overrideMoveFlyingHooks != null || this.afterMoveFlyingHooks != null);
        this.beforeOnDeathHooks = this.create(PlayerAPI.beforeOnDeathHookTypes);
        this.overrideOnDeathHooks = this.create(PlayerAPI.overrideOnDeathHookTypes);
        this.afterOnDeathHooks = this.create(PlayerAPI.afterOnDeathHookTypes);
        this.isOnDeathModded = (this.beforeOnDeathHooks != null || this.overrideOnDeathHooks != null || this.afterOnDeathHooks != null);
        this.beforeOnLivingUpdateHooks = this.create(PlayerAPI.beforeOnLivingUpdateHookTypes);
        this.overrideOnLivingUpdateHooks = this.create(PlayerAPI.overrideOnLivingUpdateHookTypes);
        this.afterOnLivingUpdateHooks = this.create(PlayerAPI.afterOnLivingUpdateHookTypes);
        this.isOnLivingUpdateModded = (this.beforeOnLivingUpdateHooks != null || this.overrideOnLivingUpdateHooks != null || this.afterOnLivingUpdateHooks != null);
        this.beforeOnKillEntityHooks = this.create(PlayerAPI.beforeOnKillEntityHookTypes);
        this.overrideOnKillEntityHooks = this.create(PlayerAPI.overrideOnKillEntityHookTypes);
        this.afterOnKillEntityHooks = this.create(PlayerAPI.afterOnKillEntityHookTypes);
        this.isOnKillEntityModded = (this.beforeOnKillEntityHooks != null || this.overrideOnKillEntityHooks != null || this.afterOnKillEntityHooks != null);
        this.beforeOnUpdateHooks = this.create(PlayerAPI.beforeOnUpdateHookTypes);
        this.overrideOnUpdateHooks = this.create(PlayerAPI.overrideOnUpdateHookTypes);
        this.afterOnUpdateHooks = this.create(PlayerAPI.afterOnUpdateHookTypes);
        this.isOnUpdateModded = (this.beforeOnUpdateHooks != null || this.overrideOnUpdateHooks != null || this.afterOnUpdateHooks != null);
        this.beforePlayStepSoundHooks = this.create(PlayerAPI.beforePlayStepSoundHookTypes);
        this.overridePlayStepSoundHooks = this.create(PlayerAPI.overridePlayStepSoundHookTypes);
        this.afterPlayStepSoundHooks = this.create(PlayerAPI.afterPlayStepSoundHookTypes);
        this.isPlayStepSoundModded = (this.beforePlayStepSoundHooks != null || this.overridePlayStepSoundHooks != null || this.afterPlayStepSoundHooks != null);
        this.beforePushOutOfBlocksHooks = this.create(PlayerAPI.beforePushOutOfBlocksHookTypes);
        this.overridePushOutOfBlocksHooks = this.create(PlayerAPI.overridePushOutOfBlocksHookTypes);
        this.afterPushOutOfBlocksHooks = this.create(PlayerAPI.afterPushOutOfBlocksHookTypes);
        this.isPushOutOfBlocksModded = (this.beforePushOutOfBlocksHooks != null || this.overridePushOutOfBlocksHooks != null || this.afterPushOutOfBlocksHooks != null);
        this.beforeRayTraceHooks = this.create(PlayerAPI.beforeRayTraceHookTypes);
        this.overrideRayTraceHooks = this.create(PlayerAPI.overrideRayTraceHookTypes);
        this.afterRayTraceHooks = this.create(PlayerAPI.afterRayTraceHookTypes);
        this.isRayTraceModded = (this.beforeRayTraceHooks != null || this.overrideRayTraceHooks != null || this.afterRayTraceHooks != null);
        this.beforeReadEntityFromNBTHooks = this.create(PlayerAPI.beforeReadEntityFromNBTHookTypes);
        this.overrideReadEntityFromNBTHooks = this.create(PlayerAPI.overrideReadEntityFromNBTHookTypes);
        this.afterReadEntityFromNBTHooks = this.create(PlayerAPI.afterReadEntityFromNBTHookTypes);
        this.isReadEntityFromNBTModded = (this.beforeReadEntityFromNBTHooks != null || this.overrideReadEntityFromNBTHooks != null || this.afterReadEntityFromNBTHooks != null);
        this.beforeRespawnPlayerHooks = this.create(PlayerAPI.beforeRespawnPlayerHookTypes);
        this.overrideRespawnPlayerHooks = this.create(PlayerAPI.overrideRespawnPlayerHookTypes);
        this.afterRespawnPlayerHooks = this.create(PlayerAPI.afterRespawnPlayerHookTypes);
        this.isRespawnPlayerModded = (this.beforeRespawnPlayerHooks != null || this.overrideRespawnPlayerHooks != null || this.afterRespawnPlayerHooks != null);
        this.beforeSendChatMessageHooks = this.create(PlayerAPI.beforeSendChatMessageHookTypes);
        this.overrideSendChatMessageHooks = this.create(PlayerAPI.overrideSendChatMessageHookTypes);
        this.afterSendChatMessageHooks = this.create(PlayerAPI.afterSendChatMessageHookTypes);
        this.isSendChatMessageModded = (this.beforeSendChatMessageHooks != null || this.overrideSendChatMessageHooks != null || this.afterSendChatMessageHooks != null);
        this.beforeSetDeadHooks = this.create(PlayerAPI.beforeSetDeadHookTypes);
        this.overrideSetDeadHooks = this.create(PlayerAPI.overrideSetDeadHookTypes);
        this.afterSetDeadHooks = this.create(PlayerAPI.afterSetDeadHookTypes);
        this.isSetDeadModded = (this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null);
        this.beforeSetPositionAndRotationHooks = this.create(PlayerAPI.beforeSetPositionAndRotationHookTypes);
        this.overrideSetPositionAndRotationHooks = this.create(PlayerAPI.overrideSetPositionAndRotationHookTypes);
        this.afterSetPositionAndRotationHooks = this.create(PlayerAPI.afterSetPositionAndRotationHookTypes);
        this.isSetPositionAndRotationModded = (this.beforeSetPositionAndRotationHooks != null || this.overrideSetPositionAndRotationHooks != null || this.afterSetPositionAndRotationHooks != null);
        this.beforeSleepInBedAtHooks = this.create(PlayerAPI.beforeSleepInBedAtHookTypes);
        this.overrideSleepInBedAtHooks = this.create(PlayerAPI.overrideSleepInBedAtHookTypes);
        this.afterSleepInBedAtHooks = this.create(PlayerAPI.afterSleepInBedAtHookTypes);
        this.isSleepInBedAtModded = (this.beforeSleepInBedAtHooks != null || this.overrideSleepInBedAtHooks != null || this.afterSleepInBedAtHooks != null);
        this.beforeSwingItemHooks = this.create(PlayerAPI.beforeSwingItemHookTypes);
        this.overrideSwingItemHooks = this.create(PlayerAPI.overrideSwingItemHookTypes);
        this.afterSwingItemHooks = this.create(PlayerAPI.afterSwingItemHookTypes);
        this.isSwingItemModded = (this.beforeSwingItemHooks != null || this.overrideSwingItemHooks != null || this.afterSwingItemHooks != null);
        this.beforeUpdateEntityActionStateHooks = this.create(PlayerAPI.beforeUpdateEntityActionStateHookTypes);
        this.overrideUpdateEntityActionStateHooks = this.create(PlayerAPI.overrideUpdateEntityActionStateHookTypes);
        this.afterUpdateEntityActionStateHooks = this.create(PlayerAPI.afterUpdateEntityActionStateHookTypes);
        this.isUpdateEntityActionStateModded = (this.beforeUpdateEntityActionStateHooks != null || this.overrideUpdateEntityActionStateHooks != null || this.afterUpdateEntityActionStateHooks != null);
        this.beforeWriteEntityToNBTHooks = this.create(PlayerAPI.beforeWriteEntityToNBTHookTypes);
        this.overrideWriteEntityToNBTHooks = this.create(PlayerAPI.overrideWriteEntityToNBTHookTypes);
        this.afterWriteEntityToNBTHooks = this.create(PlayerAPI.afterWriteEntityToNBTHookTypes);
        this.isWriteEntityToNBTModded = (this.beforeWriteEntityToNBTHooks != null || this.overrideWriteEntityToNBTHooks != null || this.afterWriteEntityToNBTHooks != null);
    }
    
    private PlayerBase[] create(final List var1) {
        if (var1.isEmpty()) {
            return null;
        }
        final PlayerBase[] var2 = new PlayerBase[var1.size()];
        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = this.getPlayerBase(var1.get(var3));
        }
        return var2;
    }
    
    private void beforeLocalConstructing(final MinecraftServer var1, final World var2, final Session var3, final int var4) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int var5 = this.beforeLocalConstructingHooks.length - 1; var5 >= 0; --var5) {
                this.beforeLocalConstructingHooks[var5].beforeLocalConstructing(var1, var2, var3, var4);
            }
        }
    }
    
    private void afterLocalConstructing(final MinecraftServer var1, final World var2, final Session var3, final int var4) {
        if (this.afterLocalConstructingHooks != null) {
            for (int var5 = 0; var5 < this.afterLocalConstructingHooks.length; ++var5) {
                this.afterLocalConstructingHooks[var5].afterLocalConstructing(var1, var2, var3, var4);
            }
        }
    }
    
    public PlayerBase getPlayerBase(final String var1) {
        return this.allBaseObjects.get(var1);
    }
    
    public Set getPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }
    
    protected static void addExhaustion(final EntityPlayerSP var0, final float var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.addExhaustion(var1);
        }
        else {
            var0.localAddExhaustion(var1);
        }
    }
    
    protected void addExhaustion(final float var1) {
        if (this.beforeAddExhaustionHooks != null) {
            for (int var2 = this.beforeAddExhaustionHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAddExhaustionHooks[var2].beforeAddExhaustion(var1);
            }
        }
        if (this.overrideAddExhaustionHooks != null) {
            this.overrideAddExhaustionHooks[this.overrideAddExhaustionHooks.length - 1].addExhaustion(var1);
        }
        else {
            this.player.localAddExhaustion(var1);
        }
        if (this.afterAddExhaustionHooks != null) {
            for (int var2 = 0; var2 < this.afterAddExhaustionHooks.length; ++var2) {
                this.afterAddExhaustionHooks[var2].afterAddExhaustion(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenAddExhaustion(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAddExhaustionHooks.length) {
            if (this.overrideAddExhaustionHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAddExhaustionHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void addMovementStat(final EntityPlayerSP var0, final double var1, final double var3, final double var5) {
        if (var0.playerAPI != null) {
            var0.playerAPI.addMovementStat(var1, var3, var5);
        }
        else {
            var0.localAddMovementStat(var1, var3, var5);
        }
    }
    
    protected void addMovementStat(final double var1, final double var3, final double var5) {
        if (this.beforeAddMovementStatHooks != null) {
            for (int var6 = this.beforeAddMovementStatHooks.length - 1; var6 >= 0; --var6) {
                this.beforeAddMovementStatHooks[var6].beforeAddMovementStat(var1, var3, var5);
            }
        }
        if (this.overrideAddMovementStatHooks != null) {
            this.overrideAddMovementStatHooks[this.overrideAddMovementStatHooks.length - 1].addMovementStat(var1, var3, var5);
        }
        else {
            this.player.localAddMovementStat(var1, var3, var5);
        }
        if (this.afterAddMovementStatHooks != null) {
            for (int var6 = 0; var6 < this.afterAddMovementStatHooks.length; ++var6) {
                this.afterAddMovementStatHooks[var6].afterAddMovementStat(var1, var3, var5);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenAddMovementStat(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAddMovementStatHooks.length) {
            if (this.overrideAddMovementStatHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAddMovementStatHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void addStat(final EntityPlayerSP var0, final StatBase var1, final int var2) {
        if (var0.playerAPI != null) {
            var0.playerAPI.addStat(var1, var2);
        }
        else {
            var0.localAddStat(var1, var2);
        }
    }
    
    protected void addStat(final Statistic var1, final int var2) {
        if (this.beforeAddStatHooks != null) {
            for (int var3 = this.beforeAddStatHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAddStatHooks[var3].beforeAddStat(var1, var2);
            }
        }
        if (this.overrideAddStatHooks != null) {
            this.overrideAddStatHooks[this.overrideAddStatHooks.length - 1].addStat(var1, var2);
        }
        else {
            this.player.localAddStat(var1, var2);
        }
        if (this.afterAddStatHooks != null) {
            for (int var3 = 0; var3 < this.afterAddStatHooks.length; ++var3) {
                this.afterAddStatHooks[var3].afterAddStat(var1, var2);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenAddStat(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAddStatHooks.length) {
            if (this.overrideAddStatHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAddStatHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean attackEntityFrom(final EntityPlayerSP var0, final DamageSource var1, final int var2) {
        boolean var3;
        if (var0.playerAPI != null) {
            var3 = var0.playerAPI.attackEntityFrom(var1, var2);
        }
        else {
            var3 = var0.localAttackEntityFrom(var1, var2);
        }
        return var3;
    }
    
    protected boolean attackEntityFrom(final DamageSource var1, final int var2) {
        if (this.beforeAttackEntityFromHooks != null) {
            for (int var3 = this.beforeAttackEntityFromHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAttackEntityFromHooks[var3].beforeAttackEntityFrom(var1, var2);
            }
        }
        boolean var4;
        if (this.overrideAttackEntityFromHooks != null) {
            var4 = this.overrideAttackEntityFromHooks[this.overrideAttackEntityFromHooks.length - 1].attackEntityFrom(var1, var2);
        }
        else {
            var4 = this.player.localAttackEntityFrom(var1, var2);
        }
        if (this.afterAttackEntityFromHooks != null) {
            for (int var5 = 0; var5 < this.afterAttackEntityFromHooks.length; ++var5) {
                this.afterAttackEntityFromHooks[var5].afterAttackEntityFrom(var1, var2);
            }
        }
        return var4;
    }
    
    protected PlayerBase GetOverwrittenAttackEntityFrom(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAttackEntityFromHooks.length) {
            if (this.overrideAttackEntityFromHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAttackEntityFromHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void alertWolves(final EntityPlayerSP var0, final EntityLiving var1, final boolean var2) {
        if (var0.playerAPI != null) {
            var0.playerAPI.alertWolves(var1, var2);
        }
        else {
            var0.localAlertWolves(var1, var2);
        }
    }
    
    protected void alertWolves(final EntityLiving var1, final boolean var2) {
        if (this.beforeAlertWolvesHooks != null) {
            for (int var3 = this.beforeAlertWolvesHooks.length - 1; var3 >= 0; --var3) {
                this.beforeAlertWolvesHooks[var3].beforeAlertWolves(var1, var2);
            }
        }
        if (this.overrideAlertWolvesHooks != null) {
            this.overrideAlertWolvesHooks[this.overrideAlertWolvesHooks.length - 1].alertWolves(var1, var2);
        }
        else {
            this.player.localAlertWolves(var1, var2);
        }
        if (this.afterAlertWolvesHooks != null) {
            for (int var3 = 0; var3 < this.afterAlertWolvesHooks.length; ++var3) {
                this.afterAlertWolvesHooks[var3].afterAlertWolves(var1, var2);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenAlertWolves(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAlertWolvesHooks.length) {
            if (this.overrideAlertWolvesHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAlertWolvesHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void attackTargetEntityWithCurrentItem(final EntityPlayerSP var0, final Entity var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.attackTargetEntityWithCurrentItem(var1);
        }
        else {
            var0.localAttackTargetEntityWithCurrentItem(var1);
        }
    }
    
    protected void attackTargetEntityWithCurrentItem(final Entity var1) {
        if (this.beforeAttackTargetEntityWithCurrentItemHooks != null) {
            for (int var2 = this.beforeAttackTargetEntityWithCurrentItemHooks.length - 1; var2 >= 0; --var2) {
                this.beforeAttackTargetEntityWithCurrentItemHooks[var2].beforeAttackTargetEntityWithCurrentItem(var1);
            }
        }
        if (this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
            this.overrideAttackTargetEntityWithCurrentItemHooks[this.overrideAttackTargetEntityWithCurrentItemHooks.length - 1].attackTargetEntityWithCurrentItem(var1);
        }
        else {
            this.player.localAttackTargetEntityWithCurrentItem(var1);
        }
        if (this.afterAttackTargetEntityWithCurrentItemHooks != null) {
            for (int var2 = 0; var2 < this.afterAttackTargetEntityWithCurrentItemHooks.length; ++var2) {
                this.afterAttackTargetEntityWithCurrentItemHooks[var2].afterAttackTargetEntityWithCurrentItem(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideAttackTargetEntityWithCurrentItemHooks.length) {
            if (this.overrideAttackTargetEntityWithCurrentItemHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideAttackTargetEntityWithCurrentItemHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean canBreatheUnderwater(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.canBreatheUnderwater();
        }
        else {
            var = var0.localCanBreatheUnderwater();
        }
        return var;
    }
    
    protected boolean canBreatheUnderwater() {
        if (this.beforeCanBreatheUnderwaterHooks != null) {
            for (int var1 = this.beforeCanBreatheUnderwaterHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanBreatheUnderwaterHooks[var1].beforeCanBreatheUnderwater();
            }
        }
        boolean var2;
        if (this.overrideCanBreatheUnderwaterHooks != null) {
            var2 = this.overrideCanBreatheUnderwaterHooks[this.overrideCanBreatheUnderwaterHooks.length - 1].canBreatheUnderwater();
        }
        else {
            var2 = this.player.localCanBreatheUnderwater();
        }
        if (this.afterCanBreatheUnderwaterHooks != null) {
            for (int var3 = 0; var3 < this.afterCanBreatheUnderwaterHooks.length; ++var3) {
                this.afterCanBreatheUnderwaterHooks[var3].afterCanBreatheUnderwater();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenCanBreatheUnderwater(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideCanBreatheUnderwaterHooks.length) {
            if (this.overrideCanBreatheUnderwaterHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideCanBreatheUnderwaterHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean canHarvestBlock(final EntityPlayerSP var0, final Block var1) {
        boolean var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.canHarvestBlock(var1);
        }
        else {
            var2 = var0.localCanHarvestBlock(var1);
        }
        return var2;
    }
    
    protected boolean canHarvestBlock(final Block var1) {
        if (this.beforeCanHarvestBlockHooks != null) {
            for (int var2 = this.beforeCanHarvestBlockHooks.length - 1; var2 >= 0; --var2) {
                this.beforeCanHarvestBlockHooks[var2].beforeCanHarvestBlock(var1);
            }
        }
        boolean var3;
        if (this.overrideCanHarvestBlockHooks != null) {
            var3 = this.overrideCanHarvestBlockHooks[this.overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(var1);
        }
        else {
            var3 = this.player.localCanHarvestBlock(var1);
        }
        if (this.afterCanHarvestBlockHooks != null) {
            for (int var4 = 0; var4 < this.afterCanHarvestBlockHooks.length; ++var4) {
                this.afterCanHarvestBlockHooks[var4].afterCanHarvestBlock(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenCanHarvestBlock(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideCanHarvestBlockHooks.length) {
            if (this.overrideCanHarvestBlockHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideCanHarvestBlockHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean canPlayerEdit(final EntityPlayerSP var0, final int var1, final int var2, final int var3) {
        boolean var4;
        if (var0.playerAPI != null) {
            var4 = var0.playerAPI.canPlayerEdit(var1, var2, var3);
        }
        else {
            var4 = var0.localCanPlayerEdit(var1, var2, var3);
        }
        return var4;
    }
    
    protected boolean canPlayerEdit(final int var1, final int var2, final int var3) {
        if (this.beforeCanPlayerEditHooks != null) {
            for (int var4 = this.beforeCanPlayerEditHooks.length - 1; var4 >= 0; --var4) {
                this.beforeCanPlayerEditHooks[var4].beforeCanPlayerEdit(var1, var2, var3);
            }
        }
        boolean var5;
        if (this.overrideCanPlayerEditHooks != null) {
            var5 = this.overrideCanPlayerEditHooks[this.overrideCanPlayerEditHooks.length - 1].canPlayerEdit(var1, var2, var3);
        }
        else {
            var5 = this.player.localCanPlayerEdit(var1, var2, var3);
        }
        if (this.afterCanPlayerEditHooks != null) {
            for (int var6 = 0; var6 < this.afterCanPlayerEditHooks.length; ++var6) {
                this.afterCanPlayerEditHooks[var6].afterCanPlayerEdit(var1, var2, var3);
            }
        }
        return var5;
    }
    
    protected PlayerBase GetOverwrittenCanPlayerEdit(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideCanPlayerEditHooks.length) {
            if (this.overrideCanPlayerEditHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideCanPlayerEditHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean canTriggerWalking(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.canTriggerWalking();
        }
        else {
            var = var0.localCanTriggerWalking();
        }
        return var;
    }
    
    protected boolean canTriggerWalking() {
        if (this.beforeCanTriggerWalkingHooks != null) {
            for (int var1 = this.beforeCanTriggerWalkingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCanTriggerWalkingHooks[var1].beforeCanTriggerWalking();
            }
        }
        boolean var2;
        if (this.overrideCanTriggerWalkingHooks != null) {
            var2 = this.overrideCanTriggerWalkingHooks[this.overrideCanTriggerWalkingHooks.length - 1].canTriggerWalking();
        }
        else {
            var2 = this.player.localCanTriggerWalking();
        }
        if (this.afterCanTriggerWalkingHooks != null) {
            for (int var3 = 0; var3 < this.afterCanTriggerWalkingHooks.length; ++var3) {
                this.afterCanTriggerWalkingHooks[var3].afterCanTriggerWalking();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenCanTriggerWalking(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideCanTriggerWalkingHooks.length) {
            if (this.overrideCanTriggerWalkingHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideCanTriggerWalkingHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void closeScreen(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.closeScreen();
        }
        else {
            var0.localCloseScreen();
        }
    }
    
    protected void closeScreen() {
        if (this.beforeCloseScreenHooks != null) {
            for (int var1 = this.beforeCloseScreenHooks.length - 1; var1 >= 0; --var1) {
                this.beforeCloseScreenHooks[var1].beforeCloseScreen();
            }
        }
        if (this.overrideCloseScreenHooks != null) {
            this.overrideCloseScreenHooks[this.overrideCloseScreenHooks.length - 1].closeScreen();
        }
        else {
            this.player.localCloseScreen();
        }
        if (this.afterCloseScreenHooks != null) {
            for (int var1 = 0; var1 < this.afterCloseScreenHooks.length; ++var1) {
                this.afterCloseScreenHooks[var1].afterCloseScreen();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenCloseScreen(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideCloseScreenHooks.length) {
            if (this.overrideCloseScreenHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideCloseScreenHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void damageEntity(final EntityPlayerSP var0, final DamageSource var1, final int var2) {
        if (var0.playerAPI != null) {
            var0.playerAPI.damageEntity(var1, var2);
        }
        else {
            var0.localDamageEntity(var1, var2);
        }
    }
    
    protected void damageEntity(final DamageSource var1, final int var2) {
        if (this.beforeDamageEntityHooks != null) {
            for (int var3 = this.beforeDamageEntityHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDamageEntityHooks[var3].beforeDamageEntity(var1, var2);
            }
        }
        if (this.overrideDamageEntityHooks != null) {
            this.overrideDamageEntityHooks[this.overrideDamageEntityHooks.length - 1].damageEntity(var1, var2);
        }
        else {
            this.player.localDamageEntity(var1, var2);
        }
        if (this.afterDamageEntityHooks != null) {
            for (int var3 = 0; var3 < this.afterDamageEntityHooks.length; ++var3) {
                this.afterDamageEntityHooks[var3].afterDamageEntity(var1, var2);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDamageEntity(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDamageEntityHooks.length) {
            if (this.overrideDamageEntityHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDamageEntityHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIBrewingStand(final EntityPlayerSP var0, final TileEntityBrewingStand var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIBrewingStand(var1);
        }
        else {
            var0.localDisplayGUIBrewingStand(var1);
        }
    }
    
    protected void displayGUIBrewingStand(final TileEntityBrewingStand var1) {
        if (this.beforeDisplayGUIBrewingStandHooks != null) {
            for (int var2 = this.beforeDisplayGUIBrewingStandHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIBrewingStandHooks[var2].beforeDisplayGUIBrewingStand(var1);
            }
        }
        if (this.overrideDisplayGUIBrewingStandHooks != null) {
            this.overrideDisplayGUIBrewingStandHooks[this.overrideDisplayGUIBrewingStandHooks.length - 1].displayGUIBrewingStand(var1);
        }
        else {
            this.player.localDisplayGUIBrewingStand(var1);
        }
        if (this.afterDisplayGUIBrewingStandHooks != null) {
            for (int var2 = 0; var2 < this.afterDisplayGUIBrewingStandHooks.length; ++var2) {
                this.afterDisplayGUIBrewingStandHooks[var2].afterDisplayGUIBrewingStand(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIBrewingStand(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIBrewingStandHooks.length) {
            if (this.overrideDisplayGUIBrewingStandHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIBrewingStandHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIChest(final EntityPlayerSP var0, final IInventory var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIChest(var1);
        }
        else {
            var0.localDisplayGUIChest(var1);
        }
    }
    
    protected void displayGUIChest(final IInventory var1) {
        if (this.beforeDisplayGUIChestHooks != null) {
            for (int var2 = this.beforeDisplayGUIChestHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIChestHooks[var2].beforeDisplayGUIChest(var1);
            }
        }
        if (this.overrideDisplayGUIChestHooks != null) {
            this.overrideDisplayGUIChestHooks[this.overrideDisplayGUIChestHooks.length - 1].displayGUIChest(var1);
        }
        else {
            this.player.localDisplayGUIChest(var1);
        }
        if (this.afterDisplayGUIChestHooks != null) {
            for (int var2 = 0; var2 < this.afterDisplayGUIChestHooks.length; ++var2) {
                this.afterDisplayGUIChestHooks[var2].afterDisplayGUIChest(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIChest(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIChestHooks.length) {
            if (this.overrideDisplayGUIChestHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIChestHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIDispenser(final EntityPlayerSP var0, final TileEntityDispenser var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIDispenser(var1);
        }
        else {
            var0.localDisplayGUIDispenser(var1);
        }
    }
    
    protected void displayGUIDispenser(final TileEntityDispenser var1) {
        if (this.beforeDisplayGUIDispenserHooks != null) {
            for (int var2 = this.beforeDisplayGUIDispenserHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIDispenserHooks[var2].beforeDisplayGUIDispenser(var1);
            }
        }
        if (this.overrideDisplayGUIDispenserHooks != null) {
            this.overrideDisplayGUIDispenserHooks[this.overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(var1);
        }
        else {
            this.player.localDisplayGUIDispenser(var1);
        }
        if (this.afterDisplayGUIDispenserHooks != null) {
            for (int var2 = 0; var2 < this.afterDisplayGUIDispenserHooks.length; ++var2) {
                this.afterDisplayGUIDispenserHooks[var2].afterDisplayGUIDispenser(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIDispenser(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIDispenserHooks.length) {
            if (this.overrideDisplayGUIDispenserHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIDispenserHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIEditSign(final EntityPlayerSP var0, final TileEntitySign var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIEditSign(var1);
        }
        else {
            var0.localDisplayGUIEditSign(var1);
        }
    }
    
    protected void displayGUIEditSign(final TileEntitySign var1) {
        if (this.beforeDisplayGUIEditSignHooks != null) {
            for (int var2 = this.beforeDisplayGUIEditSignHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIEditSignHooks[var2].beforeDisplayGUIEditSign(var1);
            }
        }
        if (this.overrideDisplayGUIEditSignHooks != null) {
            this.overrideDisplayGUIEditSignHooks[this.overrideDisplayGUIEditSignHooks.length - 1].displayGUIEditSign(var1);
        }
        else {
            this.player.localDisplayGUIEditSign(var1);
        }
        if (this.afterDisplayGUIEditSignHooks != null) {
            for (int var2 = 0; var2 < this.afterDisplayGUIEditSignHooks.length; ++var2) {
                this.afterDisplayGUIEditSignHooks[var2].afterDisplayGUIEditSign(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIEditSign(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIEditSignHooks.length) {
            if (this.overrideDisplayGUIEditSignHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIEditSignHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIEnchantment(final EntityPlayerSP var0, final int var1, final int var2, final int var3) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIEnchantment(var1, var2, var3);
        }
        else {
            var0.localDisplayGUIEnchantment(var1, var2, var3);
        }
    }
    
    protected void displayGUIEnchantment(final int var1, final int var2, final int var3) {
        if (this.beforeDisplayGUIEnchantmentHooks != null) {
            for (int var4 = this.beforeDisplayGUIEnchantmentHooks.length - 1; var4 >= 0; --var4) {
                this.beforeDisplayGUIEnchantmentHooks[var4].beforeDisplayGUIEnchantment(var1, var2, var3);
            }
        }
        if (this.overrideDisplayGUIEnchantmentHooks != null) {
            this.overrideDisplayGUIEnchantmentHooks[this.overrideDisplayGUIEnchantmentHooks.length - 1].displayGUIEnchantment(var1, var2, var3);
        }
        else {
            this.player.localDisplayGUIEnchantment(var1, var2, var3);
        }
        if (this.afterDisplayGUIEnchantmentHooks != null) {
            for (int var4 = 0; var4 < this.afterDisplayGUIEnchantmentHooks.length; ++var4) {
                this.afterDisplayGUIEnchantmentHooks[var4].afterDisplayGUIEnchantment(var1, var2, var3);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIEnchantment(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIEnchantmentHooks.length) {
            if (this.overrideDisplayGUIEnchantmentHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIEnchantmentHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayGUIFurnace(final EntityPlayerSP var0, final TileEntityFurnace var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayGUIFurnace(var1);
        }
        else {
            var0.localDisplayGUIFurnace(var1);
        }
    }
    
    protected void displayGUIFurnace(final TileEntityFurnace var1) {
        if (this.beforeDisplayGUIFurnaceHooks != null) {
            for (int var2 = this.beforeDisplayGUIFurnaceHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDisplayGUIFurnaceHooks[var2].beforeDisplayGUIFurnace(var1);
            }
        }
        if (this.overrideDisplayGUIFurnaceHooks != null) {
            this.overrideDisplayGUIFurnaceHooks[this.overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(var1);
        }
        else {
            this.player.localDisplayGUIFurnace(var1);
        }
        if (this.afterDisplayGUIFurnaceHooks != null) {
            for (int var2 = 0; var2 < this.afterDisplayGUIFurnaceHooks.length; ++var2) {
                this.afterDisplayGUIFurnaceHooks[var2].afterDisplayGUIFurnace(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayGUIFurnace(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayGUIFurnaceHooks.length) {
            if (this.overrideDisplayGUIFurnaceHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayGUIFurnaceHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void displayWorkbenchGUI(final EntityPlayerSP var0, final int var1, final int var2, final int var3) {
        if (var0.playerAPI != null) {
            var0.playerAPI.displayWorkbenchGUI(var1, var2, var3);
        }
        else {
            var0.localDisplayWorkbenchGUI(var1, var2, var3);
        }
    }
    
    protected void displayWorkbenchGUI(final int var1, final int var2, final int var3) {
        if (this.beforeDisplayWorkbenchGUIHooks != null) {
            for (int var4 = this.beforeDisplayWorkbenchGUIHooks.length - 1; var4 >= 0; --var4) {
                this.beforeDisplayWorkbenchGUIHooks[var4].beforeDisplayWorkbenchGUI(var1, var2, var3);
            }
        }
        if (this.overrideDisplayWorkbenchGUIHooks != null) {
            this.overrideDisplayWorkbenchGUIHooks[this.overrideDisplayWorkbenchGUIHooks.length - 1].displayWorkbenchGUI(var1, var2, var3);
        }
        else {
            this.player.localDisplayWorkbenchGUI(var1, var2, var3);
        }
        if (this.afterDisplayWorkbenchGUIHooks != null) {
            for (int var4 = 0; var4 < this.afterDisplayWorkbenchGUIHooks.length; ++var4) {
                this.afterDisplayWorkbenchGUIHooks[var4].afterDisplayWorkbenchGUI(var1, var2, var3);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenDisplayWorkbenchGUI(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDisplayWorkbenchGUIHooks.length) {
            if (this.overrideDisplayWorkbenchGUIHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDisplayWorkbenchGUIHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static EntityItem dropOneItem(final EntityPlayerSP var0) {
        EntityItem var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.dropOneItem();
        }
        else {
            var = var0.localDropOneItem();
        }
        return var;
    }
    
    protected EntityItem dropOneItem() {
        if (this.beforeDropOneItemHooks != null) {
            for (int var1 = this.beforeDropOneItemHooks.length - 1; var1 >= 0; --var1) {
                this.beforeDropOneItemHooks[var1].beforeDropOneItem();
            }
        }
        EntityItem var2;
        if (this.overrideDropOneItemHooks != null) {
            var2 = this.overrideDropOneItemHooks[this.overrideDropOneItemHooks.length - 1].dropOneItem();
        }
        else {
            var2 = this.player.localDropOneItem();
        }
        if (this.afterDropOneItemHooks != null) {
            for (int var3 = 0; var3 < this.afterDropOneItemHooks.length; ++var3) {
                this.afterDropOneItemHooks[var3].afterDropOneItem();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenDropOneItem(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDropOneItemHooks.length) {
            if (this.overrideDropOneItemHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDropOneItemHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static EntityItem dropPlayerItem(final EntityPlayerSP var0, final ItemStack var1) {
        EntityItem var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.dropPlayerItem(var1);
        }
        else {
            var2 = var0.localDropPlayerItem(var1);
        }
        return var2;
    }
    
    protected EntityItem dropPlayerItem(final ItemStack var1) {
        if (this.beforeDropPlayerItemHooks != null) {
            for (int var2 = this.beforeDropPlayerItemHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDropPlayerItemHooks[var2].beforeDropPlayerItem(var1);
            }
        }
        EntityItem var3;
        if (this.overrideDropPlayerItemHooks != null) {
            var3 = this.overrideDropPlayerItemHooks[this.overrideDropPlayerItemHooks.length - 1].dropPlayerItem(var1);
        }
        else {
            var3 = this.player.localDropPlayerItem(var1);
        }
        if (this.afterDropPlayerItemHooks != null) {
            for (int var4 = 0; var4 < this.afterDropPlayerItemHooks.length; ++var4) {
                this.afterDropPlayerItemHooks[var4].afterDropPlayerItem(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenDropPlayerItem(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDropPlayerItemHooks.length) {
            if (this.overrideDropPlayerItemHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDropPlayerItemHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static EntityItem dropPlayerItemWithRandomChoice(final EntityPlayerSP var0, final ItemStack var1, final boolean var2) {
        EntityItem var3;
        if (var0.playerAPI != null) {
            var3 = var0.playerAPI.dropPlayerItemWithRandomChoice(var1, var2);
        }
        else {
            var3 = var0.localDropPlayerItemWithRandomChoice(var1, var2);
        }
        return var3;
    }
    
    protected EntityItem dropPlayerItemWithRandomChoice(final ItemStack var1, final boolean var2) {
        if (this.beforeDropPlayerItemWithRandomChoiceHooks != null) {
            for (int var3 = this.beforeDropPlayerItemWithRandomChoiceHooks.length - 1; var3 >= 0; --var3) {
                this.beforeDropPlayerItemWithRandomChoiceHooks[var3].beforeDropPlayerItemWithRandomChoice(var1, var2);
            }
        }
        EntityItem var4;
        if (this.overrideDropPlayerItemWithRandomChoiceHooks != null) {
            var4 = this.overrideDropPlayerItemWithRandomChoiceHooks[this.overrideDropPlayerItemWithRandomChoiceHooks.length - 1].dropPlayerItemWithRandomChoice(var1, var2);
        }
        else {
            var4 = this.player.localDropPlayerItemWithRandomChoice(var1, var2);
        }
        if (this.afterDropPlayerItemWithRandomChoiceHooks != null) {
            for (int var5 = 0; var5 < this.afterDropPlayerItemWithRandomChoiceHooks.length; ++var5) {
                this.afterDropPlayerItemWithRandomChoiceHooks[var5].afterDropPlayerItemWithRandomChoice(var1, var2);
            }
        }
        return var4;
    }
    
    protected PlayerBase GetOverwrittenDropPlayerItemWithRandomChoice(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideDropPlayerItemWithRandomChoiceHooks.length) {
            if (this.overrideDropPlayerItemWithRandomChoiceHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideDropPlayerItemWithRandomChoiceHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void fall(final EntityPlayerSP var0, final float var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.fall(var1);
        }
        else {
            var0.localFall(var1);
        }
    }
    
    protected void fall(final float var1) {
        if (this.beforeFallHooks != null) {
            for (int var2 = this.beforeFallHooks.length - 1; var2 >= 0; --var2) {
                this.beforeFallHooks[var2].beforeFall(var1);
            }
        }
        if (this.overrideFallHooks != null) {
            this.overrideFallHooks[this.overrideFallHooks.length - 1].fall(var1);
        }
        else {
            this.player.localFall(var1);
        }
        if (this.afterFallHooks != null) {
            for (int var2 = 0; var2 < this.afterFallHooks.length; ++var2) {
                this.afterFallHooks[var2].afterFall(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenFall(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideFallHooks.length) {
            if (this.overrideFallHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideFallHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static float getBrightness(final EntityPlayerSP var0, final float var1) {
        float var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.getBrightness(var1);
        }
        else {
            var2 = var0.localGetBrightness(var1);
        }
        return var2;
    }
    
    protected float getBrightness(final float var1) {
        if (this.beforeGetBrightnessHooks != null) {
            for (int var2 = this.beforeGetBrightnessHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetBrightnessHooks[var2].beforeGetBrightness(var1);
            }
        }
        float var3;
        if (this.overrideGetBrightnessHooks != null) {
            var3 = this.overrideGetBrightnessHooks[this.overrideGetBrightnessHooks.length - 1].getBrightness(var1);
        }
        else {
            var3 = this.player.localGetBrightness(var1);
        }
        if (this.afterGetBrightnessHooks != null) {
            for (int var4 = 0; var4 < this.afterGetBrightnessHooks.length; ++var4) {
                this.afterGetBrightnessHooks[var4].afterGetBrightness(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenGetBrightness(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetBrightnessHooks.length) {
            if (this.overrideGetBrightnessHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetBrightnessHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static int getBrightnessForRender(final EntityPlayerSP var0, final float var1) {
        int var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.getBrightnessForRender(var1);
        }
        else {
            var2 = var0.localGetBrightnessForRender(var1);
        }
        return var2;
    }
    
    protected int getBrightnessForRender(final float var1) {
        if (this.beforeGetBrightnessForRenderHooks != null) {
            for (int var2 = this.beforeGetBrightnessForRenderHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetBrightnessForRenderHooks[var2].beforeGetBrightnessForRender(var1);
            }
        }
        int var2;
        if (this.overrideGetBrightnessForRenderHooks != null) {
            var2 = this.overrideGetBrightnessForRenderHooks[this.overrideGetBrightnessForRenderHooks.length - 1].getBrightnessForRender(var1);
        }
        else {
            var2 = this.player.localGetBrightnessForRender(var1);
        }
        if (this.afterGetBrightnessForRenderHooks != null) {
            for (int var3 = 0; var3 < this.afterGetBrightnessForRenderHooks.length; ++var3) {
                this.afterGetBrightnessForRenderHooks[var3].afterGetBrightnessForRender(var1);
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenGetBrightnessForRender(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetBrightnessForRenderHooks.length) {
            if (this.overrideGetBrightnessForRenderHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetBrightnessForRenderHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static float getCurrentPlayerStrVsBlock(final EntityPlayerSP var0, final Block var1) {
        float var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.getCurrentPlayerStrVsBlock(var1);
        }
        else {
            var2 = var0.localGetCurrentPlayerStrVsBlock(var1);
        }
        return var2;
    }
    
    protected float getCurrentPlayerStrVsBlock(final Block var1) {
        if (this.beforeGetCurrentPlayerStrVsBlockHooks != null) {
            for (int var2 = this.beforeGetCurrentPlayerStrVsBlockHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetCurrentPlayerStrVsBlockHooks[var2].beforeGetCurrentPlayerStrVsBlock(var1);
            }
        }
        float var3;
        if (this.overrideGetCurrentPlayerStrVsBlockHooks != null) {
            var3 = this.overrideGetCurrentPlayerStrVsBlockHooks[this.overrideGetCurrentPlayerStrVsBlockHooks.length - 1].getCurrentPlayerStrVsBlock(var1);
        }
        else {
            var3 = this.player.localGetCurrentPlayerStrVsBlock(var1);
        }
        if (this.afterGetCurrentPlayerStrVsBlockHooks != null) {
            for (int var4 = 0; var4 < this.afterGetCurrentPlayerStrVsBlockHooks.length; ++var4) {
                this.afterGetCurrentPlayerStrVsBlockHooks[var4].afterGetCurrentPlayerStrVsBlock(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetCurrentPlayerStrVsBlockHooks.length) {
            if (this.overrideGetCurrentPlayerStrVsBlockHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetCurrentPlayerStrVsBlockHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static double getDistanceSq(final EntityPlayerSP var0, final double var1, final double var3, final double var5) {
        double var6;
        if (var0.playerAPI != null) {
            var6 = var0.playerAPI.getDistanceSq(var1, var3, var5);
        }
        else {
            var6 = var0.localGetDistanceSq(var1, var3, var5);
        }
        return var6;
    }
    
    protected double getDistanceSq(final double var1, final double var3, final double var5) {
        if (this.beforeGetDistanceSqHooks != null) {
            for (int var6 = this.beforeGetDistanceSqHooks.length - 1; var6 >= 0; --var6) {
                this.beforeGetDistanceSqHooks[var6].beforeGetDistanceSq(var1, var3, var5);
            }
        }
        double var7;
        if (this.overrideGetDistanceSqHooks != null) {
            var7 = this.overrideGetDistanceSqHooks[this.overrideGetDistanceSqHooks.length - 1].getDistanceSq(var1, var3, var5);
        }
        else {
            var7 = this.player.localGetDistanceSq(var1, var3, var5);
        }
        if (this.afterGetDistanceSqHooks != null) {
            for (int var8 = 0; var8 < this.afterGetDistanceSqHooks.length; ++var8) {
                this.afterGetDistanceSqHooks[var8].afterGetDistanceSq(var1, var3, var5);
            }
        }
        return var7;
    }
    
    protected PlayerBase GetOverwrittenGetDistanceSq(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetDistanceSqHooks.length) {
            if (this.overrideGetDistanceSqHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetDistanceSqHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static double getDistanceSqToEntity(final EntityPlayerSP var0, final Entity var1) {
        double var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.getDistanceSqToEntity(var1);
        }
        else {
            var2 = var0.localGetDistanceSqToEntity(var1);
        }
        return var2;
    }
    
    protected double getDistanceSqToEntity(final Entity var1) {
        if (this.beforeGetDistanceSqToEntityHooks != null) {
            for (int var2 = this.beforeGetDistanceSqToEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetDistanceSqToEntityHooks[var2].beforeGetDistanceSqToEntity(var1);
            }
        }
        double var3;
        if (this.overrideGetDistanceSqToEntityHooks != null) {
            var3 = this.overrideGetDistanceSqToEntityHooks[this.overrideGetDistanceSqToEntityHooks.length - 1].getDistanceSqToEntity(var1);
        }
        else {
            var3 = this.player.localGetDistanceSqToEntity(var1);
        }
        if (this.afterGetDistanceSqToEntityHooks != null) {
            for (int var4 = 0; var4 < this.afterGetDistanceSqToEntityHooks.length; ++var4) {
                this.afterGetDistanceSqToEntityHooks[var4].afterGetDistanceSqToEntity(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenGetDistanceSqToEntity(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetDistanceSqToEntityHooks.length) {
            if (this.overrideGetDistanceSqToEntityHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetDistanceSqToEntityHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static float getFOVMultiplier(final EntityPlayerSP var0) {
        float var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.getFOVMultiplier();
        }
        else {
            var = var0.localGetFOVMultiplier();
        }
        return var;
    }
    
    protected float getFOVMultiplier() {
        if (this.beforeGetFOVMultiplierHooks != null) {
            for (int var1 = this.beforeGetFOVMultiplierHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetFOVMultiplierHooks[var1].beforeGetFOVMultiplier();
            }
        }
        float var2;
        if (this.overrideGetFOVMultiplierHooks != null) {
            var2 = this.overrideGetFOVMultiplierHooks[this.overrideGetFOVMultiplierHooks.length - 1].getFOVMultiplier();
        }
        else {
            var2 = this.player.localGetFOVMultiplier();
        }
        if (this.afterGetFOVMultiplierHooks != null) {
            for (int var3 = 0; var3 < this.afterGetFOVMultiplierHooks.length; ++var3) {
                this.afterGetFOVMultiplierHooks[var3].afterGetFOVMultiplier();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenGetFOVMultiplier(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetFOVMultiplierHooks.length) {
            if (this.overrideGetFOVMultiplierHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetFOVMultiplierHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static String getHurtSound(final EntityPlayerSP var0) {
        String var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.getHurtSound();
        }
        else {
            var = var0.localGetHurtSound();
        }
        return var;
    }
    
    protected String getHurtSound() {
        if (this.beforeGetHurtSoundHooks != null) {
            for (int var1 = this.beforeGetHurtSoundHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetHurtSoundHooks[var1].beforeGetHurtSound();
            }
        }
        String var2;
        if (this.overrideGetHurtSoundHooks != null) {
            var2 = this.overrideGetHurtSoundHooks[this.overrideGetHurtSoundHooks.length - 1].getHurtSound();
        }
        else {
            var2 = this.player.localGetHurtSound();
        }
        if (this.afterGetHurtSoundHooks != null) {
            for (int var3 = 0; var3 < this.afterGetHurtSoundHooks.length; ++var3) {
                this.afterGetHurtSoundHooks[var3].afterGetHurtSound();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenGetHurtSound(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetHurtSoundHooks.length) {
            if (this.overrideGetHurtSoundHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetHurtSoundHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static int getItemIcon(final EntityPlayerSP var0, final ItemStack var1, final int var2) {
        int var3;
        if (var0.playerAPI != null) {
            var3 = var0.playerAPI.getItemIcon(var1, var2);
        }
        else {
            var3 = var0.localGetItemIcon(var1, var2);
        }
        return var3;
    }
    
    protected int getItemIcon(final ItemStack var1, final int var2) {
        if (this.beforeGetItemIconHooks != null) {
            for (int var3 = this.beforeGetItemIconHooks.length - 1; var3 >= 0; --var3) {
                this.beforeGetItemIconHooks[var3].beforeGetItemIcon(var1, var2);
            }
        }
        int var3;
        if (this.overrideGetItemIconHooks != null) {
            var3 = this.overrideGetItemIconHooks[this.overrideGetItemIconHooks.length - 1].getItemIcon(var1, var2);
        }
        else {
            var3 = this.player.localGetItemIcon(var1, var2);
        }
        if (this.afterGetItemIconHooks != null) {
            for (int var4 = 0; var4 < this.afterGetItemIconHooks.length; ++var4) {
                this.afterGetItemIconHooks[var4].afterGetItemIcon(var1, var2);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenGetItemIcon(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetItemIconHooks.length) {
            if (this.overrideGetItemIconHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetItemIconHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static int getSleepTimer(final EntityPlayerSP var0) {
        int var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.getSleepTimer();
        }
        else {
            var = var0.localGetSleepTimer();
        }
        return var;
    }
    
    protected int getSleepTimer() {
        if (this.beforeGetSleepTimerHooks != null) {
            for (int var1 = this.beforeGetSleepTimerHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetSleepTimerHooks[var1].beforeGetSleepTimer();
            }
        }
        int var1;
        if (this.overrideGetSleepTimerHooks != null) {
            var1 = this.overrideGetSleepTimerHooks[this.overrideGetSleepTimerHooks.length - 1].getSleepTimer();
        }
        else {
            var1 = this.player.localGetSleepTimer();
        }
        if (this.afterGetSleepTimerHooks != null) {
            for (int var2 = 0; var2 < this.afterGetSleepTimerHooks.length; ++var2) {
                this.afterGetSleepTimerHooks[var2].afterGetSleepTimer();
            }
        }
        return var1;
    }
    
    protected PlayerBase GetOverwrittenGetSleepTimer(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetSleepTimerHooks.length) {
            if (this.overrideGetSleepTimerHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetSleepTimerHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static float getSpeedModifier(final EntityPlayerSP var0) {
        float var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.getSpeedModifier();
        }
        else {
            var = var0.localGetSpeedModifier();
        }
        return var;
    }
    
    protected float getSpeedModifier() {
        if (this.beforeGetSpeedModifierHooks != null) {
            for (int var1 = this.beforeGetSpeedModifierHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetSpeedModifierHooks[var1].beforeGetSpeedModifier();
            }
        }
        float var2;
        if (this.overrideGetSpeedModifierHooks != null) {
            var2 = this.overrideGetSpeedModifierHooks[this.overrideGetSpeedModifierHooks.length - 1].getSpeedModifier();
        }
        else {
            var2 = this.player.localGetSpeedModifier();
        }
        if (this.afterGetSpeedModifierHooks != null) {
            for (int var3 = 0; var3 < this.afterGetSpeedModifierHooks.length; ++var3) {
                this.afterGetSpeedModifierHooks[var3].afterGetSpeedModifier();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenGetSpeedModifier(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideGetSpeedModifierHooks.length) {
            if (this.overrideGetSpeedModifierHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideGetSpeedModifierHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean handleLavaMovement(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.handleLavaMovement();
        }
        else {
            var = var0.localHandleLavaMovement();
        }
        return var;
    }
    
    protected boolean handleLavaMovement() {
        if (this.beforeHandleLavaMovementHooks != null) {
            for (int var1 = this.beforeHandleLavaMovementHooks.length - 1; var1 >= 0; --var1) {
                this.beforeHandleLavaMovementHooks[var1].beforeHandleLavaMovement();
            }
        }
        boolean var2;
        if (this.overrideHandleLavaMovementHooks != null) {
            var2 = this.overrideHandleLavaMovementHooks[this.overrideHandleLavaMovementHooks.length - 1].handleLavaMovement();
        }
        else {
            var2 = this.player.localHandleLavaMovement();
        }
        if (this.afterHandleLavaMovementHooks != null) {
            for (int var3 = 0; var3 < this.afterHandleLavaMovementHooks.length; ++var3) {
                this.afterHandleLavaMovementHooks[var3].afterHandleLavaMovement();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenHandleLavaMovement(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideHandleLavaMovementHooks.length) {
            if (this.overrideHandleLavaMovementHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideHandleLavaMovementHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean handleWaterMovement(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.handleWaterMovement();
        }
        else {
            var = var0.localHandleWaterMovement();
        }
        return var;
    }
    
    protected boolean handleWaterMovement() {
        if (this.beforeHandleWaterMovementHooks != null) {
            for (int var1 = this.beforeHandleWaterMovementHooks.length - 1; var1 >= 0; --var1) {
                this.beforeHandleWaterMovementHooks[var1].beforeHandleWaterMovement();
            }
        }
        boolean var2;
        if (this.overrideHandleWaterMovementHooks != null) {
            var2 = this.overrideHandleWaterMovementHooks[this.overrideHandleWaterMovementHooks.length - 1].handleWaterMovement();
        }
        else {
            var2 = this.player.localHandleWaterMovement();
        }
        if (this.afterHandleWaterMovementHooks != null) {
            for (int var3 = 0; var3 < this.afterHandleWaterMovementHooks.length; ++var3) {
                this.afterHandleWaterMovementHooks[var3].afterHandleWaterMovement();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenHandleWaterMovement(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideHandleWaterMovementHooks.length) {
            if (this.overrideHandleWaterMovementHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideHandleWaterMovementHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void heal(final EntityPlayerSP var0, final int var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.heal(var1);
        }
        else {
            var0.localHeal(var1);
        }
    }
    
    protected void heal(final int var1) {
        if (this.beforeHealHooks != null) {
            for (int var2 = this.beforeHealHooks.length - 1; var2 >= 0; --var2) {
                this.beforeHealHooks[var2].beforeHeal(var1);
            }
        }
        if (this.overrideHealHooks != null) {
            this.overrideHealHooks[this.overrideHealHooks.length - 1].heal(var1);
        }
        else {
            this.player.localHeal(var1);
        }
        if (this.afterHealHooks != null) {
            for (int var2 = 0; var2 < this.afterHealHooks.length; ++var2) {
                this.afterHealHooks[var2].afterHeal(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenHeal(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideHealHooks.length) {
            if (this.overrideHealHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideHealHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isEntityInsideOpaqueBlock(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.isEntityInsideOpaqueBlock();
        }
        else {
            var = var0.localIsEntityInsideOpaqueBlock();
        }
        return var;
    }
    
    protected boolean isEntityInsideOpaqueBlock() {
        if (this.beforeIsEntityInsideOpaqueBlockHooks != null) {
            for (int var1 = this.beforeIsEntityInsideOpaqueBlockHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsEntityInsideOpaqueBlockHooks[var1].beforeIsEntityInsideOpaqueBlock();
            }
        }
        boolean var2;
        if (this.overrideIsEntityInsideOpaqueBlockHooks != null) {
            var2 = this.overrideIsEntityInsideOpaqueBlockHooks[this.overrideIsEntityInsideOpaqueBlockHooks.length - 1].isEntityInsideOpaqueBlock();
        }
        else {
            var2 = this.player.localIsEntityInsideOpaqueBlock();
        }
        if (this.afterIsEntityInsideOpaqueBlockHooks != null) {
            for (int var3 = 0; var3 < this.afterIsEntityInsideOpaqueBlockHooks.length; ++var3) {
                this.afterIsEntityInsideOpaqueBlockHooks[var3].afterIsEntityInsideOpaqueBlock();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsEntityInsideOpaqueBlockHooks.length) {
            if (this.overrideIsEntityInsideOpaqueBlockHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsEntityInsideOpaqueBlockHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isInWater(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.isInWater();
        }
        else {
            var = var0.localIsInWater();
        }
        return var;
    }
    
    protected boolean isInWater() {
        if (this.beforeIsInWaterHooks != null) {
            for (int var1 = this.beforeIsInWaterHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsInWaterHooks[var1].beforeIsInWater();
            }
        }
        boolean var2;
        if (this.overrideIsInWaterHooks != null) {
            var2 = this.overrideIsInWaterHooks[this.overrideIsInWaterHooks.length - 1].isInWater();
        }
        else {
            var2 = this.player.localIsInWater();
        }
        if (this.afterIsInWaterHooks != null) {
            for (int var3 = 0; var3 < this.afterIsInWaterHooks.length; ++var3) {
                this.afterIsInWaterHooks[var3].afterIsInWater();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenIsInWater(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsInWaterHooks.length) {
            if (this.overrideIsInWaterHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsInWaterHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isInsideOfMaterial(final EntityPlayerSP var0, final Material var1) {
        boolean var2;
        if (var0.playerAPI != null) {
            var2 = var0.playerAPI.isInsideOfMaterial(var1);
        }
        else {
            var2 = var0.localIsInsideOfMaterial(var1);
        }
        return var2;
    }
    
    protected boolean isInsideOfMaterial(final Material var1) {
        if (this.beforeIsInsideOfMaterialHooks != null) {
            for (int var2 = this.beforeIsInsideOfMaterialHooks.length - 1; var2 >= 0; --var2) {
                this.beforeIsInsideOfMaterialHooks[var2].beforeIsInsideOfMaterial(var1);
            }
        }
        boolean var3;
        if (this.overrideIsInsideOfMaterialHooks != null) {
            var3 = this.overrideIsInsideOfMaterialHooks[this.overrideIsInsideOfMaterialHooks.length - 1].isInsideOfMaterial(var1);
        }
        else {
            var3 = this.player.localIsInsideOfMaterial(var1);
        }
        if (this.afterIsInsideOfMaterialHooks != null) {
            for (int var4 = 0; var4 < this.afterIsInsideOfMaterialHooks.length; ++var4) {
                this.afterIsInsideOfMaterialHooks[var4].afterIsInsideOfMaterial(var1);
            }
        }
        return var3;
    }
    
    protected PlayerBase GetOverwrittenIsInsideOfMaterial(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsInsideOfMaterialHooks.length) {
            if (this.overrideIsInsideOfMaterialHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsInsideOfMaterialHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isOnLadder(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.isOnLadder();
        }
        else {
            var = var0.localIsOnLadder();
        }
        return var;
    }
    
    protected boolean isOnLadder() {
        if (this.beforeIsOnLadderHooks != null) {
            for (int var1 = this.beforeIsOnLadderHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsOnLadderHooks[var1].beforeIsOnLadder();
            }
        }
        boolean var2;
        if (this.overrideIsOnLadderHooks != null) {
            var2 = this.overrideIsOnLadderHooks[this.overrideIsOnLadderHooks.length - 1].isOnLadder();
        }
        else {
            var2 = this.player.localIsOnLadder();
        }
        if (this.afterIsOnLadderHooks != null) {
            for (int var3 = 0; var3 < this.afterIsOnLadderHooks.length; ++var3) {
                this.afterIsOnLadderHooks[var3].afterIsOnLadder();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenIsOnLadder(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsOnLadderHooks.length) {
            if (this.overrideIsOnLadderHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsOnLadderHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isSneaking(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.isSneaking();
        }
        else {
            var = var0.localIsSneaking();
        }
        return var;
    }
    
    protected boolean isSneaking() {
        if (this.beforeIsSneakingHooks != null) {
            for (int var1 = this.beforeIsSneakingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsSneakingHooks[var1].beforeIsSneaking();
            }
        }
        boolean var2;
        if (this.overrideIsSneakingHooks != null) {
            var2 = this.overrideIsSneakingHooks[this.overrideIsSneakingHooks.length - 1].isSneaking();
        }
        else {
            var2 = this.player.localIsSneaking();
        }
        if (this.afterIsSneakingHooks != null) {
            for (int var3 = 0; var3 < this.afterIsSneakingHooks.length; ++var3) {
                this.afterIsSneakingHooks[var3].afterIsSneaking();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenIsSneaking(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsSneakingHooks.length) {
            if (this.overrideIsSneakingHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsSneakingHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean isSprinting(final EntityPlayerSP var0) {
        boolean var;
        if (var0.playerAPI != null) {
            var = var0.playerAPI.isSprinting();
        }
        else {
            var = var0.localIsSprinting();
        }
        return var;
    }
    
    protected boolean isSprinting() {
        if (this.beforeIsSprintingHooks != null) {
            for (int var1 = this.beforeIsSprintingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeIsSprintingHooks[var1].beforeIsSprinting();
            }
        }
        boolean var2;
        if (this.overrideIsSprintingHooks != null) {
            var2 = this.overrideIsSprintingHooks[this.overrideIsSprintingHooks.length - 1].isSprinting();
        }
        else {
            var2 = this.player.localIsSprinting();
        }
        if (this.afterIsSprintingHooks != null) {
            for (int var3 = 0; var3 < this.afterIsSprintingHooks.length; ++var3) {
                this.afterIsSprintingHooks[var3].afterIsSprinting();
            }
        }
        return var2;
    }
    
    protected PlayerBase GetOverwrittenIsSprinting(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideIsSprintingHooks.length) {
            if (this.overrideIsSprintingHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideIsSprintingHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void jump(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.jump();
        }
        else {
            var0.localJump();
        }
    }
    
    protected void jump() {
        if (this.beforeJumpHooks != null) {
            for (int var1 = this.beforeJumpHooks.length - 1; var1 >= 0; --var1) {
                this.beforeJumpHooks[var1].beforeJump();
            }
        }
        if (this.overrideJumpHooks != null) {
            this.overrideJumpHooks[this.overrideJumpHooks.length - 1].jump();
        }
        else {
            this.player.localJump();
        }
        if (this.afterJumpHooks != null) {
            for (int var1 = 0; var1 < this.afterJumpHooks.length; ++var1) {
                this.afterJumpHooks[var1].afterJump();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenJump(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideJumpHooks.length) {
            if (this.overrideJumpHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideJumpHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void knockBack(final EntityPlayerSP var0, final Entity var1, final int var2, final double var3, final double var5) {
        if (var0.playerAPI != null) {
            var0.playerAPI.knockBack(var1, var2, var3, var5);
        }
        else {
            var0.localKnockBack(var1, var2, var3, var5);
        }
    }
    
    protected void knockBack(final Entity var1, final int var2, final double var3, final double var5) {
        if (this.beforeKnockBackHooks != null) {
            for (int var6 = this.beforeKnockBackHooks.length - 1; var6 >= 0; --var6) {
                this.beforeKnockBackHooks[var6].beforeKnockBack(var1, var2, var3, var5);
            }
        }
        if (this.overrideKnockBackHooks != null) {
            this.overrideKnockBackHooks[this.overrideKnockBackHooks.length - 1].knockBack(var1, var2, var3, var5);
        }
        else {
            this.player.localKnockBack(var1, var2, var3, var5);
        }
        if (this.afterKnockBackHooks != null) {
            for (int var6 = 0; var6 < this.afterKnockBackHooks.length; ++var6) {
                this.afterKnockBackHooks[var6].afterKnockBack(var1, var2, var3, var5);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenKnockBack(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideKnockBackHooks.length) {
            if (this.overrideKnockBackHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideKnockBackHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void moveEntity(final EntityPlayerSP var0, final double var1, final double var3, final double var5) {
        if (var0.playerAPI != null) {
            var0.playerAPI.moveEntity(var1, var3, var5);
        }
        else {
            var0.localMoveEntity(var1, var3, var5);
        }
    }
    
    protected void moveEntity(final double var1, final double var3, final double var5) {
        if (this.beforeMoveEntityHooks != null) {
            for (int var6 = this.beforeMoveEntityHooks.length - 1; var6 >= 0; --var6) {
                this.beforeMoveEntityHooks[var6].beforeMoveEntity(var1, var3, var5);
            }
        }
        if (this.overrideMoveEntityHooks != null) {
            this.overrideMoveEntityHooks[this.overrideMoveEntityHooks.length - 1].moveEntity(var1, var3, var5);
        }
        else {
            this.player.localMoveEntity(var1, var3, var5);
        }
        if (this.afterMoveEntityHooks != null) {
            for (int var6 = 0; var6 < this.afterMoveEntityHooks.length; ++var6) {
                this.afterMoveEntityHooks[var6].afterMoveEntity(var1, var3, var5);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenMoveEntity(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideMoveEntityHooks.length) {
            if (this.overrideMoveEntityHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideMoveEntityHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void moveEntityWithHeading(final EntityPlayerSP var0, final float var1, final float var2) {
        if (var0.playerAPI != null) {
            var0.playerAPI.moveEntityWithHeading(var1, var2);
        }
        else {
            var0.localMoveEntityWithHeading(var1, var2);
        }
    }
    
    protected void moveEntityWithHeading(final float var1, final float var2) {
        if (this.beforeMoveEntityWithHeadingHooks != null) {
            for (int var3 = this.beforeMoveEntityWithHeadingHooks.length - 1; var3 >= 0; --var3) {
                this.beforeMoveEntityWithHeadingHooks[var3].beforeMoveEntityWithHeading(var1, var2);
            }
        }
        if (this.overrideMoveEntityWithHeadingHooks != null) {
            this.overrideMoveEntityWithHeadingHooks[this.overrideMoveEntityWithHeadingHooks.length - 1].moveEntityWithHeading(var1, var2);
        }
        else {
            this.player.localMoveEntityWithHeading(var1, var2);
        }
        if (this.afterMoveEntityWithHeadingHooks != null) {
            for (int var3 = 0; var3 < this.afterMoveEntityWithHeadingHooks.length; ++var3) {
                this.afterMoveEntityWithHeadingHooks[var3].afterMoveEntityWithHeading(var1, var2);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenMoveEntityWithHeading(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideMoveEntityWithHeadingHooks.length) {
            if (this.overrideMoveEntityWithHeadingHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideMoveEntityWithHeadingHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void moveFlying(final EntityPlayerSP var0, final float var1, final float var2, final float var3) {
        if (var0.playerAPI != null) {
            var0.playerAPI.moveFlying(var1, var2, var3);
        }
        else {
            var0.localMoveFlying(var1, var2, var3);
        }
    }
    
    protected void moveFlying(final float var1, final float var2, final float var3) {
        if (this.beforeMoveFlyingHooks != null) {
            for (int var4 = this.beforeMoveFlyingHooks.length - 1; var4 >= 0; --var4) {
                this.beforeMoveFlyingHooks[var4].beforeMoveFlying(var1, var2, var3);
            }
        }
        if (this.overrideMoveFlyingHooks != null) {
            this.overrideMoveFlyingHooks[this.overrideMoveFlyingHooks.length - 1].moveFlying(var1, var2, var3);
        }
        else {
            this.player.localMoveFlying(var1, var2, var3);
        }
        if (this.afterMoveFlyingHooks != null) {
            for (int var4 = 0; var4 < this.afterMoveFlyingHooks.length; ++var4) {
                this.afterMoveFlyingHooks[var4].afterMoveFlying(var1, var2, var3);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenMoveFlying(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideMoveFlyingHooks.length) {
            if (this.overrideMoveFlyingHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideMoveFlyingHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void onDeath(final EntityPlayerSP var0, final DamageSource var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.onDeath(var1);
        }
        else {
            var0.localOnDeath(var1);
        }
    }
    
    protected void onDeath(final DamageSource var1) {
        if (this.beforeOnDeathHooks != null) {
            for (int var2 = this.beforeOnDeathHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnDeathHooks[var2].beforeOnDeath(var1);
            }
        }
        if (this.overrideOnDeathHooks != null) {
            this.overrideOnDeathHooks[this.overrideOnDeathHooks.length - 1].onDeath(var1);
        }
        else {
            this.player.localOnDeath(var1);
        }
        if (this.afterOnDeathHooks != null) {
            for (int var2 = 0; var2 < this.afterOnDeathHooks.length; ++var2) {
                this.afterOnDeathHooks[var2].afterOnDeath(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenOnDeath(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideOnDeathHooks.length) {
            if (this.overrideOnDeathHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideOnDeathHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void onLivingUpdate(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.onLivingUpdate();
        }
        else {
            var0.localOnLivingUpdate();
        }
    }
    
    protected void onLivingUpdate() {
        if (this.beforeOnLivingUpdateHooks != null) {
            for (int var1 = this.beforeOnLivingUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnLivingUpdateHooks[var1].beforeOnLivingUpdate();
            }
        }
        if (this.overrideOnLivingUpdateHooks != null) {
            this.overrideOnLivingUpdateHooks[this.overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
        }
        else {
            this.player.localOnLivingUpdate();
        }
        if (this.afterOnLivingUpdateHooks != null) {
            for (int var1 = 0; var1 < this.afterOnLivingUpdateHooks.length; ++var1) {
                this.afterOnLivingUpdateHooks[var1].afterOnLivingUpdate();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenOnLivingUpdate(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideOnLivingUpdateHooks.length) {
            if (this.overrideOnLivingUpdateHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideOnLivingUpdateHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void onKillEntity(final EntityPlayerSP var0, final EntityLiving var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.onKillEntity(var1);
        }
        else {
            var0.localOnKillEntity(var1);
        }
    }
    
    protected void onKillEntity(final EntityLiving var1) {
        if (this.beforeOnKillEntityHooks != null) {
            for (int var2 = this.beforeOnKillEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeOnKillEntityHooks[var2].beforeOnKillEntity(var1);
            }
        }
        if (this.overrideOnKillEntityHooks != null) {
            this.overrideOnKillEntityHooks[this.overrideOnKillEntityHooks.length - 1].onKillEntity(var1);
        }
        else {
            this.player.localOnKillEntity(var1);
        }
        if (this.afterOnKillEntityHooks != null) {
            for (int var2 = 0; var2 < this.afterOnKillEntityHooks.length; ++var2) {
                this.afterOnKillEntityHooks[var2].afterOnKillEntity(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenOnKillEntity(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideOnKillEntityHooks.length) {
            if (this.overrideOnKillEntityHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideOnKillEntityHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void onUpdate(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.onUpdate();
        }
        else {
            var0.localOnUpdate();
        }
    }
    
    protected void onUpdate() {
        if (this.beforeOnUpdateHooks != null) {
            for (int var1 = this.beforeOnUpdateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeOnUpdateHooks[var1].beforeOnUpdate();
            }
        }
        if (this.overrideOnUpdateHooks != null) {
            this.overrideOnUpdateHooks[this.overrideOnUpdateHooks.length - 1].onUpdate();
        }
        else {
            this.player.localOnUpdate();
        }
        if (this.afterOnUpdateHooks != null) {
            for (int var1 = 0; var1 < this.afterOnUpdateHooks.length; ++var1) {
                this.afterOnUpdateHooks[var1].afterOnUpdate();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenOnUpdate(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideOnUpdateHooks.length) {
            if (this.overrideOnUpdateHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideOnUpdateHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void playStepSound(final EntityPlayerSP var0, final int var1, final int var2, final int var3, final int var4) {
        if (var0.playerAPI != null) {
            var0.playerAPI.playStepSound(var1, var2, var3, var4);
        }
        else {
            var0.localPlayStepSound(var1, var2, var3, var4);
        }
    }
    
    protected void playStepSound(final int var1, final int var2, final int var3, final int var4) {
        if (this.beforePlayStepSoundHooks != null) {
            for (int var5 = this.beforePlayStepSoundHooks.length - 1; var5 >= 0; --var5) {
                this.beforePlayStepSoundHooks[var5].beforePlayStepSound(var1, var2, var3, var4);
            }
        }
        if (this.overridePlayStepSoundHooks != null) {
            this.overridePlayStepSoundHooks[this.overridePlayStepSoundHooks.length - 1].playStepSound(var1, var2, var3, var4);
        }
        else {
            this.player.localPlayStepSound(var1, var2, var3, var4);
        }
        if (this.afterPlayStepSoundHooks != null) {
            for (int var5 = 0; var5 < this.afterPlayStepSoundHooks.length; ++var5) {
                this.afterPlayStepSoundHooks[var5].afterPlayStepSound(var1, var2, var3, var4);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenPlayStepSound(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overridePlayStepSoundHooks.length) {
            if (this.overridePlayStepSoundHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overridePlayStepSoundHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static boolean pushOutOfBlocks(final EntityPlayerSP var0, final double var1, final double var3, final double var5) {
        boolean var6;
        if (var0.playerAPI != null) {
            var6 = var0.playerAPI.pushOutOfBlocks(var1, var3, var5);
        }
        else {
            var6 = var0.localPushOutOfBlocks(var1, var3, var5);
        }
        return var6;
    }
    
    protected boolean pushOutOfBlocks(final double var1, final double var3, final double var5) {
        if (this.beforePushOutOfBlocksHooks != null) {
            for (int var6 = this.beforePushOutOfBlocksHooks.length - 1; var6 >= 0; --var6) {
                this.beforePushOutOfBlocksHooks[var6].beforePushOutOfBlocks(var1, var3, var5);
            }
        }
        boolean var7;
        if (this.overridePushOutOfBlocksHooks != null) {
            var7 = this.overridePushOutOfBlocksHooks[this.overridePushOutOfBlocksHooks.length - 1].pushOutOfBlocks(var1, var3, var5);
        }
        else {
            var7 = this.player.localPushOutOfBlocks(var1, var3, var5);
        }
        if (this.afterPushOutOfBlocksHooks != null) {
            for (int var8 = 0; var8 < this.afterPushOutOfBlocksHooks.length; ++var8) {
                this.afterPushOutOfBlocksHooks[var8].afterPushOutOfBlocks(var1, var3, var5);
            }
        }
        return var7;
    }
    
    protected PlayerBase GetOverwrittenPushOutOfBlocks(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overridePushOutOfBlocksHooks.length) {
            if (this.overridePushOutOfBlocksHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overridePushOutOfBlocksHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static MovingObjectPosition rayTrace(final EntityPlayerSP var0, final double var1, final float var3) {
        MovingObjectPosition var4;
        if (var0.playerAPI != null) {
            var4 = var0.playerAPI.rayTrace(var1, var3);
        }
        else {
            var4 = var0.localRayTrace(var1, var3);
        }
        return var4;
    }
    
    protected MovingObjectPosition rayTrace(final double var1, final float var3) {
        if (this.beforeRayTraceHooks != null) {
            for (int var4 = this.beforeRayTraceHooks.length - 1; var4 >= 0; --var4) {
                this.beforeRayTraceHooks[var4].beforeRayTrace(var1, var3);
            }
        }
        MovingObjectPosition var5;
        if (this.overrideRayTraceHooks != null) {
            var5 = this.overrideRayTraceHooks[this.overrideRayTraceHooks.length - 1].rayTrace(var1, var3);
        }
        else {
            var5 = this.player.localRayTrace(var1, var3);
        }
        if (this.afterRayTraceHooks != null) {
            for (int var6 = 0; var6 < this.afterRayTraceHooks.length; ++var6) {
                this.afterRayTraceHooks[var6].afterRayTrace(var1, var3);
            }
        }
        return var5;
    }
    
    protected PlayerBase GetOverwrittenRayTrace(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideRayTraceHooks.length) {
            if (this.overrideRayTraceHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideRayTraceHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void readEntityFromNBT(final EntityPlayerSP var0, final NBTTagCompound var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.readEntityFromNBT(var1);
        }
        else {
            var0.localReadEntityFromNBT(var1);
        }
    }
    
    protected void readEntityFromNBT(final NBTTagCompound var1) {
        if (this.beforeReadEntityFromNBTHooks != null) {
            for (int var2 = this.beforeReadEntityFromNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeReadEntityFromNBTHooks[var2].beforeReadEntityFromNBT(var1);
            }
        }
        if (this.overrideReadEntityFromNBTHooks != null) {
            this.overrideReadEntityFromNBTHooks[this.overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(var1);
        }
        else {
            this.player.localReadEntityFromNBT(var1);
        }
        if (this.afterReadEntityFromNBTHooks != null) {
            for (int var2 = 0; var2 < this.afterReadEntityFromNBTHooks.length; ++var2) {
                this.afterReadEntityFromNBTHooks[var2].afterReadEntityFromNBT(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenReadEntityFromNBT(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideReadEntityFromNBTHooks.length) {
            if (this.overrideReadEntityFromNBTHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideReadEntityFromNBTHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void respawnPlayer(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.respawnPlayer();
        }
        else {
            var0.localRespawnPlayer();
        }
    }
    
    protected void respawnPlayer() {
        if (this.beforeRespawnPlayerHooks != null) {
            for (int var1 = this.beforeRespawnPlayerHooks.length - 1; var1 >= 0; --var1) {
                this.beforeRespawnPlayerHooks[var1].beforeRespawnPlayer();
            }
        }
        if (this.overrideRespawnPlayerHooks != null) {
            this.overrideRespawnPlayerHooks[this.overrideRespawnPlayerHooks.length - 1].respawnPlayer();
        }
        else {
            this.player.localRespawnPlayer();
        }
        if (this.afterRespawnPlayerHooks != null) {
            for (int var1 = 0; var1 < this.afterRespawnPlayerHooks.length; ++var1) {
                this.afterRespawnPlayerHooks[var1].afterRespawnPlayer();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenRespawnPlayer(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideRespawnPlayerHooks.length) {
            if (this.overrideRespawnPlayerHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideRespawnPlayerHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void sendChatMessage(final EntityPlayerSP var0, final String var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.sendChatMessage(var1);
        }
        else {
            var0.localSendChatMessage(var1);
        }
    }
    
    protected void sendChatMessage(final String var1) {
        if (this.beforeSendChatMessageHooks != null) {
            for (int var2 = this.beforeSendChatMessageHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSendChatMessageHooks[var2].beforeSendChatMessage(var1);
            }
        }
        if (this.overrideSendChatMessageHooks != null) {
            this.overrideSendChatMessageHooks[this.overrideSendChatMessageHooks.length - 1].sendChatMessage(var1);
        }
        else {
            this.player.localSendChatMessage(var1);
        }
        if (this.afterSendChatMessageHooks != null) {
            for (int var2 = 0; var2 < this.afterSendChatMessageHooks.length; ++var2) {
                this.afterSendChatMessageHooks[var2].afterSendChatMessage(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenSendChatMessage(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideSendChatMessageHooks.length) {
            if (this.overrideSendChatMessageHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideSendChatMessageHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void setDead(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.setDead();
        }
        else {
            var0.localSetDead();
        }
    }
    
    protected void setDead() {
        if (this.beforeSetDeadHooks != null) {
            for (int var1 = this.beforeSetDeadHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSetDeadHooks[var1].beforeSetDead();
            }
        }
        if (this.overrideSetDeadHooks != null) {
            this.overrideSetDeadHooks[this.overrideSetDeadHooks.length - 1].setDead();
        }
        else {
            this.player.localSetDead();
        }
        if (this.afterSetDeadHooks != null) {
            for (int var1 = 0; var1 < this.afterSetDeadHooks.length; ++var1) {
                this.afterSetDeadHooks[var1].afterSetDead();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenSetDead(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideSetDeadHooks.length) {
            if (this.overrideSetDeadHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideSetDeadHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void setPositionAndRotation(final EntityPlayerSP var0, final double var1, final double var3, final double var5, final float var7, final float var8) {
        if (var0.playerAPI != null) {
            var0.playerAPI.setPositionAndRotation(var1, var3, var5, var7, var8);
        }
        else {
            var0.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        }
    }
    
    protected void setPositionAndRotation(final double var1, final double var3, final double var5, final float var7, final float var8) {
        if (this.beforeSetPositionAndRotationHooks != null) {
            for (int var9 = this.beforeSetPositionAndRotationHooks.length - 1; var9 >= 0; --var9) {
                this.beforeSetPositionAndRotationHooks[var9].beforeSetPositionAndRotation(var1, var3, var5, var7, var8);
            }
        }
        if (this.overrideSetPositionAndRotationHooks != null) {
            this.overrideSetPositionAndRotationHooks[this.overrideSetPositionAndRotationHooks.length - 1].setPositionAndRotation(var1, var3, var5, var7, var8);
        }
        else {
            this.player.localSetPositionAndRotation(var1, var3, var5, var7, var8);
        }
        if (this.afterSetPositionAndRotationHooks != null) {
            for (int var9 = 0; var9 < this.afterSetPositionAndRotationHooks.length; ++var9) {
                this.afterSetPositionAndRotationHooks[var9].afterSetPositionAndRotation(var1, var3, var5, var7, var8);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenSetPositionAndRotation(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideSetPositionAndRotationHooks.length) {
            if (this.overrideSetPositionAndRotationHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideSetPositionAndRotationHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static EnumStatus sleepInBedAt(final EntityPlayerSP var0, final int var1, final int var2, final int var3) {
        EnumStatus var4;
        if (var0.playerAPI != null) {
            var4 = var0.playerAPI.sleepInBedAt(var1, var2, var3);
        }
        else {
            var4 = var0.localSleepInBedAt(var1, var2, var3);
        }
        return var4;
    }
    
    protected EnumStatus sleepInBedAt(final int var1, final int var2, final int var3) {
        if (this.beforeSleepInBedAtHooks != null) {
            for (int var4 = this.beforeSleepInBedAtHooks.length - 1; var4 >= 0; --var4) {
                this.beforeSleepInBedAtHooks[var4].beforeSleepInBedAt(var1, var2, var3);
            }
        }
        EnumStatus var5;
        if (this.overrideSleepInBedAtHooks != null) {
            var5 = this.overrideSleepInBedAtHooks[this.overrideSleepInBedAtHooks.length - 1].sleepInBedAt(var1, var2, var3);
        }
        else {
            var5 = this.player.localSleepInBedAt(var1, var2, var3);
        }
        if (this.afterSleepInBedAtHooks != null) {
            for (int var6 = 0; var6 < this.afterSleepInBedAtHooks.length; ++var6) {
                this.afterSleepInBedAtHooks[var6].afterSleepInBedAt(var1, var2, var3);
            }
        }
        return var5;
    }
    
    protected PlayerBase GetOverwrittenSleepInBedAt(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideSleepInBedAtHooks.length) {
            if (this.overrideSleepInBedAtHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideSleepInBedAtHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void swingItem(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.swingItem();
        }
        else {
            var0.localSwingItem();
        }
    }
    
    protected void swingItem() {
        if (this.beforeSwingItemHooks != null) {
            for (int var1 = this.beforeSwingItemHooks.length - 1; var1 >= 0; --var1) {
                this.beforeSwingItemHooks[var1].beforeSwingItem();
            }
        }
        if (this.overrideSwingItemHooks != null) {
            this.overrideSwingItemHooks[this.overrideSwingItemHooks.length - 1].swingItem();
        }
        else {
            this.player.localSwingItem();
        }
        if (this.afterSwingItemHooks != null) {
            for (int var1 = 0; var1 < this.afterSwingItemHooks.length; ++var1) {
                this.afterSwingItemHooks[var1].afterSwingItem();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenSwingItem(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideSwingItemHooks.length) {
            if (this.overrideSwingItemHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideSwingItemHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void updateEntityActionState(final EntityPlayerSP var0) {
        if (var0.playerAPI != null) {
            var0.playerAPI.updateEntityActionState();
        }
        else {
            var0.localUpdateEntityActionState();
        }
    }
    
    protected void updateEntityActionState() {
        if (this.beforeUpdateEntityActionStateHooks != null) {
            for (int var1 = this.beforeUpdateEntityActionStateHooks.length - 1; var1 >= 0; --var1) {
                this.beforeUpdateEntityActionStateHooks[var1].beforeUpdateEntityActionState();
            }
        }
        if (this.overrideUpdateEntityActionStateHooks != null) {
            this.overrideUpdateEntityActionStateHooks[this.overrideUpdateEntityActionStateHooks.length - 1].updateEntityActionState();
        }
        else {
            this.player.localUpdateEntityActionState();
        }
        if (this.afterUpdateEntityActionStateHooks != null) {
            for (int var1 = 0; var1 < this.afterUpdateEntityActionStateHooks.length; ++var1) {
                this.afterUpdateEntityActionStateHooks[var1].afterUpdateEntityActionState();
            }
        }
    }
    
    protected PlayerBase GetOverwrittenUpdateEntityActionState(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideUpdateEntityActionStateHooks.length) {
            if (this.overrideUpdateEntityActionStateHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideUpdateEntityActionStateHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    protected static void writeEntityToNBT(final EntityPlayerSP var0, final NBTTagCompound var1) {
        if (var0.playerAPI != null) {
            var0.playerAPI.writeEntityToNBT(var1);
        }
        else {
            var0.localWriteEntityToNBT(var1);
        }
    }
    
    protected void writeEntityToNBT(final NBTTagCompound var1) {
        if (this.beforeWriteEntityToNBTHooks != null) {
            for (int var2 = this.beforeWriteEntityToNBTHooks.length - 1; var2 >= 0; --var2) {
                this.beforeWriteEntityToNBTHooks[var2].beforeWriteEntityToNBT(var1);
            }
        }
        if (this.overrideWriteEntityToNBTHooks != null) {
            this.overrideWriteEntityToNBTHooks[this.overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(var1);
        }
        else {
            this.player.localWriteEntityToNBT(var1);
        }
        if (this.afterWriteEntityToNBTHooks != null) {
            for (int var2 = 0; var2 < this.afterWriteEntityToNBTHooks.length; ++var2) {
                this.afterWriteEntityToNBTHooks[var2].afterWriteEntityToNBT(var1);
            }
        }
    }
    
    protected PlayerBase GetOverwrittenWriteEntityToNBT(final PlayerBase var1) {
        int var2 = 0;
        while (var2 < this.overrideWriteEntityToNBTHooks.length) {
            if (this.overrideWriteEntityToNBTHooks[var2] == var1) {
                if (var2 == 0) {
                    return null;
                }
                return this.overrideWriteEntityToNBTHooks[var2 - 1];
            }
            else {
                ++var2;
            }
        }
        return var1;
    }
    
    static {
        Class = new Class[] { PlayerAPI.class };
        Classes = new Class[] { PlayerAPI.class, String.class };
        logger = Logger.getLogger("PlayerAPI");
        beforeAddExhaustionHookTypes = new LinkedList();
        overrideAddExhaustionHookTypes = new LinkedList();
        afterAddExhaustionHookTypes = new LinkedList();
        beforeAddMovementStatHookTypes = new LinkedList();
        overrideAddMovementStatHookTypes = new LinkedList();
        afterAddMovementStatHookTypes = new LinkedList();
        beforeAddStatHookTypes = new LinkedList();
        overrideAddStatHookTypes = new LinkedList();
        afterAddStatHookTypes = new LinkedList();
        beforeAttackEntityFromHookTypes = new LinkedList();
        overrideAttackEntityFromHookTypes = new LinkedList();
        afterAttackEntityFromHookTypes = new LinkedList();
        beforeAlertWolvesHookTypes = new LinkedList();
        overrideAlertWolvesHookTypes = new LinkedList();
        afterAlertWolvesHookTypes = new LinkedList();
        beforeAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
        overrideAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
        afterAttackTargetEntityWithCurrentItemHookTypes = new LinkedList();
        beforeCanBreatheUnderwaterHookTypes = new LinkedList();
        overrideCanBreatheUnderwaterHookTypes = new LinkedList();
        afterCanBreatheUnderwaterHookTypes = new LinkedList();
        beforeCanHarvestBlockHookTypes = new LinkedList();
        overrideCanHarvestBlockHookTypes = new LinkedList();
        afterCanHarvestBlockHookTypes = new LinkedList();
        beforeCanPlayerEditHookTypes = new LinkedList();
        overrideCanPlayerEditHookTypes = new LinkedList();
        afterCanPlayerEditHookTypes = new LinkedList();
        beforeCanTriggerWalkingHookTypes = new LinkedList();
        overrideCanTriggerWalkingHookTypes = new LinkedList();
        afterCanTriggerWalkingHookTypes = new LinkedList();
        beforeCloseScreenHookTypes = new LinkedList();
        overrideCloseScreenHookTypes = new LinkedList();
        afterCloseScreenHookTypes = new LinkedList();
        beforeDamageEntityHookTypes = new LinkedList();
        overrideDamageEntityHookTypes = new LinkedList();
        afterDamageEntityHookTypes = new LinkedList();
        beforeDisplayGUIBrewingStandHookTypes = new LinkedList();
        overrideDisplayGUIBrewingStandHookTypes = new LinkedList();
        afterDisplayGUIBrewingStandHookTypes = new LinkedList();
        beforeDisplayGUIChestHookTypes = new LinkedList();
        overrideDisplayGUIChestHookTypes = new LinkedList();
        afterDisplayGUIChestHookTypes = new LinkedList();
        beforeDisplayGUIDispenserHookTypes = new LinkedList();
        overrideDisplayGUIDispenserHookTypes = new LinkedList();
        afterDisplayGUIDispenserHookTypes = new LinkedList();
        beforeDisplayGUIEditSignHookTypes = new LinkedList();
        overrideDisplayGUIEditSignHookTypes = new LinkedList();
        afterDisplayGUIEditSignHookTypes = new LinkedList();
        beforeDisplayGUIEnchantmentHookTypes = new LinkedList();
        overrideDisplayGUIEnchantmentHookTypes = new LinkedList();
        afterDisplayGUIEnchantmentHookTypes = new LinkedList();
        beforeDisplayGUIFurnaceHookTypes = new LinkedList();
        overrideDisplayGUIFurnaceHookTypes = new LinkedList();
        afterDisplayGUIFurnaceHookTypes = new LinkedList();
        beforeDisplayWorkbenchGUIHookTypes = new LinkedList();
        overrideDisplayWorkbenchGUIHookTypes = new LinkedList();
        afterDisplayWorkbenchGUIHookTypes = new LinkedList();
        beforeDropOneItemHookTypes = new LinkedList();
        overrideDropOneItemHookTypes = new LinkedList();
        afterDropOneItemHookTypes = new LinkedList();
        beforeDropPlayerItemHookTypes = new LinkedList();
        overrideDropPlayerItemHookTypes = new LinkedList();
        afterDropPlayerItemHookTypes = new LinkedList();
        beforeDropPlayerItemWithRandomChoiceHookTypes = new LinkedList();
        overrideDropPlayerItemWithRandomChoiceHookTypes = new LinkedList();
        afterDropPlayerItemWithRandomChoiceHookTypes = new LinkedList();
        beforeFallHookTypes = new LinkedList();
        overrideFallHookTypes = new LinkedList();
        afterFallHookTypes = new LinkedList();
        beforeGetBrightnessHookTypes = new LinkedList();
        overrideGetBrightnessHookTypes = new LinkedList();
        afterGetBrightnessHookTypes = new LinkedList();
        beforeGetBrightnessForRenderHookTypes = new LinkedList();
        overrideGetBrightnessForRenderHookTypes = new LinkedList();
        afterGetBrightnessForRenderHookTypes = new LinkedList();
        beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
        overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
        afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList();
        beforeGetDistanceSqHookTypes = new LinkedList();
        overrideGetDistanceSqHookTypes = new LinkedList();
        afterGetDistanceSqHookTypes = new LinkedList();
        beforeGetDistanceSqToEntityHookTypes = new LinkedList();
        overrideGetDistanceSqToEntityHookTypes = new LinkedList();
        afterGetDistanceSqToEntityHookTypes = new LinkedList();
        beforeGetFOVMultiplierHookTypes = new LinkedList();
        overrideGetFOVMultiplierHookTypes = new LinkedList();
        afterGetFOVMultiplierHookTypes = new LinkedList();
        beforeGetHurtSoundHookTypes = new LinkedList();
        overrideGetHurtSoundHookTypes = new LinkedList();
        afterGetHurtSoundHookTypes = new LinkedList();
        beforeGetItemIconHookTypes = new LinkedList();
        overrideGetItemIconHookTypes = new LinkedList();
        afterGetItemIconHookTypes = new LinkedList();
        beforeGetSleepTimerHookTypes = new LinkedList();
        overrideGetSleepTimerHookTypes = new LinkedList();
        afterGetSleepTimerHookTypes = new LinkedList();
        beforeGetSpeedModifierHookTypes = new LinkedList();
        overrideGetSpeedModifierHookTypes = new LinkedList();
        afterGetSpeedModifierHookTypes = new LinkedList();
        beforeHandleLavaMovementHookTypes = new LinkedList();
        overrideHandleLavaMovementHookTypes = new LinkedList();
        afterHandleLavaMovementHookTypes = new LinkedList();
        beforeHandleWaterMovementHookTypes = new LinkedList();
        overrideHandleWaterMovementHookTypes = new LinkedList();
        afterHandleWaterMovementHookTypes = new LinkedList();
        beforeHealHookTypes = new LinkedList();
        overrideHealHookTypes = new LinkedList();
        afterHealHookTypes = new LinkedList();
        beforeIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
        overrideIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
        afterIsEntityInsideOpaqueBlockHookTypes = new LinkedList();
        beforeIsInWaterHookTypes = new LinkedList();
        overrideIsInWaterHookTypes = new LinkedList();
        afterIsInWaterHookTypes = new LinkedList();
        beforeIsInsideOfMaterialHookTypes = new LinkedList();
        overrideIsInsideOfMaterialHookTypes = new LinkedList();
        afterIsInsideOfMaterialHookTypes = new LinkedList();
        beforeIsOnLadderHookTypes = new LinkedList();
        overrideIsOnLadderHookTypes = new LinkedList();
        afterIsOnLadderHookTypes = new LinkedList();
        beforeIsSneakingHookTypes = new LinkedList();
        overrideIsSneakingHookTypes = new LinkedList();
        afterIsSneakingHookTypes = new LinkedList();
        beforeIsSprintingHookTypes = new LinkedList();
        overrideIsSprintingHookTypes = new LinkedList();
        afterIsSprintingHookTypes = new LinkedList();
        beforeJumpHookTypes = new LinkedList();
        overrideJumpHookTypes = new LinkedList();
        afterJumpHookTypes = new LinkedList();
        beforeKnockBackHookTypes = new LinkedList();
        overrideKnockBackHookTypes = new LinkedList();
        afterKnockBackHookTypes = new LinkedList();
        beforeMoveEntityHookTypes = new LinkedList();
        overrideMoveEntityHookTypes = new LinkedList();
        afterMoveEntityHookTypes = new LinkedList();
        beforeMoveEntityWithHeadingHookTypes = new LinkedList();
        overrideMoveEntityWithHeadingHookTypes = new LinkedList();
        afterMoveEntityWithHeadingHookTypes = new LinkedList();
        beforeMoveFlyingHookTypes = new LinkedList();
        overrideMoveFlyingHookTypes = new LinkedList();
        afterMoveFlyingHookTypes = new LinkedList();
        beforeOnDeathHookTypes = new LinkedList();
        overrideOnDeathHookTypes = new LinkedList();
        afterOnDeathHookTypes = new LinkedList();
        beforeOnLivingUpdateHookTypes = new LinkedList();
        overrideOnLivingUpdateHookTypes = new LinkedList();
        afterOnLivingUpdateHookTypes = new LinkedList();
        beforeOnKillEntityHookTypes = new LinkedList();
        overrideOnKillEntityHookTypes = new LinkedList();
        afterOnKillEntityHookTypes = new LinkedList();
        beforeOnUpdateHookTypes = new LinkedList();
        overrideOnUpdateHookTypes = new LinkedList();
        afterOnUpdateHookTypes = new LinkedList();
        beforePlayStepSoundHookTypes = new LinkedList();
        overridePlayStepSoundHookTypes = new LinkedList();
        afterPlayStepSoundHookTypes = new LinkedList();
        beforePushOutOfBlocksHookTypes = new LinkedList();
        overridePushOutOfBlocksHookTypes = new LinkedList();
        afterPushOutOfBlocksHookTypes = new LinkedList();
        beforeRayTraceHookTypes = new LinkedList();
        overrideRayTraceHookTypes = new LinkedList();
        afterRayTraceHookTypes = new LinkedList();
        beforeReadEntityFromNBTHookTypes = new LinkedList();
        overrideReadEntityFromNBTHookTypes = new LinkedList();
        afterReadEntityFromNBTHookTypes = new LinkedList();
        beforeRespawnPlayerHookTypes = new LinkedList();
        overrideRespawnPlayerHookTypes = new LinkedList();
        afterRespawnPlayerHookTypes = new LinkedList();
        beforeSendChatMessageHookTypes = new LinkedList();
        overrideSendChatMessageHookTypes = new LinkedList();
        afterSendChatMessageHookTypes = new LinkedList();
        beforeSetDeadHookTypes = new LinkedList();
        overrideSetDeadHookTypes = new LinkedList();
        afterSetDeadHookTypes = new LinkedList();
        beforeSetPositionAndRotationHookTypes = new LinkedList();
        overrideSetPositionAndRotationHookTypes = new LinkedList();
        afterSetPositionAndRotationHookTypes = new LinkedList();
        beforeSleepInBedAtHookTypes = new LinkedList();
        overrideSleepInBedAtHookTypes = new LinkedList();
        afterSleepInBedAtHookTypes = new LinkedList();
        beforeSwingItemHookTypes = new LinkedList();
        overrideSwingItemHookTypes = new LinkedList();
        afterSwingItemHookTypes = new LinkedList();
        beforeUpdateEntityActionStateHookTypes = new LinkedList();
        overrideUpdateEntityActionStateHookTypes = new LinkedList();
        afterUpdateEntityActionStateHookTypes = new LinkedList();
        beforeWriteEntityToNBTHookTypes = new LinkedList();
        overrideWriteEntityToNBTHookTypes = new LinkedList();
        afterWriteEntityToNBTHookTypes = new LinkedList();
        beforeLocalConstructingHookTypes = new LinkedList();
        afterLocalConstructingHookTypes = new LinkedList();
        allBaseConstructors = new Hashtable();
        unmodifiableAllIds = Collections.unmodifiableSet(PlayerAPI.allBaseConstructors.keySet());
        allBaseBeforeSuperiors = new Hashtable();
        allBaseBeforeInferiors = new Hashtable();
        allBaseOverrideSuperiors = new Hashtable();
        allBaseOverrideInferiors = new Hashtable();
        allBaseAfterSuperiors = new Hashtable();
        allBaseAfterInferiors = new Hashtable();
        PlayerAPI.initialized = false;
    }
}
