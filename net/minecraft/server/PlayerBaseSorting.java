package net.minecraft.server;

public final class PlayerBaseSorting
{
    private String[] beforeLocalConstructingSuperiors;
    private String[] beforeLocalConstructingInferiors;
    private String[] afterLocalConstructingSuperiors;
    private String[] afterLocalConstructingInferiors;
    private String[] beforeAddExhaustionSuperiors;
    private String[] beforeAddExhaustionInferiors;
    private String[] overrideAddExhaustionSuperiors;
    private String[] overrideAddExhaustionInferiors;
    private String[] afterAddExhaustionSuperiors;
    private String[] afterAddExhaustionInferiors;
    private String[] beforeAddMovementStatSuperiors;
    private String[] beforeAddMovementStatInferiors;
    private String[] overrideAddMovementStatSuperiors;
    private String[] overrideAddMovementStatInferiors;
    private String[] afterAddMovementStatSuperiors;
    private String[] afterAddMovementStatInferiors;
    private String[] beforeAddStatSuperiors;
    private String[] beforeAddStatInferiors;
    private String[] overrideAddStatSuperiors;
    private String[] overrideAddStatInferiors;
    private String[] afterAddStatSuperiors;
    private String[] afterAddStatInferiors;
    private String[] beforeAttackEntityFromSuperiors;
    private String[] beforeAttackEntityFromInferiors;
    private String[] overrideAttackEntityFromSuperiors;
    private String[] overrideAttackEntityFromInferiors;
    private String[] afterAttackEntityFromSuperiors;
    private String[] afterAttackEntityFromInferiors;
    private String[] beforeAlertWolvesSuperiors;
    private String[] beforeAlertWolvesInferiors;
    private String[] overrideAlertWolvesSuperiors;
    private String[] overrideAlertWolvesInferiors;
    private String[] afterAlertWolvesSuperiors;
    private String[] afterAlertWolvesInferiors;
    private String[] beforeAttackTargetEntityWithCurrentItemSuperiors;
    private String[] beforeAttackTargetEntityWithCurrentItemInferiors;
    private String[] overrideAttackTargetEntityWithCurrentItemSuperiors;
    private String[] overrideAttackTargetEntityWithCurrentItemInferiors;
    private String[] afterAttackTargetEntityWithCurrentItemSuperiors;
    private String[] afterAttackTargetEntityWithCurrentItemInferiors;
    private String[] beforeCanBreatheUnderwaterSuperiors;
    private String[] beforeCanBreatheUnderwaterInferiors;
    private String[] overrideCanBreatheUnderwaterSuperiors;
    private String[] overrideCanBreatheUnderwaterInferiors;
    private String[] afterCanBreatheUnderwaterSuperiors;
    private String[] afterCanBreatheUnderwaterInferiors;
    private String[] beforeCanHarvestBlockSuperiors;
    private String[] beforeCanHarvestBlockInferiors;
    private String[] overrideCanHarvestBlockSuperiors;
    private String[] overrideCanHarvestBlockInferiors;
    private String[] afterCanHarvestBlockSuperiors;
    private String[] afterCanHarvestBlockInferiors;
    private String[] beforeCanPlayerEditSuperiors;
    private String[] beforeCanPlayerEditInferiors;
    private String[] overrideCanPlayerEditSuperiors;
    private String[] overrideCanPlayerEditInferiors;
    private String[] afterCanPlayerEditSuperiors;
    private String[] afterCanPlayerEditInferiors;
    private String[] beforeCanTriggerWalkingSuperiors;
    private String[] beforeCanTriggerWalkingInferiors;
    private String[] overrideCanTriggerWalkingSuperiors;
    private String[] overrideCanTriggerWalkingInferiors;
    private String[] afterCanTriggerWalkingSuperiors;
    private String[] afterCanTriggerWalkingInferiors;
    private String[] beforeCloseScreenSuperiors;
    private String[] beforeCloseScreenInferiors;
    private String[] overrideCloseScreenSuperiors;
    private String[] overrideCloseScreenInferiors;
    private String[] afterCloseScreenSuperiors;
    private String[] afterCloseScreenInferiors;
    private String[] beforeDamageEntitySuperiors;
    private String[] beforeDamageEntityInferiors;
    private String[] overrideDamageEntitySuperiors;
    private String[] overrideDamageEntityInferiors;
    private String[] afterDamageEntitySuperiors;
    private String[] afterDamageEntityInferiors;
    private String[] beforeDisplayGUIBrewingStandSuperiors;
    private String[] beforeDisplayGUIBrewingStandInferiors;
    private String[] overrideDisplayGUIBrewingStandSuperiors;
    private String[] overrideDisplayGUIBrewingStandInferiors;
    private String[] afterDisplayGUIBrewingStandSuperiors;
    private String[] afterDisplayGUIBrewingStandInferiors;
    private String[] beforeDisplayGUIChestSuperiors;
    private String[] beforeDisplayGUIChestInferiors;
    private String[] overrideDisplayGUIChestSuperiors;
    private String[] overrideDisplayGUIChestInferiors;
    private String[] afterDisplayGUIChestSuperiors;
    private String[] afterDisplayGUIChestInferiors;
    private String[] beforeDisplayGUIDispenserSuperiors;
    private String[] beforeDisplayGUIDispenserInferiors;
    private String[] overrideDisplayGUIDispenserSuperiors;
    private String[] overrideDisplayGUIDispenserInferiors;
    private String[] afterDisplayGUIDispenserSuperiors;
    private String[] afterDisplayGUIDispenserInferiors;
    private String[] beforeDisplayGUIEditSignSuperiors;
    private String[] beforeDisplayGUIEditSignInferiors;
    private String[] overrideDisplayGUIEditSignSuperiors;
    private String[] overrideDisplayGUIEditSignInferiors;
    private String[] afterDisplayGUIEditSignSuperiors;
    private String[] afterDisplayGUIEditSignInferiors;
    private String[] beforeDisplayGUIEnchantmentSuperiors;
    private String[] beforeDisplayGUIEnchantmentInferiors;
    private String[] overrideDisplayGUIEnchantmentSuperiors;
    private String[] overrideDisplayGUIEnchantmentInferiors;
    private String[] afterDisplayGUIEnchantmentSuperiors;
    private String[] afterDisplayGUIEnchantmentInferiors;
    private String[] beforeDisplayGUIFurnaceSuperiors;
    private String[] beforeDisplayGUIFurnaceInferiors;
    private String[] overrideDisplayGUIFurnaceSuperiors;
    private String[] overrideDisplayGUIFurnaceInferiors;
    private String[] afterDisplayGUIFurnaceSuperiors;
    private String[] afterDisplayGUIFurnaceInferiors;
    private String[] beforeDisplayWorkbenchGUISuperiors;
    private String[] beforeDisplayWorkbenchGUIInferiors;
    private String[] overrideDisplayWorkbenchGUISuperiors;
    private String[] overrideDisplayWorkbenchGUIInferiors;
    private String[] afterDisplayWorkbenchGUISuperiors;
    private String[] afterDisplayWorkbenchGUIInferiors;
    private String[] beforeDropOneItemSuperiors;
    private String[] beforeDropOneItemInferiors;
    private String[] overrideDropOneItemSuperiors;
    private String[] overrideDropOneItemInferiors;
    private String[] afterDropOneItemSuperiors;
    private String[] afterDropOneItemInferiors;
    private String[] beforeDropPlayerItemSuperiors;
    private String[] beforeDropPlayerItemInferiors;
    private String[] overrideDropPlayerItemSuperiors;
    private String[] overrideDropPlayerItemInferiors;
    private String[] afterDropPlayerItemSuperiors;
    private String[] afterDropPlayerItemInferiors;
    private String[] beforeDropPlayerItemWithRandomChoiceSuperiors;
    private String[] beforeDropPlayerItemWithRandomChoiceInferiors;
    private String[] overrideDropPlayerItemWithRandomChoiceSuperiors;
    private String[] overrideDropPlayerItemWithRandomChoiceInferiors;
    private String[] afterDropPlayerItemWithRandomChoiceSuperiors;
    private String[] afterDropPlayerItemWithRandomChoiceInferiors;
    private String[] beforeFallSuperiors;
    private String[] beforeFallInferiors;
    private String[] overrideFallSuperiors;
    private String[] overrideFallInferiors;
    private String[] afterFallSuperiors;
    private String[] afterFallInferiors;
    private String[] beforeGetBrightnessSuperiors;
    private String[] beforeGetBrightnessInferiors;
    private String[] overrideGetBrightnessSuperiors;
    private String[] overrideGetBrightnessInferiors;
    private String[] afterGetBrightnessSuperiors;
    private String[] afterGetBrightnessInferiors;
    private String[] beforeGetBrightnessForRenderSuperiors;
    private String[] beforeGetBrightnessForRenderInferiors;
    private String[] overrideGetBrightnessForRenderSuperiors;
    private String[] overrideGetBrightnessForRenderInferiors;
    private String[] afterGetBrightnessForRenderSuperiors;
    private String[] afterGetBrightnessForRenderInferiors;
    private String[] beforeGetCurrentPlayerStrVsBlockSuperiors;
    private String[] beforeGetCurrentPlayerStrVsBlockInferiors;
    private String[] overrideGetCurrentPlayerStrVsBlockSuperiors;
    private String[] overrideGetCurrentPlayerStrVsBlockInferiors;
    private String[] afterGetCurrentPlayerStrVsBlockSuperiors;
    private String[] afterGetCurrentPlayerStrVsBlockInferiors;
    private String[] beforeGetDistanceSqSuperiors;
    private String[] beforeGetDistanceSqInferiors;
    private String[] overrideGetDistanceSqSuperiors;
    private String[] overrideGetDistanceSqInferiors;
    private String[] afterGetDistanceSqSuperiors;
    private String[] afterGetDistanceSqInferiors;
    private String[] beforeGetDistanceSqToEntitySuperiors;
    private String[] beforeGetDistanceSqToEntityInferiors;
    private String[] overrideGetDistanceSqToEntitySuperiors;
    private String[] overrideGetDistanceSqToEntityInferiors;
    private String[] afterGetDistanceSqToEntitySuperiors;
    private String[] afterGetDistanceSqToEntityInferiors;
    private String[] beforeGetFOVMultiplierSuperiors;
    private String[] beforeGetFOVMultiplierInferiors;
    private String[] overrideGetFOVMultiplierSuperiors;
    private String[] overrideGetFOVMultiplierInferiors;
    private String[] afterGetFOVMultiplierSuperiors;
    private String[] afterGetFOVMultiplierInferiors;
    private String[] beforeGetHurtSoundSuperiors;
    private String[] beforeGetHurtSoundInferiors;
    private String[] overrideGetHurtSoundSuperiors;
    private String[] overrideGetHurtSoundInferiors;
    private String[] afterGetHurtSoundSuperiors;
    private String[] afterGetHurtSoundInferiors;
    private String[] beforeGetItemIconSuperiors;
    private String[] beforeGetItemIconInferiors;
    private String[] overrideGetItemIconSuperiors;
    private String[] overrideGetItemIconInferiors;
    private String[] afterGetItemIconSuperiors;
    private String[] afterGetItemIconInferiors;
    private String[] beforeGetSleepTimerSuperiors;
    private String[] beforeGetSleepTimerInferiors;
    private String[] overrideGetSleepTimerSuperiors;
    private String[] overrideGetSleepTimerInferiors;
    private String[] afterGetSleepTimerSuperiors;
    private String[] afterGetSleepTimerInferiors;
    private String[] beforeGetSpeedModifierSuperiors;
    private String[] beforeGetSpeedModifierInferiors;
    private String[] overrideGetSpeedModifierSuperiors;
    private String[] overrideGetSpeedModifierInferiors;
    private String[] afterGetSpeedModifierSuperiors;
    private String[] afterGetSpeedModifierInferiors;
    private String[] beforeHandleLavaMovementSuperiors;
    private String[] beforeHandleLavaMovementInferiors;
    private String[] overrideHandleLavaMovementSuperiors;
    private String[] overrideHandleLavaMovementInferiors;
    private String[] afterHandleLavaMovementSuperiors;
    private String[] afterHandleLavaMovementInferiors;
    private String[] beforeHandleWaterMovementSuperiors;
    private String[] beforeHandleWaterMovementInferiors;
    private String[] overrideHandleWaterMovementSuperiors;
    private String[] overrideHandleWaterMovementInferiors;
    private String[] afterHandleWaterMovementSuperiors;
    private String[] afterHandleWaterMovementInferiors;
    private String[] beforeHealSuperiors;
    private String[] beforeHealInferiors;
    private String[] overrideHealSuperiors;
    private String[] overrideHealInferiors;
    private String[] afterHealSuperiors;
    private String[] afterHealInferiors;
    private String[] beforeIsEntityInsideOpaqueBlockSuperiors;
    private String[] beforeIsEntityInsideOpaqueBlockInferiors;
    private String[] overrideIsEntityInsideOpaqueBlockSuperiors;
    private String[] overrideIsEntityInsideOpaqueBlockInferiors;
    private String[] afterIsEntityInsideOpaqueBlockSuperiors;
    private String[] afterIsEntityInsideOpaqueBlockInferiors;
    private String[] beforeIsInWaterSuperiors;
    private String[] beforeIsInWaterInferiors;
    private String[] overrideIsInWaterSuperiors;
    private String[] overrideIsInWaterInferiors;
    private String[] afterIsInWaterSuperiors;
    private String[] afterIsInWaterInferiors;
    private String[] beforeIsInsideOfMaterialSuperiors;
    private String[] beforeIsInsideOfMaterialInferiors;
    private String[] overrideIsInsideOfMaterialSuperiors;
    private String[] overrideIsInsideOfMaterialInferiors;
    private String[] afterIsInsideOfMaterialSuperiors;
    private String[] afterIsInsideOfMaterialInferiors;
    private String[] beforeIsOnLadderSuperiors;
    private String[] beforeIsOnLadderInferiors;
    private String[] overrideIsOnLadderSuperiors;
    private String[] overrideIsOnLadderInferiors;
    private String[] afterIsOnLadderSuperiors;
    private String[] afterIsOnLadderInferiors;
    private String[] beforeIsSneakingSuperiors;
    private String[] beforeIsSneakingInferiors;
    private String[] overrideIsSneakingSuperiors;
    private String[] overrideIsSneakingInferiors;
    private String[] afterIsSneakingSuperiors;
    private String[] afterIsSneakingInferiors;
    private String[] beforeIsSprintingSuperiors;
    private String[] beforeIsSprintingInferiors;
    private String[] overrideIsSprintingSuperiors;
    private String[] overrideIsSprintingInferiors;
    private String[] afterIsSprintingSuperiors;
    private String[] afterIsSprintingInferiors;
    private String[] beforeJumpSuperiors;
    private String[] beforeJumpInferiors;
    private String[] overrideJumpSuperiors;
    private String[] overrideJumpInferiors;
    private String[] afterJumpSuperiors;
    private String[] afterJumpInferiors;
    private String[] beforeKnockBackSuperiors;
    private String[] beforeKnockBackInferiors;
    private String[] overrideKnockBackSuperiors;
    private String[] overrideKnockBackInferiors;
    private String[] afterKnockBackSuperiors;
    private String[] afterKnockBackInferiors;
    private String[] beforeMoveEntitySuperiors;
    private String[] beforeMoveEntityInferiors;
    private String[] overrideMoveEntitySuperiors;
    private String[] overrideMoveEntityInferiors;
    private String[] afterMoveEntitySuperiors;
    private String[] afterMoveEntityInferiors;
    private String[] beforeMoveEntityWithHeadingSuperiors;
    private String[] beforeMoveEntityWithHeadingInferiors;
    private String[] overrideMoveEntityWithHeadingSuperiors;
    private String[] overrideMoveEntityWithHeadingInferiors;
    private String[] afterMoveEntityWithHeadingSuperiors;
    private String[] afterMoveEntityWithHeadingInferiors;
    private String[] beforeMoveFlyingSuperiors;
    private String[] beforeMoveFlyingInferiors;
    private String[] overrideMoveFlyingSuperiors;
    private String[] overrideMoveFlyingInferiors;
    private String[] afterMoveFlyingSuperiors;
    private String[] afterMoveFlyingInferiors;
    private String[] beforeOnDeathSuperiors;
    private String[] beforeOnDeathInferiors;
    private String[] overrideOnDeathSuperiors;
    private String[] overrideOnDeathInferiors;
    private String[] afterOnDeathSuperiors;
    private String[] afterOnDeathInferiors;
    private String[] beforeOnLivingUpdateSuperiors;
    private String[] beforeOnLivingUpdateInferiors;
    private String[] overrideOnLivingUpdateSuperiors;
    private String[] overrideOnLivingUpdateInferiors;
    private String[] afterOnLivingUpdateSuperiors;
    private String[] afterOnLivingUpdateInferiors;
    private String[] beforeOnKillEntitySuperiors;
    private String[] beforeOnKillEntityInferiors;
    private String[] overrideOnKillEntitySuperiors;
    private String[] overrideOnKillEntityInferiors;
    private String[] afterOnKillEntitySuperiors;
    private String[] afterOnKillEntityInferiors;
    private String[] beforeOnUpdateSuperiors;
    private String[] beforeOnUpdateInferiors;
    private String[] overrideOnUpdateSuperiors;
    private String[] overrideOnUpdateInferiors;
    private String[] afterOnUpdateSuperiors;
    private String[] afterOnUpdateInferiors;
    private String[] beforePlayStepSoundSuperiors;
    private String[] beforePlayStepSoundInferiors;
    private String[] overridePlayStepSoundSuperiors;
    private String[] overridePlayStepSoundInferiors;
    private String[] afterPlayStepSoundSuperiors;
    private String[] afterPlayStepSoundInferiors;
    private String[] beforePushOutOfBlocksSuperiors;
    private String[] beforePushOutOfBlocksInferiors;
    private String[] overridePushOutOfBlocksSuperiors;
    private String[] overridePushOutOfBlocksInferiors;
    private String[] afterPushOutOfBlocksSuperiors;
    private String[] afterPushOutOfBlocksInferiors;
    private String[] beforeRayTraceSuperiors;
    private String[] beforeRayTraceInferiors;
    private String[] overrideRayTraceSuperiors;
    private String[] overrideRayTraceInferiors;
    private String[] afterRayTraceSuperiors;
    private String[] afterRayTraceInferiors;
    private String[] beforeReadEntityFromNBTSuperiors;
    private String[] beforeReadEntityFromNBTInferiors;
    private String[] overrideReadEntityFromNBTSuperiors;
    private String[] overrideReadEntityFromNBTInferiors;
    private String[] afterReadEntityFromNBTSuperiors;
    private String[] afterReadEntityFromNBTInferiors;
    private String[] beforeRespawnPlayerSuperiors;
    private String[] beforeRespawnPlayerInferiors;
    private String[] overrideRespawnPlayerSuperiors;
    private String[] overrideRespawnPlayerInferiors;
    private String[] afterRespawnPlayerSuperiors;
    private String[] afterRespawnPlayerInferiors;
    private String[] beforeSendChatMessageSuperiors;
    private String[] beforeSendChatMessageInferiors;
    private String[] overrideSendChatMessageSuperiors;
    private String[] overrideSendChatMessageInferiors;
    private String[] afterSendChatMessageSuperiors;
    private String[] afterSendChatMessageInferiors;
    private String[] beforeSetDeadSuperiors;
    private String[] beforeSetDeadInferiors;
    private String[] overrideSetDeadSuperiors;
    private String[] overrideSetDeadInferiors;
    private String[] afterSetDeadSuperiors;
    private String[] afterSetDeadInferiors;
    private String[] beforeSetPositionAndRotationSuperiors;
    private String[] beforeSetPositionAndRotationInferiors;
    private String[] overrideSetPositionAndRotationSuperiors;
    private String[] overrideSetPositionAndRotationInferiors;
    private String[] afterSetPositionAndRotationSuperiors;
    private String[] afterSetPositionAndRotationInferiors;
    private String[] beforeSleepInBedAtSuperiors;
    private String[] beforeSleepInBedAtInferiors;
    private String[] overrideSleepInBedAtSuperiors;
    private String[] overrideSleepInBedAtInferiors;
    private String[] afterSleepInBedAtSuperiors;
    private String[] afterSleepInBedAtInferiors;
    private String[] beforeSwingItemSuperiors;
    private String[] beforeSwingItemInferiors;
    private String[] overrideSwingItemSuperiors;
    private String[] overrideSwingItemInferiors;
    private String[] afterSwingItemSuperiors;
    private String[] afterSwingItemInferiors;
    private String[] beforeUpdateEntityActionStateSuperiors;
    private String[] beforeUpdateEntityActionStateInferiors;
    private String[] overrideUpdateEntityActionStateSuperiors;
    private String[] overrideUpdateEntityActionStateInferiors;
    private String[] afterUpdateEntityActionStateSuperiors;
    private String[] afterUpdateEntityActionStateInferiors;
    private String[] beforeWriteEntityToNBTSuperiors;
    private String[] beforeWriteEntityToNBTInferiors;
    private String[] overrideWriteEntityToNBTSuperiors;
    private String[] overrideWriteEntityToNBTInferiors;
    private String[] afterWriteEntityToNBTSuperiors;
    private String[] afterWriteEntityToNBTInferiors;
    
