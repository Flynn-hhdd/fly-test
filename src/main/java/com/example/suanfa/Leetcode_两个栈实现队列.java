package com.example.suanfa;

import java.util.Stack;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName Leetcode_两个栈实现队列.java
 * @Description TODO
 * @createTime 2020年04月07日 10:30:00
 */
public class Leetcode_两个栈实现队列 {
    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;

    public Leetcode_两个栈实现队列() {
        stack1 = new Stack();
        stack2 = new Stack();

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }
}
