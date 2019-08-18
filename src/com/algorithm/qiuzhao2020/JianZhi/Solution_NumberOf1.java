package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目:
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */


// n-1:如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
// 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响
// n = 1110 n-1=1101 n&(n-1)=1100

// 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
// 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。

public class Solution_NumberOf1 {
    public int NumberOf1(int n) {
        return Integer.bitCount(n);
    }

    public int NumberOf1_1(int n) {
        int cnt = 0;
        while (n != 0) {
            ++cnt;
            n &= n - 1;
        }
        return cnt;
    }
}
