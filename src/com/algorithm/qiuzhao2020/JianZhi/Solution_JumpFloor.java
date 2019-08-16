package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution_JumpFloor {
    public int JumpFloor(int target) {
        if (target <= 2)
            return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }
    public int JumpFloor_2(int target) {
        if (target <= 2)
            return target;
        int pre1 = 2;
        int pre2 = 1;
        int res = 0;
        for(int i = 3; i <= target; i ++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;

    }
}
