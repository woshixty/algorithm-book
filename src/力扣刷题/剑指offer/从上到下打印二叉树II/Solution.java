package 力扣刷题.剑指offer.从上到下打印二叉树II;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list1.add(poll.val);
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            result.add(list1);
        }
        return result;
    }
}
