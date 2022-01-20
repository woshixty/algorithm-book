package 力扣刷题.剑指offer.把数组排成最小的数;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strings[i] = String.valueOf(nums[i]);
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
