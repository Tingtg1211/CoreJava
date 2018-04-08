package com.algorithm.LeetCode;

/**606.
 * 1.Input: Binary tree: [1,2,3,4]
     1
   /   \
  2    3
 /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".

 2.Input: Binary tree: [1,2,3,null,4]
   1
 /   \
 2    3
 \
 4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

 */
public class Solution_tree2str {
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left == "" && right == "")
            return result;
        if(left == "")
            return result + "()" + "(" + right + ")";
        if(right == "")
            return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";


    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}