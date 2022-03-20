package 力扣刷题.热题榜.最大子数组和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            result = nums[i] > result ? nums[i] : result;
        }
        return result;
    }
}
