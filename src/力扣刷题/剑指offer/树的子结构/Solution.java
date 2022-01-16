package 力扣刷题.剑指offer.树的子结构;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean judge(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || B.val != A.val)
            return false;
        return judge(A.left, B.left) && judge(A.right, B.right);
    }
}
