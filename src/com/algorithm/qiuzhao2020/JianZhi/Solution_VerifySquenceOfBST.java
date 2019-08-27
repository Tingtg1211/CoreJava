package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

// 思路：找住二叉查找树的特点：左子树<根<=右子树  使用分治思想
public class Solution_VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return Judge(sequence, 0, sequence.length - 1);

    }

    // 逐一验证左边<中间<右边是否成立
    private boolean Judge(int [] sequence, int start, int end) {

        if (start >= end)
            return true;
        int root = sequence[end];
        int i = start;
        while (sequence[i] < root)
            i ++;
        for (int j = i; j < end; j ++) {
            if (sequence[j] < root)
                return false;
        }
        return Judge(sequence, start + 1, i - 1) && Judge(sequence, i, end -1);
    }
}
