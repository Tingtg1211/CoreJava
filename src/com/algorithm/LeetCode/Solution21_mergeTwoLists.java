package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/6
 * Time: 22:44
 */

/**
 * Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4

 */

public class Solution21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //考虑一个链表为空的情况
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode merge = null;
        ListNode current = null;   //辅助链表

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(merge == null){
                    merge = current = l1;
                }else {
                    current.next = l1;
                    current = current.next;
                }
                l1 = l1.next;
            }else {
                if(merge == null){
                    merge = current = l2;
                }else {
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }

        //考虑其中一个链表比较完的情况
        if(l1 == null){
            current.next = l2;
        }

        if(l2 == null){
            current.next = l1;
        }
        return merge;

    }


//
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode merge = new ListNode(0);
        ListNode result = merge;
        while (l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                merge.next = new ListNode(l1.val);
                l1 = l1.next;
                merge = merge.next;

            }else{
                merge.next = new ListNode(l2.val);
                l2 = l2.next;
                merge = merge.next;


             }


        }
        if(l2 == null){
            merge.next = l1;
        }
        if(l1 == null){
            merge.next = l2;
        }
        return result.next;

    }
}
