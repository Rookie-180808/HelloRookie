package com.tanxiao;

import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in

        );
        int t = scanner.nextInt();
        int x, y;
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] arr = new int[n + 1][n + 1];
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                arr[x][y] = 1;
                arr[y][x] = 1;
            }
            for (int j = 2; j <= n; ++j) {
                if (arr[1][j] == 1) {
                    list.add(j);
                }
            }
            List<List<Integer>> sets = new ArrayList<>();
            List<Integer> set = new ArrayList<>();
            set.add(1);
            count++;
            for (int j = 2; j <= n; ++j) {
                if (arr[1][j] == 0) {
                    set.add(j);
                    ++count;
                }
            }
            sets.add(set);
            for (int k = 0; k < list.size(); ++k) {
                int temp = list.get(k);
                boolean flag = false;
                for (int j = 0; j < sets.size(); ++j) {
                    if (sets.get(j).contains(temp)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    List<Integer> num = new ArrayList<>();
                    num.add(temp);
                    ++count;
                    for (int a = 1; a <= n; ++a) {
                        if (a != temp && arr[temp][a] == 0) {
                            num.add(a);
                            ++count;
                        }
                    }
                    sets.add(num);
                }
            }
            if (count == n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}