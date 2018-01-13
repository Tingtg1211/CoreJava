package com.algorithm.JIANZHI_OFFER;

import java.util.Stack;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/13
 * Time: 14:42
 */

public class Solution_TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("The queue is empty !");
        }else if(stack2.isEmpty() ){
            while (! stack1.isEmpty()){
                stack2.push(stack1.pop());   //循环添加已经入栈1的元素，保证队列永远满足先进先出的特性
            }

        }
        return stack2.pop();

    }

}
