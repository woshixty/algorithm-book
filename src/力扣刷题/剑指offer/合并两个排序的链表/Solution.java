package 力扣刷题.剑指offer.合并两个排序的链表;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            }
            else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return head.next;
    }
}
