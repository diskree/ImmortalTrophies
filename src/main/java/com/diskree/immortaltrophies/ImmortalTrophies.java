package com.diskree.immortaltrophies;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ImmortalTrophies implements ModInitializer {

    public static final Item TROPHY_ITEM = new TrophyItem();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier(BuildConfig.MOD_ID, "trophy"), TROPHY_ITEM);
    }
}
