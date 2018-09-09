package com.mahb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author john on 2018/9/9
 * @version 1.0
 */

public class Mainjd01 {

    public static Integer count = 0;
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("D:\\a.txt");
        FileInputStream fileInputStream = new FileInputStream(f);
        Scanner sc = new Scanner(fileInputStream);
        long ip = Long.parseLong(sc.nextLine());
        fun1(ip);
    }

    public static void fun1(Long iii) {

    }

}
