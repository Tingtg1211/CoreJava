package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

/**
 * 分析:
 * 1.如何确定链表中包含环？
 * 定义两个指针，同时从链表的头结点出发，如果走的快的指针追上走的慢的指针，说明有环
 * 如果走的快的指针走到了链表的末尾，都没有追上第一个指针，就不包含环
 *
 * 2.如何找到环的入口？
 * 假设环有n个节点，则指针p1先在链表上向前移动n步，然后两个指针以相同速度向前移动，当第二个指针指向环的入口节点时，第一个指针已经回到了入口节点
 *
 * 3.如何得到环中节点的数目？
 * 两个指针相遇的节点一定是在环中。可以从这个节点出发，一边继续向前移动一边计数，当再次回到这个节点时，就可以得到环中节点数
 */
public class Solution_EntryNodeOfLoop {
    // 找到一快一慢指针相遇的节点，相遇的节点一定是在环中某一点, 快指针一次走两步,慢指针一次走一步
    public  static ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head.next;
        if (slow == null)
            return null;
        ListNode fast = slow.next;
        while (fast != null && slow !=null) {
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)  // 防止空指针异常
                fast = fast.next;
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null)
            return null;
        // 得到环中节点的数
        int num = 1; // 只要有环，节点数至少为1
        ListNode p1 = meetingNode.next;
        while (p1 != meetingNode) {
            p1 = p1.next;
            num ++;
        }

        // 得到环中节点数后,去找环的入口
        p1 = pHead;
        for (int i = 0; i < num; i ++) {
            p1 = p1.next;
        }
        ListNode p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * 使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。
     * 因为存在环，所以两个指针必定相遇在环中的某个节点上。假设相遇点在下图的 z1 位置，
     * 此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，由于 fast 速度比 slow 快一倍，因此 x+2y+z=2(x+y)，
     * 得到 x=z。在相遇点，slow 要到环的入口点还需要移动 z 个节点，
     * 如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，那么它到环入口点还需要移动 x 个节点。
     * 在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。
     */
    public ListNode EntryNodeOfLoop_2(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
