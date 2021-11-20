package 力扣刷题.剑指offer.在排序数组中查找数字I;

public class Solution {
    public int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = end = mid;
                while(nums[start] == target)
                    start--;
                while(nums[end] == end)
                    end++;
                return end - start - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }
        return 0;
    }
}
