package com.pxshuo;

import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/28 20:24
 */

public class MainHwl05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strs = in.nextLine().split(" ");
        int[] nums = new int[strs.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        System.out.println(maxResult(nums));
    }

    private static int maxResult(int[] nums) {
        int max = 0;
        int[] maxArray = new int[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            maxArray[0] = nums[0];
            for (int j = 1; j < i; j++) {
                maxArray[j] = nums[j];
                max = 0;
                for (int k = 0; k < j; k++) {
                    if (nums[j] > nums[k]){
                        if (max < maxArray[k]){
                            max = maxArray[k];
                        }
                    }
                }
                maxArray[j] += max;
            }
        }

        max = 0;
        for (int aMax : maxArray) {
            if (max < aMax) {
                max = aMax;
            }
        }
        return max;
    }
}
