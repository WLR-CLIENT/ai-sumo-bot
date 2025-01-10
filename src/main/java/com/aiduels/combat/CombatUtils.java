package com.aiduels.combat;

import com.aiduels.AICombatMod;
import com.aiduels.ai.CombatAction;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;

import static com.aiduels.ai.CombatAction.SPRINT;
import static com.aiduels.ai.CombatAction.STRAFE;

public class CombatUtils {
    public static EntityPlayer findNearestTarget(EntityPlayer player) {
        double closestDistance = 6.0;
        EntityPlayer closest = null;

        List<EntityPlayer> players = Minecraft.getMinecraft().theWorld.playerEntities;
        for (EntityPlayer target : players) {
            if (target != player) {
                double distance = player.getDistanceToEntity(target);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closest = target;
                }
            }
        }
        return closest;
    }

    public static void handleCombat(EntityPlayer player, EntityPlayer target) {
        CombatAction action = AICombatMod.combatAI.getBestAction(player, target);

        switch (action) {
            case ATTACK:
                if (canAttack(player, target)) {
                    performAttack(player, target);
                }
                break;
            case STRAFE:
                performStrafe(player);
                break;
            case SPRINT:
                player.setSprinting(true);
                break;
        }
    }

    public static boolean isMoving(EntityPlayer entity) {
        return entity.moveForward != 0 || entity.moveStrafing != 0;
    }

    private static boolean canAttack(EntityPlayer player, EntityPlayer target) {
        return player.getDistanceToEntity(target) <= 4.0;
    }

    private static void performAttack(EntityPlayer player, EntityPlayer target) {
        Minecraft.getMinecraft().playerController.attackEntity(player, target);
    }

    private static void performStrafe(EntityPlayer player) {
        player.moveStrafing = (float) (Math.random() > 0.5 ? 1 : -1);
    }
}
