package com.tanxiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int M = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        List<Integer> headList = new ArrayList();
        List<Integer> rearList = new ArrayList();

        List<Integer> inDirectHeadList = new ArrayList();
        List<Integer> inDirectRearList = new ArrayList();

        for (int i = 0; i < M * 2; i += 2) {
            headList.add(Integer.parseInt(str.substring(2 * i, 2 * i + 1)));
            rearList.add(Integer.parseInt(str.substring(2 * i + 2, 2 * i + 3)));
        }

        for (int i = 0; i < M; i++) {
            List<Integer> indexList = findIndex(headList, rearList.get(i));

            Integer tempHead = headList.get(i);

            if (indexList.size() != 0) {

                for (int j = 0; j < indexList.size(); j++) {

                    Integer tempRear = rearList.get(indexList.get(j));

                    if (checkMap(inDirectHeadList, inDirectRearList, tempHead, tempRear)
                            && checkMap(headList, rearList, tempHead, tempRear)) {
                        inDirectHeadList.add(tempHead);
                        inDirectRearList.add(tempRear);
                    }

                }

            }
        }

        int result = checkPopular(headList, rearList, inDirectHeadList, inDirectRearList, N);
        System.out.println(result);

    }

    public static List<Integer> findIndex(List<Integer> list, Integer n) {

        List<Integer> result = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean checkMap(List<Integer> headList, List<Integer> rearList, Integer head, Integer rear) {

        for (int i = 0; i < headList.size(); i++) {
            if (headList.get(i) == head && rearList.get(i) == rear) {
                return false;
            }
            if (head == rear) {
                return false;
            }
        }

        return true;
    }

    public static int checkPopular(List<Integer> headList, List<Integer> rearList, List<Integer> inDirectHeadList,
                                   List<Integer> inDirectRearList, Integer N) {
        int result = 0;

        List<Integer> finalHeadList = new ArrayList();
        List<Integer> finalRearList = new ArrayList();

        for (int i = 0; i < headList.size(); i++) {
            finalHeadList.add(headList.get(i));
            finalRearList.add(rearList.get(i));
        }

        for (int i = 0; i < inDirectHeadList.size(); i++) {
            finalHeadList.add(inDirectHeadList.get(i));
            finalRearList.add(inDirectRearList.get(i));
        }

        int[] interestNum = new int[N];
        for (int i = 1; i <= N; i++) {
            interestNum[i - 1] = findIndex(finalRearList, i).size();
        }

        for (int i = 0; i < interestNum.length; i++) {
            if (interestNum[i] == N - 1) {
                result++;
            }
        }

        return result;

    }
}

