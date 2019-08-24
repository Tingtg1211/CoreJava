package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 请实现一个函数，用来判断一颗二叉树是不是对称的。
 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution_isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return f(pRoot.left, pRoot.right);
    }

    boolean f(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)
            return true;
        if(node1 != null && node2 != null)
            return node1.val == node2.val && f(node1.left, node2.right) && f(node1.right, node2.left);
        return false;
    }
}

