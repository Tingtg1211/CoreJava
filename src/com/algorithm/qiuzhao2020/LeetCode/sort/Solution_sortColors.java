package com.algorithm.qiuzhao2020.LeetCode.sort;

/**
 * 题目：按颜色进行排序
 *
 * 只有0/1/2三种颜色
 */
public class Solution_sortColors {
    public void sortColors(int[] nums) {
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) {
                num0 ++;
            } else if(nums[i] == 1) {
                num1 ++;
            } else {
                num2 ++;
            }

        }
        for(int i = 0; i < num0; i ++) nums[i] = 0;
        for(int i = 0; i < num1; i ++) nums[num0 + i] = 1;
        for(int i = 0; i < num2; i ++) nums[num0 + num1 + i] = 2;
    }

    public void sortColors_2(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            }else if(nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            }else if(nums[i] == 2) {
                nums[++n2] = 2;
            }
        }

    }
}
