package 力扣刷题.剑指offer.从上到下打印二叉树III;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        //flag为真从左往右，否则从右往左
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                if (flag) {
                    //从左往右
                    TreeNode poll = queue.pollFirst();
                    list1.add(poll.val);
                    if (poll.left != null)
                        queue.offerLast(poll.left);
                    if (poll.right != null)
                        queue.offerLast(poll.right);
                } else {
                    //从右往左
                    TreeNode poll = queue.pollLast();
                    list1.add(poll.val);
                    if (poll.right != null)
                        queue.offerFirst(poll.right);
                    if (poll.left != null)
                        queue.offerFirst(poll.left);
                }
            }
            flag = !flag;
            result.add(list1);
        }
        return result;
    }
}
