package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/25 16:18
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] nums = new int[n];

        String[] numStrs = in.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        System.out.println(maxNum(nums));
    }

    private static int maxNum(int[] nums) {
        int max = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < nums.length; j ++) {
                max = maxNum(nums, j, i, max);
            }
        }

        return max;
    }

    private static int maxNum(int[] nums, int begin, int length, int max) {
        // 数组越界的不用管
        if (begin + length > nums.length){
            return max;
        }

        int min = nums[begin];
        int all = 0;
        for (int i = 0; i < length; i++) {
            if (min > nums[i + begin]){
                // 选取最小值
                min = nums[i + begin];
            }
            all += nums[i + begin];
        }

        all = all * min;

        if (all > max){
            System.out.println(begin + ":" + length);
        } else {
            System.out.println(begin + "-" + length);
        }

        return Math.max(all, max);
    }


}
