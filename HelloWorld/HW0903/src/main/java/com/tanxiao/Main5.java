package com.tanxiao;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        String result = multi(num1, num2);
        System.out.println(result);
    }
    public static String multi(String n1,String n2){
        int len1=n1.length();
        int len2=n2.length();
        char[] number1=n1.toCharArray();
        char[] number2=n2.toCharArray();
        char tmp;
        int tmp1;
        for(int i=0;i<len1/2;i++){
            tmp=number1[i];
            number1[i]=number1[len1-1-i];
            number1[len1-1-i]=tmp;
        }
        for(int i=0;i<len2/2;i++){
            tmp=number2[i];
            number2[i]=number2[len2-1-i];
            number2[len2-1-i]=tmp;
        }
        int[] result=new int[len1+len2];
        for(int i=0;i<len1;i++){
            for (int j=0;j<len2;j++){
                result[i+j]+=(Integer.valueOf(number1[i])-'0')*(Integer.valueOf(number2[j])-'0');
            }
        }
        for(int i=0;i<len1+len2-1;i++){
            if(result[i]>=10){
                result[i+1]+=result[i]/10;
                result[i]%=10;
            }
        }
        for(int i=0;i<(len1+len2)/2;i++){
            tmp1=result[i];
            result[i]=result[len1+len2-1-i];
            result[len1+len2-1-i]=tmp1;
        }

        StringBuilder s=new StringBuilder();
        int k=0;
        while(result[k]==0){
            k++;
        }
        for(int i=k;i<len1+len2;i++){
            s.append(result[i]);
        }
        return s.toString();
    }

}
