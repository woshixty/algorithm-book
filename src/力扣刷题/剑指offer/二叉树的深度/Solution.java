package 力扣刷题.剑指offer.二叉树的深度;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int a = 1 + maxDepth(root.left);
        int b = 1 + maxDepth(root.right);
        return a > b ? a : b;
    }
}
