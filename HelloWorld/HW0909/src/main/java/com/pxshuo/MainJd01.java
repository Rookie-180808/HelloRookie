package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/09 16:10
 */

public class MainJd01 {
    public static void main(String[] args) {
        final String yes = "Yes";
        final String no = "No";
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            boolean[][] arr = new boolean[n + 1][n + 1];

            for (int j = 0; j < m; j++) {
                int f = in.nextInt();
                int to = in.nextInt();
                arr[f][to] = true;
                arr[to][f] = true;
            }

            results[i] = isRight(arr) ? yes : no;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(results[i]);
        }
        in.close();
    }

    private static boolean isRight(boolean[][] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (!arr[i][j]){
                    if (!isSame(arr[i], arr[j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isSame(boolean[] a1, boolean[] a2){
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }

}
