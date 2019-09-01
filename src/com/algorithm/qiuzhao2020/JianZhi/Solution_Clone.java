package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution_Clone {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;

        // 第一步，在每个节点的后面插入复制的节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // 第二步，对复制节点的random链接进行赋值
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        // 第三步，拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;

    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
