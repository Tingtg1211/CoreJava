package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/9
 * Time: 11:43
 */

/*
 n > 2, f(n) = f(n - 1) + f(n - 2)
 */
public class Solution_jumpFloor {
    public int JumpFloor(int target) {
            if(target == 1)
                return 1;
            if(target == 2)
                return 2;
            int num1 = 1;
            int num2 = 2;
            int result = 0;

            for(int i = 3; i <= target; i ++){
               result = num1 + num2;
               num1 = num2;
               num2 = result;
            }
            return result;

    }
}
