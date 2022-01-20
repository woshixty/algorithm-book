package 力扣刷题.剑指offer.扑克牌中的顺子;

import java.util.HashSet;

public class Solution {
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (num != 0) {
                if (integers.contains(num))
                    return false;
                integers.add(num);
                if (num < min)
                    min = num;
                if (num > max)
                    max = num;
            }
        }
        return (max - min) < 5 ? true : false;
    }
}
