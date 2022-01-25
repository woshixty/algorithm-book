package 力扣刷题.剑指offer.滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.offerLast(nums[j]);
            res[j] = deque.peekFirst();
        }
        return res;
    }
}
