package com.unrealdinnerbone.ibicf.mixin;

import com.unrealdinnerbone.ibicf.IBICF;
import net.minecraft.client.world.DimensionRenderInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionRenderInfo.class)
public class DimensionRenderInfoMixin {
    @Shadow @Final private float cloudLevel;

    @Inject(at = @At("HEAD"), method = "getCloudHeight()F", cancellable = true)
    private void init(CallbackInfoReturnable<Float> info) {
        if(!Float.isNaN(cloudLevel) && IBICF.cloud != null) {
            info.setReturnValue(IBICF.cloud.get().floatValue());
        }
    }

}
