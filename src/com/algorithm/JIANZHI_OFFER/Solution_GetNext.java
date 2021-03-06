package jianzhi;

/**
 * 题目:二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

public class Solution_GetNext
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        if (pNode.right != null) { // 如果有右子树，则找右子树的最左结点
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        while (pNode.next != null) { // 如果没有右子树，则找第一个当前节点是其左孩子的父节点
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;
    
    TreeLinkNode(int val) {
        this.val = val;
    }
}
