package com.algorithm.qiuzhao2020.JianZhi;

import java.util.HashMap;

/**
 * 题目描述
 统计一个数字在排序数组中出现的次数。
 */
public class Solution_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i ++) {
            if(map.containsKey(array[i])) {
                int times = map.get(array[i]);
                map.put(array[i], ++times);
            } else {
                map.put(array[i], 1);
            }
        }
        if(map.get(k) == null) {
            return 0;
        }else {
            return map.get(k);
        }

    }

    // //由于数组有序，所以使用二分查找方法定位k的第一次出现位置和最后一次出现位置
    public int GetNumberOfK_2(int [] array, int k) {
        int first = getStart(array, k);
        int last = getEnd(array, k);
        return last - first + 1;



    }
    private int getStart(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if(k <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) /2;
        }
        return start;
    }

    private int getEnd(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (k < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) /2;

        }
        return end;
    }
}
