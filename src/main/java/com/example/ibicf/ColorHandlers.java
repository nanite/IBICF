package com.example.ibicf;

import net.minecraft.world.phys.Vec3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ColorHandlers
{
    private static final Vec3[] COLORS = doIt().toArray(new Vec3[0]);
    private static int number;

    private static List<Vec3> doIt() {
        List<Vec3> colors = new ArrayList<>();
        for (int r=0; r<100; r++) colors.add(new Vec3(r*255/100,       255,         0));
        for (int g=100; g>0; g--) colors.add(new Vec3(      255, g*255/100,         0));
        for (int b=0; b<100; b++) colors.add(new Vec3(      255,         0, b*255/100));
        for (int r=100; r>0; r--) colors.add(new Vec3(r*255/100,         0,       255));
        for (int g=0; g<100; g++) colors.add(new Vec3(        0, g*255/100,       255));
        for (int b=100; b>0; b--) colors.add(new Vec3(        0,       255, b*255/100));
        return colors;
    }


    public static Vec3 getColor() {
        return COLORS[number];
    }

    public static void tick() {
        if(number + 1 >= COLORS.length) {
            number = 0;
        }else {
            number++;
        }
    }

    public static void tick(int count) {
        IntStream.range(0, count).forEach(i -> tick());
    }
}
