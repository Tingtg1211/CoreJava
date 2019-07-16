package com.algorithm.qiuzhao2020.JianZhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */
public class Solution_duplicate {
    //  时间复杂度O(n) 空间复杂度O(n)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Map<Integer, Integer> map = new HashMap<>();
        if (length == 0) {
            duplication[0] = -1;
            return false;
        }

        for(int i: numbers) {
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }


    // 时间复杂度O(n) 空间复杂度O(1)
    public boolean duplicate_2(int numbers[],int length,int [] duplication) {
        for(int i = 0; i < length; i ++) {
            if(i == numbers[i])
                continue;
            if(numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            } else { // 将数字m放在第m个位置
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }

        }
        return false;

    }
}
