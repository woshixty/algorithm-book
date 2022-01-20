package 力扣刷题.剑指offer.二叉搜索树与双向链表;

public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    public Node pre;
    public Node head;

    public Node treeToDoublyList(Node root) {
        if (head == null)
            return null;
        deepVisit(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void deepVisit(Node node) {
        if (node == null)
            return;
        deepVisit(node.left);
        if (pre == null)
            head = node;
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        deepVisit(node.right);
    }
}
