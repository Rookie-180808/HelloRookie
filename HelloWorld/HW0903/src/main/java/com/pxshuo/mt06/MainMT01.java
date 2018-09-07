package com.pxshuo.mt06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pxshuo
 * Created on 2018/09/06 20:05
 */

public class MainMT01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nodes = new Node[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int pre = in.nextInt();
            int next = in.nextInt();
            nodes[i] = new Node(pre, next);
        }
        int[] ds = new int[n + 1];
        System.out.println(minLength(sort(nodes), ds));
    }

    private static Node[] sort(Node[] node){
        Arrays.sort(node);
        return node;
    }

    private static int minLength(Node[] node, int[] ds) {
        int max = 0;

        for (int i = 0; i < node.length; i++) {
            ds[node[i].next] = ds[node[i].pre] + 1;
            if (ds[node[i].next] > max){
                max = ds[node[i].next];
            }
        }

        return 2 * (node.length) - max;
    }

    static class Node implements Comparable{
        int pre, next;

        Node(int pre, int next){
            if (pre < next) {
                this.pre = pre;
                this.next = next;
            } else {
                this.pre = next;
                this.next = pre;
            }
        }

        @Override
        public int compareTo(Object o) {
            return pre - ((Node)o).pre != 0 ? pre - ((Node)o).pre : next - ((Node)o).next;
        }

        @Override
        public String toString() {
            return pre + " " + next;
        }
    }
}
