package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/28 19:06
 */

public class MainHwl02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // t组数据
        int t = in.nextInt();

        long[] xs = new long[t];
        long[] ks = new long[t];

        for (int i = 0; i < t; i++) {
            xs[i] = in.nextLong();
            ks[i] = in.nextLong();
        }

        for (int i = 0; i < t; i++) {
            System.out.println(printResult(xs[i], ks[i]));
        }

    }

    private static long printResult(long x, long k) {
        String binaryLongX = Long.toBinaryString(x);
        String binaryLongK = Long.toBinaryString(k);

        char[] xs = binaryLongX.toCharArray();
        char[] ks = binaryLongK.toCharArray();

        char[] rs = new char[ks.length + xs.length];
        int count = 0;
        // 先不考虑出long范围
        for (int i = 0; i < rs.length; i++) {
            int xIndex = xs.length - 1 - i;
            if (xIndex >= 0 && xs[xIndex] == '1'){
                rs[rs.length - 1 - i] = '0';
                count ++;
            } else if (ks.length - 1 - i + count >= 0){
                if (ks.length - 1 - i + count >= 0){
                    rs[rs.length - 1 - i] = ks[ks.length - 1 - i + count];
                } else{
                    rs[rs.length - 1 - i] = '0';
                }
            } else {
                rs[rs.length - 1 - i] = '0';
            }
        }
        String result = new String(rs);
        return Long.parseLong(result, 2);
    }

}
