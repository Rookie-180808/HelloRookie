package com.pxshuo;

import java.util.Scanner;

/**
 * 城市为平行于坐标轴的正方形,输入居民的坐标,求城市最小面积
 * @author Pxshuo
 * Created on 2018/08/27 19:42
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = in.nextInt();
            ys[i] = in.nextInt();
        }

        System.out.println(minArea(n,xs,ys));
    }

    /**
     * 求最小面积
     * @param n     居民数
     * @param xs    居民的x坐标
     * @param ys    居民的y坐标
     * @return      最小面积
     */
    private static long minArea(int n, int[] xs, int[] ys){
        // x,y没有超出int范围,但是平方可能超出范围
        long maxLength = 0;
        // 由于是平行于坐标轴的正方形,所以最小面积值为最大x,y差值的平方
        int minX = xs[0],
                minY = ys[0],
                maxX = xs[0],
                maxY = ys[0];
        for (int i = 1; i < n; i++) {
            minX = Math.min(minX, xs[i]);
            minY = Math.min(minY, ys[i]);
            maxX = Math.max(maxX, xs[i]);
            maxY = Math.max(maxY, ys[i]);
        }

        maxLength = Math.max(maxX - minX,maxY - minY);
        return maxLength * maxLength;
    }

}
