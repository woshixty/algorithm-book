package 力扣刷题.剑指offer.调整数组顺序使奇数位于偶数前面;

public class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (nums[i] % 2 == 1) i++;
            while (nums[j] % 2 == 0) j--;
            if (i < j) {
                int num = nums[i];
                nums[i] = nums[j];
                nums[j] = num;
            }
        }
        return nums;
    }
}
