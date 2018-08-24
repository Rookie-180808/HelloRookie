package com.tanxiao;

import org.junit.Test;

import java.util.Stack;

public class Main {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();
    public void put(int data){
        stack1.push(data);
    }
    public Integer get(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());

            }
        }
        return stack2.pop();
    }
    @Test
    public void test(){
        this.put(2);
        this.put(3);
        System.out.println(this.get());
        this.put(4);
        System.out.println(this.get());
        System.out.println(this.get());
    }
}
