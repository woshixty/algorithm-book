package 力扣刷题.剑指offer.连续子数组的最大和;

public class Solution {
    /**
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];
        int max = nums[0];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (sum[i - 1] <= 0)
                sum[i] = nums[i];
            else
                sum[i] += nums[i - 1];
            if (sum[i] > max)
                max = sum[i];
        }
        return max;
    }
     */

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int maxNumber = nums[0];
        for (int i = 1; i < length; i++) {
            if (max[i - 1] < 0) {
                if (nums[i] > maxNumber)
                    maxNumber = nums[i];
                max[i] = nums[i];
            }
            else
                max[i] = max[i - 1] + nums[i];
            if (max[i] > maxNumber)
                maxNumber = max[i];
        }
        return maxNumber;
    }
}
