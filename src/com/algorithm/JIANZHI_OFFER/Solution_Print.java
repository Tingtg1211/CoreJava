package com.algorithm.JIANZHI_OFFER;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目: 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution_Print
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        // s1存奇数层结点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        // s2存偶数层结点
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()) {
                   TreeNode node = s1.pop();
                   if (node != null) {
                       temp.add(node.val);
                       s2.push(node.left);
                       s2.push(node.right);
                   }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer ++;
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer ++;
                }
            }
        }
        return list;
    }
}
