package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/27 20:11
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] fs = new int[n];
        for (int i = 0; i < n; i++) {
            fs[i] = in.nextInt();
        }
        int q = in.nextInt();
        int[] ls = new int[q];
        int[] rs = new int[q];

        for (int i = 0; i < q; i++) {
            ls[i] = in.nextInt();
            rs[i] = in.nextInt();
        }

        for (int i = 0; i < q; i++) {
            answerQuestion(m, fs, ls[i], rs[i]);
        }
    }

    /**
     * 回答看花的种类
     * @param m     m种花朵,用于hash
     * @param fs    看花的流程
     * @param l     起始时间
     * @param r     结束时间
     */
    private static void answerQuestion(int m, int[] fs, int l, int r) {
        int[] hash = new int[m + 1];
        int count = 0;

        for (int i = l - 1; i < r; i++) {
            if (hash[fs[i]] == 0){
                hash[fs[i]] = 1;
                count ++;
            }
        }

        System.out.println(count);
    }
}
