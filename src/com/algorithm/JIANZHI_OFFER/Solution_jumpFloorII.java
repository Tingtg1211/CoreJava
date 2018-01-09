package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/9
 * Time: 11:51
 */

public class Solution_jumpFloorII {
    public int JumpFloorII(int target) {
            if(target < 1){
                return -1;
            }else if(target == 1){
                return 1;
            }else {
                return 2 * JumpFloorII(target - 1);
            }

    }
}
