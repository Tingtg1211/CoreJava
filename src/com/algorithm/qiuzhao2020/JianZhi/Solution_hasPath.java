package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */

// 递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，
// 就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到到达末尾或者不满足递归条件就停止。
public class Solution_hasPath {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cols;
    private int rows;
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols ==0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for(int i = 0; i < rows; i ++) { // 遍历矩阵，找到和str字符串第一个匹配的矩阵元素，进入回溯
            for(int j = 0; j < cols; j ++) {
                if(backtracking(matrix, str, marked, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked,
                                 int pathLen, int r, int c) {
        if(pathLen == str.length) return true; // 遍历到最后一个字符
        if(c < 0 || r < 0 || c >= cols || r >= rows || marked[r][c] || matrix[r][c] != str[pathLen])
            return false;
        marked[r][c] = true;
        for(int[] n : next) {
            if(backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        }
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] chars) {
        char[][] matrix = new char[rows][cols];
        for(int i = 0, idx = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                matrix[i][j] = chars[idx ++];
            }
        }
        return matrix;
    }
}
