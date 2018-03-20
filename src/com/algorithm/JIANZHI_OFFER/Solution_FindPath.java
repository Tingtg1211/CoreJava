package com.algorithm.JIANZHI_OFFER;
import java.util.ArrayList;

/**
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 分析：
 * 1.当用前序遍历的方式访问到某一节点时，我们把该节点添加到路径上，并累加该节点的值
 * 2.如果该节点为叶节点，并且路径中节点值的和刚好等于输入的整数，则当前路径符合要求，我们打印出来
 * 3.如果当前节点不为叶节点，则继续访问它的子节点。
 * 4.当前节点访问结束后，递归函数将自动回到它的父节点，注意要在函数退出之前要在路径上删除当前节点并减去
 * 当前节点的值。

 */
public class Solution_FindPath {
    //建立一个保存节点的list
    private ArrayList<Integer> list = new ArrayList<>();
    //建立一个保存路径的listAll
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            listAll.add(new ArrayList<Integer>(list));//不重新new的话从始至终listAll中所有引用都指向了同一个一个list
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;



    }





}
