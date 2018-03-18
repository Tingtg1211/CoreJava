package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/28
 * Time: 16:22
 */

/**
 * 题目：
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */

public class Solution_Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {

        //首先考虑其中有一个链表为空的情况
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode mergeList = null;
        ListNode current = null;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(mergeList == null){
                    mergeList = current = list1;
                }else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;

            }else {
                if(mergeList == null){
                    mergeList = current = list2;
                }else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }


        //考虑其中一个链表比较完的情况

        if(list1 == null)
            current.next = list2;
        if(list2 == null)
            current.next = list1;
        return mergeList;

    }
}
