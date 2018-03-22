package com.algorithm.JIANZHI_OFFER;

import com.itcast.homework_11.h_01.h_02.NewPhone;

/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */



class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}


public class Solution_clone {
    public RandomListNode Clone(RandomListNode pHead){
        //1.根据原始链表的每个节点N创建对应的N',把N'链接到N后面

        if(pHead == null)
            return null;
        RandomListNode pCur = pHead;
           //执行插入克隆节点
        while(pCur != null){
            RandomListNode cloneNode = new RandomListNode(pCur.label);

            cloneNode.next = pCur.next;
           // node.random = null;
            pCur.next = cloneNode;
            pCur = cloneNode.next;
        }

        pCur = pHead;
        //2.假设原始链上的N的random指向节点S，那么其对应复制出来的N'是N的next指向的节点，
        //同样S'是S的next指向的节点
        while (pCur != null){
            if(pCur.random != null){
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;

        }

        //3.把奇数位置的节点链接起来是原始链表，偶数位置的节点链接起来是复制出来的链表
        RandomListNode cloneHead = pHead.next;
        RandomListNode cloneCur = cloneHead;
        pCur = pHead;
        while(pCur != null){
            pCur.next = pCur.next.next;
            if(cloneCur.next != null)
               cloneCur.next = cloneCur.next.next;
            cloneCur = cloneCur.next;
            pCur = pCur.next;
        }
        return cloneHead;



    }



}
