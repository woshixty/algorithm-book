package 力扣刷题.热题榜.合并K个升序链表;

import lombok.val;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }
        ListNode head = new ListNode();
        ListNode point = head;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            point.next = poll;
            if (poll.next != null)
                queue.offer(poll.next);
        }
        return head.next;
    }

    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val > list2.val) {
            list2.next = merge2Lists(list1, list2.next);
            return list2;
        } else {
            list1.next = merge2Lists(list1.next, list2);
            return list1;
        }
    }

    /**
    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode point = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                point.next = list2;
                list2 = list2.next;
            } else {
                point.next = list1;
                list1 = list1.next;
            }
            point = point.next;
        }
        while (list1 != null) {
            point.next = list1;
            list1 = list1.next;
            point = point.next;
        }
        while (list2 != null) {
            point.next = list2;
            list2 = list2.next;
            point = point.next;
        }
        return head.next;
    }
     */
}
