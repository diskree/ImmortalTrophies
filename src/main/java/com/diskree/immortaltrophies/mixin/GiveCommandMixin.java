package com.diskree.immortaltrophies.mixin;

import com.diskree.immortaltrophies.ImmortalTrophies;
import net.minecraft.command.argument.ItemStackArgument;
import net.minecraft.registry.Registries;
import net.minecraft.server.command.GiveCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GiveCommand.class)
public class GiveCommandMixin {

    @ModifyVariable(method = "execute", at = @At("HEAD"), index = 1, argsOnly = true)
    private static ItemStackArgument overrideTrophy(ItemStackArgument originalValue) {
        if (originalValue != null && originalValue.nbt != null && originalValue.nbt.getBoolean("Trophy")) {
            originalValue.nbt.putString("real_id", Registries.ITEM.getId(originalValue.getItem()).toString());
            return new ItemStackArgument(ImmortalTrophies.TROPHY_ITEM.getRegistryEntry(), originalValue.nbt);
        }
        return originalValue;
    }
}
