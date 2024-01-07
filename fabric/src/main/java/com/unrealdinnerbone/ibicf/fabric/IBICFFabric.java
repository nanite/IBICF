package com.unrealdinnerbone.ibicf.fabric;

import com.unrealdinnerbone.ibicf.IBICF;
import net.fabricmc.api.ModInitializer;

public class IBICFFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        IBICF.init();
    }
}
