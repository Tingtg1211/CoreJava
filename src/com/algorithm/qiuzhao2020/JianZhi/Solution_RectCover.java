package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution_RectCover {
    public int RectCover(int target) {
        if(target <= 2)
            return target;
        return RectCover(target - 1) + RectCover(target - 2);

    }

    public int RectCover_2(int target) {
        if(target <= 2)
            return target;
        int pre1 = 2;
        int pre2 = 1;
        int res = 0;
        for (int i = 0; i < target; i ++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}