    public PlayerBaseSorting() {
        this.beforeLocalConstructingSuperiors = null;
        this.beforeLocalConstructingInferiors = null;
        this.afterLocalConstructingSuperiors = null;
        this.afterLocalConstructingInferiors = null;
        this.beforeAddExhaustionSuperiors = null;
        this.beforeAddExhaustionInferiors = null;
        this.overrideAddExhaustionSuperiors = null;
        this.overrideAddExhaustionInferiors = null;
        this.afterAddExhaustionSuperiors = null;
        this.afterAddExhaustionInferiors = null;
        this.beforeAddMovementStatSuperiors = null;
        this.beforeAddMovementStatInferiors = null;
        this.overrideAddMovementStatSuperiors = null;
        this.overrideAddMovementStatInferiors = null;
        this.afterAddMovementStatSuperiors = null;
        this.afterAddMovementStatInferiors = null;
        this.beforeAddStatSuperiors = null;
        this.beforeAddStatInferiors = null;
        this.overrideAddStatSuperiors = null;
        this.overrideAddStatInferiors = null;
        this.afterAddStatSuperiors = null;
        this.afterAddStatInferiors = null;
        this.beforeAttackEntityFromSuperiors = null;
        this.beforeAttackEntityFromInferiors = null;
        this.overrideAttackEntityFromSuperiors = null;
        this.overrideAttackEntityFromInferiors = null;
        this.afterAttackEntityFromSuperiors = null;
        this.afterAttackEntityFromInferiors = null;
        this.beforeAlertWolvesSuperiors = null;
        this.beforeAlertWolvesInferiors = null;
        this.overrideAlertWolvesSuperiors = null;
        this.overrideAlertWolvesInferiors = null;
        this.afterAlertWolvesSuperiors = null;
        this.afterAlertWolvesInferiors = null;
        this.beforeAttackTargetEntityWithCurrentItemSuperiors = null;
        this.beforeAttackTargetEntityWithCurrentItemInferiors = null;
        this.overrideAttackTargetEntityWithCurrentItemSuperiors = null;
        this.overrideAttackTargetEntityWithCurrentItemInferiors = null;
        this.afterAttackTargetEntityWithCurrentItemSuperiors = null;
        this.afterAttackTargetEntityWithCurrentItemInferiors = null;
        this.beforeCanBreatheUnderwaterSuperiors = null;
        this.beforeCanBreatheUnderwaterInferiors = null;
        this.overrideCanBreatheUnderwaterSuperiors = null;
        this.overrideCanBreatheUnderwaterInferiors = null;
        this.afterCanBreatheUnderwaterSuperiors = null;
        this.afterCanBreatheUnderwaterInferiors = null;
        this.beforeCanHarvestBlockSuperiors = null;
        this.beforeCanHarvestBlockInferiors = null;
        this.overrideCanHarvestBlockSuperiors = null;
        this.overrideCanHarvestBlockInferiors = null;
        this.afterCanHarvestBlockSuperiors = null;
        this.afterCanHarvestBlockInferiors = null;
        this.beforeCanPlayerEditSuperiors = null;
        this.beforeCanPlayerEditInferiors = null;
        this.overrideCanPlayerEditSuperiors = null;
        this.overrideCanPlayerEditInferiors = null;
        this.afterCanPlayerEditSuperiors = null;
        this.afterCanPlayerEditInferiors = null;
        this.beforeCanTriggerWalkingSuperiors = null;
        this.beforeCanTriggerWalkingInferiors = null;
        this.overrideCanTriggerWalkingSuperiors = null;
        this.overrideCanTriggerWalkingInferiors = null;
        this.afterCanTriggerWalkingSuperiors = null;
        this.afterCanTriggerWalkingInferiors = null;
        this.beforeCloseScreenSuperiors = null;
        this.beforeCloseScreenInferiors = null;
        this.overrideCloseScreenSuperiors = null;
        this.overrideCloseScreenInferiors = null;
        this.afterCloseScreenSuperiors = null;
        this.afterCloseScreenInferiors = null;
        this.beforeDamageEntitySuperiors = null;
        this.beforeDamageEntityInferiors = null;
        this.overrideDamageEntitySuperiors = null;
        this.overrideDamageEntityInferiors = null;
        this.afterDamageEntitySuperiors = null;
        this.afterDamageEntityInferiors = null;
        this.beforeDisplayGUIBrewingStandSuperiors = null;
        this.beforeDisplayGUIBrewingStandInferiors = null;
        this.overrideDisplayGUIBrewingStandSuperiors = null;
        this.overrideDisplayGUIBrewingStandInferiors = null;
        this.afterDisplayGUIBrewingStandSuperiors = null;
        this.afterDisplayGUIBrewingStandInferiors = null;
        this.beforeDisplayGUIChestSuperiors = null;
        this.beforeDisplayGUIChestInferiors = null;
        this.overrideDisplayGUIChestSuperiors = null;
        this.overrideDisplayGUIChestInferiors = null;
        this.afterDisplayGUIChestSuperiors = null;
        this.afterDisplayGUIChestInferiors = null;
        this.beforeDisplayGUIDispenserSuperiors = null;
        this.beforeDisplayGUIDispenserInferiors = null;
        this.overrideDisplayGUIDispenserSuperiors = null;
        this.overrideDisplayGUIDispenserInferiors = null;
        this.afterDisplayGUIDispenserSuperiors = null;
        this.afterDisplayGUIDispenserInferiors = null;
        this.beforeDisplayGUIEditSignSuperiors = null;
        this.beforeDisplayGUIEditSignInferiors = null;
        this.overrideDisplayGUIEditSignSuperiors = null;
        this.overrideDisplayGUIEditSignInferiors = null;
        this.afterDisplayGUIEditSignSuperiors = null;
        this.afterDisplayGUIEditSignInferiors = null;
        this.beforeDisplayGUIEnchantmentSuperiors = null;
        this.beforeDisplayGUIEnchantmentInferiors = null;
        this.overrideDisplayGUIEnchantmentSuperiors = null;
        this.overrideDisplayGUIEnchantmentInferiors = null;
        this.afterDisplayGUIEnchantmentSuperiors = null;
        this.afterDisplayGUIEnchantmentInferiors = null;
        this.beforeDisplayGUIFurnaceSuperiors = null;
        this.beforeDisplayGUIFurnaceInferiors = null;
        this.overrideDisplayGUIFurnaceSuperiors = null;
        this.overrideDisplayGUIFurnaceInferiors = null;
        this.afterDisplayGUIFurnaceSuperiors = null;
        this.afterDisplayGUIFurnaceInferiors = null;
        this.beforeDisplayWorkbenchGUISuperiors = null;
        this.beforeDisplayWorkbenchGUIInferiors = null;
        this.overrideDisplayWorkbenchGUISuperiors = null;
        this.overrideDisplayWorkbenchGUIInferiors = null;
        this.afterDisplayWorkbenchGUISuperiors = null;
        this.afterDisplayWorkbenchGUIInferiors = null;
        this.beforeDropOneItemSuperiors = null;
        this.beforeDropOneItemInferiors = null;
        this.overrideDropOneItemSuperiors = null;
        this.overrideDropOneItemInferiors = null;
        this.afterDropOneItemSuperiors = null;
        this.afterDropOneItemInferiors = null;
        this.beforeDropPlayerItemSuperiors = null;
        this.beforeDropPlayerItemInferiors = null;
        this.overrideDropPlayerItemSuperiors = null;
        this.overrideDropPlayerItemInferiors = null;
        this.afterDropPlayerItemSuperiors = null;
        this.afterDropPlayerItemInferiors = null;
        this.beforeDropPlayerItemWithRandomChoiceSuperiors = null;
        this.beforeDropPlayerItemWithRandomChoiceInferiors = null;
        this.overrideDropPlayerItemWithRandomChoiceSuperiors = null;
        this.overrideDropPlayerItemWithRandomChoiceInferiors = null;
        this.afterDropPlayerItemWithRandomChoiceSuperiors = null;
        this.afterDropPlayerItemWithRandomChoiceInferiors = null;
        this.beforeFallSuperiors = null;
        this.beforeFallInferiors = null;
        this.overrideFallSuperiors = null;
        this.overrideFallInferiors = null;
        this.afterFallSuperiors = null;
        this.afterFallInferiors = null;
        this.beforeGetBrightnessSuperiors = null;
        this.beforeGetBrightnessInferiors = null;
        this.overrideGetBrightnessSuperiors = null;
        this.overrideGetBrightnessInferiors = null;
        this.afterGetBrightnessSuperiors = null;
        this.afterGetBrightnessInferiors = null;
        this.beforeGetBrightnessForRenderSuperiors = null;
        this.beforeGetBrightnessForRenderInferiors = null;
        this.overrideGetBrightnessForRenderSuperiors = null;
        this.overrideGetBrightnessForRenderInferiors = null;
        this.afterGetBrightnessForRenderSuperiors = null;
        this.afterGetBrightnessForRenderInferiors = null;
        this.beforeGetCurrentPlayerStrVsBlockSuperiors = null;
        this.beforeGetCurrentPlayerStrVsBlockInferiors = null;
        this.overrideGetCurrentPlayerStrVsBlockSuperiors = null;
        this.overrideGetCurrentPlayerStrVsBlockInferiors = null;
        this.afterGetCurrentPlayerStrVsBlockSuperiors = null;
        this.afterGetCurrentPlayerStrVsBlockInferiors = null;
        this.beforeGetDistanceSqSuperiors = null;
        this.beforeGetDistanceSqInferiors = null;
        this.overrideGetDistanceSqSuperiors = null;
        this.overrideGetDistanceSqInferiors = null;
        this.afterGetDistanceSqSuperiors = null;
        this.afterGetDistanceSqInferiors = null;
        this.beforeGetDistanceSqToEntitySuperiors = null;
        this.beforeGetDistanceSqToEntityInferiors = null;
        this.overrideGetDistanceSqToEntitySuperiors = null;
        this.overrideGetDistanceSqToEntityInferiors = null;
        this.afterGetDistanceSqToEntitySuperiors = null;
        this.afterGetDistanceSqToEntityInferiors = null;
        this.beforeGetFOVMultiplierSuperiors = null;
        this.beforeGetFOVMultiplierInferiors = null;
        this.overrideGetFOVMultiplierSuperiors = null;
        this.overrideGetFOVMultiplierInferiors = null;
        this.afterGetFOVMultiplierSuperiors = null;
        this.afterGetFOVMultiplierInferiors = null;
        this.beforeGetHurtSoundSuperiors = null;
        this.beforeGetHurtSoundInferiors = null;
        this.overrideGetHurtSoundSuperiors = null;
        this.overrideGetHurtSoundInferiors = null;
        this.afterGetHurtSoundSuperiors = null;
        this.afterGetHurtSoundInferiors = null;
        this.beforeGetItemIconSuperiors = null;
        this.beforeGetItemIconInferiors = null;
        this.overrideGetItemIconSuperiors = null;
        this.overrideGetItemIconInferiors = null;
        this.afterGetItemIconSuperiors = null;
        this.afterGetItemIconInferiors = null;
        this.beforeGetSleepTimerSuperiors = null;
        this.beforeGetSleepTimerInferiors = null;
        this.overrideGetSleepTimerSuperiors = null;
        this.overrideGetSleepTimerInferiors = null;
        this.afterGetSleepTimerSuperiors = null;
        this.afterGetSleepTimerInferiors = null;
        this.beforeGetSpeedModifierSuperiors = null;
        this.beforeGetSpeedModifierInferiors = null;
        this.overrideGetSpeedModifierSuperiors = null;
        this.overrideGetSpeedModifierInferiors = null;
        this.afterGetSpeedModifierSuperiors = null;
        this.afterGetSpeedModifierInferiors = null;
        this.beforeHandleLavaMovementSuperiors = null;
        this.beforeHandleLavaMovementInferiors = null;
        this.overrideHandleLavaMovementSuperiors = null;
        this.overrideHandleLavaMovementInferiors = null;
        this.afterHandleLavaMovementSuperiors = null;
        this.afterHandleLavaMovementInferiors = null;
        this.beforeHandleWaterMovementSuperiors = null;
        this.beforeHandleWaterMovementInferiors = null;
        this.overrideHandleWaterMovementSuperiors = null;
        this.overrideHandleWaterMovementInferiors = null;
        this.afterHandleWaterMovementSuperiors = null;
        this.afterHandleWaterMovementInferiors = null;
        this.beforeHealSuperiors = null;
        this.beforeHealInferiors = null;
        this.overrideHealSuperiors = null;
        this.overrideHealInferiors = null;
        this.afterHealSuperiors = null;
        this.afterHealInferiors = null;
        this.beforeIsEntityInsideOpaqueBlockSuperiors = null;
        this.beforeIsEntityInsideOpaqueBlockInferiors = null;
        this.overrideIsEntityInsideOpaqueBlockSuperiors = null;
        this.overrideIsEntityInsideOpaqueBlockInferiors = null;
        this.afterIsEntityInsideOpaqueBlockSuperiors = null;
        this.afterIsEntityInsideOpaqueBlockInferiors = null;
        this.beforeIsInWaterSuperiors = null;
        this.beforeIsInWaterInferiors = null;
        this.overrideIsInWaterSuperiors = null;
        this.overrideIsInWaterInferiors = null;
        this.afterIsInWaterSuperiors = null;
        this.afterIsInWaterInferiors = null;
        this.beforeIsInsideOfMaterialSuperiors = null;
        this.beforeIsInsideOfMaterialInferiors = null;
        this.overrideIsInsideOfMaterialSuperiors = null;
        this.overrideIsInsideOfMaterialInferiors = null;
        this.afterIsInsideOfMaterialSuperiors = null;
        this.afterIsInsideOfMaterialInferiors = null;
        this.beforeIsOnLadderSuperiors = null;
        this.beforeIsOnLadderInferiors = null;
        this.overrideIsOnLadderSuperiors = null;
        this.overrideIsOnLadderInferiors = null;
        this.afterIsOnLadderSuperiors = null;
        this.afterIsOnLadderInferiors = null;
        this.beforeIsSneakingSuperiors = null;
        this.beforeIsSneakingInferiors = null;
        this.overrideIsSneakingSuperiors = null;
        this.overrideIsSneakingInferiors = null;
        this.afterIsSneakingSuperiors = null;
        this.afterIsSneakingInferiors = null;
        this.beforeIsSprintingSuperiors = null;
        this.beforeIsSprintingInferiors = null;
        this.overrideIsSprintingSuperiors = null;
        this.overrideIsSprintingInferiors = null;
        this.afterIsSprintingSuperiors = null;
        this.afterIsSprintingInferiors = null;
        this.beforeJumpSuperiors = null;
        this.beforeJumpInferiors = null;
        this.overrideJumpSuperiors = null;
        this.overrideJumpInferiors = null;
        this.afterJumpSuperiors = null;
        this.afterJumpInferiors = null;
        this.beforeKnockBackSuperiors = null;
        this.beforeKnockBackInferiors = null;
        this.overrideKnockBackSuperiors = null;
        this.overrideKnockBackInferiors = null;
        this.afterKnockBackSuperiors = null;
        this.afterKnockBackInferiors = null;
        this.beforeMoveEntitySuperiors = null;
        this.beforeMoveEntityInferiors = null;
        this.overrideMoveEntitySuperiors = null;
        this.overrideMoveEntityInferiors = null;
        this.afterMoveEntitySuperiors = null;
        this.afterMoveEntityInferiors = null;
        this.beforeMoveEntityWithHeadingSuperiors = null;
        this.beforeMoveEntityWithHeadingInferiors = null;
        this.overrideMoveEntityWithHeadingSuperiors = null;
        this.overrideMoveEntityWithHeadingInferiors = null;
        this.afterMoveEntityWithHeadingSuperiors = null;
        this.afterMoveEntityWithHeadingInferiors = null;
        this.beforeMoveFlyingSuperiors = null;
        this.beforeMoveFlyingInferiors = null;
        this.overrideMoveFlyingSuperiors = null;
        this.overrideMoveFlyingInferiors = null;
        this.afterMoveFlyingSuperiors = null;
        this.afterMoveFlyingInferiors = null;
        this.beforeOnDeathSuperiors = null;
        this.beforeOnDeathInferiors = null;
        this.overrideOnDeathSuperiors = null;
        this.overrideOnDeathInferiors = null;
        this.afterOnDeathSuperiors = null;
        this.afterOnDeathInferiors = null;
        this.beforeOnLivingUpdateSuperiors = null;
        this.beforeOnLivingUpdateInferiors = null;
        this.overrideOnLivingUpdateSuperiors = null;
        this.overrideOnLivingUpdateInferiors = null;
        this.afterOnLivingUpdateSuperiors = null;
        this.afterOnLivingUpdateInferiors = null;
        this.beforeOnKillEntitySuperiors = null;
        this.beforeOnKillEntityInferiors = null;
        this.overrideOnKillEntitySuperiors = null;
        this.overrideOnKillEntityInferiors = null;
        this.afterOnKillEntitySuperiors = null;
        this.afterOnKillEntityInferiors = null;
        this.beforeOnUpdateSuperiors = null;
        this.beforeOnUpdateInferiors = null;
        this.overrideOnUpdateSuperiors = null;
        this.overrideOnUpdateInferiors = null;
        this.afterOnUpdateSuperiors = null;
        this.afterOnUpdateInferiors = null;
        this.beforePlayStepSoundSuperiors = null;
        this.beforePlayStepSoundInferiors = null;
        this.overridePlayStepSoundSuperiors = null;
        this.overridePlayStepSoundInferiors = null;
        this.afterPlayStepSoundSuperiors = null;
        this.afterPlayStepSoundInferiors = null;
        this.beforePushOutOfBlocksSuperiors = null;
        this.beforePushOutOfBlocksInferiors = null;
        this.overridePushOutOfBlocksSuperiors = null;
        this.overridePushOutOfBlocksInferiors = null;
        this.afterPushOutOfBlocksSuperiors = null;
        this.afterPushOutOfBlocksInferiors = null;
        this.beforeRayTraceSuperiors = null;
        this.beforeRayTraceInferiors = null;
        this.overrideRayTraceSuperiors = null;
        this.overrideRayTraceInferiors = null;
        this.afterRayTraceSuperiors = null;
        this.afterRayTraceInferiors = null;
        this.beforeReadEntityFromNBTSuperiors = null;
        this.beforeReadEntityFromNBTInferiors = null;
        this.overrideReadEntityFromNBTSuperiors = null;
        this.overrideReadEntityFromNBTInferiors = null;
        this.afterReadEntityFromNBTSuperiors = null;
        this.afterReadEntityFromNBTInferiors = null;
        this.beforeRespawnPlayerSuperiors = null;
        this.beforeRespawnPlayerInferiors = null;
        this.overrideRespawnPlayerSuperiors = null;
        this.overrideRespawnPlayerInferiors = null;
        this.afterRespawnPlayerSuperiors = null;
        this.afterRespawnPlayerInferiors = null;
        this.beforeSendChatMessageSuperiors = null;
        this.beforeSendChatMessageInferiors = null;
        this.overrideSendChatMessageSuperiors = null;
        this.overrideSendChatMessageInferiors = null;
        this.afterSendChatMessageSuperiors = null;
        this.afterSendChatMessageInferiors = null;
        this.beforeSetDeadSuperiors = null;
        this.beforeSetDeadInferiors = null;
        this.overrideSetDeadSuperiors = null;
        this.overrideSetDeadInferiors = null;
        this.afterSetDeadSuperiors = null;
        this.afterSetDeadInferiors = null;
        this.beforeSetPositionAndRotationSuperiors = null;
        this.beforeSetPositionAndRotationInferiors = null;
        this.overrideSetPositionAndRotationSuperiors = null;
        this.overrideSetPositionAndRotationInferiors = null;
        this.afterSetPositionAndRotationSuperiors = null;
        this.afterSetPositionAndRotationInferiors = null;
        this.beforeSleepInBedAtSuperiors = null;
        this.beforeSleepInBedAtInferiors = null;
        this.overrideSleepInBedAtSuperiors = null;
        this.overrideSleepInBedAtInferiors = null;
        this.afterSleepInBedAtSuperiors = null;
        this.afterSleepInBedAtInferiors = null;
        this.beforeSwingItemSuperiors = null;
        this.beforeSwingItemInferiors = null;
        this.overrideSwingItemSuperiors = null;
        this.overrideSwingItemInferiors = null;
        this.afterSwingItemSuperiors = null;
        this.afterSwingItemInferiors = null;
        this.beforeUpdateEntityActionStateSuperiors = null;
        this.beforeUpdateEntityActionStateInferiors = null;
        this.overrideUpdateEntityActionStateSuperiors = null;
        this.overrideUpdateEntityActionStateInferiors = null;
        this.afterUpdateEntityActionStateSuperiors = null;
        this.afterUpdateEntityActionStateInferiors = null;
        this.beforeWriteEntityToNBTSuperiors = null;
        this.beforeWriteEntityToNBTInferiors = null;
        this.overrideWriteEntityToNBTSuperiors = null;
        this.overrideWriteEntityToNBTInferiors = null;
        this.afterWriteEntityToNBTSuperiors = null;
        this.afterWriteEntityToNBTInferiors = null;
    }
    
