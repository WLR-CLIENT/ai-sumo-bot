package com.aiduels.combat;

import com.aiduels.AICombatMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class CombatHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKey() == Keyboard.KEY_SEMICOLON && Keyboard.getEventKeyState()) {
            AICombatMod.learningMode.set(!AICombatMod.learningMode.get());
            Minecraft.getMinecraft().thePlayer.addChatMessage(
                    new ChatComponentText("§aLearning mode: " +
                            (AICombatMod.learningMode.get() ? "ON" : "OFF"))
            );
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (!AICombatMod.learningMode.get()) return;

        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        EntityPlayer target = CombatUtils.findNearestTarget(player);
        if (target != null) {
            CombatUtils.handleCombat(player, target);
        }
    }
}
