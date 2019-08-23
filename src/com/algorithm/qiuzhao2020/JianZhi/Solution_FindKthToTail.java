package com.algorithm.qiuzhao2020.JianZhi;

import java.util.LinkedHashSet;

/**
 * 题目描述
   输入一个链表，输出该链表中倒数第k个结点。
 */

// 设置两个指针，p1，p2，先让p2走k-1步，然后再一起走，直到p2为最后一个 时，p1即为倒数第k个节点
public class Solution_FindKthToTail {
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if(head == null || k <= 0)
                return null;
            ListNode p2 = head;
            while (p2 != null && k > 0) {
                p2 = p2.next;
                k --;
            }
            if (k > 0) return null;  // k大于节点总数
            ListNode p1 = head;
            while (p2 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;

        }

        public ListNode FindKthToTail_2(ListNode head,int k) {
            if(head == null || k <= 0)
                return null;
            ListNode tmp = head;
            int cnt = 0;
            while (tmp != null) {
                cnt ++;
                tmp = tmp.next;
            }
            if(cnt < k)
                return null;
            for(int i = 0; i < cnt - k; i ++) {
                head = head.next;
            }
            return head;
        }
    }
}
