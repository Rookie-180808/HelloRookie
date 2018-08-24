package com.pxshuo;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * 通过率 100%
 * @author Pxshuo
 * Created on 2018/08/24 18:17
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

    public static int Fibonacci(int n) {
        if (n < 2 ){
            return n;
        }
        //返回结果
        int result = 1;

        // 前一个数字
        int preNum = 0;

        for (int i = 1; i < n; i++) {
            // 返回结果为前一个+前二个
            result = result + preNum;
            // 前一个等于之前的result
            preNum = result - preNum;
        }

        return result;
    }
}
