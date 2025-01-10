package com.aiduels.combat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class SumoAwareness {
    private static final double SUMO_PLATFORM_Y = 65.0;

    public static boolean isNearEdge(EntityPlayer player) {
        World world = player.worldObj;
        BlockPos pos = player.getPosition();

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos checkPos = pos.add(x, -1, z);
                if (world.isAirBlock(checkPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Vec3 getPlatformCenter() {
        return new Vec3(0, SUMO_PLATFORM_Y, 0);
    }
}
