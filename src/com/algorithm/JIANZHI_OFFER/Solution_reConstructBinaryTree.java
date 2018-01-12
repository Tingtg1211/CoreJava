package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/12
 * Time: 9:39
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution_reConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;



    }

    //在二叉树的前序遍历和中序遍历序列中确定根节点的值，左子树节点的值和右子树节点的值
    private TreeNode reConstructBinaryTree(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn ){
        //递归结束的条件
      if(startIn > endIn || startPre > endPre){
          return null;
      }
      TreeNode root = new TreeNode(pre[startPre]);
      for(int i = startIn; i <= endIn; i ++){
          if(in[i] == pre[startPre]){
              root.left = reConstructBinaryTree(pre, startPre + 1, startPre + (i - startIn), in, startIn, i - 1 );

              root.right = reConstructBinaryTree(pre,startPre + (i  - startIn) + 1, endPre,  in, i + 1, endIn );
          }

      }
      return root;
    }
}
