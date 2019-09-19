package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution_IsBalanced {
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        // 计算二叉树的高度
        height(root);
        return isBalanced;

    }
    private int height(TreeNode root) {
        if(root == null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);

    }

}
