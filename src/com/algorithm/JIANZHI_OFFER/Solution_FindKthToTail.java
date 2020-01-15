package com.algorithm.JIANZHI_OFFER;

import java.util.List;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/22
 * Time: 21:23
 */

/*
  题目：
  输入一个链表，输出该链表中倒数第k个结点。
  法一：第一次遍历计算出节点的个数为num个，第二次遍历找出倒数第k个节点，即正数第num-k+1个
  法二：定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；从第k步开始
  ，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1，当走在前面的指针到达链表的尾节点时，走在后面的
  指针正好指向倒数第k个节点。
 */

/*
public class Solution_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        int num = 0;
        if(head == null)
            return null;
        ListNode  temp = head;
        for(; temp != null; temp = temp.next){
            num ++;
        }
        if(k > num)
            return null;
        //倒数第k个即正数第num-k—+1个
        for(int j = 1; j < num - k + 1; j ++){
            head = head.next;
        }
        return head;
    }
}
*/


public class Solution_FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;

        ListNode pre = head;
        ListNode last = head;


        for(int i = 0; i < k - 1; i ++){
            if(pre.next != null){
                pre = pre.next;
            }else {
                return null;
            }

        }
        while (pre.next != null){
            last = last.next;
            pre = pre.next;
        }
        return last;


    }
}