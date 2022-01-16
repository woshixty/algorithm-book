package 力扣刷题.剑指offer.链表中倒数第k个节点;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode listNode1 = head;
        ListNode listNode2 = head;
        for (int i = 1; i < k; i++)
            listNode2 = listNode2.next;
        while (listNode2 != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return listNode1;
    }
}