    public String[] getBeforeLocalConstructingSuperiors() {
        return this.beforeLocalConstructingSuperiors;
    }
    
    public String[] getBeforeLocalConstructingInferiors() {
        return this.beforeLocalConstructingInferiors;
    }
    
    public String[] getAfterLocalConstructingSuperiors() {
        return this.afterLocalConstructingSuperiors;
    }
    
    public String[] getAfterLocalConstructingInferiors() {
        return this.afterLocalConstructingInferiors;
    }
    
    public void setBeforeLocalConstructingSuperiors(final String[] var1) {
        this.beforeLocalConstructingSuperiors = var1;
    }
    
    public void setBeforeLocalConstructingInferiors(final String[] var1) {
        this.beforeLocalConstructingInferiors = var1;
    }
    
    public void setAfterLocalConstructingSuperiors(final String[] var1) {
        this.afterLocalConstructingSuperiors = var1;
    }
    
    public void setAfterLocalConstructingInferiors(final String[] var1) {
        this.afterLocalConstructingInferiors = var1;
    }
    
    public String[] getBeforeAddExhaustionSuperiors() {
        return this.beforeAddExhaustionSuperiors;
    }
    
    public String[] getBeforeAddExhaustionInferiors() {
        return this.beforeAddExhaustionInferiors;
    }
    
    public String[] getOverrideAddExhaustionSuperiors() {
        return this.overrideAddExhaustionSuperiors;
    }
    
    public String[] getOverrideAddExhaustionInferiors() {
        return this.overrideAddExhaustionInferiors;
    }
    
    public String[] getAfterAddExhaustionSuperiors() {
        return this.afterAddExhaustionSuperiors;
    }
    
    public String[] getAfterAddExhaustionInferiors() {
        return this.afterAddExhaustionInferiors;
    }
    
    public void setBeforeAddExhaustionSuperiors(final String[] var1) {
        this.beforeAddExhaustionSuperiors = var1;
    }
    
    public void setBeforeAddExhaustionInferiors(final String[] var1) {
        this.beforeAddExhaustionInferiors = var1;
    }
    
    public void setOverrideAddExhaustionSuperiors(final String[] var1) {
        this.overrideAddExhaustionSuperiors = var1;
    }
    
    public void setOverrideAddExhaustionInferiors(final String[] var1) {
        this.overrideAddExhaustionInferiors = var1;
    }
    
    public void setAfterAddExhaustionSuperiors(final String[] var1) {
        this.afterAddExhaustionSuperiors = var1;
    }
    
    public void setAfterAddExhaustionInferiors(final String[] var1) {
        this.afterAddExhaustionInferiors = var1;
    }
    
    public String[] getBeforeAddMovementStatSuperiors() {
        return this.beforeAddMovementStatSuperiors;
    }
    
    public String[] getBeforeAddMovementStatInferiors() {
        return this.beforeAddMovementStatInferiors;
    }
    
    public String[] getOverrideAddMovementStatSuperiors() {
        return this.overrideAddMovementStatSuperiors;
    }
    
    public String[] getOverrideAddMovementStatInferiors() {
        return this.overrideAddMovementStatInferiors;
    }
    
    public String[] getAfterAddMovementStatSuperiors() {
        return this.afterAddMovementStatSuperiors;
    }
    
    public String[] getAfterAddMovementStatInferiors() {
        return this.afterAddMovementStatInferiors;
    }
    
    public void setBeforeAddMovementStatSuperiors(final String[] var1) {
        this.beforeAddMovementStatSuperiors = var1;
    }
    
    public void setBeforeAddMovementStatInferiors(final String[] var1) {
        this.beforeAddMovementStatInferiors = var1;
    }
    
    public void setOverrideAddMovementStatSuperiors(final String[] var1) {
        this.overrideAddMovementStatSuperiors = var1;
    }
    
    public void setOverrideAddMovementStatInferiors(final String[] var1) {
        this.overrideAddMovementStatInferiors = var1;
    }
    
    public void setAfterAddMovementStatSuperiors(final String[] var1) {
        this.afterAddMovementStatSuperiors = var1;
    }
    
    public void setAfterAddMovementStatInferiors(final String[] var1) {
        this.afterAddMovementStatInferiors = var1;
    }
    
    public String[] getBeforeAddStatSuperiors() {
        return this.beforeAddStatSuperiors;
    }
    
    public String[] getBeforeAddStatInferiors() {
        return this.beforeAddStatInferiors;
    }
    
    public String[] getOverrideAddStatSuperiors() {
        return this.overrideAddStatSuperiors;
    }
    
    public String[] getOverrideAddStatInferiors() {
        return this.overrideAddStatInferiors;
    }
    
    public String[] getAfterAddStatSuperiors() {
        return this.afterAddStatSuperiors;
    }
    
    public String[] getAfterAddStatInferiors() {
        return this.afterAddStatInferiors;
    }
    
    public void setBeforeAddStatSuperiors(final String[] var1) {
        this.beforeAddStatSuperiors = var1;
    }
    
    public void setBeforeAddStatInferiors(final String[] var1) {
        this.beforeAddStatInferiors = var1;
    }
    
    public void setOverrideAddStatSuperiors(final String[] var1) {
        this.overrideAddStatSuperiors = var1;
    }
    
    public void setOverrideAddStatInferiors(final String[] var1) {
        this.overrideAddStatInferiors = var1;
    }
    
    public void setAfterAddStatSuperiors(final String[] var1) {
        this.afterAddStatSuperiors = var1;
    }
    
    public void setAfterAddStatInferiors(final String[] var1) {
        this.afterAddStatInferiors = var1;
    }
    
    public String[] getBeforeAttackEntityFromSuperiors() {
        return this.beforeAttackEntityFromSuperiors;
    }
    
    public String[] getBeforeAttackEntityFromInferiors() {
        return this.beforeAttackEntityFromInferiors;
    }
    
    public String[] getOverrideAttackEntityFromSuperiors() {
        return this.overrideAttackEntityFromSuperiors;
    }
    
    public String[] getOverrideAttackEntityFromInferiors() {
        return this.overrideAttackEntityFromInferiors;
    }
    
    public String[] getAfterAttackEntityFromSuperiors() {
        return this.afterAttackEntityFromSuperiors;
    }
    
    public String[] getAfterAttackEntityFromInferiors() {
        return this.afterAttackEntityFromInferiors;
    }
    
    public void setBeforeAttackEntityFromSuperiors(final String[] var1) {
        this.beforeAttackEntityFromSuperiors = var1;
    }
    
    public void setBeforeAttackEntityFromInferiors(final String[] var1) {
        this.beforeAttackEntityFromInferiors = var1;
    }
    
    public void setOverrideAttackEntityFromSuperiors(final String[] var1) {
        this.overrideAttackEntityFromSuperiors = var1;
    }
    
    public void setOverrideAttackEntityFromInferiors(final String[] var1) {
        this.overrideAttackEntityFromInferiors = var1;
    }
    
    public void setAfterAttackEntityFromSuperiors(final String[] var1) {
        this.afterAttackEntityFromSuperiors = var1;
    }
    
    public void setAfterAttackEntityFromInferiors(final String[] var1) {
        this.afterAttackEntityFromInferiors = var1;
    }
    
    public String[] getBeforeAlertWolvesSuperiors() {
        return this.beforeAlertWolvesSuperiors;
    }
    
    public String[] getBeforeAlertWolvesInferiors() {
        return this.beforeAlertWolvesInferiors;
    }
    
    public String[] getOverrideAlertWolvesSuperiors() {
        return this.overrideAlertWolvesSuperiors;
    }
    
    public String[] getOverrideAlertWolvesInferiors() {
        return this.overrideAlertWolvesInferiors;
    }
    
    public String[] getAfterAlertWolvesSuperiors() {
        return this.afterAlertWolvesSuperiors;
    }
    
    public String[] getAfterAlertWolvesInferiors() {
        return this.afterAlertWolvesInferiors;
    }
    
    public void setBeforeAlertWolvesSuperiors(final String[] var1) {
        this.beforeAlertWolvesSuperiors = var1;
    }
    
    public void setBeforeAlertWolvesInferiors(final String[] var1) {
        this.beforeAlertWolvesInferiors = var1;
    }
    
    public void setOverrideAlertWolvesSuperiors(final String[] var1) {
        this.overrideAlertWolvesSuperiors = var1;
    }
    
    public void setOverrideAlertWolvesInferiors(final String[] var1) {
        this.overrideAlertWolvesInferiors = var1;
    }
    
    public void setAfterAlertWolvesSuperiors(final String[] var1) {
        this.afterAlertWolvesSuperiors = var1;
    }
    
    public void setAfterAlertWolvesInferiors(final String[] var1) {
        this.afterAlertWolvesInferiors = var1;
    }
    
    public String[] getBeforeAttackTargetEntityWithCurrentItemSuperiors() {
        return this.beforeAttackTargetEntityWithCurrentItemSuperiors;
    }
    
    public String[] getBeforeAttackTargetEntityWithCurrentItemInferiors() {
        return this.beforeAttackTargetEntityWithCurrentItemInferiors;
    }
    
    public String[] getOverrideAttackTargetEntityWithCurrentItemSuperiors() {
        return this.overrideAttackTargetEntityWithCurrentItemSuperiors;
    }
    
    public String[] getOverrideAttackTargetEntityWithCurrentItemInferiors() {
        return this.overrideAttackTargetEntityWithCurrentItemInferiors;
    }
    
    public String[] getAfterAttackTargetEntityWithCurrentItemSuperiors() {
        return this.afterAttackTargetEntityWithCurrentItemSuperiors;
    }
    
    public String[] getAfterAttackTargetEntityWithCurrentItemInferiors() {
        return this.afterAttackTargetEntityWithCurrentItemInferiors;
    }
    
    public void setBeforeAttackTargetEntityWithCurrentItemSuperiors(final String[] var1) {
        this.beforeAttackTargetEntityWithCurrentItemSuperiors = var1;
    }
    
    public void setBeforeAttackTargetEntityWithCurrentItemInferiors(final String[] var1) {
        this.beforeAttackTargetEntityWithCurrentItemInferiors = var1;
    }
    
    public void setOverrideAttackTargetEntityWithCurrentItemSuperiors(final String[] var1) {
        this.overrideAttackTargetEntityWithCurrentItemSuperiors = var1;
    }
    
    public void setOverrideAttackTargetEntityWithCurrentItemInferiors(final String[] var1) {
        this.overrideAttackTargetEntityWithCurrentItemInferiors = var1;
    }
    
    public void setAfterAttackTargetEntityWithCurrentItemSuperiors(final String[] var1) {
        this.afterAttackTargetEntityWithCurrentItemSuperiors = var1;
    }
    
    public void setAfterAttackTargetEntityWithCurrentItemInferiors(final String[] var1) {
        this.afterAttackTargetEntityWithCurrentItemInferiors = var1;
    }
    
    public String[] getBeforeCanBreatheUnderwaterSuperiors() {
        return this.beforeCanBreatheUnderwaterSuperiors;
    }
    
    public String[] getBeforeCanBreatheUnderwaterInferiors() {
        return this.beforeCanBreatheUnderwaterInferiors;
    }
    
    public String[] getOverrideCanBreatheUnderwaterSuperiors() {
        return this.overrideCanBreatheUnderwaterSuperiors;
    }
    
    public String[] getOverrideCanBreatheUnderwaterInferiors() {
        return this.overrideCanBreatheUnderwaterInferiors;
    }
    
    public String[] getAfterCanBreatheUnderwaterSuperiors() {
        return this.afterCanBreatheUnderwaterSuperiors;
    }
    
    public String[] getAfterCanBreatheUnderwaterInferiors() {
        return this.afterCanBreatheUnderwaterInferiors;
    }
    
    public void setBeforeCanBreatheUnderwaterSuperiors(final String[] var1) {
        this.beforeCanBreatheUnderwaterSuperiors = var1;
    }
    
    public void setBeforeCanBreatheUnderwaterInferiors(final String[] var1) {
        this.beforeCanBreatheUnderwaterInferiors = var1;
    }
    
    public void setOverrideCanBreatheUnderwaterSuperiors(final String[] var1) {
        this.overrideCanBreatheUnderwaterSuperiors = var1;
    }
    
