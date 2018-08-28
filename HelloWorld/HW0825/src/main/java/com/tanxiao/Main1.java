package com.tanxiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String str[] = new String[n];
            for (int j = 0; j < n; j++) {
                str[j] = sc.next();
            }
            int k;
            OUT:
            for (int h = 0; h < str.length; h++) {
                for(k=h+1;k<str.length;k++){
                    if(isAnagram(str[h], str[k])){
                        list.add("Yeah");
                        break OUT;
                    }
                }
                if(k==str.length && h == str.length-1){
                    list.add("Sad");
                }
            }


        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static boolean isAnagram(String s ,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int [] sArry = new int[26];
        int [] tArry = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArry[s.charAt(i)-97]++;
            tArry[t.charAt(i)-97]++;
        }
        for (int i = 0; i < 26; i++){
            if(sArry[i]!=tArry[i])
                return false;
        }
        return true;
    }
}
