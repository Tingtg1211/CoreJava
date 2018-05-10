package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/7
 * Time: 13:58
 */

/**
 * Example 1:

  Input: 1->1->2
  Output: 1->2

  Example 2:

  Input: 1->1->2->3->3
  Output: 1->2->3
 */

public class Solution83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null){
            if(tmp.next == null){
                break;
            }
            if(tmp.next.val == tmp.val){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }
        return head;


     }
}
