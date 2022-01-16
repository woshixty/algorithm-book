package 力扣刷题.剑指offer.和为s的两个数字;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int[] ints = new int[2];
        while (i < j) {
            int result = nums[i] + nums[j];
            if (result == target) {
                ints[0] = nums[i];
                ints[1] = nums[j];
                break;
            } else if (result < target)
                i++;
            else
                j--;
        }
        return ints;
    }
}
