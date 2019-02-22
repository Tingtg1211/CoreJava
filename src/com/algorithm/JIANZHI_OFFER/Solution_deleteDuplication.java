package jianzhi;

/**
 * 题目：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */


public class Solution_deleteDuplication
{
    /**
     * 分析:
     * 化繁为简，先找到第一个符合的节点，以后递归
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        
        // 两个循环，处理1-1-1-2-2-2-3-3-4-5有连续重复节点的情况
        while (pHead != null && pHead.next != null && pHead.val == pHead.next.val) {
            while (pHead != null && pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        if (pHead != null) {
            pHead.next = deleteDuplication(pHead.next);
        }
        return pHead;
    
    }
    
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        if (pHead.val == pHead.next.val) { //当前节点是重复节点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前节点相同的全部节点，找到第一个与当前节点不同的节点
                pNode = pNode.next;
            }
            // 从第一个与当前节点不同的节点开始递归
            return deleteDuplication_2(pNode);
        } else { // 当前节点不是重复节点
            // 保留当前节点，从下一个节点开始递归
            pHead.next = deleteDuplication_2(pHead.next);
            return pHead;
        }
    }
}
