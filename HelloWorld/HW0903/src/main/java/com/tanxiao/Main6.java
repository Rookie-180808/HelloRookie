package com.tanxiao;
/**
 * 最长回文子串
 */

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        String result = longeststr(num);
        System.out.println(result);
    }
    public static String longeststr(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        if(s==null || s.isEmpty()) return "";
        for(int i = 0 ; i < s.length();i++) {
            int length = Math.max(join(s,i,i),join(s,i,i+1));
            if(length > maxLength) {
                start = i - (length-1) / 2;
                end = i + length / 2;
                maxLength = Math.max(maxLength,end-start);
            }
        }
        return s.substring(start,end+1);
    }


    private static int join(String s, int left, int right) {
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;

    }
}
