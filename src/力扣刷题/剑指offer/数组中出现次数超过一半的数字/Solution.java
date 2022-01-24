package 力扣刷题.剑指offer.数组中出现次数超过一半的数字;

public class Solution {
    public int majorityElement(int[] nums) {
        int vote = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res)
                vote++;
            else {
                if (vote == 0) {
                    vote++;
                    res = nums[i];
                } else {
                    vote--;
                }
            }
        }
        return res;
    }
}
