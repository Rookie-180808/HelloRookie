package com.tanxiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main8{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String str = calculate(a,b);
        System.out.println(str);
    }


    public static String calculate(int num1, int num2) {
        HashMap<Long,Integer> maps = new HashMap<>();//store divid number
        List<Long> number = new ArrayList<>();
        int index = 0;
        int beginIndex = -1;

        StringBuilder builder = new StringBuilder();
        if(num2 ==0)
            return "";
        long num = num1;
        long denum = num2;
        if((num<0 && denum>0) || (num>0 && denum<0))
            builder.append('-');

        num = Math.abs(num);
        denum = Math.abs(denum);

        long val = num/denum;
        builder.append(String.valueOf(val));
        num = (num%denum)*10;

        while(num!=0){
            if(maps.containsKey(num)){//开始重复
                beginIndex = maps.get(num);
                break;
            }else{

                maps.put(num, index++);
                val = num/denum;
                num = (num%denum)*10;
                number.add(val);
            }
        }
        for(int i = 0;i<index;i++){
            if(i==0)
                builder.append('.');
            if(i==beginIndex){
                builder.append('(');
            }
            builder.append(number.get(i));
        }
        if(beginIndex!=-1)
            builder.append(')');

        return builder.toString();
    }
}