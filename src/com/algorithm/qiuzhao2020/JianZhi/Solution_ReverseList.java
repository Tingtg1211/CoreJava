package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
   输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution_ReverseList {
    // 使用头插法
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newList = new ListNode(-1); // 头节点
        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;

    }
}
