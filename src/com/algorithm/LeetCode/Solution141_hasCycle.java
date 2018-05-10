package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/10
 * Time: 20:24
 */

/**
 * Given a linked list, determine if it has a cycle in it.

   Follow up:
   Can you solve it without using extra space?
 */

/*
1.Use two pointers, walker and runner.
2.walker moves step by step. runner moves two steps at time.
3.if the Linked List has a cycle walker and runner will meet at some
point.
 */

public class Solution141_hasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            walker = walker.next;
            if(walker == runner){
                return true;
            }
        }
        return false;

    }
}
