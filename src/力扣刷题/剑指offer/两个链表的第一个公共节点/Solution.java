package 力扣刷题.剑指offer.两个链表的第一个公共节点;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNode1 = headA;
        ListNode listNode2 = headB;
        ListNode listNode;
        while (listNode1 != null && listNode2 != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        int which = (listNode1 == null ? 2 : 1);
        if (listNode1 == null) {
            listNode = headB;
            while (listNode2 != null) {
                listNode2 = listNode2.next;
                listNode = listNode.next;
            }
            headB = listNode;
        } else {
            listNode = headA;
            while (listNode1 != null) {
                listNode1 = listNode1.next;
                listNode = listNode.next;
            }
            headA = listNode;
        }

        while (headA != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
