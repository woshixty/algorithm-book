package 力扣刷题.剑指offer.复杂链表的复制;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for (Node node = head; node != null; node = node.next.next) {
            node.next.random = node.random == null ? null : node.random.next;
        }
        Node newHead = head.next;
        for (Node node = head.next; node.next != null; node = node.next) {
            node.next = node.next.next;
        }
        return newHead;
    }
}

class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}

class Solution3 {
    public Node copyRandomList(Node head) {
        Node node = head;
        while(node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        while(node != null) {
            if (node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        node = head;
        Node newHead = head.next;
        while(node.next.next != null) {
            Node newNode = node.next;
            Node nextNode = node.next.next;
            newNode.next = newNode.next.next;
            node.next = nextNode;
            node = nextNode;
        }
        node.next = null;
        return newHead;
    }
}
