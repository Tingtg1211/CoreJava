package com.algorithm.qiuzhao2020.JianZhi;

import java.util.LinkedList;

public class Solution_FindFirstCommonNode {
    // 设链表A的长度为a+c，b的长度为b+c，则a+c+b=b+c+a
    // 当访问链表A的指针访问到链表尾部时，令他从链表B的头部重新开始访问链表B;同样地，当访问链表B的指针访问到
    // 链表尾部时，令他从链表A的头部重新开始访问链表A。这样就能控制访问A和B两个链表的指针能同时访问到交点

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null)? pHead2 : p1.next;
            p2 = (p2 == null)? pHead1 : p2.next;
        }
        return p1;
    }

    public ListNode FindFirstCommonNode_3(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        if(pHead1 == null || pHead2 == null)
            return null;
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        if(len1 - len2 >= 0) {
            int len = len1 - len2;
            while (len > 0) {
                p1 = p1.next;
                len --;
            }
        }else {
            int len = len2 - len1;
            while (len > 0) {
                p2 = p2.next;
                len --;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }
    private int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len ++;
            node = node.next;
        }
        return len;

    }

}
