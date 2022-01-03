package 力扣刷题.剑指offer.从尾到头打印链表;

import java.util.Stack;

public class Solution {
    /**
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
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.empty())
            result[i++] = stack.pop();
        return result;
    }
}
