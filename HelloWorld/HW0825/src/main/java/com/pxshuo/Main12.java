package com.pxshuo;

import java.util.Scanner;

/**
 * 0%
 * @author Pxshuo
 * Created on 2018/08/25 9:56
 */

public class Main12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] result = new String[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            String[] s = new String[n];
            for (int j = 0; j < n; j++) {
                s[j] = in.nextLine();
            }
            result[i] = checkResult(s);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }

    }
//    public static void main(String[] args) {
//
//        String s0 = "helloworld";
//        String s1 = "hdlrowolle";
//
//        System.out.println(checkResult(s0, s1));
//    }

    private static String checkResult(String[] s){
        String yeah = "Yeah";
        String sad = "Sad";

        if (s.length < 2){
            return sad;
        }

        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 1; j < s.length; j++) {
                if (checkResult(s[i], s[j])){
                    return yeah;
                }
            }
        }

        return sad;
    }

    private static boolean checkResult(String s0, String s1){
        boolean yeah = true;
        boolean sad = false;
        if (s0.length() != s1.length()){
            return sad;
        }

        if ("".equals(s0) && "".equals(s1)){
            return true;
        }

        char[] c0 = s0.toCharArray();
        char[] c1 = s1.toCharArray();

        if (checkStoE(c0, c1)){
            return yeah;
        } else if (checkEtoS(c0, c1)){
            return yeah;
        }

        return sad;
    }

    /**
     * 正向
     * @param c0
     * @param c1
     * @return
     */
    private static boolean checkStoE(char[] c0, char[] c1){
        int rightNum = 0;
        for (int i = 0; i < c0.length; i ++) {
            int i1 = i;
            for (int j = 0; j < c1.length && rightNum < c1.length; j = addOne(j, c1.length)) {
                if (c0[i1] == c1[j]){
                    rightNum ++;
                    i1 = addOne(i1, c0.length);
                }else {
                    rightNum = 0;
                    break;
                }
            }
            if (rightNum == c0.length){
                return true;
            }
        }
        return false;
    }

    private static boolean checkEtoS(char[] c0, char[] c1){
        int rightNum = 0;
        for (int i = 0; i < c0.length; i ++) {
            int i1 = i;
            for (int j = 0; j < c1.length && rightNum < c1.length; j = subOne(j, c1.length)) {
                if (c0[i1] == c1[j]){
                    rightNum ++;
                    i1 = addOne(i1, c0.length);
                }else {
                    rightNum = 0;
                    break;
                }
            }
            if (rightNum == c0.length){
                return true;
            }
        }
        return false;
    }

    private static int addOne(int index, int length){
        if (index < length - 1){
            index ++;
            return index;
        } else {
            return 0;
        }
    }

    private static int subOne(int index, int length){
        if (index > 0){
            index --;
            return index;
        } else {
            return length - 1;
        }
    }

}
