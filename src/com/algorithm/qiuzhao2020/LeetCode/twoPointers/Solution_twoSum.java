package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

/**
 * 题目描述：在有序数组中找出两个数，使它们的和为 target。
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution_twoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                return new int[]{i + 1, j + 1};
            }else if(sum < target) {
                i ++;
            }else {
                j --;
            }
        }
        return null;
    }

}
