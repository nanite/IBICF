package com.unrealdinnerbone.ibicf;

public class IBICF {
    public static final String MOD_ID = "ibicf";

    public static void init() {
        //Load config on mod startup not on first render
        IBICFConfig.CONFIG.get();
    }

}