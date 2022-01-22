package 力扣刷题.剑指offer.平衡二叉树;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        if (left == -1)
            return -1;
        int right = maxDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right);
    }
}