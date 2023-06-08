package com.unrealdinnerbone.ibicf;

import com.google.common.base.Suppliers;
import com.unrealdinnerbone.trenzalore.api.config.ConfigManger;

import java.util.function.Supplier;

public record IBICFConfig(float cloudLevel) {
    public static Supplier<IBICFConfig> CONFIG = Suppliers.memoize(() -> ConfigManger.getOrCreateConfig(IBICF.MOD_ID, IBICFConfig.class, () -> new IBICFConfig(128)));
}