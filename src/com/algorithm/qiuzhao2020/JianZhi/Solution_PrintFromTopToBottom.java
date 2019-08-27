package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            list.add(tmp.val);
            if (tmp.left != null)
                queue.add(tmp.left);
            if (tmp.right != null)
                queue.add(tmp.right);
        }
        return list;

    }
}
