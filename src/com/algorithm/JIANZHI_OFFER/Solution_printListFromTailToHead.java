package com.algorithm.JIANZHI_OFFER;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/12
 * Time: 9:15
 */

/*
class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
}

public class Solution_printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();

        //没经过一个节点的时候，把该节点放到栈中
        while(listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        //当遍历完整个链表后，再从栈顶开始逐个输出节点的值
        while (! stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;



    }
}
*/


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution_printListFromTailToHead {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }


        return arrayList;

    }
}