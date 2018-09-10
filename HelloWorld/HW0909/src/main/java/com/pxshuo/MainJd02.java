package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/09 16:10
 */

public class MainJd02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] input  = new int[n][3];

        for (int i = 0; i < n; i++) {
            input[i][0] = in.nextInt();
            input[i][1] = in.nextInt();
            input[i][2] = in.nextInt();
        }

        System.out.println(getCount(input));

        in.close();
    }

    private static int getCount(int[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i !=j && isBelow(input, i, j)){
                    count ++;
                    break;
                }
            }
        }

        return count;
    }

    private static boolean isBelow(int[][] input, int i, int j) {
        if (input[j][0] > input[i][0] && input[j][1] > input[i][1] && input[j][2] > input[i][2]){
            return true;
        }
        return false;
    }

//    private static boolean isRight(int[][] input, int a, int b, int c, int num) {
//        for (int i = 0; i < num; i++) {
//            if (isBelow(input, i, a, b, c)){
//
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean isBelow(int[][] input, int num, int aj, int bj, int cj) {
//        if (aj > input[num][0] && bj > input[num][1] && cj > input[num][2]){
//            input[num][0] = aj;
//            input[num][1] = bj;
//            input[num][2] = cj;
//            return true;
//        }
//        return false;
//    }


}
