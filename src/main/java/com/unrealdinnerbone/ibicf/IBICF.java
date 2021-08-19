package com.unrealdinnerbone.ibicf;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ibicf")
public class IBICF {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final ForgeConfigSpec.Builder SPEC = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.DoubleValue cloud;

    static {
        cloud = SPEC.defineInRange("cloudLevel", 200.0, 0.0, 256.0);;
    }

    public IBICF() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SPEC.build());
    }

}
