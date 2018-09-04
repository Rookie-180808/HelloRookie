package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/04 19:30
 */

public class MainLong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        String lstr = Long.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < lstr.length(); i++) {
            if (lstr.charAt(i) == '1'){
                count ++;
            }
        }

        System.out.println(count);
    }
}
