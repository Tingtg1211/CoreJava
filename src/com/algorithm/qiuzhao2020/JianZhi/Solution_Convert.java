package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Stack;

/**
 * 题目描述
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
 只能调整树中结点指针的指向。
 */
public class Solution_Convert {

//    解题思路：递归版
//       1.将左子树构造成双链表，并返回链表头节点。
//       2.定位至左子树双链表最后一个节点。
//       3.如果左子树链表不为空的话，将当前root追加到左子树链表。
//       4.将右子树构造成双链表，并返回链表头节点。
//       5.如果右子树链表不为空的话，将该链表追加到root节点之后。
//       6.根据左子树链表是否为空确定返回的节点。
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 2.定位至左子树双链表的最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 4.将右子树构造成双链表，并返回链表头节点。
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null ? pRootOfTree : left;

    }

    // 解题思路：非递归版
    // 核心是中序遍历的非递归算法
    // 修改当前遍历节点与前一遍历节点的指针指向
    public TreeNode Convert_2(TreeNode pRoot) {
        if (pRoot == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        TreeNode pre = null; // 指向中序遍历的前一个节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst) {
                pRoot = p; // 将中序遍历的第一个节点记为链表的第一个节点
                pre = pRoot;
                isFirst = false;
            } else {
                p.left = pre;
                pre.right = p;
                pre = p;
            }
            p = p.right;
        }
        return pRoot;
    }
 }
