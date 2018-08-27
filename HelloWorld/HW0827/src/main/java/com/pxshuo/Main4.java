package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/27 20:34
 */

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        System.out.println(maxLength(n,a,b));
    }

    private static int maxLength(int n, int[] a, int[] b) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while ((j - count >= 0 && i + count < n) && b[j - count] == a[i + count]){
                    count ++;
                }
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }
}
