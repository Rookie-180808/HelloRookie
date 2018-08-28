package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/28 21:46
 */

public class MainHwl03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] nums = in.nextLine().split(" ");
        String[] bins = in.nextLine().split(" ");

        printAll(nums, bins);

    }

    private static void printAll(String[] nums, String[] bins) {

        printAll(nums, bins, -1, "-1");
    }

    private static void printAll(String[] nums, String[] bins, int pos, String isShow) {
        if (pos > 0){
            bins[pos] = isShow;
        }
        boolean isPrint = true;
        int start = pos > 0 ? pos : 0;
        for (int i = start; i < nums.length; i++) {
            if ("0".equals(bins[i])){
                isPrint = false;
                printAll(nums, bins, i, "-1");
                printAll(nums, bins, i, "1");
                break;
            }
        }

        if (isPrint){
            for (int i = 0; i < nums.length; i++) {
                if (!"-1".equals(bins[i])){
                    System.out.print(nums[i]);
                }
            }
            System.out.println();
        }

        if (pos > 0){
            bins[pos] = "0";
        }
    }
}
