package jianzhi;

public class Solution_IsBalanced {
    // 法一：遍历每一个节点，借助一个获取树深度的递归函数，根据该节点的左右子树高度差判断是否平衡，然后递归的对左右子树进行判断
    // 但是在判断上层节点的时候，会多次重复遍历下层节点，增加了不必要的开销
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(MaxDepth(root.left) - MaxDepth(root.right)) <= 1 && IsBalanced_Solution(root.right) &&
                IsBalanced_Solution(root.left);
    }
    
    private int MaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
    }
    
    // 法二：用后序遍历的方式遍历二叉树的每个节点，那么在遍历到一个节点之前我们就已经遍历了她的左右子树
    // 在遍历某节点的左右子节点后，我们可以根据他的左右子节点的深度判断他是不是平衡的，并得到当前节点的深度
    // 当最后遍历到树的根节点的时候，也就判断了整棵二叉树是不是平衡二叉树
    public boolean IsBalanced_Solution_2(TreeNode root) {
        return GetDepth(root) != -1;
    }
    public int GetDepth(TreeNode root) {
        if (root == null) return 0;
        int left = GetDepth(root.left);
        if (left == -1) return -1;
        int right = GetDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
