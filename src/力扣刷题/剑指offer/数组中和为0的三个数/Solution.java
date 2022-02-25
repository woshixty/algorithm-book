package 力扣刷题.剑指offer.数组中和为0的三个数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> single = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int total = 0 - (nums[i] + nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == total) {
                        single.add(nums[i]);
                        single.add(nums[j]);
                        single.add(nums[k]);
                        result.add(new ArrayList<>(single));
                        single.clear();
                    }
                }
            }
        }
        return result;
    }
}
