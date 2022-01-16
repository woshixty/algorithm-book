package 力扣刷题.剑指offer.对称的二叉树;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return judgeEquals(root.left, root.right);
    }

    public boolean judgeEquals(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        else
            return judgeEquals(left.left, right.right)
                    &&
                    judgeEquals(left.right, right.left);
    }
}
