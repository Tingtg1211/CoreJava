package com.algorithm.JIANZHI_OFFER;

import java.util.Stack;

/**
 * 题目：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 法1分析：
 * 在二叉搜索树中，左子节点的值总是小于父节点的值，右子节点的值总是大于父节点的值。
 * 因此在将二叉搜索树转换成排序双向链表时，原先指向左子节点的指针调整为链表中指向前一个节点的指针
 * 原先指向右子节点的指针调整为链表中指向后一个节点的指针
 *
 *
 * 法2分析：
 * 先扫描根节点的所有左节点并将他们一一进栈，然后出栈一个节点（显然节点没有左孩子节点或者左孩子节点均被访问过）
 * 则访问他，然后扫描该节点的右孩子节点，将其进栈，再扫描该右孩子节点的所有左孩子节点并一一进栈，如此继续，直到栈空为止
 */


public class Solution_convert {
    //法1：递归版本(中序）
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return  null;
        if(pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //1.将左子树构造成双链表，并返回链表的头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        //2.定位至左子树双链表的最后一个节点
        while(p != null && p.right != null){
            p = p.right;
        }
        //3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //4.将右子树构造成双链表，并返回链表的头节点
        TreeNode right = Convert(pRootOfTree.right);
        //5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //6.根据左子树链表是否为空决定返回的节点
        return left != null ? left:pRootOfTree;
    }

    //法2：中序遍历的非递归版
    public TreeNode Convert_2(TreeNode pRootOfTree){
        if(pRootOfTree == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null; //用于保存中序遍历的上一个节点
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;//将中序遍历序列中的第一个节点记为root
                pre = pRootOfTree;
                isFirst = false;
            }else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }

            p = p.right;
        }
        return pRootOfTree;


    }


}
