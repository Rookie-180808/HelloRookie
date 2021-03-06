package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/03 21:00
 */

public class Main {

//

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        while(in.hasNextLine()){
            String[] line = in.nextLine().split("\\s+");
            if (line.length == 3){
                // put操作
                int key = Integer.parseInt(line[1]);
                int value = Integer.parseInt(line[2]);

            } else if (line.length == 2){
                // get 操作
                int key = Integer.parseInt(line[1]);
                System.out.println("get : " + key);
            }
        }


        in.close();
    }


    private static String yn(int w, int c, int[][] y){
        int[][] r = new int[c + 1][w + 1];
        int[][] p = new int[c + 1][w + 1];
        for(int i = 1; i < c + 1; i ++){
            for(int j = 0; j < w + 1; j ++){
                if(y[i][0] > j){
                    // 上一个
                    r[i][j] = r[i - 1][j];
                    p[i][j] = j;
                    System.out.print("" + 0 + ":" + r[i - 1][j] + "-");
                } else {
                    r[i][j] = Math.max(r[i - 1][j]
                            , y[i][1] + r[i - 1][j - y[i][0]]);
                    if (r[i][j] == r[i - 1][j]){
                        p[i][j] = j;
                    } else {
                        p[i][j] = j - y[i][0];
                    }
                    System.out.print("" + (y[i][1] + r[i - 1][j] - y[i][0]) + ":" + r[i - 1][j] + "-");
                    //System.out.print("" + y[i][0] + ":" + j + "-");
                }
            }
            System.out.println();
        }

        System.out.println();
        for(int i = 0; i < c + 1; i ++){
            for(int j = 0; j < w + 1; j ++){
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("result");
        int i = c, j = w;
        printResult(r, i, j, y);
        System.out.println();
        return r[c][w] + "";
    }

    private static void printResult(int[][] r, int i, int j, int[][] y) {
        if (i <= 0){
            return;
        }
        if(r[i][j] == r[i - 1][j]){
            printResult(r, i - 1, j, y);
            if (i != 1){
                System.out.print(" ");
            }
            System.out.print(0);
        } else {
            printResult(r, i - 1, j - y[i][0], y);
            if (i != 1){
                System.out.print(" ");
            }
            System.out.print(1);
        }
    }

    private static void printArray(int[][] a){
        for(int i = 0; i < a.length; i ++){
            for(int j = 0; j < a[0].length; j ++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
