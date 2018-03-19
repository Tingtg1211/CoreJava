package com.algorithm.JIANZHI_OFFER;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * 分析：判断一个序列是不是栈的弹出规律：
 * 1.如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
 * 2.如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
 * 3.如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
   验证一个出栈是否合理的方法就是先入栈再出栈。
 */

public class Solution_IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        if(pushA.length == 0 || popA.length == 0)
            return false;
        int popIndex = 0;
        for(int i = 0; i < pushA.length; i ++){
            s.push(pushA[i]);
            //1.如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
            while(! s.empty() && s.peek() == popA[popIndex]){
                s.pop();
                popIndex ++;
            }//2.如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止
             //3.如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
        }
        return s.empty();



    }
}
