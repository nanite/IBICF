package com.unrealdinnerbone.ibicf;

import net.fabricmc.api.ModInitializer;

public class IBICFFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        IBICF.init();
    }
}
