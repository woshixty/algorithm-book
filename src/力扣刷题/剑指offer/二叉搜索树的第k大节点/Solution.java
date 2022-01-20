package 力扣刷题.剑指offer.二叉搜索树的第k大节点;

public class Solution {
    int k;
    int result;

    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return 0;
        this.k = k;
        deepVisit(root);
        return result;
    }

    public void deepVisit(TreeNode root) {
        if (root == null)
            return;
        deepVisit(root.right);
        if (--k == 0)
            result = root.val;
        deepVisit(root.left);
    }
}
