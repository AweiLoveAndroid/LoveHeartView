package com.lzw.loveheart.widget.flower;



/**
 * 花园类
 */
public class Garden {

    //创建一个随机的花朵
    public Bloom createRandomBloom(int x, int y) {
        //创建一个随机的花朵半径
        int radius = MyUtil.randomInt(Options.minBloomRadius, Options.maxBloomRadius);
        //创建一个随机的花朵颜色
        int color = MyUtil.randomrgba(Options.minRedColor, Options.maxRedColor, Options.minGreenColor, Options.maxGreenColor, Options.minBlueColor, Options.maxBlueColor, Options.opacity);
        //创建随机的花朵中花瓣个数
        int petalCount = MyUtil.randomInt(Options.minPetalCount, Options.maxPetalCount);
        return createBloom(x, y, radius, color, petalCount);
    }

    //创建花朵
    public Bloom createBloom(int x, int y, int radius, int color, int petalCount) {
        return new Bloom(new PointUtil(x, y), radius, color, petalCount);
    }

    static class Options {
        //用于控制产生随机花瓣个数范围
        public static int minPetalCount = 8;
        public static int maxPetalCount = 15;
        //用于控制产生延长线倍数范围
        public static float minPetalStretch = 2f;
        public static float maxPetalStretch = 3.5f;
        //用于控制产生随机增长因子范围,增长因子决定花瓣绽放速度
        public static float minGrowFactor = 1f;
        public static float maxGrowFactor = 1.1f;
        //用于控制产生花朵半径随机数范围
        public static int minBloomRadius = 8;
        public static int maxBloomRadius = 10;
        //用于产生随机颜色
        public static int minRedColor = 128;
        public static int maxRedColor = 255;
        public static int minGreenColor = 0;
        public static int maxGreenColor = 128;
        public static int minBlueColor = 0;
        public static int maxBlueColor = 128;
        //花瓣的透明度
        public static int opacity = 50;//0.1
    }
}
