package 力扣刷题.剑指offer.缺失的数字;

public class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return -1;
    }
}
