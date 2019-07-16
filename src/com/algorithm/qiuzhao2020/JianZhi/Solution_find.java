package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Solution_find {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        while (rows == 0 || cols == 0 || array == null)
            return false;
        int r = 0, c= cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target < array[r][c]) {
                c --;
            } else {
                r ++;
            }
        }
        return false;
    }

}
