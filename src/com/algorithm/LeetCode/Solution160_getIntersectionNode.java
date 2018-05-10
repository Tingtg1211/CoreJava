package com.algorithm.LeetCode;

/**
 * Author: GAO_TING_T11
 * Date: 2018/5/10
 * Time: 20:33
 */

/**
 * For example, the following two linked lists:

 A:          a1 → a2
                    ↘
                     c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 Notes:

 1.If the two linked lists have no intersection at all, return null.
 2.The linked lists must retain their original structure after the function returns.
 3.You may assume there are no cycles anywhere in the entire linked structure.
 4.Your code should preferably run in O(n) time and use only O(1) memory.
 */


public class Solution160_getIntersectionNode {
    //1, Get the length of the two lists.

    //2, Align them to the same start point.

    //3, Move them together until finding the intersection point, or the end null

    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {

        //1, Get the length of the two lists.
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        //2, Align them to the same start point.
        while (lenA > lenB){
            headA = headA.next;
            lenA --;
        }
        while (lenB > lenA){
            headB = headB.next;
            lenB --;
        }

        //3, Move them together until finding the intersection point, or the end null
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;




    }
    private int getLength(ListNode node){
        int len = 0;
        while(node != null){
            len ++;
            node = node.next;
        }
        return len;
    }

    //我们可以使用两个迭代来完成这个任务。在第一次迭代中，我们将把一个linkedlist的指针重置到另一个linkedlist的头部，在它到达尾节点之后。
    // 在第二个迭代中，我们将移动两个指针，直到它们指向同一个节点。我们在第一次迭代中的操作将帮助我们抵消这种差异(长度不同的差异）。
    // 因此，如果两个linkedlist相交，第二个迭代的相遇点必须是交点。
    // 如果两个链表没有交集，那么第二个迭代中的会议指针必须是两个列表的尾部节点，它是null

    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;

    }


}
