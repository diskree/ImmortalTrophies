package com.diskree.immortaltrophies;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class TrophyUtils {

    private static final String TROPHY_NBT_KEY = "Trophy";

    public static boolean isTrophy(ItemStack stack) {
        if (stack == null) {
            return false;
        }
        NbtCompound nbt = stack.getNbt();
        return nbt != null && nbt.getBoolean(TROPHY_NBT_KEY);
    }
}
