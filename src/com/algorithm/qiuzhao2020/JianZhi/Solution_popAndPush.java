package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution_popAndPush {
    // 进栈
    Stack<Integer> stack1 = new Stack<Integer>();
    // 出栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
                throw new Exception("queue is null");
        }
        return stack2.pop(); // 如果stack2不为null 需要将值pop出去再push stack1的值来维持顺序

    }
}
