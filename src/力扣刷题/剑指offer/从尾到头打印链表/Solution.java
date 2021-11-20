package 力扣刷题.剑指offer.从尾到头打印链表;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> list;
    public int[] reversePrint(ListNode head) {
        list = new ArrayList<>();
        deepin(head);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ints[i] = list.get(i);
        return ints;
    }

    public void deepin(ListNode head) {
        if (head == null)
            return;
        deepin(head.next);
        list.add(head.val);
    }
}
