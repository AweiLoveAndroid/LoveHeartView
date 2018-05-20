package com.demo.commandline;

/**
 * 命令行打印爱心
 * 主要是 使用for循环控制输出的字符是*还是空格
 * 全程for循环 
 * 这个应该是初学java的人写的
 */
public class LoveHeart2 {
    public static void main(String[] args) {
        int n = 4;
        int i, j, m;
        //上面部分
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                System.out.print("*");
            }
            for (j = 1; j <= 2 * n - 1 + (i - 6) * (i - 1); j++) {
                if (i == n) break;
                System.out.print(" ");
            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                if (i == n) break;
                System.out.print("*");
            }
            if (i == n) {
                for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2 - 1; j++) {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
        //中间部分
        for (i = 1; i <= n - 2; i++) {
            for (j = 1; j <= 6 + (10 - n) * (n - 1) / 2 - 1 + 6 + (10 - n) * (n - 1) / 2; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        //下面部分
        m = 6 + (10 - n) * (n - 1) / 2 + 6 + (10 - n) * (n - 1) / 2 - 1;
        for (i = 1; i <= (m - 2 - 3) / 4 + 1; i++) {
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= m + 2 - 4 * i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (j = 1; j <= 2 * ((m - 2 - 3) / 4 + 1); j++)

        {
            System.out.print(" ");
        }
        System.out.print("*");
    }
}