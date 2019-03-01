package jianzhi;

import java.util.Stack;

/**
 * 题目: 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution_KthNode
{
    // 中序遍历的非递归写法，遍历时，判断是否到第K个，如果是直接跳出，完成
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (pRoot != null || !stack.isEmpty()) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else {
                pRoot = stack.pop();
                if (k == count + 1) {
                    return pRoot;
                }else {
                    count ++;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
