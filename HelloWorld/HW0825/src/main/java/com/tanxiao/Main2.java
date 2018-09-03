package com.tanxiao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for (int i=0;i<n;i++){
            arr1[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            arr2[i]=scanner.nextInt();
        }
        int i=test(arr1,arr2);
        System.out.println(i);
    }

    private static int test(int[] arr1, int[] arr2) {
        return 2;
    }
}
