package com.pxshuo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 70%
 * @author Pxshuo
 * Created on 2018/08/31 20:20
 */

public class MainTX01 {
    public static void main(String[] args) {
        BigInteger integer = new BigInteger("2");
        System.out.println(integer.add(new BigInteger("3")).multiply(new BigInteger("5")).mod(new BigInteger("3")));
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int a = in.nextInt();
        int x = in.nextInt();
        int b = in.nextInt();
        int y = in.nextInt();

        System.out.println(methodKind(k, a, b, x, y));
    }

    private static BigInteger methodKind(int k, int a, int b, int x, int y) {
        BigInteger result = new BigInteger("0");

        int aNum = Math.min(k/a, x);
        for (int i = 0; i <= aNum; i++) {
            int otherLength = k - i * a;
            if (otherLength % b == 0){
                int bNum = otherLength / b;
                // b满足长度
                if (bNum < y){
                    result = result.add(cMethod(x, i).multiply(cMethod(y, otherLength/b))).mod(new BigInteger(1000000007 + ""));
                }
            }
        }

        return result.mod(new BigInteger(1000000007 + ""));
    }

    private static BigInteger cMethod(int all, int part){
//        if (all == 0 || part == 0){
//            return 1;
//        }
        if (part > all/2){
            part = all - part;
        }
        BigInteger result1 = new BigInteger("1");
        BigInteger result2 = new BigInteger("1");
        for (int i = 0; i < part; i++) {
            result1 = result1.multiply(new BigInteger((all - i) + ""));
            result2 = result2.multiply(new BigInteger((part - i) + ""));
        }
        return result1.divide(result2);
    }
}
