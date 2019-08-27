package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;

/**
 * 题目描述
 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往
 下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution_FindPath {
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list)); // add的是一个引用,以防后续操作更改
        }
        if (root.left != null) {
            FindPath(root.left, target);
        }
        if (root.right != null) {
            FindPath(root.right, target);
        }
        list.remove(list.size() - 1); // 遍历到叶子节点回退到父节点
        return listAll;

    }
}
