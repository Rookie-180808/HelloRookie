package com.tanxiao;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in

        );
        int t = scanner.nextInt();
        int x, y;
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] vec = new int[n + 1][n + 1];
            int count = 0;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                vec[x][y] = 1;
                vec[y][x] = 1;
            }
            for (int j = 2; j <= n; ++j) {
                if (vec[1][j] == 1) {
                    list.add(j);
                }
            }
            List<List<Integer>> sets = new ArrayList<>();
            List<Integer> set = new ArrayList<>();
            set.add(1);
            count++;
            for (int j = 2; j <= n; ++j) {
                if (vec[1][j] == 0) {
                    set.add(j);
                    ++count;
                }
            }
            sets.add(set);
            for (int k = 0; k < list.size(); ++k) {
                int temp = list.get(k);
                boolean b = false;
                for (int j = 0; j < sets.size(); ++j) {
                    if (sets.get(j).contains(temp)) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(temp);
                    ++count;
                    for (int a = 1; a <= n; ++a) {
                        if (a != temp && vec[temp][a] == 0) {
                            list1.add(a);
                            ++count;
                        }
                    }
                    sets.add(list1);
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