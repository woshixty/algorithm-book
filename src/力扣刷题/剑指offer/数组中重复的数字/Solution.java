package 力扣刷题.剑指offer.数组中重复的数字;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        int[] numbers = new int[max + 1];
        for (int num : nums) {
            if (numbers[num] == 1)
                return num;
            else
                numbers[num] = 1;
        }
        return 0;
    }
}
