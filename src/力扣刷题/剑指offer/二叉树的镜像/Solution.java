package 力扣刷题.剑指offer.二叉树的镜像;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = root.left;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
