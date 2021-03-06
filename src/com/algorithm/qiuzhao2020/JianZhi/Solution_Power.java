package com.algorithm.qiuzhao2020.JianZhi;

public class Solution_Power {
    // 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;

    }

    public double Power_2(double base, int exponent) {
        double result = 1;
        if(base == 0 && exponent < 0){
            return 0;
        }
        for(int i = 0; i < Math.abs(exponent); i ++){
            result *= base;
        }

        //考虑指数是否为负数
        if(exponent < 0){
            result = 1 / result;
        }
        return result;

    }

}
