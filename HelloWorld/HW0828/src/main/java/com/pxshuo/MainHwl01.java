package com.pxshuo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/08/28 20:43
 */

public class MainHwl01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // t组数据
        String num = in.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(maxThree(num, map));
    }

    private static int maxThree(String num, HashMap<String, Integer> map) {
        if (map.containsKey(num)){
            return map.get(num);
        }
        int result = 0;
        if (num.length() == 0){
            result = 0;
        } else if (num.length() == 1){
            if (isThree(num)){
                result = 1;
            } else {
                result = 0;
            }
        }else {
            int s0 = 0, sm = 0;
            if (isThree(num)){
                s0 = 1;
            }
            for (int i = 1; i < num.length(); i++) {
                int ln = maxThree(num.substring(0, i), map);
                int rn = maxThree(num.substring(i, num.length()), map);
                int s2 = ln + rn;
                if (s2 > sm){
                    sm = s2;
                }
            }
            result = Math.max(sm, s0);
        }
        map.put(num, result);
        return result;
    }
    private static boolean isThree(String num){
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result += Integer.parseInt(num.substring(i, i + 1));
        }
        return result % 3 == 0;
    }
}
