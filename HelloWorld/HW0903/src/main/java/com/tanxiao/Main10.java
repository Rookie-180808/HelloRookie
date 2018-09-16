package com.tanxiao;

import java.util.Scanner;

public class Main10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(",");
        int[] is = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            is[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(mincost(is));
    }

    public static int mincost(int[] cost) {
        int minCost[] = new int[cost.length + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {
            int costV = (i == cost.length) ? 0 : cost[i];
            minCost[i] = Math.min(minCost[i - 1] + costV, minCost[i - 2]
                    + costV);
        }
        return minCost[cost.length];
    }
}
