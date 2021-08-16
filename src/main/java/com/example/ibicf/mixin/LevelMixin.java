package com.example.ibicf.mixin;

import com.example.ibicf.IBICF;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientLevel.class)
public class LevelMixin {

    @Inject(at = @At("HEAD"), method = "getCloudColor(F)Lnet/minecraft/world/phys/Vec3;", cancellable = true)
    private void init(float p_228328_1_, CallbackInfoReturnable<Vec3> info) {
        info.setReturnValue(IBICF.get());
    }

}
