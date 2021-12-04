package com.unrealdinnerbone.ibicf;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod("ibicf")
public class IBICF {

    private static final ForgeConfigSpec.Builder SPEC = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<Double> cloud;

    static {
        cloud = SPEC.define("cloudLevel", 200.0);;
    }

    public IBICF() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SPEC.build());
    }

}
