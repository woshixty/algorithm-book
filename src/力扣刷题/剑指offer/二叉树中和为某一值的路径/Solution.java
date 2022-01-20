package 力扣刷题.剑指offer.二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> listList = new ArrayList<>();
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return listList;
        this.target = target;
        deepVisit(root, 0);
        return listList;
    }

    public void deepVisit(TreeNode root, int sum) {
        sum += root.val;
        list.addLast(root.val);
        if (sum == target && root.right == null && root.left == null)
            listList.add(new LinkedList<>(list));
        if (root.left != null)
            deepVisit(root.left, sum);
        if (root.right != null)
            deepVisit(root.right, sum);
        list.removeLast();
    }
}
