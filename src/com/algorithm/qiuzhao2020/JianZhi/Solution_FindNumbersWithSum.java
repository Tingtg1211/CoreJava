package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;

/**
 * 题目描述
 输入一个递增排序的数组和一个数字S，
 在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int start = 0, end = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length < 2 || array == null) {
            return list;
        }
        while (start <= end) {
            if(array[start] + array[end] == sum) {
                list.add(array[start]);
                list.add(array[end]);
                return list;
            } else if (array[start] + array[end] < sum) {
                start ++;
            } else {
                end --;
            }
        }
        return list;


    }
}
