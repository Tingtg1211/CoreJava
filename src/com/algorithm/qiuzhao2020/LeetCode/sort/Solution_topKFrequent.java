package com.algorithm.qiuzhao2020.LeetCode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：出现频率最多的k个元素
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */

// 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
//
//把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。

public class Solution_topKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for(int num : nums) { // 统计数组中每个数字出现的频率,注意getOrDefault()的用法
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        // 将出现频率相同的数字放在同一个桶中(数组里每个元素都是个链表)
        List<Integer> [] bucket = new ArrayList[nums.length + 1];
        for(int key: frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);

        }

        List<Integer> topK = new ArrayList<>(); // 存放出现频率最高的k个数容器
        for(int i = bucket.length - 1; i >= 0 && topK.size() < k; i --) {
            if(bucket[i] == null)
                continue;
            if(bucket[i].size() <= (k- topK.size())) {
                topK.addAll(bucket[i]);
            } else{
                topK.addAll(bucket[i].subList(0, k - topK.size()));
            }
        }
        return topK;

    }
}
