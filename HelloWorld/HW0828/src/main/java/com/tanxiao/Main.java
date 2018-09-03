package com.tanxiao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String string = "321";
        int result = getResult(string);
        System.out.println(result);
    }
    public static int getResult(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        int sum = 0;
        int i = 1;
        while (i < chars.length) {
            for (int j = 0; j <=  chars.length - i; j++) {
                for (int k = 1; k <= i; k++) {
                    sum += Integer.valueOf(chars[j]);
                    if (sum % 3 == 0) {
                        result++;

                    }
                }
            }
            i++;
        }
        return result;
    }

}
