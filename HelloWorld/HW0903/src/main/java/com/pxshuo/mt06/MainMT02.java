package com.pxshuo.mt06;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/06 20:57
 */

public class MainMT02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();

        if(n == 0 || k == 0 || t == 0 || k < t){
            System.out.println(0);
        }

        int[] array = new int[n];
        for(int i = 0;i < n; i++){
            array[i] = in.nextInt();
        }
        int count=0;
        for(int i = 0;i <= n-k; i++){
            int jump = hasT(array, t, i, i + k);
            if(jump != -1){
                i = i + jump;
                count  = count + jump + 1;
            }
        }
        System.out.println(count);
    }

    private static int hasT(int[] array ,int t, int l, int r){
        int[] map = new int[10001];
        int[] m1 = new int[10001];
        for(int i = l;i < r; i++){
            Integer value;
            if (map[array[i]] == 0){
                value = 1;
            } else {
                value = map[array[i]] + 1;
            }
            map[array[i]] = value;
            if(m1[array[i]] != 0) {
                m1[array[i]] = i;
            }
            if(map[array[i]] >= t){
                return m1[array[i]] - l;
            }
        }
        return -1;
    }
}
