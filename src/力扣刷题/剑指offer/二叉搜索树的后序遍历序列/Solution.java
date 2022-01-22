package 力扣刷题.剑指offer.二叉搜索树的后序遍历序列;

public class Solution {
    int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return deepVisit(0, postorder.length - 1);
    }
    public boolean deepVisit(int begin, int end) {
        if (end - begin <= 0)
            return true;
        int i;
        for (i = begin; i < end; i++)
            if (postorder[i] > postorder[end])
                break;
        for (int j = i + 1; j < end; j++)
            if (postorder[i] < postorder[end])
                return false;
        return deepVisit(begin, i - 1) && deepVisit(i + 1, end);
    }
}
