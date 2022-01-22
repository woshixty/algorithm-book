package 力扣刷题.剑指offer.数组中数字出现的次数;

public class Solution {
    /**
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums)
            n ^= num;
        int position = 1;
        while((position & n) == 0)
            position <<= 1;
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & position) == 0)
                a ^= num;
            else
                b ^= num;
        }
        int[] result = {a, b};
        return result;
    }
     */

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int num : nums)
            x ^= num;
        int m = 1;
        while ((x & m) ==0)
            m <<= 1;
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & m) == 0)
                a ^= num;
            else
                b ^= num;
        }
        int[] result = {a, b};
        return result;
    }
}
