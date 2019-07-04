package com.algorithm.qiuzhao2020.LeetCode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题目描述：找到倒数第 k 个的元素。
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */
public class Solution_findKthLargest {
    // 第一种：自带的排序 时间复杂度 O(NlogN)，空间复杂度 O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    // 第二种：利用小顶堆 时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(); // 小顶堆，PriorityQueue默认的优先级是自然顺序（从小到大排序）
        for(int num: nums) {
            queue.add(num);
            if(queue.size() > k) { // 维护队列的大小为k 删掉前k-1个元素
                queue.poll();
            }
        }
        return queue.peek();
    }



}
