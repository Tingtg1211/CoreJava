package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution_Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null)
            return list;
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> layer = new LinkedList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while (layer.size() != 0) {
            TreeNode tmp = layer.remove();
            temp.add(tmp.val);
            start ++;
            if (tmp.left != null)
                layer.add(tmp.left);
            if (tmp.right != null)
                layer.add(tmp.right);
            if (start == end) {  // 使用计数器，当遍历完一层后，清空计数器
                start = 0;
                end = layer.size();
                list.add(temp);
                temp = new ArrayList<>();
            }
        }
        return list;
    }

    ArrayList<ArrayList<Integer>> Print_2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();  // poll 在队列为空时返回null 注意与remove的区别
                if (node == null) // 检查队列空节点的情况
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }

}
