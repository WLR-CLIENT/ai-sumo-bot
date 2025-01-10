package com.aiduels.ai;

import com.aiduels.combat.CombatUtils;
import net.minecraft.entity.player.EntityPlayer;
import java.util.LinkedList;

public class CombatAI {
    private final LinkedList<CombatState> recentStates = new LinkedList<CombatState>();

    public void learn(CombatState state) {
        recentStates.add(state);
        if (recentStates.size() > 100) {
            recentStates.removeFirst();
        }

        if (state.wasHitSuccessful()) {
            reinforcePattern(state);
        }
    }

    public CombatAction getBestAction(EntityPlayer player, EntityPlayer target) {
        CombatState currentState = new CombatState(
                player.getDistanceToEntity(target),
                CombatUtils.isMoving(target),
                player.getHealth(),
                target.getHealth()
        );

        return decideBestAction(currentState);
    }

    private void reinforcePattern(CombatState state) {
        // Implement pattern reinforcement logic
    }

    private CombatAction decideBestAction(CombatState state) {
        // Implement decision logic
        return CombatAction.ATTACK;
    }
}
