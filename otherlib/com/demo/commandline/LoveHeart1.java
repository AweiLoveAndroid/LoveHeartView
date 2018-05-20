package com.demo.commandline;

/**
 * 命令行打印爱心
 * 主要是 使用for循环控制输出的字符是*还是空格
 */
public class LoveHeart1 {

    public static void main(String[] args) {
        printEmpty();
    }

    static float count(float x, float y) {
        return (float) (Math.pow((x * x + y * y - 1), 3) - x * x * y * y * y);
    }

    public static void printEmpty() {
        int height = 20, width = 60;
        int heart[][] = new int[height][width];
        float hx = 0.0f, hy = 0.0f;
        for (int y = height / 2; y > -height / 2; y--) {
            for (int x = -width / 2; x < width / 2; x++) {
                hx = (float) x / (float) (width / 2.8f);
                hy = (float) (y) / (float) (height / 2.8f);
                if (count(hx, hy) <= 0.0f) {
                    heart[height / 2 - y][x + width / 2] = 1;
                }
            }
        }
        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                if (heart[y][x] == 1
                        && !(heart[y][x - 2] == 1 && heart[y][x + 2] == 1
                        && heart[y - 1][x] == 1 && heart[y + 1][x] == 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}