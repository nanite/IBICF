package com.example.ibicf.mixin;

import com.example.ibicf.IBICF;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionSpecialEffects.class)
public class ExampleMixin {
    @Shadow @Final private float cloudLevel;

    @Inject(at = @At("HEAD"), method = "getCloudHeight()F", cancellable = true)
    private void init(CallbackInfoReturnable<Float> info) {
        if(!Float.isNaN(cloudLevel) && IBICF.cloud != null) {
            info.setReturnValue(IBICF.cloud.get().floatValue());
        }
    }

}
