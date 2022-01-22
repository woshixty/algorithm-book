package 力扣刷题.剑指offer.重建二叉树;

public class Solution {
    int[] preorder;
    int[] inorder;
    int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, inorder.length - 1);
    }

    public TreeNode build(int begin, int end) {
        TreeNode treeNode = new TreeNode(preorder[pre]);
        int mid = 0;
        for (int i = begin; i <= end; i++)
            if (inorder[i] == preorder[pre]) {
                mid = i;
                break;
            }
        if (mid - begin > 0) {
            pre++;
            treeNode.left = build(begin, mid - 1);
        }
        if (end - mid > 0) {
            pre++;
            treeNode.right = build(mid + 1, end);
        }
        return treeNode;
    }
}
