package com.pxshuo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main2{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int n = Integer.valueOf(scanner.nextLine());
            long curtime = getLongFromString(scanner.nextLine());
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<n;i++){
                Integer result = getOrderId(scanner.nextLine(),curtime);
                if(result!=null) {
                    list.add(result);
                }
            }

            Collections.sort(list);

            if(list==null||list.size()==0){
                System.out.println("null");
            }else{
                for(Integer i:list) {
                    System.out.println(i);
                }
            }
        }
        scanner.close();
    }

    public static Integer getOrderId(String s,long curtime){
        String arr[] = s.split("\\s+");
        long start = getLongFromString(arr[1]);
        long end = getLongFromString(arr[2]);
        if(start<=curtime && curtime<=end) {
            return Integer.valueOf(arr[0]);
        }
        return null;
    }

    public static long getLongFromString(String dateTime){
        StringBuffer buffer = new StringBuffer();
        char[] charArray = dateTime .toCharArray();
        for (int i = 0; i < charArray .length ; i ++) {
            if (Character.isDigit( charArray[i])) {
                buffer.append(charArray[i]);
            }
        }
        dateTime = buffer.toString();
        buffer = null;
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yyyyMMdd").parse(dateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.getTimeInMillis();
    }
}