    public void setOverrideCanBreatheUnderwaterInferiors(final String[] var1) {
        this.overrideCanBreatheUnderwaterInferiors = var1;
    }
    
    public void setAfterCanBreatheUnderwaterSuperiors(final String[] var1) {
        this.afterCanBreatheUnderwaterSuperiors = var1;
    }
    
    public void setAfterCanBreatheUnderwaterInferiors(final String[] var1) {
        this.afterCanBreatheUnderwaterInferiors = var1;
    }
    
    public String[] getBeforeCanHarvestBlockSuperiors() {
        return this.beforeCanHarvestBlockSuperiors;
    }
    
    public String[] getBeforeCanHarvestBlockInferiors() {
        return this.beforeCanHarvestBlockInferiors;
    }
    
    public String[] getOverrideCanHarvestBlockSuperiors() {
        return this.overrideCanHarvestBlockSuperiors;
    }
    
    public String[] getOverrideCanHarvestBlockInferiors() {
        return this.overrideCanHarvestBlockInferiors;
    }
    
    public String[] getAfterCanHarvestBlockSuperiors() {
        return this.afterCanHarvestBlockSuperiors;
    }
    
    public String[] getAfterCanHarvestBlockInferiors() {
        return this.afterCanHarvestBlockInferiors;
    }
    
    public void setBeforeCanHarvestBlockSuperiors(final String[] var1) {
        this.beforeCanHarvestBlockSuperiors = var1;
    }
    
    public void setBeforeCanHarvestBlockInferiors(final String[] var1) {
        this.beforeCanHarvestBlockInferiors = var1;
    }
    
    public void setOverrideCanHarvestBlockSuperiors(final String[] var1) {
        this.overrideCanHarvestBlockSuperiors = var1;
    }
    
    public void setOverrideCanHarvestBlockInferiors(final String[] var1) {
        this.overrideCanHarvestBlockInferiors = var1;
    }
    
    public void setAfterCanHarvestBlockSuperiors(final String[] var1) {
        this.afterCanHarvestBlockSuperiors = var1;
    }
    
    public void setAfterCanHarvestBlockInferiors(final String[] var1) {
        this.afterCanHarvestBlockInferiors = var1;
    }
    
    public String[] getBeforeCanPlayerEditSuperiors() {
        return this.beforeCanPlayerEditSuperiors;
    }
    
    public String[] getBeforeCanPlayerEditInferiors() {
        return this.beforeCanPlayerEditInferiors;
    }
    
    public String[] getOverrideCanPlayerEditSuperiors() {
        return this.overrideCanPlayerEditSuperiors;
    }
    
    public String[] getOverrideCanPlayerEditInferiors() {
        return this.overrideCanPlayerEditInferiors;
    }
    
    public String[] getAfterCanPlayerEditSuperiors() {
        return this.afterCanPlayerEditSuperiors;
    }
    
    public String[] getAfterCanPlayerEditInferiors() {
        return this.afterCanPlayerEditInferiors;
    }
    
    public void setBeforeCanPlayerEditSuperiors(final String[] var1) {
        this.beforeCanPlayerEditSuperiors = var1;
    }
    
    public void setBeforeCanPlayerEditInferiors(final String[] var1) {
        this.beforeCanPlayerEditInferiors = var1;
    }
    
    public void setOverrideCanPlayerEditSuperiors(final String[] var1) {
        this.overrideCanPlayerEditSuperiors = var1;
    }
    
    public void setOverrideCanPlayerEditInferiors(final String[] var1) {
        this.overrideCanPlayerEditInferiors = var1;
    }
    
    public void setAfterCanPlayerEditSuperiors(final String[] var1) {
        this.afterCanPlayerEditSuperiors = var1;
    }
    
    public void setAfterCanPlayerEditInferiors(final String[] var1) {
        this.afterCanPlayerEditInferiors = var1;
    }
    
    public String[] getBeforeCanTriggerWalkingSuperiors() {
        return this.beforeCanTriggerWalkingSuperiors;
    }
    
    public String[] getBeforeCanTriggerWalkingInferiors() {
        return this.beforeCanTriggerWalkingInferiors;
    }
    
    public String[] getOverrideCanTriggerWalkingSuperiors() {
        return this.overrideCanTriggerWalkingSuperiors;
    }
    
    public String[] getOverrideCanTriggerWalkingInferiors() {
        return this.overrideCanTriggerWalkingInferiors;
    }
    
    public String[] getAfterCanTriggerWalkingSuperiors() {
        return this.afterCanTriggerWalkingSuperiors;
    }
    
    public String[] getAfterCanTriggerWalkingInferiors() {
        return this.afterCanTriggerWalkingInferiors;
    }
    
    public void setBeforeCanTriggerWalkingSuperiors(final String[] var1) {
        this.beforeCanTriggerWalkingSuperiors = var1;
    }
    
    public void setBeforeCanTriggerWalkingInferiors(final String[] var1) {
        this.beforeCanTriggerWalkingInferiors = var1;
    }
    
    public void setOverrideCanTriggerWalkingSuperiors(final String[] var1) {
        this.overrideCanTriggerWalkingSuperiors = var1;
    }
    
    public void setOverrideCanTriggerWalkingInferiors(final String[] var1) {
        this.overrideCanTriggerWalkingInferiors = var1;
    }
    
    public void setAfterCanTriggerWalkingSuperiors(final String[] var1) {
        this.afterCanTriggerWalkingSuperiors = var1;
    }
    
    public void setAfterCanTriggerWalkingInferiors(final String[] var1) {
        this.afterCanTriggerWalkingInferiors = var1;
    }
    
    public String[] getBeforeCloseScreenSuperiors() {
        return this.beforeCloseScreenSuperiors;
    }
    
    public String[] getBeforeCloseScreenInferiors() {
        return this.beforeCloseScreenInferiors;
    }
    
    public String[] getOverrideCloseScreenSuperiors() {
        return this.overrideCloseScreenSuperiors;
    }
    
    public String[] getOverrideCloseScreenInferiors() {
        return this.overrideCloseScreenInferiors;
    }
    
    public String[] getAfterCloseScreenSuperiors() {
        return this.afterCloseScreenSuperiors;
    }
    
    public String[] getAfterCloseScreenInferiors() {
        return this.afterCloseScreenInferiors;
    }
    
    public void setBeforeCloseScreenSuperiors(final String[] var1) {
        this.beforeCloseScreenSuperiors = var1;
    }
    
    public void setBeforeCloseScreenInferiors(final String[] var1) {
        this.beforeCloseScreenInferiors = var1;
    }
    
    public void setOverrideCloseScreenSuperiors(final String[] var1) {
        this.overrideCloseScreenSuperiors = var1;
    }
    
    public void setOverrideCloseScreenInferiors(final String[] var1) {
        this.overrideCloseScreenInferiors = var1;
    }
    
    public void setAfterCloseScreenSuperiors(final String[] var1) {
        this.afterCloseScreenSuperiors = var1;
    }
    
    public void setAfterCloseScreenInferiors(final String[] var1) {
        this.afterCloseScreenInferiors = var1;
    }
    
    public String[] getBeforeDamageEntitySuperiors() {
        return this.beforeDamageEntitySuperiors;
    }
    
    public String[] getBeforeDamageEntityInferiors() {
        return this.beforeDamageEntityInferiors;
    }
    
    public String[] getOverrideDamageEntitySuperiors() {
        return this.overrideDamageEntitySuperiors;
    }
    
    public String[] getOverrideDamageEntityInferiors() {
        return this.overrideDamageEntityInferiors;
    }
    
    public String[] getAfterDamageEntitySuperiors() {
        return this.afterDamageEntitySuperiors;
    }
    
    public String[] getAfterDamageEntityInferiors() {
        return this.afterDamageEntityInferiors;
    }
    
    public void setBeforeDamageEntitySuperiors(final String[] var1) {
        this.beforeDamageEntitySuperiors = var1;
    }
    
    public void setBeforeDamageEntityInferiors(final String[] var1) {
        this.beforeDamageEntityInferiors = var1;
    }
    
    public void setOverrideDamageEntitySuperiors(final String[] var1) {
        this.overrideDamageEntitySuperiors = var1;
    }
    
    public void setOverrideDamageEntityInferiors(final String[] var1) {
        this.overrideDamageEntityInferiors = var1;
    }
    
    public void setAfterDamageEntitySuperiors(final String[] var1) {
        this.afterDamageEntitySuperiors = var1;
    }
    
