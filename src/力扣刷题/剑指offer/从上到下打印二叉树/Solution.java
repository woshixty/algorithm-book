package 力扣刷题.剑指offer.从上到下打印二叉树;

import java.util.LinkedList;
import java.util.Queue;

//广度优先搜索
public class Solution {
    /**
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        List<TreeNode> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll);
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i).val;
        return result;
    }
     */

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        Queue<TreeNode> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.offer(poll);
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.poll().val;
        return result;
    }
}
