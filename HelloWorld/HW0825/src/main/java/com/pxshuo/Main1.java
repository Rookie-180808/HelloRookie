package com.pxshuo;

import java.util.Scanner;

/**
 * @author tanxiao
 * Created on 2018/08/27 19:42
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] x = new int[input];
        int[] y = new int[input];

        for (int i = 0; i < input; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }

        System.out.println(minArea(input,x,y));
    }

    private static long minArea(int n, int[] xs, int[] ys){
        long maxLen = 0;
        int minX = xs[0];
        int minY = ys[0];
        int maxX = xs[0];
        int maxY = ys[0];
        for (int i = 1; i < n; i++) {
            minX = Math.min(minX, xs[i]);
            minY = Math.min(minY, ys[i]);
            maxX = Math.max(maxX, xs[i]);
            maxY = Math.max(maxY, ys[i]);
        }

        maxLen = Math.max(maxX - minX,maxY - minY);
        return maxLen * maxLen;
    }

}
