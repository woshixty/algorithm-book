package 力扣刷题.两数之和;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int i = 0;
        for (int num : nums) {
            if (hashMap.containsKey(target - num)) {
                return new int[] {i, hashMap.get(target - num)};
            }
            hashMap.put(num, i++);
        }
        return new int[0];
    }
}
