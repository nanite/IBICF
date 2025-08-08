package com.unrealdinnerbone.ibicf;

import com.google.common.base.Suppliers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.unrealdinnerbone.trenzalore.api.platform.Services;
import org.slf4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;


public record IBICFConfig(float cloudLevel, boolean renderClouds) {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();

    private static Codec<IBICFConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("cloudLevel").forGetter(IBICFConfig::cloudLevel),
            Codec.BOOL.fieldOf("renderClouds").orElse(true).forGetter(IBICFConfig::renderClouds)
    ).apply(instance, IBICFConfig::new));

    public static Supplier<IBICFConfig> CONFIG = Suppliers.memoize(() -> getOrCreateCodecConfig(IBICF.MOD_ID, IBICFConfig.CODEC, () -> new IBICFConfig(128, true)));


    public static <T> T getOrCreateCodecConfig(String name, Codec<T> codec, Supplier<T> defaultValue) {
        Path configPath = Services.PLATFORM.getConfigPath();
        Path config = configPath.resolve(name + ".json");
        if (!Files.exists(config)) {
            T defaultConfig = defaultValue.get();

            save(codec, defaultConfig, config);

            return defaultConfig;
        } else {
            try {
                String jsonString = Files.readString(config);
                JsonElement parse = new JsonParser().parse(jsonString);
                DataResult<T> data = codec.parse(JsonOps.INSTANCE, parse);
                T orThrow = data.getOrThrow();
                save(codec, orThrow, config);
                return orThrow;
            } catch (Exception e) {
                LOGGER.error("Error loading config. Defaulting to default config", e);
                return defaultValue.get();
            }
        }
    }

    private static <T> void save(Codec<T> codec, T config, Path path) {
        try {
            DataResult<JsonElement> result = codec.encodeStart(JsonOps.INSTANCE, config);
            if (result.result().isPresent()) {
                if (!Files.exists(path.getParent())) {
                    Files.createDirectories(path.getParent());
                }
                Files.writeString(path, GSON.toJson(result.result().get()));
            } else {
                LOGGER.error("Failed to load config: {}", result.error().get());
            }
        } catch (Exception e) {
            LOGGER.error("Error saving config. Defaulting to default config", e);
        }
    }
}