package com.aiduels.ai;

public class CombatState {
    private final double distance;
    private final boolean targetMoving;
    private final float playerHealth;
    private final float targetHealth;
    private boolean wasHitSuccessful;

    public CombatState(double distance, boolean targetMoving, float playerHealth, float targetHealth) {
        this.distance = distance;
        this.targetMoving = targetMoving;
        this.playerHealth = playerHealth;
        this.targetHealth = targetHealth;
    }

    public boolean wasHitSuccessful() {
        return wasHitSuccessful;
    }
}
