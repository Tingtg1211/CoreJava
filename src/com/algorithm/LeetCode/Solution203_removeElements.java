package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/11
 * Time: 13:51
 */

/*
 Remove all elements from a linked list of integers that have value val.

 Example:

 Input:  1->2->6->3->4->5->6, val = 6
 Output: 1->2->3->4->5
 */

public class Solution203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode prev = fakeHead;
        while (cur != null){
            if(cur.val != val){
                prev = prev.next;
            }else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }

        return fakeHead.next;//注意：在链表只有一个值且这个值刚好是val的时候，return head;错误

    }
}
