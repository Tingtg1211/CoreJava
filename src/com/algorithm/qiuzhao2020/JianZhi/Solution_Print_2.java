package com.algorithm.qiuzhao2020.JianZhi;

import java.util.*;

/**
 * 题目描述
 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution_Print_2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;  // 标志
        while (! queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt -- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse)
                Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                lists.add(list);
        }
        return lists;
    }

    public ArrayList<ArrayList<Integer>> Print_22(TreeNode pRoot) {
        int layer = 1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.empty() || !s2.empty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (layer % 2 != 0) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        s2.add(node.left);
                        s2.add(node.right);

                    }

                }
            } else {
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        s1.add(node.right);
                        s1.add(node.left);
                    }
                }
            }
            if (temp.size() != 0) {
                lists.add(temp);
                layer ++;

            }

        }
        return lists;
    }
}
