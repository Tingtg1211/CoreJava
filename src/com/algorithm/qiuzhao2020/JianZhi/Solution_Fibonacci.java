package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * f(n)={
 *        0, n = 0
 *        1, n =1
 *        f(n-1) + f(n-2), n >1
 *
 *       }
 */
public class Solution_Fibonacci {
    public int Fibonacci(int n) {
        if(n < 0)
            return n;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n -2 );

    }
    public  int Fibonacci_2(int n) {
        if(n <= 1)
            return n;
        int pre1 = 1;
        int pre2 = 0;
        int fib = 0;
        for (int i = 2; i <= n; i ++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
