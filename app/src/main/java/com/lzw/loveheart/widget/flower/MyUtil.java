package com.lzw.loveheart.widget.flower;

import android.graphics.Color;

/**
 * 工具类：主要是产生随机数、颜色等。
 */
public class MyUtil {

    public static float circle = (float) (2 * Math.PI);

    public static int rgba(int r, int g, int b, int a) {
        return Color.argb(a, r, g, b);
    }

    public static int randomInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    public static float random(float min, float max) {
        return (float) (Math.random() * (max - min) + min);
    }

    //产生随机的argb颜色
    public static int randomrgba(int rmin, int rmax, int gmin, int gmax, int bmin, int bmax, int a) {
        int r = Math.round(random(rmin, rmax));
        int g = Math.round(random(gmin, gmax));
        int b = Math.round(random(bmin, bmax));
        int limit = 5;
        if (Math.abs(r - g) <= limit && Math.abs(g - b) <= limit && Math.abs(b - r) <= limit) {
            return rgba(rmin, rmax, gmin, gmax);
        } else {
            return rgba(r, g, b, a);
        }
    }

    //角度转弧度
    public static float degrad(float angle) {
        return circle / 360 * angle;
    }
}
