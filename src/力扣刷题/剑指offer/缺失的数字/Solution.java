package 力扣刷题.剑指offer.缺失的数字;

public class Solution {
    /**
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return -1;
    }
     */

    public int missingNumber(int[] nums) {
        int first = 0, last = nums.length - 1;
        int mid;
        //二分法查找
        while (first <= last) {
            mid = (first + last) / 2;
            if (nums[mid] == mid && nums[mid + 1] == mid + 1)
                return mid +1;
            else if (nums[mid] == mid)
                first = mid + 1;
            else
                last--;
        }
        return -1;
    }
}
