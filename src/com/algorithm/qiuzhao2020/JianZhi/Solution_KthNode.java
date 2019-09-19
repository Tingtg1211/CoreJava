package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Stack;

/**
 * 题目描述
 给定一棵二叉搜索树，请找出其中的第k小的结点。例如，
 （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution_KthNode {
    // 利用二叉查找树中序遍历有序的特点
    private TreeNode ret;
    private int cnt = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        InOrder(pRoot, k);
        return ret;

    }
    private void InOrder(TreeNode node, int k) {
        if (node == null || cnt >= k) {
            return;
        }

        InOrder(node.left, k);
        cnt ++;
        if( k == cnt) {
            ret = node;
        }
        InOrder(node.right, k);

    }

    TreeNode KthNode_2(TreeNode pRoot, int k) {
        if (pRoot == null)
            return null;
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || ! stack.isEmpty()) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if(k == cnt + 1) {
                    return pRoot;
                } else {
                    cnt ++;
                }
                pRoot = pRoot.right;
            }

        }
        return null;
    }
}
