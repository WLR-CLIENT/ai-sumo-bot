package com.aiduels;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import com.aiduels.ai.CombatAI;
import com.aiduels.combat.CombatHandler;

@Mod(modid = "aicombat", version = "1.0")
public class AICombatMod {
    public static final AtomicBoolean learningMode = new AtomicBoolean(false);
    public static final CombatAI combatAI = new CombatAI();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CombatHandler());
    }
}
