package jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目: 把二叉树打印成多行
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class Solution_Print_2
{
    // 用队列linkedlist完成层序遍历,用end记录每层节点数目,节点数满后遍历下一层
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null)
            return list;
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> layer = new LinkedList<>();
        ((LinkedList<TreeNode>)layer).add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            // remove方法移除并返回队列头部的元素
            TreeNode node = layer.remove();
            temp.add(node.val);
            start ++;
            if (node.left != null) {
                ((LinkedList<TreeNode>)layer).add(node.left);
            }
            if (node.right != null) {
                ((LinkedList<TreeNode>)layer).add(node.right);
            }
            if (start == end) {
                end = layer.size();
                start = 0;
                list.add(temp);
                temp = new ArrayList<Integer>();
            }
        }
        return list;
    
    }
}
