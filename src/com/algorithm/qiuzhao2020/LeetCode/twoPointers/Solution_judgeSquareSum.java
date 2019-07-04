package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

/**
 * 题目描述：判断一个数是否为两个数的平方和。
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 */
public class Solution_judgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.sqrt(c);
        while (i < j) {
            int powSum = i * i + j * j;
            if(powSum == c){
                return true;
            }else if(powSum < c) {
                i ++;
            }else {
                j --;
            }
        }
        return false;

    }
}
