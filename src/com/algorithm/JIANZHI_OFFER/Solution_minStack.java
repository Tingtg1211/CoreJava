package com.algorithm.JIANZHI_OFFER;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：借助一个辅助栈，每次都把最小元素压入辅助栈，就能保证辅助栈的栈顶一直都是最小元素。
 * 当最小元素从数据栈内被弹出之后，同时弹出辅助栈的栈顶元素，此时辅助栈的新栈顶元素就是下一个最小值。
 *
 *

 */
public class Solution_minStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
      dataStack.push(node);
      if(minStack.empty()){
          minStack.push(node);
      }else {
          int min = minStack.peek();
          if(node <= min){
              minStack.push(node);

          }else {
              minStack.push(min);
          }

      }


    }

    public void pop() {
        if(!dataStack.isEmpty()){
        dataStack.pop();
        minStack.pop();
        }

    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }else{
            return 0;
        }

    }
}
