package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;

/**
 * 题目描述
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution_printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i ++)
                ret.add(matrix[r1][i]);

            for (int j = r1 + 1; j <= r2; j ++)
                ret.add(matrix[j][c2]);
            // 中间只剩一行或者一列 不走以下的从右往左和从下往上的逻辑
            if (r1 != r2) {
                for (int m = c2 - 1; m >= c1; m --)
                    ret.add(matrix[r2][m]);
            }
            if (c1 != c2) {
                for (int n = r2 - 1; n > r1; n --)
                    ret.add(matrix[n][c1]);
            }

            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ret;

    }
}
