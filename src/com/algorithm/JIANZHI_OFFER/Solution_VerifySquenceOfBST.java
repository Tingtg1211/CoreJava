package com.algorithm.JIANZHI_OFFER;

/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 注意：二叉搜索树是二叉排序树！！
 */
public class Solution_VerifySquenceOfBST {


     public static boolean VerifySquenceOfBST(int [] sequence) {
         if(sequence.length == 0) {
             return false;
         }
         if(sequence.length == 1){
           return true;
        }
           return judge(sequence,0,sequence.length-1);
     }
     public static boolean judge(int [] sequence, int first, int last) {

        if(first >= last){
            return true;
        }
        //后序遍历序列最后一个节点是根节点
        int root = sequence[last];
        //在二叉搜索树中左子树的节点的值小于根节点
        int i = first;
        while(sequence[i] < root){
            i ++;
        }
        //右子树的节点的值大于根节点的值
        int j = i;
        for(; j < last; j ++){
            if(sequence[j] < root){
                return false;
            }
        }
        return judge(sequence, first, i - 1) && judge(sequence, j, last - 1);





    }

}
