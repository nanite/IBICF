package com.unrealdinnerbone.ibicf.forge;

import com.unrealdinnerbone.ibicf.IBICF;
import net.minecraftforge.fml.common.Mod;

@Mod(IBICF.MOD_ID)
public class IBICFForge {
    
    public IBICFForge() {
        IBICF.init();
    }
}