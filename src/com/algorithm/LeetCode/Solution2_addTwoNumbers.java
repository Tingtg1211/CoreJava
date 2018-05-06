package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/6
 * Time: 19:49
 */

/**
 *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *Output: 7 -> 0 -> 8
 *Explanation: 342 + 465 = 807.
 */

public class Solution2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sumList = new ListNode(0);
        ListNode temp = sumList;
        int sum = 0;
        while(c1 != null || c2 != null){
            sum /= 10;
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            temp.next = new ListNode(sum % 10);
            temp = temp.next;

        }
        if(sum / 10 == 1){
            temp.next = new ListNode(1);

        }
        return sumList.next;

    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) { val = x; }
  }
