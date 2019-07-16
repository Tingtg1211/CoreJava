package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头反过来打印出每个结点的值。
 */

public class Solution_printListFromTailToHead {

    // 1.遍历链表将结点的值放到栈中存储
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null ) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (! stack.isEmpty()) {
            list.add(stack.pop()); // pop查看栈顶元素并移除，peek查看栈顶元素不移除

        }
        return list;

    }

    // 2.使用头插法
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        ListNode head = new ListNode(-1); // 头节点
        // 头插法构建链表
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        head = head.next;
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;

    }

    // 3.递归
    public ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null) {
            arrayList.addAll(printListFromTailToHead_3(listNode.next));
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
