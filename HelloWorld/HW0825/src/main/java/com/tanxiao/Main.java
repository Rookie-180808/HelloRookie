package com.tanxiao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int q=scanner.nextInt();
        for(int i=0;i<q;i++){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            System.out.println(flowers(l,r,arr,m));
        }
    }

    private static int flowers(int l, int r,int[] arr,int m) {
        int[] hash = new int[m + 1];
        int count = 0;

        for (int i = l - 1; i < r; i++) {
            if (hash[arr[i]] == 0){
                hash[arr[i]] = 1;
                count ++;
            }
        }
        return count;
    }
}
