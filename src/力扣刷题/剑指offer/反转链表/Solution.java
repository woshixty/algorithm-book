package 力扣刷题.剑指offer.反转链表;

public class Solution {
    /**
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode newHead = head.next.next = head;
            head.next = null;
            return newHead;
        }
        ListNode H1 = head, H2 = head.next, H3 = head.next.next;
        while (H3.next != null) {
            H2.next = H1;
            H1 = H2;
            H2 = H3;
            H3 = H3.next;
        }
        head.next = null;
        H2.next = H1;
        H3.next = H2;
        return H3;
    }
     */
    //据说还有递归法
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode cur = head;
        ListNode temp = head.next;
        ListNode pre = null;
        while (temp != null) {
            //循环变换链表的指针
            cur.next = pre;
            pre = cur;
            cur = temp;
            temp = temp.next;
        }
        cur.next = pre;
        return cur;
    }
}
