package com.algorithm.qiuzhao2020.LeetCode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按照字符出现次数对字符串排序
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class Solution_frequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for(char c : s.toCharArray()) {
            frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for(char c : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(c);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        StringBuilder str = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i --) {
            if(buckets[i] == null)
                continue;
            for(char c: buckets[i]) {
                for(int j = 0; j < i; j ++){ //保证出现n次的字母能够添加n次
                    str.append(c);

                }

            }
        }
        return str.toString();

    }
}
