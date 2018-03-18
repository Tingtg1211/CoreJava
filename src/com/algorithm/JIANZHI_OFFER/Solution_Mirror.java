package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/31
 * Time: 16:40
 */


import sun.reflect.generics.tree.Tree;

/**
 * 题目：
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 二叉树的镜像定义：源二叉树
   8
  /  \
  6    10
 / \  / \
 5  7 9 11
 镜像二叉树
   8
  /  \
  10   6
 / \  / \
 11 9 7  5
 */

public class Solution_Mirror {
    public void Mirror(TreeNode root) {
        //先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换他的子节点，直到交换完所有的非叶子节点
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);


    }
}
