package 力扣刷题.剑指offer.数据流中的中位数;

import java.util.PriorityQueue;

public class Solution {
    class MedianFinder {
        PriorityQueue<Integer> big;
        PriorityQueue<Integer> small;

        /** initialize your data structure here. */
        public MedianFinder() {
            //小堆顶，保存大的
            big = new PriorityQueue<>();
            //大堆顶，保存小的
            small = new PriorityQueue<>((a, b) -> (b - a));
        }

        public void addNum(int num) {
            if (big.size() != small.size()) {
                big.offer(num);
                small.offer(big.poll());
            } else {
                small.offer(num);
                big.offer(small.poll());
            }
        }

        public double findMedian() {
            if (big.size() == small.size())
                return (big.peek() + small.peek()) / 2;
            else
                return big.peek();
        }
    }
}
