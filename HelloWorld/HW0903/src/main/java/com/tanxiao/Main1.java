package com.tanxiao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int result=function(arr);
        System.out.println(result);
    }

    private static int function(int[] arr) {
        return 0;
    }
}
