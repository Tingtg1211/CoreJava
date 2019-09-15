package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 则最小的4个数字是1,2,3,4,。
 */
public class Solution_GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k > input.length)
            return arrayList;
        Arrays.sort(input);
        for(int i = 0; i < k; i ++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    // 使用大顶堆来维护最小堆
    // 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，
    // 如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
    // 注:此方法特别适合处理海量数据
    public ArrayList<Integer> GetLeastNumbers_2(int [] input, int k) {
        if(k > input.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // 降序
            }
        });
        for(int num : input) {
            maxHeap.add(num);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
