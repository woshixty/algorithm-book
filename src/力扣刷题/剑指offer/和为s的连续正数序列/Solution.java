package 力扣刷题.剑指offer.和为s的连续正数序列;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<Queue<Integer>> listList = new LinkedList<>();
        Queue<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = 1; i < target; ) {
            if (sum == target) {
                listList.add(new LinkedList<>(list));
                Integer poll = list.poll();
                sum -= poll;
            }
            else if (sum > target) {
                Integer poll = list.poll();
                sum -= poll;
            } else {
                list.offer(i);
                sum += i;
                i++;
            }
        }
        int[][] res = new int[listList.size()][];
        int size1 = listList.size();
        for (int i = 0; i < size1; i++) {
            res[i] = new int[listList.get(i).size()];
            int size = listList.get(i).size();
            for (int i1 = 0; i1 < size; i1++)
                res[i][i1] = listList.get(i).poll();
        }
        return res;
    }
}
