package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
   输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
   所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution_reOrderArray {
//    方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
    public void reOrderArray(int [] array) {
        int oddCnt = 0;
        // 统计出奇数的个数
        for(int x : array) {
            if(!isEven(x))
                oddCnt ++;
        }
        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for(int num : copy) {
            if(!isEven(num)) {
                array[i ++] = num;
            } else {
                array[j ++] = num;
            }

        }

    }

//    方法二：使用冒泡思想，每次都当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
    public void reOrderArray_2(int[] array) {
        for (int j = array.length - 1; j > 0; j --) {
            for (int i = 0; i < j; i ++) {
                if (isEven(array[i]) && !isEven(array[i + 1])) {
                    swap(array, i, i + 1);
                }
            }
        }

    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
