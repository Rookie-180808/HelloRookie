package com.tanxiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> list = saveIp(s);
        System.out.println(list.size());


    }
    public static ArrayList<String> saveIp(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        String temp = new String();
        find(s , temp , result , 4 , 0 , s.length());
        return result;
    }

    public static void find(String s , String temp , ArrayList<String> result , int count , int index , int len){
        //index 操作到字符串第几个字符
        //count 操作到IP第几位
        if(count == 0 && index == len){
            result.add(temp);
            return ;
        }
        if((count == 0 && index < len) || (count > 0  && index == len)){
            return ;
        }

        int value = 0;
        boolean flag = true;//第一个字符是否为0标志
        while(index < len && flag){
            if(value == 0 && s.charAt(index) == '0'){
                flag = false;
            }
            value = value * 10 + s.charAt(index) - '0';
            index++;
            if(value < 256){
                String record = "";
                if(count == 1){
                    record = temp + Integer.toString(value);
                }else{
                    record = temp + Integer.toString(value) + '.';
                }

                find(s , record , result , count - 1 , index , len);
            }
        }
    }


}
