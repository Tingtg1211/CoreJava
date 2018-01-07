package com.algorithm;

import java.util.Stack;

public class sortStack {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();//辅助栈
        while(!stack.isEmpty()) {
            int cur = stack.pop();

            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        while (!help.isEmpty()){
                stack.push(help.pop());
        }
    }
}

