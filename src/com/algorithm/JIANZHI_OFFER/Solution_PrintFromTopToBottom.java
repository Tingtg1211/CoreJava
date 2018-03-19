package com.algorithm.JIANZHI_OFFER;

import java.util.ArrayList;

/**
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 分析：借助队列实现层次遍历可以实现题目要求，本质就是树的层次遍历

 */
public class Solution_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        //辅助队列实现层次遍历
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while (queue.size() != 0){

            //总是移除队列队头元素
            TreeNode temp = queue.remove(0);
            list.add(temp.val);
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }

        }

        return list;




    }
}
