package com.example.ibicf;

import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ibicf")
public class IBICF {

    private static final Logger LOGGER = LogManager.getLogger();
    public static ForgeConfigSpec.DoubleValue cloud = null;

    public IBICF() {
        ForgeConfigSpec.Builder forgeConfigSpec = new ForgeConfigSpec.Builder();
        cloud = forgeConfigSpec.defineInRange("cloudLevel", 200.0, 0.0, 256.0);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, forgeConfigSpec.build());
        MinecraftForge.EVENT_BUS.addListener(this::onClickTick);
    }

    public void onClickTick(TickEvent.ClientTickEvent event) {
        if(runs++ >= 100) {
            System.out.println("CASD");
            runs = 0;
            ColorHandlers.tick();
        }
    }

    private static int runs = 0;

    public static Vec3 get() {
        return ColorHandlers.getColor();
    }

}
