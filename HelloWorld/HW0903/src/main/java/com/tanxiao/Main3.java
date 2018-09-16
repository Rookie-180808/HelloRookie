package com.tanxiao;
import java.util.Scanner;

public class Main3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        int n = sc.nextInt();
        int [] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        boolean result = validUtf8(data);
        int count = result==true?1:0;
        System.out.print(count);
    }
    public static int judge(int n) {
        if ((128 & n) == 0)
            return -1;
        if ((192 & n) == 128)//10
            return 0;
        if ((224 & n) == 192)
            return 1;
        if ((240 & n) == 224)
            return 2;
        if ((248 & n) == 240)
            return 3;
        return -2;
    }

    public static boolean validUtf8(int[] data) {
        boolean isUtf8 = false;// 当前num是否在一个验证的字符中
        int times = 0;
        for (int i = 0; i < data.length; i++) {
            if(isUtf8==false){//当前数不在某字符编码内
                times = judge(data[i]);//当前编码需要多少个10
                if (times == -2 || times == 0)//非编码
                    return false;
                if(times>0)//后面需要跟多少个10编码
                    isUtf8=true;
            }else{
                if(times>0&&judge(data[i])==0)//是10编码
                    times--;
                else
                    return false;
                if(times==0)
                    isUtf8=false;
            }
        }
        return times>0?false:true;
    }


}
