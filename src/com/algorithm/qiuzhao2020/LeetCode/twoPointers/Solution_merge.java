package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */

// 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
public class Solution_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if(index1 < 0) { // nums1的比较结束
                nums1[mergeIndex --] = nums2[index2 --];
            } else if (index2 < 0) { // nums2的比较结束
                nums1[mergeIndex --] = nums1[index1 --];
            } else if (nums1[index1] > nums2 [index2]) {
                nums1[mergeIndex --] = nums1[index1 --];
            } else {
                nums1[mergeIndex --] = nums2[index2 --];
            }
        }

    }
}
