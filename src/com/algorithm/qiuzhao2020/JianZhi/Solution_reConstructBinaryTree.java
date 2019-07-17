package com.algorithm.qiuzhao2020.JianZhi;


/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Solution_reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int [] pre, int preStart, int preEnd, int [] in, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= inEnd; i ++) {
            if(in[i] == pre[preStart]) {
                root.left = reConstructBinaryTree(pre, preStart + 1 , preStart + (i - inStart) , in, inStart,i - 1);
                root.right = reConstructBinaryTree(pre, preStart + (i - inStart) + 1, preEnd, in, i + 1, inEnd);
            }

        }
        return root;
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}




