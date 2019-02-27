package jianzhi;

/**
 * 题目:对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution_isSymmetrical
{
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return f(pRoot.left, pRoot.right);
        
    
    }
    
    boolean f(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
                return true;
        if (t1 != null && t2 != null)
            return t1.val == t2.val && f(t1.left, t2.right) && f(t1.right, t2.left);
        return false;
    }
}
