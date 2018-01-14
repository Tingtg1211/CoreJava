package com.algorithm.JIANZHI_OFFER;

/**
 * Created by gtt on 2018/1/14.
 */


//  传统O(n)解法

public class Solution_power {
    public double Power(double base, int exponent) {
        double result = 1;

        //考虑底数为0，指数为负，对0求倒数，程序会出错
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





