package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * [2,3,4,1]是[1,2,3,4]的旋转数组
 * [1,1,1,0,1]是[0,1,1,1,1]的旋转数组
 */
public class Solution_minNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if(array[mid] == array[left] && array[mid] == array[right]){
                return minInOrder(array, left, right);
            } else if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[right];

    }

    public int minInOrder(int [] array, int l, int r) {
        for (int i = l; i < r; i ++) {
            if(array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }
        return array[l];
    }
}
