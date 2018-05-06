package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/6
 * Time: 20:59
 */

import java.util.List;

/**
 * Example:

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution19_removeNthFromEnd {
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode tmp = head;
        int num = 0;
        for(; tmp != null; tmp = tmp.next){
            num ++;
        }
        if(n > num || n == 0){
            return null;
        }
        ListNode tmp2 = head;
        for(int i = 1; i < num - n; i ++){
            tmp2 = tmp2.next;
        }
        if(n == num){      //考虑删除第一个节点的情况
            return head.next;
        }


        if(n == 1){  //考虑删除最后一个节点的情况
            tmp2.next = null;

        }else{
            tmp2.next = tmp2.next.next;

        }

        return head;
    }

    public ListNode removeNthFromEnd_2(ListNode head, int n){
        if(head == null){
            return null;
        }
        ListNode start = new ListNode(0); //设置头节点的目的：处理删除（正数第一个节点）的情况
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;
        for(int i = 1; i <= n; i ++){
            if(fast.next != null){
                fast = fast.next;
            }else{
                return null;
            }
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;  //重要:考虑节点数目为1的情况，不能return head;


    }

}
