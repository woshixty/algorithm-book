package 力扣刷题.剑指offer.删除链表的节点;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            return head.next = head.next.next;
        ListNode listNode1 = head;
        ListNode listNode2 = head.next;
        while (listNode2 != null) {
            if (listNode2.val == val) {
                listNode1.next = listNode2.next;
                break;
            }
            listNode1 = listNode2;
            listNode2 = listNode2.next;
        }
        return head;
    }
}
