package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Stack;

/**
 * 题目描述
 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution_minOfStack {
    public static Stack<Integer> dataStack = new Stack<>();
    public static Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if(minStack.empty()) {
            minStack.push(node);
        }else {
            if (node <= minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
        return minStack.peek();
    }
}
