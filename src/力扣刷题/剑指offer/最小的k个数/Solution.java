package 力扣刷题.剑指offer.最小的k个数;

import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0)
            return res;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i : arr)
            priorityQueue.offer(i);
        for (int i = 0; i < k; i++)
            res[i] = priorityQueue.poll();
        return res;
    }
}
