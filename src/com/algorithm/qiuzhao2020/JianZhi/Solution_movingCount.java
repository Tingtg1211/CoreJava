package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述:
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

// 回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，
// 并在本次搜索结束之后清除状态

public class Solution_movingCount {
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;

    }

    private void dfs(boolean[][] marked, int i, int j) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || marked[i][j])
            return;
        marked[i][j] = true;
        if(this.digitSum[i][j] > this.threshold)
            return;
        cnt ++;
        for(int[] n : next) {
            dfs(marked, i + n[0], j + n[1]);
        }

    }

    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(cols, rows)];
        for(int i = 0; i < digitSumOne.length; i ++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i ++) {
            for (int j = 0; j < this.cols; j ++) {
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
