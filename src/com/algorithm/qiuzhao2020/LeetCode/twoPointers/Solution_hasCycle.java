package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

/**
 * 题目：判断链表是否有环
 *
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 */
public class Solution_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2)
                return true;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
class ListNode {
    int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }