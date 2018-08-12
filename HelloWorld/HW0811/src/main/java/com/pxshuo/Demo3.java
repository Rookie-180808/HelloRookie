package com.pxshuo;

import java.util.*;

/**
 * 通过率: 10%
 * @author
 * Created
 */

public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = 0;
        int n = 0;
        int[] mn;

        mn = lineToArray(in.nextLine());
        m = mn[0];
        n = mn[1];

        int arr[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            arr[i] = lineToArray(in.nextLine());
        }

//        m = 10;
//        n = 10;
//        int arr[][] = new int[][]{
//                {0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,1,1,0,1,0,0,0},
//                {0,1,0,0,0,0,0,1,0,1},
//                {1,0,0,0,0,0,0,0,1,1},
//                {0,0,0,1,1,1,0,0,0,1},
//                {0,0,0,0,0,0,1,0,1,1},
//                {0,1,1,0,0,0,0,0,0,0},
//                {0,0,0,1,0,1,0,0,0,0},
//                {0,0,1,0,0,1,0,0,0,0},
//                {0,1,0,0,0,0,0,0,0,0}
//            };
//        m = 2;
//        n = 3;
//        int arr[][] = new int[][]{
//                {1,0,0},
//                {0,1,1}
//            };

        System.out.println(getResult(m, n, arr));

    }

    private static String getResult(int m, int n, int[][] arr) {
        int p = 0;
        int q = 0;

        int[][] pArr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 群组未被访问过
                if (arr[i][j] == 1 && pArr[i][j] == 0){
                    p ++;
                    q = Math.max(q, checkP(i, j, arr, pArr, p));
                }
            }
        }

        return p + "," + q;
    }

    private static int checkP(int x, int y, int[][] arr, int[][] pArr, int p) {
        int num = 1;
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(x, y));
        pArr[x][y] = p;
        while (!queue.isEmpty()){
            x = queue.peek().x;
            y = queue.peek().y;
            if (arrNotEmpty(x, y + 1, arr, pArr)){
                queue.offer(new Point(x, y + 1));
                pArr[x][y + 1] = p;
                num ++;
            }
            if (arrNotEmpty(x + 1, y - 1, arr, pArr)){
                queue.offer(new Point(x + 1, y - 1));
                pArr[x + 1][y - 1] = p;
                num ++;
            }
            if (arrNotEmpty(x + 1, y, arr, pArr)){
                queue.offer(new Point(x + 1, y));
                pArr[x + 1][y] = p;
                num ++;
            }
            if (arrNotEmpty(x + 1, y + 1, arr, pArr)){
                queue.offer(new Point(x + 1, y + 1));
                pArr[x + 1][y + 1] = p;
                num ++;
            }
            if (arrNotEmpty(x, y - 1, arr, pArr)){
                queue.offer(new Point(x, y - 1));
                pArr[x][y - 1] = p;
                num ++;
            }
            if (arrNotEmpty(x - 1, y + 1, arr, pArr)){
                queue.offer(new Point(x - 1, y + 1));
                pArr[x - 1][y + 1] = p;
                num ++;
            }
            if (arrNotEmpty(x - 1, y, arr, pArr)){
                queue.offer(new Point(x - 1, y));
                pArr[x - 1][y] = p;
                num ++;
            }
            if (arrNotEmpty(x - 1, y - 1, arr, pArr)){
                queue.offer(new Point(x - 1, y - 1));
                pArr[x - 1][y - 1] = p;
                num ++;
            }
            queue.poll();
        }
        return num;
    }

    private static boolean arrNotEmpty(int x, int y, int[][] arr, int[][] pArr) {
        if (x >= arr.length || x < 0 || y >= arr[x].length || y < 0){
            return false;
        }
        return arr[x][y] == 1 && pArr[x][y] ==0;
    }

    private static int[] lineToArray(String line){
        String[] strArr = line.split(",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        return arr;
    }

    private static class Point{
        private int x;
        private int y;

        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
