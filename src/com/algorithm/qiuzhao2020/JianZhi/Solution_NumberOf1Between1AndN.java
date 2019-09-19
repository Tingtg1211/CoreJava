package com.algorithm.qiuzhao2020.JianZhi;

public class Solution_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int nummber = 0;
        for(int i = 1; i <= n; i ++) {
            nummber += numberOf1(i);
        }
        return nummber;
    }
    private int numberOf1(int n) {
        int number = 0;
        while (n != 0 ) {
            if(n % 10 == 1) {
                number ++;
            }
            n /= 10;
        }
        return number;

    }
}