    public void setAfterDamageEntityInferiors(final String[] var1) {
        this.afterDamageEntityInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIBrewingStandSuperiors() {
        return this.beforeDisplayGUIBrewingStandSuperiors;
    }
    
    public String[] getBeforeDisplayGUIBrewingStandInferiors() {
        return this.beforeDisplayGUIBrewingStandInferiors;
    }
    
    public String[] getOverrideDisplayGUIBrewingStandSuperiors() {
        return this.overrideDisplayGUIBrewingStandSuperiors;
    }
    
    public String[] getOverrideDisplayGUIBrewingStandInferiors() {
        return this.overrideDisplayGUIBrewingStandInferiors;
    }
    
    public String[] getAfterDisplayGUIBrewingStandSuperiors() {
        return this.afterDisplayGUIBrewingStandSuperiors;
    }
    
    public String[] getAfterDisplayGUIBrewingStandInferiors() {
        return this.afterDisplayGUIBrewingStandInferiors;
    }
    
    public void setBeforeDisplayGUIBrewingStandSuperiors(final String[] var1) {
        this.beforeDisplayGUIBrewingStandSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIBrewingStandInferiors(final String[] var1) {
        this.beforeDisplayGUIBrewingStandInferiors = var1;
    }
    
    public void setOverrideDisplayGUIBrewingStandSuperiors(final String[] var1) {
        this.overrideDisplayGUIBrewingStandSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIBrewingStandInferiors(final String[] var1) {
        this.overrideDisplayGUIBrewingStandInferiors = var1;
    }
    
    public void setAfterDisplayGUIBrewingStandSuperiors(final String[] var1) {
        this.afterDisplayGUIBrewingStandSuperiors = var1;
    }
    
    public void setAfterDisplayGUIBrewingStandInferiors(final String[] var1) {
        this.afterDisplayGUIBrewingStandInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIChestSuperiors() {
        return this.beforeDisplayGUIChestSuperiors;
    }
    
    public String[] getBeforeDisplayGUIChestInferiors() {
        return this.beforeDisplayGUIChestInferiors;
    }
    
    public String[] getOverrideDisplayGUIChestSuperiors() {
        return this.overrideDisplayGUIChestSuperiors;
    }
    
    public String[] getOverrideDisplayGUIChestInferiors() {
        return this.overrideDisplayGUIChestInferiors;
    }
    
    public String[] getAfterDisplayGUIChestSuperiors() {
        return this.afterDisplayGUIChestSuperiors;
    }
    
    public String[] getAfterDisplayGUIChestInferiors() {
        return this.afterDisplayGUIChestInferiors;
    }
    
    public void setBeforeDisplayGUIChestSuperiors(final String[] var1) {
        this.beforeDisplayGUIChestSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIChestInferiors(final String[] var1) {
        this.beforeDisplayGUIChestInferiors = var1;
    }
    
    public void setOverrideDisplayGUIChestSuperiors(final String[] var1) {
        this.overrideDisplayGUIChestSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIChestInferiors(final String[] var1) {
        this.overrideDisplayGUIChestInferiors = var1;
    }
    
    public void setAfterDisplayGUIChestSuperiors(final String[] var1) {
        this.afterDisplayGUIChestSuperiors = var1;
    }
    
    public void setAfterDisplayGUIChestInferiors(final String[] var1) {
        this.afterDisplayGUIChestInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIDispenserSuperiors() {
        return this.beforeDisplayGUIDispenserSuperiors;
    }
    
    public String[] getBeforeDisplayGUIDispenserInferiors() {
        return this.beforeDisplayGUIDispenserInferiors;
    }
    
    public String[] getOverrideDisplayGUIDispenserSuperiors() {
        return this.overrideDisplayGUIDispenserSuperiors;
    }
    
    public String[] getOverrideDisplayGUIDispenserInferiors() {
        return this.overrideDisplayGUIDispenserInferiors;
    }
    
    public String[] getAfterDisplayGUIDispenserSuperiors() {
        return this.afterDisplayGUIDispenserSuperiors;
    }
    
    public String[] getAfterDisplayGUIDispenserInferiors() {
        return this.afterDisplayGUIDispenserInferiors;
    }
    
    public void setBeforeDisplayGUIDispenserSuperiors(final String[] var1) {
        this.beforeDisplayGUIDispenserSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIDispenserInferiors(final String[] var1) {
        this.beforeDisplayGUIDispenserInferiors = var1;
    }
    
    public void setOverrideDisplayGUIDispenserSuperiors(final String[] var1) {
        this.overrideDisplayGUIDispenserSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIDispenserInferiors(final String[] var1) {
        this.overrideDisplayGUIDispenserInferiors = var1;
    }
    
    public void setAfterDisplayGUIDispenserSuperiors(final String[] var1) {
        this.afterDisplayGUIDispenserSuperiors = var1;
    }
    
    public void setAfterDisplayGUIDispenserInferiors(final String[] var1) {
        this.afterDisplayGUIDispenserInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIEditSignSuperiors() {
        return this.beforeDisplayGUIEditSignSuperiors;
    }
    
    public String[] getBeforeDisplayGUIEditSignInferiors() {
        return this.beforeDisplayGUIEditSignInferiors;
    }
    
    public String[] getOverrideDisplayGUIEditSignSuperiors() {
        return this.overrideDisplayGUIEditSignSuperiors;
    }
    
    public String[] getOverrideDisplayGUIEditSignInferiors() {
        return this.overrideDisplayGUIEditSignInferiors;
    }
    
    public String[] getAfterDisplayGUIEditSignSuperiors() {
        return this.afterDisplayGUIEditSignSuperiors;
    }
    
    public String[] getAfterDisplayGUIEditSignInferiors() {
        return this.afterDisplayGUIEditSignInferiors;
    }
    
    public void setBeforeDisplayGUIEditSignSuperiors(final String[] var1) {
        this.beforeDisplayGUIEditSignSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIEditSignInferiors(final String[] var1) {
        this.beforeDisplayGUIEditSignInferiors = var1;
    }
    
    public void setOverrideDisplayGUIEditSignSuperiors(final String[] var1) {
        this.overrideDisplayGUIEditSignSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIEditSignInferiors(final String[] var1) {
        this.overrideDisplayGUIEditSignInferiors = var1;
    }
    
    public void setAfterDisplayGUIEditSignSuperiors(final String[] var1) {
        this.afterDisplayGUIEditSignSuperiors = var1;
    }
    
    public void setAfterDisplayGUIEditSignInferiors(final String[] var1) {
        this.afterDisplayGUIEditSignInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIEnchantmentSuperiors() {
        return this.beforeDisplayGUIEnchantmentSuperiors;
    }
    
    public String[] getBeforeDisplayGUIEnchantmentInferiors() {
        return this.beforeDisplayGUIEnchantmentInferiors;
    }
    
    public String[] getOverrideDisplayGUIEnchantmentSuperiors() {
        return this.overrideDisplayGUIEnchantmentSuperiors;
    }
    
    public String[] getOverrideDisplayGUIEnchantmentInferiors() {
        return this.overrideDisplayGUIEnchantmentInferiors;
    }
    
    public String[] getAfterDisplayGUIEnchantmentSuperiors() {
        return this.afterDisplayGUIEnchantmentSuperiors;
    }
    
    public String[] getAfterDisplayGUIEnchantmentInferiors() {
        return this.afterDisplayGUIEnchantmentInferiors;
    }
    
    public void setBeforeDisplayGUIEnchantmentSuperiors(final String[] var1) {
        this.beforeDisplayGUIEnchantmentSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIEnchantmentInferiors(final String[] var1) {
        this.beforeDisplayGUIEnchantmentInferiors = var1;
    }
    
    public void setOverrideDisplayGUIEnchantmentSuperiors(final String[] var1) {
        this.overrideDisplayGUIEnchantmentSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIEnchantmentInferiors(final String[] var1) {
        this.overrideDisplayGUIEnchantmentInferiors = var1;
    }
    
    public void setAfterDisplayGUIEnchantmentSuperiors(final String[] var1) {
        this.afterDisplayGUIEnchantmentSuperiors = var1;
    }
    
    public void setAfterDisplayGUIEnchantmentInferiors(final String[] var1) {
        this.afterDisplayGUIEnchantmentInferiors = var1;
    }
    
    public String[] getBeforeDisplayGUIFurnaceSuperiors() {
        return this.beforeDisplayGUIFurnaceSuperiors;
    }
    
    public String[] getBeforeDisplayGUIFurnaceInferiors() {
        return this.beforeDisplayGUIFurnaceInferiors;
    }
    
    public String[] getOverrideDisplayGUIFurnaceSuperiors() {
        return this.overrideDisplayGUIFurnaceSuperiors;
    }
    
    public String[] getOverrideDisplayGUIFurnaceInferiors() {
        return this.overrideDisplayGUIFurnaceInferiors;
    }
    
    public String[] getAfterDisplayGUIFurnaceSuperiors() {
        return this.afterDisplayGUIFurnaceSuperiors;
    }
    
    public String[] getAfterDisplayGUIFurnaceInferiors() {
        return this.afterDisplayGUIFurnaceInferiors;
    }
    
    public void setBeforeDisplayGUIFurnaceSuperiors(final String[] var1) {
        this.beforeDisplayGUIFurnaceSuperiors = var1;
    }
    
    public void setBeforeDisplayGUIFurnaceInferiors(final String[] var1) {
        this.beforeDisplayGUIFurnaceInferiors = var1;
    }
    
    public void setOverrideDisplayGUIFurnaceSuperiors(final String[] var1) {
        this.overrideDisplayGUIFurnaceSuperiors = var1;
    }
    
    public void setOverrideDisplayGUIFurnaceInferiors(final String[] var1) {
        this.overrideDisplayGUIFurnaceInferiors = var1;
    }
    
    public void setAfterDisplayGUIFurnaceSuperiors(final String[] var1) {
        this.afterDisplayGUIFurnaceSuperiors = var1;
    }
    
    public void setAfterDisplayGUIFurnaceInferiors(final String[] var1) {
        this.afterDisplayGUIFurnaceInferiors = var1;
    }
    
    public String[] getBeforeDisplayWorkbenchGUISuperiors() {
        return this.beforeDisplayWorkbenchGUISuperiors;
    }
    
    public String[] getBeforeDisplayWorkbenchGUIInferiors() {
        return this.beforeDisplayWorkbenchGUIInferiors;
    }
    
    public String[] getOverrideDisplayWorkbenchGUISuperiors() {
        return this.overrideDisplayWorkbenchGUISuperiors;
    }
    
    public String[] getOverrideDisplayWorkbenchGUIInferiors() {
        return this.overrideDisplayWorkbenchGUIInferiors;
    }
    
    public String[] getAfterDisplayWorkbenchGUISuperiors() {
        return this.afterDisplayWorkbenchGUISuperiors;
    }
    
    public String[] getAfterDisplayWorkbenchGUIInferiors() {
        return this.afterDisplayWorkbenchGUIInferiors;
    }
    
    public void setBeforeDisplayWorkbenchGUISuperiors(final String[] var1) {
        this.beforeDisplayWorkbenchGUISuperiors = var1;
    }
    
    public void setBeforeDisplayWorkbenchGUIInferiors(final String[] var1) {
        this.beforeDisplayWorkbenchGUIInferiors = var1;
    }
    
    public void setOverrideDisplayWorkbenchGUISuperiors(final String[] var1) {
        this.overrideDisplayWorkbenchGUISuperiors = var1;
    }
    
    public void setOverrideDisplayWorkbenchGUIInferiors(final String[] var1) {
        this.overrideDisplayWorkbenchGUIInferiors = var1;
    }
    
    public void setAfterDisplayWorkbenchGUISuperiors(final String[] var1) {
        this.afterDisplayWorkbenchGUISuperiors = var1;
    }
    
    public void setAfterDisplayWorkbenchGUIInferiors(final String[] var1) {
        this.afterDisplayWorkbenchGUIInferiors = var1;
    }
    
    public String[] getBeforeDropOneItemSuperiors() {
        return this.beforeDropOneItemSuperiors;
    }
    
    public String[] getBeforeDropOneItemInferiors() {
        return this.beforeDropOneItemInferiors;
    }
    
    public String[] getOverrideDropOneItemSuperiors() {
        return this.overrideDropOneItemSuperiors;
    }
    
    public String[] getOverrideDropOneItemInferiors() {
        return this.overrideDropOneItemInferiors;
    }
    
    public String[] getAfterDropOneItemSuperiors() {
        return this.afterDropOneItemSuperiors;
    }
    
    public String[] getAfterDropOneItemInferiors() {
        return this.afterDropOneItemInferiors;
    }
    
    public void setBeforeDropOneItemSuperiors(final String[] var1) {
        this.beforeDropOneItemSuperiors = var1;
    }
    
    public void setBeforeDropOneItemInferiors(final String[] var1) {
        this.beforeDropOneItemInferiors = var1;
    }
    
    public void setOverrideDropOneItemSuperiors(final String[] var1) {
        this.overrideDropOneItemSuperiors = var1;
    }
    
    public void setOverrideDropOneItemInferiors(final String[] var1) {
        this.overrideDropOneItemInferiors = var1;
    }
    
    public void setAfterDropOneItemSuperiors(final String[] var1) {
        this.afterDropOneItemSuperiors = var1;
    }
    
    public void setAfterDropOneItemInferiors(final String[] var1) {
        this.afterDropOneItemInferiors = var1;
    }
    
    public String[] getBeforeDropPlayerItemSuperiors() {
        return this.beforeDropPlayerItemSuperiors;
    }
    
    public String[] getBeforeDropPlayerItemInferiors() {
        return this.beforeDropPlayerItemInferiors;
    }
    
    public String[] getOverrideDropPlayerItemSuperiors() {
        return this.overrideDropPlayerItemSuperiors;
    }
    
    public String[] getOverrideDropPlayerItemInferiors() {
        return this.overrideDropPlayerItemInferiors;
    }
    
    public String[] getAfterDropPlayerItemSuperiors() {
        return this.afterDropPlayerItemSuperiors;
    }
    
    public String[] getAfterDropPlayerItemInferiors() {
        return this.afterDropPlayerItemInferiors;
    }
    
    public void setBeforeDropPlayerItemSuperiors(final String[] var1) {
        this.beforeDropPlayerItemSuperiors = var1;
    }
    
    public void setBeforeDropPlayerItemInferiors(final String[] var1) {
        this.beforeDropPlayerItemInferiors = var1;
    }
    
    public void setOverrideDropPlayerItemSuperiors(final String[] var1) {
        this.overrideDropPlayerItemSuperiors = var1;
    }
    
    public void setOverrideDropPlayerItemInferiors(final String[] var1) {
        this.overrideDropPlayerItemInferiors = var1;
    }
    
    public void setAfterDropPlayerItemSuperiors(final String[] var1) {
        this.afterDropPlayerItemSuperiors = var1;
    }
    
    public void setAfterDropPlayerItemInferiors(final String[] var1) {
        this.afterDropPlayerItemInferiors = var1;
    }
    
    public String[] getBeforeDropPlayerItemWithRandomChoiceSuperiors() {
        return this.beforeDropPlayerItemWithRandomChoiceSuperiors;
    }
    
    public String[] getBeforeDropPlayerItemWithRandomChoiceInferiors() {
        return this.beforeDropPlayerItemWithRandomChoiceInferiors;
    }
    
    public String[] getOverrideDropPlayerItemWithRandomChoiceSuperiors() {
        return this.overrideDropPlayerItemWithRandomChoiceSuperiors;
    }
    
    public String[] getOverrideDropPlayerItemWithRandomChoiceInferiors() {
        return this.overrideDropPlayerItemWithRandomChoiceInferiors;
    }
    
    public String[] getAfterDropPlayerItemWithRandomChoiceSuperiors() {
        return this.afterDropPlayerItemWithRandomChoiceSuperiors;
    }
    
    public String[] getAfterDropPlayerItemWithRandomChoiceInferiors() {
        return this.afterDropPlayerItemWithRandomChoiceInferiors;
    }
    
    public void setBeforeDropPlayerItemWithRandomChoiceSuperiors(final String[] var1) {
        this.beforeDropPlayerItemWithRandomChoiceSuperiors = var1;
    }
    
    public void setBeforeDropPlayerItemWithRandomChoiceInferiors(final String[] var1) {
        this.beforeDropPlayerItemWithRandomChoiceInferiors = var1;
    }
    
    public void setOverrideDropPlayerItemWithRandomChoiceSuperiors(final String[] var1) {
        this.overrideDropPlayerItemWithRandomChoiceSuperiors = var1;
    }
    
    public void setOverrideDropPlayerItemWithRandomChoiceInferiors(final String[] var1) {
        this.overrideDropPlayerItemWithRandomChoiceInferiors = var1;
    }
    
    public void setAfterDropPlayerItemWithRandomChoiceSuperiors(final String[] var1) {
        this.afterDropPlayerItemWithRandomChoiceSuperiors = var1;
    }
    
    public void setAfterDropPlayerItemWithRandomChoiceInferiors(final String[] var1) {
        this.afterDropPlayerItemWithRandomChoiceInferiors = var1;
    }
    
    public String[] getBeforeFallSuperiors() {
        return this.beforeFallSuperiors;
    }
    
    public String[] getBeforeFallInferiors() {
        return this.beforeFallInferiors;
    }
    
    public String[] getOverrideFallSuperiors() {
        return this.overrideFallSuperiors;
    }
    
    public String[] getOverrideFallInferiors() {
        return this.overrideFallInferiors;
    }
    
    public String[] getAfterFallSuperiors() {
        return this.afterFallSuperiors;
    }
    
    public String[] getAfterFallInferiors() {
        return this.afterFallInferiors;
    }
    
    public void setBeforeFallSuperiors(final String[] var1) {
        this.beforeFallSuperiors = var1;
    }
    
    public void setBeforeFallInferiors(final String[] var1) {
        this.beforeFallInferiors = var1;
    }
    
    public void setOverrideFallSuperiors(final String[] var1) {
        this.overrideFallSuperiors = var1;
    }
    
    public void setOverrideFallInferiors(final String[] var1) {
        this.overrideFallInferiors = var1;
    }
    
    public void setAfterFallSuperiors(final String[] var1) {
        this.afterFallSuperiors = var1;
    }
    
    public void setAfterFallInferiors(final String[] var1) {
        this.afterFallInferiors = var1;
    }
    
    public String[] getBeforeGetBrightnessSuperiors() {
        return this.beforeGetBrightnessSuperiors;
    }
    
    public String[] getBeforeGetBrightnessInferiors() {
        return this.beforeGetBrightnessInferiors;
    }
    
    public String[] getOverrideGetBrightnessSuperiors() {
        return this.overrideGetBrightnessSuperiors;
    }
    
    public String[] getOverrideGetBrightnessInferiors() {
        return this.overrideGetBrightnessInferiors;
    }
    
    public String[] getAfterGetBrightnessSuperiors() {
        return this.afterGetBrightnessSuperiors;
    }
    
    public String[] getAfterGetBrightnessInferiors() {
        return this.afterGetBrightnessInferiors;
    }
    
    public void setBeforeGetBrightnessSuperiors(final String[] var1) {
        this.beforeGetBrightnessSuperiors = var1;
    }
    
    public void setBeforeGetBrightnessInferiors(final String[] var1) {
        this.beforeGetBrightnessInferiors = var1;
    }
    
    public void setOverrideGetBrightnessSuperiors(final String[] var1) {
        this.overrideGetBrightnessSuperiors = var1;
    }
    
    public void setOverrideGetBrightnessInferiors(final String[] var1) {
        this.overrideGetBrightnessInferiors = var1;
    }
    
    public void setAfterGetBrightnessSuperiors(final String[] var1) {
        this.afterGetBrightnessSuperiors = var1;
    }
    
    public void setAfterGetBrightnessInferiors(final String[] var1) {
        this.afterGetBrightnessInferiors = var1;
    }
    
    public String[] getBeforeGetBrightnessForRenderSuperiors() {
        return this.beforeGetBrightnessForRenderSuperiors;
    }
    
    public String[] getBeforeGetBrightnessForRenderInferiors() {
        return this.beforeGetBrightnessForRenderInferiors;
    }
    
    public String[] getOverrideGetBrightnessForRenderSuperiors() {
        return this.overrideGetBrightnessForRenderSuperiors;
    }
    
    public String[] getOverrideGetBrightnessForRenderInferiors() {
        return this.overrideGetBrightnessForRenderInferiors;
    }
    
    public String[] getAfterGetBrightnessForRenderSuperiors() {
        return this.afterGetBrightnessForRenderSuperiors;
    }
    
    public String[] getAfterGetBrightnessForRenderInferiors() {
        return this.afterGetBrightnessForRenderInferiors;
    }
    
    public void setBeforeGetBrightnessForRenderSuperiors(final String[] var1) {
        this.beforeGetBrightnessForRenderSuperiors = var1;
    }
    
    public void setBeforeGetBrightnessForRenderInferiors(final String[] var1) {
        this.beforeGetBrightnessForRenderInferiors = var1;
    }
    
    public void setOverrideGetBrightnessForRenderSuperiors(final String[] var1) {
        this.overrideGetBrightnessForRenderSuperiors = var1;
    }
    
    public void setOverrideGetBrightnessForRenderInferiors(final String[] var1) {
        this.overrideGetBrightnessForRenderInferiors = var1;
    }
    
    public void setAfterGetBrightnessForRenderSuperiors(final String[] var1) {
        this.afterGetBrightnessForRenderSuperiors = var1;
    }
    
    public void setAfterGetBrightnessForRenderInferiors(final String[] var1) {
        this.afterGetBrightnessForRenderInferiors = var1;
    }
    
    public String[] getBeforeGetCurrentPlayerStrVsBlockSuperiors() {
        return this.beforeGetCurrentPlayerStrVsBlockSuperiors;
    }
    
    public String[] getBeforeGetCurrentPlayerStrVsBlockInferiors() {
        return this.beforeGetCurrentPlayerStrVsBlockInferiors;
    }
    
    public String[] getOverrideGetCurrentPlayerStrVsBlockSuperiors() {
        return this.overrideGetCurrentPlayerStrVsBlockSuperiors;
    }
    
    public String[] getOverrideGetCurrentPlayerStrVsBlockInferiors() {
        return this.overrideGetCurrentPlayerStrVsBlockInferiors;
    }
    
    public String[] getAfterGetCurrentPlayerStrVsBlockSuperiors() {
        return this.afterGetCurrentPlayerStrVsBlockSuperiors;
    }
    
    public String[] getAfterGetCurrentPlayerStrVsBlockInferiors() {
        return this.afterGetCurrentPlayerStrVsBlockInferiors;
    }
    
    public void setBeforeGetCurrentPlayerStrVsBlockSuperiors(final String[] var1) {
        this.beforeGetCurrentPlayerStrVsBlockSuperiors = var1;
    }
    
    public void setBeforeGetCurrentPlayerStrVsBlockInferiors(final String[] var1) {
        this.beforeGetCurrentPlayerStrVsBlockInferiors = var1;
    }
    
    public void setOverrideGetCurrentPlayerStrVsBlockSuperiors(final String[] var1) {
        this.overrideGetCurrentPlayerStrVsBlockSuperiors = var1;
    }
    
    public void setOverrideGetCurrentPlayerStrVsBlockInferiors(final String[] var1) {
        this.overrideGetCurrentPlayerStrVsBlockInferiors = var1;
    }
    
    public void setAfterGetCurrentPlayerStrVsBlockSuperiors(final String[] var1) {
        this.afterGetCurrentPlayerStrVsBlockSuperiors = var1;
    }
    
    public void setAfterGetCurrentPlayerStrVsBlockInferiors(final String[] var1) {
        this.afterGetCurrentPlayerStrVsBlockInferiors = var1;
    }
    
    public String[] getBeforeGetDistanceSqSuperiors() {
        return this.beforeGetDistanceSqSuperiors;
    }
    
    public String[] getBeforeGetDistanceSqInferiors() {
        return this.beforeGetDistanceSqInferiors;
    }
    
    public String[] getOverrideGetDistanceSqSuperiors() {
        return this.overrideGetDistanceSqSuperiors;
    }
    
    public String[] getOverrideGetDistanceSqInferiors() {
        return this.overrideGetDistanceSqInferiors;
    }
    
    public String[] getAfterGetDistanceSqSuperiors() {
        return this.afterGetDistanceSqSuperiors;
    }
    
    public String[] getAfterGetDistanceSqInferiors() {
        return this.afterGetDistanceSqInferiors;
    }
    
    public void setBeforeGetDistanceSqSuperiors(final String[] var1) {
        this.beforeGetDistanceSqSuperiors = var1;
    }
    
    public void setBeforeGetDistanceSqInferiors(final String[] var1) {
        this.beforeGetDistanceSqInferiors = var1;
    }
    
    public void setOverrideGetDistanceSqSuperiors(final String[] var1) {
        this.overrideGetDistanceSqSuperiors = var1;
    }
    
    public void setOverrideGetDistanceSqInferiors(final String[] var1) {
        this.overrideGetDistanceSqInferiors = var1;
    }
    
    public void setAfterGetDistanceSqSuperiors(final String[] var1) {
        this.afterGetDistanceSqSuperiors = var1;
    }
    
    public void setAfterGetDistanceSqInferiors(final String[] var1) {
        this.afterGetDistanceSqInferiors = var1;
    }
    
    public String[] getBeforeGetDistanceSqToEntitySuperiors() {
        return this.beforeGetDistanceSqToEntitySuperiors;
    }
    
    public String[] getBeforeGetDistanceSqToEntityInferiors() {
        return this.beforeGetDistanceSqToEntityInferiors;
    }
    
    public String[] getOverrideGetDistanceSqToEntitySuperiors() {
        return this.overrideGetDistanceSqToEntitySuperiors;
    }
    
    public String[] getOverrideGetDistanceSqToEntityInferiors() {
        return this.overrideGetDistanceSqToEntityInferiors;
    }
    
    public String[] getAfterGetDistanceSqToEntitySuperiors() {
        return this.afterGetDistanceSqToEntitySuperiors;
    }
    
    public String[] getAfterGetDistanceSqToEntityInferiors() {
        return this.afterGetDistanceSqToEntityInferiors;
    }
    
    public void setBeforeGetDistanceSqToEntitySuperiors(final String[] var1) {
        this.beforeGetDistanceSqToEntitySuperiors = var1;
    }
    
    public void setBeforeGetDistanceSqToEntityInferiors(final String[] var1) {
        this.beforeGetDistanceSqToEntityInferiors = var1;
    }
    
    public void setOverrideGetDistanceSqToEntitySuperiors(final String[] var1) {
        this.overrideGetDistanceSqToEntitySuperiors = var1;
    }
    
    public void setOverrideGetDistanceSqToEntityInferiors(final String[] var1) {
        this.overrideGetDistanceSqToEntityInferiors = var1;
    }
    
    public void setAfterGetDistanceSqToEntitySuperiors(final String[] var1) {
        this.afterGetDistanceSqToEntitySuperiors = var1;
    }
    
    public void setAfterGetDistanceSqToEntityInferiors(final String[] var1) {
        this.afterGetDistanceSqToEntityInferiors = var1;
    }
    
    public String[] getBeforeGetFOVMultiplierSuperiors() {
        return this.beforeGetFOVMultiplierSuperiors;
    }
    
    public String[] getBeforeGetFOVMultiplierInferiors() {
        return this.beforeGetFOVMultiplierInferiors;
    }
    
    public String[] getOverrideGetFOVMultiplierSuperiors() {
        return this.overrideGetFOVMultiplierSuperiors;
    }
    
    public String[] getOverrideGetFOVMultiplierInferiors() {
        return this.overrideGetFOVMultiplierInferiors;
    }
    
    public String[] getAfterGetFOVMultiplierSuperiors() {
        return this.afterGetFOVMultiplierSuperiors;
    }
    
    public String[] getAfterGetFOVMultiplierInferiors() {
        return this.afterGetFOVMultiplierInferiors;
    }
    
    public void setBeforeGetFOVMultiplierSuperiors(final String[] var1) {
        this.beforeGetFOVMultiplierSuperiors = var1;
    }
    
    public void setBeforeGetFOVMultiplierInferiors(final String[] var1) {
        this.beforeGetFOVMultiplierInferiors = var1;
    }
    
    public void setOverrideGetFOVMultiplierSuperiors(final String[] var1) {
        this.overrideGetFOVMultiplierSuperiors = var1;
    }
    
    public void setOverrideGetFOVMultiplierInferiors(final String[] var1) {
        this.overrideGetFOVMultiplierInferiors = var1;
    }
    
    public void setAfterGetFOVMultiplierSuperiors(final String[] var1) {
        this.afterGetFOVMultiplierSuperiors = var1;
    }
    
    public void setAfterGetFOVMultiplierInferiors(final String[] var1) {
        this.afterGetFOVMultiplierInferiors = var1;
    }
    
    public String[] getBeforeGetHurtSoundSuperiors() {
        return this.beforeGetHurtSoundSuperiors;
    }
    
    public String[] getBeforeGetHurtSoundInferiors() {
        return this.beforeGetHurtSoundInferiors;
    }
    
    public String[] getOverrideGetHurtSoundSuperiors() {
        return this.overrideGetHurtSoundSuperiors;
    }
    
    public String[] getOverrideGetHurtSoundInferiors() {
        return this.overrideGetHurtSoundInferiors;
    }
    
    public String[] getAfterGetHurtSoundSuperiors() {
        return this.afterGetHurtSoundSuperiors;
    }
    
    public String[] getAfterGetHurtSoundInferiors() {
        return this.afterGetHurtSoundInferiors;
    }
    
    public void setBeforeGetHurtSoundSuperiors(final String[] var1) {
        this.beforeGetHurtSoundSuperiors = var1;
    }
    
    public void setBeforeGetHurtSoundInferiors(final String[] var1) {
        this.beforeGetHurtSoundInferiors = var1;
    }
    
    public void setOverrideGetHurtSoundSuperiors(final String[] var1) {
        this.overrideGetHurtSoundSuperiors = var1;
    }
    
    public void setOverrideGetHurtSoundInferiors(final String[] var1) {
        this.overrideGetHurtSoundInferiors = var1;
    }
    
    public void setAfterGetHurtSoundSuperiors(final String[] var1) {
        this.afterGetHurtSoundSuperiors = var1;
    }
    
    public void setAfterGetHurtSoundInferiors(final String[] var1) {
        this.afterGetHurtSoundInferiors = var1;
    }
    
    public String[] getBeforeGetItemIconSuperiors() {
        return this.beforeGetItemIconSuperiors;
    }
    
    public String[] getBeforeGetItemIconInferiors() {
        return this.beforeGetItemIconInferiors;
    }
    
    public String[] getOverrideGetItemIconSuperiors() {
        return this.overrideGetItemIconSuperiors;
    }
    
    public String[] getOverrideGetItemIconInferiors() {
        return this.overrideGetItemIconInferiors;
    }
    
    public String[] getAfterGetItemIconSuperiors() {
        return this.afterGetItemIconSuperiors;
    }
    
    public String[] getAfterGetItemIconInferiors() {
        return this.afterGetItemIconInferiors;
    }
    
    public void setBeforeGetItemIconSuperiors(final String[] var1) {
        this.beforeGetItemIconSuperiors = var1;
    }
    
    public void setBeforeGetItemIconInferiors(final String[] var1) {
        this.beforeGetItemIconInferiors = var1;
    }
    
    public void setOverrideGetItemIconSuperiors(final String[] var1) {
        this.overrideGetItemIconSuperiors = var1;
    }
    
    public void setOverrideGetItemIconInferiors(final String[] var1) {
        this.overrideGetItemIconInferiors = var1;
    }
    
    public void setAfterGetItemIconSuperiors(final String[] var1) {
        this.afterGetItemIconSuperiors = var1;
    }
    
    public void setAfterGetItemIconInferiors(final String[] var1) {
        this.afterGetItemIconInferiors = var1;
    }
    
    public String[] getBeforeGetSleepTimerSuperiors() {
        return this.beforeGetSleepTimerSuperiors;
    }
    
    public String[] getBeforeGetSleepTimerInferiors() {
        return this.beforeGetSleepTimerInferiors;
    }
    
    public String[] getOverrideGetSleepTimerSuperiors() {
        return this.overrideGetSleepTimerSuperiors;
    }
    
    public String[] getOverrideGetSleepTimerInferiors() {
        return this.overrideGetSleepTimerInferiors;
    }
    
    public String[] getAfterGetSleepTimerSuperiors() {
        return this.afterGetSleepTimerSuperiors;
    }
    
    public String[] getAfterGetSleepTimerInferiors() {
        return this.afterGetSleepTimerInferiors;
    }
    
    public void setBeforeGetSleepTimerSuperiors(final String[] var1) {
        this.beforeGetSleepTimerSuperiors = var1;
    }
    
    public void setBeforeGetSleepTimerInferiors(final String[] var1) {
        this.beforeGetSleepTimerInferiors = var1;
    }
    
    public void setOverrideGetSleepTimerSuperiors(final String[] var1) {
        this.overrideGetSleepTimerSuperiors = var1;
    }
    
    public void setOverrideGetSleepTimerInferiors(final String[] var1) {
        this.overrideGetSleepTimerInferiors = var1;
    }
    
    public void setAfterGetSleepTimerSuperiors(final String[] var1) {
        this.afterGetSleepTimerSuperiors = var1;
    }
    
    public void setAfterGetSleepTimerInferiors(final String[] var1) {
        this.afterGetSleepTimerInferiors = var1;
    }
    
    public String[] getBeforeGetSpeedModifierSuperiors() {
        return this.beforeGetSpeedModifierSuperiors;
    }
    
    public String[] getBeforeGetSpeedModifierInferiors() {
        return this.beforeGetSpeedModifierInferiors;
    }
    
    public String[] getOverrideGetSpeedModifierSuperiors() {
        return this.overrideGetSpeedModifierSuperiors;
    }
    
    public String[] getOverrideGetSpeedModifierInferiors() {
        return this.overrideGetSpeedModifierInferiors;
    }
    
    public String[] getAfterGetSpeedModifierSuperiors() {
        return this.afterGetSpeedModifierSuperiors;
    }
    
    public String[] getAfterGetSpeedModifierInferiors() {
        return this.afterGetSpeedModifierInferiors;
    }
    
    public void setBeforeGetSpeedModifierSuperiors(final String[] var1) {
        this.beforeGetSpeedModifierSuperiors = var1;
    }
    
    public void setBeforeGetSpeedModifierInferiors(final String[] var1) {
        this.beforeGetSpeedModifierInferiors = var1;
    }
    
    public void setOverrideGetSpeedModifierSuperiors(final String[] var1) {
        this.overrideGetSpeedModifierSuperiors = var1;
    }
    
    public void setOverrideGetSpeedModifierInferiors(final String[] var1) {
        this.overrideGetSpeedModifierInferiors = var1;
    }
    
    public void setAfterGetSpeedModifierSuperiors(final String[] var1) {
        this.afterGetSpeedModifierSuperiors = var1;
    }
    
    public void setAfterGetSpeedModifierInferiors(final String[] var1) {
        this.afterGetSpeedModifierInferiors = var1;
    }
    
    public String[] getBeforeHandleLavaMovementSuperiors() {
        return this.beforeHandleLavaMovementSuperiors;
    }
    
    public String[] getBeforeHandleLavaMovementInferiors() {
        return this.beforeHandleLavaMovementInferiors;
    }
    
    public String[] getOverrideHandleLavaMovementSuperiors() {
        return this.overrideHandleLavaMovementSuperiors;
    }
    
    public String[] getOverrideHandleLavaMovementInferiors() {
        return this.overrideHandleLavaMovementInferiors;
    }
    
    public String[] getAfterHandleLavaMovementSuperiors() {
        return this.afterHandleLavaMovementSuperiors;
    }
    
    public String[] getAfterHandleLavaMovementInferiors() {
        return this.afterHandleLavaMovementInferiors;
    }
    
    public void setBeforeHandleLavaMovementSuperiors(final String[] var1) {
        this.beforeHandleLavaMovementSuperiors = var1;
    }
    
    public void setBeforeHandleLavaMovementInferiors(final String[] var1) {
        this.beforeHandleLavaMovementInferiors = var1;
    }
    
    public void setOverrideHandleLavaMovementSuperiors(final String[] var1) {
        this.overrideHandleLavaMovementSuperiors = var1;
    }
    
    public void setOverrideHandleLavaMovementInferiors(final String[] var1) {
        this.overrideHandleLavaMovementInferiors = var1;
    }
    
    public void setAfterHandleLavaMovementSuperiors(final String[] var1) {
        this.afterHandleLavaMovementSuperiors = var1;
    }
    
    public void setAfterHandleLavaMovementInferiors(final String[] var1) {
        this.afterHandleLavaMovementInferiors = var1;
    }
    
    public String[] getBeforeHandleWaterMovementSuperiors() {
        return this.beforeHandleWaterMovementSuperiors;
    }
    
    public String[] getBeforeHandleWaterMovementInferiors() {
        return this.beforeHandleWaterMovementInferiors;
    }
    
    public String[] getOverrideHandleWaterMovementSuperiors() {
        return this.overrideHandleWaterMovementSuperiors;
    }
    
    public String[] getOverrideHandleWaterMovementInferiors() {
        return this.overrideHandleWaterMovementInferiors;
    }
    
    public String[] getAfterHandleWaterMovementSuperiors() {
        return this.afterHandleWaterMovementSuperiors;
    }
    
    public String[] getAfterHandleWaterMovementInferiors() {
        return this.afterHandleWaterMovementInferiors;
    }
    
    public void setBeforeHandleWaterMovementSuperiors(final String[] var1) {
        this.beforeHandleWaterMovementSuperiors = var1;
    }
    
    public void setBeforeHandleWaterMovementInferiors(final String[] var1) {
        this.beforeHandleWaterMovementInferiors = var1;
    }
    
    public void setOverrideHandleWaterMovementSuperiors(final String[] var1) {
        this.overrideHandleWaterMovementSuperiors = var1;
    }
    
    public void setOverrideHandleWaterMovementInferiors(final String[] var1) {
        this.overrideHandleWaterMovementInferiors = var1;
    }
    
    public void setAfterHandleWaterMovementSuperiors(final String[] var1) {
        this.afterHandleWaterMovementSuperiors = var1;
    }
    
    public void setAfterHandleWaterMovementInferiors(final String[] var1) {
        this.afterHandleWaterMovementInferiors = var1;
    }
    
    public String[] getBeforeHealSuperiors() {
        return this.beforeHealSuperiors;
    }
    
    public String[] getBeforeHealInferiors() {
        return this.beforeHealInferiors;
    }
    
    public String[] getOverrideHealSuperiors() {
        return this.overrideHealSuperiors;
    }
    
    public String[] getOverrideHealInferiors() {
        return this.overrideHealInferiors;
    }
    
    public String[] getAfterHealSuperiors() {
        return this.afterHealSuperiors;
    }
    
    public String[] getAfterHealInferiors() {
        return this.afterHealInferiors;
    }
    
    public void setBeforeHealSuperiors(final String[] var1) {
        this.beforeHealSuperiors = var1;
    }
    
    public void setBeforeHealInferiors(final String[] var1) {
        this.beforeHealInferiors = var1;
    }
    
    public void setOverrideHealSuperiors(final String[] var1) {
        this.overrideHealSuperiors = var1;
    }
    
    public void setOverrideHealInferiors(final String[] var1) {
        this.overrideHealInferiors = var1;
    }
    
    public void setAfterHealSuperiors(final String[] var1) {
        this.afterHealSuperiors = var1;
    }
    
    public void setAfterHealInferiors(final String[] var1) {
        this.afterHealInferiors = var1;
    }
    
    public String[] getBeforeIsEntityInsideOpaqueBlockSuperiors() {
        return this.beforeIsEntityInsideOpaqueBlockSuperiors;
    }
    
    public String[] getBeforeIsEntityInsideOpaqueBlockInferiors() {
        return this.beforeIsEntityInsideOpaqueBlockInferiors;
    }
    
    public String[] getOverrideIsEntityInsideOpaqueBlockSuperiors() {
        return this.overrideIsEntityInsideOpaqueBlockSuperiors;
    }
    
    public String[] getOverrideIsEntityInsideOpaqueBlockInferiors() {
        return this.overrideIsEntityInsideOpaqueBlockInferiors;
    }
    
    public String[] getAfterIsEntityInsideOpaqueBlockSuperiors() {
        return this.afterIsEntityInsideOpaqueBlockSuperiors;
    }
    
    public String[] getAfterIsEntityInsideOpaqueBlockInferiors() {
        return this.afterIsEntityInsideOpaqueBlockInferiors;
    }
    
    public void setBeforeIsEntityInsideOpaqueBlockSuperiors(final String[] var1) {
        this.beforeIsEntityInsideOpaqueBlockSuperiors = var1;
    }
    
    public void setBeforeIsEntityInsideOpaqueBlockInferiors(final String[] var1) {
        this.beforeIsEntityInsideOpaqueBlockInferiors = var1;
    }
    
    public void setOverrideIsEntityInsideOpaqueBlockSuperiors(final String[] var1) {
        this.overrideIsEntityInsideOpaqueBlockSuperiors = var1;
    }
    
    public void setOverrideIsEntityInsideOpaqueBlockInferiors(final String[] var1) {
        this.overrideIsEntityInsideOpaqueBlockInferiors = var1;
    }
    
    public void setAfterIsEntityInsideOpaqueBlockSuperiors(final String[] var1) {
        this.afterIsEntityInsideOpaqueBlockSuperiors = var1;
    }
    
    public void setAfterIsEntityInsideOpaqueBlockInferiors(final String[] var1) {
        this.afterIsEntityInsideOpaqueBlockInferiors = var1;
    }
    
    public String[] getBeforeIsInWaterSuperiors() {
        return this.beforeIsInWaterSuperiors;
    }
    
    public String[] getBeforeIsInWaterInferiors() {
        return this.beforeIsInWaterInferiors;
    }
    
    public String[] getOverrideIsInWaterSuperiors() {
        return this.overrideIsInWaterSuperiors;
    }
    
    public String[] getOverrideIsInWaterInferiors() {
        return this.overrideIsInWaterInferiors;
    }
    
    public String[] getAfterIsInWaterSuperiors() {
        return this.afterIsInWaterSuperiors;
    }
    
    public String[] getAfterIsInWaterInferiors() {
        return this.afterIsInWaterInferiors;
    }
    
    public void setBeforeIsInWaterSuperiors(final String[] var1) {
        this.beforeIsInWaterSuperiors = var1;
    }
    
    public void setBeforeIsInWaterInferiors(final String[] var1) {
        this.beforeIsInWaterInferiors = var1;
    }
    
    public void setOverrideIsInWaterSuperiors(final String[] var1) {
        this.overrideIsInWaterSuperiors = var1;
    }
    
    public void setOverrideIsInWaterInferiors(final String[] var1) {
        this.overrideIsInWaterInferiors = var1;
    }
    
    public void setAfterIsInWaterSuperiors(final String[] var1) {
        this.afterIsInWaterSuperiors = var1;
    }
    
    public void setAfterIsInWaterInferiors(final String[] var1) {
        this.afterIsInWaterInferiors = var1;
    }
    
    public String[] getBeforeIsInsideOfMaterialSuperiors() {
        return this.beforeIsInsideOfMaterialSuperiors;
    }
    
    public String[] getBeforeIsInsideOfMaterialInferiors() {
        return this.beforeIsInsideOfMaterialInferiors;
    }
    
    public String[] getOverrideIsInsideOfMaterialSuperiors() {
        return this.overrideIsInsideOfMaterialSuperiors;
    }
    
    public String[] getOverrideIsInsideOfMaterialInferiors() {
        return this.overrideIsInsideOfMaterialInferiors;
    }
    
    public String[] getAfterIsInsideOfMaterialSuperiors() {
        return this.afterIsInsideOfMaterialSuperiors;
    }
    
    public String[] getAfterIsInsideOfMaterialInferiors() {
        return this.afterIsInsideOfMaterialInferiors;
    }
    
    public void setBeforeIsInsideOfMaterialSuperiors(final String[] var1) {
        this.beforeIsInsideOfMaterialSuperiors = var1;
    }
    
    public void setBeforeIsInsideOfMaterialInferiors(final String[] var1) {
        this.beforeIsInsideOfMaterialInferiors = var1;
    }
    
    public void setOverrideIsInsideOfMaterialSuperiors(final String[] var1) {
        this.overrideIsInsideOfMaterialSuperiors = var1;
    }
    
    public void setOverrideIsInsideOfMaterialInferiors(final String[] var1) {
        this.overrideIsInsideOfMaterialInferiors = var1;
    }
    
    public void setAfterIsInsideOfMaterialSuperiors(final String[] var1) {
        this.afterIsInsideOfMaterialSuperiors = var1;
    }
    
    public void setAfterIsInsideOfMaterialInferiors(final String[] var1) {
        this.afterIsInsideOfMaterialInferiors = var1;
    }
    
    public String[] getBeforeIsOnLadderSuperiors() {
        return this.beforeIsOnLadderSuperiors;
    }
    
    public String[] getBeforeIsOnLadderInferiors() {
        return this.beforeIsOnLadderInferiors;
    }
    
    public String[] getOverrideIsOnLadderSuperiors() {
        return this.overrideIsOnLadderSuperiors;
    }
    
    public String[] getOverrideIsOnLadderInferiors() {
        return this.overrideIsOnLadderInferiors;
    }
    
    public String[] getAfterIsOnLadderSuperiors() {
        return this.afterIsOnLadderSuperiors;
    }
    
    public String[] getAfterIsOnLadderInferiors() {
        return this.afterIsOnLadderInferiors;
    }
    
    public void setBeforeIsOnLadderSuperiors(final String[] var1) {
        this.beforeIsOnLadderSuperiors = var1;
    }
    
    public void setBeforeIsOnLadderInferiors(final String[] var1) {
        this.beforeIsOnLadderInferiors = var1;
    }
    
    public void setOverrideIsOnLadderSuperiors(final String[] var1) {
        this.overrideIsOnLadderSuperiors = var1;
    }
    
    public void setOverrideIsOnLadderInferiors(final String[] var1) {
        this.overrideIsOnLadderInferiors = var1;
    }
    
    public void setAfterIsOnLadderSuperiors(final String[] var1) {
        this.afterIsOnLadderSuperiors = var1;
    }
    
    public void setAfterIsOnLadderInferiors(final String[] var1) {
        this.afterIsOnLadderInferiors = var1;
    }
    
    public String[] getBeforeIsSneakingSuperiors() {
        return this.beforeIsSneakingSuperiors;
    }
    
    public String[] getBeforeIsSneakingInferiors() {
        return this.beforeIsSneakingInferiors;
    }
    
    public String[] getOverrideIsSneakingSuperiors() {
        return this.overrideIsSneakingSuperiors;
    }
    
    public String[] getOverrideIsSneakingInferiors() {
        return this.overrideIsSneakingInferiors;
    }
    
    public String[] getAfterIsSneakingSuperiors() {
        return this.afterIsSneakingSuperiors;
    }
    
    public String[] getAfterIsSneakingInferiors() {
        return this.afterIsSneakingInferiors;
    }
    
    public void setBeforeIsSneakingSuperiors(final String[] var1) {
        this.beforeIsSneakingSuperiors = var1;
    }
    
    public void setBeforeIsSneakingInferiors(final String[] var1) {
        this.beforeIsSneakingInferiors = var1;
    }
    
    public void setOverrideIsSneakingSuperiors(final String[] var1) {
        this.overrideIsSneakingSuperiors = var1;
    }
    
    public void setOverrideIsSneakingInferiors(final String[] var1) {
        this.overrideIsSneakingInferiors = var1;
    }
    
    public void setAfterIsSneakingSuperiors(final String[] var1) {
        this.afterIsSneakingSuperiors = var1;
    }
    
    public void setAfterIsSneakingInferiors(final String[] var1) {
        this.afterIsSneakingInferiors = var1;
    }
    
    public String[] getBeforeIsSprintingSuperiors() {
        return this.beforeIsSprintingSuperiors;
    }
    
    public String[] getBeforeIsSprintingInferiors() {
        return this.beforeIsSprintingInferiors;
    }
    
    public String[] getOverrideIsSprintingSuperiors() {
        return this.overrideIsSprintingSuperiors;
    }
    
    public String[] getOverrideIsSprintingInferiors() {
        return this.overrideIsSprintingInferiors;
    }
    
    public String[] getAfterIsSprintingSuperiors() {
        return this.afterIsSprintingSuperiors;
    }
    
    public String[] getAfterIsSprintingInferiors() {
        return this.afterIsSprintingInferiors;
    }
    
    public void setBeforeIsSprintingSuperiors(final String[] var1) {
        this.beforeIsSprintingSuperiors = var1;
    }
    
    public void setBeforeIsSprintingInferiors(final String[] var1) {
        this.beforeIsSprintingInferiors = var1;
    }
    
    public void setOverrideIsSprintingSuperiors(final String[] var1) {
        this.overrideIsSprintingSuperiors = var1;
    }
    
    public void setOverrideIsSprintingInferiors(final String[] var1) {
        this.overrideIsSprintingInferiors = var1;
    }
    
    public void setAfterIsSprintingSuperiors(final String[] var1) {
        this.afterIsSprintingSuperiors = var1;
    }
    
    public void setAfterIsSprintingInferiors(final String[] var1) {
        this.afterIsSprintingInferiors = var1;
    }
    
    public String[] getBeforeJumpSuperiors() {
        return this.beforeJumpSuperiors;
    }
    
    public String[] getBeforeJumpInferiors() {
        return this.beforeJumpInferiors;
    }
    
    public String[] getOverrideJumpSuperiors() {
        return this.overrideJumpSuperiors;
    }
    
    public String[] getOverrideJumpInferiors() {
        return this.overrideJumpInferiors;
    }
    
    public String[] getAfterJumpSuperiors() {
        return this.afterJumpSuperiors;
    }
    
    public String[] getAfterJumpInferiors() {
        return this.afterJumpInferiors;
    }
    
    public void setBeforeJumpSuperiors(final String[] var1) {
        this.beforeJumpSuperiors = var1;
    }
    
    public void setBeforeJumpInferiors(final String[] var1) {
        this.beforeJumpInferiors = var1;
    }
    
    public void setOverrideJumpSuperiors(final String[] var1) {
        this.overrideJumpSuperiors = var1;
    }
    
    public void setOverrideJumpInferiors(final String[] var1) {
        this.overrideJumpInferiors = var1;
    }
    
    public void setAfterJumpSuperiors(final String[] var1) {
        this.afterJumpSuperiors = var1;
    }
    
    public void setAfterJumpInferiors(final String[] var1) {
        this.afterJumpInferiors = var1;
    }
    
    public String[] getBeforeKnockBackSuperiors() {
        return this.beforeKnockBackSuperiors;
    }
    
    public String[] getBeforeKnockBackInferiors() {
        return this.beforeKnockBackInferiors;
    }
    
    public String[] getOverrideKnockBackSuperiors() {
        return this.overrideKnockBackSuperiors;
    }
    
    public String[] getOverrideKnockBackInferiors() {
        return this.overrideKnockBackInferiors;
    }
    
    public String[] getAfterKnockBackSuperiors() {
        return this.afterKnockBackSuperiors;
    }
    
    public String[] getAfterKnockBackInferiors() {
        return this.afterKnockBackInferiors;
    }
    
    public void setBeforeKnockBackSuperiors(final String[] var1) {
        this.beforeKnockBackSuperiors = var1;
    }
    
    public void setBeforeKnockBackInferiors(final String[] var1) {
        this.beforeKnockBackInferiors = var1;
    }
    
    public void setOverrideKnockBackSuperiors(final String[] var1) {
        this.overrideKnockBackSuperiors = var1;
    }
    
    public void setOverrideKnockBackInferiors(final String[] var1) {
        this.overrideKnockBackInferiors = var1;
    }
    
    public void setAfterKnockBackSuperiors(final String[] var1) {
        this.afterKnockBackSuperiors = var1;
    }
    
    public void setAfterKnockBackInferiors(final String[] var1) {
        this.afterKnockBackInferiors = var1;
    }
    
    public String[] getBeforeMoveEntitySuperiors() {
        return this.beforeMoveEntitySuperiors;
    }
    
    public String[] getBeforeMoveEntityInferiors() {
        return this.beforeMoveEntityInferiors;
    }
    
    public String[] getOverrideMoveEntitySuperiors() {
        return this.overrideMoveEntitySuperiors;
    }
    
    public String[] getOverrideMoveEntityInferiors() {
        return this.overrideMoveEntityInferiors;
    }
    
    public String[] getAfterMoveEntitySuperiors() {
        return this.afterMoveEntitySuperiors;
    }
    
    public String[] getAfterMoveEntityInferiors() {
        return this.afterMoveEntityInferiors;
    }
    
    public void setBeforeMoveEntitySuperiors(final String[] var1) {
        this.beforeMoveEntitySuperiors = var1;
    }
    
    public void setBeforeMoveEntityInferiors(final String[] var1) {
        this.beforeMoveEntityInferiors = var1;
    }
    
    public void setOverrideMoveEntitySuperiors(final String[] var1) {
        this.overrideMoveEntitySuperiors = var1;
    }
    
    public void setOverrideMoveEntityInferiors(final String[] var1) {
        this.overrideMoveEntityInferiors = var1;
    }
    
    public void setAfterMoveEntitySuperiors(final String[] var1) {
        this.afterMoveEntitySuperiors = var1;
    }
    
    public void setAfterMoveEntityInferiors(final String[] var1) {
        this.afterMoveEntityInferiors = var1;
    }
    
    public String[] getBeforeMoveEntityWithHeadingSuperiors() {
        return this.beforeMoveEntityWithHeadingSuperiors;
    }
    
    public String[] getBeforeMoveEntityWithHeadingInferiors() {
        return this.beforeMoveEntityWithHeadingInferiors;
    }
    
    public String[] getOverrideMoveEntityWithHeadingSuperiors() {
        return this.overrideMoveEntityWithHeadingSuperiors;
    }
    
    public String[] getOverrideMoveEntityWithHeadingInferiors() {
        return this.overrideMoveEntityWithHeadingInferiors;
    }
    
    public String[] getAfterMoveEntityWithHeadingSuperiors() {
        return this.afterMoveEntityWithHeadingSuperiors;
    }
    
    public String[] getAfterMoveEntityWithHeadingInferiors() {
        return this.afterMoveEntityWithHeadingInferiors;
    }
    
    public void setBeforeMoveEntityWithHeadingSuperiors(final String[] var1) {
        this.beforeMoveEntityWithHeadingSuperiors = var1;
    }
    
    public void setBeforeMoveEntityWithHeadingInferiors(final String[] var1) {
        this.beforeMoveEntityWithHeadingInferiors = var1;
    }
    
    public void setOverrideMoveEntityWithHeadingSuperiors(final String[] var1) {
        this.overrideMoveEntityWithHeadingSuperiors = var1;
    }
    
    public void setOverrideMoveEntityWithHeadingInferiors(final String[] var1) {
        this.overrideMoveEntityWithHeadingInferiors = var1;
    }
    
    public void setAfterMoveEntityWithHeadingSuperiors(final String[] var1) {
        this.afterMoveEntityWithHeadingSuperiors = var1;
    }
    
    public void setAfterMoveEntityWithHeadingInferiors(final String[] var1) {
        this.afterMoveEntityWithHeadingInferiors = var1;
    }
    
    public String[] getBeforeMoveFlyingSuperiors() {
        return this.beforeMoveFlyingSuperiors;
    }
    
    public String[] getBeforeMoveFlyingInferiors() {
        return this.beforeMoveFlyingInferiors;
    }
    
    public String[] getOverrideMoveFlyingSuperiors() {
        return this.overrideMoveFlyingSuperiors;
    }
    
    public String[] getOverrideMoveFlyingInferiors() {
        return this.overrideMoveFlyingInferiors;
    }
    
    public String[] getAfterMoveFlyingSuperiors() {
        return this.afterMoveFlyingSuperiors;
    }
    
    public String[] getAfterMoveFlyingInferiors() {
        return this.afterMoveFlyingInferiors;
    }
    
    public void setBeforeMoveFlyingSuperiors(final String[] var1) {
        this.beforeMoveFlyingSuperiors = var1;
    }
    
    public void setBeforeMoveFlyingInferiors(final String[] var1) {
        this.beforeMoveFlyingInferiors = var1;
    }
    
    public void setOverrideMoveFlyingSuperiors(final String[] var1) {
        this.overrideMoveFlyingSuperiors = var1;
    }
    
    public void setOverrideMoveFlyingInferiors(final String[] var1) {
        this.overrideMoveFlyingInferiors = var1;
    }
    
    public void setAfterMoveFlyingSuperiors(final String[] var1) {
        this.afterMoveFlyingSuperiors = var1;
    }
    
    public void setAfterMoveFlyingInferiors(final String[] var1) {
        this.afterMoveFlyingInferiors = var1;
    }
    
    public String[] getBeforeOnDeathSuperiors() {
        return this.beforeOnDeathSuperiors;
    }
    
    public String[] getBeforeOnDeathInferiors() {
        return this.beforeOnDeathInferiors;
    }
    
    public String[] getOverrideOnDeathSuperiors() {
        return this.overrideOnDeathSuperiors;
    }
    
    public String[] getOverrideOnDeathInferiors() {
        return this.overrideOnDeathInferiors;
    }
    
    public String[] getAfterOnDeathSuperiors() {
        return this.afterOnDeathSuperiors;
    }
    
    public String[] getAfterOnDeathInferiors() {
        return this.afterOnDeathInferiors;
    }
    
    public void setBeforeOnDeathSuperiors(final String[] var1) {
        this.beforeOnDeathSuperiors = var1;
    }
    
    public void setBeforeOnDeathInferiors(final String[] var1) {
        this.beforeOnDeathInferiors = var1;
    }
    
    public void setOverrideOnDeathSuperiors(final String[] var1) {
        this.overrideOnDeathSuperiors = var1;
    }
    
    public void setOverrideOnDeathInferiors(final String[] var1) {
        this.overrideOnDeathInferiors = var1;
    }
    
    public void setAfterOnDeathSuperiors(final String[] var1) {
        this.afterOnDeathSuperiors = var1;
    }
    
    public void setAfterOnDeathInferiors(final String[] var1) {
        this.afterOnDeathInferiors = var1;
    }
    
    public String[] getBeforeOnLivingUpdateSuperiors() {
        return this.beforeOnLivingUpdateSuperiors;
    }
    
    public String[] getBeforeOnLivingUpdateInferiors() {
        return this.beforeOnLivingUpdateInferiors;
    }
    
    public String[] getOverrideOnLivingUpdateSuperiors() {
        return this.overrideOnLivingUpdateSuperiors;
    }
    
    public String[] getOverrideOnLivingUpdateInferiors() {
        return this.overrideOnLivingUpdateInferiors;
    }
    
    public String[] getAfterOnLivingUpdateSuperiors() {
        return this.afterOnLivingUpdateSuperiors;
    }
    
    public String[] getAfterOnLivingUpdateInferiors() {
        return this.afterOnLivingUpdateInferiors;
    }
    
    public void setBeforeOnLivingUpdateSuperiors(final String[] var1) {
        this.beforeOnLivingUpdateSuperiors = var1;
    }
    
    public void setBeforeOnLivingUpdateInferiors(final String[] var1) {
        this.beforeOnLivingUpdateInferiors = var1;
    }
    
    public void setOverrideOnLivingUpdateSuperiors(final String[] var1) {
        this.overrideOnLivingUpdateSuperiors = var1;
    }
    
    public void setOverrideOnLivingUpdateInferiors(final String[] var1) {
        this.overrideOnLivingUpdateInferiors = var1;
    }
    
    public void setAfterOnLivingUpdateSuperiors(final String[] var1) {
        this.afterOnLivingUpdateSuperiors = var1;
    }
    
    public void setAfterOnLivingUpdateInferiors(final String[] var1) {
        this.afterOnLivingUpdateInferiors = var1;
    }
    
    public String[] getBeforeOnKillEntitySuperiors() {
        return this.beforeOnKillEntitySuperiors;
    }
    
    public String[] getBeforeOnKillEntityInferiors() {
        return this.beforeOnKillEntityInferiors;
    }
    
    public String[] getOverrideOnKillEntitySuperiors() {
        return this.overrideOnKillEntitySuperiors;
    }
    
    public String[] getOverrideOnKillEntityInferiors() {
        return this.overrideOnKillEntityInferiors;
    }
    
    public String[] getAfterOnKillEntitySuperiors() {
        return this.afterOnKillEntitySuperiors;
    }
    
    public String[] getAfterOnKillEntityInferiors() {
        return this.afterOnKillEntityInferiors;
    }
    
    public void setBeforeOnKillEntitySuperiors(final String[] var1) {
        this.beforeOnKillEntitySuperiors = var1;
    }
    
    public void setBeforeOnKillEntityInferiors(final String[] var1) {
        this.beforeOnKillEntityInferiors = var1;
    }
    
    public void setOverrideOnKillEntitySuperiors(final String[] var1) {
        this.overrideOnKillEntitySuperiors = var1;
    }
    
    public void setOverrideOnKillEntityInferiors(final String[] var1) {
        this.overrideOnKillEntityInferiors = var1;
    }
    
    public void setAfterOnKillEntitySuperiors(final String[] var1) {
        this.afterOnKillEntitySuperiors = var1;
    }
    
    public void setAfterOnKillEntityInferiors(final String[] var1) {
        this.afterOnKillEntityInferiors = var1;
    }
    
    public String[] getBeforeOnUpdateSuperiors() {
        return this.beforeOnUpdateSuperiors;
    }
    
    public String[] getBeforeOnUpdateInferiors() {
        return this.beforeOnUpdateInferiors;
    }
    
    public String[] getOverrideOnUpdateSuperiors() {
        return this.overrideOnUpdateSuperiors;
    }
    
    public String[] getOverrideOnUpdateInferiors() {
        return this.overrideOnUpdateInferiors;
    }
    
    public String[] getAfterOnUpdateSuperiors() {
        return this.afterOnUpdateSuperiors;
    }
    
    public String[] getAfterOnUpdateInferiors() {
        return this.afterOnUpdateInferiors;
    }
    
    public void setBeforeOnUpdateSuperiors(final String[] var1) {
        this.beforeOnUpdateSuperiors = var1;
    }
    
    public void setBeforeOnUpdateInferiors(final String[] var1) {
        this.beforeOnUpdateInferiors = var1;
    }
    
    public void setOverrideOnUpdateSuperiors(final String[] var1) {
        this.overrideOnUpdateSuperiors = var1;
    }
    
    public void setOverrideOnUpdateInferiors(final String[] var1) {
        this.overrideOnUpdateInferiors = var1;
    }
    
    public void setAfterOnUpdateSuperiors(final String[] var1) {
        this.afterOnUpdateSuperiors = var1;
    }
    
    public void setAfterOnUpdateInferiors(final String[] var1) {
        this.afterOnUpdateInferiors = var1;
    }
    
    public String[] getBeforePlayStepSoundSuperiors() {
        return this.beforePlayStepSoundSuperiors;
    }
    
    public String[] getBeforePlayStepSoundInferiors() {
        return this.beforePlayStepSoundInferiors;
    }
    
    public String[] getOverridePlayStepSoundSuperiors() {
        return this.overridePlayStepSoundSuperiors;
    }
    
    public String[] getOverridePlayStepSoundInferiors() {
        return this.overridePlayStepSoundInferiors;
    }
    
    public String[] getAfterPlayStepSoundSuperiors() {
        return this.afterPlayStepSoundSuperiors;
    }
    
    public String[] getAfterPlayStepSoundInferiors() {
        return this.afterPlayStepSoundInferiors;
    }
    
    public void setBeforePlayStepSoundSuperiors(final String[] var1) {
        this.beforePlayStepSoundSuperiors = var1;
    }
    
    public void setBeforePlayStepSoundInferiors(final String[] var1) {
        this.beforePlayStepSoundInferiors = var1;
    }
    
    public void setOverridePlayStepSoundSuperiors(final String[] var1) {
        this.overridePlayStepSoundSuperiors = var1;
    }
    
    public void setOverridePlayStepSoundInferiors(final String[] var1) {
        this.overridePlayStepSoundInferiors = var1;
    }
    
    public void setAfterPlayStepSoundSuperiors(final String[] var1) {
        this.afterPlayStepSoundSuperiors = var1;
    }
    
    public void setAfterPlayStepSoundInferiors(final String[] var1) {
        this.afterPlayStepSoundInferiors = var1;
    }
    
    public String[] getBeforePushOutOfBlocksSuperiors() {
        return this.beforePushOutOfBlocksSuperiors;
    }
    
    public String[] getBeforePushOutOfBlocksInferiors() {
        return this.beforePushOutOfBlocksInferiors;
    }
    
    public String[] getOverridePushOutOfBlocksSuperiors() {
        return this.overridePushOutOfBlocksSuperiors;
    }
    
    public String[] getOverridePushOutOfBlocksInferiors() {
        return this.overridePushOutOfBlocksInferiors;
    }
    
    public String[] getAfterPushOutOfBlocksSuperiors() {
        return this.afterPushOutOfBlocksSuperiors;
    }
    
    public String[] getAfterPushOutOfBlocksInferiors() {
        return this.afterPushOutOfBlocksInferiors;
    }
    
    public void setBeforePushOutOfBlocksSuperiors(final String[] var1) {
        this.beforePushOutOfBlocksSuperiors = var1;
    }
    
    public void setBeforePushOutOfBlocksInferiors(final String[] var1) {
        this.beforePushOutOfBlocksInferiors = var1;
    }
    
    public void setOverridePushOutOfBlocksSuperiors(final String[] var1) {
        this.overridePushOutOfBlocksSuperiors = var1;
    }
    
    public void setOverridePushOutOfBlocksInferiors(final String[] var1) {
        this.overridePushOutOfBlocksInferiors = var1;
    }
    
    public void setAfterPushOutOfBlocksSuperiors(final String[] var1) {
        this.afterPushOutOfBlocksSuperiors = var1;
    }
    
    public void setAfterPushOutOfBlocksInferiors(final String[] var1) {
        this.afterPushOutOfBlocksInferiors = var1;
    }
    
    public String[] getBeforeRayTraceSuperiors() {
        return this.beforeRayTraceSuperiors;
    }
    
    public String[] getBeforeRayTraceInferiors() {
        return this.beforeRayTraceInferiors;
    }
    
    public String[] getOverrideRayTraceSuperiors() {
        return this.overrideRayTraceSuperiors;
    }
    
    public String[] getOverrideRayTraceInferiors() {
        return this.overrideRayTraceInferiors;
    }
    
    public String[] getAfterRayTraceSuperiors() {
        return this.afterRayTraceSuperiors;
    }
    
    public String[] getAfterRayTraceInferiors() {
        return this.afterRayTraceInferiors;
    }
    
    public void setBeforeRayTraceSuperiors(final String[] var1) {
        this.beforeRayTraceSuperiors = var1;
    }
    
    public void setBeforeRayTraceInferiors(final String[] var1) {
        this.beforeRayTraceInferiors = var1;
    }
    
    public void setOverrideRayTraceSuperiors(final String[] var1) {
        this.overrideRayTraceSuperiors = var1;
    }
    
    public void setOverrideRayTraceInferiors(final String[] var1) {
        this.overrideRayTraceInferiors = var1;
    }
    
    public void setAfterRayTraceSuperiors(final String[] var1) {
        this.afterRayTraceSuperiors = var1;
    }
    
    public void setAfterRayTraceInferiors(final String[] var1) {
        this.afterRayTraceInferiors = var1;
    }
    
    public String[] getBeforeReadEntityFromNBTSuperiors() {
        return this.beforeReadEntityFromNBTSuperiors;
    }
    
    public String[] getBeforeReadEntityFromNBTInferiors() {
        return this.beforeReadEntityFromNBTInferiors;
    }
    
    public String[] getOverrideReadEntityFromNBTSuperiors() {
        return this.overrideReadEntityFromNBTSuperiors;
    }
    
    public String[] getOverrideReadEntityFromNBTInferiors() {
        return this.overrideReadEntityFromNBTInferiors;
    }
    
    public String[] getAfterReadEntityFromNBTSuperiors() {
        return this.afterReadEntityFromNBTSuperiors;
    }
    
    public String[] getAfterReadEntityFromNBTInferiors() {
        return this.afterReadEntityFromNBTInferiors;
    }
    
    public void setBeforeReadEntityFromNBTSuperiors(final String[] var1) {
        this.beforeReadEntityFromNBTSuperiors = var1;
    }
    
    public void setBeforeReadEntityFromNBTInferiors(final String[] var1) {
        this.beforeReadEntityFromNBTInferiors = var1;
    }
    
    public void setOverrideReadEntityFromNBTSuperiors(final String[] var1) {
        this.overrideReadEntityFromNBTSuperiors = var1;
    }
    
    public void setOverrideReadEntityFromNBTInferiors(final String[] var1) {
        this.overrideReadEntityFromNBTInferiors = var1;
    }
    
    public void setAfterReadEntityFromNBTSuperiors(final String[] var1) {
        this.afterReadEntityFromNBTSuperiors = var1;
    }
    
    public void setAfterReadEntityFromNBTInferiors(final String[] var1) {
        this.afterReadEntityFromNBTInferiors = var1;
    }
    
    public String[] getBeforeRespawnPlayerSuperiors() {
        return this.beforeRespawnPlayerSuperiors;
    }
    
    public String[] getBeforeRespawnPlayerInferiors() {
        return this.beforeRespawnPlayerInferiors;
    }
    
    public String[] getOverrideRespawnPlayerSuperiors() {
        return this.overrideRespawnPlayerSuperiors;
    }
    
    public String[] getOverrideRespawnPlayerInferiors() {
        return this.overrideRespawnPlayerInferiors;
    }
    
    public String[] getAfterRespawnPlayerSuperiors() {
        return this.afterRespawnPlayerSuperiors;
    }
    
    public String[] getAfterRespawnPlayerInferiors() {
        return this.afterRespawnPlayerInferiors;
    }
    
    public void setBeforeRespawnPlayerSuperiors(final String[] var1) {
        this.beforeRespawnPlayerSuperiors = var1;
    }
    
    public void setBeforeRespawnPlayerInferiors(final String[] var1) {
        this.beforeRespawnPlayerInferiors = var1;
    }
    
    public void setOverrideRespawnPlayerSuperiors(final String[] var1) {
        this.overrideRespawnPlayerSuperiors = var1;
    }
    
    public void setOverrideRespawnPlayerInferiors(final String[] var1) {
        this.overrideRespawnPlayerInferiors = var1;
    }
    
    public void setAfterRespawnPlayerSuperiors(final String[] var1) {
        this.afterRespawnPlayerSuperiors = var1;
    }
    
    public void setAfterRespawnPlayerInferiors(final String[] var1) {
        this.afterRespawnPlayerInferiors = var1;
    }
    
    public String[] getBeforeSendChatMessageSuperiors() {
        return this.beforeSendChatMessageSuperiors;
    }
    
    public String[] getBeforeSendChatMessageInferiors() {
        return this.beforeSendChatMessageInferiors;
    }
    
    public String[] getOverrideSendChatMessageSuperiors() {
        return this.overrideSendChatMessageSuperiors;
    }
    
    public String[] getOverrideSendChatMessageInferiors() {
        return this.overrideSendChatMessageInferiors;
    }
    
    public String[] getAfterSendChatMessageSuperiors() {
        return this.afterSendChatMessageSuperiors;
    }
    
    public String[] getAfterSendChatMessageInferiors() {
        return this.afterSendChatMessageInferiors;
    }
    
    public void setBeforeSendChatMessageSuperiors(final String[] var1) {
        this.beforeSendChatMessageSuperiors = var1;
    }
    
    public void setBeforeSendChatMessageInferiors(final String[] var1) {
        this.beforeSendChatMessageInferiors = var1;
    }
    
    public void setOverrideSendChatMessageSuperiors(final String[] var1) {
        this.overrideSendChatMessageSuperiors = var1;
    }
    
    public void setOverrideSendChatMessageInferiors(final String[] var1) {
        this.overrideSendChatMessageInferiors = var1;
    }
    
    public void setAfterSendChatMessageSuperiors(final String[] var1) {
        this.afterSendChatMessageSuperiors = var1;
    }
    
    public void setAfterSendChatMessageInferiors(final String[] var1) {
        this.afterSendChatMessageInferiors = var1;
    }
    
    public String[] getBeforeSetDeadSuperiors() {
        return this.beforeSetDeadSuperiors;
    }
    
    public String[] getBeforeSetDeadInferiors() {
        return this.beforeSetDeadInferiors;
    }
    
    public String[] getOverrideSetDeadSuperiors() {
        return this.overrideSetDeadSuperiors;
    }
    
    public String[] getOverrideSetDeadInferiors() {
        return this.overrideSetDeadInferiors;
    }
    
    public String[] getAfterSetDeadSuperiors() {
        return this.afterSetDeadSuperiors;
    }
    
    public String[] getAfterSetDeadInferiors() {
        return this.afterSetDeadInferiors;
    }
    
    public void setBeforeSetDeadSuperiors(final String[] var1) {
        this.beforeSetDeadSuperiors = var1;
    }
    
    public void setBeforeSetDeadInferiors(final String[] var1) {
        this.beforeSetDeadInferiors = var1;
    }
    
    public void setOverrideSetDeadSuperiors(final String[] var1) {
        this.overrideSetDeadSuperiors = var1;
    }
    
    public void setOverrideSetDeadInferiors(final String[] var1) {
        this.overrideSetDeadInferiors = var1;
    }
    
    public void setAfterSetDeadSuperiors(final String[] var1) {
        this.afterSetDeadSuperiors = var1;
    }
    
    public void setAfterSetDeadInferiors(final String[] var1) {
        this.afterSetDeadInferiors = var1;
    }
    
    public String[] getBeforeSetPositionAndRotationSuperiors() {
        return this.beforeSetPositionAndRotationSuperiors;
    }
    
    public String[] getBeforeSetPositionAndRotationInferiors() {
        return this.beforeSetPositionAndRotationInferiors;
    }
    
    public String[] getOverrideSetPositionAndRotationSuperiors() {
        return this.overrideSetPositionAndRotationSuperiors;
    }
    
    public String[] getOverrideSetPositionAndRotationInferiors() {
        return this.overrideSetPositionAndRotationInferiors;
    }
    
    public String[] getAfterSetPositionAndRotationSuperiors() {
        return this.afterSetPositionAndRotationSuperiors;
    }
    
    public String[] getAfterSetPositionAndRotationInferiors() {
        return this.afterSetPositionAndRotationInferiors;
    }
    
    public void setBeforeSetPositionAndRotationSuperiors(final String[] var1) {
        this.beforeSetPositionAndRotationSuperiors = var1;
    }
    
    public void setBeforeSetPositionAndRotationInferiors(final String[] var1) {
        this.beforeSetPositionAndRotationInferiors = var1;
    }
    
    public void setOverrideSetPositionAndRotationSuperiors(final String[] var1) {
        this.overrideSetPositionAndRotationSuperiors = var1;
    }
    
    public void setOverrideSetPositionAndRotationInferiors(final String[] var1) {
        this.overrideSetPositionAndRotationInferiors = var1;
    }
    
    public void setAfterSetPositionAndRotationSuperiors(final String[] var1) {
        this.afterSetPositionAndRotationSuperiors = var1;
    }
    
    public void setAfterSetPositionAndRotationInferiors(final String[] var1) {
        this.afterSetPositionAndRotationInferiors = var1;
    }
    
    public String[] getBeforeSleepInBedAtSuperiors() {
        return this.beforeSleepInBedAtSuperiors;
    }
    
    public String[] getBeforeSleepInBedAtInferiors() {
        return this.beforeSleepInBedAtInferiors;
    }
    
    public String[] getOverrideSleepInBedAtSuperiors() {
        return this.overrideSleepInBedAtSuperiors;
    }
    
    public String[] getOverrideSleepInBedAtInferiors() {
        return this.overrideSleepInBedAtInferiors;
    }
    
    public String[] getAfterSleepInBedAtSuperiors() {
        return this.afterSleepInBedAtSuperiors;
    }
    
    public String[] getAfterSleepInBedAtInferiors() {
        return this.afterSleepInBedAtInferiors;
    }
    
    public void setBeforeSleepInBedAtSuperiors(final String[] var1) {
        this.beforeSleepInBedAtSuperiors = var1;
    }
    
    public void setBeforeSleepInBedAtInferiors(final String[] var1) {
        this.beforeSleepInBedAtInferiors = var1;
    }
    
    public void setOverrideSleepInBedAtSuperiors(final String[] var1) {
        this.overrideSleepInBedAtSuperiors = var1;
    }
    
    public void setOverrideSleepInBedAtInferiors(final String[] var1) {
        this.overrideSleepInBedAtInferiors = var1;
    }
    
    public void setAfterSleepInBedAtSuperiors(final String[] var1) {
        this.afterSleepInBedAtSuperiors = var1;
    }
    
    public void setAfterSleepInBedAtInferiors(final String[] var1) {
        this.afterSleepInBedAtInferiors = var1;
    }
    
    public String[] getBeforeSwingItemSuperiors() {
        return this.beforeSwingItemSuperiors;
    }
    
    public String[] getBeforeSwingItemInferiors() {
        return this.beforeSwingItemInferiors;
    }
    
    public String[] getOverrideSwingItemSuperiors() {
        return this.overrideSwingItemSuperiors;
    }
    
    public String[] getOverrideSwingItemInferiors() {
        return this.overrideSwingItemInferiors;
    }
    
    public String[] getAfterSwingItemSuperiors() {
        return this.afterSwingItemSuperiors;
    }
    
    public String[] getAfterSwingItemInferiors() {
        return this.afterSwingItemInferiors;
    }
    
    public void setBeforeSwingItemSuperiors(final String[] var1) {
        this.beforeSwingItemSuperiors = var1;
    }
    
    public void setBeforeSwingItemInferiors(final String[] var1) {
        this.beforeSwingItemInferiors = var1;
    }
    
    public void setOverrideSwingItemSuperiors(final String[] var1) {
        this.overrideSwingItemSuperiors = var1;
    }
    
    public void setOverrideSwingItemInferiors(final String[] var1) {
        this.overrideSwingItemInferiors = var1;
    }
    
    public void setAfterSwingItemSuperiors(final String[] var1) {
        this.afterSwingItemSuperiors = var1;
    }
    
    public void setAfterSwingItemInferiors(final String[] var1) {
        this.afterSwingItemInferiors = var1;
    }
    
    public String[] getBeforeUpdateEntityActionStateSuperiors() {
        return this.beforeUpdateEntityActionStateSuperiors;
    }
    
    public String[] getBeforeUpdateEntityActionStateInferiors() {
        return this.beforeUpdateEntityActionStateInferiors;
    }
    
    public String[] getOverrideUpdateEntityActionStateSuperiors() {
        return this.overrideUpdateEntityActionStateSuperiors;
    }
    
    public String[] getOverrideUpdateEntityActionStateInferiors() {
        return this.overrideUpdateEntityActionStateInferiors;
    }
    
    public String[] getAfterUpdateEntityActionStateSuperiors() {
        return this.afterUpdateEntityActionStateSuperiors;
    }
    
    public String[] getAfterUpdateEntityActionStateInferiors() {
        return this.afterUpdateEntityActionStateInferiors;
    }
    
    public void setBeforeUpdateEntityActionStateSuperiors(final String[] var1) {
        this.beforeUpdateEntityActionStateSuperiors = var1;
    }
    
    public void setBeforeUpdateEntityActionStateInferiors(final String[] var1) {
        this.beforeUpdateEntityActionStateInferiors = var1;
    }
    
    public void setOverrideUpdateEntityActionStateSuperiors(final String[] var1) {
        this.overrideUpdateEntityActionStateSuperiors = var1;
    }
    
    public void setOverrideUpdateEntityActionStateInferiors(final String[] var1) {
        this.overrideUpdateEntityActionStateInferiors = var1;
    }
    
    public void setAfterUpdateEntityActionStateSuperiors(final String[] var1) {
        this.afterUpdateEntityActionStateSuperiors = var1;
    }
    
    public void setAfterUpdateEntityActionStateInferiors(final String[] var1) {
        this.afterUpdateEntityActionStateInferiors = var1;
    }
    
    public String[] getBeforeWriteEntityToNBTSuperiors() {
        return this.beforeWriteEntityToNBTSuperiors;
    }
    
    public String[] getBeforeWriteEntityToNBTInferiors() {
        return this.beforeWriteEntityToNBTInferiors;
    }
    
    public String[] getOverrideWriteEntityToNBTSuperiors() {
        return this.overrideWriteEntityToNBTSuperiors;
    }
    
    public String[] getOverrideWriteEntityToNBTInferiors() {
        return this.overrideWriteEntityToNBTInferiors;
    }
    
    public String[] getAfterWriteEntityToNBTSuperiors() {
        return this.afterWriteEntityToNBTSuperiors;
    }
    
    public String[] getAfterWriteEntityToNBTInferiors() {
        return this.afterWriteEntityToNBTInferiors;
    }
    
    public void setBeforeWriteEntityToNBTSuperiors(final String[] var1) {
        this.beforeWriteEntityToNBTSuperiors = var1;
    }
    
    public void setBeforeWriteEntityToNBTInferiors(final String[] var1) {
        this.beforeWriteEntityToNBTInferiors = var1;
    }
    
    public void setOverrideWriteEntityToNBTSuperiors(final String[] var1) {
        this.overrideWriteEntityToNBTSuperiors = var1;
    }
    
    public void setOverrideWriteEntityToNBTInferiors(final String[] var1) {
        this.overrideWriteEntityToNBTInferiors = var1;
    }
    
    public void setAfterWriteEntityToNBTSuperiors(final String[] var1) {
        this.afterWriteEntityToNBTSuperiors = var1;
    }
    
    public void setAfterWriteEntityToNBTInferiors(final String[] var1) {
        this.afterWriteEntityToNBTInferiors = var1;
    }
}
