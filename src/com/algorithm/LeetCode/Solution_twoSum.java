package com.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/4
 * Time: 11:13
 */

/*
  Example:
  Given nums = [2, 7, 11, 15], target = 9,
  Because nums[0] + nums[1] = 2 + 7 = 9,
  return [0, 1].
 */


public class Solution_twoSum {
    //O(n)解法，空间换时间
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(hashMap.containsKey(target - nums[i])){
                results[1] = i;
                results[0] = hashMap.get(target - nums[i]);//小下标，因为是先判断值后添加的元素。
                break;
            }else {
                hashMap.put(nums[i], i);
            }
        }

        return results;
    }


    //暴力解法，O(n2)
    public int[] twoSum2(int[] nums, int target){
        int[] results = new int[2];
        for(int i = 0; i < nums.length; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                if(nums[i] + nums[j] == target){
                    results[0] = i;
                    results[1] = j;
                    break;
                }
            }
        }
        return results;
    }

}
